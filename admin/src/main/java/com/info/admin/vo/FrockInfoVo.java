package com.info.admin.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 设备信息实体类
 * @author administrator  2018-11-14 23:45:42
 */
public class FrockInfoVo implements Serializable {
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
	 /*****类别*****/ 
	 private String type;
	 /*****管理编号*****/ 
	 private String mId;
	 /*****名称*****/ 
	 private String name;
	 /*****型号规格*****/ 
	 private String model;
	 /*****生产厂家*****/ 
	 private String manufacturer;
	 /*****完好状态*****/ 
	 private String state;
	 /*****使用场所*****/ 
	 private String usePlace;
	 /*****责任人*****/ 
	 private String liabler;
	 /*****购置日期*****/ 
	 private Date purchaseTime;


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

	 public String getType() {
		 return type;
	 }

	 public void setType(String type) {
		 this.type = type;
	 }

	 public String getMId() {
		 return mId;
	 }

	 public void setMId(String mId) {
		 this.mId = mId;
	 }

	 public String getName() {
		 return name;
	 }

	 public void setName(String name) {
		 this.name = name;
	 }

	 public String getModel() {
		 return model;
	 }

	 public void setModel(String model) {
		 this.model = model;
	 }

	 public String getManufacturer() {
		 return manufacturer;
	 }

	 public void setManufacturer(String manufacturer) {
		 this.manufacturer = manufacturer;
	 }

	 public String getState() {
		 return state;
	 }

	 public void setState(String state) {
		 this.state = state;
	 }

	 public String getUsePlace() {
		 return usePlace;
	 }

	 public void setUsePlace(String usePlace) {
		 this.usePlace = usePlace;
	 }

	 public String getLiabler() {
		 return liabler;
	 }

	 public void setLiabler(String liabler) {
		 this.liabler = liabler;
	 }

	 public Date getPurchaseTime() {
		 return purchaseTime;
	 }

	 public void setPurchaseTime(Date purchaseTime) {
		 this.purchaseTime = purchaseTime;
	 }

	public FrockInfoVo() {
		super();
	}
}
