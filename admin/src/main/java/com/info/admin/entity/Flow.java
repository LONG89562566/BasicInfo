package com.info.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 流程 实体类
 * @author ysh  
 * @date 2018-11-14 23:45:41
 */
public class 	Flow implements Serializable {
	private static final long serialVersionUID = 1L;
	 /*****主键*****/
	 private String flowId;
	 /*****创建时间*****/
	 private Date createTime;
	 /*****创建时间 日常的字符串*****/
	 private String createTimeStr;
	 /*****创建人编号*****/
	 private Long createUser;
	 /*****创建人名称*****/
	 private String createUserCn;
	 /*****删除标记*****/
	 private Long deleteFlag;
	 /*****修改时间*****/
	 private Date updateTime;
	 /*****修改时间 日常的字符串*****/
	 private String updateTimeStr;
	 /*****排序号*****/
	 private Long seq;
	 /*****节点名称*****/
	 private String name;
	 /*****上一节点*****/
	 private String lastNode;
	 /*****下一节点*****/
	 private String nextNode;
	 /*****参与部门编号*****/
	 private String orgId;
	 /*****参与角色编号*****/
	 private String roleId;
	 /*****参与人编号*****/
	 private String userId;
	 /*****意见*****/
	 private String msg;
	 /*****是否完成*****/
	 private Long isDone;
	 /*****业务内容*****/
	 private String showTitle;
	 /*****业务详情页面*****/
	 private String docUrl;
	 /*****业务表主键*****/
	 private String docUnid;
	 /*****经办人编号*****/
	 private String operator;
	 /*****经办人名称*****/
	 private String operatorCn;
	 /*****是否提交*****/
	 private Long isSubmit;
     /*****是否结束*****/
     private Long isEnd;

	 public String getFlowId() {
		 return flowId;
	 }

	 public void setFlowId(String flowId) {
		 this.flowId = flowId;
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

	 public String getOrgId() {
		 return orgId;
	 }

	 public void setOrgId(String orgId) {
		 this.orgId = orgId;
	 }

	 public String getRoleId() {
		 return roleId;
	 }

	 public void setRoleId(String roleId) {
		 this.roleId = roleId;
	 }

	 public String getUserId() {
		 return userId;
	 }

	 public void setUserId(String userId) {
		 this.userId = userId;
	 }

	 public String getMsg() {
		 return msg;
	 }

	 public void setMsg(String msg) {
		 this.msg = msg;
	 }

	 public Long getIsDone() {
		 return isDone;
	 }

	 public void setIsDone(Long isDone) {
		 this.isDone = isDone;
	 }

	 public String getShowTitle() {
		 return showTitle;
	 }

	 public void setShowTitle(String showTitle) {
		 this.showTitle = showTitle;
	 }

	 public String getDocUrl() {
		 return docUrl;
	 }

	 public void setDocUrl(String docUrl) {
		 this.docUrl = docUrl;
	 }

	 public String getDocUnid() {
		 return docUnid;
	 }

	 public void setDocUnid(String docUnid) {
		 this.docUnid = docUnid;
	 }

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getOperatorCn() {
		return operatorCn;
	}

	public void setOperatorCn(String operatorCn) {
		this.operatorCn = operatorCn;
	}

	public Long getIsSubmit() {
		return isSubmit;
	}

	public void setIsSubmit(Long isSubmit) {
		this.isSubmit = isSubmit;
	}

    public Long getIsEnd() {
        return isEnd;
    }

    public void setIsEnd(Long isEnd) {
        this.isEnd = isEnd;
    }

    public Flow() {
		super();
	}
}
