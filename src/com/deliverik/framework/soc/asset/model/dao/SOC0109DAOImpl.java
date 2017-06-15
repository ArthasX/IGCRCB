package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0109SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0109TB;

/**
 * 资产配置信息DAO实现
 * 
 */
@SuppressWarnings("deprecation")
public class SOC0109DAOImpl extends BaseHibernateDAOImpl<SOC0109Info> implements SOC0109DAO {

	/**
	 * 构造函数
	 */
	public SOC0109DAOImpl(){
		super(SOC0109TB.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	@Override
	public List<SOC0109Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("cid"));
		List<SOC0109Info> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param cid 主键
	 * @return 检索结果
	 */
	@Override
	public SOC0109Info findByPK(Serializable cid) {

		SOC0109Info config = super.findByPK(cid);
		if(config == null) return null;

		return config;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0109SearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0109Info> findByCond(final SOC0109SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("cid"));
		List<SOC0109Info> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 获取最大CID用
	 * @param cond
	 * @return
	 */
	public List<SOC0109Info> findMaxCidByCond(final SOC0109SearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("cid"));
		List<SOC0109Info> ret = findByCriteria(c);
		return ret;
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(SOC0109SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//资产属性ID
		if(!StringUtils.isEmpty(cond.getCid())){
			c.add(Expression.eq("cid", cond.getCid()));
		}
		//资产属性ID like
		if(!StringUtils.isEmpty(cond.getCid_like())){
			c.add(Expression.like("cid", cond.getCid_like() + "%"));
		}
		//资产模型ID
		if( !StringUtils.isEmpty(cond.getEid())){
			c.add(Expression.eq("eid", cond.getEid()));
		}	
		//资产属性编号
		if( !StringUtils.isEmpty(cond.getClabel())){
			c.add(Expression.eq("clabel", cond.getClabel()));
		}	
		//资产属性名称
		if( !StringUtils.isEmpty(cond.getCname())){
			c.add(Expression.like("cname", "%" + cond.getCname() + "%"));
		}	
		//资产属性类型
		if( !StringUtils.isEmpty(cond.getCcategory())){
			c.add(Expression.eq("ccategory", cond.getCcategory()));
		}
		//资产属性状态
		if( !StringUtils.isEmpty(cond.getCstatus())){
			c.add(Expression.eq("cstatus", cond.getCstatus()));
		}
		//资产属性类型默认属性标志
		if( cond.getCseq()!=null && cond.getCseq()!= 0){
			c.add(Expression.ne("cseq", cond.getCseq()));
		}
		// 资产属性类型默认属性标志
		if (cond.getCseq() != null && cond.getCseq() != 0) {
			c.add(Expression.ne("cseq", cond.getCseq()));
		}
		//资产属性状态
		if( cond.getCattachList()!=null && cond.getCattachList().size()>0){
			c.add(Expression.in("cattach", cond.getCattachList()));
		}

		// 资产属性层次码集合
		if (cond.getEsyscodingList() != null && cond.getEsyscodingList().size() > 0) {
			c.add(Restrictions.in("esyscoding", cond.getEsyscodingList()));
		}

		// 资产码 like
		if (!StringUtils.isEmpty(cond.getEsyscoding_like())) {
			c.add(Expression.like("esyscoding", cond.getEsyscoding_like() + "%"));
		}
		return c;
	}


}
