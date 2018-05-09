$('#register').click(function () {
    if ($('#rphone').val() == "" || $('#rpassword').val() == "") {
        alert("用户名或密码不能为空！");
    }
    else{
        $.ajax({
            url:'/test/user/register',
            data:{
                'phone':$('#rphone').val(),
                'password':$('#rpassword').val()
            },
            type:'post',
            datatype:'json',
            success:function (res) {
                if (res.status == "用户注册成功") {
                    alert("注册成功");
                    // window.location.href='main.html';
                    // window.location.href='mainA.html';
                    // window.location.href='mainL.html';
                }
                else{
                    alert("注册失败");
                }
            }
        })
    }
});

//验证手机号码
// function checkMobile(str) {
//
//     var re= /^1\d{10}$/;//验证是不是11位数字
//     if(res.test(str)){
//         $("#test").html("手机号码格式正确");
//         $("#test").css("color","green");
//     }else{
//         $("#test").html("手机号码格式正确");
//         $("#test").html("color","red");
//     }
// }
