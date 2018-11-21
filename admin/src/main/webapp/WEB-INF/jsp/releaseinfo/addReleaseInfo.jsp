<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
    	<meta charset="utf-8">
		<title>新增信息发布</title>
		<%@include file="/WEB-INF/jsp/decorators/addHeader.jsp" %>

		<link rel="stylesheet" href="/dist/fSelect/fSelect.css"/>
		<script type="text/javascript" src="/dist/fSelect/fSelect.js"></script>
	</head>
	<body>
 		<form id="saleForm" class="layui-form" style="margin-top:30px;">
 			<input  type="hidden" id="releaseId" name="releaseId" value="${releaseInfo.releaseId}"/>
 			<input  type="hidden" id="releaseUser" name="releaseUser" value="${releaseInfo.releaseUser}${userId}"/>

			<div class='layui-form-item'>
				<label class="layui-form-label">标题</label>
				<div class="layui-input-block">
					<input type="text" id="title" style="width: 80%;" name="title" placeholder="请输入标题"  value="${releaseInfo.title }" class="layui-input"/>
					<span style="color: red" id="s-title"></span>
				</div>
			</div>
			<div class='layui-form-item'>
				<div class="layui-inline">
					<label class="layui-form-label">发布人</label>
					<div class="layui-input-inline">
						<input type="text" id="releaseUserName" name="releaseUserName" placeholder="请输入发布人编号"  value="${releaseInfo.releaseUserCn }${userName}" class="layui-input" readonly/>
						<span style="color: red" id="s-releaseUser"></span>
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">接收人</label>
					<div class="layui-input-inline" id="div-receiveUser">
						<input type="text" id="receiveUser" name="receiveUser" placeholder="请输入接收人编号"  value="${releaseInfo.receiveUser }" class="layui-input"/>
						<span style="color: red" id="s-receiveUser"></span>
					</div>

				</div>
			</div>
			<div class='layui-form-item'>
				<div class="layui-inline">
					<label  class="layui-form-label">发布时间:</label>
					<div class="layui-input-inline">
						<input onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" type="text"  name="releaseTime" id="releaseTime" value="${releaseInfo.releaseTimeStr}" class="form-control input-small" placeholder="请选择发布时间"/>
						<span style="color: red" id="s-releaseTime"></span>
					</div>
				</div>

				<div class="layui-inline">
					<label class="layui-form-label">发布类型</label>
					<div class="layui-input-inline">
						<select id="releaseType" name="releaseType">
							<option value="1" <c:if test="${releaseInfo.releaseType == 1}"> selected </c:if> >指定人</option>
							<option value="0" <c:if test="${releaseInfo.releaseType == 0}"> selected </c:if>>全部</option>
						</select>
						<span style="color: red" id="s-releaseType"></span>
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

				<div class="layui-inline" style="display: none;">
					<label class="layui-form-label">事件编号</label>
					<div class="layui-input-inline">
						<input type="text" id="releaseNo" name="releaseNo" placeholder="请输入事件编号"  value="${releaseInfo.releaseNo }" class="layui-input"/>
						<span style="color: red" id="s-releaseNo"></span>
					</div>
				</div>

			</div>

			<div class='layui-form-item'>
		        <label class="layui-form-label">内容</label>
				<div class="layui-input-block">
					<textarea placeholder="请输入内容" style="width: 80%;" class="layui-textarea"  id="content" name = "content" lay-verify="content">${releaseInfo.content}</textarea>
					<span style="color: red" id="s-content"></span>
				</div>
			</div>


	 		<div class="layui-input-block" style="margin-top:30px;margin-left:40%;">
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

            $("#receiveUser").combotree({
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
						$("#div-receiveUser").append("<input type='hidden' id='receiveUserCn-"+node.id+"' name='receiveUserCn-"+node.id+"' value='"+node.text+"'/>");
						//控制只能选一项，选中某一项后后面不能再勾选
						// if(nodes.length == 0){
						//     return true;
						// }else{
						//     return false;
						// }
					}else{//当前为取消选中操作
						$("#receiveUserCn-"+node.id+"").remove();
						return true;
					}
				}
			});
        });

	</script>

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
			var releaseTime = $("#releaseTime").val();
			var releaseNo = $("#releaseNo").val();
			var seq = $("#seq").val();
			var title = $("#title").val();
			var content = $("#content").val();
			var releaseUser = $('#releaseUser').val();
			var receiveUser = $('#receiveUser').combotree('getValues');
			var receiveUserCn = getValLetters("receiveUserCn-");
			var releaseType  = $("#releaseType").val();
			var requestData={
				"releaseId":releaseId,
				"releaseTimeStr":releaseTime,
				"releaseNo":releaseNo,
				"seq":seq,
				"title":title,
				"content":content,
				"releaseUser":releaseUser,
				"receiveUsers":receiveUser,
				"releaseType":releaseType,
				"receiveUserCns":receiveUserCn
			};
			updateAndAdd(requestData);
		}

</script>
</html>				 
