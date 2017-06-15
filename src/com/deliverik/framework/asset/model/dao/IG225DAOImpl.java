package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.asset.model.IG225Info;
import com.deliverik.framework.asset.model.condition.IG225SearchCond;
import com.deliverik.framework.asset.model.entity.IG225TB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 资产配置信息DAO实现
 * 
 */
@SuppressWarnings("deprecation")
public class IG225DAOImpl extends BaseHibernateDAOImpl<IG225Info> implements IG225DAO {

	/**
	 * 构造函数
	 */
	public IG225DAOImpl(){
		super(IG225TB.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<IG225Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("cid"));
		List<IG225Info> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param cid 主键
	 * @return 检索结果
	 */
	public IG225Info findByPK(Serializable cid) {

		IG225Info config = super.findByPK(cid);
		if(config == null) return null;

		return config;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG225SearchCond cond){
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
	public List<IG225Info> findByCond(final IG225SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("cid"));
		List<IG225Info> ret = findByCriteria(c, start, count);
		return ret;
	}


	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG225SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//资产模型ID
		if( !StringUtils.isEmpty(cond.getEid())){
			c.add(Expression.eq("eid", Integer.parseInt(cond.getEid())));
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
		
		//资产属性状态
		if( cond.getCattachList()!=null && cond.getCattachList().size()>0){
			c.add(Expression.in("cattach", cond.getCattachList()));
		}
		return c;
	}


}
