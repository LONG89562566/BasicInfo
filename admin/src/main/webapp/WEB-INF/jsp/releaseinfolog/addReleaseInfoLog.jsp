<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
    	<meta charset="utf-8">
		<title>新增信息发布日志</title>
		<%@include file="/WEB-INF/jsp/decorators/addHeader.jsp" %>
	</head>
	<body>
 		<form id="saleForm" class="layui-form" style="margin-top:30px;">
 			<input  type="hidden" id="releaseInfoLogId" name="releaseInfoLogId" value="${releaseInfoLog.releaseInfoLogId}"/>
     		<div class="layui-form-item" >
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label  class="layui-form-label">注册时间:</label>
	            	<div class="layui-input-inline">
		            	<input onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" type="text"  name="createTime" id="createTime" value="${releaseInfoLog.createTimeStr}" class="form-control input-small" placeholder="请选择注册时间"/>
		            	<span style="color: red" id="s-createTime"></span>
		        	</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">信息发布id</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="releaseInfoId" name="releaseInfoId" placeholder="请输入信息发布id"  value="${releaseInfoLog.releaseInfoId }" class="layui-input"/>
		        		<span style="color: red" id="s-releaseInfoId"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">接收人id</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="accepter" name="accepter" placeholder="请输入接收人id"  value="${releaseInfoLog.accepter }" class="layui-input"/>
		        		<span style="color: red" id="s-accepter"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">回报率</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="isRead" name="isRead" placeholder="请输入回报率"  value="${releaseInfoLog.isRead }" class="layui-input"/>
		        		<span style="color: red" id="s-isRead"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">阅读时间</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="readTime" name="readTime" placeholder="请输入阅读时间"  value="${releaseInfoLog.readTime }" class="layui-input"/>
		        		<span style="color: red" id="s-readTime"></span>
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
		var reqUpdateAndAddUrl = "/admin/releaseInfoLog/insertAndUpdate";
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
	    var releaseInfoLogId = $("#releaseInfoLogId").val();
	    var createTime = $("#createTime").val();
	    var releaseInfoId = $("#releaseInfoId").val();
	    var accepter = $("#accepter").val();
	    var isRead = $("#isRead").val();
	    var readTime = $("#readTime").val();

        var requestData={
            "releaseInfoLogId":releaseInfoLogId,
            "createTimeStr":createTime,
            "releaseInfoId":releaseInfoId,
            "accepter":accepter,
            "isRead":isRead,
            "readTime":readTime
        };
        updateAndAdd(requestData);
    }
	
</script>
</html>				 
