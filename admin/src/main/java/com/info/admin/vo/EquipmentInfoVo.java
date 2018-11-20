package com.info.admin.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 设备信息实体类
 * @author administrator  2018-11-20 17:37:49
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
	 /*****管理编号*****/ 
	 private Long manageNum;
	 /*****名称*****/ 
	 private String name;
	 /*****型号*****/ 
	 private String model;
	 /*****功率*****/ 
	 private String power;
	 /*****主要技术参数*****/ 
	 private String mtp;
	 /*****出场编号*****/ 
	 private String startNum;
	 /*****原值(元)*****/ 
	 private BigDecimal ov;
	 /*****净值(元)*****/ 
	 private BigDecimal nv;
	 /*****生产厂*****/ 
	 private String producPlant;
	 /*****出厂日期*****/ 
	 private Date producTime;
	 /*****进场日期*****/ 
	 private Date advanceTime;
	 /*****设备来源*****/ 
	 private String source;
	 /*****安全操作规程*****/ 
	 private String sop;


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

	 public Long getManageNum() {
		 return manageNum;
	 }

	 public void setManageNum(Long manageNum) {
		 this.manageNum = manageNum;
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

	 public String getPower() {
		 return power;
	 }

	 public void setPower(String power) {
		 this.power = power;
	 }

	 public String getMtp() {
		 return mtp;
	 }

	 public void setMtp(String mtp) {
		 this.mtp = mtp;
	 }

	 public String getStartNum() {
		 return startNum;
	 }

	 public void setStartNum(String startNum) {
		 this.startNum = startNum;
	 }

	 public BigDecimal getOv() {
		 return ov;
	 }

	 public void setOv(BigDecimal ov) {
		 this.ov = ov;
	 }

	 public BigDecimal getNv() {
		 return nv;
	 }

	 public void setNv(BigDecimal nv) {
		 this.nv = nv;
	 }

	 public String getProducPlant() {
		 return producPlant;
	 }

	 public void setProducPlant(String producPlant) {
		 this.producPlant = producPlant;
	 }

	 public Date getProducTime() {
		 return producTime;
	 }

	 public void setProducTime(Date producTime) {
		 this.producTime = producTime;
	 }

	 public Date getAdvanceTime() {
		 return advanceTime;
	 }

	 public void setAdvanceTime(Date advanceTime) {
		 this.advanceTime = advanceTime;
	 }

	 public String getSource() {
		 return source;
	 }

	 public void setSource(String source) {
		 this.source = source;
	 }

	 public String getSop() {
		 return sop;
	 }

	 public void setSop(String sop) {
		 this.sop = sop;
	 }

	public EquipmentInfoVo() {
		super();
	}
}
