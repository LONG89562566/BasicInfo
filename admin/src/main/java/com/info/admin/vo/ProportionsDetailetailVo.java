package com.info.admin.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 配合比详情实体类
 * @author administrator  2018-11-14 23:45:42
 */
public class ProportionsDetailetailVo implements Serializable {
	private static final long serialVersionUID = 1L;
	 /*****主键*****/ 
	 private String detailId;
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
	 /*****配合比编号*****/ 
	 private String proportionsId;
	 /*****材料编号*****/ 
	 private String materialId;
	 /*****材料数量*****/ 
	 private BigDecimal num;


	 public String getDetailId() {
		 return detailId;
	 }

	 public void setDetailId(String detailId) {
		 this.detailId = detailId;
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

	 public String getProportionsId() {
		 return proportionsId;
	 }

	 public void setProportionsId(String proportionsId) {
		 this.proportionsId = proportionsId;
	 }

	 public String getMaterialId() {
		 return materialId;
	 }

	 public void setMaterialId(String materialId) {
		 this.materialId = materialId;
	 }

	 public BigDecimal getNum() {
		 return num;
	 }

	 public void setNum(BigDecimal num) {
		 this.num = num;
	 }

	public ProportionsDetailetailVo() {
		super();
	}
}
