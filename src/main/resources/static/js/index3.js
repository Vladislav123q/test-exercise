
let list3 = $("#list3");



$(function () {

    getPurchaseNalfYear()


});




function getPurchaseNalfYear() {
    $.get("/admin/users/purchase-nalf-year", function (data) {
        for (let i = 0; i < data.length; i++) {
            let user = data[i];

            let tr = $("<tr id='tr" + i + "'></tr>");
            let td = "";
            td += "<td>" + (i + 1) + "</td>";
            td += "<td id='td" + i + "username'>" + user.name + "</td>";
            td += "<td id='td" + i + "password'>" + user.lastname + "</td>";
            td += "<td id='td" + i + "first_name'>" + user.count + "</td>";

            tr.html(td);
            list3.append(tr);
        }

    });
}

