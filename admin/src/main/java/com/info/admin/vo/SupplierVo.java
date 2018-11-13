package com.info.admin.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 供应商实体类
 * @author administrator  2018-11-13 16:23:58
 */
public class SupplierVo implements Serializable {
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
	 /*****供方全称*****/ 
	 private String supperName;
	 /*****法人代表*****/ 
	 private String representative;
	 /*****地址*****/ 
	 private String address;
	 /*****企业性质（全民/集体/三资/个体）*****/ 
	 private Long nature;
	 /*****营业执照号*****/ 
	 private String license;
	 /*****税务登记编号*****/ 
	 private String registration;
	 /*****联系人*****/ 
	 private String contacts;
	 /*****联系电话*****/ 
	 private String phone;


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

	 public String getSupperName() {
		 return supperName;
	 }

	 public void setSupperName(String supperName) {
		 this.supperName = supperName;
	 }

	 public String getRepresentative() {
		 return representative;
	 }

	 public void setRepresentative(String representative) {
		 this.representative = representative;
	 }

	 public String getAddress() {
		 return address;
	 }

	 public void setAddress(String address) {
		 this.address = address;
	 }

	 public Long getNature() {
		 return nature;
	 }

	 public void setNature(Long nature) {
		 this.nature = nature;
	 }

	 public String getLicense() {
		 return license;
	 }

	 public void setLicense(String license) {
		 this.license = license;
	 }

	 public String getRegistration() {
		 return registration;
	 }

	 public void setRegistration(String registration) {
		 this.registration = registration;
	 }

	 public String getContacts() {
		 return contacts;
	 }

	 public void setContacts(String contacts) {
		 this.contacts = contacts;
	 }

	 public String getPhone() {
		 return phone;
	 }

	 public void setPhone(String phone) {
		 this.phone = phone;
	 }

	public SupplierVo() {
		super();
	}
}
