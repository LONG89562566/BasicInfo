<%@ page contentType="text/html;charset=UTF-8"%>
<%
    //业务表主键
    String docUnid = request.getParameter("docUnid");
    //流程节点主键
    String flowId = request.getParameter("flowId");
    //类型
    String type = request.getParameter("type");
    //图片显示标题
    String fileTitle = request.getParameter("fileTitle");
    //类型
    String fileLable = request.getParameter("fileLable");
    //数据操作类型 add 新增 edit 编辑
    String fn = request.getParameter("fn");
%>
<div class="layui-inline">
    <label class="layui-form-label">上传<%=fileTitle%>文件：</label>
    <div class="layui-input-inline">
        <input type="file" id="<%=fileLable%>File" name="uloadFile" class="layui-upload-file"/>
        <span style="color: red" id="s-<%=fileLable%>"></span>
    </div>
</div>
<div class="layui-inline" id="div-<%=fileLable%>-img" style="width:96%;">
    <div id="ul-<%=fileLable%>-file" style="width:96%;margin-left: 2%;min-height: 200px;height: 200px;overflow: scroll;">
        <table style="border: 1px solid #f4f4f4;width: 100%;border-collapse: collapse;
            border-spacing: 0;background-color: transparent; max-width: 100%;" width="100%" border="1px" cellspacing="1" cellpadding="0">
            <thead>
                <th width="70%">文件名</th>
                <th width="30%">操作</th>
            </thead>
            <tbody id="data-<%=fileLable%>-tbody">

            </tbody>
        </table>
    </div>
</div>
<script type="text/javascript">
    //提交表单数据
    layui.use([ 'jquery','upload'], function(){
        var $ = layui.jquery;
        //上传<%=fileLable%>图片
        layui.upload({
            url: '<%=request.getContextPath()%>/admin/uploadFileAttr?dir=fileAll&docUnid=<%=docUnid%>&flowId=<%=flowId%>&type=<%=type%>',//上传接口
            elem: '#<%=fileLable%>File', //指定原始元素，默认直接查找class="layui-upload-file"
            type:'file',
            ext:'doc|docx|xls|xlsx|ppt|htm|html|xml|txt|zip|rar|gz|bz2|gif|jpg|jpeg|png|bmp|swf|flv|swf|flv|mp3|wav|wma|wmv|mid|avi|mpg|asf|rm|rmvb',
            success: function(res){
                _showFileLs(res , "data-<%=fileLable%>-tbody");
            }
        });
    });

    $(function () {
        if("edit" == '<%=fn%>'){
            _loadFileUtilLs("data-<%=fileLable%>-tbody",'<%=docUnid%>','<%=flowId%>','<%=type%>');
        }
    });

</script>