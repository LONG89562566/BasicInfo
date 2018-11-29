<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//业务主键id
	String docUnid = request.getParameter("docUnid");
    //流程主键id
    String flowId = request.getParameter("flowId");
%>

            <div class="layui-input-block" style="margin:30px;" id="flow-btn">
                <input type="button" id="tj-btn" class="layui-btn" onclick="" style="display: none;" value="提交"/>
                <input type="button" class="layui-btn" onclick="addFlow()" value="发送"/>
                <input type="button" class="layui-btn" onclick="endFlow()" value="结束流程"/>
                <input type="button" class="layui-btn" onclick="queryFlow()" value="查看流程"/>
            </div>

	<script type="text/javascript">
		$(function () {
		    var docUnid = "<%=docUnid%>";
		    if(!docUnid){
		        $("#flow-btn").hide();
            }
            loadFlow();
		});

        function loadFlow() {
            $.post("/admin/flow/isSubmit",{docUnid :'<%=docUnid%>',flowId : '<%=flowId%>'},function (data) {
                if(data.code == 200 && data.object > 1){
                    $("#tj-btn").attr("onclick","submitFlow()");
                    $("#tj-btn").show();
                }
            });
        }

		var addFlow = function () {
			//多窗口模式，层叠置顶
			layer.open({
				type: 2,
				title: '流程信息',
				area: ['60%', '90%'],
				shade: 0.5,
				anim: 3,//0-6的动画形式，-1不开启
				content: '<%=request.getContextPath()%>/admin/flow/addOrEdit?flowId=<%=flowId%>',
				zIndex: layer.zIndex, //重点1
				success: function(layero, index){
					//layer.setAddOrEdit(layero);
					var body = layer.getChildFrame('body', index);

					var iframeWin = window[layero.find('iframe')[0]['name']];
					body.find('input[name="docUnid"]').val('<%=docUnid%>');
					body.find('input[name="docUrl"]').val(window.location.href);
					//弹窗表单的取消操作时关闭弹窗
					var canclebtn=body.find('button[name="cancleSubmit"]').click(function cancleSubmit(){
						layer.closeAll();
						//刷新页面
						refreshTheCurrentPage();
					});
				}
			});
		};

        var submitFlow = function () {
			//多窗口模式，层叠置顶
			layer.open({
				type: 2,
				title: '流程信息',
				area: ['60%', '90%'],
				shade: 0.5,
				anim: 3,//0-6的动画形式，-1不开启
				content: '<%=request.getContextPath()%>/admin/flow/submitPage?flowId=<%=flowId%>',
				zIndex: layer.zIndex, //重点1
				success: function(layero, index){
					//layer.setAddOrEdit(layero);
					var body = layer.getChildFrame('body', index);

					var iframeWin = window[layero.find('iframe')[0]['name']];
					body.find('input[name="docUnid"]').val('<%=docUnid%>');
					body.find('input[name="docUrl"]').val(window.location.href);
					//弹窗表单的取消操作时关闭弹窗
					var canclebtn=body.find('button[name="cancleSubmit"]').click(function cancleSubmit(){
						layer.closeAll();
						//刷新页面
						refreshTheCurrentPage();
					});
				}
			});
		};

		var queryFlow = function () {
            var _queryFlowUrl = '<%=request.getContextPath()%>/admin/flow/queryFlow?docUnid=<%=docUnid%>';
			//多窗口模式，层叠置顶
			layer.open({
				type: 2,
				title: '流程信息',
				area: ['80%', '90%'],
				shade: 0.5,
				anim: 3,//0-6的动画形式，-1不开启
				content: _queryFlowUrl,
				zIndex: layer.zIndex, //重点1
				success: function(layero, index){
					//layer.setAddOrEdit(layero);
					// var body = layer.getChildFrame('body', index);
                    //
					// var iframeWin = window[layero.find('iframe')[0]['name']];
					// body.find('input[name="docUnid"]').val(materialId);
					// body.find('input[name="docUrl"]').val(window.location.href);
					// //弹窗表单的取消操作时关闭弹窗
					// var canclebtn=body.find('button[name="cancleSubmit"]').click(function cancleSubmit(){
					// 	layer.closeAll();
					// 	//刷新页面
					// 	refreshTheCurrentPage();
					// });
				}
			});
		};

		var endFlow = function () {
			$.ajax({
				type: 'post',
				url: '/admin/flow/endFlow?docUnid=<%=docUnid%>',
				dataType: 'json',
				success: function (data) {
					if(data.code==200){
						$.messager.alert('提示','结束成功!');
					}else{
						$.messager.alert('错误','结束失败!','error');
					}
				}
			});
		};
	</script>

