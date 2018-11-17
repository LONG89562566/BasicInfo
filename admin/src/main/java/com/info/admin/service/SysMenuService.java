package com.info.admin.service;

import java.util.List;

import com.info.admin.entity.SysMenu;

import net.sf.json.JSONArray;

/**
 * 菜单service
 * @author administrator
 */
public interface SysMenuService {

	/**
	 * 查询所有菜单
	 */
	 List<SysMenu> getAllMenu();

	/**
	 * 添加菜单
	 */
	 int insertMenu(SysMenu entity);

	/**
	 * 更新菜单
	 */
	 int updateMenu(SysMenu entity);
	
	/**
	 * 根据id查找菜单
	 */
	 SysMenu getMenuById(int menuId);
	
	/**
	 * 根据菜单id查询其子菜单
	 */
	 List<SysMenu> getChildrenMenu(int menuId);
	
	/*
	 * 分类树(json格式)
	 */
	 JSONArray menuTree(List<SysMenu> menuList,int parentId);

	/*
	 * 分类树(json格式)
	 */
	JSONArray menuTree(List<SysMenu> menuList);
	
	/**
	 * 根据角色取得菜单
	 */
	 List<SysMenu> getAllMenuByRoleId(int roleId);
	
	/**
	 * 添加角色菜单
	 */
	 int insertRoleMenu(int roleId,List<String> menuIdList);
	
	/**
	 * 查询用户的菜单
	 */
	 List<SysMenu> getMyMenu(List<SysMenu> menuList,int parentId);
	
	/**
	 * 根据用户和菜单类型查询菜单
	 */
	 List<SysMenu> getAllMenuByUserId(Long userId, int type);

	/****
	 * 根据用户取得可设置桌面的菜单
	 * @param userId
	 * @return
	 */
	List<SysMenu> getAllMenuDesktopByUserId( Long userId);
	/**
	 * 删除菜单
	 */
	 int deleteMenu(Integer menuId);

}
