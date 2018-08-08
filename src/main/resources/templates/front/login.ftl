<!doctype html>
<html lang="zh">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>登录</title>
<link rel="stylesheet" type="text/css" href="/templates/static/css/login.css">
</head>
<body>
<div class="htmleaf-container">
	<div class="wrapper">
		<div class="container">
			<h1>Welcome</h1>
			<form class="form">
				<input id="name" type="text" placeholder="Username">
				<input id="pass" type="password" placeholder="Password">
				<button type="button" onclick="login()">Login</button>
			</form>
		</div>
		<ul class="bg-bubbles">
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
		</ul>
	</div>
</div>
<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';color:#000000">
    <h1>数据管理系统</h1>
</div>
</body>

<script src="/templates/static/js/jquery-2.1.1.min.js" type="text/javascript"></script>
<script>
    /*
        TODO:使用js框架做mvc替代原生js控制
     */
    function login() {
        var name = $("#name").val();
        var pass = $("#pass").val();
        if ("" === name || "" === pass) {
            alert("用户名或密码不能为空");
            return;
        }
        $.ajax({
            url:"/user/login",
            data:{
                "name":name,
                "password":pass
            },
            dataType:"json",
            success:function (result) {
                alert(result.msg);
                if (0 === result.code) {
                    window.location.href = "/index";
                }
            }
        })
    }
</script>
</html>