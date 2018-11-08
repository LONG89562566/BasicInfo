package com.info.admin.dao;

import java.util.List;

import com.info.admin.entity.TodayStatistics;
import org.apache.ibatis.annotations.Param;

import com.info.admin.entity.TodayStatistics;

/**
 */
public interface TodayStatisticsDao {

	/**
	 * 获取全部
	 */
	public List<TodayStatistics> getList(@Param("t") TodayStatistics todayStatistics);
}
