package com.info.admin.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 信息发布日志实体类
 * @author administrator  2018-11-18 19:39:48
 */
public class ReleaseInfoLogVo implements Serializable {
	private static final long serialVersionUID = 1L;
	 /*****主键*****/ 
	 private Long releaseInfoLogId;
	 /*****注册时间*****/ 
	 private Date createTime;
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
		 return createTime;
	 }

	 public void setCreateTime(Date createTime) {
		 this.createTime = createTime;
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

	public ReleaseInfoLogVo() {
		super();
	}
}
