package com.info.admin.utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 树形结构优化
 * @author ljuenan
 * @date 2018/11/19 15:16:00
 */
public class TreeUtils {

    /**
     * 返回树形结构json数据
     * @param list 数据，因读大于写
     * @param parentIdV 父节点的值
     * @param parentIdN 父节点的名称
     * @param IdN 节点编号
     * @return JSONArray
     */
    public static JSONArray getTreeJson(CopyOnWriteArrayList<?> list, String parentIdV,String parentIdN,String IdN) {
        JSONArray all = new JSONArray();
        for (Object obj : list){
            JSONObject main = JSONObject.fromObject(obj);
            String childrenId = main.getString(IdN);
            String pid = main.getString(parentIdN);
            if (parentIdV.equals(pid)) {
                JSONArray children = getTreeJson(list, childrenId,parentIdN,IdN);
                main.put("children", children);
                all.add(main);
                list.remove(obj);
            }
        }

        return all;
    }
    

}