
//发送数据到book表的,进行查询
// var date = new Date(data).toLocaleDateString();
//点击搜索查询
$('#search').click(function(){
    // console.log('lalalal');
    $.ajax({
        url: "/test/book/get",
        data: {
            "id": $('#id').val()//编号
        },
        type: "post",
        dataType: "json",
        success: function (data) {
            console.log(data);
            if(data==null){
                $('#tbody').html('');
            }
            //日期处理函数
            var date = new Date(parseInt(json.date));
            function getDateTime() {
                var year = date.getFullYear();
                // var month = date.getMonth();
                // var day = date.getDate();
                // var hh = date.getHours();
                // var mm = date.getMinutes();
                // var ss = date.getSeconds();
                // return year+"-"+month+"-"+day+"-"+hh+"-"+mm+"-"+ss;
            };
            json.press=getDateTime;

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
                "<input type='button' value='借阅' class='btn' onclick='jump()'>" +
                "<input type='button' value='归还' class='btn delete' onclick='deleteBtn(this)'></td></tr>";
            //});
            $('#tbody').html(html);
        }
    });
})

//查看所有
function showAll(){
    location.reload();
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
            "<input type='button' value='借阅' class='btn' onclick='jump(this)'>" +
            "<input type='button' value='归还' class='btn delete' onclick='jumpTo(this)'></td></tr>";
        $('#tbody').append(html);
    });
}
function jump(obj) {
    var id=obj.parentNode.parentNode.firstChild.innerText;
    //console.log(id);
    window.location.href='userbookadd.html?id='+id;
}
function jumpTo(obj) {
    var id=obj.parentNode.parentNode.firstChild.innerText;
    //console.log(id);
    window.location.href='userbookdelete.html?id='+id;
}