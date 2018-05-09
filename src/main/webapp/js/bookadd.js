$('.imgtable tbody tr:odd').addClass('odd');
// var date = new Date(data).toLocaleDateString();
(function(){
    /**
     * url对象
     */
    const oURL = {
        PRONAME : '/test',
        POST:'/book/add',//最终提交路径
    }

    /**
     * 提交表单
     */
    $('#submit')[0].onclick = function(){

        var json = queryParse.call($('form'));
        //var json = new FormData($('form')[0]);

        $.post(oURL.PRONAME+oURL.POST,json,function(res){

            if(res.status){
                alert("信息提示添加书籍成功");
            }else{
                alert("信息提示添加书籍失败");
            }
        })
        $.setRequestHeader()
    }

    function queryParse() {

        var initData = this.serialize();
        //console.log(initData);//id=1221&name=willon&press=%E4%BB%B2%E6%81%BA&publication=1996&price=20&quantity=100
        initData = decodeURIComponent(initData)//id=123&name=00&press=仲恺&publication=0&price=0&quantity=100
        //console.log(initData);
        var dataArr =initData.split('&');
        var json = {};
        dataArr.forEach(function (item,index,arr) {
            var key = item.split('=')[0],
                val = item.split('=')[1];

                if(json.hasOwnProperty(key)){

                    json[key] = [json[key]];  //json[key] = [val]

                    json[key].push(val);

                }else{
                    json[key] = val;
                }


        })

        return json;
    }
})();