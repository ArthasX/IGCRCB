/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.csebank.lom.bl.IGLOMCONSTANTS;
import com.csebank.lom.model.Ginoutstockdetail;
import com.csebank.lom.model.condition.GinoutstockdetailSearchCond;
import com.csebank.lom.model.entity.GinoutstockdetailTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 
 * 物品入出库明细信息DAO实现
 *
 */
@SuppressWarnings("deprecation")
public class GinoutstockdetailDAOImpl extends BaseHibernateDAOImpl<Ginoutstockdetail> implements GinoutstockdetailDAO {

	/**
	 * 构造函数
	 */
	public GinoutstockdetailDAOImpl(){
		super(GinoutstockdetailTB.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<Ginoutstockdetail> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("giodid"));
		List<Ginoutstockdetail> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param rid 主键
	 * @return 检索结果
	 */
	public Ginoutstockdetail findByPK(Serializable giodid) {

		Ginoutstockdetail result = super.findByPK(giodid);
		if(result == null) return null;

		return result;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final GinoutstockdetailSearchCond cond){
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
	public List<Ginoutstockdetail> findByCond(final GinoutstockdetailSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("giodid"));
		List<Ginoutstockdetail> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(GinoutstockdetailSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//入出库明细ID
		if(cond.getGiodid()!=null && cond.getGiodid()!=0){
			c.add(Expression.eq("giodid", cond.getGiodid()));
		}
		
		//物品种类
		if(StringUtils.isNotEmpty(cond.getGiodcategory())){
			c.add(Expression.like("giodcategory", cond.getGiodcategory()+"%"));
		}
		
		//物品编码
		if(StringUtils.isNotEmpty(cond.getGiodcode())){
			c.add(Expression.eq("giodcode", cond.getGiodcode()));
		}
		
		if(StringUtils.isNotEmpty(cond.getGiotime_f())){
			c.add(Expression.ge("giodtime", cond.getGiotime_f()));
		}
		if(StringUtils.isNotEmpty(cond.getGiotime_t())){
			c.add(Expression.le("giodtime", cond.getGiotime_t()));
		}
		
		//入库类型
		if(StringUtils.isNotEmpty(cond.getGiodtype())){
			c.add(Expression.eq("giodtype", cond.getGiodtype()));
		}
		
		//入库状态
		if(StringUtils.isNotEmpty(cond.getGiodstatus())){
			c.add(Expression.eq("giodstatus", cond.getGiodstatus()));
		}
		
		//所属机构
		if(StringUtils.isNotEmpty(cond.getGiodorg())){
			c.add(Expression.eq("giodorg", cond.getGiodorg()));
		}
		
		//采购申请单编号
		if(StringUtils.isNotEmpty(cond.getGiodreqnum())){
			c.add(Expression.eq("giodreqnum", cond.getGiodreqnum()));
		}
		
		if(StringUtils.isNotEmpty(cond.getGiodoutype())){
			List<String> condList = new ArrayList<String>();
			condList.add(IGLOMCONSTANTS.GIODTYPE_RK);
			condList.add(IGLOMCONSTANTS.GIODTYPE_LY);
			condList.add(IGLOMCONSTANTS.GIODTYPE_TJ);
			condList.add(IGLOMCONSTANTS.GIODTYPE_HX);
			c.add(Expression.in("giodtype", condList));
		}
		
		return c;
	}

}
