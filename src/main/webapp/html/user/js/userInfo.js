//加载整个页面
// var date = new Date(data).toLocaleDateString();
$.ajax({
    url:"/test/userbook/list",
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
        var  userId=item.userId;
        var  bookId=item.bookId;
        var  date=item.date;
        // var  operate=item.operate;
        html="<tr><td>"
            +userId+"</td><td>"
            +bookId+"</td><td>"
            +date+"</td></tr>"
            // +operate+"</td></tr>"
        $('#tbody').append(html);
    });

}