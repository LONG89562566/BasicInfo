package com.info.admin.entity;

import java.io.Serializable;
import java.util.Date;

public class OrgInfoTree implements Serializable {

    /*****主键*****/
    private String orgId;
    /*****创建时间*****/
    private Date createTime;
    /*****删除标记*****/
    private Long deleteFlag;
    /*****层级*****/
    private Long level;
    /*****父编号*****/
    private String parentId;
    /*****机构名称*****/
    private String orgName;
    /*****机构别名*****/
    private String otName;
    /*****机构编码*****/
    private String orgCode;
    /*****项目编号*****/
    private String projectId;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public Long getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Long deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOtName() {
        return otName;
    }

    public void setOtName(String otName) {
        this.otName = otName;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }
}
