<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
    	<meta charset="utf-8">
		<title>新增操作人员</title>
		<%@include file="/WEB-INF/jsp/decorators/addHeader.jsp" %>
	</head>
	<body>
 		<form id="saleForm" class="layui-form" style="margin-top:30px;">
 			<input  type="hidden" id="repairId" name="repairId" value="${repairInfo.repairId}"/>
 			<input  type="hidden" id="equipmentId" name="equipmentId" value=""/>
            <jsp:include page="/WEB-INF/jsp/flow/flowPage.jsp">
                <jsp:param name="docUnid" value="${repairInfo.repairId}" />
            </jsp:include>
     		<div class="layui-form-item" >
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">排序号</label>
		        	<div class="layui-input-inline">
		        		<input type="number" id="seq" name="seq" placeholder="请输入排序号"  value="${repairInfo.seq }" class="layui-input"/>
		        		<span style="color: red" id="s-seq"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">维修人员</label>
		        	<div class="layui-input-inline" id="div-repairUserCn">
		        		<input type="text" id="repairUser" name="repairUser" placeholder="请选择维修人员"  value="${repairInfo.repairUser }" class="layui-input"/>
		        		<span style="color: red" id="s-repairUser"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label  class="layui-form-label">维修时间:</label>
	            	<div class="layui-input-inline">
		            	<input onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" type="text"  name="repairTime" id="repairTime" value="${repairInfo.repairTimeStr}" class="form-control input-small" placeholder="请选择维修时间"/>
		            	<span style="color: red" id="s-repairTime"></span>
		        	</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">维修费用</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="amount" name="amount" placeholder="请输入维修费用"  value="${repairInfo.amount }" class="layui-input"/>
		        		<span style="color: red" id="s-amount"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
		        <label class="layui-form-label">备注</label>
				<div class="layui-input-block">
					<textarea placeholder="请输入备注" style="width: 90%;" class="layui-textarea"  id="remark" name = "remark" lay-verify="content">${repairInfo.remark}</textarea>
					<span style="color: red" id="s-remark"></span>
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
		var reqUpdateAndAddUrl = "/admin/repairInfo/insertAndUpdate";
	</script>

	<script type="text/javascript">
        $("#repairUser").combotree({
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
                    $("#div-repairUserCn").append("<input type='hidden' id='repairUserCn-"+node.id+"' name='repairUserCn-"+node.id+"' value='"+node.text+"'/>");
                }else{//当前为取消选中操作
                    $("#repairUserCn-"+node.id+"").remove();
                    return true;
                }
            }
        });
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
	    var repairId = $("#repairId").val();
	    var seq = $("#seq").val();
	    var repairUser = $("#repairUser").combotree('getValues');
	    var repairTime = $("#repairTime").val();
	    var amount = $("#amount").val();
	    var remark = $("#remark").val();
		var equipmentId =$("#equipmentId").val();
		var repairUserCn = getValLetters("repairUserCn-");
        var requestData={
            "repairId":repairId,
            "seq":seq,
            "repairUsers":repairUser,
            "repairTimeStr":repairTime,
            "amount":amount,
            "remark":remark,
			"equipmentId":equipmentId,
            "repairUserCns":repairUserCn
        };
        updateAndAdd(requestData);
    }
	
</script>
</html>				 
