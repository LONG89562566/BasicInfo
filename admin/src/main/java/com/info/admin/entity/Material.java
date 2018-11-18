package com.info.admin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 材料 实体类
 * @author ysh  
 * @date 2018-11-14 23:45:41
 */
public class Material implements Serializable {
	private static final long serialVersionUID = 1L;
	 /*****主键*****/
	 private String materialId;
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
	 /*****材料名称*****/
	 private String materialName;
	 /*****规格型号*****/
	 private String model;
	 /*****计量单位*****/
	 private String unit;
	 /*****进场数量*****/
	 private BigDecimal entryNum;
	 /*****生产厂家*****/
	 private String manufactrer;
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

	 
	public Material() {
		super();
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getManufactrer() {
		return manufactrer;
	}

	public void setManufactrer(String manufactrer) {
		this.manufactrer = manufactrer;
	}
}
