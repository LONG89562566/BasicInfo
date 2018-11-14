package com.info.admin.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 混泥土信息实体类
 * @author administrator  2018-11-14 23:45:42
 */
public class ConcreteInfoVo implements Serializable {
	private static final long serialVersionUID = 1L;
	 /*****主键*****/ 
	 private String concreteId;
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
	 /*****项目编号*****/ 
	 private String projectId;
	 /*****混泥土别名*****/ 
	 private String name;
	 /*****混泥土等级*****/ 
	 private Long level;
	 /*****配合比编号*****/ 
	 private String proportionId;
	 /*****混泥土方量*****/ 
	 private Float square;
	 /*****总材料用量*****/ 
	 private String totalUse;


	 public String getConcreteId() {
		 return concreteId;
	 }

	 public void setConcreteId(String concreteId) {
		 this.concreteId = concreteId;
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

	 public String getProjectId() {
		 return projectId;
	 }

	 public void setProjectId(String projectId) {
		 this.projectId = projectId;
	 }

	 public String getName() {
		 return name;
	 }

	 public void setName(String name) {
		 this.name = name;
	 }

	 public Long getLevel() {
		 return level;
	 }

	 public void setLevel(Long level) {
		 this.level = level;
	 }

	 public String getProportionId() {
		 return proportionId;
	 }

	 public void setProportionId(String proportionId) {
		 this.proportionId = proportionId;
	 }

	 public Float getSquare() {
		 return square;
	 }

	 public void setSquare(Float square) {
		 this.square = square;
	 }

	 public String getTotalUse() {
		 return totalUse;
	 }

	 public void setTotalUse(String totalUse) {
		 this.totalUse = totalUse;
	 }

	public ConcreteInfoVo() {
		super();
	}
}
