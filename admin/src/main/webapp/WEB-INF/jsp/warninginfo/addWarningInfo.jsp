<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
    	<meta charset="utf-8">
		<title>新增预警设置</title>
		<%@include file="/WEB-INF/jsp/decorators/addHeader.jsp" %>
	</head>
	<body>
 		<form id="saleForm" class="layui-form" style="margin-top:30px;">
 			<input  type="hidden" id="warningId" name="warningId" value="${warningInfo.warningId}"/>
			<input  type="hidden" id="releaseUser" name="releaseUser" value="${userId}"/>
			<div class='layui-form-item'>
				<div class="layui-inline">
					<label class="layui-form-label">标题</label>
					<div class="layui-input-inline">
						<input type="text" id="title" name="title" placeholder="请输入标题"  value="${warningInfo.title }" class="layui-input"/>
						<span style="color: red" id="s-title"></span>
					</div>
				</div>

     			<div class="layui-inline">
		        	<label class="layui-form-label">排序号</label>
		        	<div class="layui-input-inline">
		        		<input type="number" id="seq" name="seq" placeholder="请输入排序号"  value="${warningInfo.seq }" class="layui-input"/>
		        		<span style="color: red" id="s-seq"></span>
		     		</div>
     			</div>

			</div>
			<div class='layui-form-item'>
		        <label class="layui-form-label">内容</label>
				<div class="layui-input-block">
					<textarea placeholder="请输入内容" style="width: 90%;" class="layui-textarea"  id="content" name = "content" lay-verify="content">${warningInfo.content}</textarea>
					<span style="color: red" id="s-content"></span>
				</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">发布人编号</label>
		        	<div class="layui-input-inline">
						<input type="text" id="releaseUserName" name="releaseUserName" placeholder="请输入发布人编号"  value="${userName}" class="layui-input" readonly/>
		        		<span style="color: red" id="s-releaseUser"></span>
		     		</div>
     			</div>
     			<div class="layui-inline" id="div-receiveUser">
		        	<label class="layui-form-label">接收人编号</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="receiveUser" name="receiveUser" placeholder="请输入接收人编号"  value="${warningInfo.receiveUser }" class="layui-input"/>
		        		<span style="color: red" id="s-receiveUser"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item' >
     			<div class="layui-inline">
		        	<label class="layui-form-label">对象属性</label>
		        	<div class="layui-input-inline">
						<select id="options" name="options" lay-filter="option">
							<option value="1" <c:if test="${warningInfo.options == 1}"> selected </c:if> >流程</option>
							<option value="2" <c:if test="${warningInfo.options == 2}"> selected </c:if>>材料</option>
						</select>
		        		<span style="color: red" id="s-options"></span>
		     		</div>
     			</div>
     			<div class="layui-inline" id="div-true_val" style="display: none;">
		        	<label class="layui-form-label">值</label>
		        	<div class="layui-input-inline" id="">
		        		<input type="text" id="true_val" name="true_val" placeholder="请输入值"  value="${warningInfo.true_val }" class="layui-input"/>
		        		<span style="color: red" id="s-true_val"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">条件</label>
					<div class="layui-input-inline">
					<select name="checkCondition" id="checkCondition">
					<option value="">请选择</option>
					<option value="1" <c:if test="${warningInfo.checkCondition== 1 }">selected</c:if> >大</option>
					<option value="2" <c:if test="${warningInfo.checkCondition== 2 }">selected</c:if>>小</option>
					<option value="3" <c:if test="${warningInfo.checkCondition== 3 }">selected</c:if>>等</option>
					<option value="4" <c:if test="${warningInfo.checkCondition== 4 }">selected</c:if>>不大</option>
					<option value="5" <c:if test="${warningInfo.checkCondition== 5 }">selected</c:if>>不小</option>
					<option value="6" <c:if test="${warningInfo.checkCondition== 6 }">selected</c:if>>不等于</option>
					</select>
					</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">预警值</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="warn_val" name="warn_val" placeholder="请输入预警值"  value="${warningInfo.warn_val }" class="layui-input" onkeyup="javascript:CheckInputIntFloat(this);"/>
		        		<span style="color: red" id="s-warn_val"></span>
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

        $(function () {
            if("${warningInfo.options}" == 2){
                $("#div-true_val").show();
            }else {
                $("#div-true_val").hide();
            }

			$("#true_val").combotree({
				 url: '/admin/repertory/repertoryTree',
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
                url: '/admin/staffInfo/staffInfoTree',
                // multiple : true,//设置可以多选，显示多选框，不设置不会出现多选框
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
                        //控制只能选一项，选中某一项后后面不能再勾选
                        if(nodes.length == 0){
                            return true;
                        }else{
                            return false;
                        }
                    }else{//当前为取消选中操作
                        $("#receiveUserCn-"+node.id+"").remove();
                        return true;
                    }
                }
            });
        });

	</script>

	<script type="text/javascript">
		var reqUpdateAndAddUrl = "/admin/warningInfo/insertAndUpdate";
	</script>

	<script type="text/javascript">
        function CheckInputIntFloat(oInput) {
            if('' != oInput.value.replace(/\d{1,}\.{0,1}\d{0,}/,'')) {
                oInput.value = oInput.value.match(/\d{1,}\.{0,1}\d{0,}/) == null ? '' :oInput.value.match(/\d{1,}\.{0,1}\d{0,}/);
            }
        }

		//提交表单数据
		layui.use(['form', 'jquery', 'layedit', 'laydate'], function(){
			  var $ = layui.jquery;
			  var form = layui.form();
			  var layer = layui.layer;
			  var layedit = layui.layedit;
			  var laydate = layui.laydate;
			  form.verify({
			  });

            form.on('select(option)', function(data){
                if(data.value == 1){
                    $("#div-true_val").hide();

				}else if(data.value == 2){
                    $("#div-true_val").show();
				}else {
                    $("#div-true_val").hide();
				}
                console.log(data);
                console.log(data.value);
            });
		});

	
	function saveData() {
	    var warningId = $("#warningId").val();
	    var seq = $("#seq").val();
	    var title = $("#title").val();
	    var content = $("#content").val();
	    var releaseUser = $("#releaseUser").val();
        var receiveUser = $('#receiveUser').combotree('getValues');
	    var options = $("#options").val();
	    var true_val = $("#true_val").val();
	    var checkCondition = $("#checkCondition").val();
	    var warn_val = $("#warn_val").val();

        var requestData={
            "warningId":warningId,
            "seq":seq,
            "title":title,
            "content":content,
            "releaseUser":releaseUser,
            "receiveUsers":receiveUser,
            "options":options,
            "true_val":true_val,
            "checkCondition":checkCondition,
            "warn_val":warn_val
        };
        updateAndAdd(requestData);
    }
	
</script>
</html>				 
