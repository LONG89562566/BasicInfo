package com.info.admin.utils;


import com.info.admin.constants.DBPropertie;
import com.info.admin.entity.DBP;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang.StringUtils;

import java.io.InputStream;
import java.util.*;

/**
 * Properties操作，用于动态数据库
 * @author ljuenan
 */
public class PropertiesUtil {

    private static final String DeafultFile = "db-config.properties";
    /**
     * 获取文件路径(可改为参数传入)
     * @param fileName 文件名
     * @return
     */
    public static InputStream getStream(String fileName){
        if (fileName==null||fileName==""){
            fileName = DeafultFile;
        }
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
        return inputStream;
    }

    /**
     * 获取文件
     * @param fileName 文件名
     * @return
     */
    public static PropertiesConfiguration getConf(String fileName){
        PropertiesConfiguration config = null;
        try
        {
            config  = new PropertiesConfiguration(fileName);
            config.setAutoSave(true);
        }
        catch(ConfigurationException cex)
        {
            cex.printStackTrace();
        }
        return config;
    }
    /**
     * 新增/修改操作
     * @param dbp 数据源对象
     * @param fileName  文件名
     * @return
     */
	public static boolean setDB(DBP dbp,String fileName) throws Exception  {
	    boolean isOk;
        String code = dbp.getCode();
        if (StringUtils.isEmpty(dbp.getCode())){
            code = UUIDUtils.generateShortUuid();
        }
        PropertiesConfiguration config = getConf(fileName);
        config.setProperty(DBPropertie.DB_CODE+code,code);
        config.setProperty(DBPropertie.DB_ADDR+code,dbp.getIp());
        config.setProperty(DBPropertie.DB_PORT+code,dbp.getPort());
        config.setProperty(DBPropertie.DB_NAME+code,dbp.getName());
        config.setProperty(DBPropertie.DB_USER+code,dbp.getUser());
        config.setProperty(DBPropertie.DB_PWD+code,dbp.getPassword());
        isOk = StringUtils.isNotEmpty((String) config.getProperty(DBPropertie.DB_CODE+code));
        return isOk;
    }

    /**
     * 删除操作
     * @param code 源编号
     * @param fileName 文件名
     * @return
     */
    public static boolean delDB(String code,String fileName) throws Exception {
        boolean isOk;
        PropertiesConfiguration config = getConf(fileName);
        config.clearProperty(DBPropertie.DB_CODE+code);
        config.clearProperty(DBPropertie.DB_ADDR+code);
        config.clearProperty(DBPropertie.DB_PORT+code);
        config.clearProperty(DBPropertie.DB_NAME+code);
        config.clearProperty(DBPropertie.DB_USER+code);
        config.clearProperty(DBPropertie.DB_PWD+code);
        isOk = StringUtils.isEmpty((String) config.getProperty(DBPropertie.DB_CODE+code));
        return isOk;
    }

    /**
     * 查询数据源
     * @param code 源编号
     * @param fileName 文件名
     * @param dbFileName 数据源使用的配置文件
     * @return
     */
    public static DBP queryDB(String code,String fileName,String dbFileName)  {
        PropertiesConfiguration config = getConf(fileName);
        PropertiesConfiguration dbConfig = getConf(dbFileName);
        DBP dbp = new DBP();
        dbp.setCode(code);
        dbp.setIp((String) config.getProperty(DBPropertie.DB_ADDR+code));
        dbp.setPort((String) config.getProperty(DBPropertie.DB_PORT+code));
        dbp.setName((String) config.getProperty(DBPropertie.DB_NAME+code));
        dbp.setUser((String) config.getProperty(DBPropertie.DB_USER+code));
        dbp.setPassword((String) config.getProperty(DBPropertie.DB_PWD+code));
        dbp.setUse(dbConfig.getProperty(DBPropertie.DB_CODE).equals(code));
        return dbp;
    }


    /**
     * 查询数据源列表
     * @param fileName 文件名
     * @param dbFileName 数据源使用的配置文件
     * @return
     */
    public static List<DBP> queryDBList(String fileName,String dbFileName)  {
        List<DBP> list = new ArrayList<>();
        PropertiesConfiguration config = getConf(fileName);
        PropertiesConfiguration dbConfig = getConf(dbFileName);

        Iterator<String> it =  config.getKeys();
        while (it.hasNext()){
            if (it.next().contains(DBPropertie.DB_CODE)){
                DBP dbp = new DBP();
                //库码,即源编号
                String dbNum = it.next().substring(DBPropertie.DB_CODE.length()-2);
                //源编号
                Object code = config.getProperty(DBPropertie.DB_CODE+dbNum);
                dbp.setCode((String)code);
                //源地址
                dbp.setIp((String)config.getProperty(DBPropertie.DB_ADDR+dbNum));
                //源端口
                dbp.setPort((String)config.getProperty(DBPropertie.DB_PORT+dbNum));
                //源名称
                dbp.setName((String)config.getProperty(DBPropertie.DB_NAME+dbNum));
                //用户名
                dbp.setUser((String)config.getProperty(DBPropertie.DB_USER+dbNum));
                //密码
                dbp.setPassword((String)config.getProperty(DBPropertie.DB_PWD+dbNum));
                //是否默认
                dbp.setUse(dbConfig.getProperty(DBPropertie.DB_CODE).equals(code));
                list.add(dbp);
            }
        }
        return list;
    }

    /**
     * 设置当前数据源
     * @param dbp 源对象
     * @param fileName 文件名
     * @return
     */
    public static void setUseDB(DBP dbp, String fileName)  {
        PropertiesConfiguration config = getConf(fileName);
        config.setProperty(DBPropertie.DB_CODE, dbp.getCode());
        config.setProperty(DBPropertie.DB_URL, dbp.getUrl());
        config.setProperty(DBPropertie.DB_USER, dbp.getUser());
        config.setProperty(DBPropertie.DB_PWD, dbp.getPassword());
    }

}
