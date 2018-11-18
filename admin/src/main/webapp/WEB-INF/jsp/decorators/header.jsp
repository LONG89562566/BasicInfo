<%@ page contentType="text/html;charset=UTF-8"%>  
<header class="main-header">
    <style>
        .head-img{
        box-sizing:  border-box    ;
        color:                rgb(51, 51, 51)    ;
        display:                block    ;
        float:                left    ;
        font-family:                "Microsoft YaHei"    ;
        font-size:                14px    ;
        font-stretch:                100%    ;
        font-style:                normal    ;
        font-variant-caps:                normal    ;
        font-variant-east-asian:                normal    ;
        font-variant-ligatures:                normal    ;
        font-variant-numeric:                normal    ;
        font-weight:                400    ;
        height:                47.6462px
    ;
        line-height:                normal    ;
        margin-bottom:                0px    ;
        margin-left:                0px    ;
        margin-right:                0px    ;
        margin-top:                0px    ;
        padding-bottom:                0px    ;
        padding-left:                0px    ;
        padding-right:                0px    ;
        padding-top:                0px    ;
        text-size-adjust:                100%    ;
        white-space:                nowrap    ;
        width:                45px    ;
        -webkit-tap-highlight-color:                rgba(0, 0, 0, 0)    ;}
    </style>
   <a href="/admin/index" class="logo">
     <span class="logo-lg"><b>信息管理平台</b></span>
   </a>
   <nav class="navbar navbar-static-top">
     <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
       <span class="sr-only"></span>
     </a>

     <div class="navbar-custom-menu">
         <div style="margin: 10px 10px 10px 10px;">
             <div style="float: left;margin-right: 10px;">
                <a target="frame" onclick="addHist('/admin/customDesktop/setDesktop')"  href="/admin/customDesktop/setDesktop">
                    <div style="width: 20px;height: 20px;float: left;" title="桌面设置"><img  width="100%" src="/dist/img/ioc-set.png" class="user-image" alt="User Image"/></div>
                    <span  style="color: #ffffff;float: right;font-size: 14px;margin-top: 2px;margin-left: 6px;">桌面设置</span>
                </a>
             </div>
             <div style="float: left;margin-right: 10px;">
                 <a href="/admin/logout">
                     <div style="width: 20px;height: 20px;float: left;" class="head-img"><img width="100%" src="/dist/img/ioc-check-out.png" class="user-image" alt="User Image"/></div>
                     <span  style="color: #ffffff;float: right;font-size: 14px;margin-top: 2px;margin-left: 6px;">退出</span>
                 </a>
             </div>
         </div>
     </div>
   </nav>
</header>