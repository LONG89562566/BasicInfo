var _loadFileUtilLs = function (fileLable,docUnid,flowId,type) {
    var _loadUrlImg = "/admin/fileAttr/query";
    $.post(_loadUrlImg,{docUnid: docUnid,flowId: flowId ,type: type },function (data) {
        if(data.code == 200){
            var obj = data.object;
            if(obj != null  && obj != undefined){
                $.each(obj,function (i,item) {
                    _addFileHtml(fileLable,item);
                });
            }
        }
    });
};

var _showFileLs = function (res , fileLable){
    var code = res.code;
    if(code == "200"){
        layer.msg("上传文件成功", {icon: 1,time: 1200});
        var fileAttrs = res.fileAttrs;
        if(fileAttrs != undefined && fileAttrs != null){
            $.each(fileAttrs,function (i,item) {
                _addFileHtml(fileLable,item);
            });
        }
    }
};

var _addFileHtml = function (fileLable,obj) {
    $("#"+fileLable).append( "            <tr>" +
        "<td><div style='width: 90%;margin-left: 10px;float: left;'>"+obj.name+"</div></td>" +
        "<td align='center' valign=\"middle\"><div style='width: 100%;margin-left: 10px;float: left;'> " +
        "<input type='button' class='layui-btn' value='下载' onclick='_downFile(\""+obj.fileId+"\")'></div></td>" +
        "</tr>\n");
};

var _downFile = function (fileId) {
    window.open("/admin/dowLoadFile?fileId="+fileId);
};
