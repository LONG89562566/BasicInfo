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
     		<div class="layui-form-item" >
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label  class="layui-form-label">创建时间:</label>
	            	<div class="layui-input-inline">
		            	<input onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" type="text"  name="createTime" id="createTime" value="${material.createTimeStr}" class="form-control input-small" placeholder="请选择创建时间"/>
		            	<span style="color: red" id="s-createTime"></span>
		        	</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">创建人编号</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="createUser" name="createUser" placeholder="请输入创建人编号"  value="${material.createUser }" class="layui-input"/>
		        		<span style="color: red" id="s-createUser"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">删除标记</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="deleteFlag" name="deleteFlag" placeholder="请输入删除标记"  value="${material.deleteFlag }" class="layui-input"/>
		        		<span style="color: red" id="s-deleteFlag"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label  class="layui-form-label">修改时间:</label>
	            	<div class="layui-input-inline">
		            	<input onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" type="text"  name="updateTime" id="updateTime" value="${material.updateTimeStr}" class="form-control input-small" placeholder="请选择修改时间"/>
		            	<span style="color: red" id="s-updateTime"></span>
		        	</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">排序号</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="seq" name="seq" placeholder="请输入排序号"  value="${material.seq }" class="layui-input"/>
		        		<span style="color: red" id="s-seq"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">项目编号</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="projectId" name="projectId" placeholder="请输入项目编号"  value="${material.projectId }" class="layui-input"/>
		        		<span style="color: red" id="s-projectId"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">材料名称</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="materialname" name="materialname" placeholder="请输入材料名称"  value="${material.materialname }" class="layui-input"/>
		        		<span style="color: red" id="s-materialname"></span>
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
		        		<input type="text" id="manufacturer" name="manufacturer" placeholder="请输入生产厂家"  value="${material.manufacturer }" class="layui-input"/>
		        		<span style="color: red" id="s-manufacturer"></span>
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
			<div class='layui-form-item'>
		        <label class="layui-form-label">试验报告单</label>
				<div class="layui-input-block">
					<textarea placeholder="请输入试验报告单" style="width: 90%;" class="layui-textarea"  id="testReport" name = "testReport" lay-verify="content">${material.testReport}</textarea>
					<span style="color: red" id="s-testReport"></span>
				</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">检验状态</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="testState" name="testState" placeholder="请输入检验状态"  value="${material.testState }" class="layui-input"/>
		        		<span style="color: red" id="s-testState"></span>
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
	
	function saveData() {
	    var materialId = $("#materialId").val();
	    var createTime = $("#createTime").val();
	    var createUser = $("#createUser").val();
	    var deleteFlag = $("#deleteFlag").val();
	    var updateTime = $("#updateTime").val();
	    var seq = $("#seq").val();
	    var projectId = $("#projectId").val();
	    var materialname = $("#materialname").val();
	    var model = $("#model").val();
	    var unit = $("#unit").val();
	    var entryNum = $("#entryNum").val();
	    var manufacturer = $("#manufacturer").val();
	    var supplyer = $("#supplyer").val();
	    var certificateQuality = $("#certificateQuality").val();
	    var inspection = $("#inspection").val();
	    var usePart = $("#usePart").val();
	    var storage = $("#storage").val();
	    var residualNum = $("#residualNum").val();
	    var testReport = $("#testReport").val();
	    var testState = $("#testState").val();

        var requestData={
            "materialId":materialId,
            "createTimeStr":createTime,
            "createUser":createUser,
            "deleteFlag":deleteFlag,
            "updateTimeStr":updateTime,
            "seq":seq,
            "projectId":projectId,
            "materialname":materialname,
            "model":model,
            "unit":unit,
            "entryNum":entryNum,
            "manufacturer":manufacturer,
            "supplyer":supplyer,
            "certificateQuality":certificateQuality,
            "inspection":inspection,
            "usePart":usePart,
            "storage":storage,
            "residualNum":residualNum,
            "testReport":testReport,
            "testState":testState
        };
        updateAndAdd(requestData);
    }
	
</script>
</html>				 
