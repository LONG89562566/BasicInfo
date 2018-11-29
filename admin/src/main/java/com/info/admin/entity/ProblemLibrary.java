package com.info.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 问题库 实体类
 *
 * @author ysh
 * @date 2018-11-19 18:06:32
 */
public class ProblemLibrary implements Serializable {
    private static final long serialVersionUID = 1L;
    /*****主键*****/
    private String supplierId;
    /*****创建时间*****/
    private Date createTime;
    /*****创建时间 日常的字符串*****/
    private String createTimeStr;
    /*****创建人编号*****/
    private Long createUser;
    /*****删除标记*****/
    private Long deleteFlag;
    /*****修改时间*****/
    private Date updateTime;
    /*****修改时间 日常的字符串*****/
    private String updateTimeStr;
    /*****排序号*****/
    private Long seq;
    /*****标题*****/
    private String title;
    /*****问题类型*****/
    private String type;
    /*****检查内容*****/
    private String inspectContent;
    /*****检查人编号*****/
    private String inspectUser;
    /*****整改人编号*****/
    private String rectifyUser;
    /*****检查人编号*****/
    private String inspectUserCn;
    /*****整改人编号*****/
    private String rectifyUserCn;
    /*****整改时间*****/
    private Date rectifyTime;
    /*****整改时间 日常的字符串*****/
    private String rectifyTimeStr;
    /*****键名*****/
    private String columnName;
    /*****注释*****/
    private String columnComment;


    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public Date getCreateTime() {
        if (org.apache.commons.lang.StringUtils.isNotBlank(createTimeStr) && createTime == null) {
            createTime = com.info.admin.utils.DateUtil.stringToDate(createTimeStr);
        }
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
        if (org.apache.commons.lang.StringUtils.isNotBlank(createTimeStr) && createTime == null) {
            this.createTime = com.info.admin.utils.DateUtil.stringToDate(createTimeStr);
        }
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Long getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Long deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Date getUpdateTime() {
        if (org.apache.commons.lang.StringUtils.isNotBlank(updateTimeStr) && updateTime == null) {
            updateTime = com.info.admin.utils.DateUtil.stringToDate(updateTimeStr);
        }
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateTimeStr() {
        return updateTimeStr;
    }

    public void setUpdateTimeStr(String updateTimeStr) {
        this.updateTimeStr = updateTimeStr;
        if (org.apache.commons.lang.StringUtils.isNotBlank(updateTimeStr) && updateTime == null) {
            this.updateTime = com.info.admin.utils.DateUtil.stringToDate(updateTimeStr);
        }
    }

    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInspectContent() {
        return inspectContent;
    }

    public void setInspectContent(String inspectContent) {
        this.inspectContent = inspectContent;
    }

    public String getInspectUser() {
        return inspectUser;
    }

    public void setInspectUser(String inspectUser) {
        this.inspectUser = inspectUser;
    }

    public String getRectifyUser() {
        return rectifyUser;
    }

    public void setRectifyUser(String rectifyUser) {
        this.rectifyUser = rectifyUser;
    }

    public Date getRectifyTime() {
        if (org.apache.commons.lang.StringUtils.isNotBlank(rectifyTimeStr) && rectifyTime == null) {
            rectifyTime = com.info.admin.utils.DateUtil.stringToDate(rectifyTimeStr);
        }
        return rectifyTime;
    }

    public void setRectifyTime(Date rectifyTime) {
        this.rectifyTime = rectifyTime;
    }

    public String getRectifyTimeStr() {
        return rectifyTimeStr;
    }

    public void setRectifyTimeStr(String rectifyTimeStr) {
        this.rectifyTimeStr = rectifyTimeStr;
        if (org.apache.commons.lang.StringUtils.isNotBlank(rectifyTimeStr) && rectifyTime == null) {
            this.rectifyTime = com.info.admin.utils.DateUtil.stringToDate(rectifyTimeStr);
        }
    }

    public String getInspectUserCn() {
        return inspectUserCn;
    }

    public void setInspectUserCn(String inspectUserCn) {
        this.inspectUserCn = inspectUserCn;
    }

    public String getRectifyUserCn() {
        return rectifyUserCn;
    }

    public void setRectifyUserCn(String rectifyUserCn) {
        this.rectifyUserCn = rectifyUserCn;
    }

    public ProblemLibrary() {
        super();
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }
}
