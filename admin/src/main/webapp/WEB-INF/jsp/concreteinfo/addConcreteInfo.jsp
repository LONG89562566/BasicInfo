<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
    	<meta charset="utf-8">
		<title>新增混泥土信息</title>
		<%@include file="/WEB-INF/jsp/decorators/addHeader.jsp" %>
	</head>
	<body>
 		<form id="saleForm" class="layui-form" style="margin-top:30px;">
 			<input  type="hidden" id="concreteId" name="concreteId" value="${concreteInfo.concreteId}"/>
 			<input  type="hidden" id="projectId" name="projectId" value="${projectId}"/>
     		<div class="layui-form-item" >
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">混泥土别名</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="name" name="name" placeholder="请输入混泥土别名"  value="${concreteInfo.name }" class="layui-input"/>
		        		<span style="color: red" id="s-name"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">混泥土等级</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="level" name="level" placeholder="请输入混泥土等级"  value="${concreteInfo.level }" class="layui-input"/>
		        		<span style="color: red" id="s-level"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">配合比编号</label>
					<div class="layui-input-inline">
						<select id="proportionId" name="proportionId"  lay-filter="proportionId">
							<option value="">请选择配合比</option>
							<c:forEach items="${proportionsList}" var="r">
								<option value="${r.proportionsId }" <c:if test="${r.proportionsId==concreteInfo.proportionId }">selected</c:if> >${r.name }</option>
							</c:forEach>
						</select>
					</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">混泥土方量</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="square" name="square" placeholder="请输入混泥土方量"  value="${concreteInfo.square }" class="layui-input"/>
		        		<span style="color: red" id="s-square"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">总材料用量</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="totalUse" name="totalUse" placeholder="请输入总材料用量"  value="${concreteInfo.totalUse }" class="layui-input"/>
		        		<span style="color: red" id="s-totalUse"></span>
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
		var reqUpdateAndAddUrl = "/admin/concreteInfo/insertAndUpdate";
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
	    var concreteId = $("#concreteId").val();
	    var projectId = $("#projectId").val();
	    var name = $("#name").val();
	    var level = $("#level").val();
	    var proportionId = $("#proportionId").val();
	    var square = $("#square").val();
	    var totalUse = $("#totalUse").val();

        var requestData={
            "concreteId":concreteId,
            "projectId":projectId,
            "name":name,
            "level":level,
            "proportionId":proportionId,
            "square":square,
            "totalUse":totalUse
        };
        updateAndAdd(requestData);
    }
	
</script>
</html>				 
