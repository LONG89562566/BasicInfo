package com.info.admin.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 梁段信息实体类
 * @author administrator  2018-11-14 23:45:42
 */
public class BeamSectionVo implements Serializable {
	private static final long serialVersionUID = 1L;
	 /*****主键*****/ 
	 private String sectionId;
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
	 /*****类型*****/ 
	 private String type;
	 /*****拟架部位*****/ 
	 private String frame;


	 public String getSectionId() {
		 return sectionId;
	 }

	 public void setSectionId(String sectionId) {
		 this.sectionId = sectionId;
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

	 public String getType() {
		 return type;
	 }

	 public void setType(String type) {
		 this.type = type;
	 }

	 public String getFrame() {
		 return frame;
	 }

	 public void setFrame(String frame) {
		 this.frame = frame;
	 }

	public BeamSectionVo() {
		super();
	}
}
