package com.info.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 三维交底 实体类
 * @author ysh  
 * @date 2018-11-13 16:23:56
 */
public class D3Pay implements Serializable {
	private static final long serialVersionUID = 1L;
	 /*****主键*****/
	 private String payId;
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
	 /*****项目编号*****/
	 private String projectId;
	 /*****工序*****/
	 private String procedure;
	 /*****关键工艺控制要点*****/
	 private String processControl;
	 /*****安全控制要点*****/
	 private String safetyControl;
	 /*****质量控制要点*****/
	 private String qualityControl;


	 public String getPayId() {
		 return payId;
	 }

	 public void setPayId(String payId) {
		 this.payId = payId;
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

	 public Long getSeq() {
		 return seq;
	 }

	 public void setSeq(Long seq) {
		 this.seq = seq;
	 }

	 public String getProjectId() {
		 return projectId;
	 }

	 public void setProjectId(String projectId) {
		 this.projectId = projectId;
	 }

	 public String getProcedure() {
		 return procedure;
	 }

	 public void setProcedure(String procedure) {
		 this.procedure = procedure;
	 }

	 public String getProcessControl() {
		 return processControl;
	 }

	 public void setProcessControl(String processControl) {
		 this.processControl = processControl;
	 }

	 public String getSafetyControl() {
		 return safetyControl;
	 }

	 public void setSafetyControl(String safetyControl) {
		 this.safetyControl = safetyControl;
	 }

	 public String getQualityControl() {
		 return qualityControl;
	 }

	 public void setQualityControl(String qualityControl) {
		 this.qualityControl = qualityControl;
	 }

	 
	public D3Pay() {
		super();
	}
}
