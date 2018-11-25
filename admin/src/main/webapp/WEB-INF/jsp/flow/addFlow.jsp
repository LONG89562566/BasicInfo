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
 			<input  type="hidden" id="docUnid" name="docUnid" value=""/>
            <input  type="hidden" id="docUrl" name="docUrl" value=""/>
<%--     			<div class="layui-inline">
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
     			</div>--%>
            <div class='layui-form-item'>
                <div class="layui-inline">
                    <label class="layui-form-label">业务名称</label>
                    <div class="layui-input-inline">
                        <input type="text" id="showTitle" name="showTitle" placeholder="请输入业务名称"  value="${flow.showTitle }" class="layui-input"/>
                        <span style="color: red" id="s-showTitle"></span>
                    </div>
                </div>
            </div>
            <div class='layui-form-item'>
                <div class="layui-inline">
                    <label class="layui-form-label">参与人</label>
                    <div class="layui-input-inline">
                        <input type="text" id="userId" name="userId" placeholder="请输入参与人"  value="${flow.userId }" class="layui-input"/>
                        <span style="color: red" id="s-userId"></span>
                    </div>
                </div>
            </div>
            <div class='layui-form-item'>
                <label class="layui-form-label">意见</label>
                <div class="layui-input-block">
                    <textarea placeholder="请输入意见" style="width: 90%;" class="layui-textarea"  id="msg" name = "msg" lay-verify="content">${flow.msg}</textarea>
                    <span style="color: red" id="s-msg"></span>
                </div>
            </div>

	 		<div class="layui-input-block" style="margin-top:2%;margin-left: 30%;margin-bottom: 2%">
	 			<input type="button" class="layui-btn" onclick="saveData()" value="确定"/>
       			<button class="layui-btn" name="cancleSubmit" >取消</button>
     		</div>
  		</form>
	</body>
    <script type="text/javascript">

        $(function () {
            /*         $("#releaseUser").combotree({
                         url: '/admin/staffInfo/staffInfoTree',
                         // multiple : true,//设置可以多选，显示多选框，不设置不会出现多选框
                         data : [{},{},{}],//数据省略
                         required: true,
                         checkbox : true,//显示多选框
                         onlyLeafCheck : true,//只在叶子节点显示多选框
                         onBeforeSelect : function(node){
                             if(!$(this).tree("isLeaf", node.target)){//如果不是叶子节点，不让选择
                                 return false;
                             }
                         },
                         onBeforeCheck : function(node, checked){//控制只能选一项
                             if(checked){//当前为选中操作
                                 var nodes = $(this).tree("getChecked");
                                 //控制只能选一项，选中某一项后后面不能再勾选
                                 if(nodes.length == 0){
                                     return true;
                                 }else{
                                     return false;
                                 }
                             }else{//当前为取消选中操作
                                 return true;
                             }
                         }
                     });*/

            $("#userId").combotree({
                url: '/admin/staffInfo/staffInfoTree',
                multiple : true,//设置可以多选，显示多选框，不设置不会出现多选框
                idField:'staffId',           //定义标识树节点的键名字段
                treeField:'name',       //定义树节点的字段
                data : [{},{},{}],//数据省略
                required: true,
                checkbox : true,//显示多选框
                onlyLeafCheck : true,//只在叶子节点显示多选框
                onBeforeSelect : function(node){
                    if(!$(this).tree("isLeaf", node.target)){//如果不是叶子节点，不让选择
                        return false;
                    }
                },
                onBeforeCheck : function(node, checked){//控制只能选一项
                    if(checked){//当前为选中操作
                        var nodes = $(this).tree("getChecked");
                    }else{//当前为取消选中操作
                        return true;
                    }
                }
            });
        });

    </script>
	<script type="text/javascript">
		var reqUpdateAndAddUrl = "/admin/flow/sendFlow";
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
	    var user = $('#userId').combotree('getValues');
	    var userId = "";
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
            "user":user,
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
