/**
 * 根据分页参数返回分页的html脚本
 * @param pageVo
 * @author ljuenan
 * @createTime 2018/7/5 16:37
 */
var getPageVoHtml =function (pageVo) {
    var out = "";
    if (!pageVo) {
        return out;
    }
    if (pageVo.totalPage > 0) {
        out +=  "<li><a href='javascript:onSelectPage(" + (0) + "," + pageVo.pageRecord + ")'>首页</a></li>";
        out +=  "<li><a href='javascript:onSelectPage(" + (pageVo.currentPage - 1) + "," + pageVo.pageRecord + ")'>上一页</a></li>";		
		
        if (pageVo.totalPage <= 10) {
            for (var i = 1; i <= pageVo.totalPage; i++) {
				out += addPageHtml(i, pageVo.currentPage ,pageVo.pageRecord);
            }
        }

        if (pageVo.totalPage > 10) {
            if (pageVo.currentPage < 10) {				
                for (i = 1; i <= 10; i++) {
					out += addPageHtml( i, pageVo.currentPage ,pageVo.pageRecord);
                }
            }
			
            if (pageVo.currentPage >= 10) {				
                for (var j = pageVo.currentPage - 5; j <= pageVo.currentPage + 4; j++) {
                    if (j <= pageVo.totalPage) {
						out += addPageHtml( j, pageVo.currentPage ,pageVo.pageRecord);
                    }
                }
            }
        }

        if(pageVo.currentPage < pageVo.totalPage){
            out += "<li><a href='javascript:onSelectPage(" + (pageVo.currentPage + 1) + "," + pageVo.pageRecord + ")'>下一页</a></li>";
        }else{
            out += "<li class='disabled'><a href='javascript:void(0);'>下一页</a></li>";
        }
		
        out += "<li><a href='javascript:onSelectPage(" + (pageVo.totalPage) + "," + pageVo.pageRecord + ")'>尾页</a></li>";
        out += "<li>每页显示<select onchange='onSelectPage(" + (pageVo.currentPage) + ",this.value)'>";
        for(var i=0;i<200;i=i+10){
            var val = i+ 10;
            if(pageVo.pageRecord == val){
                out +=  "<option value='"+val+"' selected>"+val+"</option>";
            }else{
                out +=  "<option value='"+val+"'>"+val+"</option>";
            }
        }
        out +=  "</select>条</li>";
        out +=  "<li><a href='#'>共" + pageVo.totalRecord + "条,当前是第" + pageVo.currentPage + "页，共" + pageVo.totalPage + "页</a></li>";
    }
    return out;
};

var addPageHtml = function( index , currentPage, pageRecord){
	if (index == currentPage) {
		return  "<li class='active'><a href='javascript:onSelectPage(" + index + "," + pageRecord + ")'>" + index + "</a></li>";
	} else {
		return "<li><a href='javascript:onSelectPage(" + index + "," + pageRecord + ")'>" + index + "</a></li>";
	}
};

//选择页码
var onSelectPage = function(currentPage,pageSize){
    $('#pageNum').val(currentPage);
    $('#pageSize').val(pageSize);
    loadSelectPageDat($('#pageNum').val(),$('#pageSize').val());
};

//刷新当前页面
var  refreshTheCurrentPage = function () {
    loadSelectPageDat($('#pageNum').val(),$('#pageSize').val());
};
//刷新当前页面
var  resetRefreshTheCurrentPage = function () {
    loadThisPageData($('#pageNum').val(),$('#pageSize').val(),{},"");
};

//局部刷新页面
var loadSelectPageDat = function (currentPage,pageSize) {
    $('#pageNum').val(currentPage);
    $('#pageSize').val(pageSize);

    if( _queryConditionForrId == undefined || _queryConditionForrId == "" ||  _queryConditionForrId.length == 0) {
        _queryConditionForrId = "form_submit";
    }

    var json = serializeFormPost(_queryConditionForrId);
    var parm = serializeFormGet(_queryConditionForrId);

    loadThisPageData(currentPage,pageSize,json,parm);
};

//局部刷新页面
var loadThisPageData = function (currentPage,pageSize,json,parm) {
    $('#pageNum').val(currentPage);
    $('#pageSize').val(pageSize);


    $.post(pageQueryUrl+"?"+parm,json,function (data) {
        if(data.code=="200" || data.code=="201"){
            var object = data.object.object;
            var currentPage = data.object.currentPage;
            var pageRecord = data.object.pageRecord;
            var showField = tableField(showFieldId);

            $("#"+showFieldData).empty();
            $.each(object,function (i,n) {
                var html = "";
                $.each(showField,function (j, f) {
                    if(f.name == "sys_xh" && f.describe == "序号"){
                        html += "<td> "+ ((i + 1)  + (currentPage - 1) * pageRecord  )+"</td>";
                    }else if(f.name == "sys_opt" && f.describe == "操作"){
                        html += "<td>";
                        html += "<div class='site-demo-button' >";
                        $.each(tableBtn,function (index, btn) {
                            // methodField,isShowMethod,showMethodVal
                            var methodField = "";
                            var showMethodVal = "";
                            if(btn.methodField != "" && btn.methodField != undefined && btn.methodField.length > 0){
                                methodField = n[btn.methodField];
                                if(btn.isShowMethod != "" && btn.isShowMethod != undefined && btn.isShowMethod.length > 0 && btn.isShowMethod == 'true'){
                                    isShowMethod = btn.isShowMethod;
                                    if(btn.showMethodVal != "" && btn.showMethodVal != undefined && btn.showMethodVal.length > 0 && isShowMethod){
                                        showMethodVal = btn.showMethodVal;
                                        if(showMethodVal != methodField){
                                            return true;
                                        }
                                    }
                                }
                            }

                            if(btn.jurisdiction != "" && btn.jurisdiction != undefined && btn.jurisdiction.length > 0){
                                html += "<shiro:hasPermission name='"+btn.jurisdiction+"'>";
                            }

                            if(btn.otherFiled == "" || btn.otherFiled == undefined || btn.otherFiled.length == 0 || !btn.otherFiled){
                                html += "<button id='updatePlantationsMassif' style='margin: 2px 2px 2px 2px;' onclick='"+btn.method+"(\""+ n[primarykey]+"\")' value='"+ n[primarykey]+"' class='layui-btn "+btn.btnClass+" layui-btn-small'>";
                            }else{
                                html += "<button id='updatePlantationsMassif' style='margin: 2px 2px 2px 2px;' onclick='"+btn.method+"(\""+ n[primarykey]+"\",\""+n[btn.otherFiled]+"\")' value='"+ n[primarykey]+"' class='layui-btn "+btn.btnClass+" layui-btn-small'>";
                            }
                            if(btn.icon != "" && btn.icon != undefined && btn.icon.length > 0){
                                html += "<i class='"+btn.icon+"'></i>";
                            }
                            html +=  "<span>&nbsp; "+btn.name+"&nbsp;</span></button>";

                            if(btn.jurisdiction != "" && btn.jurisdiction != undefined && btn.jurisdiction.length > 0){
                                html += "</shiro:hasPermission>";
                            }
                        });
                        html += "</div>";
                        html += "</td>";
                    }else{

                        if(f.type == "img" || f.type == "IMG"){
                            if(f.imgWidth == undefined || f.imgWidth == '' || f.imgWidth.length == 0){
                                f.imgWidth = "275px";
                            }
                            if(f.imgHeight == undefined || f.imgHeight == '' || f.imgHeight.length == 0){
                                f.imgHeight = "125px";
                            }
                            html += "<td><div style='width:"+f.imgWidth+" ;height: "+f.imgHeight+";'><img onclick='_showImg(this)' width='100%' src='"+n[f.name]+"'/></div></td>";
                        }else  if(f.type == "Date" || f.type == "date"){
                           html += "<td>"+ (formatDateTime (n[f.name]) )+"</td>";
                       } else {
                           html += "<td";
                           if(f.getIdVal != "" && f.getIdVal != undefined && f.getIdVal.length > 0 ){
                               html += " id='"+n[f.getIdVal]+"' ";
                           }
                           html += ">";
                           if(f.method != "" && f.method != undefined && f.method.length > 0){
                               html +=  eval(f.method+'("'+n[f.name]+'","'+n[primarykey]+'")')+"</td>";
                           }else{
                               html +=  n[f.name]+"</td>";
                           }
                       }
                    }
                });
                $("#"+showFieldData).append("<tr id="+n[primarykey]+">" + html + "</tr>");
            });
            //分页插件代码
            var paginatorHtml =  getPageVoHtml(data.object);
            $("#"+showPageNumber).html(paginatorHtml);
        }
    });
};
/**
 * 拼接字符
 * @param out
 * @param newOut
 * @returns {*}
 */
var appendHtml = function (out,newOut) {
    return out+newOut;
};

var tableField = function(tableId){
    var filedObj = new Array();
    $("#"+tableId+" tr").each(function(i){                   // 遍历 tr
        $(this).children('th').each(function(j){  // 遍历 tr 的各个 th
            var filed =new Object();
            filed.describe = $(this).text();
            filed.name = $(this).attr("field"); //字段名称
            filed.type = $(this).attr("type");  //字段类型
            filed.format = $(this).attr("format"); //日期时间格式
            filed.method = $(this).attr("method");  //字段调用的方法
            filed.getIdVal = $(this).attr("getIdVal");  //是否需要设置id在td上
            filed.imgWidth = $(this).attr("imgWidth");  //图片的宽度
            filed.imgHeight = $(this).attr("imgHeight"); //图片的高度
            filedObj.push(filed);
        });
    });
    return filedObj;
};
/***
 * 添加表格操作按钮
 * @param addBtn 按钮数组
 * @param method 方法 （addOrEdit）
 * @param name 显示名称 （修改）
 * @param jurisdiction 权限（material:update）
 * @param icon 图标（<i class='layui-icon'></i>）
 * @param methodField 调用方法需要传入字段名称
 * @param isShowMethod 调用方法是否更加 传入字段名称取得值进行显示
 * @param showMethodVal 调用方法根据传入字段名称去的值进行匹配设置的值是否相等
 * @param btnClass 添加button Class 样式名称
 * @param otherFiled 其他字段
 * @returns {*}
 */
var addBtn = function (addBtn, method, name , jurisdiction, icon, methodField, isShowMethod, showMethodVal,btnClass,otherFiled) {
    if(btnClass == "" || btnClass == undefined || btnClass.length == 0){
        btnClass = "layui-btn-normal";
    }
    var btn = new Object();
    btn.method = method;
    btn.jurisdiction = jurisdiction;
    btn.name = name;
    btn.icon = icon;
    btn.methodField = methodField;
    btn.isShowMethod = isShowMethod;
    btn.showMethodVal = showMethodVal;
    btn.btnClass = btnClass;
    btn.otherFiled = otherFiled;
    addBtn.push(btn);
    return addBtn;
};

var showDivImg = "<div id='_outerdiv' style='position:fixed;top:0;left:0;background:rgba(0,0,0,0.7);z-index:2;width:100%;height:100%;display:none;'>\n" +
    "    <div id='_innerdiv' style='position:absolute;'>\n" +
    "        <img id='_bigimg' style='border:5px solid #fff;' src='' />\n" +
    "    </div>\n" +
    "</div>";

$(function(){
    $("body").append(showDivImg);
});

function _showImg(obj) {
    imgShow("#_outerdiv", "#_innerdiv", "#_bigimg", obj);
}

function imgShow(outerdiv, innerdiv, bigimg, _this){
    var src = $(_this).attr("src");//获取当前点击的pimg元素中的src属性
    $(bigimg).attr("src", src);//设置#bigimg元素的src属性

    /*获取当前点击图片的真实大小，并显示弹出层及大图*/
    $("<img/>").attr("src", src).load(function(){
        var windowW = $(window).width();//获取当前窗口宽度
        var windowH = $(window).height();//获取当前窗口高度
        var realWidth = this.width;//获取图片真实宽度
        var realHeight = this.height;//获取图片真实高度
        var imgWidth, imgHeight;
        var scale = 0.8;//缩放尺寸，当图片真实宽度和高度大于窗口宽度和高度时进行缩放

        if(realHeight>windowH*scale) {//判断图片高度
            imgHeight = windowH*scale;//如大于窗口高度，图片高度进行缩放
            imgWidth = imgHeight/realHeight*realWidth;//等比例缩放宽度
            if(imgWidth>windowW*scale) {//如宽度扔大于窗口宽度
                imgWidth = windowW*scale;//再对宽度进行缩放
            }
        } else if(realWidth>windowW*scale) {//如图片高度合适，判断图片宽度
            imgWidth = windowW*scale;//如大于窗口宽度，图片宽度进行缩放
            imgHeight = imgWidth/realWidth*realHeight;//等比例缩放高度
        } else {//如果图片真实高度和宽度都符合要求，高宽不变
            imgWidth = realWidth;
            imgHeight = realHeight;
        }
        $(bigimg).css("width",imgWidth);//以最终的宽度对图片缩放

        var w = (windowW-imgWidth)/2;//计算图片与窗口左边距
        var h = (windowH-imgHeight)/2;//计算图片与窗口上边距
        $(innerdiv).css({"top":h, "left":w});//设置#innerdiv的top和left属性
        $(outerdiv).fadeIn("fast");//淡入显示#outerdiv及.pimg
    });

    $(outerdiv).click(function(){//再次点击淡出消失弹出层
        $(this).fadeOut("fast");
    });
}