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
    $("#delete").click(function () {
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
        $.get(
            "/test/userbook/add",
            {
                "userId": $("#userId").val(),
                "bookId": $("#bookId").val(),
                // "date": $("#date").val(),
                "operate": $("#delete").val()
            },
            function(res){
                //console.log(res);
                //console.log(res.status);
                if(res.status=="归还成功"){
                    alert("归还成功");
                }else{
                    alert("归还成功");
                }
                }
        )
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
