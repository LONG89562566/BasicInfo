<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
    	<meta charset="utf-8">
		<title>新增二维码</title>
		<%@include file="/WEB-INF/jsp/decorators/addHeader.jsp" %>
	</head>
	<body>
 		<form id="saleForm" class="layui-form" style="margin-top:30px;">
 			<input  type="hidden" id="codeId" name="codeId" value="${codeInfo.codeId}"/>
            <input  type="hidden" id="projectId" name="projectId" value="${codeInfo.projectId}"/>
     		<div class="layui-form-item" >
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">排序号</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="seq" name="seq" placeholder="请输入排序号"  value="${codeInfo.seq }" class="layui-input"/>
		        		<span style="color: red" id="s-seq"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">结构名称</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="structureName" name="structureName" placeholder="请输入结构名称"  value="${codeInfo.structureName }" class="layui-input"/>
		        		<span style="color: red" id="s-structureName"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">结构类型</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="structureType" name="structureType" placeholder="请输入结构类型"  value="${codeInfo.structureType }" class="layui-input"/>
		        		<span style="color: red" id="s-structureType"></span>
		     		</div>
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
		var reqUpdateAndAddUrl = "/admin/codeInfo/insertAndUpdate";
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
	    var codeId = $("#codeId").val();
	    var seq = $("#seq").val();
	    var structureName = $("#structureName").val();
	    var structureType = $("#structureType").val();
	    var projectId = $("#projectId").val();


        var requestData={
            "codeId":codeId,
            "seq":seq,
            "structureName":structureName,
            "structureType":structureType,
            "projectId":projectId
        };
        updateAndAdd(requestData);
    }
	
</script>
</html>				 
