<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>尚硅谷会员注册页面</title>
		<base href="http://localhost:8080/book/">
		<link type="text/css" rel="stylesheet" href="static/css/style.css" >
		<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
		<script type="text/javascript">
			// 页面加载完成之后
			$(function (){
				$("#sub_btn").click(function (){
					// 获取用户名
					let username = $("#username").val();
					// 编写正则匹配规则
					let userRegex = /^\w{5,12}$/;
					// 测试匹配规则
					if(!userRegex.test(username)){
						$("span.errorMsg").text("用户名不合法");
						return false;
					}

					// 获取密码
					let password = $("#password").val();
					// 编写正则匹配规则
					let pwdRegex = /^\w{5,12}$/;
					// 测试匹配规则
					if(!pwdRegex.test(password)){
						$("span.errorMsg").text("密码必须大于5位小于12位");
						return false;
					}

					// 获取密码
					let oldPwd = $("#password").val();
					let newPwd = $("#repwd").val();
					// 测试匹配规则
					if(oldPwd!=newPwd){
						$("span.errorMsg").text("确认密码不一致");
						return false;
					}

					$("span.errorMsg").text("");

				});
			});


		</script>
	<style type="text/css">
		.login_form{
			height:420px;
			margin-top: 25px;
		}

	</style>
	</head>
	<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>

			<div class="login_banner">

				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>

				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg"></span>
							</div>
							<div class="form">
								<form action="register" method="POST">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名"
										   autocomplete="off" tabindex="1" name="username" id="username" />
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码"
										   autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码"
										   autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址"
										   autocomplete="off" tabindex="1" name="email" id="email" />
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 150px;" id="code" name="code"/>
									<img alt="" src="static/img/code.bmp" style="float: right; margin-right: 40px">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
								</form>
							</div>

						</div>
					</div>
				</div>
			</div>
		<div id="bottom">
			<span>
				尚硅谷书城.Copyright &copy;2015
			</span>
		</div>
	</body>
</html>