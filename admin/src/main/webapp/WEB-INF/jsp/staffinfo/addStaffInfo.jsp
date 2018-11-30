<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
    	<meta charset="utf-8">
		<title>新增员工信息</title>
		<%@include file="/WEB-INF/jsp/decorators/addHeader.jsp" %>
	</head>
	<body>
 		<form id="saleForm" class="layui-form" style="margin-top:30px;">
 			<input  type="hidden" id="staffId" name="staffId" value="${staffInfo.staffId}"/>
 			<input  type="hidden" id="orgId" name="orgId" value="${orgId}"/>

			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">姓名</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="name" name="name" placeholder="请输入姓名"  value="${staffInfo.name }" class="layui-input"/>
		        		<span style="color: red" id="s-name"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">性别</label>
		        	<div class="layui-input-inline">
						<select id="sex" name="sex">
							<option value="1" <c:if test="${staffInfo.sex == 1}"> selected </c:if> >男</option>
							<option value="2" <c:if test="${staffInfo.sex == 2}"> selected </c:if>>女</option>
						</select>
		        		<span style="color: red" id="s-sex"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">籍贯</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="native" name="native" placeholder="请输入籍贯"  value="${staffInfo.natives }" class="layui-input"/>
		        		<span style="color: red" id="s-native"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">民族</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="nation" name="nation" placeholder="请输入民族"  value="${staffInfo.nation }" class="layui-input"/>
		        		<span style="color: red" id="s-nation"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">身份证号</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="idCard" name="idCard" placeholder="请输入身份证号"  value="${staffInfo.idCard }" class="layui-input"/>
		        		<span style="color: red" id="s-idCard"></span>
		     		</div>
     			</div>
				<div class="layui-inline">
					<label class="layui-form-label">排序号</label>
					<div class="layui-input-inline">
						<input type="number" id="seq" name="seq" placeholder="请输入排序号"  value="${staffInfo.seq }" class="layui-input"/>
						<span style="color: red" id="s-seq"></span>
					</div>
				</div>
			</div>
			<div class='layui-form-item'>
		        <label class="layui-form-label">家庭住址</label>
				<div class="layui-input-block">
					<textarea placeholder="请输入家庭住址" style="width: 90%;" class="layui-textarea"  id="address" name = "address" lay-verify="content">${staffInfo.address}</textarea>
					<span style="color: red" id="s-address"></span>
				</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">联系电话</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="phone" name="phone" placeholder="请输入联系电话"  value="${staffInfo.phone }" class="layui-input"/>
		        		<span style="color: red" id="s-phone"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">职位</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="position" name="position" placeholder="请输入职位"  value="${staffInfo.position }" class="layui-input"/>
		        		<span style="color: red" id="s-position"></span>
		     		</div>
     			</div>

	 		</div>
	 		<div class="layui-input-block" style="margin-top:30px;margin-left:324px;">
	 			<%--<input class="layui-btn" type="button"  onclick="saveData()" value="确定"/>--%>
				<button class="layui-btn" name="saveSubmit">保存</button>
       			<button class="layui-btn" name="cancleSubmit" >取消</button>
     		</div>
  		</form>
	</body>

	<script type="text/javascript">
		var reqUpdateAndAddUrl = "/admin/staffInfo/insertAndUpdate";
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
	    var requestData = getData();
	    if(requestData != false){
            updateAndAdd(requestData);
		}
    }

    function getData() {
	    var staffId = $("#staffId").val();
	    var createUser = $("#createUser").val();
	    var deleteFlag = $("#deleteFlag").val();
	    var updateTime = $("#updateTime").val();
	    var seq = $("#seq").val();
	    var orgId = $("#orgId").val();
	    var name = $("#name").val();
	    var sex = $("#sex").val();
	    var native = $("#native").val();
	    var nation = $("#nation").val();
	    var idCard = $("#idCard").val();
	    var address = $("#address").val();
	    var phone = $("#phone").val();
	    var position = $("#position").val();

        var requestData={
            "staffId":staffId,
            "createUser":createUser,
            "deleteFlag":deleteFlag,
            "updateTimeStr":updateTime,
            "seq":seq,
            "orgId":orgId,
            "name":name,
            "sex":sex,
            "natives":native,
            "nation":nation,
            "IdCard":idCard,
            "address":address,
            "phone":phone,
            "position":position
        };

        return  requestData;
    }

</script>
</html>				 
