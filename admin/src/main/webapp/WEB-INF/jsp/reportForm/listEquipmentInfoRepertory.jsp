

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
    <link rel="stylesheet" href="/layui/css/layui.css"  media="all">
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
</head>

<body class="hold-transition skin-blue sidebar-mini">
<script src="/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="/bootstrap/js/bootstrap.min.js"></script>
<script src="/bootstrap/js/fileinput.js"></script>
<script src="/js/jquery-ui.min.js"></script>
<script src="/js/jquery.form.js"></script>
<script src="/js/fromVal.js"></script>
<script src="/js/date-format.js"></script>
<script src="/layui/layui.js"></script>
<script src="/dist/js/app.min.js"></script>
<script type="text/javascript" src="/jquery-easyui-1.5.2/jquery.easyui.min.js" charset="utf-8"></script>
<script type="text/javascript" src="/My97DatePicker/WdatePicker.js" charset="utf-8" ></script>
<script type="text/javascript" src="/jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>

<!-- 员工信息列表start -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>设备报表${sessionScope.login_session_admin.userName}</h1>
    </section>
    <!-- Main content -->
    <shiro:hasPermission name="frockInfoRepertory:query">
        <section class="content">

            <div class="row">
                <div style="float: left;width: 18%;height: 500px;background-color: white;margin-right: 1%">
                    <table id="equipmentInfoRepertoryTree" title="所有条件" style="width:100%;height:500px">
                        <thead>
                        <tr>
                            <th data-options="field:'text'" width="220px">条件名称</th>
                        </tr>
                        </thead>
                    </table>
                </div>
                <div class="box" style="float: left;width: 80%;height: auto; background-color: white;">
                    <section class="box-header">
                        <h1>设备报表：</h1>
                    </section>

                    <!-- form start -->
                    <div class="box box-info">

                        <form  id="form_submit"  method="post" class="form-horizontal" >
                            <input type="hidden" name="pageNum" id="pageNum" value="${paginator.currentPage}">
                            <input type="hidden" name="pageSize" id="pageSize" value="${paginator.pageRecord}">
                            <div >
                                <div class="form-group">
                                    <label for="projectId" class="col-sm-2 control-label">  梁场：</label>
                                    <select id="projectId" name="projectId" class="form-control" style="width:150px;">
                                        <option value="" >全部</option>
                                        <c:forEach items="${projectSurveyList}" var="p">
                                            <option value="${p.projectId}" >${p.lcName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </form>
                        <!-- form end -->
                    </div>
                    <!-- 表格列表start -->
                    <div class="box">

                        <div class="box-body">
                            <table id="example1" class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th field="sys_xh">序号</th>
                                    <th field="manageNum" id="manage_num" >管理编号</th>
                                    <th field="name" id="name" >名称</th>
                                    <th field="model" id="model" >型号</th>
                                    <th field="power" id="power" >功率</th>
                                    <th field="mtp" id="mtp" >主要技术参数</th>
                                    <th field="startNum" id="start_num" >出场编号</th>
                                    <th field="ov" id="ov" >原值(元)</th>
                                    <th field="nv"  id="nv">净值(元)</th>
                                    <th field="producPlant" id="produc_plant" >生产厂</th>
                                    <th field="producTime" id="produc_time" type='date'>出厂日期</th>
                                    <th field="advanceTime" id="advance_time" type='date'>进场日期</th>
                                    <th field="source" id="source" >设备来源</th>
                                    <th field="seq" id="seq" >排序号</th>
                                    <th field="projectName" id="project_id" >所属梁场</th>
                                </tr>
                                </thead>
                                <tbody id="show-data">
                                <c:forEach items="${paginator.object}" var="r" varStatus="st">
                                    <tr>
                                        <td>${(st.index + 1)  + ((paginator.currentPage - 1) * paginator.pageRecord )} </td>
                                        <td>${r.manageNum}</td>
                                        <td>${r.name}</td>
                                        <td>${r.model}</td>
                                        <td>${r.power}</td>
                                        <td>${r.mtp}</td>
                                        <td>${r.startNum}</td>
                                        <td>${r.ov}</td>
                                        <td>${r.nv}</td>
                                        <td>${r.producPlant}</td>
                                        <td><fmt:formatDate value="${r.producTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                        <td><fmt:formatDate value="${r.advanceTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                        <td>${r.source}</td>
                                        <td>${r.seq}</td>
                                        <td>${r.projectName}</td>
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
        </section>
    </shiro:hasPermission>
</div>
<script type="text/javascript">
    //查询数据Url
    var pageQueryUrl = "<%=request.getContextPath()%>/admin/reportForm/equipmentInfoPageQuery";
    //查询条件表单Id
    var _queryConditionForrId = "form_submit";
    //显示数据表格id
    var showFieldId = "example1";
    //数据展示id
    var showFieldData = "show-data";
    //主键
    var primarykey = "forckId";
    //分页显示标签id
    var showPageNumber = "show-page";
    //列表操作按钮
    var tableBtn = new Array();
    // tableBtn = addBtn(tableBtn,"setAddOrEdit","修改","","","","","","layui-btn-normal");
    // tableBtn = addBtn(tableBtn,"escBoundUser","解绑","","","isBound","true","1","layui-btn-danger");
    // tableBtn = addBtn(tableBtn,"boundUser","绑定","","","isBound","true","0","layui-btn-danger");
    // tableBtn = addBtn(tableBtn,"delData","删除","","","","","","layui-btn-normal");
</script>


<script type="text/javascript" charset="utf-8">
    // layui.use(['layer','jquery','form','element'], function(){ }

    var asynLoadTree = "<%=request.getContextPath()%>/admin/reportForm/equipmentInfoRepertoryTree";

    $(document).ready(function () {
        equipmentInfoRepertoryTree();
        // staffInfoRepertory_tree()
    });

    $("#projectId").bind("change",function(){
        initPaginator();
    });

    var equipmentInfoRepertoryTree = function () {
        //加载菜单
        $('#equipmentInfoRepertoryTree').treegrid({
            url:asynLoadTree,
            multiple : true,
            method: 'get',          //请求方式
            idField: 'id',           //定义标识树节点的键名字段
            treeField: 'text',       //定义树节点的字段
            fit: true,               //网格自动撑满
            fitColumns: true,
            singleSelect:false, //是否单选
            onLoadSuccess: function (node, data) {
                $(this).treegrid('collapseAll');
                ;//控制点击文字时也能勾选
            },
            onClickRow: function (row) {
                $('#equipmentInfoRepertoryTree').treegrid('select');

                $('#pageNum').val(1);
                //点击时初始化数据
                if($("#"+row.id).attr("isShow") == "false" || $("#"+row.id).attr("isShow") == ""){
                    $('#'+row.id).attr("isShow",true)
                    $('#'+row.id).show()
                }else {
                    $('#'+row.id).attr("isShow","false")
                    $('#'+row.id).hide()
                }
                initPaginator();
            },
        });
    }



    //初始化列表
    var initPaginator = function () {

        loadSelectPageDat($('#pageNum').val(),$('#pageSize').val());
    };

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
</body>
</html>

