package com.info.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 混泥土信息 实体类
 * @author ysh  
 * @date 2018-11-14 23:45:41
 */
public class ConcreteInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	 /*****主键*****/
	 private String concreteId;
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
	 /*****项目编号*****/
	 private String projectId;
	 /*****混泥土别名*****/
	 private String name;
	 /*****混泥土等级*****/
	 private Long level;
	 /*****配合比编号*****/
	 private String proportionId;
	/*****配合比名称*****/
	private String proportionName;
	 /*****混泥土方量*****/
	 private Float square;
	 /*****总材料用量*****/
	 private String totalUse;


	 public String getConcreteId() {
		 return concreteId;
	 }

	 public void setConcreteId(String concreteId) {
		 this.concreteId = concreteId;
	 }

	 public Date getCreateTime() {
	 	 if(org.apache.commons.lang.StringUtils.isNotBlank(createTimeStr) && createTime == null){
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
		 if(org.apache.commons.lang.StringUtils.isNotBlank(createTimeStr) && createTime == null){
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
	 	 if(org.apache.commons.lang.StringUtils.isNotBlank(updateTimeStr) && updateTime == null){
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
		 if(org.apache.commons.lang.StringUtils.isNotBlank(updateTimeStr) && updateTime == null){
			this.updateTime = com.info.admin.utils.DateUtil.stringToDate(updateTimeStr);
		 }
	 }


	 public String getProjectId() {
		 return projectId;
	 }

	 public void setProjectId(String projectId) {
		 this.projectId = projectId;
	 }

	 public String getName() {
		 return name;
	 }

	 public void setName(String name) {
		 this.name = name;
	 }

	 public Long getLevel() {
		 return level;
	 }

	 public void setLevel(Long level) {
		 this.level = level;
	 }

	 public String getProportionId() {
		 return proportionId;
	 }

	 public void setProportionId(String proportionId) {
		 this.proportionId = proportionId;
	 }

	 public Float getSquare() {
		 return square;
	 }

	 public void setSquare(Float square) {
		 this.square = square;
	 }

	 public String getTotalUse() {
		 return totalUse;
	 }

	 public void setTotalUse(String totalUse) {
		 this.totalUse = totalUse;
	 }

	 
	public ConcreteInfo() {
		super();
	}

	public String getProportionName() {
		return proportionName;
	}

	public void setProportionName(String proportionName) {
		this.proportionName = proportionName;
	}
}
