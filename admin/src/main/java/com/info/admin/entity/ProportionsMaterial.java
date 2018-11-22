package com.info.admin.entity;

import java.io.Serializable;
import java.util.Date;

public class ProportionsMaterial implements Serializable {
    private static final long serialVersionUID = 1L;

    /*****主键*****/
    private String proportionsMaterialId;
    /*****创建时间*****/
    private Date createTime;
    /*****创建时间 日常的字符串*****/
    private String createTimeStr;
    /*****删除标记*****/
    private Long deleteFlag;
    /*****修改时间*****/
    private Date updateTime;
    /*****修改时间 日常的字符串*****/
    private String updateTimeStr;
    /*****配合比详情编号*****/
    private String detailId;
    /*****材料编号*****/
    private String materialId;
    /*****材料名称*****/
    private String materialName;
    /*****材料编号*****/
    private Long materialNum;

    public String getProportionsMaterialId() {
        return proportionsMaterialId;
    }

    public void setProportionsMaterialId(String proportionsMaterialId) {
        this.proportionsMaterialId = proportionsMaterialId;
    }

    public Date getCreateTime() {
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
    }

    public Long getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Long deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Date getUpdateTime() {
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
    }

    public String getDetailId() {
        return detailId;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId;
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    public Long getMaterialNum() {
        return materialNum;
    }

    public void setMaterialNum(Long materialNum) {
        this.materialNum = materialNum;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }
}
