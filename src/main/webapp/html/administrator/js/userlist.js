$('.imgtable tbody tr:odd').addClass('odd');
// var date = new Date(data).toLocaleDateString();
//发送数据到user表的,进行查询
$('#search').click(function(){
    console.log('lalalal');
    $.ajax({
        url: "/test/user/get",
        data: {
            "id": $('#id').val(),//编号
        },
        type: "post",
        dataType: "json",
        contentType: "application/x-www-form-urlencoded;charset=utf-8",
        success: function (data) {
            console.log(data);
            if(data==null){
                $('#tbody').html('');
            }
            var item=data;
            var html='';
            //$.each(json,function (index,item) {
            //循坏数据
            //alert(index,item);
            // console.log(index,item)
            var  id=item.id;
            var  name=item.name;
            var  sex=item.sex;
            var  entry=item.entry;
            var  roleId=item.roleId;
            var  phone=item.phone;
            html="<tr><td>"
                +id+"</td><td>"
                +name+"</td><td>"
                +sex+"</td><td>"
                +entry+"</td><td>"
                +roleId+"</td><td>"
                +phone+"</td><td>"+
                "<a href='useredit.html?id=id' class='btn'>修改</a>" +
                "<input type='button' value='删除' class='btn delete' onclick='deleteBtn(this)'></td></tr>";
            //});
            $('#tbody').html(html);
        }
    });
})
function showAll(){
    location.reload();
}
function deleteBtn(obj)
{
    var id=obj.parentNode.parentNode.firstChild.innerText;//得到按钮[obj]的父元素[td]的父元素[tr]
    // tr.parentNode.removeChild(tr);//从tr的父元素[tbody]移除tr
    $.ajax({
        url: "/test/user/delete?id="+id,
        data: {},
        type: "post",
        dataType: "json",
        contentType: "application/x-www-form-urlencoded;charset=utf-8",
        success: function (res) {
            if(res.msg){
                alert("删除成功！！！");
            }
            else{
                alert("删除失败！！！");
            }
            location.reload();
        }
    });
}

//加载整个页面
$.ajax({
    url:"/test/user/list",
    type:"post",
    data:{},
    dataType:"json",
    contentType: "application/x-www-form-urlencoded;charset=utf-8",
    success: function(data,textStatus){
        succFunction(data.list);
    }
})

function succFunction(data1) {
    var json = data1;
    var html = '';

    //日期处理函数
    var date = new Date(parseInt(json.date));
    function getDateTime() {
        var year = date.getFullYear();
        var month = date.getMonth();
        var day = date.getDate();
        var hh = date.getHours();
        var mm = date.getMinutes();
        var ss = date.getSeconds();
        return year+"-"+month+"-"+day+"-"+hh+"-"+mm+"-"+ss;
    };
    json.entry=getDateTime;

    $.each(json,function (index,item) {
        //循坏数据
        //alert(index,item);
        // console.log(index,item)
        var  id=item.id;
        var  name=item.name;
        var  sex=item.sex;
        var  entry=item.entry;
        var roleId=item.roleId;
        var  phone=item.phone;
        html="<tr><td>"
            +id+"</td><td>"
            +name+"</td><td>"
            +sex+"</td><td>"
            +entry+"</td><td>"
            +roleId+"</td><td>"
            +phone+"</td><td>"+
            "<input type='button' value='修改' class='btn' onclick='jump(this)'>" +
            "<input type='button' value='删除' class='btn delete' onclick='deleteBtn(this)'></td></tr>";
        $('#tbody').append(html);
    });
}
function jump(obj) {
    //window.open('useredit.html?id=id');
    var id=obj.parentNode.parentNode.firstChild.innerText;
    console.log(id);
    window.location.href='useredit.html?id='+id;
}