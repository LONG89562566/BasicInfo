<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
    	<meta charset="utf-8">
		<title>入库</title>
		<%@include file="/WEB-INF/jsp/decorators/addHeader.jsp" %>
	</head>
	<body>
 		<form id="saleForm" class="layui-form" style="margin-top:30px;">
 			<input  type="hidden" id="materialDetailId" name="materialDetailId" value="${materialDetail.materialDetailId}"/>
 			<input  type="hidden" id="projectId" name="projectId" value="${projectId}"/>

			<div class="layui-form-item" >
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">出入库选择:</label>
		        	<div class="layui-input-inline">
						<select name="materialType" id="materialType" class="layui-input">
							<option value="1" <c:if test="${materialDetail.materialType == 1 }">selected</c:if>>入库</option>
						</select>
		        		<span style="color: red" id="s-materialType"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">物品</label>
					<div class="layui-input-inline">

						<select name="materialName" id="materialName" class="layui-input" lay-filter="materialName">
							<option value="">请选择</option>
							<c:forEach items="${materialList}" var="r">
							<option value="${r.materialName}">${r.materialName}</option>
							</c:forEach>
						</select>
					</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">出入库数量</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="num" name="num" placeholder="请输入出入库数量"  value="${materialDetail.num }" class="layui-input"/>
		        		<span style="color: red" id="s-num"></span>
		     		</div>
     			</div>
			</div>
	 		</div>
  		</form>
	</body>

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
	
	var getData = function() {
	    var materialDetailId = $("#materialDetailId").val();
	    var createTime = $("#createTime").val();
	    var materialType = $("#materialType").val();
	    var materialName = $("#materialName").val();
	    var num = $("#num").val();
	    var projectId = $("#projectId").val();

        var requestData={
            "materialDetailId":materialDetailId,
            "createTimeStr":createTime,
            "materialType":materialType,
            "materialName":materialName,
            "num":num,
            "projectId":projectId
        };
        return requestData;
    }


</script>
</html>				 
