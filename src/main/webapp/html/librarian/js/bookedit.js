// var date = new Date(data).toLocaleDateString();
$('.imgtable tbody tr:odd').addClass('odd');
$(function () {
    //console.log(id);
    //获取url中的参数
    //var id =getQueryString("id");
    var id='1';
    console.log(id);
    //根据id从数据库中获取修改前的值
    $.post(
        "/test/book/get?id="+id,

        function (data) {
            $("#id").val(data.id),
            $("#name").val(data.name),
                $("#press").val(data.press),
                $("#publication").val(data.publication),
                $("#price").val(data.price),
                $("#quantity").val(data.quantity),
                $("#status").val(data.status)
        },
        "json"
    );
    //edit按钮绑定事件
    $("#edit").click(function () {

        $.post(
            "/test/book/update?id="+id,
            {
                "id":id,
                "name": $("#name").val(),
                "press": $("#press").val(),
                "publication": $("#publication").val(),
                "price": $("#price").val(),
                "quantity": $("#quantity").val(),
                "status": $("#status").val()
            },
            "json",function(res){
                console.log(res);
                if(res.status){
                    alert("信息提示修改成功");
                }else{
                    alert("信息提示修改失败");
                }}
        )
    })
})

function getQueryString(name) {
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    console.log(reg );
    var r = window.location.search.substr(1).match(reg);
    if(r!=null){
        return  unescape(r[2]);
    }
    return null;
}

//返回的按钮
$('#back').click(function () {
    window.location.href('book.html');
});