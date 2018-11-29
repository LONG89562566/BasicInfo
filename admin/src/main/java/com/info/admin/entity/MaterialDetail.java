package com.info.admin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 材料出入库 实体类
 * @author ysh  
 * @date 2018-11-28 15:06:08
 */
public class MaterialDetail implements Serializable {
	private static final long serialVersionUID = 1L;
	 /*****主键*****/
	 private String materialDetailId;
	 /*****创建时间*****/
	 private Date createTime;
	 /*****创建时间 日常的字符串*****/
	 private String createTimeStr;
	 /*****（0，出库1，入库）*****/
	 private Long materialType;
	 /*****出入库数量*****/
	 private BigDecimal num;
	 /*****检验状态*****/
	 private String testState;
	 /*****检验报告单*****/
	 private String testReport;
	 /*****项目编号*****/
	 private String projectId;
	/*****物品ID*****/
	private String materialName;
	/*****出库批次ID*****/
	private String outId;
	/*****出库批次ID*****/
	private String outName;
	/*****(1,已经出库2，未出库)*****/
	private Long outState;
	/*****虚拟库物品ID*****/
	private String repertoryId;



	 public String getMaterialDetailId() {
		 return materialDetailId;
	 }

	 public void setMaterialDetailId(String materialDetailId) {
		 this.materialDetailId = materialDetailId;
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

	 public Long getMaterialType() {
		 return materialType;
	 }

	 public void setMaterialType(Long materialType) {
		 this.materialType = materialType;
	 }

	 public BigDecimal getNum() {
		 return num;
	 }

	 public void setNum(BigDecimal num) {
		 this.num = num;
	 }

	 public String getTestState() {
		 return testState;
	 }

	 public void setTestState(String testState) {
		 this.testState = testState;
	 }

	 
	public MaterialDetail() {
		super();
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getTestReport() {
		return testReport;
	}

	public void setTestReport(String testReport) {
		this.testReport = testReport;
	}


	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getOutId() {
		return outId;
	}

	public void setOutId(String outId) {
		this.outId = outId;
	}

	public String getOutName() {
		return outName;
	}

	public void setOutName(String outName) {
		this.outName = outName;
	}

	public Long getOutState() {
		return outState;
	}

	public void setOutState(Long outState) {
		this.outState = outState;
	}

	public String getRepertoryId() {
		return repertoryId;
	}

	public void setRepertoryId(String repertoryId) {
		this.repertoryId = repertoryId;
	}
}
