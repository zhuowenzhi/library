$('#submit').click(function () {
    $.ajax({
        url: "/test/book/add",
        type: "post",
        contentType: "application/x-www-form-urlencoded;charset=utf-8",
        data: {
            "id":$("#id").val(),
            "name": $("#name").val(),
            "press": $("#press").val(),
            "publication": $("#publication").val(),
            "price": $("#price").val(),
            "quantity": $("#quantity").val(),
            "status": $("#status").val()
        },
        dataType: "json",
        success: function (res) {
            if (res.status) {
                alert("信息提示" + res.msg);
            } else {
                alert("信息提示" + res.msg);
            }
        }
    })
})
