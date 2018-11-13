package com.info.admin.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 流程实体类
 * @author administrator  2018-11-13 16:23:58
 */
public class FlowVo implements Serializable {
	private static final long serialVersionUID = 1L;
	 /*****主键*****/ 
	 private String flowId;
	 /*****创建时间*****/ 
	 private Date createTime;
	 /*****创建人编号*****/ 
	 private Long createUser;
	 /*****创建人名称*****/ 
	 private String createUserCn;
	 /*****删除标记*****/ 
	 private Long deleteFlag;
	 /*****修改时间*****/ 
	 private Date updateTime;
	 /*****排序号*****/ 
	 private Long seq;
	 /*****节点名称*****/ 
	 private String name;
	 /*****上一节点*****/ 
	 private String lastNode;
	 /*****下一节点*****/ 
	 private String nextNode;
	 /*****业务表主键*****/ 
	 private String docUnid;


	 public String getFlowId() {
		 return flowId;
	 }

	 public void setFlowId(String flowId) {
		 this.flowId = flowId;
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

	 public String getCreateUserCn() {
		 return createUserCn;
	 }

	 public void setCreateUserCn(String createUserCn) {
		 this.createUserCn = createUserCn;
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

	 public String getLastNode() {
		 return lastNode;
	 }

	 public void setLastNode(String lastNode) {
		 this.lastNode = lastNode;
	 }

	 public String getNextNode() {
		 return nextNode;
	 }

	 public void setNextNode(String nextNode) {
		 this.nextNode = nextNode;
	 }

	 public String getDocUnid() {
		 return docUnid;
	 }

	 public void setDocUnid(String docUnid) {
		 this.docUnid = docUnid;
	 }

	public FlowVo() {
		super();
	}
}
