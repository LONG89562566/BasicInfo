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
     		<div class="layui-form-item" >
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label  class="layui-form-label">创建时间:</label>
	            	<div class="layui-input-inline">
		            	<input onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" type="text"  name="createTime" id="createTime" value="${d3Pay.createTimeStr}" class="form-control input-small" placeholder="请选择创建时间"/>
		            	<span style="color: red" id="s-createTime"></span>
		        	</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">创建人编号</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="createUser" name="createUser" placeholder="请输入创建人编号"  value="${d3Pay.createUser }" class="layui-input"/>
		        		<span style="color: red" id="s-createUser"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">删除标记</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="deleteFlag" name="deleteFlag" placeholder="请输入删除标记"  value="${d3Pay.deleteFlag }" class="layui-input"/>
		        		<span style="color: red" id="s-deleteFlag"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label  class="layui-form-label">修改时间:</label>
	            	<div class="layui-input-inline">
		            	<input onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" type="text"  name="updateTime" id="updateTime" value="${d3Pay.updateTimeStr}" class="form-control input-small" placeholder="请选择修改时间"/>
		            	<span style="color: red" id="s-updateTime"></span>
		        	</div>
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
     			<div class="layui-inline">
		        	<label class="layui-form-label">项目编号</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="projectId" name="projectId" placeholder="请输入项目编号"  value="${d3Pay.projectId }" class="layui-input"/>
		        		<span style="color: red" id="s-projectId"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
		        <label class="layui-form-label">工序</label>
				<div class="layui-input-block">
					<textarea placeholder="请输入工序" style="width: 90%;" class="layui-textarea"  id="procedure" name = "procedure" lay-verify="content">${d3Pay.procedure}</textarea>
					<span style="color: red" id="s-procedure"></span>
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
	    var createTime = $("#createTime").val();
	    var createUser = $("#createUser").val();
	    var deleteFlag = $("#deleteFlag").val();
	    var updateTime = $("#updateTime").val();
	    var seq = $("#seq").val();
	    var projectId = $("#projectId").val();
	    var procedure = $("#procedure").val();
	    var processControl = $("#processControl").val();
	    var safetyControl = $("#safetyControl").val();
	    var qualityControl = $("#qualityControl").val();

        var requestData={
            "payId":payId,
            "createTimeStr":createTime,
            "createUser":createUser,
            "deleteFlag":deleteFlag,
            "updateTimeStr":updateTime,
            "seq":seq,
            "projectId":projectId,
            "procedure":procedure,
            "processControl":processControl,
            "safetyControl":safetyControl,
            "qualityControl":qualityControl
        };
        updateAndAdd(requestData);
    }
	
</script>
</html>				 
