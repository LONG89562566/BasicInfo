<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="pv" uri="/pageTaglib"%>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName();
    String port = String.valueOf(request.getServerPort());
    if(port.equals("80")) {
        basePath += path+"/";
    } else {
        basePath += ":" + port+path+"/";
    }
    request.setAttribute("basePath", basePath);
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/jquery-easyui-1.5.2/themes/default/easyui.css"/>
<link rel="stylesheet" href="/layui/css/layui.css"  media="all">
<script type="text/javascript" src="/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script type="text/javascript" src="/jquery-easyui-1.5.2/jquery.easyui.min.js" charset="utf-8"></script>
<script type="text/javascript" src="/jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
<script type="text/javascript" src="/js/jquery.formPlugin.js"></script>
<script type="text/javascript" src="/js/jquery.form.js"></script>
<script type="text/javascript" src="/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="/layui/layui.js"></script>
<script type="text/javascript" src="/dist/js/app.min.js"></script>
<script type="text/javascript" src="/js/fromVal.js"></script>
<script type="text/javascript" src="/My97DatePicker/WdatePicker.js" charset="utf-8" ></script>


<style type="text/css">
    .layui-input-inline{
        margin-left:30px;
    }
    .layui-input-inline{
        padding:5px;
    }
</style>
<script type="text/javascript">

    $(function(){
        //修改时图片回显
        var imgUrl = $("img").attr("src");
        if(imgUrl!=null && imgUrl!=''){
            $("img").show();
        }
    });

    function _showImage(res , imagLable){
        var code = res.code;
        if(code == "200"){
            layer.msg("上传图片成功", {icon: 1,time: 1200});
            var imgUrl = res.object[0];
            var showImgUrl = res.object[0];
            //将上传图片显示
            $("#"+imagLable).attr("src",showImgUrl);
            $("#"+imagLable).show();
        }
    }

</script>
