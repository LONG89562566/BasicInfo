package com.info.admin.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 操作人员实体类
 * @author administrator  2018-11-14 23:45:42
 */
public class RepairInfoVo implements Serializable {
	private static final long serialVersionUID = 1L;
	 /*****主键*****/ 
	 private String repairId;
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
	 /*****维修人员编号*****/ 
	 private String repairUser;
	 /*****维修时间*****/ 
	 private Date repairTime;
	 /*****维修费用*****/ 
	 private BigDecimal amount;
	 /*****备注*****/ 
	 private String remark;


	 public String getRepairId() {
		 return repairId;
	 }

	 public void setRepairId(String repairId) {
		 this.repairId = repairId;
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

	 public String getRepairUser() {
		 return repairUser;
	 }

	 public void setRepairUser(String repairUser) {
		 this.repairUser = repairUser;
	 }

	 public Date getRepairTime() {
		 return repairTime;
	 }

	 public void setRepairTime(Date repairTime) {
		 this.repairTime = repairTime;
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

	public RepairInfoVo() {
		super();
	}
}
