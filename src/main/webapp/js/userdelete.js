$('.imgtable tbody tr:odd').addClass('odd');
//发送数据到user表的,查询
  $('#search').click=function(){
    $.ajax({
        url: "test/user/list",
        data: {
            "id": $('#id').val(),//编号
            "name":$('#name').val(),//名称
        },
        type: "post",
        dataType: "json",
        success: function () {
            console.log("发送成功！！！");
        }
    });
  }

//加载整个页面
$.ajax({
    url:"test/user/list",
    type:"post",
    dataType:"json",
    success: succFunction(data)
})
succFunction(data);
function succFunction(data1) {
    var json = data1;

    var html = '';
    $.each(json,function (index,item) {
        //循坏数据
        alert(item);
        var  id=item.id;
        var  name=item.name;
        var  sex=item.sex
        var  entry=item.entry
        var  phone=item.phone;
       html="<tr><td>"
            +id+"</td><td>"
            +name+"</td><td>"
            +sex+"</td><td>"
            +entry+"</td><td>"
            +phone+"</td><td></td><td><input type='button' value='删除' class='btn delete' onclick='deleteBtn(this)'></td></tr>";
    });
    $('#tbody').html(html);
}
$('.delete').click(function () {
    $('#tbody').innerHTML='';
});

//点击按钮删除
function deleteBtn(obj)
{
    var tr=obj.parentNode.parentNode;//得到按钮[obj]的父元素[td]的父元素[tr]
    tr.parentNode.removeChild(tr);//从tr的父元素[tbody]移除tr
}