let userList = $("#user-list");
let deleteButton = $("#deleteButton");
let userEditForm = $("#userEditForm");
let editId = $("#editId");
let editname = $("#editname");
let editlastname = $("#editlastname");
let editpurchaseItem = $("#editpurchaseItem");
let editcount = $("#editcount");
let editamount = $("#editamount");
let editRole = $("#edit-roles");
let editCloseButton = $("#editCloseButton");
let newCloseButton = $("#newCloseButton");
let newUser;
let newFUser;
let newFormUser = $("#new-form-user");
let newUserUsername = $("#newUserUsername");
let newUserPassword = $("#newUserPassword");
let newUserFirstName;
let newUserLasName;
let newUserEmail;
let newUserRole = $("#new-user-role");
let newRoleView;
let AddNewUserInput;
let newUserFormResetButton = $("#newUserFormResetButton");


$(function () {
    getAllUsers();

});


function getAllUsers() {
    $.get("/admin/users", function (data) {
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


            td += "<td><div class='btn-group'>" +
                "<button data-target='#editUser' data-toggle='modal' class='btn btn-primary'" +
                "onclick='openEditUserModal(" + user.id + ")' data-userId='" + user.id + "'>Edit</button></div>" +
                "<div class='btn-group'><button class='btn btn-danger' data-userId='" + user.id + "' onclick='removeUser(" + user.id + ")'>Delete</button></div></td>";
            tr.html(td);
            userList.append(tr);


        }
    });
}

let editAge = $("#editAge");
let date = $("#editdate");

function openEditUserModal(id) {

    $.get("/admin/users/" + id, function (user) {
        let id = user.id;
        let username = user.name;
        let password = user.lastname;
        let age = user.age;
        let first_name = user.purchaseItem.name;
        let last_name = user.count;
        let email = user.amount;
        date.val(user.purchaseDate);
        editname.val(username);
        editlastname.val(password);
        editpurchaseItem.val(first_name);
        editcount.val(last_name);
        editamount.val(email);
        editAge.val(age)
        editId.val(id);


    });

}


userEditForm.submit(function (event) {
    event.preventDefault();
    $.ajax({
        url: userEditForm.attr("action"),
        method: "PUT",
        data: userEditForm.serialize(),
        success: function (data) {
            let id = data.id;
            let currentTr = $("tr#tr" + id);
            currentTr.empty();
            let newTr = "";
            newTr += "<td>" + id + "</td>";
            newTr += "<td id='td" + id + "username'>" + data.name + "</td>";
            newTr += "<td id='td" + id + "password'>" + data.lastname + "</td>";
            newTr += "<td id='td" + id + "passwordee'>" + data.age + "</td>";
            newTr += "<td id='td" + id + "firstName'>" + data.purchaseItem.name + "</td>";
            newTr += "<td id='td" + id + "lastName'>" + data.count + "</td>";
            newTr += "<td id='td" + id + "email'>" + data.amount + "</td>";
            newTr += "<td id='td" + id + "date'>" + data.purchaseDate + "</td>";

            newTr += "<td><div class='btn-group'>" +
                "<button data-target='#editUser' data-toggle='modal' class='btn btn-primary'" +
                "onclick='openEditUserModal(" + id + ")' data-userId='" + id + "'>Edit</button></div>" +
                "<div class='btn-group'><button class='btn btn-danger' data-userId='" + id + "' onclick='removeUser(" + id + ")'>Delete</button></div></td>";
            currentTr.html(newTr);
        }

    });

    location.reload();
});

function removeUser(id) {
    $("tr#tr" + id).remove();
    $.ajax({
        url: "/admin/users/delete",
        method: "POST",
        data: ({
            id: id
        })
    });

}


function loadAllRoles() {
    $.get("/admin/users/purchases", function (data) {

        for (let i = 0; i < data.length; i++) {
            let purchase = data[i].name;
            let id = data[i].id
            let option = "<option id='option" + id + "' value='" + purchase + "'>" + purchase + "</option>";
            newUserRole.append(option);
        }

    });
}

newFormUser.on("submit", function (event) {
    event.preventDefault();
    let user_ = newFormUser.serialize();
    $.ajax({
        url: newFormUser.attr("action"),
        method: "POST",
        data: user_,
        success: function (user) {
            let newTr = $("<tr id='tr" + user.id + "'></tr>");
            let newTrTd = "";
            newTrTd += "<td>" + user.id + "</td>";
            newTrTd += "<td id='td" + user.id + "username'>" + user.name + "</td>";
            newTrTd += "<td id='td" + user.id + "password'>" + user.lastname + "</td>";
            newTrTd += "<td id='td" + user.id + "first_name'>" + user.age + "</td>";
            newTrTd += "<td id='td" + user.id + "last_name'>" + user.purchaseItem.name + "</td>";
            newTrTd += "<td id='td" + user.id + "email'>" + user.count + "</td>";
            newTrTd += "<td id='td" + user.id + "roles'>" + user.amount + "</td>";
            newTrTd += "<td id='td" + user.id + "date'>" + user.purchaseDate + "</td>";

            newTrTd += "<td><div class='btn-group'>" +
                "<button data-target='#editUser' data-toggle='modal' class='btn btn-primary'" +
                "onclick='openEditUserModal(" + id + ")' data-userId='" + id + "'>Edit</button></div>" +
                "<div class='btn-group'><button class='btn btn-danger' data-userId='" + id + "' onclick='removeUser(" + id + ")'>Delete</button></div></td>";

            newTr.html(newTrTd);
            userList.append(newTr);
            newCloseButton.trigger("click");

            location.href = '/admin/userlist_page';
            location.reload();

        },
        error: function (data) {
            let msg = "Ошибка при валидации -> ";
            alert(msg + data.responseText);
        }
    });
    // $.post(newFormUser.attr("action"), user_, function (user) {
    //
    //     let newTr = $("<tr id='tr" + user.id + "'></tr>");
    //     let newTrTd = "";
    //     newTrTd += "<td>" + user.id + "</td>";
    //     newTrTd += "<td id='td" + user.id + "username'>" + user.name + "</td>";
    //     newTrTd += "<td id='td" + user.id + "password'>" + user.lastname + "</td>";
    //     newTrTd += "<td id='td" + user.id + "first_name'>" + user.age + "</td>";
    //     newTrTd += "<td id='td" + user.id + "last_name'>" + user.purchaseItem.name + "</td>";
    //     newTrTd += "<td id='td" + user.id + "email'>" + user.count + "</td>";
    //     newTrTd += "<td id='td" + user.id + "roles'>" + user.amount + "</td>";
    //     newTrTd += "<td id='td" + user.id + "date'>" + user.purchaseDate + "</td>";
    //
    //     newTrTd += "<td><div class='btn-group'>" +
    //         "<button data-target='#editUser' data-toggle='modal' class='btn btn-primary'" +
    //         "onclick='openEditUserModal(" + id + ")' data-userId='" + id + "'>Edit</button></div>" +
    //         "<div class='btn-group'><button class='btn btn-danger' data-userId='" + id + "' onclick='removeUser(" + id + ")'>Delete</button></div></td>";
    //
    //     newTr.html(newTrTd);
    //     userList.append(newTr);
    //     newCloseButton.trigger("click");
    //     $("#id").trigger("click");
    // });

});



