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
			table th{
				background:#ffffff;
			}
			table tr:nth-child(odd){
				background:#F0F0F0;
			}
			.col-sm-2 {
				width: 10%;
			}
		</style>
	</head>
	<body class="hold-transition skin-blue sidebar-mini">
	  <!-- 工程概况列表start -->
	  <div class="content-wrapper">
	    <!-- Content Header (Page header) --> 
	    <section class="content-header">
	      <h1>工程概况管理</h1>
	    </section>
	    <!-- Main content -->
	    <shiro:hasPermission name="projectSurvey:query">
		    <section class="content">
		      <div class="row">
		        <div class="col-xs-12">
		          <div class="box">
		            <div class="box-header">
		              <h3 class="box-title">工程概况列表 :${sessionScope.login_session_admin.userName}</h3>
		            </div>
			        <div class="box box-info">
			           <!-- form start -->
			           <form  id="form_submit" class="form-horizontal" action="/admin/projectSurvey/list" method="post">
			           	  <input type="hidden" name="pageNum" id="pageNum" value="${paginator.currentPage}">
	                      <input type="hidden" name="pageSize" id="pageSize" value="${paginator.pageRecord}">
			              <div class="box-body">
							  <div class="form-group">
								  <label for="lcName" class="col-sm-1 control-label">梁场名称:</label>
								  <div class="col-sm-3" style="width: 200px">
									  <input type="text" name="lcName" id="lcName" value="" class="form-control input-small" placeholder="请输入梁场名称！">
								  </div>
							  </div>
			                 <div class="box-footer">
			                 	<button onclick='refreshTheCurrentPage()' class="btn btn-info pull-left">查询</button>
			                 	<button type="reset" onclick='refreshTheCurrentPage()' id="reset" class="btn btn-info ">重置</button>
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


			                    <th field="lcName"  >梁场名称</th>
							    <th field="seq"  >排序号</th>
			                    <th field="lcAddr"  >梁场地址</th>
			                    <th field="lineMileage"  >线路里程</th>
			                    <th field="lcScale"  >梁场规模</th>
			                    <th field="bearTask"  >承担任务</th>
			                    <th field="supplyMileage"  >供应里程</th>
			                    <th field="throughput"  >生产能力</th>
			                    <th field="constructionUnit"  >建设单位</th>
			                    <th field="bearUnit"  >承建单位</th>
			                    <th field="controlUnit"  >监理单位</th>
			                    <th field="designUnit"  >设计单位</th>
								  <%--<th field="createUser"  >创建人编号</th>--%>
								  <th field="createTime"  type='date'>创建时间</th>
								  <th field="updateTime"  type='date'>修改时间</th>
				                <th field="sys_opt">操作</th>
				              </tr>
			               </thead>
			               <tbody id="show-data">
			               <c:forEach items="${paginator.object}" var="r" varStatus="st"> 
				   			 <tr>
								<td>${(st.index + 1)  + ((paginator.currentPage - 1) * paginator.pageRecord )} </td>
					            <td>${r.lcName}</td>
								 <td>${r.seq}</td>
					            <td>${r.lcAddr}</td>
					            <td>${r.lineMileage}</td>
					            <td>${r.lcScale}</td>
					            <td>${r.bearTask}</td>
					            <td>${r.supplyMileage}</td>
					            <td>${r.throughput}</td>
					            <td>${r.constructionUnit}</td>
					            <td>${r.bearUnit}</td>
					            <td>${r.controlUnit}</td>
					            <td>${r.designUnit}</td>
								 <%--<td>${r.createUser}</td>--%>
								 <td><fmt:formatDate value="${r.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								 <td><fmt:formatDate value="${r.updateTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						        <td>
						         <div class="site-demo-button" >
								   <button id="updateProjectSurvey" data-method="setAddOrEdit" value="${r.projectId}" class="layui-btn layui-btn-normal layui-btn-small"><i class="layui-icon"></i><span>&nbsp;&nbsp;修改</span></button>
								   <button id="ProjectSurveyDetail" data-method="ProjectSurveyDetail" value="${r.projectId}" class="layui-btn layui-btn-normal layui-btn-small"><i class="layui-icon"></i><span>&nbsp;&nbsp;梁场详情</span></button>
								   <button id="deleteProjectSurvey" data-method="deletes" value="${r.projectId}"     class="layui-btn layui-btn-danger layui-btn-small"><i class="layui-icon"></i><span>&nbsp;&nbsp;删除</span></button>
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
		    </section>
	    </shiro:hasPermission>
	  </div>
	
	<script type="text/javascript">

		//查询数据Url
		var pageQueryUrl = "<%=request.getContextPath()%>/admin/projectSurvey/pageQuery";
		//查询条件表单Id
	    var _queryConditionForrId = "form_submit";
		//显示数据表格id
	    var showFieldId = "example1";
	    //数据展示id
	    var showFieldData = "show-data";
	    //主键
	    var primarykey = "projectId";
	    //分页显示标签id
	    var showPageNumber = "show-page";
	    //列表操作按钮
	    var tableBtn = new Array();
	    tableBtn = addBtn(tableBtn,"setAddOrEdit","修改","","","","","","layui-btn-normal");
	    tableBtn = addBtn(tableBtn,"setAddOrEdit","梁场详情","","","","","","layui-btn-normal");
	    tableBtn = addBtn(tableBtn,"deletes","删除","","","","","","layui-btn-danger");
		//tableBtn = addBtn(tableBtn,"enabled","禁用","","","status","true","1","layui-btn-danger");
		//tableBtn = addBtn(tableBtn,"openset","启用","","","status","true","-1","layui-btn-danger");
	</script>


	<script type="text/javascript">

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
					//获取userId
					var id = data.val();
					setAddOrEdit(id);
				},
                deletes: function(data){
                //获取userId
                var id = data.val();
                deletes(id);
            },
                ProjectSurveyDetail: function(data){
                //获取userId
                var id = data.val();
                    ProjectSurveyDetail(id);
            },
			};
			$('.site-demo-button .layui-btn').on('click', function(){
				var othis = $(this), method = othis.data('method');
				active[method] ? active[method].call(this, othis) : '';
			});
		});

		
		//新增、编辑打开
		var setAddOrEdit = function(projectId){
		     //多窗口模式，层叠置顶
		     layer.open({
		         type: 2, 
		         title: '新增/修改 梁场',
		         area: ['70%', '86%'],
		         shade: 0.5,
		         anim: 3,//0-6的动画形式，-1不开启
		         content: '<%=request.getContextPath()%>/admin/projectSurvey/addOrEdit?projectId='+projectId,
		         zIndex: layer.zIndex, //重点1
		         success: function(layero, index){
		        	 //layer.setAddOrEdit(layero);
		        	 var body = layer.getChildFrame('body', index);
		             var iframeWin = window[layero.find('iframe')[0]['name']]; 
		             body.find('input[name="projectId"]').val(projectId);
		             //弹窗表单的取消操作时关闭弹窗
		             var canclebtn=body.find('button[name="cancleSubmit"]').click(function cancleSubmit(){
		            	 layer.closeAll();
		             });
		         }
		     });
		};		//新增、编辑打开
		var ProjectSurveyDetail = function(projectId){
		     //多窗口模式，层叠置顶
		     layer.open({
		         type: 2,
		         title: '梁场详情',
		         area: ['70%', '86%'],
		         shade: 0.5,
		         anim: 3,//0-6的动画形式，-1不开启
		         content: '<%=request.getContextPath()%>/admin/projectSurvey/ProjectSurveyDetail?projectId='+projectId,
		         zIndex: layer.zIndex, //重点1
		         success: function(layero, index){
		        	 //layer.setAddOrEdit(layero);
		        	 var body = layer.getChildFrame('body', index);
		             var iframeWin = window[layero.find('iframe')[0]['name']];
		             body.find('input[name="projectId"]').val(projectId);
		             //弹窗表单的取消操作时关闭弹窗
		             var canclebtn=body.find('button[name="cancleSubmit"]').click(function cancleSubmit(){
		            	 layer.closeAll();
		             });
		         }
		     });
		};
		

        //删除
        var deletes = function (id) {
            //启用的url
            requestUrl="<%=request.getContextPath()%>/admin/projectSurvey/delete";
            text = "删除此数据有极大可能导致数据紊乱，确定删除？";
            deletesUserOffSet(0,requestUrl, id,text);
        };

        var deletesUserOffSet = function (type ,requestUrl,id,text) {
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
                        data: {"projectId":id},
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
					
