/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
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
 * �軹����ϸDAOʵ��
 *
 */
@SuppressWarnings("deprecation")
public class LoanPayDetailDAOImpl extends BaseHibernateDAOImpl<LoanPayDetail> implements LoanPayDetailDAO {

	/**
	 * ���캯��
	 */
	public LoanPayDetailDAOImpl(){
		super(LoanPayDetailTB.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<LoanPayDetail> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("lpdid"));
		List<LoanPayDetail> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param lpdid ����
	 * @return �������
	 */
	public LoanPayDetail findByPK(Serializable lpdid) {

		LoanPayDetail result = super.findByPK(lpdid);
		if(result == null) return null;

		return result;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final LoanPayDetailSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<LoanPayDetail> findByCond(final LoanPayDetailSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
//		c.addOrder(Order.asc("lpdid"));
		c.addOrder(Order.desc("lpddate"));
		List<LoanPayDetail> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(LoanPayDetailSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//�Ӵ�����ID
		if(cond.getRid_q()!=null && cond.getRid_q()!=0){
			c.add(Expression.eq("rid", cond.getRid_q()));
		}
		
		//�軹������
		if(StringUtils.isNotEmpty(cond.getLpdtype_q())){
			c.add(Expression.eq("lpdtype", cond.getLpdtype_q()));
		}
		
		//�軹��״̬(������ȷ��)
		if(StringUtils.isNotEmpty(cond.getLpdstatus_q())){
			if(IGLOMCONSTANTS.LPD_STATUS_YIQUEREN_YIHUANKUAN.equals(cond.getLpdstatus_q())){
				c.add(Expression.or(Expression.eq("lpdstatus", IGLOMCONSTANTS.LPD_STATUS_YIQUEREN), Expression.eq("lpdstatus", IGLOMCONSTANTS.LPD_STATUS_YIHUANKUAN)));

			} else {
				c.add(Expression.eq("lpdstatus", cond.getLpdstatus_q()));
			}
		}
		
		
		//�軹������
		if(StringUtils.isNotEmpty(cond.getLpduser_q())){
			c.add(Expression.eq("lpduser", cond.getLpduser_q()));
		}
		
		//�����
		if(StringUtils.isNotEmpty(cond.getLpduser_q())){
			c.add(Expression.eq("lpduser", cond.getLpduser_q()));
		}
		
		//��Ʊ���ڿ�ʼ
		if(StringUtils.isNotEmpty(cond.getLpdinvoicedate_from())){
			c.add(Expression.ge("lpdinvoicedate", cond.getLpdinvoicedate_from()));
			c.add(Expression.ne("lpdinvoicedate", ""));
		}

		//��Ʊ���ڽ���
		if(StringUtils.isNotEmpty(cond.getLpdinvoicedate_to())){
			c.add(Expression.le("lpdinvoicedate", cond.getLpdinvoicedate_to()));
			c.add(Expression.ne("lpdinvoicedate", ""));
		}
		
		//��Ʊ���,����0,��ֲ�ѯ��
		if(StringUtils.isNotEmpty(cond.getLpdinvoiceamount_q())){
			c.add(Expression.gt("lpdinvoiceamount", new BigDecimal(0)));
			c.add(Expression.eq("lpdtype", IGLOMCONSTANTS.LPD_TYPE_PAY_INVOICE));
			c.add(Expression.eq("lpdstatus", IGLOMCONSTANTS.LPD_STATUS_YIHUANKUAN));
			c.add(Expression.sql("ldid in (select lpdid from LoanPayDetail where lpdstatus = '4')"));
		}
		
		//���ID
		if(cond.getLdid_invoice()!=null && cond.getLdid_invoice()!=0){
			c.add(Expression.eq("ldid", cond.getLdid_invoice()));
		}
		//����ѯ���ڿ�ʼʱ��
		if(StringUtils.isNotEmpty(cond.getTime_from())){

			c.add(Expression.ge("lpddate", cond.getTime_from()));
		}
		//����ѯ���ڽ���ʱ��
		if(StringUtils.isNotEmpty(cond.getTime_from())){

			c.add(Expression.le("lpddate", cond.getTime_to()));
		}
		//���״̬
		if(StringUtils.isNotEmpty(cond.getSpType())){

			c.add(Expression.eq("lpdstatus", cond.getSpType()));
		}
		return c;
	}
	
	/**
	 * ��ȡ�ѻ����ֽ������ѻ��Ʊ��
	 * 
	 * @param lpdid ����¼ID
	 * @return �ѻ����ֽ������ѻ��Ʊ��
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
