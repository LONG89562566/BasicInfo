package com.info.admin.utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * url转码、解码
 * @author administrator 
 */
public class TreeUtils {
	
    /**
     * URL 解码
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