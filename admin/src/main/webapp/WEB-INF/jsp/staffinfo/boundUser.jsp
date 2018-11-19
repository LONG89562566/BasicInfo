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
 			<input  type="hidden" id="staffId" name="staffId" value="${staffId}"/>
 			<input  type="hidden" id="boundUserId" name="boundUserId" value="${boundUserId}"/>
			<div class='layui-form-item'>
				<div class="layui-inline">
					<label class="layui-form-label">选择绑定人</label>
					<div class="layui-input-inline">
						<input type="text" id="boundUser" name="boundUser" placeholder="请输选择绑定"  value="" class="layui-input"/>
						<span style="color: red" id="s-releaseUser"></span>
					</div>
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
            $("#boundUser").combotree({
                url: '/admin/sysUser/getUserTreeNoBound',
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
                        $("#boundUserId").val("");
						return true;
					}
				}
			});

        });

	</script>

	<script type="text/javascript">
		var reqUpdateAndAddUrl = "/admin/staffInfo/saveBoundUser";
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
            var boundUser = $('#boundUser').combotree('getValues');
            if(boundUser.length > 0){
                boundUser = boundUser[0];
			}
			var staffId = $("#staffId").val();
			if(boundUser == "" || boundUser.length == 0){
                $.messager.alert({
                    title:'消息',
					msg:'请选择绑定人！',
					icon:'info'
				});
                return ;
			}

			var requestData={
				"staffId":staffId,
				"boundUserId":boundUser
			};
			updateAndAdd(requestData);
		}

		//id开头的input 标签
        var getVals = function (lableId) {
            var input = $("input[id^='"+lableId+"']");
            var vals = new Array();
            $(input).each(function (i,n) {
                vals.push($(n).val());
            });
            return vals;
        };


</script>
</html>				 
