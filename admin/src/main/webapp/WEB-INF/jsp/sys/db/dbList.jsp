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
<script src="/js/fromVal-v.1.0.js"></script>
<script src="/js/date-format.js"></script>
<script src="/layui/layui.js"></script>
<script src="/dist/js/app.min.js"></script>
<script type="text/javascript" src="/jquery-easyui-1.5.2/jquery.easyui.min.js" charset="utf-8"></script>
<script type="text/javascript" src="/My97DatePicker/WdatePicker.js" charset="utf-8" ></script>
<script type="text/javascript" src="/jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
<script src="/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="/bootstrap/js/bootstrap.min.js"></script>
<script src="/bootstrap/js/fileinput.js"></script>
<script src="/js/jquery-ui.min.js"></script>
<script src="/js/jquery.form.js"></script>
<script src="/layui/layui.js"></script>
<script src="/dist/js/app.min.js"></script>
<script type="text/javascript" src="/jquery-easyui-1.5.2/jquery.easyui.min.js" charset="utf-8"></script>
<script type="text/javascript" src="/jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
<script type="text/javascript" src="/My97DatePicker/WdatePicker.js" charset="utf-8" ></script>

<!-- 数据源信息列表start -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>数据源管理</h1>
    </section>
    <!-- Main content -->
    <shiro:hasPermission name="db:query">
        <section class="content">
                <div class="box" style="height: auto; background-color: white;">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="box">
                                <div class="box-header">
                                    <h3 class="box-title">数据源信息列表 :${sessionScope.login_session_admin.userName}</h3>
                                </div>
                                <!-- 表格列表start -->
                                <div class="box">
                                    <div class="box-body">
                                        <div class="site-demo-button" >
                                            <button data-method="setAddOrEdit" id="add" class="layui-btn layui-btn-small"><i class="layui-icon"></i><span>&nbsp;&nbsp;新增</span></button>
                                        </div>
                                        <table id="example1" class="table table-bordered table-striped">
                                            <thead>
                                            <tr>
                                                <th field="sys_xh">序号</th>
                                                <th>数据码</th>
                                                <th>源地址</th>
                                                <th>源端口</th>
                                                <th>源名称</th>
                                                <th>用户名</th>
                                                <th>密码</th>
                                                <th>状态</th>
                                                <th>操作</th>
                                            </tr>
                                            </thead>
                                            <tbody id="show-data">
                                            <c:forEach items="${list}" var="r" varStatus="st">
                                                <tr>
                                                    <td>${(st.index + 1)} </td>
                                                    <td>${r.code}</td>
                                                    <td>${r.ip}</td>
                                                    <td>${r.port}</td>
                                                    <td>${r.name}</td>
                                                    <td>${r.user}</td>
                                                    <td>${r.password}</td>
                                                    <td>
                                                    <c:if test="${r.use==true }">启用</c:if>
                                                    <c:if test="${r.use==false }">禁用</c:if>
                                                    </td>
                                                    <td>
                                                        <div class="site-demo-button" >
                                                            <button id="update" data-method="setAddOrEdit" value="${r.code}" class="layui-btn layui-btn-normal layui-btn-small"><i class="layui-icon"></i><span>&nbsp;&nbsp;修改</span></button>
                                                            <button id="delete" data-method="delete" type="${r.use}" value="${r.code}"     class="layui-btn layui-btn-danger layui-btn-small"><i class="layui-icon"></i><span>&nbsp;&nbsp;删除</span></button>
                                                            <button id="offset" data-method="offset" value="${r.code}" class="layui-btn layui-btn-normal layui-btn-small"><i class="layui-icon"></i><span>&nbsp;&nbsp;启用</span></button>
                                                        </div>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
        </section>
    </shiro:hasPermission>
</div>

<script>
    //新增数据弹窗
    layui.use('layer', function(){ //独立版的layer无需执行这一句
        var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句
        //触发事件
        var active = {
            setAddOrEdit: function(data){
                var code = data.val();
                setAddOrEdit(code);
            },
            //启用数据弹窗
            offset: function(data){
                var code = data.val();
                var requestUrl="<%=request.getContextPath()%>/admin/setUseDB";
                var text = "确定要启用此条数据吗？启用后需重启服务生效。";
                userOffSet(1,requestUrl, code,text);
            },
            delete : function (data) {
                var code = data.val();
                var type = data.attr("type");
                if(type=="true"){
                    layer.msg("正在使用的数据不可删除", {icon: 1,time: 1000});//1秒关闭
                    return;
                }
                var requestUrl="<%=request.getContextPath()%>/admin/delDB";
                var text = "确定要删除此条数据吗？";
                userOffSet(0,requestUrl, code,text);
            }
        };
        $('.site-demo-button .layui-btn').on('click', function(){
            var othis = $(this), method = othis.data('method');
            active[method] ? active[method].call(this, othis) : '';
        });
    });


    //新增、编辑打开
    var setAddOrEdit = function(code){
        //多窗口模式，层叠置顶
        layer.open({
            type: 2,
            title: '新增/修改 数据源信息',
            area: ['100%', '100%'],
            shade: 0.5,
            anim: 3,//0-6的动画形式，-1不开启
            content: '<%=request.getContextPath()%>/admin/addOrEdit?code='+code,
            zIndex: layer.zIndex, //重点1
            success: function (layero, index) {
                var body = layer.getChildFrame('body', index);
                //弹窗表单的取消操作时关闭弹窗
                var canclebtn = body.find('button[name="cancleSubmit"]').click(function cancleSubmit() {
                    layer.closeAll();
                });
            }
        });
    };



    var userOffSet = function (type ,requestUrl,code,text) {
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
                    data: {"code":code},
                    dataType: "json",
                    cache:false,
                    success: function(data){
                        var code = data.code;
                        var msg = data.message;
                        if(code == "200"){
                            layer.msg(msg, {icon: 1,time: 2000});//2秒关闭
                            //刷新页面
                            location.reload();
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

