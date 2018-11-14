package com.info.admin.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 三维交底实体类
 * @author administrator  2018-11-14 23:45:42
 */
public class D3PayVo implements Serializable {
	private static final long serialVersionUID = 1L;
	 /*****主键*****/ 
	 private String payId;
	 /*****创建时间*****/ 
	 private Date createTime;
	 /*****创建人编号*****/ 
	 private Long createUser;
	 /*****删除标记*****/ 
	 private Long deleteFlag;
	 /*****修改时间*****/ 
	 private Date updateTime;
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
		 return createTime;
	 }

	 public void setCreateTime(Date createTime) {
		 this.createTime = createTime;
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
		 return updateTime;
	 }

	 public void setUpdateTime(Date updateTime) {
		 this.updateTime = updateTime;
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

	public D3PayVo() {
		super();
	}
}
