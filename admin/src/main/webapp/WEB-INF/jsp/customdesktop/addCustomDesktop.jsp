<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
    	<meta charset="utf-8">
		<title>新增自定义桌面</title>
		<%@include file="/WEB-INF/jsp/decorators/addHeader.jsp" %>
	</head>
	<body>
 		<form id="saleForm" class="layui-form" style="margin-top:30px;">
 			<input  type="hidden" id="desktopId" name="desktopId" value="${customDesktop.desktopId}"/>
     		<div class="layui-form-item" >
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label  class="layui-form-label">创建时间:</label>
	            	<div class="layui-input-inline">
		            	<input onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" type="text"  name="createTime" id="createTime" value="${customDesktop.createTimeStr}" class="form-control input-small" placeholder="请选择创建时间"/>
		            	<span style="color: red" id="s-createTime"></span>
		        	</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">创建人编号</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="createUser" name="createUser" placeholder="请输入创建人编号"  value="${customDesktop.createUser }" class="layui-input"/>
		        		<span style="color: red" id="s-createUser"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">用户主键编号</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="userId" name="userId" placeholder="请输入用户主键编号"  value="${customDesktop.userId }" class="layui-input"/>
		        		<span style="color: red" id="s-userId"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">菜单编号</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="menuId" name="menuId" placeholder="请输入菜单编号"  value="${customDesktop.menuId }" class="layui-input"/>
		        		<span style="color: red" id="s-menuId"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">自定义名称</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="customName" name="customName" placeholder="请输入自定义名称"  value="${customDesktop.customName }" class="layui-input"/>
		        		<span style="color: red" id="s-customName"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label  class="layui-form-label">修改时间:</label>
	            	<div class="layui-input-inline">
		            	<input onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" type="text"  name="updateTime" id="updateTime" value="${customDesktop.updateTimeStr}" class="form-control input-small" placeholder="请选择修改时间"/>
		            	<span style="color: red" id="s-updateTime"></span>
		        	</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">排序号</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="seq" name="seq" placeholder="请输入排序号"  value="${customDesktop.seq }" class="layui-input"/>
		        		<span style="color: red" id="s-seq"></span>
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
		var reqUpdateAndAddUrl = "/admin/customDesktop/insertAndUpdate";
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
	    var desktopId = $("#desktopId").val();
	    var createTime = $("#createTime").val();
	    var createUser = $("#createUser").val();
	    var userId = $("#userId").val();
	    var menuId = $("#menuId").val();
	    var customName = $("#customName").val();
	    var updateTime = $("#updateTime").val();
	    var seq = $("#seq").val();

        var requestData={
            "desktopId":desktopId,
            "createTimeStr":createTime,
            "createUser":createUser,
            "userId":userId,
            "menuId":menuId,
            "customName":customName,
            "updateTimeStr":updateTime,
            "seq":seq
        };
        updateAndAdd(requestData);
    }
	
</script>
</html>				 
