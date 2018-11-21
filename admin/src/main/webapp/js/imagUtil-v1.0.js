/**
 * 点击图片放大
 * @param pageVo
 * @author ljuenan
 * @createTime 2018/7/5 16:37
 */

var _showDivImg = "<div id='_outerdiv' style='position:fixed;top:0;left:0;background:rgba(0,0,0,0.7);z-index:2;width:100%;height:100%;display:none;'>\n" +
    "    <div id='_innerdiv' style='position:absolute;'>\n" +
    "        <img id='_bigimg' style='border:5px solid #fff;' src='' />\n" +
    "    </div>\n" +
    "</div>";

$(function(){
    $("body").append(_showDivImg);
});

function _showImgUtil(obj) {
    imgShowUtil("#_outerdiv", "#_innerdiv", "#_bigimg", obj);
}

function imgShowUtil(outerdiv, innerdiv, bigimg, _this){
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

var _loadImgUtil = function (imgLable,docUnid,flowId,type) {
    var _loadUrlImg = "/admin/fileAttr/pageQuery";
    $.post(_loadUrlImg,{docUnid: docUnid,flowId: flowId ,type: type ,pageSize:1},function (data) {
        if(data.code == 200){
            var obj = data.object;
            if(obj != null  && obj != undefined){
                obj = obj.object;
                $("#"+imgLable).attr("src",obj[0].url);
            }
        }
    });
};

var _loadImgUtilLs = function (imgLable,docUnid,flowId,type) {
    var _loadUrlImg = "/admin/fileAttr/query";
    $.post(_loadUrlImg,{docUnid: docUnid,flowId: flowId ,type: type },function (data) {
        if(data.code == 200){
            var obj = data.object;
            if(obj != null  && obj != undefined){
                $.each(obj,function (i,item) {
                    $("#"+imgLable).append("<li>\n" +
                        "            <div style='width:160px ;height: 160px;'><img width=\"100%\" src='"+item.url+"' onclick=\"_showImgUtil($(this))\"/></div>\n" +
                        "        </li>");
                });
            }
        }
    });
};

var _showImage = function (res , imagLable){
    var code = res.code;
    if(code == "200"){
        layer.msg("上传图片成功", {icon: 1,time: 1200});
        var imgUrl = res.object[0];
        var showImgUrl = res.object[0];
        //将上传图片显示
        $("#"+imagLable).attr("src",showImgUrl);
        $("#"+imagLable).show();
    }
};

var _showImageLs = function (res , imagLable){
    var code = res.code;
    if(code == "200"){
        layer.msg("上传图片成功", {icon: 1,time: 1200});
        var imgUrl = res.object[0];
        var showImgUrl = res.object[0];
        //将上传图片显示
        $("#"+imagLable).append("<li>\n" +
            "            <div style='width:160px ;height: 160px;'><img width=\"100%\" src='"+showImgUrl+"' onclick=\"_showImgUtil($(this))\"/></div>\n" +
            "        </li>");
        // $("#"+imagLable).show();
    }
};

