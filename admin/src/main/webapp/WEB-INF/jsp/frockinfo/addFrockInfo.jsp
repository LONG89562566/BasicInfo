<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
    	<meta charset="utf-8">
		<title>新增工装信息</title>
		<%@include file="/WEB-INF/jsp/decorators/addHeader.jsp" %>
	</head>
	<body>
 		<form id="saleForm" class="layui-form" style="margin-top:30px;">
 			<input  type="hidden" id="frockId" name="frockId" value="${frockInfo.frockId}"/>
			<input  type="hidden" id="projectId" name="projectId" value="${frockInfo.projectId}"/>
			<jsp:include page="/WEB-INF/jsp/flow/flowPage.jsp">
				<jsp:param name="docUnid" value="${frockInfo.frockId}" />
			</jsp:include>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">排序号</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="seq" name="seq" placeholder="请输入排序号"  value="${frockInfo.seq }" class="layui-input"/>
		        		<span style="color: red" id="s-seq"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">类别</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="type" name="type" placeholder="请输入类别"  value="${frockInfo.type }" class="layui-input"/>
		        		<span style="color: red" id="s-type"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">管理编号</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="mId" name="mId" placeholder="请输入管理编号"  value="${frockInfo.mId }" class="layui-input"/>
		        		<span style="color: red" id="s-mId"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">名称</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="name" name="name" placeholder="请输入名称"  value="${frockInfo.name }" class="layui-input"/>
		        		<span style="color: red" id="s-name"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">型号规格</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="model" name="model" placeholder="请输入型号规格"  value="${frockInfo.model }" class="layui-input"/>
		        		<span style="color: red" id="s-model"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">生产厂家</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="manufacturer" name="manufacturer" placeholder="请输入生产厂家"  value="${frockInfo.manufacturer }" class="layui-input"/>
		        		<span style="color: red" id="s-manufacturer"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">完好状态</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="state" name="state" placeholder="请输入完好状态"  value="${frockInfo.state }" class="layui-input"/>
		        		<span style="color: red" id="s-state"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">使用场所</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="usePlace" name="usePlace" placeholder="请输入使用场所"  value="${frockInfo.usePlace }" class="layui-input"/>
		        		<span style="color: red" id="s-usePlace"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">责任人</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="liabler" name="liabler" placeholder="请输入责任人"  value="${frockInfo.liabler }" class="layui-input"/>
		        		<span style="color: red" id="s-liabler"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label  class="layui-form-label">购置日期:</label>
	            	<div class="layui-input-inline">
		            	<input onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" type="text"  name="purchaseTime" id="purchaseTime" value="${frockInfo.purchaseTimeStr}" class="form-control input-small" placeholder="请选择购置日期"/>
		            	<span style="color: red" id="s-purchaseTime"></span>
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
		var reqUpdateAndAddUrl = "/admin/frockInfo/insertAndUpdate";
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
	    var frockId = $("#frockId").val();
	    var seq = $("#seq").val();
	    var projectId = $("#projectId").val();
	    var type = $("#type").val();
	    var mId = $("#mId").val();
	    var name = $("#name").val();
	    var model = $("#model").val();
	    var manufacturer = $("#manufacturer").val();
	    var state = $("#state").val();
	    var usePlace = $("#usePlace").val();
	    var liabler = $("#liabler").val();
	    var purchaseTime = $("#purchaseTime").val();

        var requestData={
            "frockId":frockId,
            "seq":seq,
            "projectId":projectId,
            "type":type,
            "mId":mId,
            "name":name,
            "model":model,
            "manufacturer":manufacturer,
            "state":state,
            "usePlace":usePlace,
            "liabler":liabler,
            "purchaseTimeStr":purchaseTime
        };
        updateAndAdd(requestData);
    }
	
</script>
</html>				 
