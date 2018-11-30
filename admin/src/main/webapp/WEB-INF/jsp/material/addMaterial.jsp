<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
    	<meta charset="utf-8">
		<title>新增材料</title>
		<%@include file="/WEB-INF/jsp/decorators/addHeader.jsp" %>
	</head>
	<body>
 		<form id="saleForm" class="layui-form" style="margin-top:30px;">
 			<input  type="hidden" id="materialId" name="materialId" value="${material.materialId}"/>
 			<input  type="hidden" id="projectId" name="projectId" value="${projectId}"/>


			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">排序号</label>
		        	<div class="layui-input-inline">
		        		<input type="number" id="seq" name="seq" placeholder="请输入排序号"  value="${material.seq }" class="layui-input"/>
		        		<span style="color: red" id="s-seq"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">材料名称</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="materialName" name="materialName" placeholder="请输入材料名称"  value="${material.materialName }" class="layui-input"/>
		        		<span style="color: red" id="s-materialName"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">规格型号</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="model" name="model" placeholder="请输入规格型号"  value="${material.model }" class="layui-input"/>
		        		<span style="color: red" id="s-model"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">计量单位</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="unit" name="unit" placeholder="请输入计量单位"  value="${material.unit }" class="layui-input"/>
		        		<span style="color: red" id="s-unit"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">进场数量</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="entryNum" name="entryNum" placeholder="请输入进场数量"  value="${material.entryNum }" class="layui-input"/>
		        		<span style="color: red" id="s-entryNum"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">生产厂家</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="manufactrer" name="manufactrer" placeholder="请输入生产厂家"  value="${material.manufactrer }" class="layui-input"/>
		        		<span style="color: red" id="s-manufactrer"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">供货单位</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="supplyer" name="supplyer" placeholder="请输入供货单位"  value="${material.supplyer }" class="layui-input"/>
		        		<span style="color: red" id="s-supplyer"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
		        <label class="layui-form-label">质量证明书</label>
				<div class="layui-input-block">
					<textarea placeholder="请输入质量证明书" style="width: 90%;" class="layui-textarea"  id="certificateQuality" name = "certificateQuality" lay-verify="content">${material.certificateQuality}</textarea>
					<span style="color: red" id="s-certificateQuality"></span>
				</div>
			</div>
			<div class='layui-form-item'>
		        <label class="layui-form-label">报验委托单</label>
				<div class="layui-input-block">
					<textarea placeholder="请输入报验委托单" style="width: 90%;" class="layui-textarea"  id="inspection" name = "inspection" lay-verify="content">${material.inspection}</textarea>
					<span style="color: red" id="s-inspection"></span>
				</div>
			</div>
			<div class='layui-form-item'>
		        <label class="layui-form-label">使用部位</label>
				<div class="layui-input-block">
					<textarea placeholder="请输入使用部位" style="width: 90%;" class="layui-textarea"  id="usePart" name = "usePart" lay-verify="content">${material.usePart}</textarea>
					<span style="color: red" id="s-usePart"></span>
				</div>
			</div>
			<div class='layui-form-item'>
		        <label class="layui-form-label">存放地点</label>
				<div class="layui-input-block">
					<textarea placeholder="请输入存放地点" style="width: 90%;" class="layui-textarea"  id="storage" name = "storage" lay-verify="content">${material.storage}</textarea>
					<span style="color: red" id="s-storage"></span>
				</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">剩余数量</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="residualNum" name="residualNum" placeholder="请输入剩余数量"  value="${material.residualNum }" class="layui-input"/>
		        		<span style="color: red" id="s-residualNum"></span>
		     		</div>
     			</div>
			</div>
  		</form>
	</body>

	<script type="text/javascript">
		var reqUpdateAndAddUrl = "/admin/material/insertAndUpdate";
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

    var getData = function () {
        var materialId = $("#materialId").val();
        var createTime = $("#createTime").val();
        var createUser = $("#createUser").val();
        var deleteFlag = $("#deleteFlag").val();
        var updateTime = $("#updateTime").val();
        var seq = $("#seq").val();
        var projectId = $("#projectId").val();
        var materialName = $("#materialName").val();
        var model = $("#model").val();
        var unit = $("#unit").val();
        var entryNum = $("#entryNum").val();
        var manufactrer = $("#manufactrer").val();
        var supplyer = $("#supplyer").val();
        var certificateQuality = $("#certificateQuality").val();
        var inspection = $("#inspection").val();
        var usePart = $("#usePart").val();
        var storage = $("#storage").val();
        var residualNum = $("#residualNum").val();

        var requestData={
            "materialId":materialId,
            "createTimeStr":createTime,
            "createUser":createUser,
            "deleteFlag":deleteFlag,
            "updateTimeStr":updateTime,
            "seq":seq,
            "projectId":projectId,
            "materialName":materialName,
            "model":model,
            "unit":unit,
            "entryNum":entryNum,
            "manufactrer":manufactrer,
            "supplyer":supplyer,
            "certificateQuality":certificateQuality,
            "inspection":inspection,
            "usePart":usePart,
            "storage":storage,
            "residualNum":residualNum,
        };
        return requestData;
    };

	
</script>
</html>				 
