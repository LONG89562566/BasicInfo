package com.info.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 信息发布 实体类
 * @author ysh  
 * @date 2018-11-14 23:45:41
 */
public class ReleaseInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	 /*****主键*****/
	 private String releaseId;
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


	 public String getReleaseId() {
		 return releaseId;
	 }

	 public void setReleaseId(String releaseId) {
		 this.releaseId = releaseId;
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

	 
	public ReleaseInfo() {
		super();
	}
}
