let list1 = $("#list1");



$(function () {
    getByLastWeek();


});


function getByLastWeek() {
    $.get("/admin/users/lastweek", function (data) {
        for (let i = 0; i < data.length; i++) {
            let user = data[i];
            let purchase = user.purchaseItem;

            let tr = $("<tr id='tr" + user.id + "'></tr>");
            let td = "";
            td += "<td>" + user.id + "</td>";
            td += "<td id='td" + user.id + "username'>" + user.name + "</td>";
            td += "<td id='td" + user.id + "password'>" + user.lastname + "</td>";
            td += "<td id='td" + user.id + "first_name'>" + user.age + "</td>";
            td += "<td id='td" + user.id + "last_name'>" + purchase.name + "</td>";
            td += "<td id='td" + user.id + "email'>" + user.count + "</td>";
            td += "<td id='td" + user.id + "amount'>" + user.amount + "</td>";
            td += "<td id='td" + user.id + "date'>" + user.purchaseDate + "</td>";

            tr.html(td);
            list1.append(tr);
        }
    });

}
