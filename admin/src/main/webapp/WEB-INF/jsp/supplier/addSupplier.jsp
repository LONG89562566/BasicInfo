<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
    	<meta charset="utf-8">
		<title>新增供应商</title>
		<%@include file="/WEB-INF/jsp/decorators/addHeader.jsp" %>
	</head>
	<body>
 		<form id="saleForm" class="layui-form" style="margin-top:30px;">
 			<input  type="hidden" id="supplierId" name="supplierId" value="${supplier.supplierId}"/>
 			<input  type="hidden" id="projectId" name="projectId" value="${projectId}"/>
     		<div class="layui-form-item" >
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">排序号</label>
		        	<div class="layui-input-inline">
		        		<input type="number" id="seq" name="seq" placeholder="请输入排序号"  value="${supplier.seq }" class="layui-input"/>
		        		<span style="color: red" id="s-seq"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">供方全称</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="supperName" name="supperName" placeholder="请输入供方全称"  value="${supplier.supperName }" class="layui-input"/>
		        		<span style="color: red" id="s-supperName"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">法人代表</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="representative" name="representative" placeholder="请输入法人代表"  value="${supplier.representative }" class="layui-input"/>
		        		<span style="color: red" id="s-representative"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
		        <label class="layui-form-label">地址</label>
				<div class="layui-input-block">
					<textarea placeholder="请输入地址" style="width: 90%;" class="layui-textarea"  id="address" name = "address" lay-verify="content">${supplier.address}</textarea>
					<span style="color: red" id="s-address"></span>
				</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">企业性质</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="nature" name="nature" placeholder="请输入企业性质"  value="${supplier.nature }" class="layui-input"/>
		        		<span style="color: red" id="s-nature"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">营业执照号</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="license" name="license" placeholder="请输入营业执照号"  value="${supplier.license }" class="layui-input"/>
		        		<span style="color: red" id="s-license"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">税务登记编号</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="registration" name="registration" placeholder="请输入税务登记编号"  value="${supplier.registration }" class="layui-input"/>
		        		<span style="color: red" id="s-registration"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">联系人</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="contacts" name="contacts" placeholder="请输入联系人"  value="${supplier.contacts }" class="layui-input"/>
		        		<span style="color: red" id="s-contacts"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">联系电话</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="phone" name="phone" placeholder="请输入联系电话"  value="${supplier.phone }" class="layui-input"/>
		        		<span style="color: red" id="s-phone"></span>
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
		var reqUpdateAndAddUrl = "/admin/supplier/insertAndUpdate";
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
	    var projectId = $("#projectId").val();
	    var supperName = $("#supperName").val();
	    var representative = $("#representative").val();
	    var address = $("#address").val();
	    var nature = $("#nature").val();
	    var license = $("#license").val();
	    var registration = $("#registration").val();
	    var contacts = $("#contacts").val();
	    var phone = $("#phone").val();

        var requestData={
            "supplierId":supplierId,
            "seq":seq,
            "projectId":projectId,
            "supperName":supperName,
            "representative":representative,
            "address":address,
            "nature":nature,
            "license":license,
            "registration":registration,
            "contacts":contacts,
            "phone":phone
        };
        updateAndAdd(requestData);
    }
	
</script>
</html>				 
