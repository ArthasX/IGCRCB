/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
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
 * ��Ʊ����DAOʵ��
 *
 */
@SuppressWarnings("deprecation")
public class InvoiceDAOImpl extends BaseHibernateDAOImpl<Invoice> implements InvoiceDAO {

	/**
	 * ���캯��
	 */
	public InvoiceDAOImpl(){
		super(InvoiceTB.class);
	}
   
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
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
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final InvoiceInfoSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(final InvoiceInfoSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//��Ʊ�������벿��
		if( !StringUtils.isEmpty(cond.getIreqemp())){
			c.add(Expression.eq("ireqemp",cond.getIreqemp()));
		}
		if( !StringUtils.isEmpty(cond.getEiorgsyscoding())){
			c.add(Expression.eq("ireqemp",cond.getEiorgsyscoding()));
		}
		//������
		if( !StringUtils.isEmpty(cond.getIrequser())){
			c.add(Expression.like("irequser", "%"+cond.getIrequser()+"%"));
		}	
		//��Ʊ����
		if( !StringUtils.isEmpty(cond.getIdate_from())){
			c.add(Expression.ge("idate", cond.getIdate_from()));
		}
		if( !StringUtils.isEmpty(cond.getIdate_to())){
			c.add(Expression.le("idate", cond.getIdate_to()));
		}
		//���
		if( !StringUtils.isEmpty(cond.getIamount())){
			c.add(Expression.eq("iamount", BigDecimal.valueOf(Double.parseDouble(cond.getIamount()))));
		}	
		//״̬
		if( !StringUtils.isEmpty(cond.getIstatus())&& !"notSelect".equals(cond.getIstatus())){
			c.add(Expression.eq("istatus", cond.getIstatus()));
		}	
		//��Ʊ����
		if( !StringUtils.isEmpty(cond.getItype())){
			c.add(Expression.eq("itype", cond.getItype()));
		}	
		//����������
		if(StringUtils.isNotEmpty(cond.getIrequsername())){
			c.add(Expression.eq("irequsername", cond.getIrequsername()));
		}
		
		return c;
	}


}
