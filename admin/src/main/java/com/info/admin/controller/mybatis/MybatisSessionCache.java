package com.info.admin.controller.mybatis;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;

import com.info.admin.listener.SpringContextUtil;

/**
 * MybatisSessionCache清理
 * 
 * @author administrator
 */
@Component
public class MybatisSessionCache {

	private static final Logger logger = LoggerFactory.getLogger(MybatisSessionCache.class);

	private SqlSessionFactory sqlSessionFactory;
	private Resource[] mapperLocations;
	private String packageSearchPath = "classpath:com/hw77/admin/dao/impl/*Dao.xml";

	private HashMap<String, Long> fileMapping = new HashMap<String, Long>();// 记录文件是否变化

	public void refreshMapper() {
		try {

			SqlSessionFactory sessionFactory = (SqlSessionFactory) SpringContextUtil.getBean("sqlSessionFactory");

			sqlSessionFactory = sessionFactory;

			Configuration configuration = sqlSessionFactory.getConfiguration();

			// step.1 扫描文件
			try {
				this.scanMapperXml();
			} catch (IOException e) {
				logger.error("packageSearchPath扫描包路径配置错误");
				return;
			}
			logger.info("==============刷新前mapper中的内容===============");
			for (String name : configuration.getMappedStatementNames()) {
				logger.info(name);
			}

			// step.2 判断是否有文件发生了变化
			if (this.isChanged()) {
				// step.2.1 清理
				this.removeConfig(configuration);

				// step.2.2 重新加载
				for (Resource configLocation : mapperLocations) {
					try {
						XMLMapperBuilder xmlMapperBuilder = new XMLMapperBuilder(configLocation.getInputStream(),
								configuration, configLocation.toString(), configuration.getSqlFragments());
						xmlMapperBuilder.parse();
						logger.info("mapper文件[" + configLocation.getFilename() + "]缓存加载成功");
					} catch (IOException e) {
						logger.error("mapper文件[" + configLocation.getFilename() + "]不存在或内容格式不对");
						continue;
					}
				}
			}
			logger.info("==============刷新后mapper中的内容===============");
			for (String name : configuration.getMappedStatementNames()) {
				logger.info(name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setPackageSearchPath(String packageSearchPath) {
		this.packageSearchPath = packageSearchPath;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	/**
	 * 扫描xml文件所在的路径
	 * 
	 * @throws IOException
	 */
	private void scanMapperXml() throws IOException {
		this.mapperLocations = new PathMatchingResourcePatternResolver().getResources(packageSearchPath);
	}

	/**
	 * 清空Configuration中几个重要的缓存
	 * 
	 * @param configuration
	 * @throws Exception
	 */
	private void removeConfig(Configuration configuration) throws Exception {
		Class<?> classConfig = configuration.getClass();
		clearMap(classConfig, configuration, "mappedStatements");
		clearMap(classConfig, configuration, "caches");
		clearMap(classConfig, configuration, "resultMaps");
		clearMap(classConfig, configuration, "parameterMaps");
		clearMap(classConfig, configuration, "keyGenerators");
		clearMap(classConfig, configuration, "sqlFragments");

		clearSet(classConfig, configuration, "loadedResources");

	}

	@SuppressWarnings("rawtypes")
	private void clearMap(Class<?> classConfig, Configuration configuration, String fieldName) throws Exception {
		Field field = classConfig.getDeclaredField(fieldName);
		field.setAccessible(true);
		Map mapConfig = (Map) field.get(configuration);
		mapConfig.clear();
	}

	@SuppressWarnings("rawtypes")
	private void clearSet(Class<?> classConfig, Configuration configuration, String fieldName) throws Exception {
		Field field = classConfig.getDeclaredField(fieldName);
		field.setAccessible(true);
		Set setConfig = (Set) field.get(configuration);
		setConfig.clear();
	}

	/**
	 * 判断文件是否发生了变化
	 * 
	 * @param resource
	 * @return
	 * @throws IOException
	 */
	private boolean isChanged() throws IOException {
		boolean flag = false;
		for (Resource resource : mapperLocations) {
			String resourceName = resource.getFilename();

			boolean addFlag = !fileMapping.containsKey(resourceName);// 此为新增标识

			// 修改文件:判断文件内容是否有变化
			Long compareFrame = fileMapping.get(resourceName);
			long lastFrame = resource.contentLength() + resource.lastModified();
			boolean modifyFlag = null != compareFrame && compareFrame.longValue() != lastFrame;// 此为修改标识

			// 新增或是修改时,存储文件
			if (addFlag || modifyFlag) {
				fileMapping.put(resourceName, Long.valueOf(lastFrame));// 文件内容帧值
				flag = true;
			}
		}
		return flag;
	}
}