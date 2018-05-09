$(function () {
    //获取url中的参数
    var id =getQueryString('id');
    $("#bookId").val(id);
    //根据id从数据库中获取修改前的值
    // $.post(
    //     "/test/book/get?id="+id,
    //     function (data) {
    //         $("#id").val(data.id),
    //             $("#name").val(data.name),
    //             $("#press").val(data.press),
    //             $("#publication").val(data.publication),
    //             $("#price").val(data.price),
    //             $("#quantity").val(data.quantity),
    //             $("#status").val(data.status)
    //     },
    //     "json"
    // );
    //edit按钮绑定事件
    $("#add").click(function () {
        // $.ajax({
        //     url:"/test/userbook/add",
        //     type:"post",
        //     data:{
        //         "userId": $("#userId").val(),
        //         "bookId": $("#bookId").val(),
        //         // "date": $("#date").val(),
        //         "operate": $("#add").val()
        //     },
        //     dataType:"json",
        //     success: function(data){
        //         alert('借阅成功');
        //     }
        // })
        $.post(
            "/test/userbook/add",
            {
                "userId": $("#userId").val(),
                "bookId": $("#bookId").val(),
                // "date": $("#date").val(),
                "operate": $("#add").val()
            },
            "json",function(){

                //console.log(res);
                //console.log(res.status);
                // if(res.status){
                //     alert("信息提示"+res.msg);
                // }else{
                //     alert("信息提示"+res.msg);
                // }
                }
        )
        alert('借阅成功');
    })
})

function getQueryString(name) {
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    // console.log(reg );
    var r = window.location.search.substr(1).match(reg);
    if(r!=null){
        return  unescape(r[2]);
    }
    return null;
}

$('#submit').click(function () {
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
                alert("借阅成功" );
            } else {
                alert("借阅失败");
            }
        }
    })
})
