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

<div class="box-header">
    <h3 class="box-title"><%=imageTitle%>图片</h3>
</div>
<div class="form-group" >
    <label for="inputEmail3" class="col-sm-2 control-label"><input type="button" id="J_selectImage" class="btn btn-info" value="上传图片" /></label>
    <div class="col-xs-3">
        <span id="<%=imageLable%>ProductPicCount"></span>
    </div>
</div>
<div class="form-group" >
    <div class="col-xs-12">
        <div id="<%=imageLable%>picList" style="width:100%;overflow:auto;height:160px;"></div>
    </div>
</div>
<style>
    .picItem-div{width: 20%;float: left;text-align: center;}
</style>
<script type="text/javascript">

    var picList,productPicCount = null;
    var _sort = ${fn:length(goods.pictureList)};

    KindEditor.ready(function(K) {
        var editor = K.editor({
            uploadJson : '<%=request.getContextPath()%>/admin/upload?dir=image&docUnid=<%=docUnid%>&flowId=<%=flowId%>&type=<%=type%>',
            allowFileManager : true,
            imageUploadLimit: productPicCount-uploadCount
        });
        K('#J_selectImage').click(function() {
            if(productPicCount-uploadCount==0){
                $.messager.alert('错误','您最多只能上传5张图片！','error');
                return;
            }
            editor.loadPlugin('multiimage', function() {
                editor.plugin.multiImageDialog({
                    clickFn : function(urlList) {
                        K.each(urlList, function(i, data) {
                            var _rowHtml = '<div id="picItem_0" class="unit border picItem-div"><input type="hidden" name="pictureList['+_sort+'].picUrl" value="'+data.url.replace("~/", "")+'" />'
                                +'<img id="uploadUrl" src="'+data.url.replace("~/", "")+'" onclick="imgShow($(this))"/>'
                                +'<div class="line txtL">'
                                +'   <span>排序</span>' +
                                '<input id="sortText" name="pictureList['+_sort+'].picSeq" type="text" class="ui-text" style="width:20px;" value="'+_sort+'" title="'+_sort+'" onblur="setSort(this,'+_sort+',\'<%=imageLable%>picList\');" />\
                                                    <br/>\
                                                    <a class="ui-icon14" href="javascript:void(0);" onclick="removeItem('+_sort+',\'<%=imageLable%>ProductPicCount\');" title="删除">删除<i class="icon14 icon14-delete"></i></a>\
                                                </div>\
                                            </div>';

                            $("#<%=imageLable%>picList").append(_rowHtml);
                            _sort++;
                        });
                        uploadCount = uploadCount+urlList.length;
                        editor.imageUploadLimit = productPicCount-uploadCount;
                        updateUploadtxt("<%=imageLable%>ProductPicCount",productPicCount,uploadCount);
                        editor.hideDialog();
                    }
                });
            });
        });
    });

    function updateUploadtxt(ProductPicCount,productPicCount,uploadCount){
        //剩余数量
        var _difLength= productPicCount-uploadCount;
        $('#'+ProductPicCount).html("还可以上传<font color=red>" + _difLength + "</font>张图片");
    }


    function setSort(obj, divId,pidListLable) {
        var currentDiv = null;
        if (divId != undefined) {
            var _sortObj = $(obj);
            if (_sortObj.val() != "" && _sortObj.attr("title") != _sortObj.val()) {
                _sortObj.attr("title", _sortObj.val());
                currentDiv = $("#picItem_" + divId);
            }
        }
        if (currentDiv != null) {
            //将当前这个设置为半透明
            currentDiv.find("img").animate({ opacity: 0.3 });
            //排序主代码
            var picItem = $("#"+pidListLable).find("div.unit:visible").toArray().sort(function (a, b) {
                return parseInt($(a).find("#sortText").val()) - parseInt($(b).find("#sortText").val())
            });
            $(picItem).appendTo($("#"+pidListLable));
            //将当前这个设置为不透明
            currentDiv.find("img").animate({ opacity: 1 });
        }
    }

    //移出Item,不删除数据
    function removeItem(divId,numLable) {
        if (divId != undefined) {
            $.messager.confirm('确认','是否确认删除?删除后无法恢复！',function(r){
                if (r){
                    var currentDiv = $("#picItem_" + divId);
                    if (currentDiv != null) {
                        var picId = currentDiv.attr("tabindex");
                        if(undefined==picId){
                            currentDiv.remove();
                            uploadCount--;
                            editor.imageUploadLimit = productPicCount-uploadCount;
                            updateUploadtxt(numLable,productPicCount,uploadCount);
                            return;
                        }
                        var picUrl = currentDiv.attr("taburl");
                        //异步提交开始
                        $.ajax({
                            type: "POST",
                            url: "/admin/goods/deleteGoodsPicture?picId="+picId+"&picUrl="+picUrl,
                            dataType: 'json',
                            cache:false,
                            complete:function(){
                                ajaxUpdateing = false;
                            },
                            success: function (result) {
                                if (result.object > 0) {
                                    currentDiv.remove();
                                    uploadCount--;
                                    editor.imageUploadLimit = productPicCount-uploadCount;
                                    updateUploadtxt(numLable,productPicCount,uploadCount);
                                }else {
                                    $.messager.alert('错误','删除失败！','error');
                                }
                            },
                            error: function (status) {
                                $.messager.alert('错误','删除失败！','error');
                            }
                        });

                    } else {
                        currentDiv.remove();
                        uploadCount--;
                        editor.imageUploadLimit = productPicCount-uploadCount;
                        updateUploadtxt(numLable,productPicCount,uploadCount);
                    }
                }
            });
        }else{
            $.messager.alert('错误','数据有误，无法删除，请联系管理员！','error');
        }
    }

</script>
