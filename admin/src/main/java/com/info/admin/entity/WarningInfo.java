package com.info.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 预警设置 实体类
 * @author ysh  
 * @date 2018-11-14 23:45:41
 */
public class WarningInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	 /*****主键*****/
	 private String warningId;
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
	 /*****标题*****/
	 private String title;
	 /*****内容*****/
	 private String content;
	 /*****发布人编号*****/
	 private String releaseUser;
	 /*****接收人编号*****/
	 private String receiveUser;
	 /*****对象属性*****/
	 private Long options;
	 /*****值*****/
	 private String true_val;
	 /*****（大/小/等/不大/不小/不等于）*****/
	 private Long checkCondition;
	 /*****预警值*****/
	 private String warn_val;


	 public String getWarningId() {
		 return warningId;
	 }

	 public void setWarningId(String warningId) {
		 this.warningId = warningId;
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

	 public String getTitle() {
		 return title;
	 }

	 public void setTitle(String title) {
		 this.title = title;
	 }

	 public String getContent() {
		 return content;
	 }

	 public void setContent(String content) {
		 this.content = content;
	 }

	 public String getReleaseUser() {
		 return releaseUser;
	 }

	 public void setReleaseUser(String releaseUser) {
		 this.releaseUser = releaseUser;
	 }

	 public String getReceiveUser() {
		 return receiveUser;
	 }

	 public void setReceiveUser(String receiveUser) {
		 this.receiveUser = receiveUser;
	 }

	 public Long getOptions() {
		 return options;
	 }

	 public void setOptions(Long options) {
		 this.options = options;
	 }

	 public String getTrue_val() {
		 return true_val;
	 }

	 public void setTrue_val(String true_val) {
		 this.true_val = true_val;
	 }

	public Long getCheckCondition() {
		return checkCondition;
	}

	public void setCheckCondition(Long checkCondition) {
		this.checkCondition = checkCondition;
	}

	public String getWarn_val() {
		 return warn_val;
	 }

	 public void setWarn_val(String warn_val) {
		 this.warn_val = warn_val;
	 }

	 
	public WarningInfo() {
		super();
	}
}
