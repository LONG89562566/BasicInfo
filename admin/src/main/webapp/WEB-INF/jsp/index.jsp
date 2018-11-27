<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="pv" uri="/pageTaglib"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title></title>
	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
	<!-- 引入公共部分jsp文件 -->
	<meta name="decorator" content="default"/>
	<!--[if lt IE 9]>
	<script src="/js/html5shiv.min.js"></script>
	<script src="/js/respond.min.js"></script>
	<![endif]-->

</head>
<body class="hold-transition skin-blue sidebar-mini">
<!-- 系统用户列表start -->
<div id="content" class="content-wrapper">
    <iframe id="frame"  name="frame" src="" style="width: 100%;height: 100%;" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="no" allowtransparency="yes" ></iframe>
</div>
<script src="/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="/bootstrap/js/bootstrap.min.js"></script>
<script src="/js/raphael-min.js"></script>
<script src="/plugins/sparkline/jquery.sparkline.min.js"></script>
<script src="/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script src="/plugins/knob/jquery.knob.js"></script>
<script src="/js/moment.min.js"></script>
<script src="/plugins/daterangepicker/daterangepicker.js"></script>
<script src="/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script src="/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="/plugins/fastclick/fastclick.js"></script>
<script src="/dist/js/app.js"></script>
<script src="/dist/js/demo.js"></script>
<script src="/js/jquery-ui.min.js"></script>
<script src="/layer/layer.js"></script>
<script src="/layui/layui.js" charset="utf-8"></script>
<script>
    window.onload = function(){
        var currenturl = window.location.href;
        var newUrl = (currenturl.split("#"))[1];
        if(!newUrl){
            // newUrl = "/admin/home";
            newUrl = "/admin/customDesktop/myDesktop";
        }
        $("#frame").css("min-height",$("#content").height());
        $("#frame").attr("src",newUrl);
    }
    $(function(){
/*        $('.sidebar-menu li:not(.treeview) > a').on('click', function(){
            var $parent = $(this).parent();
            $parent.parent().siblings('ul').children().removeClass('active');
            $parent.addClass('active');
        });*/
        $('.sidebar-menu a').each(function(){
            var currenturl = window.location.href;
            var newUrl = (currenturl.split("#"))[1];
            if(this.href.indexOf(newUrl) != -1){
                $(this).parent().addClass('active')
                    .closest('.treeview-menu').addClass('.menu-open')
                    .closest('.treeview').addClass('active');
            }
        });


    });

    var addHist = function (e) {
        var currenturl = window.location.href;
        var newUrl = (currenturl.split("#"))[0];
        history.pushState('','',newUrl+'#'+e);
    }
    // 计算页面的实际高度，iframe自适应会用到
    function calcPageHeight(doc) {
        var cHeight = Math.max(doc.body.clientHeight, doc.documentElement.clientHeight);
        var sHeight = Math.max(doc.body.scrollHeight, doc.documentElement.scrollHeight);
        var height  = Math.max(cHeight, sHeight);
        return height;
    }
    // 计算页面的实际宽度，iframe自适应会用到
    function calcPageWidth(doc) {
        var width = Math.max(doc.body.scrollWidth, doc.documentElement.scrollWidth);
        return width;
    }
    var ifr = document.getElementById('frame')
    ifr.onload = function() {
        var iDoc = ifr.contentDocument || ifr.document;
        var height = calcPageHeight(iDoc);
        var width = calcPageWidth(iDoc);
        ifr.style.height = height + 'px';
        ifr.style.width = width + 'px';
    }



</script>

</body>
</html>