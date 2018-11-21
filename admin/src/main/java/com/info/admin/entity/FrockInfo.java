package com.info.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 设备信息 实体类
 * @author ysh  
 * @date 2018-11-14 23:45:41
 */
public class FrockInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	 /*****主键*****/
	 private String frockId;
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
	 /*****类别*****/
	 private String type;
	 /*****管理编号*****/
	 private String mId;
	 /*****管理编号*****/
	 private String mid;
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
	 /*****购置日期 日常的字符串*****/
	 private String purchaseTimeStr;


	 public String getFrockId() {
		 return frockId;
	 }

	 public void setFrockId(String frockId) {
		 this.frockId = frockId;
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

	 public String getType() {
		 return type;
	 }

	 public void setType(String type) {
		 this.type = type;
	 }

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
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
	 	 if(org.apache.commons.lang.StringUtils.isNotBlank(purchaseTimeStr) && purchaseTime == null){
			 purchaseTime = com.info.admin.utils.DateUtil.stringToDate(purchaseTimeStr);
		 }
		 return purchaseTime;
	 }

	 public void setPurchaseTime(Date purchaseTime) {
		 this.purchaseTime = purchaseTime;
	 }
	 
	 public String getPurchaseTimeStr() {
		 return purchaseTimeStr;
	 }

	 public void setPurchaseTimeStr(String purchaseTimeStr) {
		 this.purchaseTimeStr = purchaseTimeStr;
		 if(org.apache.commons.lang.StringUtils.isNotBlank(purchaseTimeStr) && purchaseTime == null){
			this.purchaseTime = com.info.admin.utils.DateUtil.stringToDate(purchaseTimeStr);
		 }
	 }

	 
	public FrockInfo() {
		super();
	}
}
