<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
    	<meta charset="utf-8">
		<title>新增仓库</title>
		<%@include file="/WEB-INF/jsp/decorators/addHeader.jsp" %>
	</head>
	<body>
 		<form id="saleForm" class="layui-form" style="margin-top:30px;">
 			<input  type="hidden" id="repertoryId" name="repertoryId" value="${repertory.repertoryId}"/>
			<input  type="hidden" id="projectId" name="projectId" value="${projectId}"/>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">排序号</label>
		        	<div class="layui-input-inline">
		        		<input type="number" id="seq" name="seq" placeholder="请输入排序号"  value="${repertory.seq }" class="layui-input"/>
		        		<span style="color: red" id="s-seq"></span>
		     		</div>
     			</div>

			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">材料名称</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="materialName" name="materialName" placeholder="请输入材料名称"  value="${repertory.materialName }" class="layui-input"/>
		        		<span style="color: red" id="s-materialName"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">规格型号</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="model" name="model" placeholder="请输入规格型号"  value="${repertory.model }" class="layui-input"/>
		        		<span style="color: red" id="s-model"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">计量单位</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="unit" name="unit" placeholder="请输入计量单位"  value="${repertory.unit }" class="layui-input"/>
		        		<span style="color: red" id="s-unit"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">库存数量</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="num" name="num" placeholder="请输入库存数量"  value="${repertory.num }" class="layui-input"/>
		        		<span style="color: red" id="s-num"></span>
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
		var reqUpdateAndAddUrl = "/admin/repertory/insertAndUpdate";
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
	    var repertoryId = $("#repertoryId").val();
	    var createTime = $("#createTime").val();
	    var createUser = $("#createUser").val();
	    var deleteFlag = $("#deleteFlag").val();
	    var updateTime = $("#updateTime").val();
	    var seq = $("#seq").val();
	    var projectId = $("#projectId").val();
	    var materialName = $("#materialName").val();
	    var model = $("#model").val();
	    var unit = $("#unit").val();
	    var num = $("#num").val();

        var requestData={
            "repertoryId":repertoryId,
            "createTimeStr":createTime,
            "createUser":createUser,
            "deleteFlag":deleteFlag,
            "updateTimeStr":updateTime,
            "seq":seq,
            "projectId":projectId,
            "materialName":materialName,
            "model":model,
            "unit":unit,
            "num":num
        };
        updateAndAdd(requestData);
    }
	
</script>
</html>				 
