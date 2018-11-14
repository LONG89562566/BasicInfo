package com.info.admin.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 材料实体类
 * @author administrator  2018-11-14 23:45:42
 */
public class MaterialVo implements Serializable {
	private static final long serialVersionUID = 1L;
	 /*****主键*****/ 
	 private String materialId;
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
	 /*****材料名称*****/ 
	 private String materialname;
	 /*****规格型号*****/ 
	 private String model;
	 /*****计量单位*****/ 
	 private String unit;
	 /*****进场数量*****/ 
	 private BigDecimal entryNum;
	 /*****生产厂家*****/ 
	 private String manufacturer;
	 /*****供货单位*****/ 
	 private String supplyer;
	 /*****质量证明书*****/ 
	 private String certificateQuality;
	 /*****报验委托单*****/ 
	 private String inspection;
	 /*****使用部位*****/ 
	 private String usePart;
	 /*****存放地点*****/ 
	 private String storage;
	 /*****剩余数量*****/ 
	 private BigDecimal residualNum;
	 /*****试验报告单*****/ 
	 private String testReport;
	 /*****检验状态*****/ 
	 private Long testState;


	 public String getMaterialId() {
		 return materialId;
	 }

	 public void setMaterialId(String materialId) {
		 this.materialId = materialId;
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

	 public String getMaterialname() {
		 return materialname;
	 }

	 public void setMaterialname(String materialname) {
		 this.materialname = materialname;
	 }

	 public String getModel() {
		 return model;
	 }

	 public void setModel(String model) {
		 this.model = model;
	 }

	 public String getUnit() {
		 return unit;
	 }

	 public void setUnit(String unit) {
		 this.unit = unit;
	 }

	 public BigDecimal getEntryNum() {
		 return entryNum;
	 }

	 public void setEntryNum(BigDecimal entryNum) {
		 this.entryNum = entryNum;
	 }

	 public String getManufacturer() {
		 return manufacturer;
	 }

	 public void setManufacturer(String manufacturer) {
		 this.manufacturer = manufacturer;
	 }

	 public String getSupplyer() {
		 return supplyer;
	 }

	 public void setSupplyer(String supplyer) {
		 this.supplyer = supplyer;
	 }

	 public String getCertificateQuality() {
		 return certificateQuality;
	 }

	 public void setCertificateQuality(String certificateQuality) {
		 this.certificateQuality = certificateQuality;
	 }

	 public String getInspection() {
		 return inspection;
	 }

	 public void setInspection(String inspection) {
		 this.inspection = inspection;
	 }

	 public String getUsePart() {
		 return usePart;
	 }

	 public void setUsePart(String usePart) {
		 this.usePart = usePart;
	 }

	 public String getStorage() {
		 return storage;
	 }

	 public void setStorage(String storage) {
		 this.storage = storage;
	 }

	 public BigDecimal getResidualNum() {
		 return residualNum;
	 }

	 public void setResidualNum(BigDecimal residualNum) {
		 this.residualNum = residualNum;
	 }

	 public String getTestReport() {
		 return testReport;
	 }

	 public void setTestReport(String testReport) {
		 this.testReport = testReport;
	 }

	 public Long getTestState() {
		 return testState;
	 }

	 public void setTestState(Long testState) {
		 this.testState = testState;
	 }

	public MaterialVo() {
		super();
	}
}
