package com.info.admin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 操作人员 实体类
 * @author ysh  
 * @date 2018-11-14 23:45:41
 */
public class RepairInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	 /*****主键*****/
	 private String repairId;
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
	 /*****维修人员编号*****/
	 private String repairUser;
	 /*****维修时间*****/
	 private Date repairTime;
	 /*****维修时间 日常的字符串*****/
	 private String repairTimeStr;
	 /*****维修费用*****/
	 private BigDecimal amount;
	 /*****备注*****/
	 private String remark;
	 /*****维修人名称*****/
	 private String repairUserCn;
	 /*****设备编号*****/
	 private String equipmentId;


	 public String getRepairId() {
		 return repairId;
	 }

	 public void setRepairId(String repairId) {
		 this.repairId = repairId;
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

	 public String getRepairUser() {
		 return repairUser;
	 }

	 public void setRepairUser(String repairUser) {
		 this.repairUser = repairUser;
	 }

	 public Date getRepairTime() {
	 	 if(org.apache.commons.lang.StringUtils.isNotBlank(repairTimeStr) && repairTime == null){
			 repairTime = com.info.admin.utils.DateUtil.stringToDate(repairTimeStr);
		 }
		 return repairTime;
	 }

	 public void setRepairTime(Date repairTime) {
		 this.repairTime = repairTime;
	 }
	 
	 public String getRepairTimeStr() {
		 return repairTimeStr;
	 }

	 public void setRepairTimeStr(String repairTimeStr) {
		 this.repairTimeStr = repairTimeStr;
		 if(org.apache.commons.lang.StringUtils.isNotBlank(repairTimeStr) && repairTime == null){
			this.repairTime = com.info.admin.utils.DateUtil.stringToDate(repairTimeStr);
		 }
	 }

	 public BigDecimal getAmount() {
		 return amount;
	 }

	 public void setAmount(BigDecimal amount) {
		 this.amount = amount;
	 }

	 public String getRemark() {
		 return remark;
	 }

	 public void setRemark(String remark) {
		 this.remark = remark;
	 }

	public String getRepairUserCn() {
		return repairUserCn;
	}

	public void setRepairUserCn(String repairUserCn) {
		this.repairUserCn = repairUserCn;
	}

	public String getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	public RepairInfo() {
		super();
	}
}
