package com.info.admin.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 组织机构信息实体类
 * @author administrator  2018-11-13 16:23:58
 */
public class OrgInfoVo implements Serializable {
	private static final long serialVersionUID = 1L;
	 /*****主键*****/ 
	 private String orgId;
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

	public OrgInfoVo() {
		super();
	}
}
