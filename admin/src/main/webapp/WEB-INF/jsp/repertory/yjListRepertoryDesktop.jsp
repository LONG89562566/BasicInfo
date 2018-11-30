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
		.col-sm-2 {
			width: 10%;
		}
	</style>
	<script type="text/javascript" src="/jquery-easyui-1.5.2/jquery.easyui.min.js" charset="utf-8"></script>
	<script type="text/javascript" src="/jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<!-- 仓库列表start -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>仓库管理</h1>
	</section>
	<!-- Main content -->
	<shiro:hasPermission name="repertory:yjList">
		<section class="content">
			<div class="row">

				<div class="box" style="float: left;width: 100%;height: auto; background-color: white;">
					<div class="row">
						<div class="col-xs-12">
							<div class="box">
								<div class="box-header">
									<%--<h3 class="box-title">仓库列表 :${sessionScope.login_session_admin.userName}</h3>--%>
								</div>
								<div class="box box-info">
									<!-- form start -->
									<form  id="form_submit" class="form-horizontal" action="/admin/repertory/list" method="post" style="display: none;">
										<input type="hidden" name="pageNum" id="pageNum" value="">
										<input type="hidden" name="pageSize" id="pageSize" value="">
										<input type="hidden" name="projectId" id="projectId" value="">
										<div class="box-body">
											<div class="form-group">
												<label for="materialName" class="col-sm-1 control-label">材料名称:</label>
												<div class="col-sm-3" style="width: 200px">
													<input type="text" name="materialName" id="materialName" value="" class="form-control input-small" placeholder="请输入材料名称！">
												</div>
												<label for="model" class="col-sm-1 control-label">规格型号:</label>
												<div class="col-sm-3" style="width: 200px">
													<input type="text" name="model" id="model" value="" class="form-control input-small" placeholder="请输入规格型号！">
												</div>
											</div>
											<div class="box-footer">
												<button onclick='refreshTheCurrentPage()' class="btn btn-info pull-left">查询</button>
												<button type="reset" onclick='resetRefreshTheCurrentPage()' id="reset" class="btn btn-info ">重置</button>
											</div>
										</div>
									</form>
									<!-- form end -->
								</div>
								<!-- 表格列表start -->
								<div class="box">
									<div class="box-body">
											<%--<div class="site-demo-button" >--%>
											<%--<button data-method="setAddOrEdit" id="addUser" class="layui-btn layui-btn-small"><i class="layui-icon"></i><span>&nbsp;&nbsp;新增</span></button>--%>
											<%--</div>--%>
										<table id="example1" class="table table-bordered table-striped">
											<thead>
											<tr>
												<th field="sys_xh">序号</th>
												<th field="seq"  >排序号</th>
												<th field="materialName"  >材料名称</th>
												<th field="model"  >规格型号</th>
												<th field="unit"  >计量单位</th>
												<th field="num"  >库存数量</th>
												<th field="checkCondition"  >预警条件</th>
												<th field="warnVal"  >预警值</th>
												<th field="sys_opt">操作</th>
											</tr>
											</thead>
											<tbody id="show-data">
											<c:forEach items="${paginator}" var="r" varStatus="st">
												<tr>
													<td>${(st.index + 1) } </td>
													<td>${r.seq}</td>
													<td>${r.materialName}</td>
													<td>${r.model}</td>
													<td>${r.unit}</td>
													<td>${r.num}</td>
													<td>${r.checkCondition}</td>
													<td>${r.warnVal}</td>
													<td>
														<div class="site-demo-button" >
																<%--								   <button id="updateRepertory" data-method="setAddOrEdit" projectId="${r.projectId}" value="${r.repertoryId}" class="layui-btn layui-btn-normal layui-btn-small"><i class="layui-icon"></i><span>&nbsp;&nbsp;修改</span></button>
                                                                                                   <button id="delRepertory" data-method="delIfon" value="${r.repertoryId}" class="layui-btn layui-btn-warm layui-btn-small"><i class="layui-icon"></i><span>&nbsp;&nbsp;删除</span></button>--%>
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

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</shiro:hasPermission>
</div>

<script type="text/javascript">

    //查询数据Url
    var pageQueryUrl = "<%=request.getContextPath()%>/admin/repertory/pageQuery";
    //查询条件表单Id
    var _queryConditionForrId = "form_submit";
    //显示数据表格id
    var showFieldId = "example1";
    //数据展示id
    var showFieldData = "show-data";
    //主键
    var primarykey = "repertoryId";
    //分页显示标签id
    var showPageNumber = "show-page";
    //列表操作按钮
    var tableBtn = new Array();
    tableBtn = addBtn(tableBtn,"setAddOrEdit","修改","","","","","","layui-btn-normal","projectId");
    tableBtn = addBtn(tableBtn,"delData","删除","","","","","","layui-btn-warm");
    //tableBtn = addBtn(tableBtn,"enabled","禁用","","","status","true","1","layui-btn-danger");
    //tableBtn = addBtn(tableBtn,"openset","启用","","","status","true","-1","layui-btn-danger");
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
    //加载菜单
    $('#projectSurveyTree').treegrid({
        url:'<%=request.getContextPath()%>/admin/projectSurvey/projectSurveyTree',
        method:'get',          //请求方式
        idField:'projectId',           //定义标识树节点的键名字段
        treeField:'lcName',       //定义树节点的字段
        fit:true,               //网格自动撑满
        fitColumns:true,
        onLoadSuccess:function(node, data){
            $(this).treegrid('collapseAll');
        },
        onClickRow:function(row){
            $('#pageNum').val(1);
            $("#projectId").val(row.projectId);
            //点击时初始化数据
            initPaginator(row.projectId);



        }
    });
    //初始化列表
    var initPaginator = function (projectId) {
        if (projectId) {
            loadSelectPageDat($('#pageNum').val(),$('#pageSize').val());
        } else {
            layer.msg('请先选择一个梁场！');
            return;
        }

    };
    //新增数据弹窗
    layui.use('layer', function(){ //独立版的layer无需执行这一句
        var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句
        //触发事件
        var active = {
            setAddOrEdit: function(data){
                //获取userId
                var id = data.val();
                var projectId = $("#projectId").val();
                projectId = projectId?projectId:data.attr("projectId");
                setAddOrEdit(id,projectId);
            },
            delIfon: function(data){
                //获取@primarykey
                var id = data.val();
                delData(id);
            },
            //启用和禁用数据弹窗
            offset: function(othis){
                var type = othis.data('type');
                var status=othis.text();
                if(status.indexOf("禁用")!=-1){
                    //禁用的url
                    requestUrl="<%=request.getContextPath()%>/admin/repertory/disabled";
                    text = "确定要禁用此条数据吗？";
                }else{
                    //启用的url
                    requestUrl="<%=request.getContextPath()%>/admin/repertory/enabled";
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


    //新增、编辑打开
    var setAddOrEdit = function(repertoryId,projectId){
        if(!projectId){
            layer.msg('请先选择一个梁场！');
            return;
        }
        //多窗口模式，层叠置顶
        layer.open({
            type: 2,
            title: '新增/修改 仓库',
            area: ['70%', '86%'],
            shade: 0.5,
            anim: 3,//0-6的动画形式，-1不开启
            content: '<%=request.getContextPath()%>/admin/repertory/addOrEdit?repertoryId='+repertoryId,
            zIndex: layer.zIndex, //重点1
            success: function(layero, index){
                //layer.setAddOrEdit(layero);
                var body = layer.getChildFrame('body', index);
                var iframeWin = window[layero.find('iframe')[0]['name']];
                body.find('input[name="repertoryId"]').val(repertoryId);
                body.find('input[name="projectId"]').val(projectId);
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
        requestUrl="<%=request.getContextPath()%>/admin/repertory/disabled";
        text = "确定要禁用此条数据吗？";
        userOffSet(1,requestUrl, id,text);
    };
    //启用
    var openset = function (id) {
        //启用的url
        requestUrl="<%=request.getContextPath()%>/admin/repertory/enabled";
        text = "确定要启用此条数据吗？";
        userOffSet(0,requestUrl, id,text);
    };
    //删除
    var delData = function(id){
        //删除的url
        requestUrl= "<%=request.getContextPath()%>/admin/repertory/delete";
        text = "确定要删除此条数据吗？";
        userOffSet(2,requestUrl, id,text);
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
                    data: {"repertoryId":id},
                    dataType: "json",
                    cache:false,
                    success: function(data){
                        var code = data.code;
                        var msg = data.message;
                        if(code == "200"){
                            layer.msg(msg, {icon: 1,time: 2000});//2秒关闭
                            //刷新页面
                            refreshTheCurrentPage();
                        }
                    },
                    error:function(){
                        layer.msg("操作失败", {icon: 1,time: 2000});//1.5秒关闭
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
					
