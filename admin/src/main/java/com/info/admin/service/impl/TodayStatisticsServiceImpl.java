package com.info.admin.service.impl;

import java.util.List;

import com.info.admin.dao.TodayStatisticsDao;
import com.info.admin.entity.TodayStatistics;
import com.info.admin.service.TodayStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.admin.dao.TodayStatisticsDao;
import com.info.admin.entity.TodayStatistics;
import com.info.admin.service.TodayStatisticsService;

/**
 */
@Service
public class TodayStatisticsServiceImpl implements TodayStatisticsService {

	@Autowired
	private TodayStatisticsDao todayStatisticsDao;

	@Override
	public List<TodayStatistics> getList(TodayStatistics todayStatistics) {
		return todayStatisticsDao.getList(todayStatistics);
	}
	
}
