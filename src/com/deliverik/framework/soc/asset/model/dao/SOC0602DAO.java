/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.soc.asset.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0602Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0602SearchCond;

/**
 * 设备视图DAO接口
 * 
 * @author 
 */
public interface SOC0602DAO extends BaseHibernateDAO<SOC0602Info> {

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0602SearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0602Info> findByCond(final SOC0602SearchCond cond, final int start, final int count);
	
	/**
     * 条件检索处理：模糊查询设备名，返回设备所在机柜，机房
     * 
     * @param cond
     * @param start
     * @param count
     * @return
     */
    public List<Object[]> findZhiJiLocation(final SOC0602SearchCond cond);
}
