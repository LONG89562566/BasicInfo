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

			<div class='layui-form-item'>
				<div class="layui-inline">
					<label class="layui-form-label">梁场名称</label>
					<div class="layui-input-inline">
						<input type="text" id="lcName" name="lcName" placeholder="请输入梁场名称"  value="${projectSurvey.lcName }" class="layui-input"/>
						<span style="color: red" id="s-lcName"></span>
					</div>
				</div>

     			<div class="layui-inline">
		        	<label class="layui-form-label">梁场地址</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="lcAddr" name="lcAddr" placeholder="请输入梁场地址"  value="${projectSurvey.lcAddr }" class="layui-input"/>
		        		<span style="color: red" id="s-lcAddr"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
				<div class="layui-inline">
					<label class="layui-form-label">生产能力</label>
					<div class="layui-input-inline">
						<input type="text" id="throughput" name="throughput" placeholder="请输入生产能力"  value="${projectSurvey.throughput }" class="layui-input"/>
						<span style="color: red" id="s-throughput"></span>
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">建设单位</label>
					<div class="layui-input-inline">
						<input type="text" id="constructionUnit" name="constructionUnit" placeholder="请输入建设单位"  value="${projectSurvey.constructionUnit }" class="layui-input"/>
						<span style="color: red" id="s-constructionUnit"></span>
					</div>
				</div>
			</div>
			<div class='layui-form-item'>
				<div class="layui-inline">
					<label class="layui-form-label">承建单位</label>
					<div class="layui-input-inline">
						<input type="text" id="bearUnit" name="bearUnit" placeholder="请输入承建单位"  value="${projectSurvey.bearUnit }" class="layui-input"/>
						<span style="color: red" id="s-bearUnit"></span>
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">监理单位</label>
					<div class="layui-input-inline">
						<input type="text" id="controlUnit" name="controlUnit" placeholder="请输入监理单位"  value="${projectSurvey.controlUnit }" class="layui-input"/>
						<span style="color: red" id="s-controlUnit"></span>
					</div>
				</div>
			</div>

			<div class='layui-form-item'>
				<div class="layui-inline">
					<label class="layui-form-label">设计单位</label>
					<div class="layui-input-inline">
						<input type="text" id="designUnit" name="designUnit" placeholder="请输入设计单位"  value="${projectSurvey.designUnit }" class="layui-input"/>
						<span style="color: red" id="s-designUnit"></span>
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">排序号</label>
					<div class="layui-input-inline">
						<input type="text" id="seq" name="seq" placeholder="请输入排序号"  value="${projectSurvey.seq }" class="layui-input"/>
						<span style="color: red" id="s-seq"></span>
					</div>
				</div>

			</div>
			<div class='layui-form-item'>
		        <label class="layui-form-label">线路里程</label>
				<div class="layui-input-block">
					<textarea placeholder="请输入线路里程" style="width: 90%;" class="layui-textarea"  id="lineMileage" name = "lineMileage" lay-verify="content">${projectSurvey.lineMileage}</textarea>
					<span style="color: red" id="s-lineMileage"></span>
				</div>
			</div>
			<div class='layui-form-item'>
		        <label class="layui-form-label">梁场规模</label>
				<div class="layui-input-block">
					<textarea placeholder="请输入梁场规模" style="width: 90%;" class="layui-textarea"  id="lcScale" name = "lcScale" lay-verify="content">${projectSurvey.lcScale}</textarea>
					<span style="color: red" id="s-lcScale"></span>
				</div>
			</div>
			<div class='layui-form-item'>
		        <label class="layui-form-label">承担任务</label>
				<div class="layui-input-block">
					<textarea placeholder="请输入承担任务" style="width: 90%;" class="layui-textarea"  id="bearTask" name = "bearTask" lay-verify="content">${projectSurvey.bearTask}</textarea>
					<span style="color: red" id="s-bearTask"></span>
				</div>
			</div>
			<div class='layui-form-item'>
		        <label class="layui-form-label">供应里程</label>
				<div class="layui-input-block">
					<textarea placeholder="请输入供应里程" style="width: 90%;" class="layui-textarea"  id="supplyMileage" name = "supplyMileage" lay-verify="content">${projectSurvey.supplyMileage}</textarea>
					<span style="color: red" id="s-supplyMileage"></span>
				</div>
			</div>

			<div class='layui-form-item'>
				<jsp:include page="/WEB-INF/jsp/decorators/imageFile.jsp">
					<jsp:param name="docUnid" value="${projectSurvey.projectId}" />
					<jsp:param name="flowId" value="" />
					<jsp:param name="type" value=''/>
					<jsp:param name="imageTitle" value='梁场图片'/>
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
	    var projectId = $("#projectId").val();
	    var createTime = $("#createTime").val();
	    var createUser = $("#createUser").val();
	    var deleteFlag = $("#deleteFlag").val();
	    var updateTime = $("#updateTime").val();
	    var seq = $("#seq").val();
	    var lcName = $("#lcName").val();
	    var lcAddr = $("#lcAddr").val();
	    var lineMileage = $("#lineMileage").val();
	    var lcScale = $("#lcScale").val();
	    var bearTask = $("#bearTask").val();
	    var supplyMileage = $("#supplyMileage").val();
	    var throughput = $("#throughput").val();
	    var constructionUnit = $("#constructionUnit").val();
	    var bearUnit = $("#bearUnit").val();
	    var controlUnit = $("#controlUnit").val();
	    var designUnit = $("#designUnit").val();

        var requestData={
            "projectId":projectId,
            "createTimeStr":createTime,
            "createUser":createUser,
            "deleteFlag":deleteFlag,
            "updateTimeStr":updateTime,
            "seq":seq,
            "lcName":lcName,
            "lcAddr":lcAddr,
            "lineMileage":lineMileage,
            "lcScale":lcScale,
            "bearTask":bearTask,
            "supplyMileage":supplyMileage,
            "throughput":throughput,
            "constructionUnit":constructionUnit,
            "bearUnit":bearUnit,
            "controlUnit":controlUnit,
            "designUnit":designUnit,
        };
        updateAndAdd(requestData);
    }
	
</script>
</html>				 
