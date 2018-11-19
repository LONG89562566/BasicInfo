package com.info.admin.entity;

import java.io.Serializable;
import java.util.Date;

public class ProjectSurveyTree implements Serializable {
    /*****主键*****/
    private String projectId;
    /*****排序号*****/
    private Long seq;
    /*****梁场名称*****/
    private String lcName;
    /*****梁场地址*****/
    private String lcAddr;
    /*****线路里程*****/
    private String lineMileage;
    /*****梁场规模*****/
    private String lcScale;
    /*****承担任务*****/
    private String bearTask;
    /*****供应里程*****/
    private String supplyMileage;
    /*****生产能力*****/
    private String throughput;
    /*****建设单位*****/
    private String constructionUnit;
    /*****承建单位*****/
    private String bearUnit;
    /*****监理单位*****/
    private String controlUnit;
    /*****设计单位*****/
    private String designUnit;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }


    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    public String getLcName() {
        return lcName;
    }

    public void setLcName(String lcName) {
        this.lcName = lcName;
    }

    public String getLcAddr() {
        return lcAddr;
    }

    public void setLcAddr(String lcAddr) {
        this.lcAddr = lcAddr;
    }

    public String getLineMileage() {
        return lineMileage;
    }

    public void setLineMileage(String lineMileage) {
        this.lineMileage = lineMileage;
    }

    public String getLcScale() {
        return lcScale;
    }

    public void setLcScale(String lcScale) {
        this.lcScale = lcScale;
    }

    public String getBearTask() {
        return bearTask;
    }

    public void setBearTask(String bearTask) {
        this.bearTask = bearTask;
    }

    public String getSupplyMileage() {
        return supplyMileage;
    }

    public void setSupplyMileage(String supplyMileage) {
        this.supplyMileage = supplyMileage;
    }

    public String getThroughput() {
        return throughput;
    }

    public void setThroughput(String throughput) {
        this.throughput = throughput;
    }

    public String getConstructionUnit() {
        return constructionUnit;
    }

    public void setConstructionUnit(String constructionUnit) {
        this.constructionUnit = constructionUnit;
    }

    public String getBearUnit() {
        return bearUnit;
    }

    public void setBearUnit(String bearUnit) {
        this.bearUnit = bearUnit;
    }

    public String getControlUnit() {
        return controlUnit;
    }

    public void setControlUnit(String controlUnit) {
        this.controlUnit = controlUnit;
    }

    public String getDesignUnit() {
        return designUnit;
    }

    public void setDesignUnit(String designUnit) {
        this.designUnit = designUnit;
    }
}
