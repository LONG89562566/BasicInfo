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
			<input  type="hidden" id="projectId" name="projectId" value="${beamSection.projectId}"/>

            <jsp:include page="/WEB-INF/jsp/flow/flowPage.jsp">
                <jsp:param name="docUnid" value="${beamSection.sectionId}" />
            </jsp:include>

     		<div class="layui-form-item" >
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">排序号</label>
		        	<div class="layui-input-inline">
		        		<input type="number" id="seq" name="seq" placeholder="请输入排序号"  value="${beamSection.seq }" class="layui-input"/>
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
                <div class="layui-inline">
                    <label class="layui-form-label">梁体名称</label>
                    <div class="layui-input-inline">
                        <input type="text" id="name" name="name" placeholder="请输入梁体名称"  value="${beamSection.name }" class="layui-input"/>
                        <span style="color: red" id="s-name"></span>
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
        sectionId = sectionId == '' ? '${uuid}' : sectionId;
	    var seq = $("#seq").val();
	    var type = $("#type").val();
	    var frame = $("#frame").val();
        var name = $("#name").val();
        var projectId = $("#projectId").val();

        var requestData={
            fn : '${fn}',
            "sectionId":sectionId,
            "seq":seq,
            "type":type,
            "frame":frame,
            "projectId":projectId,
            "name":name
        };
        updateAndAdd(requestData);
    }
	
</script>
</html>				 
