<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>新增工程概况</title>
    <%@include file="/WEB-INF/jsp/decorators/addHeader.jsp" %>
</head>
<body>
    <div class="layui-form-item" >
        <div class='layui-form-item'>
            <div class="layui-inline">
                <label class="layui-form-label">梁场名称</label>
                <div class="layui-input-inline">
                    <span >${projectSurvey.lcName }</span>
                </div>
            </div>
            <div class='layui-form-item'>
                <label class="layui-form-label">梁场地址</label>
                <div class="layui-input-block">
                    <span >  ${projectSurvey.overallGoal}</span>
                </div>
            </div>
            <div class='layui-form-item'>
                <label class="layui-form-label">线路里程</label>
                <div class="layui-input-block">
                    <span>${projectSurvey.lineMileage}</span>
                </div>
            </div>
            <div class='layui-form-item'>
                <label class="layui-form-label">梁场规模</label>
                <div class="layui-input-block">
                    <span > ${projectSurvey.lcScale}</span>
                </div>
            </div>
            <div class='layui-form-item'>
                <label class="layui-form-label">承担任务</label>
                <div class="layui-input-block">
                    <span >${projectSurvey.bearTask}</span>
                </div>
            </div>
            <div class='layui-form-item'>
                <label class="layui-form-label">供应里程</label>
                <div class="layui-input-block">
                    <span >${projectSurvey.supplyMileage}</span>
                </div>
            </div>
            <div class='layui-form-item'>
                <div class="layui-inline">
                    <label class="layui-form-label">生产能力</label>
                    <div class="layui-input-inline">
                        <span style="color: red" id="s-throughput">${projectSurvey.throughput }</span>
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">建设单位</label>
                    <div class="layui-input-inline">
                        <span > ${projectSurvey.constructionUnit }</span>
                    </div>
                </div>
            </div>
            <div class='layui-form-item'>
                <div class="layui-inline">
                    <label class="layui-form-label">承建单位</label>
                    <div class="layui-input-inline">
                        <span > ${projectSurvey.bearUnit }</span>
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">监理单位</label>
                    <div class="layui-input-inline">
                        <span > ${projectSurvey.controlUnit }</span>
                    </div>
                </div>
            </div>
            <div class='layui-form-item'>
                <div class="layui-inline">
                    <label class="layui-form-label">设计单位</label>
                    <div class="layui-input-inline">
                        <span > ${projectSurvey.designUnit }</span>
                    </div>
                </div>

        </div>
        </div>
</body>
</html>
