<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
    	<meta charset="utf-8">
		<title>新增三维交底</title>
		<%@include file="/WEB-INF/jsp/decorators/addHeader.jsp" %>
	</head>
	<body>
 		<form id="saleForm" class="layui-form" style="margin-top:30px;">
 			<input  type="hidden" id="payId" name="payId" value="${d3Pay.payId}"/>
			<input  type="hidden" id="projectId" name="projectId" value="${d3Pay.projectId}"/>


			<div class='layui-form-item'>
		        <label class="layui-form-label">工序</label>
				<div class="layui-input-block">
					<textarea placeholder="请输入工序" style="width: 90%;" class="layui-textarea"  id="procedures" name = "procedures" lay-verify="content">${d3Pay.procedures}</textarea>
					<span style="color: red" id="s-procedures"></span>
				</div>
			</div>
			<div class='layui-form-item'>
		        <label class="layui-form-label">关键工艺控制要点</label>
				<div class="layui-input-block">
					<textarea placeholder="请输入关键工艺控制要点" style="width: 90%;" class="layui-textarea"  id="processControl" name = "processControl" lay-verify="content">${d3Pay.processControl}</textarea>
					<span style="color: red" id="s-processControl"></span>
				</div>
			</div>
			<div class='layui-form-item'>
		        <label class="layui-form-label">安全控制要点</label>
				<div class="layui-input-block">
					<textarea placeholder="请输入安全控制要点" style="width: 90%;" class="layui-textarea"  id="safetyControl" name = "safetyControl" lay-verify="content">${d3Pay.safetyControl}</textarea>
					<span style="color: red" id="s-safetyControl"></span>
				</div>
			</div>
			<div class='layui-form-item'>
		        <label class="layui-form-label">质量控制要点</label>
				<div class="layui-input-block">
					<textarea placeholder="请输入质量控制要点" style="width: 90%;" class="layui-textarea"  id="qualityControl" name = "qualityControl" lay-verify="content">${d3Pay.qualityControl}</textarea>
					<span style="color: red" id="s-qualityControl"></span>
				</div>
	 		</div>
			<div class='layui-form-item'>
				<div class="layui-inline">
					<label class="layui-form-label">排序号</label>
					<div class="layui-input-inline">
						<input type="text" id="seq" name="seq" placeholder="请输入排序号"  value="${d3Pay.seq }" class="layui-input"/>
						<span style="color: red" id="s-seq"></span>
					</div>
				</div>
			</div>
			<div class='layui-form-item'>
				<jsp:include page="/WEB-INF/jsp/decorators/imageFile.jsp">
					<jsp:param name="docUnid" value="${projectSurvey.projectId}" />
					<jsp:param name="flowId" value="" />
					<jsp:param name="type" value=''/>
					<jsp:param name="imageTitle" value='三维交底图片'/>
					<jsp:param name="imageLable" value='lcImage'/>
				</jsp:include>
			</div>
	 		<div class="layui-input-block" style="margin-top:30px;margin-left:324px;">
	 			<input type="button" class="layui-btn" onclick="saveData()" value="确定"/>
       			<button class="layui-btn" name="cancleSubmit" >取消</button>
     		</div>
  		</form>
	</body>

	<script type="text/javascript">
		var reqUpdateAndAddUrl = "/admin/d3Pay/insertAndUpdate";
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
	    var payId = $("#payId").val();
	    var seq = $("#seq").val();
	    var projectId = $("#projectId").val();
	    var procedures = $("#procedures").val();
	    var processControl = $("#processControl").val();
	    var safetyControl = $("#safetyControl").val();
	    var qualityControl = $("#qualityControl").val();

        var requestData={
            "payId":payId,
            "seq":seq,
            "projectId":projectId,
            "procedures":procedures,
            "processControl":processControl,
            "safetyControl":safetyControl,
            "qualityControl":qualityControl
        };
        updateAndAdd(requestData);
    }
	
</script>
</html>				 
