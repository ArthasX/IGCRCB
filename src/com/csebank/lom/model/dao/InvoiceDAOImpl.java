/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.csebank.lom.model.Invoice;
import com.csebank.lom.model.condition.InvoiceInfoSearchCond;
import com.csebank.lom.model.entity.InvoiceTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;


/**
 * 
 * 发票管理DAO实现
 *
 */
@SuppressWarnings("deprecation")
public class InvoiceDAOImpl extends BaseHibernateDAOImpl<Invoice> implements InvoiceDAO {

	/**
	 * 构造函数
	 */
	public InvoiceDAOImpl(){
		super(InvoiceTB.class);
	}
   
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Invoice> findByCond(final InvoiceInfoSearchCond cond, final int start,
			final int count) {		
			DetachedCriteria c = getCriteria(cond);
			c.addOrder(Order.asc("iid"));
			List<Invoice> ret = findByCriteria(c, start, count);
			return ret;
		
	}

	public String getMaxRacode() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final InvoiceInfoSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(final InvoiceInfoSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//发票管理申请部门
		if( !StringUtils.isEmpty(cond.getIreqemp())){
			c.add(Expression.eq("ireqemp",cond.getIreqemp()));
		}
		if( !StringUtils.isEmpty(cond.getEiorgsyscoding())){
			c.add(Expression.eq("ireqemp",cond.getEiorgsyscoding()));
		}
		//申请人
		if( !StringUtils.isEmpty(cond.getIrequser())){
			c.add(Expression.like("irequser", "%"+cond.getIrequser()+"%"));
		}	
		//开票日期
		if( !StringUtils.isEmpty(cond.getIdate_from())){
			c.add(Expression.ge("idate", cond.getIdate_from()));
		}
		if( !StringUtils.isEmpty(cond.getIdate_to())){
			c.add(Expression.le("idate", cond.getIdate_to()));
		}
		//金额
		if( !StringUtils.isEmpty(cond.getIamount())){
			c.add(Expression.eq("iamount", BigDecimal.valueOf(Double.parseDouble(cond.getIamount()))));
		}	
		//状态
		if( !StringUtils.isEmpty(cond.getIstatus())&& !"notSelect".equals(cond.getIstatus())){
			c.add(Expression.eq("istatus", cond.getIstatus()));
		}	
		//发票类型
		if( !StringUtils.isEmpty(cond.getItype())){
			c.add(Expression.eq("itype", cond.getItype()));
		}	
		//申请人姓名
		if(StringUtils.isNotEmpty(cond.getIrequsername())){
			c.add(Expression.eq("irequsername", cond.getIrequsername()));
		}
		
		return c;
	}


}
