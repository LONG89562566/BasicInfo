<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <%@include file="/WEB-INF/jsp/decorators/meta.jsp" %>
  <style type="text/css">
    button{
      margin-right:5px;
    }
    .layui-form-label{
      width:100px;
    }
    <%@include file="/WEB-INF/jsp/decorators/listHeader.jsp" %>
      #myDesktop{width:100%;height:500px;}
    #select_menu>tr th{text-align: center;height: 30px;}
    #myDesktop>thead>tr td{text-align: center;height: 30px;}
  </style>
</head>
<body>
  <!-- 角色菜单start -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>设置角色菜单</h1>
    </section>
    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
			<div style="padding-top: 5px;width: 100%;">
				<div style="float: left;width: 24%;height: 600px;background-color: white;">
                    <table id="menuTree" title="请选择菜单" style="width:400px;height:500px">
                        <thead>
                            <tr>
                                <th data-options="field:'menuName'" width="220">菜单</th>
                                <th data-options="field:'selected'" width="100" align="center" formatter="formatcheckbox">选择</th>
                            </tr>
                        </thead>
                     </table>
			    </div>
			    <div style="float: right;width: 75%;height: 600px; background-color: white;">
                     <table id="myDesktop" title="已选菜单" class="table table-bordered table-striped" align="center" >
                        <thead>
                            <tr >
                                <th  width="30%" >菜单名称</th>
                                <th  width="15%"  style='display: none;'>宽度</th>
                                <th  width="15%"  >高度</th>
                                <th  width="15%"  >排序</th>
                                <th  width="25%"  >操作</th>
                            </tr>
                        </thead>
                         <tbody id="select_menu">
                             <c:forEach items="${customDesktopLs}" var="menu" varStatus="status">
                                 <tr style="" id="tr-${menu.menuId}">
                                     <td><input type='hidden' name='menuId' id='menuId-${menu.menuId}' value='${menu.menuId}'>
                                         <input type='hidden' name='name' id='name-${menu.menuId}' value='${menu.menuName}"'>&nbsp;&nbsp;<span>${menu.menuName}</span></td>
                                     <td style='display: none;'> <input type='text'  value='${menu.width}'  name='width' class='form-control'  id='width-${menu.menuId}' placeholder='请输入宽度' /></td>
                                     <td> <input type='text'  value='${menu.height}'  name='height' class='form-control'  id='height-${menu.menuId}' placeholder='请输入高度' /></td>
                                     <td><input type='number' name='seq' class='form-control' id='seq-${menu.menuId}' placeholder='请输入排序号'  value='${menu.seq}' onkeyup="value=value.replace(/[^\\d]/g,'')"/></td>
                                     <td><div class='site-demo-button' >
                                     <button value='${menu.menuId}' class='layui-btn layui-btn-normal' onclick='removeMaterial(this)'>&nbsp;&nbsp;移除</span></button></div></td>
                                 </tr>
                             </c:forEach>

                         </tbody>
                     </table>
			    </div>    
			</div>
          </div>
        </div>
      </div>
    </section>
  </div>
  <!-- 所有菜单按钮 -->
  <div id="c_tb" style="height:auto">
  	<a href="javascript:void(0)" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" onclick="saveOrUpdate()">保存</a>
  </div>

<script src="/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="/bootstrap/js/bootstrap.min.js"></script>
<script src="/js/jquery-ui.min.js"></script>
<script src="/layui/layui.js"></script>
<script src="/dist/js/app.min.js"></script>
<script type="text/javascript" src="/jquery-easyui-1.5.2/jquery.easyui.min.js" charset="utf-8"></script>
<script type="text/javascript" src="/jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
<script type="text/javascript" charset="utf-8">
$(document).ready(function () {
	//加载菜单树
	$('#menuTree').treegrid({
		url:'<%=request.getContextPath()%>/admin/customDesktop/menuTree',
	    method:'get',          //请求方式
	    idField:'menuId',           //定义标识树节点的键名字段
	    treeField:'menuName',       //定义树节点的字段
	    toolbar:"#c_tb",
	    fit:true,               //网格自动撑满
	    onLoadSuccess:function(node, data){
	    	onLoad();  //加载已选择的数据
	    },
        onClickRow:function(row){
            //添加物品
            addMaterial(row.menuId,row.menuName,'50%','320px',1);
        }
	});
});

//勾选checkbox
function show(checkid) {
    var s = '#check_' + checkid;
    /*选子节点*/
    var nodes = $("#menuTree").treegrid("getChildren", checkid);
    for (i = 0; i < nodes.length; i++) {
    	//当父节点被选中，则其孩子都被选中
        $(('#check_' + nodes[i].menuId))[0].checked = $(s)[0].checked;
    }
}

//添加物品
var addMaterial  = function(id,name,width,height,seq){
    //console.log("id: "+id+" ;name :"+name);
    var s = '#check_' + id;
    if(!$(s)[0].checked){
        $("#tr-"+id).remove();
       return;
    }
    var input = $("input[id$='menuId']");
    var isAdd = true;
    $(input).each(function (i,n) {
        if(id == $(n).val()){
            isAdd = false;
            return;
        }
    });

    if(!isAdd){
        return;
    }
    var html = "<td><input type='hidden' name='menuId' id='menuId-"+id+"' value='"+id+"'>"
        +"<input type='hidden' name='name' id='name-"+id+"' value='"+name+"'>&nbsp;&nbsp;<span>"+name+"</span></td>"
        +"<td style='display: none;'> <input type='text'  value='"+width+"'  name='width' class='form-control'  id='width-"+id+"' placeholder='请输入宽度' /></td>"
        +"<td > <input type='text'  value='"+height+"'  name='height' class='form-control'  id='height-"+id+"' placeholder='请输入高度量'/></td>"
        +"<td><input type='number' name='seq' class='form-control' id='seq-"+id+"' placeholder='请输入排序号'  value='"+seq+"' onkeyup=\"value=value.replace(/[^\\d]/g,'')\"/></td>"
        +"<td><div class=\"site-demo-button\" >\n" +
        "<button value='"+id+"' class='layui-btn layui-btn-normal' onclick='removeMaterial(this)'>&nbsp;&nbsp;移除</span></button></div></td>";
    $("#select_menu").append("<tr id='tr-"+id+"'>"+html+"</tr>");
}

//移除添加的物品
var removeMaterial = function (data) {
    var id = $(data).val();
    $("#tr-"+id).remove();
    $(('#check_'+id)).attr("checked",false);
}


function formatcheckbox(val, row) {
    return "<input value='" + row.menuId + "' type='checkbox' onclick=show('" + row.menuId + "') id='check_" + row.menuId + "' />";
}
//获取选中的结点
function getSelected() {
    var idList = "";
    $("input:checked").each(function() {
        var id = $(this).attr("id");
        if (id.indexOf("check_") > -1) {
            idList += id.replace("check_", '') + ',';
        }
    });
    if(idList!=""){
    	idList = idList.substring(0,idList.length-1);
    }
    return idList;
}
//保存、修改数据
function saveOrUpdate(){
	var menuIds = getVals("menuId");
	if(menuIds == null || menuIds.length == 0){
        $.messager.alert('提示','桌面至少保持一个!','error');
	    return;
    }
	var menuNames = getVals("name");
	var widths = getVals("width");
	var heights = getVals("height");
	var seqs = getVals("seq");
	var data = { menuIds : menuIds,  menuNames : menuNames, widths : widths, heights : heights, seqs : seqs};
	$.ajax({
	  type: 'post',
	  url: '/admin/customDesktop/saveDesktopMenu',
      data: data,
      dataType: 'json',
	  success: function (data) {
		  if(data.code==200){
			  $.messager.alert('提示','更新成功!');
			  window.location.reload();
		  }else{
			  $.messager.alert('错误','更新失败!','error');
		  }
	  }
   });
}

var getVals = function (lableId) {
    var input = $("input[id^='"+lableId+"']");
    var vals = new Array();
    $(input).each(function (i,n) {
        vals.push($(n).val());
    });
    return vals;
}

function onLoad(){
	<c:forEach items="${customDesktopLs}" var="menu" varStatus="status">
	   $(('#check_${menu.menuId}')).attr("checked",true);
	</c:forEach>
}
</script>
</body>
</html>