package com.info.admin.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 预警设置实体类
 * @author administrator  2018-11-14 23:45:42
 */
public class WarningInfoVo implements Serializable {
	private static final long serialVersionUID = 1L;
	 /*****主键*****/ 
	 private String warningId;
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
	/*****发布人*****/
	private String releaseUserName;
	/*****接收人编号*****/
	private String receiveUser;
	/*****接收人*****/
	private String receiveUserCn;
	/*****对象属性*****/
	private Long options;
	/*****值*****/
	private String true_val;
	/*****（1.大/2.小/3.等/4.不大/5.不小/6.不等于）*****/
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

	public String getReleaseUserName() {
		return releaseUserName;
	}

	public void setReleaseUserName(String releaseUserName) {
		this.releaseUserName = releaseUserName;
	}

	public String getReceiveUserCn() {
		return receiveUserCn;
	}

	public void setReceiveUserCn(String receiveUserCn) {
		this.receiveUserCn = receiveUserCn;
	}

	public WarningInfoVo() {
		super();
	}
}
