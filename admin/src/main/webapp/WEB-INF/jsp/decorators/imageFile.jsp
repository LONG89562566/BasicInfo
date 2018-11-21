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
            <div style='width:160px ;height: 160px;'><img width="100%" id="<%=imageLable%>Img" src="" onclick="_showImgUtil($(this))"/></div>
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

    $(function () {
        _loadImgUtil("<%=imageLable%>Img",'<%=docUnid%>','<%=flowId%>','<%=type%>');
    });


</script>