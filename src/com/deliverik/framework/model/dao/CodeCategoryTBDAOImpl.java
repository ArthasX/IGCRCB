package com.deliverik.framework.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.model.CodeCategoryInfo;
import com.deliverik.framework.model.condition.CodeCategorySearchCond;
import com.deliverik.framework.model.entity.CodeCategoryTB;

/**
 * 数据分类信息DAO实现
 * 
 */
@SuppressWarnings("deprecation")
public class CodeCategoryTBDAOImpl extends BaseHibernateDAOImpl<CodeCategoryInfo> implements CodeCategoryTBDAO {

	/**
	 * 构造函数
	 */
	public CodeCategoryTBDAOImpl(){
		super(CodeCategoryTB.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<CodeCategoryInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("ccid"));
		List<CodeCategoryInfo> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param pid 主键
	 * @return 检索结果
	 */
	public CodeCategoryInfo findByPK(Serializable pk) {

		CodeCategoryInfo codeDetail = super.findByPK(pk);
		if(codeDetail == null) return null;

		return codeDetail;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final CodeCategorySearchCond cond){
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
	public List<CodeCategoryInfo> findByCond(final CodeCategorySearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("ccid"));
		List<CodeCategoryInfo> ret = findByCriteria(c, start, count);
		return ret;
	}


	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(CodeCategorySearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//分类CD
		if( !StringUtils.isEmpty(cond.getCcid())){
			c.add(Expression.eq("ccid", cond.getCcid()));
		}	
		//上级分类CD
		if( !StringUtils.isEmpty(cond.getPccid())){
			c.add(Expression.eq("pccid", cond.getPccid()));
		}	
		//数据编辑标识
		if( !StringUtils.isEmpty(cond.getCceditable())){
			c.add(Expression.eq("cceditable", cond.getCceditable()));
		}	
		//是否层次数据
		if( cond.isTree()){
			c.add(Expression.gt("pcflag", "0"));
			c.add(Expression.or(Expression.eq("pccid", ""),Expression.isNull("pccid")));
		}	
		return c;
	}
}
