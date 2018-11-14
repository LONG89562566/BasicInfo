<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
    	<meta charset="utf-8">
		<title>新增梁段信息</title>
		<%@include file="/WEB-INF/jsp/decorators/addHeader.jsp" %>
	</head>
	<body>
 		<form id="saleForm" class="layui-form" style="margin-top:30px;">
 			<input  type="hidden" id="sectionId" name="sectionId" value="${beamSection.sectionId}"/>
     		<div class="layui-form-item" >
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label  class="layui-form-label">创建时间:</label>
	            	<div class="layui-input-inline">
		            	<input onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" type="text"  name="createTime" id="createTime" value="${beamSection.createTimeStr}" class="form-control input-small" placeholder="请选择创建时间"/>
		            	<span style="color: red" id="s-createTime"></span>
		        	</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">创建人编号</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="createUser" name="createUser" placeholder="请输入创建人编号"  value="${beamSection.createUser }" class="layui-input"/>
		        		<span style="color: red" id="s-createUser"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">删除标记</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="deleteFlag" name="deleteFlag" placeholder="请输入删除标记"  value="${beamSection.deleteFlag }" class="layui-input"/>
		        		<span style="color: red" id="s-deleteFlag"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label  class="layui-form-label">修改时间:</label>
	            	<div class="layui-input-inline">
		            	<input onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" type="text"  name="updateTime" id="updateTime" value="${beamSection.updateTimeStr}" class="form-control input-small" placeholder="请选择修改时间"/>
		            	<span style="color: red" id="s-updateTime"></span>
		        	</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">排序号</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="seq" name="seq" placeholder="请输入排序号"  value="${beamSection.seq }" class="layui-input"/>
		        		<span style="color: red" id="s-seq"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">类型</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="type" name="type" placeholder="请输入类型"  value="${beamSection.type }" class="layui-input"/>
		        		<span style="color: red" id="s-type"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
		        <label class="layui-form-label">拟架部位</label>
				<div class="layui-input-block">
					<textarea placeholder="请输入拟架部位" style="width: 90%;" class="layui-textarea"  id="frame" name = "frame" lay-verify="content">${beamSection.frame}</textarea>
					<span style="color: red" id="s-frame"></span>
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
		var reqUpdateAndAddUrl = "/admin/beamSection/insertAndUpdate";
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
	    var sectionId = $("#sectionId").val();
	    var createTime = $("#createTime").val();
	    var createUser = $("#createUser").val();
	    var deleteFlag = $("#deleteFlag").val();
	    var updateTime = $("#updateTime").val();
	    var seq = $("#seq").val();
	    var type = $("#type").val();
	    var frame = $("#frame").val();

        var requestData={
            "sectionId":sectionId,
            "createTimeStr":createTime,
            "createUser":createUser,
            "deleteFlag":deleteFlag,
            "updateTimeStr":updateTime,
            "seq":seq,
            "type":type,
            "frame":frame
        };
        updateAndAdd(requestData);
    }
	
</script>
</html>				 
