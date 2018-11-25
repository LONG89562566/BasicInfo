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
		<link rel="stylesheet" href="/layui/css/layui.css"  media="all">
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
	</head>

	<body class="hold-transition skin-blue sidebar-mini">
	<script src="/plugins/jQuery/jquery-2.2.3.min.js"></script>
	<script src="/bootstrap/js/bootstrap.min.js"></script>
	<script src="/bootstrap/js/fileinput.js"></script>
	<script src="/js/jquery-ui.min.js"></script>
	<script src="/js/jquery.form.js"></script>
	<script src="/js/fromVal.js"></script>
	<script src="/js/date-format.js"></script>
	<script src="/layui/layui.js"></script>
	<script src="/dist/js/app.min.js"></script>
	<script type="text/javascript" src="/jquery-easyui-1.5.2/jquery.easyui.min.js" charset="utf-8"></script>
	<script type="text/javascript" src="/My97DatePicker/WdatePicker.js" charset="utf-8" ></script>
	<script type="text/javascript" src="/jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>

	  <!-- 员工信息列表start -->
	  <div class="content-wrapper">
	    <!-- Content Header (Page header) --> 
	    <section class="content-header">
	      <h1>组织和人员信息</h1>
	    </section>
	    <!-- Main content -->
	    <shiro:hasPermission name="staffInfo:query">
		    <section class="content">

					<div class="row">
						<div style="float: left;width: 18%;height: 500px;background-color: white;margin-right: 1%">
							<div class="col-sm-12">
								<div class="pull-left btn-group-sm">
									<button onclick="add()" class="btn btn-success"><i class="fa fa-fw fa-plus-square"></i>新增</button>
									<button class="btn btn-danger" onclick="deletes($('#orgIds').val())"><i class="fa fa-fw fa-times-circle"></i>删除</button>
								</div>
							</div>
							<table id="orgInfoTree" title="所有组织" style="width:100%;height:500px">
								<thead>
									<tr>
										<th data-options="field:'orgName'" width="220px">梁场名称</th>
									</tr>
								</thead>
							</table>
						</div>

						<div class="box" style="float: left;width: 80%;height: auto; background-color: white;">
							<div class="row">
								<div class="col-xs-12">
									<div class="box">
										<div class="box box-info"  id="orgShow" style="display: none">
										<div class="box-header">
											<h3 class="box-title">组织信息 :${sessionScope.login_session_admin.userName}</h3>
										</div>
			              	<div class="box-body">
							  	<div class='layui-form-item'>
			               		  	<div class="layui-inline">
									  	<label for="orgName" class="layui-form-label">机构名称：</label>
								 	  	<div class="layui-input-inline">
										  	<input type="text"  name="orgName" class="layui-input" id="orgName" placeholder="请输入机构名称" >
										  	<input type="hidden"  name="parentId" class="layui-input" id="parentId" value="">
										  	<input type="hidden"  name="level" class="layui-input" id="level" value="" >
										  	<input type="hidden"  name="orgIds" class="layui-input" id="orgIds" value="" >
										  	<input type="hidden"  name="projectId" class="layui-input" id="projectId" value="" >
								 	  	</div>
								  	</div>
								  	<div class="layui-inline">
									  	<label for="otName" class="layui-form-label">机构别名：</label>
									  	<div class="layui-input-inline">
										  	<input type="text"  name="otName" class="layui-input" id="otName" placeholder="请输入机构别名">
									  	</div>
								  	</div>
								  	<div class="layui-inline">
									  	<label for="orgCode" class="layui-form-label">机构编码：</label>
									  	<div class="layui-input-inline">
										  	<input type="text"  name="orgCode" class="form-control" id="orgCode" placeholder="请输入机构编码">
									  	</div>
								  	</div>
							  	</div>
							  	<div class='layui-form-item'>
								  	<div class="layui-inline">
									  	<label for="seq" class="layui-form-label">排序号：</label>
									  	<div class="layui-input-inline">
										  	<input type="text"  name="seq" class="form-control" id="seq" placeholder="请输入排序号">
									  	</div>
								  	</div>
								  	<div class="layui-inline">
									  	<label for="isEnd" class="layui-form-label">是否末级:</label>
									  	<div class="layui-input-inline">
										  	<select name="isEnd" id="isEnd"   class="form-control select2" style="width: 100%;">
											  	<option value="1">是</option>
											  	<option value="2">否</option>
										  	</select>
									  	</div>
								  	</div>
							  	</div>
							</div>
			            </div>
						<div  style="margin-top:10px;margin-left:150px;">
							<button class="layui-btn" name="commit" onclick="saveOrUp()">提交</button>
						</div>
						<!-- form start -->
						<form  id="form_submit"  method="post"  class="form-horizontal" enctype="multipart/form-data">
							<input type="hidden" name="pageNum" id="pageNum" value="${paginator.currentPage}">
							<input type="hidden" name="pageSize" id="pageSize" value="${paginator.pageRecord}">
							<input type="hidden" name="orgId" id="orgId" value="">
						</form>
			           <!-- form end -->
			        </div>
					<!-- 表格列表start -->
		            <div class="box" style="min-height: 400px;height: 400px;overflow: scroll;">
						<section class="content-header">
							<h1>人员信息：${sessionScope.login_session_admin.userName}</h1>
						</section>
			            <div class="box-body">
			             <div class="site-demo-button" >
						   <button data-method="setAddOrEdit" id="addUser" class="layui-btn layui-btn-small"><i class="layui-icon"></i><span>&nbsp;&nbsp;新增</span></button>
						 </div>
			             <table id="example1" class="table table-bordered table-striped">
			               <thead>
				              <tr>
				                <th field="sys_xh">序号</th>
			                    <th field="seq"  >排序号</th>
			                    <th field="name"  >姓名</th>
			                    <th field="sex"  method = "getSex">性别</th>
			                    <th field="natives"  >籍贯</th>
			                    <th field="nation"  >民族</th>
			                    <th field="idCard"  >身份证号</th>
			                    <th field="address"  >家庭住址</th>
			                    <th field="phone"  >联系电话</th>
			                    <th field="position"  >职位</th>
							  	<th field="createTime"  type='date'>创建时间</th>

				                <th field="sys_opt">操作</th>
				              </tr>
			               </thead>
			               <tbody id="show-data">
		                  </tbody>
			             </table>
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
        var reqUpdateAndAddUrl = "/admin/staffInfo/insertAndUpdate";
		//查询数据Url
		var pageQueryUrl = "<%=request.getContextPath()%>/admin/staffInfo/pageQuery";
		//查询条件表单Id
	    var _queryConditionForrId = "form_submit";
		//显示数据表格id
	    var showFieldId = "example1";
	    //数据展示id
	    var showFieldData = "show-data";
	    //主键
	    var primarykey = "staffId";
	    //分页显示标签id
	    var showPageNumber = "show-page";
	    //列表操作按钮
	    var tableBtn = new Array();
	    tableBtn = addBtn(tableBtn,"setAddOrEdit","修改","","","","","","layui-btn-normal");
		tableBtn = addBtn(tableBtn,"escBoundUser","解绑","","","isBound","true","1","layui-btn-danger");
		tableBtn = addBtn(tableBtn,"boundUser","绑定","","","isBound","true","0","layui-btn-danger");
        tableBtn = addBtn(tableBtn,"delData","删除","","","","","","layui-btn-normal");
	</script>


	<script type="text/javascript" charset="utf-8">
        layui.use(['layer','jquery','form','element'], function(){ })
        //加载菜单
        $('#orgInfoTree').treegrid({
            url:'<%=request.getContextPath()%>/admin/orgInfo/orgInfoTree',
            method:'get',          //请求方式
            idField:'orgId',           //定义标识树节点的键名字段
            treeField:'orgName',       //定义树节点的字段
            fit:true,               //网格自动撑满
            fitColumns:true,
            onLoadSuccess:function(node, data){
                $(this).treegrid('collapseAll');
            },
            onClickRow:function(row){
                $('#pageNum').val(1);
                $("#orgId").val(row.orgId);
                $("#orgIds").val(row.orgId);
                $("#projectId").val(row.projectId);
                $("#orgName").val(row.orgName);
                $("#orgCode").val(row.orgCode);
                $("#otName").val(row.otName);
                $("#parentId").val(row.parentId);
                $("#level").val(row.level);
                $("#seq").val(row.seq);
                $("#isEnd").val(row.isEnd);
                $('#orgShow').show();
                //点击时初始化数据
                initPaginator(row.orgId);
            }
        });
        //初始化列表
        var initPaginator = function (orgId) {
            var selectRow = $('#orgInfoTree').datagrid('getSelected');
            if (selectRow) {
                orgId = selectRow.orgId;
            } else {
                layer.msg('请先选择一个组织机构！');
                return;
            }
            loadSelectPageDat($('#pageNum').val(),$('#pageSize').val());
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

        //新增组织结构数据
        function add() {

            $('#orgShow').show();
            $('#orgShow').form('clear');
            var row = $('#orgInfoTree').datagrid('getSelected');
            if (row){
                if(row.isEnd == 1){
                    $.messager.alert('错误','末级菜单下不能再添加菜单!','error');
                }else{
                    $('#projectId').val(row.projectId);
                    $('#parentId').val(row.orgId);
                    $('#level').val(Number(row.level)+1);
                }
            } else {
                $.messager.alert('错误','必须选中一个梁场进行添加!','error');
                return;
            }
        }

        //保存、修改数据
        function saveOrUp(){
            var orgIds = $('#orgIds').val();
            var levels =  $('#level').val();
            var parentIds  = $('#parentId').val();
            var projectIds = $('#projectId').val();
            var orgNames = $('#orgName').val();
            var otNames = $('#otName').val();
            var seqs = $('#seq').val();
            var isEnds= $('#isEnd').val();
            var orgCode= $('#orgCode').val();
            if(levels==0||levels=="0"){
                orgNames="";
            }
            $.ajax({
                type: 'post',
                url: '<%=request.getContextPath()%>/admin/orgInfo/insertAndUpdate',
                dataType: 'json',
                data:{
                    orgId:orgIds,
                    projectId:projectIds,
                    orgName:orgNames,
                    otName:otNames,
                    parentId:parentIds,
                    level:levels,
                    seq:seqs,
                    isEnd:isEnds,
                    orgCode:orgCode,

                },
                success: function (data) {
                    if(data == null){
                        $.messager.alert('错误','系统错误，请联系管理员!','error');
                        return ;
                    }
                    $('#orgInfoTree').treegrid('reload')
                }
            });
        }

	</script>
	<script type="text/javascript" charset="utf-8" >
        layui.use(['layer','jquery','form','element'], function(){ });

		//新增人员数据弹窗
		layui.use('layer', function(){ //独立版的layer无需执行这一句
			var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句
			//触发事件
			var active = {
				setAddOrEdit: function(data){
					//获取userId
					var id = data.val();
					setAddOrEdit(id);
				},
                deletes: function(id){

                    deletes(id);
				},
				//启用和禁用数据弹窗
				offset: function(othis){
					var type = othis.data('type');
					var status=othis.text();
					if(status.indexOf("禁用")!=-1){
						//禁用的url
						requestUrl="<%=request.getContextPath()%>/admin/staffInfo/disabled";
						text = "确定要禁用此条数据吗？";
					}else{
						//启用的url
						requestUrl="<%=request.getContextPath()%>/admin/staffInfo/enabled";
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
		var setAddOrEdit = function(staffId){

            var selectRow = $('#orgInfoTree').datagrid('getSelected');
            if (selectRow) {
                var orgId = selectRow.orgId;
            } else {
                layer.msg('请先选择一个组织机构！');
                return;
            }
            if( selectRow || orgId != "" || orgId != null) {
                //多窗口模式，层叠置顶
                layer.open({
                    type: 2,
                    title: '新增/修改 员工信息',
                    area: ['70%', '86%'],
                    shade: 0.5,
                    anim: 3,//0-6的动画形式，-1不开启
                    content: '<%=request.getContextPath()%>/admin/staffInfo/addOrEdit?staffId='+staffId+"&orgId="+orgId,
                    zIndex: layer.zIndex, //重点1
                    success: function (layero, index) {
                        //layer.setAddOrEdit(layero);
                        var body = layer.getChildFrame('body', index);
                        var iframeWin = window[layero.find('iframe')[0]['name']];
                        body.find('input[name="staffId"]').val(staffId);
                        //弹窗表单的取消操作时关闭弹窗
                        var canclebtn = body.find('button[name="cancleSubmit"]').click(function cancleSubmit() {
                            layer.closeAll();
                        });

                        //弹窗表单的取消操作时关闭弹窗
                        var savebtn = body.find('button[name="saveSubmit"]').click(function saveSubmit() {
                            var requestData = iframeWin.getData();
                            $.ajax({
                                type:"POST",
                                url: reqUpdateAndAddUrl,
                                data: requestData,
                                dataType:"json",
                                success:function(result){
                                    var code = result.code;
                                    var msg = result.message;
                                    if(code=="200" || code=="201"){
                                        layer.msg(msg,{icon : 1,time:1200});

                                        //刷新页面
                                        refreshTheCurrentPage();
                                        layer.close(index);
                                    }
                                },
                                error:function(){
                                    layer.msg("更新数据异常", {icon: 1,time: 1200},function(){
                                        // var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
                                        // parent.layer.close(index);//关闭父页面的弹窗
                                    });
                                }
                            });

                        });
                    }
                });
            }else {
                layer.msg('请先选择一个组织机构！');
                return;
			}
		};

		//新增、编辑打开
		var boundUser = function(staffId){

            //多窗口模式，层叠置顶
            layer.open({
                type: 2,
                title: '员工绑定用户',
                area: ['40%', '60%'],
                btn: ['确定', '取消'],
                shade: 0.5,
                anim: 3,//0-6的动画形式，-1不开启
                content: '<%=request.getContextPath()%>/admin/staffInfo/boundUser?staffId='+staffId,
                zIndex: layer.zIndex, //重点1
                success: function (layero, index) {
                    // layer.setAddOrEdit(layero);
                    var body = layer.getChildFrame('body', index);
                    var iframeWin = window[layero.find('iframe')[0]['name']];
                    body.find('input[name="staffId"]').val(staffId);
                    //弹窗表单的取消操作时关闭弹窗
                    var canclebtn = body.find('button[name="cancleSubmit"]').click(function cancleSubmit() {
                        layer.closeAll();
                    });
                },
                yes: function(index, layero){
                    var body = layer.getChildFrame('body', index);
                    var iframeWin = window[layero.find('iframe')[0]['name']];
                    var data = iframeWin.getData();
                    if(data != false){
                        $.ajax({
                            type: "POST",
                            url: "/admin/staffInfo/saveBoundUser",
                            data: data,
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
                        //按钮【按钮一】的回调
                        layer.close(index); //如果设定了yes回调，需进行手工关闭
                    }

                },cancel: function(){
                        //右上角关闭回调
                    // alert(4);
                }
            });
		};

		//禁用
		var escBoundUser = function (id) {
			//禁用的url
			requestUrl="<%=request.getContextPath()%>/admin/staffInfo/escBoundUser";
			text = "确定要对该用户解除绑定吗？";
			userOffSet(1,requestUrl, id,text);
		};
		//启用
		var openset = function (id) {
			//启用的url
			requestUrl="<%=request.getContextPath()%>/admin/staffInfo/enabled";
			text = "确定要启用此条数据吗？";
			userOffSet(0,requestUrl, id,text);
		};
        //删除
        var deletes = function (id) {
            var level = $("#level").val();
            if(!level){
                return;
            }
            if(level==0){
                layer.msg('梁场不允许删除！');
                return;
            }
            //启用的url
            requestUrl="<%=request.getContextPath()%>/admin/orgInfo/delete";
            text = "确定要启用此条数据吗？";
            userOffSet(0,requestUrl, id,text);
        };
		//删除
		var delData = function (id) {
			//启用的url
			requestUrl="<%=request.getContextPath()%>/admin/staffInfo/delete";
			text = "确定要删除此条数据吗？";
			userOffSet(0,requestUrl, id,text);
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
						data: {"staffId":id},
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
	<script type="text/javascript">
		var getSex = function (val) {
		    if(val == 1){
		        return "男";
			}else{
		        return "女";
			}
        };
	</script>
</body>
</html>
					
