<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
    	<meta charset="utf-8">
		<title>新增问题库</title>
		<%@include file="/WEB-INF/jsp/decorators/addHeader.jsp" %>
	</head>
	<body>
 		<form id="saleForm" class="layui-form" style="margin-top:30px;">
 			<input  type="hidden" id="supplierId" name="supplierId" value="${problemLibrary.supplierId}"/>
			<jsp:include page="/WEB-INF/jsp/flow/flowPage.jsp">
				<jsp:param name="docUnid" value="${problemLibrary.supplierId}" />
			</jsp:include>
			<div class='layui-form-item'>
				<label class="layui-form-label">标题</label>
				<div class="layui-input-block">
					<input type="text" id="title" name="title" style="width: 80%;" placeholder="请输入标题"  value="${problemLibrary.title }" class="layui-input"/>
					<span style="color: red" id="s-title"></span>
				</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">问题类型</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="type" name="type" placeholder="请输入问题类型"  value="${problemLibrary.type }" class="layui-input"/>
		        		<span style="color: red" id="s-type"></span>
		     		</div>
     			</div>
				<div class="layui-inline">
					<label class="layui-form-label">排序号</label>
					<div class="layui-input-inline">
						<input type="number" id="seq" name="seq" placeholder="请输入排序号"  value="${problemLibrary.seq }" class="layui-input"/>
						<span style="color: red" id="s-seq"></span>
					</div>
				</div>
			</div>
			<div class='layui-form-item'>
		        <label class="layui-form-label">检查内容</label>
				<div class="layui-input-block">
					<textarea placeholder="请输入检查内容" style="width: 80%;" class="layui-textarea"  id="inspectContent" name = "inspectContent" lay-verify="content">${problemLibrary.inspectContent}</textarea>
					<span style="color: red" id="s-inspectContent"></span>
				</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">检查人编号</label>
		        	<div class="layui-input-inline" id="div-inspectUser">
		        		<input type="text" id="inspectUser" name="inspectUser" placeholder="请输入检查人编号"  value="${problemLibrary.inspectUser }" class="layui-input"/>
		        		<span style="color: red" id="s-inspectUser"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">整改人编号</label>
		        	<div class="layui-input-inline" id="div-rectifyUser">
		        		<input type="text" id="rectifyUser" name="rectifyUser" placeholder="请输入整改人编号"  value="${problemLibrary.rectifyUser }" class="layui-input"/>
		        		<span style="color: red" id="s-rectifyUser"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label  class="layui-form-label">整改时间:</label>
	            	<div class="layui-input-inline">
		            	<input onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" type="text"  name="rectifyTime" id="rectifyTime" value="${problemLibrary.rectifyTimeStr}" class="form-control input-small" placeholder="请选择整改时间"/>
		            	<span style="color: red" id="s-rectifyTime"></span>
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
			 $("#inspectUser").combotree({
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
                         $("#div-inspectUser").append("<input type='hidden' id='inspectUser-"+node.id+"' name='inspectUser-"+node.id+"' value='"+node.text+"'/>");
						 //控制只能选一项，选中某一项后后面不能再勾选
						 if(nodes.length == 0){
							 return true;
						 }else{
							 return false;
						 }
					 }else{//当前为取消选中操作
                         $("#inspectUser-"+node.id+"").remove();
						 return true;
					 }
				 }
			 });

            $("#rectifyUser").combotree({
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
                        $("#div-rectifyUser").append("<input type='hidden' id='rectifyUser-"+node.id+"' name='rectifyUser-"+node.id+"' value='"+node.text+"'/>");
                        //控制只能选一项，选中某一项后后面不能再勾选
                        if(nodes.length == 0){
                            return true;
                        }else{
                            return false;
                        }
                    }else{//当前为取消选中操作
                        $("#rectifyUser-"+node.id+"").remove();
                        return true;
                    }
                }
            });
        });

	</script>

	<script type="text/javascript">
		var reqUpdateAndAddUrl = "/admin/problemLibrary/insertAndUpdate";
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
	    var supplierId = $("#supplierId").val();
	    var seq = $("#seq").val();
	    var title = $("#title").val();
	    var type = $("#type").val();
	    var inspectContent = $("#inspectContent").val();
	    var inspectUser = $("#inspectUser").val();
	    var rectifyUser = $("#rectifyUser").val();
	    var rectifyTime = $("#rectifyTime").val();

        var inspectUsers = $('#inspectUser').combotree('getValues');
        var inspectUserCn = getValLetters("inspectUserCn-");
        var rectifyUsers = $('#rectifyUser').combotree('getValues');
        var rectifyUserCn = getValLetters("rectifyUserCn-");

        var requestData={
            "supplierId":supplierId,
            "seq":seq,
            "title":title,
            "type":type,
            "inspectContent":inspectContent,
            "inspectUsers":inspectUsers,
            "rectifyUsers":rectifyUsers,
			"inspectUser":inspectUser,
            "rectifyUser":rectifyUser,
            "rectifyTimeStr":rectifyTime
        };
        updateAndAdd(requestData);
    }


	
</script>
</html>				 
