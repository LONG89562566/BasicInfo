package com.info.admin.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 问题库实体类
 * @author administrator  2018-11-19 18:06:32
 */
public class ProblemLibraryVo implements Serializable {
	private static final long serialVersionUID = 1L;
	 /*****主键*****/ 
	 private String supplierId;
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
	 /*****问题类型*****/ 
	 private Long type;
	 /*****检查内容*****/ 
	 private String inspectContent;
	 /*****检查人编号*****/ 
	 private String inspectUser;
	 /*****整改人编号*****/ 
	 private String rectifyUser;
	 /*****整改时间*****/ 
	 private Date rectifyTime;


	 public String getSupplierId() {
		 return supplierId;
	 }

	 public void setSupplierId(String supplierId) {
		 this.supplierId = supplierId;
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

	 public Long getType() {
		 return type;
	 }

	 public void setType(Long type) {
		 this.type = type;
	 }

	 public String getInspectContent() {
		 return inspectContent;
	 }

	 public void setInspectContent(String inspectContent) {
		 this.inspectContent = inspectContent;
	 }

	 public String getInspectUser() {
		 return inspectUser;
	 }

	 public void setInspectUser(String inspectUser) {
		 this.inspectUser = inspectUser;
	 }

	 public String getRectifyUser() {
		 return rectifyUser;
	 }

	 public void setRectifyUser(String rectifyUser) {
		 this.rectifyUser = rectifyUser;
	 }

	 public Date getRectifyTime() {
		 return rectifyTime;
	 }

	 public void setRectifyTime(Date rectifyTime) {
		 this.rectifyTime = rectifyTime;
	 }

	public ProblemLibraryVo() {
		super();
	}
}
