package org.manage.dao;

import java.util.Map;

import org.manage.entity.ScheduleJobEntity;

/**
 * 定时任务
 * 
 * @author lyg
 * @email 964793210@qq.com
 * @date 2016年12月1日 下午10:29:57
 */
public interface ScheduleJobDao extends BaseDao<ScheduleJobEntity> {
	
	/**
	 * 批量更新状态
	 */
	int updateBatch(Map<String, Object> map);
}
