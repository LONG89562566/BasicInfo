package com.info.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 信息发布日志 实体类
 * @author ysh  
 * @date 2018-11-18 19:39:48
 */
public class ReleaseInfoLog implements Serializable {
	private static final long serialVersionUID = 1L;
	 /*****主键*****/
	 private Long releaseInfoLogId;
	 /*****注册时间*****/
	 private Date createTime;
	 /*****注册时间 日常的字符串*****/
	 private String createTimeStr;
	 /*****信息发布id*****/
	 private String releaseInfoId;
	 /*****接收人id*****/
	 private String accepter;
	 /*****回报率*****/
	 private String isRead;
	 /*****阅读时间*****/
	 private String readTime;


	 public Long getReleaseInfoLogId() {
		 return releaseInfoLogId;
	 }

	 public void setReleaseInfoLogId(Long releaseInfoLogId) {
		 this.releaseInfoLogId = releaseInfoLogId;
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

	 public String getReleaseInfoId() {
		 return releaseInfoId;
	 }

	 public void setReleaseInfoId(String releaseInfoId) {
		 this.releaseInfoId = releaseInfoId;
	 }

	 public String getAccepter() {
		 return accepter;
	 }

	 public void setAccepter(String accepter) {
		 this.accepter = accepter;
	 }

	 public String getIsRead() {
		 return isRead;
	 }

	 public void setIsRead(String isRead) {
		 this.isRead = isRead;
	 }

	 public String getReadTime() {
		 return readTime;
	 }

	 public void setReadTime(String readTime) {
		 this.readTime = readTime;
	 }

	 
	public ReleaseInfoLog() {
		super();
	}
}
