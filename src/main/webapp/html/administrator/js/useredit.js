$('.imgtable tbody tr:odd').addClass('odd');
// var date = new Date(data).toLocaleDateString();
$(function () {
    //console.log(id);
    //获取url中的参数
    var id =getQueryString("id");
    // var id='1';
    console.log(id);
    //根据id从数据库中获取修改前的值
    $.post(
        "/test/user/get?id="+id,
        function (data) {
            $("#id").val(data.id),
                $("#name").val(data.name),
                $("#sex").val(data.sex),
                $("#entry").val(data.entry),
                $("#roleId").val(data.roleId),
                $("#phone").val(data.phone)
        },
        "json"

    )
    //edit按钮绑定事件
    $("#edit").click(function () {
        console.log(id);
        $.post(
            "/test/user/update?id="+id,
            {
                "id":id,
                "name": $("#name").val(),
                "sex": $("#sex").val(),
                "entry": $("#entry").val(),
                "roleId": $("#roleId").val(),
                "phone": $("#phone").val()
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
    var r = window.location.search.substr(1).match(reg);
    if(r!=null){
        return  unescape(r[2]);
    }
    return null;
}

