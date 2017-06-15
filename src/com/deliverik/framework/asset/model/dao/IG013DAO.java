package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.IG013Info;
import com.deliverik.framework.asset.model.SwitchConfigItemVW;
import com.deliverik.framework.asset.model.condition.IG013SearchCond;
import com.deliverik.framework.asset.model.condition.IG688SearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;



/**
 * 资产信息DAO接口
 * 
 */
public interface IG013DAO extends BaseHibernateDAO<IG013Info> {

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<IG013Info> findAll();

	/**
	 * 主键检索处理
	 * @param eiid 主键
	 * @return 检索结果
	 */
	public IG013Info findByPK(Serializable eiid);

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG013SearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG013Info> findByCond(final IG013SearchCond cond, final int start, final int count);
	
	/**
	 * 获取资产编号最大值 资产key+年+编号 （位数：4+2+6）
	 * 
	 * @param cond 资产信息检索条件
	 * @return 资产编号最大值（平台保留）
	 */
	
	public String searchMaxIG013InfoLable(final IG013SearchCond cond);
	
	/**
	 * 设备相关服务记录检索
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG013Info> searchDeviceService(final IG688SearchCond cond, final int start, final int count);
	
	/**
	 * 设备相关服务记录检索
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SwitchConfigItemVW> searchSwitchService(final String eiid,final String version,final String smallversion);
}
