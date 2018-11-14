<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
    	<meta charset="utf-8">
		<title>新增流程</title>
		<%@include file="/WEB-INF/jsp/decorators/addHeader.jsp" %>
	</head>
	<body>
 		<form id="saleForm" class="layui-form" style="margin-top:30px;">
 			<input  type="hidden" id="flowId" name="flowId" value="${flow.flowId}"/>
     		<div class="layui-form-item" >
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label  class="layui-form-label">创建时间:</label>
	            	<div class="layui-input-inline">
		            	<input onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" type="text"  name="createTime" id="createTime" value="${flow.createTimeStr}" class="form-control input-small" placeholder="请选择创建时间"/>
		            	<span style="color: red" id="s-createTime"></span>
		        	</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">创建人编号</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="createUser" name="createUser" placeholder="请输入创建人编号"  value="${flow.createUser }" class="layui-input"/>
		        		<span style="color: red" id="s-createUser"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">创建人名称</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="createUserCn" name="createUserCn" placeholder="请输入创建人名称"  value="${flow.createUserCn }" class="layui-input"/>
		        		<span style="color: red" id="s-createUserCn"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">删除标记</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="deleteFlag" name="deleteFlag" placeholder="请输入删除标记"  value="${flow.deleteFlag }" class="layui-input"/>
		        		<span style="color: red" id="s-deleteFlag"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label  class="layui-form-label">修改时间:</label>
	            	<div class="layui-input-inline">
		            	<input onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" type="text"  name="updateTime" id="updateTime" value="${flow.updateTimeStr}" class="form-control input-small" placeholder="请选择修改时间"/>
		            	<span style="color: red" id="s-updateTime"></span>
		        	</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">排序号</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="seq" name="seq" placeholder="请输入排序号"  value="${flow.seq }" class="layui-input"/>
		        		<span style="color: red" id="s-seq"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">节点名称</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="name" name="name" placeholder="请输入节点名称"  value="${flow.name }" class="layui-input"/>
		        		<span style="color: red" id="s-name"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">上一节点</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="lastNode" name="lastNode" placeholder="请输入上一节点"  value="${flow.lastNode }" class="layui-input"/>
		        		<span style="color: red" id="s-lastNode"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">下一节点</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="nextNode" name="nextNode" placeholder="请输入下一节点"  value="${flow.nextNode }" class="layui-input"/>
		        		<span style="color: red" id="s-nextNode"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">参与部门编号</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="orgId" name="orgId" placeholder="请输入参与部门编号"  value="${flow.orgId }" class="layui-input"/>
		        		<span style="color: red" id="s-orgId"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">参与角色编号</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="roleId" name="roleId" placeholder="请输入参与角色编号"  value="${flow.roleId }" class="layui-input"/>
		        		<span style="color: red" id="s-roleId"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">参与人编号</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="userId" name="userId" placeholder="请输入参与人编号"  value="${flow.userId }" class="layui-input"/>
		        		<span style="color: red" id="s-userId"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">意见</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="msg" name="msg" placeholder="请输入意见"  value="${flow.msg }" class="layui-input"/>
		        		<span style="color: red" id="s-msg"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">是否完成</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="isDone" name="isDone" placeholder="请输入是否完成"  value="${flow.isDone }" class="layui-input"/>
		        		<span style="color: red" id="s-isDone"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">业务内容</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="showTitle" name="showTitle" placeholder="请输入业务内容"  value="${flow.showTitle }" class="layui-input"/>
		        		<span style="color: red" id="s-showTitle"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">业务详情页面</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="docUrl" name="docUrl" placeholder="请输入业务详情页面"  value="${flow.docUrl }" class="layui-input"/>
		        		<span style="color: red" id="s-docUrl"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">业务表主键</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="docUnid" name="docUnid" placeholder="请输入业务表主键"  value="${flow.docUnid }" class="layui-input"/>
		        		<span style="color: red" id="s-docUnid"></span>
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
		var reqUpdateAndAddUrl = "/admin/flow/insertAndUpdate";
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
	    var flowId = $("#flowId").val();
	    var createTime = $("#createTime").val();
	    var createUser = $("#createUser").val();
	    var createUserCn = $("#createUserCn").val();
	    var deleteFlag = $("#deleteFlag").val();
	    var updateTime = $("#updateTime").val();
	    var seq = $("#seq").val();
	    var name = $("#name").val();
	    var lastNode = $("#lastNode").val();
	    var nextNode = $("#nextNode").val();
	    var orgId = $("#orgId").val();
	    var roleId = $("#roleId").val();
	    var userId = $("#userId").val();
	    var msg = $("#msg").val();
	    var isDone = $("#isDone").val();
	    var showTitle = $("#showTitle").val();
	    var docUrl = $("#docUrl").val();
	    var docUnid = $("#docUnid").val();

        var requestData={
            "flowId":flowId,
            "createTimeStr":createTime,
            "createUser":createUser,
            "createUserCn":createUserCn,
            "deleteFlag":deleteFlag,
            "updateTimeStr":updateTime,
            "seq":seq,
            "name":name,
            "lastNode":lastNode,
            "nextNode":nextNode,
            "orgId":orgId,
            "roleId":roleId,
            "userId":userId,
            "msg":msg,
            "isDone":isDone,
            "showTitle":showTitle,
            "docUrl":docUrl,
            "docUnid":docUnid
        };
        updateAndAdd(requestData);
    }
	
</script>
</html>				 
