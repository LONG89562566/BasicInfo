package com.info.admin.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 文件实体类
 * @author administrator  2018-11-14 23:45:42
 */
public class FileAttrVo implements Serializable {
	private static final long serialVersionUID = 1L;
	 /*****主键*****/ 
	 private String fileId;
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
	 /*****名称*****/ 
	 private String name;
	 /*****备注*****/ 
	 private String remark;
	 /*****地址*****/ 
	 private String url;
	 /*****业务表主键*****/ 
	 private String docUnid;
	 /*****流程节点主键*****/ 
	 private String flowId;
	 /*****类型*****/ 
	 private String type;


	 public String getFileId() {
		 return fileId;
	 }

	 public void setFileId(String fileId) {
		 this.fileId = fileId;
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

	 public String getName() {
		 return name;
	 }

	 public void setName(String name) {
		 this.name = name;
	 }

	 public String getRemark() {
		 return remark;
	 }

	 public void setRemark(String remark) {
		 this.remark = remark;
	 }

	 public String getUrl() {
		 return url;
	 }

	 public void setUrl(String url) {
		 this.url = url;
	 }

	 public String getDocUnid() {
		 return docUnid;
	 }

	 public void setDocUnid(String docUnid) {
		 this.docUnid = docUnid;
	 }

	 public String getFlowId() {
		 return flowId;
	 }

	 public void setFlowId(String flowId) {
		 this.flowId = flowId;
	 }

	 public String getType() {
		 return type;
	 }

	 public void setType(String type) {
		 this.type = type;
	 }

	public FileAttrVo() {
		super();
	}
}
