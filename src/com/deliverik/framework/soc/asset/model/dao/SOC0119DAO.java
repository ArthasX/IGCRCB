package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0119SearchCond;



/**
 * 资产项关系信息DAO接口
 * 
 */
public interface SOC0119DAO extends BaseHibernateDAO<SOC0119Info> {

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<SOC0119Info> findAll();

	/**
	 * 主键检索处理
	 * @param eirid 主键
	 * @return 检索结果
	 */
	public SOC0119Info findByPK(Serializable eirid);

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0119SearchCond cond);
	
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0119Info> findByCond(final SOC0119SearchCond cond, final int start, final int count);
	
	public List<SOC0119Info> searchMaxEntityItemRelation(final SOC0119SearchCond cond,final int start, final int count);
	/**
	 * 资产关系最大版本检索
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0119Info> searchMaxEntityItemRelation(final SOC0119SearchCond cond);
	
	/**
	 * 根据eiid删除关系数据
	 * @param eiid
	 */
	public void delByEiid(Integer eiid);
	
	/**
	 * 根据eiid 查询与其相关的eiid
	 * @param eiid
	 * @return
	 */
	public List<Integer> searchRelationByEiid(final SOC0119SearchCond cond);
	
	/**
	 * 密码关联关系查询
	 * @param cond
	 * @return
	 */
	public List<Integer> searchCldeiidByPareiid(final SOC0119SearchCond cond);
	
	/**
     * 条件检索处理
     * @param cond 检索条件
     * @param start 检索记录起始行号
     * @param count 检索记录件数
     * @return 检索结果列表
     */
    public List<SOC0119Info> findByCondBySql(final SOC0119SearchCond cond, final int start, final int count);
	
    /**
	 * 根据eiid_in 查询与其相关的eiid
	 * @param eiid
	 * @return
	 */
	public List<Integer> searchRelationByEiid_in(final SOC0119SearchCond cond);
	
	/**
	 * 根据eiid删除关系数据
	 * @param eiid
	 */
	public void delByEiid(Integer eiid,String eirrelationcode);
}
