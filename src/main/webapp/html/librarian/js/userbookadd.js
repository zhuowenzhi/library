
$('#add').click(function () {
    $.ajax({
        url: "/test/userbook/add",
        type: "post",
        contentType: "application/x-www-form-urlencoded;charset=utf-8",
        data: {
            "userId": $("#userId").val(),
            "bookId": $("#bookId").val(),
            // "date": $("#date").val(),
            "operate": $("#add").val()
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
