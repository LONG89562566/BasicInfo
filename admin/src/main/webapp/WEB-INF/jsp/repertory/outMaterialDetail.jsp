<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
    	<meta charset="utf-8">
		<title>入库</title>
		<%@include file="/WEB-INF/jsp/decorators/addHeader.jsp" %>
	</head>
	<body>
	<script type="text/javascript" src="/jquery-easyui-1.5.2/jquery.easyui.min.js" charset="utf-8"></script>
	<script type="text/javascript" src="/jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
	<div class="row">
		<div style="float: left;width: 18%;height: 500px;background-color: white;margin-right: 1%">
			<table id="repertoryTree" title="所有梁场" style="width:100%;height:500px">
				<thead>
				<tr>
					<th data-options="field:'text'" width="220px">梁场名称</th>
				</tr>
				</thead>
			</table>
		</div>
		<div class="box" style="float: left;width: 80%;height: auto; background-color: white;">
 		<form id="saleForm" class="layui-form" style="margin-top:30px;">
 			<input  type="hidden" id="materialDetailId" name="materialDetailId" value="${materialDetail.materialDetailId}"/>
 			<input  type="hidden" id="projectId" name="projectId" value="${projectId}"/>
			<div class='layui-form-item'>
				<div class='layui-form-item'>
					<div class="layui-inline">
						<label class="layui-form-label">出库名称</label>
						<div class="layui-input-inline">
							<input type="text" id="outName" name="outName" placeholder="请输入出库名称"  value="" class="layui-input"/>
							<span style="color: red" id="s-name"></span>
						</div>
					</div>
				</div>
				<table id="example1" class="table table-bordered table-striped" style="width: 50%">
					<thead>
					<tr >
						<th width="30%" style="text-align: center">材料名称</th>
						<th width="20%" style="text-align: center">库存数量</th>
						<th width="30%" style="text-align: center">出库数量</th>
						<th width="20%" style="text-align: center">操作</th>
					</tr>
					</thead>
					<tbody id="example1-tbody" style="text-align: center">
					</tbody>
				</table>
			</div>
			<div class="layui-input-block" style="margin-top:30px;margin-left:150px;">
				<input type="button" class="layui-btn" onclick="saveData()" value="确定"/>
				<button class="layui-btn" name="cancleSubmit" >取消</button>
			</div>
  		</form>
		</div>
	</div>
	</body>

	<script type="text/javascript">
        //添加物品
        var addMaterial  = function(id,name,num){
            //console.log("id: "+id+" ;name :"+name);
            var input = $("input[id$='repertoryId']");
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
            var html =
                "<td><input type='hidden' name='repertoryId' id='repertoryId' value='"+id+"'>"
				+"&nbsp;&nbsp;<span id='"+id+"-materialName' >"+name+"</span></td>"
				+"<td>&nbsp;&nbsp;<span id='"+id+"+material'>"+num+"</span></td>"
                +"<td> <input class='layui-input' type='number'  value='' min='0' max='"+num+"' name='num' class='form-control' onchange='checkMaterialNum(this)' id='"+id+"-num' placeholder='请输入出库数量')' /></td>"
                +"<td><div class='site-demo-button' >\n" +
                "<button value='"+id+"' class='layui-btn layui-btn-normal' onclick='removeMaterial(this)'>&nbsp;&nbsp;移除</span></button></div></td>";
            $("#example1-tbody").append("<tr id='outbound-tr-"+id+"'>"+html+"</tr>");
        };
        //移除添加的物品
        var removeMaterial = function (data) {
            var id = $(data).val();
            $("#outbound-tr-"+id).remove();
        };

        //验证数量的数量
        var checkMaterialNum = function (obj) {
            var val = $(obj).val() - 0 ;
            var max = $(obj).attr("max") - 0;
            //console.log("val : "+val+ " ; max :"+max +" ; val > max : "+(val > max));
            if(val > max){
                layer.msg("库存不足！")
                $(obj).val(null)
            }
        }

        //加载菜单
        $('#repertoryTree').treegrid({
            url:'<%=request.getContextPath()%>/admin/repertory/repertoryTree?projectId=${projectId}',
            method:'get',          //请求方式
            idField:'id',           //定义标识树节点的键名字段
            treeField:'text',       //定义树节点的字段
            fit:true,               //网格自动撑满
            fitColumns:true,
            onLoadSuccess:function(node, data){
                $(this).treegrid('collapseAll');
            },
            onClickRow:function(row){
                //点击时初始化数据
                addMaterial(row.id,row.text,row.num);
            }
        });

		//提交表单数据
		layui.use(['form', 'jquery', 'layedit', 'laydate'], function(){
			  var $ = layui.jquery;
			  var form = layui.form();
			  var layer = layui.layer;
			  var layedit = layui.layedit;
			  var laydate = layui.laydate;
			  form.verify({
			  });		  

		});

        function saveData() {
            var outName = $("#outName").val();
            if(outName == null || outName == ""){
                layer.msg('请输入出库名称！');
			}

            var inputMaterialNum = $("input[id$='num']");
            if(inputMaterialNum.length == 0){
                layer.msg('请输入出库数量！');
                return;
            }
            var isOpenDiv = true;
            var materialNum = new Array();
            $(inputMaterialNum).each(function (i,n) {
                if($(n).val() < 0 || $(n).val() == ""){
                    $(n).focus();
                    var id = $(n).attr("id").split("-");
                    layer.msg('请输入'+$("#"+id[0]+"-name").text()+'数量！');
                    isOpenDiv = false;
                    return;
                }

                materialNum.push($(n).val());
            });
            if(!isOpenDiv){
                return;
            }
            var getVals = function (lableId) {
                var input = $("input[id$='"+lableId+"']");
                var vals = new Array();
                $(input).each(function (i,n) {
                    vals.push($(n).val());
                });
                return vals;
            };
            var getValss = function (lableId) {
                var input = $("span[id$='"+lableId+"']");
                var vals = new Array();
                $(input).each(function (i,n) {
                    vals.push($(n).text());
                });
                return vals;
            };
            layer.open({
                type: 1,
                content: $("#example1"),
                area: ['650px   ', '80%'],
                btn: ['确定', '取消'],
                btnAlign: 'c', //按钮居中
                shade: 0.5 ,//不显示遮罩
                yes: function(){
                    var materialName  = getValss("materialName");
                    var repertoryId  = getVals("repertoryId");
                    //获取传递的参数
                    var requestData={
                        num : materialNum,
                        materialName :materialName,
                        repertoryId :repertoryId,
                    };

                    $.ajax({
                        type: "POST",
                        url: '/admin/materialDetail/insertMaterialDetail?projectId=${projectId}'+'&outName='+outName,
                        data: requestData,
                        dataType: "json",
                        cache:false,
                        success: function(data){
                            var code = data.code;
                            var msg = data.message;
                            if(code == "200"){
                                layer.msg(msg, {icon: 1,time: 2000});//2秒关闭
                                //刷新页面
                                parent.location.reload();
                            }
                        },
                        error:function(){
                            layer.msg("操作失败！", {icon: 1,time: 2000});//1.5秒关闭
                        }
                    });

                    layer.closeAll();
                },
                btn2: function(){
                    layer.closeAll();
                }
            });


        };
        $('.site-demo-button .layui-btn').on('click', function(){
            var othis = $(this), method = othis.data('method');
            active[method] ? active[method].call(this, othis) : '';
        });



	</script>
</html>				 
