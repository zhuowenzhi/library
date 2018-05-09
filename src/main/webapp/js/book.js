$('.imgtable tbody tr:odd').addClass('odd');
//发送数据到book表的,进行查询
// var date = new Date(data).toLocaleDateString();
//点击搜索查询
$('#search').click(function(){
    console.log('lalalal');
    $.ajax({
        url: "/test/book/get",
        data: {
            "id": $('#id').val()//编号
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
                var  publication=item.publication;
                var  press=item.press;
                var  price=item.price;
                var  quantity=item.quantity;
                var  status=item.status;
                html="<tr><td>"
                    +id+"</td><td>"
                    +name+"</td><td>"
                    +publication+"</td><td>"
                    +press+"</td><td>"
                    +price+"</td><td>"
                    +quantity+"</td><td>"
                    +status+"</td><td>" +
                    "<a href='bookedit.html?id=id' class='btn'>修改</a>" +
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
        url: "/test/book/delete?id="+id,
        data: {},
        type: "post",
        contentType: "application/x-www-form-urlencoded;charset=utf-8",
        dataType: "json",
        success: function (res) {
            alert("删除成功！！！");
            location.reload();
        }
    });
}

//加载整个页面
$.ajax({
    url:"/test/book/list",
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
    $.each(json,function (index,item) {
        //循坏数据
        //alert(index,item);
       // console.log(index,item)
        var  id=item.id;
        var  name=item.name;
        var  publication=item.publication;
        var  press=item.press;
        var  price=item.price;
        var  quantity=item.quantity;
        var  status=item.status;
       html="<tr><td>"
       +id+"</td><td>"
       +name+"</td><td>"
       +publication+"</td><td>"
       +press+"</td><td>"
       +price+"</td><td>"
       +quantity+"</td><td>"
           +status+"</td><td>" +
           "<input type='button' value='修改' class='btn' onclick='jump(this)'>" +
           "<input type='button' value='删除' class='btn delete' onclick='deleteBtn(this)'></td></tr>";
        $('#tbody').append(html);
    });
}
// function jump(obj) {
//     window.location.href = 'bookedit.html?id=id';
//     // window.open('bookedit.html?id=id');
// }
function jump(obj) {
    var id=obj.parentNode.parentNode.firstChild.innerText;
    //console.log(id);
    window.location.href='bookedit.html?id='+id;
}