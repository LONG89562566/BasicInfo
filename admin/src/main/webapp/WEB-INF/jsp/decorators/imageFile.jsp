<%@ page contentType="text/html;charset=UTF-8"%>
<%
    //业务表主键
    String docUnid = request.getParameter("docUnid");
    //流程节点主键
    String flowId = request.getParameter("flowId");
    //类型
    String type = request.getParameter("type");
    //图片显示标题
    String imageTitle = request.getParameter("imageTitle");
    //类型
    String imageLable = request.getParameter("imageLable");
%>
<div class="layui-inline">
    <label class="layui-form-label">上传<%=imageTitle%>图片：</label>
    <div class="layui-input-inline">
        <input type="file" id="<%=imageLable%>File" name="imgFiles" class="layui-upload-file"/>
        <span style="color: red" id="s-<%=imageLable%>"></span>
    </div>
</div>
<div class="layui-inline">
    <ul>
        <li>
            <img id="<%=imageLable%>Img" src="" onclick="imgShow($(this))"/>
        </li>
    </ul>
</div>
<script type="text/javascript">
    //提交表单数据
    layui.use([ 'jquery','upload'], function(){
        var $ = layui.jquery;
        //上传<%=imageTitle%>图片
        layui.upload({
            url: '<%=request.getContextPath()%>/admin/uploadImgs?dir=image&docUnid=<%=docUnid%>&flowId=<%=flowId%>&type=<%=type%>',//上传接口
            elem: '#<%=imageLable%>File', //指定原始元素，默认直接查找class="layui-upload-file"
            success: function(res){
                _showImage(res , "<%=imageLable%>Img");
            }
        });
    });

    function imgShow(_this){
        var src = _this.attr("src");
        $("#bigimg").attr("src", src);
        $("<img/>").attr("src", src).load(function(){
            var windowW = $(window).width();
            var windowH = $(window).height();
            var realWidth = this.width;
            var realHeight = this.height;
            var imgWidth, imgHeight;
            var scale = 0.8;

            if(realHeight>windowH*scale) {
                imgHeight = windowH*scale;
                imgWidth = imgHeight/realHeight*realWidth;
                if(imgWidth>windowW*scale) {
                    imgWidth = windowW*scale;
                }
            } else if(realWidth>windowW*scale) {
                imgWidth = windowW*scale;
                imgHeight = imgWidth/realWidth*realHeight;
            } else {
                imgWidth = realWidth;
                imgHeight = realHeight;
            }
            $("#bigimg").css("width",imgWidth);

            var w = (windowW-imgWidth)/2;
            var h = (windowH-imgHeight)/2;
            $("#innerdiv").css({"top":h, "left":w});
            $("#outerdiv").fadeIn("fast");
        });
        $("#outerdiv").click(function(){
            $(this).fadeOut("fast");
        });
    }
</script>