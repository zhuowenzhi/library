(function () {
    var id =getQueryString("id");
    console.log(id+"=++++++++++++++++++++++++++++++++++++++")
    $.get(
        "/test/book/get",
        {id: id},
        function (data) {
            $("#bookId").val(data.id)
                // $("#name").val(data.name),
                // $("#sex").val(data.sex),
                // $("#entry").val(data.entry),
                // $("#roleId").val(data.roleId),
                // $("#phone").val(data.phone)
        }

    )
})()
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
                alert("借阅成功");
            } else {
                alert("借阅失败");
            }
        }
    })
})
function getQueryString(name) {
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r!=null){
        return  unescape(r[2]);
    }
    return null;
}

