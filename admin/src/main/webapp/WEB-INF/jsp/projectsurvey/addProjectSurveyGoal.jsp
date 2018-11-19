<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
    	<meta charset="utf-8">
		<title>新增工程概况</title>
		<%@include file="/WEB-INF/jsp/decorators/addHeader.jsp" %>
	</head>
	<body>
 		<form id="saleForm" class="layui-form" style="margin-top:30px;">
 			<input  type="hidden" id="projectId" name="projectId" value="${projectSurvey.projectId}"/>
     		<div class="layui-form-item" >

			<div class='layui-form-item'>
				<div class="layui-inline">
					<label class="layui-form-label">梁场名称</label>
					<div class="layui-input-inline">
						<input type="text" id="lcName" name="lcName" placeholder="请输入梁场名称"  value="${projectSurvey.lcName }" class="layui-input"/>
						<span style="color: red" id="s-lcName"></span>
					</div>
				</div>
			<div class='layui-form-item'>
		        <label class="layui-form-label">总体目标</label>
				<div class="layui-input-block">
					<textarea placeholder="请输入总体目标" style="width: 90%;" class="layui-textarea"  id="overallGoal" name = "overallGoal" lay-verify="content">${projectSurvey.overallGoal}</textarea>
					<span style="color: red" id="s-overallGoal"></span>
				</div>
			</div>
			<div class='layui-form-item'>
		        <label class="layui-form-label">工期目标</label>
				<div class="layui-input-block">
					<textarea placeholder="请输入工期目标" style="width: 90%;" class="layui-textarea"  id="timeGoal" name = "timeGoal" lay-verify="content">${projectSurvey.timeGoal}</textarea>
					<span style="color: red" id="s-timeGoal"></span>
				</div>
			</div>
			<div class='layui-form-item'>
		        <label class="layui-form-label">安全目标</label>
				<div class="layui-input-block">
					<textarea placeholder="请输入安全目标" style="width: 90%;" class="layui-textarea"  id="securityGoal" name = "securityGoal" lay-verify="content">${projectSurvey.securityGoal}</textarea>
					<span style="color: red" id="s-securityGoal"></span>
				</div>
			</div>
			<div class='layui-form-item'>
		        <label class="layui-form-label">质量目标</label>
				<div class="layui-input-block">
					<textarea placeholder="请输入质量目标" style="width: 90%;" class="layui-textarea"  id="qualityGoal" name = "qualityGoal" lay-verify="content">${projectSurvey.qualityGoal}</textarea>
					<span style="color: red" id="s-qualityGoal"></span>
				</div>
			</div>
			<div class='layui-form-item'>
		        <label class="layui-form-label">环境保护目标</label>
				<div class="layui-input-block">
					<textarea placeholder="请输入环境保护目标" style="width: 90%;" class="layui-textarea"  id="epoGoal" name = "epoGoal" lay-verify="content">${projectSurvey.epoGoal}</textarea>
					<span style="color: red" id="s-epoGoal"></span>
				</div>
			</div>
			<div class='layui-form-item'>
		        <label class="layui-form-label">职业健康目标</label>
				<div class="layui-input-block">
					<textarea placeholder="请输入职业健康目标" style="width: 90%;" class="layui-textarea"  id="ophGoal" name = "ophGoal" lay-verify="content">${projectSurvey.ophGoal}</textarea>
					<span style="color: red" id="s-ophGoal"></span>
				</div>
	   </div>

	 		</div>
	 		<div class="layui-input-block" style="margin-top:30px;margin-left:324px;">
	 			<input type="button" class="layui-btn" onclick="saveData()" value="确定"/>
       			<button class="layui-btn" name="cancleSubmit" >取消</button>
     		</div>
			</div>
  		</form>
	</body>

	<script type="text/javascript">
		var reqUpdateAndAddUrl = "/admin/projectSurvey/insertAndUpdate";
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
	    var projectId  = $("#projectId").val();
	    var overallGoal = $("#overallGoal").val();
	    var timeGoal = $("#timeGoal").val();
	    var securityGoal = $("#securityGoal").val();
	    var qualityGoal = $("#qualityGoal").val();
	    var epoGoal = $("#epoGoal").val();
	    var ophGoal = $("#ophGoal").val();

        var requestData={
            "projectId":projectId,
            "overallGoal":overallGoal,
            "timeGoal":timeGoal,
            "securityGoal":securityGoal,
            "qualityGoal":qualityGoal,
            "epoGoal":epoGoal,
            "ophGoal":ophGoal
        };
        updateAndAdd(requestData);
    }
	
</script>
</html>				 
