<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
    	<meta charset="utf-8">
		<title>新增数据源</title>
		<%@include file="/WEB-INF/jsp/decorators/addHeader.jsp" %>
	</head>
	<body>
 		<form id="saleForm" class="layui-form" style="margin-top:30px;">
 			<input  type="hidden" id="code" name="code" value="${dbp.code}"/>
			<div class='layui-form-item'>
				<div class="layui-inline">
					<label class="layui-form-label">源地址</label>
					<div class="layui-input-inline">
						<input type="text" id="ip" name="ip" placeholder="请输入源地址"  value="${dbp.ip }" class="layui-input"/>
						<span style="color: red" id="s-ip"></span>
					</div>
				</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">源端口</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="port" name="port" placeholder="请输入源端口"  value="${dbp.port }" class="layui-input"/>
		        		<span style="color: red" id="s-port"></span>
		     		</div>
     			</div>
			</div>
            <div class='layui-form-item'>
                <div class="layui-inline">
                    <label class="layui-form-label">源名称</label>
                    <div class="layui-input-inline">
                        <input type="text" id="name" name="name" placeholder="请输入源名称"  value="${dbp.name }" class="layui-input"/>
                        <span style="color: red" id="s-name"></span>
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">用户名</label>
                    <div class="layui-input-inline">
                        <input type="text" id="user" name="user" placeholder="请输入用户名"  value="${dbp.user }" class="layui-input"/>
                        <span style="color: red" id="s-user"></span>
                    </div>
                </div>
            </div>
            <div class='layui-form-item'>
                <div class="layui-inline">
                    <label class="layui-form-label">密码</label>
                    <div class="layui-input-inline">
                        <input type="text" id="password" name="pwd" placeholder="请输入密码"  value="${dbp.password }" class="layui-input"/>
                        <span style="color: red" id="s-password"></span>
                    </div>
                </div>
            </div>
            <div class="layui-input-block" style="margin-top:30px;margin-left:324px;">
                <input type="button" class="layui-btn" onclick="saveData()" value="确定"/>
                <button class="layui-btn" name="cancleSubmit" >取消</button>
            </div>
  		</form>
	</body>

	<script type="text/javascript">
		var reqUpdateAndAddUrl = "/admin/setDB";
	</script>

	<script type="text/javascript">
		//提交表单数据
		layui.use(['form', 'jquery', 'layedit', 'laydate'], function(){
			  var $ = layui.jquery;
			  var form = layui.form();
			  var layer = layui.layer;
			  var layedit = layui.layedit;
			  var laydate = layui.laydate;
			  form.verify({
			  });		  

		});
	
	function saveData() {
	    var code = $("#code").val();
	    var ip = $("#ip").val();
	    var port = $("#port").val();
	    var name = $("#name").val();
	    var user = $("#user").val();
	    var password = $("#password").val();
	    var use = false;

        var requestData={
            "code":code,
            "ip":ip,
            "port":port,
            "name":name,
            "user":user,
            "password":password,
            "use":use
        };
        updateAndAdd(requestData);
    }
	
</script>
</html>				 
