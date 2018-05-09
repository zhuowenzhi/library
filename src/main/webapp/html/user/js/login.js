$('#login').click(function () {
    if ($('#phone').val() == "" || $('#password').val() == "") {
        alert("用户名或密码不能为空！");
    }
    else{
        $.ajax({
            url:'/test/user/login',
            data:{
                'phone':$('#phone').val(),
                'password':$('#password').val()
            },
            type:'post',
            datatype:'json',
            success:function (data) {
                if (data==true) {
                    alert("登录成功");
                    window.location.href='main.html';
                }
                else{
                    alert("用户名或者密码错误");
                }
            }
        })
    }
});