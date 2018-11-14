<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
    	<meta charset="utf-8">
		<title>新增信息发布</title>
		<%@include file="/WEB-INF/jsp/decorators/addHeader.jsp" %>
	</head>
	<body>
 		<form id="saleForm" class="layui-form" style="margin-top:30px;">
 			<input  type="hidden" id="releaseId" name="releaseId" value="${releaseInfo.releaseId}"/>
     		<div class="layui-form-item" >
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label  class="layui-form-label">创建时间:</label>
	            	<div class="layui-input-inline">
		            	<input onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" type="text"  name="createTime" id="createTime" value="${releaseInfo.createTimeStr}" class="form-control input-small" placeholder="请选择创建时间"/>
		            	<span style="color: red" id="s-createTime"></span>
		        	</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">创建人编号</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="createUser" name="createUser" placeholder="请输入创建人编号"  value="${releaseInfo.createUser }" class="layui-input"/>
		        		<span style="color: red" id="s-createUser"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">删除标记</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="deleteFlag" name="deleteFlag" placeholder="请输入删除标记"  value="${releaseInfo.deleteFlag }" class="layui-input"/>
		        		<span style="color: red" id="s-deleteFlag"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label  class="layui-form-label">修改时间:</label>
	            	<div class="layui-input-inline">
		            	<input onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" type="text"  name="updateTime" id="updateTime" value="${releaseInfo.updateTimeStr}" class="form-control input-small" placeholder="请选择修改时间"/>
		            	<span style="color: red" id="s-updateTime"></span>
		        	</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">排序号</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="seq" name="seq" placeholder="请输入排序号"  value="${releaseInfo.seq }" class="layui-input"/>
		        		<span style="color: red" id="s-seq"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">标题</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="title" name="title" placeholder="请输入标题"  value="${releaseInfo.title }" class="layui-input"/>
		        		<span style="color: red" id="s-title"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
		        <label class="layui-form-label">内容</label>
				<div class="layui-input-block">
					<textarea placeholder="请输入内容" style="width: 90%;" class="layui-textarea"  id="content" name = "content" lay-verify="content">${releaseInfo.content}</textarea>
					<span style="color: red" id="s-content"></span>
				</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">发布人编号</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="releaseUser" name="releaseUser" placeholder="请输入发布人编号"  value="${releaseInfo.releaseUser }" class="layui-input"/>
		        		<span style="color: red" id="s-releaseUser"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">接收人编号</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="receiveUser" name="receiveUser" placeholder="请输入接收人编号"  value="${releaseInfo.receiveUser }" class="layui-input"/>
		        		<span style="color: red" id="s-receiveUser"></span>
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
		var reqUpdateAndAddUrl = "/admin/releaseInfo/insertAndUpdate";
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
	    var releaseId = $("#releaseId").val();
	    var createTime = $("#createTime").val();
	    var createUser = $("#createUser").val();
	    var deleteFlag = $("#deleteFlag").val();
	    var updateTime = $("#updateTime").val();
	    var seq = $("#seq").val();
	    var title = $("#title").val();
	    var content = $("#content").val();
	    var releaseUser = $("#releaseUser").val();
	    var receiveUser = $("#receiveUser").val();

        var requestData={
            "releaseId":releaseId,
            "createTimeStr":createTime,
            "createUser":createUser,
            "deleteFlag":deleteFlag,
            "updateTimeStr":updateTime,
            "seq":seq,
            "title":title,
            "content":content,
            "releaseUser":releaseUser,
            "receiveUser":receiveUser
        };
        updateAndAdd(requestData);
    }
	
</script>
</html>				 
