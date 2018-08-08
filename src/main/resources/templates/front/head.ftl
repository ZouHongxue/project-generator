<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="/templates/static/css/head.css" rel="stylesheet">
    <style>
        * {
            margin: 0px;
            padding: 0px;
        }

        ul {
            list-style: none;
        }

        .ul-left li {
            float: left;
            margin-right: 60px;
        }
    </style>
</head>

<body>
<div class="head">
    <div class="left">
        <ul class="ul-left">
            <li>品牌</li>
            <li>车型</li>
            <li>工具&服务</li>
            <li>车型配置器</li>
        </ul>
    </div>
    <div class="right">Hi,
            <#if login ?exists && login = "true">
                Welcome, <b class="user">${user.name}</b> <b class="logout" onclick="logout()">退出</b>
            <#else>
                <a href="/user/toLogin">请登录</a>
            </#if>
    </div>
</div>
</body>
<script src="/templates/static/js/jquery-2.1.1.min.js" type="text/javascript"></script>
<script>
    /*
        TODO:使用js框架做mvc替代原生js控制
     */
    function logout() {
        $.ajax({
            url: "/user/logout",
            dataType: "json",
            success: function (result) {
                alert(result.msg);
                if (0 === result.code) {
                    window.location.href = "/index";
                }
            }
        })
    }
</script>
</html>