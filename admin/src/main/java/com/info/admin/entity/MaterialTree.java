package com.info.admin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 材料 实体类
 * @author ysh  
 * @date 2018-11-14 23:45:41
 */
public class MaterialTree implements Serializable {
	private static final long serialVersionUID = 1L;
	 /*****主键*****/
	 private String materialId;
	 /*****创建时间*****/
	 private Date createTime;
	 /*****删除标记*****/
	 private Long deleteFlag;
	 /*****项目编号*****/
	 private String projectId;
	 /*****材料名称*****/
	 private String materialName;
	 /*****规格型号*****/
	 private String model;
	 /*****计量单位*****/
	 private String unit;
	 /*****进场数量*****/
	 private BigDecimal entryNum;
	 /*****剩余数量*****/
	 private BigDecimal residualNum;

	public String getMaterialId() {
		return materialId;
	}

	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Long deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public BigDecimal getEntryNum() {
		return entryNum;
	}

	public void setEntryNum(BigDecimal entryNum) {
		this.entryNum = entryNum;
	}

	public BigDecimal getResidualNum() {
		return residualNum;
	}

	public void setResidualNum(BigDecimal residualNum) {
		this.residualNum = residualNum;
	}
}
