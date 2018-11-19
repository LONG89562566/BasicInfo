<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
    	<meta charset="utf-8">
		<title>新增信息发布</title>
		<%@include file="/WEB-INF/jsp/decorators/addHeader.jsp" %>
		<style>
			input[readonly]{
				background-color: #efefef;
			}
		</style>
	</head>
	<body>
 		<form id="saleForm" class="layui-form" style="margin-top:30px;">
 			<input  type="hidden" id="releaseId" name="releaseId" value="${releaseInfo.releaseId}"/>

			<div class='layui-form-item'>
				<label class="layui-form-label">标题</label>
				<div class="layui-input-block">
					<input type="text" id="title"  style="width: 80%;" name="title"  value="${releaseInfo.title }" class="layui-input" disabled/>
				</div>
			</div>
			<div class='layui-form-item'>
				<div class="layui-inline">
					<label class="layui-form-label">发布人</label>
					<div class="layui-input-inline">
						<input type="text" id="releaseUser" name="releaseUser"  value="${releaseInfo.releaseUser }" class="layui-input" disabled/>
					</div>
				</div>

				<div class="layui-inline">
					<label  class="layui-form-label">发布时间:</label>
					<div class="layui-input-inline">
						<input type="text" id="releaseTime" name="releaseTime"   value="${releaseInfo.releaseTimeStr }" class="layui-input" disabled/>
					</div>
				</div>

			</div>

			<div class='layui-form-item'>
		        <label class="layui-form-label">内容</label>
				<div class="layui-input-block">
					<textarea  style="width: 80%;" class="layui-textarea"  id="content" name = "content" lay-verify="content" disabled>${releaseInfo.content}</textarea>
					<span style="color: red" id="s-content"></span>
				</div>
			</div>

	 		<div class="layui-input-block" style="margin-top:30px;margin-left:40%;">
       			<button class="layui-btn" name="cancleSubmit" >取消</button>
     		</div>
  		</form>
	</body>
	<script type="text/javascript">

		$(function () {
            $("#releaseUser").combotree({
                url: '/admin/sysUser/getUserTree',
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
			});

            $("#receiveUser").combotree({
                url: '/admin/sysUser/getUserTree',
                multiple : true,//设置可以多选，显示多选框，不设置不会出现多选框
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
						$("#div-receiveUser").append("<input type='hidden' id='receiveUserCn-"+node.id+"' name='receiveUserCn-"+node.id+"' value='"+node.name+"'/>");
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

</script>
</html>				 
