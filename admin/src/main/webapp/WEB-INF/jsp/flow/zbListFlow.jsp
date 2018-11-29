<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="pv" uri="/pageTaglib"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title></title>
	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
	<!-- 引入公共部分css jsp文件 -->
	<%@include file="/WEB-INF/jsp/decorators/meta.jsp" %>
	<!-- 引入公共部分js jsp文件 -->
	<%@include file="/WEB-INF/jsp/decorators/listHeader.jsp" %>
	<style type="text/css">
		.layui-form-label{
			width:100px;
		}

		.layui-input-block{
			width:auto;
			height:auto;
			position:relative;
			left:800px;
		}
		table th{
			background:#ffffff;
		}
		table tr:nth-child(odd){
			background:#F0F0F0;
		}
		.col-sm-2 {
			width: 10%;
		}
	</style>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<!-- 流程列表start -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>在办流程</h1>
	</section>
	<!-- Main content -->
	<section class="content">
		<div class="row">
			<div class="col-xs-12">
				<div class="box">
					<div class="box-header">
						<h3 class="box-title">流程列表 :${sessionScope.login_session_admin.userName}</h3>
					</div>
					<!-- 表格列表start -->
					<div class="box">
						<div class="box-body">
							<table id="example1" class="table table-bordered table-striped">
								<thead>
								<tr>
									<th field="sys_xh">序号</th>
									<th field="showTitle"  >业务内容</th>
									<th field="createTime"  type='date'>当前节点创建时间</th>
									<th field="operatorCn"  >相关人</th>
									<th field="sys_opt">操作</th>
								</tr>
								</thead>
								<tbody id="show-data">
								<c:forEach items="${paginator.object}" var="r" varStatus="st">
									<tr>
										<td>${(st.index + 1)  + ((paginator.currentPage - 1) * paginator.pageRecord )} </td>
										<td>${r.showTitle}</td>
										<td><fmt:formatDate value="${r.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
										<td>${r.operatorCn}</td>
										<td>
											<div class="site-demo-button" >
												<button id="readFlow" data-method="readFlow" value="${r.docUrl}" class="layui-btn layui-btn-normal layui-btn-small"><i class="layui-icon"></i><span>&nbsp;&nbsp;查看</span></button>
											</div>
										</td>
									</tr>
								</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					<!-- 表格列表end -->
					<div class="box-footer clearfix">
						<ul id="show-page" class="pagination pagination-sm no-margin pull-left">
							<pv:showPaging pageVo="${paginator}" />
						</ul>
					</div>
				</div>
			</div>
		</div>
	</section>
</div>

<script type="text/javascript">

    //查询数据Url
    var pageQueryUrl = "<%=request.getContextPath()%>/admin/flow/pageZbQuery";
    //查询条件表单Id
    var _queryConditionForrId = "form_submit";
    //显示数据表格id
    var showFieldId = "example1";
    //数据展示id
    var showFieldData = "show-data";
    //主键
    var primarykey = "flowId";
    //分页显示标签id
    var showPageNumber = "show-page";
    //列表操作按钮
    var tableBtn = new Array();
    tableBtn = addBtn(tableBtn,"readFlow","查看","","","","","","layui-btn-normal","docUrl");
</script>

<script>
    //数据弹窗
    layui.use('layer', function(){ //独立版的layer无需执行这一句
        var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句
        //触发事件
        var active = {
            readFlow: function(data){
                //获取userId
                var url = data.val();
                readFlow("",url);
            }
        };
        $('.site-demo-button .layui-btn').on('click', function(){
            var othis = $(this), method = othis.data('method');
            active[method] ? active[method].call(this, othis) : '';
        });
    });


    //查看
    var readFlow = function(id,url){
        //多窗口模式，层叠置顶
        layer.open({
            type: 2,
            title: '待办查看',
            area: ['100%', '100%'],
            shade: 0.5,
            anim: 3,//0-6的动画形式，-1不开启
            content: '<%=request.getContextPath()%>'+url,
            zIndex: layer.zIndex, //重点1
            success: function(layero, index){
                var body = layer.getChildFrame('body', index);
                //弹窗表单的取消操作时关闭弹窗
                var canclebtn=body.find('button[name="cancleSubmit"]').click(function cancleSubmit(){
                    layer.closeAll();
                });
            }
        });
    };
</script>
</body>
</html>
					
