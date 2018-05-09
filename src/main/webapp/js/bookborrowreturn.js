//发送数据到user表的,进行查询
// var date = new Date(data).toLocaleDateString();
  $('#search').click=function(){
    $.ajax({
        url: "/test/book/list",
        data: {
            "id": $('#id').val(),//编号
        },
        type: "post",
        dataType: "json",
        success: function () {
            console.log("发送成功！！！");
        }
    });
}
    //  //发送数据到book表的,进行查询
    // $('#search').click=function(){
    //     $.ajax({
    //         url: "/test/book/list",
    //         data: {
    //             "bookId": $('#id').val(),//图书编号
    //         },
    //         type: "post",
    //         dataType: "json",
    //         success: function () {
    //             console.log("发送成功！！！");
    //         }
    //     });
    // }
$('.add').click(function () {
    $.ajax({
        url:"test/userbook",
        type:"post",
        dataType:"json",
        success:function () {
            alert("借阅成功");
        }
    })
});

$('.delete').click(function () {
    $.ajax({
        url:"test/userbook",
        type:"post",
        dataType:"json",
        success:function () {
            alert("归还成功");
        }
    })
 });

//发送数据到book表的,进行查询
$('#search').click(function(){
    console.log('lalalal');
    $.ajax({
        url: "/test/book/get",
        data: {
            "id": $('#id').val(),//编号
        },
        type: "post",
        dataType: "json",
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
            var  press=item.press
            var  price=item.price;
            var  quantity=item.quantity;
            var  status=item. status;
            html="<tr><td>"
                +id+"</td><td>"
                +name+"</td><td>"
                +publication+"</td><td>"
                +press+"</td><td>"
                +price+"</td><td>"
                +quantity+"</td><td>"
                +status+"</td><td>"
                +"<input type='button' value='借阅' class='btn add' onclick='addBtn(this)'><input type='button' value='归还' class='btn delete' onclick='deleteBtn(this)'></td></tr>";
            $('#tbody').html(html);
        }
    });
})

//查看所有
function showAll(){
    location.reload();
}

//归还
function deleteBtn(obj)
{
    var id=obj.parentNode.parentNode.firstChild.innerText;//得到按钮[obj]的父元素[td]的父元素[tr]
    // tr.parentNode.removeChild(tr);//从tr的父元素[tbody]移除tr
    $.ajax({
        url: "/test/book/delete?id="+id,
        data: {},
        type: "post",
        dataType: "json",
        success: function (res) {
            alert("归还成功！！！");
            location.reload();
        }
    });
}
//借阅
function addBtn(obj)
{
    var id=obj.parentNode.parentNode.firstChild.innerText;//得到按钮[obj]的父元素[td]的父元素[tr]
    // tr.parentNode.removeChild(tr);//从tr的父元素[tbody]移除tr
    $.ajax({
        url: "/test/book/delete?id="+id,
        data: {},
        type: "post",
        dataType: "json",
        success: function (res) {
            alert("借阅成功！！！");
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
        var  press=item.press
        var  price=item.price;
        var  quantity=item.quantity;
        var  status=item. status;
        html="<tr><td>"
            +id+"</td><td>"
            +name+"</td><td>"
            +publication+"</td><td>"
            +press+"</td><td>"
            +price+"</td><td>"
            +quantity+"</td><td>"
            +status+"</td><td>"
            +"<input type='button' value='借阅' class='btn add' onclick='addBtn(this)'><input type='button' value='归还' class='btn delete' onclick='deleteBtn(this)'></td></tr>";
        $('#tbody').append(html);
    });

}

