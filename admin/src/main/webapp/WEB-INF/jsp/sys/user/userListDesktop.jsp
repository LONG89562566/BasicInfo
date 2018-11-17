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
			.fl{float: left;}
		</style>
	</head>
	<body class="hold-transition skin-blue sidebar-mini">
	<!-- 系统用户列表start -->
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>系统用户信息管理</h1>
		</section>
		<!-- Main content -->
		<shiro:hasPermission name="sysUser:query">
			<section class="content">
				<div class="row">
					<div class="col-xs-12">
						<div class="box">
							<div class="box-header">
								<%--<h3 class="box-title">系统用户列表 :${sessionScope.login_session_admin.userName}</h3>--%>
							</div>
							<div class="box box-info">
								<!-- form start -->
								<form  id="form_submit" class="form-horizontal" action="<%=request.getContextPath() %>/admin/sysUser/list" method="post">
									<input type="hidden" name="pageNum" id="pageNum" value="${paginator.currentPage}">
									<input type="hidden" name="pageSize" id="pageSize" value="${paginator.pageRecord}">
									<div class="box-body">
										<div class="form-group">
											<div class="layui-inline">
												<label for="userName" class="col-sm-4 control-label fl" >用户名：</label>
												<div class="col-xs-6 fl" >
													<input type="text" class="form-control" id="userName" name="userName" value="${sysUser.userName}" placeholder="请输入用户名">
												</div>
											</div>
											<div class="layui-inline">
												<label for="phone" class="col-sm-4 control-label" style="float: left;">手机号：</label>
												<div class="col-xs-6" style="float: left;">
													<input type="text" class="form-control" id="phone" name="phone" value="${sysUser.phone}" placeholder="请输入手机号">
												</div>
											</div>
											<div class="layui-inline">
												<label for="status" class="col-sm-4 control-label" style="float: left;">状态</label>
												<div class="col-xs-6" style="float: left;">
													<select id="status" name="status" class="form-control" style="width:150px;">
														<option value="" selected>全部</option>
														<option value="1" <c:if test="${sysUser.status == 1}">selected</c:if>>启用</option>
														<option value="-1" <c:if test="${sysUser.status == -1}">selected</c:if>>禁用</option>
													</select>
												</div>
											</div>
										</div>
										<div class="box-footer">
											<button onclick="refreshTheCurrentPage()" class="btn btn-info pull-left">查询</button>
											<button type="reset" onclick="resetRefreshTheCurrentPage()" class="btn btn-info ">重置</button>
										</div>
									</div>
								</form>
								<!-- form end -->
							</div>
							<!-- 表格列表start -->
							<div class="box">
								<div class="box-body" style="overflow:auto">
									<div class="site-demo-button" >
										<button data-method="setTop" id="addUser" class="layui-btn layui-btn-small"><i class="layui-icon"></i><span>&nbsp;&nbsp;新增</span></button>
									</div>
									<table id="example1" class="table table-bordered table-striped" style="overflow: scroll;">
										<thead>
										<tr>
											<th field="sys_xh" style="width: 40px;">序号</th>
											<th field="userName"  style="width: 120px;">用户名</th>
											<th field="name"  style="width: 120px;">姓名</th>
											<th field="phone"  style="width: 140px;">手机号码</th>
											<th field="email"  style="width: 140px;">邮箱</th>
											<th field="status" method="methodStatus"  style="width: 40px;">状态</th>
											<th field="remarks"  style="width: 320px;">备注信息</th>
											<th field="createTime"  style="width: 140px;">创建时间</th>
											<th field="lastUpdateTime"  style="width: 140px;">更新时间</th>
											<th field="sys_opt"  style="width: 220px;">操作</th>
										</tr>
										</thead>
										<tbody id="showPicture">
										<c:forEach items="${paginator.object}" var="r" varStatus="st">
											<tr>
												<td>${(st.index + 1)  + ((paginator.currentPage - 1) * paginator.pageRecord )}</td>
												<td>${r.userName}</td>
												<td>${r.name}</td>
												<td>${r.phone}</td>
												<td>${r.email}</td>
												<td>
													<c:if test="${r.status==1 }">启用</c:if>
													<c:if test="${r.status==-1 }">禁用</c:if>
												</td>
												<td>${r.remarks}</td>
												<td><fmt:formatDate value="${r.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
												<td><fmt:formatDate value="${r.lastUpdateTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
												<td>
													<div class="site-demo-button" >
														<button id="updateUser" data-method="setTop" value="${r.id }" class="layui-btn layui-btn-normal layui-btn-small"><i class="layui-icon"> </i><span>&nbsp;&nbsp;修改</span></button>
														<c:choose>
															<c:when test="${r.status==1}">
																<button data-method="offset" name="1" value="${r.id }" class="layui-btn layui-btn-danger layui-btn-small"><i class="layui-icon"> </i><span>&nbsp;&nbsp;禁用</span></button>
															</c:when>
															<c:otherwise>
																<button data-method="offset" name="-1" value="${r.id }" class="layui-btn layui-btn-danger layui-btn-small"><i class="layui-icon"> </i><span>&nbsp;&nbsp;启用</span></button>
															</c:otherwise>
														</c:choose>
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
								<ul id="paginator" class="pagination pagination-sm no-margin pull-left">
									<pv:showPaging pageVo="${paginator}" />
								</ul>
							</div>
						</div>
					</div>
				</div>
			</section>
		</shiro:hasPermission>
	</div>

	<script type="text/javascript">
		var pageQueryUrl = "<%=request.getContextPath()%>/admin/sysUser/pageQuery";
		var _queryConditionForrId = "form_submit";
		var showFieldId = "example1";
		var showFieldData = "showPicture";
		var primarykey = "id";
		var showPageNumber = "paginator";
		var tableBtn = new Array();
		tableBtn = addBtn(tableBtn,"saveAndUpdate","修改","","","","","","layui-btn-normal");
		tableBtn = addBtn(tableBtn,"enabled","禁用","","","status","true","1","layui-btn-danger");
		tableBtn = addBtn(tableBtn,"openset","启用","","","status","true","-1","layui-btn-danger");
	</script>
	<script type="text/javascript">

		var methodStatus = function (val , obj) {
			var retVal = "";
			if(val == 1){
				retVal = "启用";
			}else if(val == -1){
				retVal = "禁用";
			}
			return retVal;
		};

	</script>
	<script>
		//新增数据弹窗
		layui.use('layer', function(){ //独立版的layer无需执行这一句
			var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句
			//触发事件
			var active = {
				setTop: function(data){
					//获取userId
					var id = data.val();
					saveAndUpdate(id);
				},
				//启用和禁用数据弹窗
				offset: function(othis){
					var type = othis.data('type');
					var status=othis.text();
					if(status.indexOf("禁用")!=-1){
						//禁用的url
						requestUrl="<%=request.getContextPath()%>/admin/sysUser/disabled";
						text = "确定要禁用此条数据吗？";
					}else{
						//启用的url
						requestUrl="<%=request.getContextPath()%>/admin/sysUser/enabled";
						text = "确定要启用此条数据吗？";
					}
					var id = othis.val();
					userOffSet(type,requestUrl, id,text);
				}
			};
			$('.site-demo-button .layui-btn').on('click', function(){
				var othis = $(this), method = othis.data('method');
				active[method] ? active[method].call(this, othis) : '';
			});
		});

		var saveAndUpdate =  function(id){
			//多窗口模式，层叠置顶
			layer.open({
				type: 2,
				title: '新增/修改系统用户信息',
				area: ['99%', '60%'],
				shade: 0.5,
				anim: 3,//0-6的动画形式，-1不开启
				content: '/admin/sysUser/addSysUser?id='+id,
				zIndex: layer.zIndex, //重点1
				success: function(layero, index){
					layer.setTop(layero);
					var body = layer.getChildFrame('body', index);
					var iframeWin = window[layero.find('iframe')[0]['name']];
					body.find('input[name="id"]').val(id);
					//弹窗表单的取消操作时关闭弹窗
					var canclebtn=body.find('button[name="cancleSubmit"]').click(function cancleSubmit(){
						layer.closeAll();
					});
				}
			});
		};
		//禁用
		var enabled = function (id) {
			//禁用的url
			requestUrl="<%=request.getContextPath()%>/admin/sysUser/disabled";
			text = "确定要禁用此条数据吗？";
			userOffSet(1,requestUrl, id,text);
		};
		//启用
		var openset = function (id) {
			//启用的url
			requestUrl="<%=request.getContextPath()%>/admin/sysUser/enabled";
			text = "确定要启用此条数据吗？";
			userOffSet(0,requestUrl, id,text);
		};

		var userOffSet = function (type ,requestUrl,id,text) {
			layer.open({
				type: 1,
				offset: type,
				id: 'LAY_demo'+type, //防止重复弹出
				content: '<div style="padding: 20px 100px;">'+ text +'</div>',
				btn: ['确定', '取消'],
				btnAlign: 'c', //按钮居中
				shade: 0.5 ,//不显示遮罩
				yes: function(){
					layer.closeAll();
					$.ajax({
						type: "POST",
						url: requestUrl,
						data: {"id":id},
						dataType: "json",
						cache:false,
						success: function(data){
							var code = data.code;
							var msg = data.message;
							if(code == "200"){
								layer.msg(msg, {icon: 1,time: 2000});//2秒关闭
								//刷新页面
								refreshTheCurrentPage();
								<%--window.location.href="<%=request.getContextPath() %>/admin/sysUser/list";--%>
							}
						},
						error:function(){
							layer.msg("删除失败", {icon: 1,time: 2000});//1.5秒关闭
						}
					});
				},
				btn2: function(){
					layer.closeAll();
				}
			});
		}
	</script>
</body>
</html>