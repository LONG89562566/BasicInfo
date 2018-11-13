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
     		<div class="layui-form-item" >
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label  class="layui-form-label">创建时间:</label>
	            	<div class="layui-input-inline">
		            	<input onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" type="text"  name="createTime" id="createTime" value="${staffInfo.createTimeStr}" class="form-control input-small" placeholder="请选择创建时间"/>
		            	<span style="color: red" id="s-createTime"></span>
		        	</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">创建人编号</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="createUser" name="createUser" placeholder="请输入创建人编号"  value="${staffInfo.createUser }" class="layui-input"/>
		        		<span style="color: red" id="s-createUser"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">删除标记</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="deleteFlag" name="deleteFlag" placeholder="请输入删除标记"  value="${staffInfo.deleteFlag }" class="layui-input"/>
		        		<span style="color: red" id="s-deleteFlag"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label  class="layui-form-label">修改时间:</label>
	            	<div class="layui-input-inline">
		            	<input onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" type="text"  name="updateTime" id="updateTime" value="${staffInfo.updateTimeStr}" class="form-control input-small" placeholder="请选择修改时间"/>
		            	<span style="color: red" id="s-updateTime"></span>
		        	</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">排序号</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="seq" name="seq" placeholder="请输入排序号"  value="${staffInfo.seq }" class="layui-input"/>
		        		<span style="color: red" id="s-seq"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">机构编号</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="orgId" name="orgId" placeholder="请输入机构编号"  value="${staffInfo.orgId }" class="layui-input"/>
		        		<span style="color: red" id="s-orgId"></span>
		     		</div>
     			</div>
			</div>
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
		        		<input type="text" id="sex" name="sex" placeholder="请输入性别"  value="${staffInfo.sex }" class="layui-input"/>
		        		<span style="color: red" id="s-sex"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">籍贯</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="native" name="native" placeholder="请输入籍贯"  value="${staffInfo.native }" class="layui-input"/>
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

	 		</div>
	 		<div class="layui-input-block" style="margin-top:30px;margin-left:324px;">
	 			<input type="button" class="layui-btn" onclick="saveData()" value="确定"/>
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
	    var staffId = $("#staffId").val();
	    var createTime = $("#createTime").val();
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
            "createTimeStr":createTime,
            "createUser":createUser,
            "deleteFlag":deleteFlag,
            "updateTimeStr":updateTime,
            "seq":seq,
            "orgId":orgId,
            "name":name,
            "sex":sex,
            "native":native,
            "nation":nation,
            "IdCard":IdCard,
            "address":address,
            "phone":phone,
            "position":position
        };
        updateAndAdd(requestData);
    }
	
</script>
</html>				 
