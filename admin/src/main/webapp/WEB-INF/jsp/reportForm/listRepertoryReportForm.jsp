

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
        <h1>材料报表${sessionScope.login_session_admin.userName}</h1>
    </section>
    <!-- Main content -->
    <shiro:hasPermission name="repertoryRepertory:query">
        <section class="content">

            <div class="row">
                <div style="float: left;width: 18%;height: 500px;background-color: white;margin-right: 1%">
                    <table id="repertoryRepertoryTree" title="所有条件" style="width:100%;height:500px">
                        <thead>
                        <tr>
                            <th data-options="field:'text'" width="220px">条件名称</th>
                        </tr>
                        </thead>
                    </table>
                </div>
                <div class="box" style="float: left;width: 80%;height: auto; background-color: white;">
                    <section class="box-header">
                        <h1>材料报表：</h1>
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
                                        <th field="seq"id="seq" >排序号</th>
                                        <th field="createUser" id="create_user">创建人编号</th>
                                        <th field="materialName" id="material_name" >材料名称</th>
                                        <th field="model" id="model"   >规格型号</th>
                                        <th field="unit" id="unit" >计量单位</th>
                                        <th field="num" id="num" >库存数量</th>
                                        <th field="projectName" id="project_id" >项目编号</th>
                                        <th field="createTime" id="create_time" >创建时间</th>
                                    </tr>
                                    </thead>
                                    <tbody id="show-data">
                                    <c:forEach items="${paginator.object}" var="r" varStatus="st">
                                        <tr>
                                            <td>${(st.index + 1)  + ((paginator.currentPage - 1) * paginator.pageRecord )} </td>
                                            <td>${r.seq}</td>
                                            <td>${r.createUser}</td>
                                            <td>${r.materialName}</td>
                                            <td>${r.model}</td>
                                            <td>${r.unit}</td>
                                            <td>${r.num}</td>
                                            <td>${r.projectName}</td>
                                            <td>${r.createTime}</td>
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
    var pageQueryUrl = "<%=request.getContextPath()%>/admin/reportForm/repertoryPageQuery";
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

</script>


<script type="text/javascript" charset="utf-8">
    // layui.use(['layer','jquery','form','element'], function(){ }

    var asynLoadTree = "<%=request.getContextPath()%>/admin/reportForm/repertoryRepertoryTree";

    $(document).ready(function () {
        repertoryRepertoryTree();
        // staffInfoRepertory_tree()
    });

    $("#projectId").bind("change",function(){
        initPaginator();
    });

    var repertoryRepertoryTree = function () {
        //加载菜单
        $('#repertoryRepertoryTree').treegrid({
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
                $('#repertoryRepertoryTree').treegrid('select');

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

