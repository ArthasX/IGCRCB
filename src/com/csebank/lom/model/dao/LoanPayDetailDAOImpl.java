/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.csebank.lom.bl.IGLOMCONSTANTS;
import com.csebank.lom.model.LoanPayDetail;
import com.csebank.lom.model.condition.LoanPayDetailSearchCond;
import com.csebank.lom.model.entity.LoanPayDetailTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 
 * 借还款明细DAO实现
 *
 */
@SuppressWarnings("deprecation")
public class LoanPayDetailDAOImpl extends BaseHibernateDAOImpl<LoanPayDetail> implements LoanPayDetailDAO {

	/**
	 * 构造函数
	 */
	public LoanPayDetailDAOImpl(){
		super(LoanPayDetailTB.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<LoanPayDetail> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("lpdid"));
		List<LoanPayDetail> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param lpdid 主键
	 * @return 检索结果
	 */
	public LoanPayDetail findByPK(Serializable lpdid) {

		LoanPayDetail result = super.findByPK(lpdid);
		if(result == null) return null;

		return result;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final LoanPayDetailSearchCond cond){
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
	public List<LoanPayDetail> findByCond(final LoanPayDetailSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
//		c.addOrder(Order.asc("lpdid"));
		c.addOrder(Order.desc("lpddate"));
		List<LoanPayDetail> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(LoanPayDetailSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//接待管理ID
		if(cond.getRid_q()!=null && cond.getRid_q()!=0){
			c.add(Expression.eq("rid", cond.getRid_q()));
		}
		
		//借还款区分
		if(StringUtils.isNotEmpty(cond.getLpdtype_q())){
			c.add(Expression.eq("lpdtype", cond.getLpdtype_q()));
		}
		
		//借还款状态(审批或确认)
		if(StringUtils.isNotEmpty(cond.getLpdstatus_q())){
			if(IGLOMCONSTANTS.LPD_STATUS_YIQUEREN_YIHUANKUAN.equals(cond.getLpdstatus_q())){
				c.add(Expression.or(Expression.eq("lpdstatus", IGLOMCONSTANTS.LPD_STATUS_YIQUEREN), Expression.eq("lpdstatus", IGLOMCONSTANTS.LPD_STATUS_YIHUANKUAN)));

			} else {
				c.add(Expression.eq("lpdstatus", cond.getLpdstatus_q()));
			}
		}
		
		
		//借还款区分
		if(StringUtils.isNotEmpty(cond.getLpduser_q())){
			c.add(Expression.eq("lpduser", cond.getLpduser_q()));
		}
		
		//借款人
		if(StringUtils.isNotEmpty(cond.getLpduser_q())){
			c.add(Expression.eq("lpduser", cond.getLpduser_q()));
		}
		
		//发票日期开始
		if(StringUtils.isNotEmpty(cond.getLpdinvoicedate_from())){
			c.add(Expression.ge("lpdinvoicedate", cond.getLpdinvoicedate_from()));
			c.add(Expression.ne("lpdinvoicedate", ""));
		}

		//发票日期结束
		if(StringUtils.isNotEmpty(cond.getLpdinvoicedate_to())){
			c.add(Expression.le("lpdinvoicedate", cond.getLpdinvoicedate_to()));
			c.add(Expression.ne("lpdinvoicedate", ""));
		}
		
		//发票金额,大于0,冲抵查询用
		if(StringUtils.isNotEmpty(cond.getLpdinvoiceamount_q())){
			c.add(Expression.gt("lpdinvoiceamount", new BigDecimal(0)));
			c.add(Expression.eq("lpdtype", IGLOMCONSTANTS.LPD_TYPE_PAY_INVOICE));
			c.add(Expression.eq("lpdstatus", IGLOMCONSTANTS.LPD_STATUS_YIHUANKUAN));
			c.add(Expression.sql("ldid in (select lpdid from LoanPayDetail where lpdstatus = '4')"));
		}
		
		//借款ID
		if(cond.getLdid_invoice()!=null && cond.getLdid_invoice()!=0){
			c.add(Expression.eq("ldid", cond.getLdid_invoice()));
		}
		//借款查询日期开始时间
		if(StringUtils.isNotEmpty(cond.getTime_from())){

			c.add(Expression.ge("lpddate", cond.getTime_from()));
		}
		//借款查询日期结束时间
		if(StringUtils.isNotEmpty(cond.getTime_from())){

			c.add(Expression.le("lpddate", cond.getTime_to()));
		}
		//借款状态
		if(StringUtils.isNotEmpty(cond.getSpType())){

			c.add(Expression.eq("lpdstatus", cond.getSpType()));
		}
		return c;
	}
	
	/**
	 * 获取已还款现金数和已还款发票数
	 * 
	 * @param lpdid 借款记录ID
	 * @return 已还款现金数和已还款发票数
	 */
	
	@SuppressWarnings("unchecked")
	public BigDecimal[] searchAmountdAndInvoice(final Integer lpdid) {
		String sql =  "SELECT SUM(lpdamount),SUM(lpdinvoiceamount) FROM LoanPayDetailTB WHERE ldid = :lpdid";
		NamedParamMap p = getNamedParamMap();
		p.setInteger("lpdid", lpdid);
		List<Object[]> l = findByNamedParamMap(sql, p);
		BigDecimal[] array = new BigDecimal[]{new BigDecimal(0),new BigDecimal(0)};
		if( l.size() == 0 ) return array;
		for(Object[] obj : l) {
			if(obj[0] == null){
				array[0] = new BigDecimal(0);
			} else {
				array[0] = (BigDecimal)obj[0];
			}
			if(obj[1] == null){
				array[1] = new BigDecimal(0);
			} else {
				array[1] = (BigDecimal)obj[1];
			}
		}
		return array;
	}

}
