<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="pv" uri="/pageTaglib"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title></title>
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<!-- 引入公共部分css jsp文件 -->
		<%@include file="/WEB-INF/jsp/decorators/meta.jsp" %>
		<!-- 引入公共部分js jsp文件 -->
		<%@include file="/WEB-INF/jsp/decorators/listHeader.jsp" %>
		<style type="text/css">
			.layui-form-label{
				width:100px;
			}

			.layui-input-block{
				width:auto;
				height:auto;
				position:relative;
				left:800px;
			}
			.col-sm-2 {
				width: 10%;
			}
		</style>
		<script type="text/javascript" src="/jquery-easyui-1.5.2/jquery.easyui.min.js" charset="utf-8"></script>
		<script type="text/javascript" src="/jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
	</head>
	<body class="hold-transition skin-blue sidebar-mini">
	  <!-- 设备信息列表start -->
	  <div class="content-wrapper">
	    <!-- Content Header (Page header) --> 
	    <section class="content-header">
	      <h1>设备信息管理</h1>
	    </section>
	    <!-- Main content -->
	    <shiro:hasPermission name="equipmentInfo:query">
		    <section class="content">
		      <div class="row">
                  <div style="float: left;width: 18%;height: 500px;background-color: white;">
                      <table id="lcTree" title="所有梁场" style="width:100%;height:500px">
                          <thead>
                          <tr>
                              <th data-options="field:'lcName'" width="220px">梁场名称</th>
                          </tr>
                          </thead>
                      </table>
                  </div>
                  <div class="box" style="float: right;width: 81%;height: auto; background-color: white;">
                      <div class="row">
		        <div class="col-xs-12">
		          <div class="box">
		            <div class="box-header">
		              <h3 class="box-title">设备信息列表 :${sessionScope.login_session_admin.userName}</h3>
		            </div>
			        <div class="box box-info">
			           <!-- form start -->
			           <form  id="form_submit" class="form-horizontal" action="/admin/equipmentInfo/list" method="post">
			           	  <input type="hidden" name="pageNum" id="pageNum" value="${paginator.currentPage}">
	                      <input type="hidden" name="pageSize" id="pageSize" value="${paginator.pageRecord}">		           	 
			              <div class="box-body">
                              <div class="form-group" hidden="hidden">
                                  <label for="projectId" class="col-sm-1 control-label">梁场编号:</label>
                                  <div class="col-sm-3" style="width: 200px">
                                      <input type="text" name="projectId" id="projectId" value="" class="form-control input-small">
                                  </div>
                              </div>
                              <div class="form-group" >
                                  <label for="manageNum" class="col-sm-1 control-label">管理编号:</label>
                                  <div class="col-sm-3" style="width: 200px">
                                      <input type="text" name="manageNum" id="manageNum" value="" class="form-control input-small">
                                  </div>
                                  <label for="name" class="col-sm-1 control-label">名称:</label>
                                  <div class="col-sm-3" style="width: 200px">
                                      <input type="text" name="name" id="name" value="" class="form-control input-small">
                                  </div>
                              </div>
			                 <div class="box-footer">
			                 	<button onclick='refreshTheCurrentPage()' class="btn btn-info pull-left">查询</button>
			                 	<button type="reset" onclick='resetRefreshTheCurrentPage()' id="reset" class="btn btn-info ">重置</button>
			               	 </div>
			             </div>
			           </form>
			           <!-- form end -->
			        </div>
					<!-- 表格列表start -->
		            <div class="box">
			           <div class="box-body">
			             <div class="site-demo-button" >
						   <button data-method="setAddOrEdit" id="addUser" class="layui-btn layui-btn-small"><i class="layui-icon"></i><span>&nbsp;&nbsp;新增</span></button>
						 </div>
			             <table id="example1" class="table table-bordered table-striped">
			               <thead>
				              <tr>
				                <th field="sys_xh">序号</th>			              	
			                    <th field="manageNum"  >管理编号</th>
			                    <th field="name"  >名称</th>
			                    <th field="model"  >型号</th>
			                    <th field="power"  >功率</th>
			                    <th field="mtp"  >主要技术参数</th>
			                    <th field="startNum"  >出场编号</th>
			                    <th field="ov"  >原值(元)</th>
			                    <th field="nv"  >净值(元)</th>
			                    <th field="producPlant"  >生产厂</th>
			                    <th field="producTime"  type='date'>出厂日期</th>
			                    <th field="advanceTime"  type='date'>进场日期</th>
			                    <th field="source"  >设备来源</th>
								  <th field="seq"  >排序号</th>
				                <th field="sys_opt">操作</th>
				              </tr>
			               </thead>
			               <tbody id="show-data">
			               <c:forEach items="${paginator.object}" var="r" varStatus="st"> 
				   			 <tr>
								<td>${(st.index + 1)  + ((paginator.currentPage - 1) * paginator.pageRecord )} </td>			   			 
					            <td>${r.manageNum}</td>
					            <td>${r.name}</td>
					            <td>${r.model}</td>
					            <td>${r.power}</td>
					            <td>${r.mtp}</td>
					            <td>${r.startNum}</td>
					            <td>${r.ov}</td>
					            <td>${r.nv}</td>
					            <td>${r.producPlant}</td>
				                <td><fmt:formatDate value="${r.producTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				                <td><fmt:formatDate value="${r.advanceTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					            <td>${r.source}</td>
								 <td>${r.seq}</td>
						        <td>
						         <div class="site-demo-button" >
								   <button id="updateEquipmentInfo" data-method="setAddOrEdit" projectId="${r.projectId}" value="${r.equipmentId}" class="layui-btn layui-btn-normal layui-btn-small"><i class="layui-icon"></i><span>&nbsp;&nbsp;修改</span></button>
								   <button id="delEquipmentInfo" data-method="delIfon" value="${r.equipmentId}" class="layui-btn layui-btn-danger layui-btn-small"><i class="layui-icon"></i><span>&nbsp;&nbsp;删除</span></button>
								   <button id="repairEquipment" data-method="repairEquipment" value="${r.equipmentId}" class="layui-btn layui-btn-warm layui-btn-small"><i class="layui-icon"></i><span>&nbsp;&nbsp;维修</span></button>
								 </div>
						       </td>
				             </tr>
						   </c:forEach>
		                  </tbody>
			             </table>
			           </div>
			        </div>
		            <!-- 表格列表end -->
		            <div class="box-footer clearfix">
		              <ul id="show-page" class="pagination pagination-sm no-margin pull-left">
		              	 <pv:showPaging pageVo="${paginator}" />
		              </ul>
		            </div>
		          </div>
		        </div>
                      </div>
                  </div>
		      </div>
		    </section>
	    </shiro:hasPermission>
	  </div>
	
	<script type="text/javascript">
	    //保存数据提交地址
	    var reqUpdateAndAddUrl = "/admin/equipmentInfo/insertAndUpdate";
		//查询数据Url
		var pageQueryUrl = "<%=request.getContextPath()%>/admin/equipmentInfo/pageQuery";
		//查询条件表单Id
	    var _queryConditionForrId = "form_submit";
		//显示数据表格id
	    var showFieldId = "example1";
	    //数据展示id
	    var showFieldData = "show-data";
	    //主键
	    var primarykey = "equipmentId";
	    //分页显示标签id
	    var showPageNumber = "show-page";
	    //列表操作按钮
	    var tableBtn = new Array();
	    tableBtn = addBtn(tableBtn,"setAddOrEdit","修改","","","","","","layui-btn-normal","projectId");
        tableBtn = addBtn(tableBtn,"delData","删除","","","","","","layui-btn-danger");
        tableBtn = addBtn(tableBtn,"repairEquipment","维修","","","","","","layui-btn-warm");
		//tableBtn = addBtn(tableBtn,"enabled","禁用","","","status","true","1","layui-btn-danger");
		//tableBtn = addBtn(tableBtn,"openset","启用","","","status","true","-1","layui-btn-danger");

	</script>
    <script type="text/javascript" charset="utf-8">
      layui.use(['layer','jquery','form','element'], function(){ })
      //加载菜单
      $('#lcTree').treegrid({
          url:'<%=request.getContextPath()%>/admin/projectSurvey/projectSurveyTree',
          method:'get',          //请求方式
          idField:'projectId',           //定义标识树节点的键名字段
          treeField:'lcName',       //定义树节点的字段
          fit:true,               //网格自动撑满
          fitColumns:true,
          onLoadSuccess:function(node, data){
              $(this).treegrid('collapseAll');
          },
          onClickRow:function(row){
              $('#pageNum').val(1);
              $("#projectId").val(row.projectId);
              //点击时初始化数据
              initPaginator(row.projectId);
          }
      });
    </script>
	<script type="text/javascript">
        //初始化列表
        var initPaginator = function (projectId) {
            if (projectId) {
                loadSelectPageDat($('#pageNum').val(),$('#pageSize').val());
            } else {
                layer.msg('请先选择一个梁场！');
                return;
            }

        }
		var methodStatus = function (val , obj) {
			var retVal = "";
			if(val == 1){
				retVal = "启用";
			}else if(val == -1){
				retVal = "禁用";
			}
			return retVal;
		};

	</script>
	<script>
		//新增数据弹窗
		layui.use('layer', function(){ //独立版的layer无需执行这一句
			var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句
			//触发事件
			var active = {
				setAddOrEdit: function(data){
					//获取 equipmentId
					var id = data.val();
                    var projectId = $("#projectId").val();
                    projectId = projectId?projectId:data.attr("projectId");
					setAddOrEdit(id,projectId);
				},
                delIfon: function(data){
                    //获取equipmentId
                    var id = data.val();
                    delData(id);
                },
                repairEquipment: function(data){
                    //获取equipmentId
                    var id = data.val();
                    repairEquipment(id);
                },
				//启用和禁用数据弹窗
				offset: function(othis){
					var type = othis.data('type');
					var status=othis.text();
					if(status.indexOf("禁用")!=-1){
						//禁用的url
						requestUrl="<%=request.getContextPath()%>/admin/equipmentInfo/disabled";
						text = "确定要禁用此条数据吗？";
					}else{
						//启用的url
						requestUrl="<%=request.getContextPath()%>/admin/equipmentInfo/enabled";
						text = "确定要启用此条数据吗？";
					}
					var id = othis.val();
					userOffSet(type,requestUrl, id,text);
				}
			};
			$('.site-demo-button .layui-btn').on('click', function(){
				var othis = $(this), method = othis.data('method');
				active[method] ? active[method].call(this, othis) : '';
			});
		});

		
		//新增、编辑打开
		var setAddOrEdit = function(equipmentId,projectId){
            if(!projectId){
                layer.msg('请先选择一个梁场！');
                return;
            }
                //多窗口模式，层叠置顶
		     layer.open({
		         type: 2,
		         title: '新增/修改 设备信息',
		         area: ['100%', '100%'],
		         shade: 0.5,
		         anim: 3,//0-6的动画形式，-1不开启
		         content: '<%=request.getContextPath()%>/admin/equipmentInfo/addOrEdit?equipmentId='+equipmentId,
		         zIndex: layer.zIndex, //重点1
		         success: function(layero, index){
		        	 //layer.setAddOrEdit(layero);
		        	 var body = layer.getChildFrame('body', index);
		             var iframeWin = window[layero.find('iframe')[0]['name']];
		             body.find('input[name="equipmentId"]').val(equipmentId);
                     body.find('input[name="projectId"]').val(projectId);
                     //弹窗表单的取消操作时关闭弹窗
                     var canclebtn=body.find('button[name="cancleSubmit"]').click(function cancleSubmit(){
                         layer.closeAll();
                         //刷新页面
                         refreshTheCurrentPage();
		             });
		         }
		     });
		};

		//维修打开
		var repairEquipment = function(equipmentId){
                //多窗口模式，层叠置顶
		     layer.open({
		         type: 2,
		         title: '维修 设备',
		         area: ['100%', '100%'],
		         shade: 0.5,
		         anim: 3,//0-6的动画形式，-1不开启
		         content: '<%=request.getContextPath()%>/admin/repairInfo/list?equipmentId='+equipmentId,
		         zIndex: layer.zIndex, //重点1
		         success: function(layero, index){
		        	 //layer.setAddOrEdit(layero);
		        	 var body = layer.getChildFrame('body', index);
		             var iframeWin = window[layero.find('iframe')[0]['name']];
		             body.find('input[name="equipmentId"]').val(equipmentId);
                     //弹窗表单的取消操作时关闭弹窗
                     var canclebtn=body.find('button[name="cancleSubmit"]').click(function cancleSubmit(){
                         layer.closeAll();
                         //刷新页面
                         refreshTheCurrentPage();
		             });
		         }
		     });
		};
		
		//禁用
		var enabled = function (id) {
			//禁用的url
			requestUrl="<%=request.getContextPath()%>/admin/equipmentInfo/disabled";
			text = "确定要禁用此条数据吗？";
			userOffSet(1,requestUrl, id,text);
		};
		//启用
		var openset = function (id) {
			//启用的url
			requestUrl="<%=request.getContextPath()%>/admin/equipmentInfo/enabled";
			text = "确定要启用此条数据吗？";
			userOffSet(0,requestUrl, id,text);
		};
		//删除
		var delData = function(id){
            //删除的url
            requestUrl= "<%=request.getContextPath()%>/admin/equipmentInfo/delete";
            text = "确定要删除此条数据吗？";
            userOffSet(2,requestUrl, id,text);
		};

		var userOffSet = function (type ,requestUrl,id,text) {
			layer.open({
				type: 1,
				offset: type,
				id: 'LAY_demo'+type, //防止重复弹出
				content: '<div style="padding: 20px 100px;">'+ text +'</div>',
				btn: ['确定', '取消'],
				btnAlign: 'c', //按钮居中
				shade: 0.5 ,//不显示遮罩
				yes: function(){
					layer.closeAll();
					$.ajax({
						type: "POST",
						url: requestUrl,
						data: {"equipmentId":id},
						dataType: "json",
						cache:false,
						success: function(data){
							var code = data.code;
							var msg = data.message;
							if(code == "200"){
								layer.msg(msg, {icon: 1,time: 2000});//2秒关闭
								//刷新页面
								refreshTheCurrentPage();
							}
						},
						error:function(){
							layer.msg("操作失败", {icon: 1,time: 2000});//1.5秒关闭
						}
					});
				},
				btn2: function(){
					layer.closeAll();
				}
			});
		}
	</script>
</body>
</html>
					
