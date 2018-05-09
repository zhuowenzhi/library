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
            success:function (res) {
                switch (res.roleId){
                    case "1": window.location.href = "mainA.html"; break;
                    case "2":window.location.href ="main.html"; break;
                    case "3":window.location.href ="mainL.html"; break;
                }
            }
        })
    }
});