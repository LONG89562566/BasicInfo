package com.info.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 组织机构信息 实体类
 * @author ysh  
 * @date 2018-11-14 23:45:41
 */
public class OrgInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	 /*****主键*****/
	 private String orgId;
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
	 /*****层级*****/
	 private Long level;
	 /*****是否末级*****/
	 private Long isEnd;
	 /*****父编号*****/
	 private String parentId;
	 /*****机构名称*****/
	 private String orgName;
	 /*****机构别名*****/
	 private String otName;
	 /*****机构编码*****/
	 private String orgCode;
	 /*****项目编号*****/
	 private String projectId;


	 public String getOrgId() {
		 return orgId;
	 }

	 public void setOrgId(String orgId) {
		 this.orgId = orgId;
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

	 public Long getLevel() {
		 return level;
	 }

	 public void setLevel(Long level) {
		 this.level = level;
	 }

	 public Long getIsEnd() {
		 return isEnd;
	 }

	 public void setIsEnd(Long isEnd) {
		 this.isEnd = isEnd;
	 }

	 public String getParentId() {
		 return parentId;
	 }

	 public void setParentId(String parentId) {
		 this.parentId = parentId;
	 }

	 public String getOrgName() {
		 return orgName;
	 }

	 public void setOrgName(String orgName) {
		 this.orgName = orgName;
	 }

	 public String getOtName() {
		 return otName;
	 }

	 public void setOtName(String otName) {
		 this.otName = otName;
	 }

	 public String getOrgCode() {
		 return orgCode;
	 }

	 public void setOrgCode(String orgCode) {
		 this.orgCode = orgCode;
	 }

	 public String getProjectId() {
		 return projectId;
	 }

	 public void setProjectId(String projectId) {
		 this.projectId = projectId;
	 }

	 
	public OrgInfo() {
		super();
	}
}
