<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
    	<meta charset="utf-8">
		<title>新增设备信息</title>
		<%@include file="/WEB-INF/jsp/decorators/addHeader.jsp" %>
	</head>
	<body>
 		<form id="saleForm" class="layui-form" style="margin-top:30px;">
 			<input  type="hidden" id="equipmentId" name="equipmentId" value="${equipmentInfo.equipmentId}"/>
			<input  type="hidden" id="projectId" name="projectId" value="${equipmentInfo.projectId}"/>

			<jsp:include page="/WEB-INF/jsp/flow/flowPage.jsp">
				<jsp:param name="docUnid" value="${beamSection.sectionId}" />
			</jsp:include>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">排序号</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="seq" name="seq" placeholder="请输入排序号"  value="${equipmentInfo.seq }" class="layui-input"/>
		        		<span style="color: red" id="s-seq"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">管理编号</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="manageNum" name="manageNum" placeholder="请输入管理编号"  value="${equipmentInfo.manageNum }" class="layui-input" maxlength="10"/>
		        		<span style="color: red" id="s-manageNum"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">名称</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="name" name="name" placeholder="请输入名称"  value="${equipmentInfo.name }" class="layui-input"/>
		        		<span style="color: red" id="s-name"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">型号</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="model" name="model" placeholder="请输入型号"  value="${equipmentInfo.model }" class="layui-input"/>
		        		<span style="color: red" id="s-model"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">功率</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="power" name="power" placeholder="请输入功率"  value="${equipmentInfo.power }" class="layui-input"/>
		        		<span style="color: red" id="s-power"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">主要技术参数</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="mtp" name="mtp" placeholder="请输入主要技术参数"  value="${equipmentInfo.mtp }" class="layui-input"/>
		        		<span style="color: red" id="s-mtp"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">出场编号</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="startNum" name="startNum" placeholder="请输入出场编号"  value="${equipmentInfo.startNum }" class="layui-input"/>
		        		<span style="color: red" id="s-startNum"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">原值(元)</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="ov" name="ov" placeholder="请输入原值(元)"  value="${equipmentInfo.ov }" class="layui-input"/>
		        		<span style="color: red" id="s-ov"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">净值(元)</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="nv" name="nv" placeholder="请输入净值(元)"  value="${equipmentInfo.nv }" class="layui-input"/>
		        		<span style="color: red" id="s-nv"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label class="layui-form-label">生产厂</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="producPlant" name="producPlant" placeholder="请输入生产厂"  value="${equipmentInfo.producPlant }" class="layui-input"/>
		        		<span style="color: red" id="s-producPlant"></span>
		     		</div>
     			</div>
     			<div class="layui-inline">
		        	<label  class="layui-form-label">出厂日期:</label>
	            	<div class="layui-input-inline">
		            	<input onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" type="text"  name="producTime" id="producTime" value="${equipmentInfo.producTimeStr}" class="form-control input-small" placeholder="请选择出厂日期"/>
		            	<span style="color: red" id="s-producTime"></span>
		        	</div>
     			</div>
			</div>
			<div class='layui-form-item'>
     			<div class="layui-inline">
		        	<label  class="layui-form-label">进场日期:</label>
	            	<div class="layui-input-inline">
		            	<input onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" type="text"  name="advanceTime" id="advanceTime" value="${equipmentInfo.advanceTimeStr}" class="form-control input-small" placeholder="请选择进场日期"/>
		            	<span style="color: red" id="s-advanceTime"></span>
		        	</div>
     			</div>
     			<div class="layui-inline">
		        	<label class="layui-form-label">设备来源</label>
		        	<div class="layui-input-inline">
		        		<input type="text" id="source" name="source" placeholder="请输入设备来源"  value="${equipmentInfo.source }" class="layui-input"/>
		        		<span style="color: red" id="s-source"></span>
		     		</div>
     			</div>
			</div>
			<div class='layui-form-item'>
		        <label class="layui-form-label">安全操作规程</label>
				<div class="layui-input-block">
					<textarea placeholder="请输入安全操作规程" style="width: 90%;" class="layui-textarea"  id="sop" name = "sop" lay-verify="content">${equipmentInfo.sop}</textarea>
					<span style="color: red" id="s-sop"></span>
				</div>
	 		</div>
            <div class="layui-input-block" style="margin-top:30px;margin-left:324px;">
                <input type="button" class="layui-btn" onclick="saveData()" value="确定"/>
                <button class="layui-btn" name="cancleSubmit" >取消</button>
            </div>
  		</form>
	</body>

    <script type="text/javascript">
        var reqUpdateAndAddUrl = "/admin/equipmentInfo/insertAndUpdate";
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
            var equipmentId = $("#equipmentId").val();
            var seq = $("#seq").val();
            var projectId = $("#projectId").val();
            var manageNum = $("#manageNum").val();
            var name = $("#name").val();
            var model = $("#model").val();
            var power = $("#power").val();
            var mtp = $("#mtp").val();
            var startNum = $("#startNum").val();
            var ov = $("#ov").val();
            var nv = $("#nv").val();
            var producPlant = $("#producPlant").val();
            var producTime = $("#producTime").val();
            var advanceTime = $("#advanceTime").val();
            var source = $("#source").val();
            var sop = $("#sop").val();

            var requestData={
                "equipmentId":equipmentId,
                "seq":seq,
                "projectId":projectId,
                "manageNum":manageNum,
                "name":name,
                "model":model,
                "power":power,
                "mtp":mtp,
                "startNum":startNum,
                "ov":ov,
                "nv":nv,
                "producPlant":producPlant,
                "producTimeStr":producTime,
                "advanceTimeStr":advanceTime,
                "source":source,
                "sop":sop
            };
            updateAndAdd(requestData);
        }

</script>
</html>				 
