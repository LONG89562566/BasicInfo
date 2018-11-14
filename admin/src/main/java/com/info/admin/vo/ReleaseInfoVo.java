package com.info.admin.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 信息发布实体类
 * @author administrator  2018-11-14 23:45:42
 */
public class ReleaseInfoVo implements Serializable {
	private static final long serialVersionUID = 1L;
	 /*****主键*****/ 
	 private String releaseId;
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

	public ReleaseInfoVo() {
		super();
	}
}
