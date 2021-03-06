package com.info.admin.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 自定义桌面实体类
 * @author administrator  2018-11-13 16:23:58
 */
public class CustomDesktopVo implements Serializable {
	private static final long serialVersionUID = 1L;
	 /*****主键*****/ 
	 private String desktopId;
	 /*****创建时间*****/ 
	 private Date createTime;
	 /*****创建人编号*****/ 
	 private Long createUser;
	 /*****用户主键编号*****/ 
	 private Long userId;
	 /*****菜单编号*****/ 
	 private Long menuId;
	 /*****自定义名称*****/ 
	 private String customName;
	 /*****修改时间*****/ 
	 private Date updateTime;
	 /*****排序号*****/ 
	 private Long seq;
	/*****宽度*****/
	private String width;
	/*****高度*****/
	private String height;
	/***** 菜单名称 *****/
	private String menuName;
	/***** 连接地址 *****/
	private String menuHref;

	 public String getDesktopId() {
		 return desktopId;
	 }

	 public void setDesktopId(String desktopId) {
		 this.desktopId = desktopId;
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

	 public Long getUserId() {
		 return userId;
	 }

	 public void setUserId(Long userId) {
		 this.userId = userId;
	 }

	 public Long getMenuId() {
		 return menuId;
	 }

	 public void setMenuId(Long menuId) {
		 this.menuId = menuId;
	 }

	 public String getCustomName() {
		 return customName;
	 }

	 public void setCustomName(String customName) {
		 this.customName = customName;
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

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuHref() {
		return menuHref;
	}

	public void setMenuHref(String menuHref) {
		this.menuHref = menuHref;
	}

	public CustomDesktopVo() {
		super();
	}
}
