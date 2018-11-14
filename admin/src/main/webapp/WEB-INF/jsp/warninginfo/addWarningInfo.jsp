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
     		<div class="layui-form-item" >
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label  class="layui-form-label">创建时间:</label>
	            	<div class="layui-input-inline">
		            	<input onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" type="text"  name="createTime" id="createTime" value="${warningInfo.createTimeStr}" class="form-control input-small" placeholder="请选择创建时间"/>
		            	<span style="color: red" id="s-createTime"></span>
		        	</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">创建人编号</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="createUser" name="createUser" placeholder="请输入创建人编号"  value="${warningInfo.createUser }" class="layui-input"/>
		        		<span style="color: red" id="s-createUser"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">删除标记</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="deleteFlag" name="deleteFlag" placeholder="请输入删除标记"  value="${warningInfo.deleteFlag }" class="layui-input"/>
		        		<span style="color: red" id="s-deleteFlag"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label  class="layui-form-label">修改时间:</label>
	            	<div class="layui-input-inline">
		            	<input onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" type="text"  name="updateTime" id="updateTime" value="${warningInfo.updateTimeStr}" class="form-control input-small" placeholder="请选择修改时间"/>
		            	<span style="color: red" id="s-updateTime"></span>
		        	</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">排序号</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="seq" name="seq" placeholder="请输入排序号"  value="${warningInfo.seq }" class="layui-input"/>
		        		<span style="color: red" id="s-seq"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">标题</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="title" name="title" placeholder="请输入标题"  value="${warningInfo.title }" class="layui-input"/>
		        		<span style="color: red" id="s-title"></span>
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
		        		<input type="text" id="releaseUser" name="releaseUser" placeholder="请输入发布人编号"  value="${warningInfo.releaseUser }" class="layui-input"/>
		        		<span style="color: red" id="s-releaseUser"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">接收人编号</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="receiveUser" name="receiveUser" placeholder="请输入接收人编号"  value="${warningInfo.receiveUser }" class="layui-input"/>
		        		<span style="color: red" id="s-receiveUser"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">对象属性</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="options" name="options" placeholder="请输入对象属性"  value="${warningInfo.options }" class="layui-input"/>
		        		<span style="color: red" id="s-options"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">值</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="true_val" name="true_val" placeholder="请输入值"  value="${warningInfo.true_val }" class="layui-input"/>
		        		<span style="color: red" id="s-true_val"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">（大/小/等/不大/不小/不等于）</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="condition" name="condition" placeholder="请输入（大/小/等/不大/不小/不等于）"  value="${warningInfo.condition }" class="layui-input"/>
		        		<span style="color: red" id="s-condition"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">预警值</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="warn_val" name="warn_val" placeholder="请输入预警值"  value="${warningInfo.warn_val }" class="layui-input"/>
		        		<span style="color: red" id="s-warn_val"></span>
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
		var reqUpdateAndAddUrl = "/admin/warningInfo/insertAndUpdate";
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
	    var warningId = $("#warningId").val();
	    var createTime = $("#createTime").val();
	    var createUser = $("#createUser").val();
	    var deleteFlag = $("#deleteFlag").val();
	    var updateTime = $("#updateTime").val();
	    var seq = $("#seq").val();
	    var title = $("#title").val();
	    var content = $("#content").val();
	    var releaseUser = $("#releaseUser").val();
	    var receiveUser = $("#receiveUser").val();
	    var options = $("#options").val();
	    var true_val = $("#true_val").val();
	    var condition = $("#condition").val();
	    var warn_val = $("#warn_val").val();

        var requestData={
            "warningId":warningId,
            "createTimeStr":createTime,
            "createUser":createUser,
            "deleteFlag":deleteFlag,
            "updateTimeStr":updateTime,
            "seq":seq,
            "title":title,
            "content":content,
            "releaseUser":releaseUser,
            "receiveUser":receiveUser,
            "options":options,
            "true_val":true_val,
            "condition":condition,
            "warn_val":warn_val
        };
        updateAndAdd(requestData);
    }
	
</script>
</html>				 
