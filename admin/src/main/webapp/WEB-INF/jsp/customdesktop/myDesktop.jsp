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
    <%@include file="/WEB-INF/jsp/decorators/meta.jsp" %>
  <style type="text/css">
    .inner p{
       font-size:19px;
    }
    .inner h3{
      font-size:24px;
    }
    table th{
      background:#ffffff;
    }
	table tr:nth-child(odd){
	  background:#F0F0F0;
	}
	.col-lg-7 {
      width: 1120px; 
    }
      .fl{float: left;}
      .fr{float: right;}
  </style>
</head>
<body>
     <div class="content-wrapper">
         <section class="content-header">
           <h1>我的桌面</h1>
         </section>
         <section class="content">
             <div style="width: 100%;">
             <c:forEach items="${customDesktopLs}" var="r" varStatus="st">
                  <iframe src="${r.menuHref}/desktop" style="width: 50%;min-height: 320px;height: ${r.height}" class="fl"></iframe>
             </c:forEach>
             </div>
         </section>
     </div>

<script src="/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="/js/jquery-ui.min.js"></script>
<script>
  $.widget.bridge('uibutton', $.ui.button);
</script>
<script src="/bootstrap/js/bootstrap.min.js"></script>
<script src="/js/raphael-min.js"></script>
<script src="/plugins/sparkline/jquery.sparkline.min.js"></script>
<script src="/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script src="/js/moment.min.js"></script>
<script src="/plugins/daterangepicker/daterangepicker.js"></script>
<script src="/plugins/datepicker/bootstrap-datepicker.js"></script>
<script src="/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script src="/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="/plugins/fastclick/fastclick.js"></script>
<script src="/dist/js/app.min.js"></script>
<script src="/dist/js/demo.js"></script>
<script src="/layer/layer.js"></script>
<script src="/echart/www/js/echarts.js"></script>
<script src="/echart/asset/js/codemirror.js"></script>
<script src="/echart/asset/js/javascript.js"></script>
<script type="text/javascript">

</script>
</body>
</html>