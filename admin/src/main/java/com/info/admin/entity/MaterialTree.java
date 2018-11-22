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
	 private String repertoryId;
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
	 /*****库存数量*****/
	 private BigDecimal num;

	public String getRepertoryId() {
		return repertoryId;
	}

	public void setRepertoryId(String repertoryId) {
		this.repertoryId = repertoryId;
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

	public BigDecimal getNum() {
		return num;
	}

	public void setNum(BigDecimal num) {
		this.num = num;
	}
}
