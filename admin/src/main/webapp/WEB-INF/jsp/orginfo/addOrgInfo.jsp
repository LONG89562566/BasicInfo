<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
    	<meta charset="utf-8">
		<title>新增组织机构信息</title>
		<%@include file="/WEB-INF/jsp/decorators/addHeader.jsp" %>
	</head>
	<body>
 		<form id="saleForm" class="layui-form" style="margin-top:30px;">
 			<input  type="hidden" id="orgId" name="orgId" value="${orgInfo.orgId}"/>
     		<div class="layui-form-item" >
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label  class="layui-form-label">创建时间:</label>
	            	<div class="layui-input-inline">
		            	<input onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" type="text"  name="createTime" id="createTime" value="${orgInfo.createTimeStr}" class="form-control input-small" placeholder="请选择创建时间"/>
		            	<span style="color: red" id="s-createTime"></span>
		        	</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">创建人编号</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="createUser" name="createUser" placeholder="请输入创建人编号"  value="${orgInfo.createUser }" class="layui-input"/>
		        		<span style="color: red" id="s-createUser"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">删除标记</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="deleteFlag" name="deleteFlag" placeholder="请输入删除标记"  value="${orgInfo.deleteFlag }" class="layui-input"/>
		        		<span style="color: red" id="s-deleteFlag"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label  class="layui-form-label">修改时间:</label>
	            	<div class="layui-input-inline">
		            	<input onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" type="text"  name="updateTime" id="updateTime" value="${orgInfo.updateTimeStr}" class="form-control input-small" placeholder="请选择修改时间"/>
		            	<span style="color: red" id="s-updateTime"></span>
		        	</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">排序号</label>
		        	<div class="layui-input-inline">
		        		<input type="number" id="seq" name="seq" placeholder="请输入排序号"  value="${orgInfo.seq }" class="layui-input"/>
		        		<span style="color: red" id="s-seq"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">层级</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="level" name="level" placeholder="请输入层级"  value="${orgInfo.level }" class="layui-input"/>
		        		<span style="color: red" id="s-level"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">是否末级</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="isEnd" name="isEnd" placeholder="请输入是否末级"  value="${orgInfo.isEnd }" class="layui-input"/>
		        		<span style="color: red" id="s-isEnd"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">父编号</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="parentId" name="parentId" placeholder="请输入父编号"  value="${orgInfo.parentId }" class="layui-input"/>
		        		<span style="color: red" id="s-parentId"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">机构名称</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="orgName" name="orgName" placeholder="请输入机构名称"  value="${orgInfo.orgName }" class="layui-input"/>
		        		<span style="color: red" id="s-orgName"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">机构别名</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="otName" name="otName" placeholder="请输入机构别名"  value="${orgInfo.otName }" class="layui-input"/>
		        		<span style="color: red" id="s-otName"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">机构编码</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="orgCode" name="orgCode" placeholder="请输入机构编码"  value="${orgInfo.orgCode }" class="layui-input"/>
		        		<span style="color: red" id="s-orgCode"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">项目编号</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="projectId" name="projectId" placeholder="请输入项目编号"  value="${orgInfo.projectId }" class="layui-input"/>
		        		<span style="color: red" id="s-projectId"></span>
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
		var reqUpdateAndAddUrl = "/admin/orgInfo/insertAndUpdate";
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
	    var orgId = $("#orgId").val();
	    var createTime = $("#createTime").val();
	    var createUser = $("#createUser").val();
	    var deleteFlag = $("#deleteFlag").val();
	    var updateTime = $("#updateTime").val();
	    var seq = $("#seq").val();
	    var level = $("#level").val();
	    var isEnd = $("#isEnd").val();
	    var parentId = $("#parentId").val();
	    var orgName = $("#orgName").val();
	    var otName = $("#otName").val();
	    var orgCode = $("#orgCode").val();
	    var projectId = $("#projectId").val();

        var requestData={
            "orgId":orgId,
            "createTimeStr":createTime,
            "createUser":createUser,
            "deleteFlag":deleteFlag,
            "updateTimeStr":updateTime,
            "seq":seq,
            "level":level,
            "isEnd":isEnd,
            "parentId":parentId,
            "orgName":orgName,
            "otName":otName,
            "orgCode":orgCode,
            "projectId":projectId
        };
        updateAndAdd(requestData);
    }
	
</script>
</html>				 
