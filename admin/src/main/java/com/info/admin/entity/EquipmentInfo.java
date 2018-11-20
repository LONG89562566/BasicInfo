package com.info.admin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 设备信息 实体类
 * @author ysh  
 * @date 2018-11-20 17:37:49
 */
public class EquipmentInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	 /*****主键*****/
	 private String supplierId;
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
	 /*****出厂日期 日常的字符串*****/
	 private String producTimeStr;
	 /*****进场日期*****/
	 private Date advanceTime;
	 /*****进场日期 日常的字符串*****/
	 private String advanceTimeStr;
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
	 	 if(org.apache.commons.lang.StringUtils.isNotBlank(producTimeStr) && producTime == null){
			 producTime = com.info.admin.utils.DateUtil.stringToDate(producTimeStr);
		 }
		 return producTime;
	 }

	 public void setProducTime(Date producTime) {
		 this.producTime = producTime;
	 }
	 
	 public String getProducTimeStr() {
		 return producTimeStr;
	 }

	 public void setProducTimeStr(String producTimeStr) {
		 this.producTimeStr = producTimeStr;
		 if(org.apache.commons.lang.StringUtils.isNotBlank(producTimeStr) && producTime == null){
			this.producTime = com.info.admin.utils.DateUtil.stringToDate(producTimeStr);
		 }
	 }

	 public Date getAdvanceTime() {
	 	 if(org.apache.commons.lang.StringUtils.isNotBlank(advanceTimeStr) && advanceTime == null){
			 advanceTime = com.info.admin.utils.DateUtil.stringToDate(advanceTimeStr);
		 }
		 return advanceTime;
	 }

	 public void setAdvanceTime(Date advanceTime) {
		 this.advanceTime = advanceTime;
	 }
	 
	 public String getAdvanceTimeStr() {
		 return advanceTimeStr;
	 }

	 public void setAdvanceTimeStr(String advanceTimeStr) {
		 this.advanceTimeStr = advanceTimeStr;
		 if(org.apache.commons.lang.StringUtils.isNotBlank(advanceTimeStr) && advanceTime == null){
			this.advanceTime = com.info.admin.utils.DateUtil.stringToDate(advanceTimeStr);
		 }
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

	 
	public EquipmentInfo() {
		super();
	}
}
