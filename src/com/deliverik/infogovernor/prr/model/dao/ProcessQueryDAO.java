/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.model.dao;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程通用查询接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface ProcessQueryDAO {

	/**
	 * 取得查询数量
	 * @param sql 执行sql
	 * @return 查询数量
	 */
	public int getSearchCount(String sql);

	/**
	 * 流程查询操作
	 * @param sql 执行sql
	 * @param start 起始页码
	 * @param count 显示数量
	 * @return 流程信息集合
	 */
	public List<Map<String, Object>> searchProcessRecordInfo(String sql, int start, int count);

}
