<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
    	<meta charset="utf-8">
		<title>新增配合比详情</title>
		<%@include file="/WEB-INF/jsp/decorators/addHeader.jsp" %>
	</head>
	<body style="width: 80%">
 			<input  type="hidden" id="detailId" name="detailId" value="${proportionsDetailetail.detailId}"/>
     		<div class="layui-form-item"  >
				<div class="box" style="margin-left: auto;margin-right: auto">

								<table id="example1" class="table table-bordered table-striped" style="text-align: center">
									<thead>
									<tr>
										<th style="width: 30% ;text-align: center" >材料名称 </th>
										<th  style="width: 30% ;text-align: center"  >材料数量</th>
										<th  style="width: 30% ;text-align: center">操作</th>
									</tr>
									</thead>
									<tbody id="show-data">
									<c:forEach items="${proportionsMaterial}" var="r" varStatus="st">
										<tr>

											<td>${r.materialName }</td>
											<td><input  style="text-align: center" type="text" id="materialNum" name="materialNum" placeholder="请输入材料数量"  value="${r.materialNum }" class="layui-input"/></td>

											<td>
												<div class="site-demo-button" >
													<button id="updateProportions" onclick="updateProportions('${r.proportionsMaterialId}')"  class="layui-btn layui-btn-normal layui-btn-small"><i class="layui-icon"></i><span>&nbsp;&nbsp;修改</span></button>
												</div>
											</td>
										</tr>
									</c:forEach>
									</tbody>
								</table>
				</div>

				</div>
	</body>

	<script type="text/javascript">
		var reqUpdateAndAddUrl = "/admin/proportionsDetailetail/insertAndUpdate";
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
	
	 var updateProportions = function(id){
	 var materialNum = $('#materialNum').val();
        $.ajax({
            type: "POST",
            url: '/admin/proportionsDetailetail/updateProportionsMaterial',
            data: {
                "proportionsMaterialId":id,
				"materialNum":materialNum,
			},
            dataType: "json",
            cache:false,
            success: function(data){
                var code = data.code;
                var msg = data.message;
                if(code == "200"){
                    layer.msg(msg, {icon: 1,time: 2000});//2秒关闭
                    //刷新页面
                    parent.location.reload();
                }
            },
            error:function(){
                layer.msg("操作失败！", {icon: 1,time: 2000});//1.5秒关闭
            }
        });

        layer.closeAll();
    }


	
</script>
</html>				 
