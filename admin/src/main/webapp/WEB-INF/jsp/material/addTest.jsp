<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
    	<meta charset="utf-8">
		<title>检验流程</title>
		<%@include file="/WEB-INF/jsp/decorators/addHeader.jsp" %>
	</head>
	<body>
 		<form id="saleForm" class="layui-form" style="margin-top:30px;">
 			<input  type="hidden" id="materialId" name="materialId" value="${material.materialId}"/>
 			<input  type="hidden" id="projectId" name="projectId" value="${projectId}"/>
            <div class="layui-input-block" style="margin:30px;">
                <input type="button" class="layui-btn" onclick="addFlow()" value="发送"/>
                <input type="button" class="layui-btn" onclick="endFlow()" value="结束流程"/>
                <input type="button" class="layui-btn" onclick="queryFlow()" value="查看流程"/>
            </div>
			<div class='layui-form-item'>
				<label class="layui-form-label">试验报告单</label>
				<div class="layui-input-block">
					<textarea placeholder="请输入试验报告单" style="width: 90%;" class="layui-textarea"  id="testReport" name = "testReport" lay-verify="content">${material.testReport}</textarea>
					<span style="color: red" id="s-testReport"></span>
				</div>
			</div>
			<div class='layui-form-item'>
				<div class="layui-inline">
					<label class="layui-form-label">检验状态</label>
					<div class="layui-input-inline">
						<input type="text" id="testState" name="testState" placeholder="请输入检验状态"  value="${material.testState }" class="layui-input"/>
						<span style="color: red" id="s-testState"></span>
					</div>
				</div>
			</div>

			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">排序号</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="seq" name="seq" placeholder="请输入排序号"  value="${material.seq }" class="layui-input"/>
		        		<span style="color: red" id="s-seq"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">材料名称</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="materialName" name="materialName" placeholder="请输入材料名称"  value="${material.materialName }" class="layui-input"/>
		        		<span style="color: red" id="s-materialName"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">规格型号</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="model" name="model" placeholder="请输入规格型号"  value="${material.model }" class="layui-input"/>
		        		<span style="color: red" id="s-model"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">计量单位</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="unit" name="unit" placeholder="请输入计量单位"  value="${material.unit }" class="layui-input"/>
		        		<span style="color: red" id="s-unit"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">进场数量</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="entryNum" name="entryNum" placeholder="请输入进场数量"  value="${material.entryNum }" class="layui-input"/>
		        		<span style="color: red" id="s-entryNum"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">生产厂家</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="manufactrer" name="manufactrer" placeholder="请输入生产厂家"  value="${material.manufactrer }" class="layui-input"/>
		        		<span style="color: red" id="s-manufactrer"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">供货单位</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="supplyer" name="supplyer" placeholder="请输入供货单位"  value="${material.supplyer }" class="layui-input"/>
		        		<span style="color: red" id="s-supplyer"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
		        <label class="layui-form-label">质量证明书</label>
				<div class="layui-input-block">
					<textarea placeholder="请输入质量证明书" style="width: 90%;" class="layui-textarea"  id="certificateQuality" name = "certificateQuality" lay-verify="content">${material.certificateQuality}</textarea>
					<span style="color: red" id="s-certificateQuality"></span>
				</div>
			</div>
			<div class='layui-form-item'>
		        <label class="layui-form-label">报验委托单</label>
				<div class="layui-input-block">
					<textarea placeholder="请输入报验委托单" style="width: 90%;" class="layui-textarea"  id="inspection" name = "inspection" lay-verify="content">${material.inspection}</textarea>
					<span style="color: red" id="s-inspection"></span>
				</div>
			</div>
			<div class='layui-form-item'>
		        <label class="layui-form-label">使用部位</label>
				<div class="layui-input-block">
					<textarea placeholder="请输入使用部位" style="width: 90%;" class="layui-textarea"  id="usePart" name = "usePart" lay-verify="content">${material.usePart}</textarea>
					<span style="color: red" id="s-usePart"></span>
				</div>
			</div>
			<div class='layui-form-item'>
		        <label class="layui-form-label">存放地点</label>
				<div class="layui-input-block">
					<textarea placeholder="请输入存放地点" style="width: 90%;" class="layui-textarea"  id="storage" name = "storage" lay-verify="content">${material.storage}</textarea>
					<span style="color: red" id="s-storage"></span>
				</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">剩余数量</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="residualNum" name="residualNum" placeholder="请输入剩余数量"  value="${material.residualNum }" class="layui-input"/>
		        		<span style="color: red" id="s-residualNum"></span>
		     		</div>
     			</div>
			</div>


  		</form>
	</body>

	<script type="text/javascript">
		var reqUpdateAndAddUrl = "/admin/material/insertAndUpdate";
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

    var getData = function () {
        var materialId = $("#materialId").val();
        var createTime = $("#createTime").val();
        var createUser = $("#createUser").val();
        var deleteFlag = $("#deleteFlag").val();
        var updateTime = $("#updateTime").val();
        var seq = $("#seq").val();
        var projectId = $("#projectId").val();
        var materialName = $("#materialName").val();
        var model = $("#model").val();
        var unit = $("#unit").val();
        var entryNum = $("#entryNum").val();
        var manufactrer = $("#manufactrer").val();
        var supplyer = $("#supplyer").val();
        var certificateQuality = $("#certificateQuality").val();
        var inspection = $("#inspection").val();
        var usePart = $("#usePart").val();
        var storage = $("#storage").val();
        var residualNum = $("#residualNum").val();
        var testReport = $("#testReport").val();
        var testState = $("#testState").val();

        var requestData={
            "materialId":materialId,
            "createTimeStr":createTime,
            "createUser":createUser,
            "deleteFlag":deleteFlag,
            "updateTimeStr":updateTime,
            "seq":seq,
            "projectId":projectId,
            "materialName":materialName,
            "model":model,
            "unit":unit,
            "entryNum":entryNum,
            "manufactrer":manufactrer,
            "supplyer":supplyer,
            "certificateQuality":certificateQuality,
            "inspection":inspection,
            "usePart":usePart,
            "storage":storage,
            "residualNum":residualNum,
            "testReport":testReport,
            "testState":testState
        };
        return requestData;
    };

    var addFlow = function () {
        var materialId = $("#materialId").val();
        //多窗口模式，层叠置顶
        layer.open({
            type: 2,
            title: '流程信息',
            area: ['60%', '70%'],
            shade: 0.5,
            anim: 3,//0-6的动画形式，-1不开启
            content: '<%=request.getContextPath()%>/admin/flow/addOrEdit',
            zIndex: layer.zIndex, //重点1
            success: function(layero, index){
                //layer.setAddOrEdit(layero);
                var body = layer.getChildFrame('body', index);

                var iframeWin = window[layero.find('iframe')[0]['name']];
                body.find('input[name="docUnid"]').val(materialId);
                body.find('input[name="docUrl"]').val(window.location.href);
                //弹窗表单的取消操作时关闭弹窗
                var canclebtn=body.find('button[name="cancleSubmit"]').click(function cancleSubmit(){
                    layer.closeAll();
                    //刷新页面
                    refreshTheCurrentPage();
                });
            }
        });
    }

    var endFlow = function () {
        var docUnid = $("#materialId").val();
        $.ajax({
            type: 'post',
            url: '/admin/flow/endFlow?docUnid='+docUnid,
            dataType: 'json',
            success: function (data) {
                if(data.code==200){
                    $.messager.alert('提示','结束成功!');
                }else{
                    $.messager.alert('错误','结束失败!','error');
                }
            }
        });
    }
</script>
</html>				 
