/**
 * 分页模板的渲染方法
 * @param templateId 分页需要渲染的模板的id
 * @param resultContentId 模板渲染后显示在页面的内容的容器id
 * @param data 服务器返回的json对象
 */
function renderTemplate(templateId, resultContentId, data){
    layuiuse(['form','laytpl'], function(){
        var laytpl = layui.laytpl;
        laytpl($("#"+templateId).html()).render(data, function(html){
            $("#"+resultContentId).html(html);
        });
    });
    layui.form().render();// 渲染
};

/**
 * layuilaypage 分页封装
 * @param laypagepId 分页控件p层的id
 * @param pageParams 分页的参数
 * @param templateId 分页需要渲染的模板的id
 * @param resultContentId 模板渲染后显示在页面的内容的容器id
 * @param url 向服务器请求分页的url链接地址
 */
function renderPageData(laypagepId, pageParams, templateId, resultContentId, url){
    if(isNull(pageParams)){
        pageParams = {
            pageIndex : 1,
            pageSize : 10
        }
    }
    $ajax({
        url : url,//basePath + '/sysMenu/pageSysMenu',
        method : 'post',
        data : pageParams,//JSON.stringify(datasub)
        async : true,
        complete : function (XHR, TS){},
        error : function(XMLHttpRequest, textStatus, errorThrown) {
            if("error"==textStatus){
                error("服务器未响应，请稍候再试");
            }else{
                error("操作失败，textStatus="+textStatus);
            }
        },
        success : function(data) {
            var jsonObj;
            if('object' == typeof data){
                jsonObj = data;
            }else{
                jsonObj = JSON.parse(data);
            }
            renderTemplate(templateId, resultContentId, jsonObj);

            //重新初始化分页插件
            layui.use(['form','laypage'], function(){
                laypage = layui.laypage;
                laypage({
                    cont : laypagepId,
                    curr : jsonObj.pager.pageIndex,
                    pages : jsonObj.pager.totalPage,
                    skip : true,
                    jump: function(obj, first){//obj是一个object类型。包括了分页的所有配置信息。first一个Boolean类，检测页面是否初始加载。非常有用，可避免无限刷新。
                        pageParams.pageIndex = obj.curr;
                        pageParams.pageSize = jsonObj.pager.pageSize;
                        if(!first){
                            renderPageData(laypagepId, pageParams, templateId, resultContentId, url);
                        }
                    }
                });
            });
        }
    });
};

/**
 * 分页插件刷新当前页的数据，必须有跳转的确定按钮，因为根据按钮点击事件刷新
 */
function reloadCurrentPage(){
    $(".layui-laypage-btn").click();
};

/***
 * 分页参数：
 * @returns {{pageIndex: number, pageSize: number}}
 */
function getPageParams(){
    var pageParams = {
        pageIndex : 1,
        pageSize : 2
    };
    pageParams.permissionName = $("input[name='permissionName']").val();
    pageParams.permissionCode = $("input[name='permissionCode']").val();
    pageParams.menuName = $("input[name='menuName']").val();
    return pageParams;
};

/***
 * 分页执行方法
 */
function initPage(){
    renderPageData("imovie-page-p", getPageParams(), "page_template_id",
        "page_template_body_id", basePath + '/sysPermission/pageSysPermission');
};