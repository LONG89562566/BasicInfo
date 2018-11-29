<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
    	<meta charset="utf-8">
		<title>入库</title>
		<%@include file="/WEB-INF/jsp/decorators/addHeader.jsp" %>
	</head>
	<body>

	<link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="/bootstrap/css/fileinput.css">
	<link rel="stylesheet" href="/bootstrap/css/bootstrap-datetimepicker.css">
	<link rel="stylesheet" href="/bootstrap/css/bootstrapValidator.css">
	<link rel="stylesheet" href="/bootstrap/css/bootstrap-editable.css">
	<link rel="stylesheet" href="/libs/font-awesome.min.css">
	<link rel="stylesheet" href="/libs/ionicons.min.css">
	<link rel="stylesheet" href="/dist/css/AdminLTE.css">
	<link rel="stylesheet" href="/dist/css/skins/_all-skins.min.css">
	<link rel="stylesheet" href="/plugins/iCheck/flat/blue.css">
	<link rel="stylesheet" href="/plugins/morris/morris.css">
	<link rel="stylesheet" href="/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
	<link rel="stylesheet" href="/plugins/datepicker/datepicker3.css">
	<link rel="stylesheet" href="/plugins/daterangepicker/daterangepicker.css">
	<link rel="stylesheet" href="/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
	<link rel="stylesheet" href="/layui/css/layui.css"  media="all">
	<link rel="stylesheet" href="/plugins/datatables/dataTables.bootstrap.css">
	<link rel="stylesheet" href="/kindeditor/plugins/code/prettify.css" />
	<link rel="stylesheet" href="/kindeditor/themes/default/default.css" />
 		<form id="saleForm" class="layui-form" style="margin-top:30px;">
 			<%--<input  type="hidden" id="materialDetailId" name="materialDetailId" value="${materialDetail.materialDetailId}"/>--%>

				<jsp:include page="/WEB-INF/jsp/flow/flowPage.jsp">
					<jsp:param name="docUnid" value="${materialDetail.outId}" />
				</jsp:include>

				<div class='layui-form-item'>
					<label class="layui-form-label">试验报告单</label>
					<div class="layui-input-block">
						<textarea placeholder="请输入试验报告单" style="width: 90%;" class="layui-textarea"  id="testReport" name = "testReport" lay-verify="content">${materialDetail.testReport}</textarea>
						<span style="color: red" id="s-testReport"></span>
					</div>
				</div>
				<div class='layui-form-item'>
					<div class="layui-inline">
						<label class="layui-form-label">检验状态</label>
						<div class="layui-input-inline">
							<select name="testState" id="testState">
								<option value="">请选择</option>
								<option value="0"  <c:if test="${materialDetail.testState == 0}">selected</c:if>>检验未通过</option>
								<option value="1"  <c:if test="${materialDetail.testState == 1}">selected</c:if>>检验通过</option>
								<option value="2"  <c:if test="${materialDetail.testState == 2}">selected</c:if>>检验中</option>
							</select>
							<span style="color: red" id="s-testState"></span>
						</div>
					</div>
				</div>
				<div class="box">
					<input  type="hidden" id="outId" name="outId" value="${outId}"/>
					<div class="box-body">
				<table id="example1" class="table table-bordered table-striped" style="width: 50%">
					<thead>
					<tr >
						<th width="30%" style="text-align: center">材料名称</th>
						<th width="30%" style="text-align: center">出库数量</th>
					</tr>
					</thead>
					<tbody id="example1-tbody" style="text-align: center">
					  <c:forEach items="${materialDetailList}" var="r">
						  <tr>
						  <td>${r.materialName}</td>
						  <td>${r.num}</td>
						  </tr>
					  </c:forEach>
					</tbody>
				</table>
			</div>
				</div>
  		</form>
		</div>
	</div>
	</body>

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

        function getData() {
            var testReport = $("#testReport").val();
            var testState = $("#testState").val();
            var outId = $("#outId").val();

            layer.open({
                type: 1,
                content: '<div style="padding: 20px 100px;">确认执行?</div>',
                btn: ['确定', '取消'],
                btnAlign: 'c', //按钮居中
                shade: 0.5 ,//不显示遮罩
                yes: function(){
                    //获取传递的参数
                    var requestData={
                        testReport : testReport,
                        testState :testState,
                        outId :outId,
                    };

                    $.ajax({
                        type: "POST",
                        url: '/admin/materialDetail/updateTestMaterialDetail',
                        data: requestData,
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
                },
                btn2: function(){
                    layer.closeAll();
                }
            });


        };
        $('.site-demo-button .layui-btn').on('click', function(){
            var othis = $(this), method = othis.data('method');
            active[method] ? active[method].call(this, othis) : '';
        });



	</script>
</html>				 
