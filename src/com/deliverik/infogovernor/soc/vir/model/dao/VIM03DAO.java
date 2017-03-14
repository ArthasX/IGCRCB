/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.vir.model.VIM03Info;
import com.deliverik.infogovernor.soc.vir.model.condition.Vim03SearchCond;

/**
  * 概述: 资源申请虚机信息表DAO接口
  * 功能描述: 资源申请虚机信息表DAO接口
  * 创建记录: 2014/02/13
  * 修改记录: 
  */
public interface VIM03DAO extends BaseHibernateDAO<VIM03Info> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<VIM03Info> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public VIM03Info findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final Vim03SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<VIM03Info> findByCond(
			final Vim03SearchCond cond, final int start,
			final int count);
	
	public  List<Object[]>  getOrgCountByMonth(String sDate);
	
	/**
     * 查询一个季度内的资源申请数量
     * 
     * @param sDate
     * @return
     */
    public List<Object[]> getOrgCount(String sDate);
    
    /**
     * 检索条数取得
     *
     * @param cond 检索条件
     * @return 检索条数
     */
    public Integer  getVMCount4HostCountByCond(final Vim03SearchCond cond);

    /**
     * 获取主机下虚机的个数
     *
     * @param cond 检索条件
     * @return 检索结果列表
     */
    public List<Object[]> getVMCount4HostByCond(final Vim03SearchCond cond, final int start, final int count);
}