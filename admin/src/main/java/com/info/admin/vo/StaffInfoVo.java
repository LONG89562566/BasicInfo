package com.info.admin.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 员工信息实体类
 * @author administrator  2018-11-13 09:49:00
 */
public class StaffInfoVo implements Serializable {
	private static final long serialVersionUID = 1L;
	 /*****主键*****/ 
	 private String staffId;
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
	 /*****机构编号*****/ 
	 private String orgId;
	 /*****姓名*****/ 
	 private String name;
	 /*****性别*****/ 
	 private String sex;
	 /*****籍贯*****/ 
	 private String native;
	 /*****民族*****/ 
	 private String nation;
	 /*****身份证号*****/ 
	 private String idCard;
	 /*****家庭住址*****/ 
	 private String address;
	 /*****联系电话*****/ 
	 private String phone;
	 /*****职位*****/ 
	 private String position;


	 public String getStaffId() {
		 return staffId;
	 }

	 public void setStaffId(String staffId) {
		 this.staffId = staffId;
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

	 public String getOrgId() {
		 return orgId;
	 }

	 public void setOrgId(String orgId) {
		 this.orgId = orgId;
	 }

	 public String getName() {
		 return name;
	 }

	 public void setName(String name) {
		 this.name = name;
	 }

	 public String getSex() {
		 return sex;
	 }

	 public void setSex(String sex) {
		 this.sex = sex;
	 }

	 public String getNative() {
		 return native;
	 }

	 public void setNative(String native) {
		 this.native = native;
	 }

	 public String getNation() {
		 return nation;
	 }

	 public void setNation(String nation) {
		 this.nation = nation;
	 }

	 public String getIdCard() {
		 return idCard;
	 }

	 public void setIdCard(String idCard) {
		 this.idCard = idCard;
	 }

	 public String getAddress() {
		 return address;
	 }

	 public void setAddress(String address) {
		 this.address = address;
	 }

	 public String getPhone() {
		 return phone;
	 }

	 public void setPhone(String phone) {
		 this.phone = phone;
	 }

	 public String getPosition() {
		 return position;
	 }

	 public void setPosition(String position) {
		 this.position = position;
	 }

	public StaffInfoVo() {
		super();
	}
}
