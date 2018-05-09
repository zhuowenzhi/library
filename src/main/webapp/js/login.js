function loadXMLDoc() {
    var xmlhttp;
    if (window.XMLHttpRequest){
        //code for IE7,Firefox,Chorme,Opera,Safari
        xmlhttp = new XMLHttpRequest();
    }else{
        //code for IE5,IE6
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function () {
        if(xmlhttp.readyState==4 && xmlhttp.status==200){
           console.log("请求成功"+xhr.status);
        }
        xmlhttp.open("GET","/test/user/login?phone=" + phone + "&password=" + password ,true);
        xhr.send();
    }
}
$(function () {
    $('#login').click(function () {
        console.log('登录');
        $.ajax({
            url:'/test/user/login',
            data:{
                'phone':$('#phone').val(),
                'password':$('#password').val()
            },
            type:'post',
            datatype:'json',
            success:function (res) {
                if (res.msg) {
                    alert("登录成功");
                    function jump() {
                        window.location.href='main.html';
                    }
                }
                if (!res){
                    alert("登录成功");
                }

            }
        })
        loadXMLDoc();
    });
    $('#register').click(function () {
        console.log('注册');
        $.ajax({
            url:'/test/user/register',
            data:{
                'name':$('#rname').val(),
                'phone':$('#rphone').val(),
                'password':$('#rpassword').val()
            },
            type:'post',
            datatype:'json',
            success: function(data,textStatus){
                console.log("注册成功");
                alert("注册成功");
            }
        })
    });
})
function jump() {
    window.location.href = 'main.html';
}
