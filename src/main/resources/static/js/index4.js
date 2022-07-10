
let list4 = $("#list4");


$(function () {

    getPurchaseNameAge()

});



function getPurchaseNameAge() {
    $.get("/admin/users/purchase-name-age", function (data) {
        for (let i = 0; i < data.length; i++) {
            let user = data[i];

            let tr = $("<tr id='tr" + i + "'></tr>");
            let td = "";
            td += "<td>" + (i + 1) + "</td>";
            td += "<td id='td" + i + "username'>" + user.name + "</td>";
            td += "<td id='td" + i + "first_name'>" + user.count + "</td>";

            tr.html(td);
            list4.append(tr);
        }

    });
}