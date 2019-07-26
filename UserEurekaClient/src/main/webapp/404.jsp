<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="./404_files/base.css">
<link rel="stylesheet" href="./404_files/style.css">
<title>404</title>
</head>
<body>
<div class="note-content">
<div class="content-main w clearfix">
<div class="font-size fr">
<h2>身份过期，请先登录</h2>
<a id="href" href="http://localhost:8762/service-user/userCenter/login.jsp">如果没有自动跳转请点击这里...</a>
<p>等待时间：<b id="wait">2</b></p>
</div>
</div>
</div>

<ul class="regi-footer">
<li>
<a href="javascript:;">关于我们</a>
<a href="javascript:;">联系我们</a>
<a href="javascript:;">加盟我们</a>
<a href="javascript:;">商城APP</a>
<a href="javascript:;" class="active">友情链接</a>
</li>
<li>
<span>wx4556464654</span>
<span class="active">有任何问题请联系我们在线客服 电话：400-800-900</span>
</li>
<li>© 20016-2018 亿速网络用品 版权所有，并保留所有权利</li>
</ul>
<script src="./404_files/jquery.min.js"></script>
<script type="text/javascript">
    (function(){
        var wait = document.getElementById('wait'),href = document.getElementById('href').href;
        var interval = setInterval(function(){
            var time = --wait.innerHTML;
            if(time <= 0) {
                location.href = href;
                clearInterval(interval);
            };
        }, 1000);
    })();
</script>

</body></html>