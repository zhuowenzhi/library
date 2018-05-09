$('#submit').click(function () {
    $.ajax({
        url: "/test/user/add",
        type: "post",
        contentType: "application/x-www-form-urlencoded;charset=utf-8",
        data: {
            "id":$("#id").val(),
            "name": $("#name").val(),
            "sex": $("#sex").val(),
            "entry": $("#entry").val(),
            "roleId": $("#roleId").val(),
            "phone": $("#phone").val(),
        },
        dataType: "json",
        success: function (res) {
            if (res.status) {
                alert("添加成功");
            } else {
                alert("添加失败");
            }
        }
    })
})
