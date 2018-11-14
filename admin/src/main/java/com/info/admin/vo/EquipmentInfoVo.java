package com.info.admin.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 设备信息实体类
 * @author administrator  2018-11-14 23:45:42
 */
public class EquipmentInfoVo implements Serializable {
	private static final long serialVersionUID = 1L;
	 /*****主键*****/ 
	 private String supplierId;
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


	 public String getSupplierId() {
		 return supplierId;
	 }

	 public void setSupplierId(String supplierId) {
		 this.supplierId = supplierId;
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

	public EquipmentInfoVo() {
		super();
	}
}
