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
		        	<label  class="layui-form-label">创建时间:</label>
	            	<div class="layui-input-inline">
		            	<input onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" type="text"  name="createTime" id="createTime" value="${projectSurvey.createTimeStr}" class="form-control input-small" placeholder="请选择创建时间"/>
		            	<span style="color: red" id="s-createTime"></span>
		        	</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">创建人编号</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="createUser" name="createUser" placeholder="请输入创建人编号"  value="${projectSurvey.createUser }" class="layui-input"/>
		        		<span style="color: red" id="s-createUser"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">删除标记</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="deleteFlag" name="deleteFlag" placeholder="请输入删除标记"  value="${projectSurvey.deleteFlag }" class="layui-input"/>
		        		<span style="color: red" id="s-deleteFlag"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label  class="layui-form-label">修改时间:</label>
	            	<div class="layui-input-inline">
		            	<input onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" type="text"  name="updateTime" id="updateTime" value="${projectSurvey.updateTimeStr}" class="form-control input-small" placeholder="请选择修改时间"/>
		            	<span style="color: red" id="s-updateTime"></span>
		        	</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">排序号</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="seq" name="seq" placeholder="请输入排序号"  value="${projectSurvey.seq }" class="layui-input"/>
		        		<span style="color: red" id="s-seq"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">梁场名称</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="lcName" name="lcName" placeholder="请输入梁场名称"  value="${projectSurvey.lcName }" class="layui-input"/>
		        		<span style="color: red" id="s-lcName"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">梁场地址</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="lcAddr" name="lcAddr" placeholder="请输入梁场地址"  value="${projectSurvey.lcAddr }" class="layui-input"/>
		        		<span style="color: red" id="s-lcAddr"></span>
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
	    var overallGoal = $("#overallGoal").val();
	    var timeGoal = $("#timeGoal").val();
	    var securityGoal = $("#securityGoal").val();
	    var qualityGoal = $("#qualityGoal").val();
	    var epoGoal = $("#epoGoal").val();
	    var ophGoal = $("#ophGoal").val();

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
