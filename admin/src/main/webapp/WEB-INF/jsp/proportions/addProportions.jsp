<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
    	<meta charset="utf-8">
		<title>新增配合比</title>
		<%@include file="/WEB-INF/jsp/decorators/addHeader.jsp" %>
	</head>
	<body>
 		<form id="saleForm" class="layui-form" style="margin-top:30px;">
 			<input  type="hidden" id="proportionsId" name="proportionsId" value="${proportions.proportionsId}"/>
 			<input  type="hidden" id="projectId" name="projectId" value="${projectId}"/>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">排序号</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="seq" name="seq" placeholder="请输入排序号"  value="${proportions.seq }" class="layui-input"/>
		        		<span style="color: red" id="s-seq"></span>
		     		</div>
     			</div>

			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">配合比名称</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="name" name="name" placeholder="请输入配合比名称"  value="${proportions.name }" class="layui-input"/>
		        		<span style="color: red" id="s-name"></span>
		     		</div>
     			</div>
	 		 </div>
	 		</div>
	 		<div class="layui-input-block" style="margin-top:30px;margin-left:150px;">
	 			<input type="button" class="layui-btn" onclick="saveData()" value="确定"/>
       			<button class="layui-btn" name="cancleSubmit" >取消</button>
     		</div>
  		</form>
	</body>

	<script type="text/javascript">
		var reqUpdateAndAddUrl = "/admin/proportions/insertAndUpdate";
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
	    var proportionsId = $("#proportionsId").val();
	    var seq = $("#seq").val();
	    var projectId = $("#projectId").val();
	    var name = $("#name").val();

        var requestData={
            "proportionsId":proportionsId,
            "seq":seq,
            "projectId":projectId,
            "name":name
        };
        updateAndAdd(requestData);
    }
	
</script>
</html>				 
