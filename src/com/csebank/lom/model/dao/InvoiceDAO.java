/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.csebank.lom.model.dao;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.Invoice;
import com.csebank.lom.model.condition.InvoiceInfoSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * ��ƱDAO�ӿ�
 * @author lipeng@deliverik.com
 */
public interface InvoiceDAO extends BaseHibernateDAO<Invoice> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<Invoice> findAll();

	/**
	 * ������������
	 * @param raid ����
	 * @return �������
	 */
	public Invoice findByPK(Serializable iid);
	

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final InvoiceInfoSearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Invoice> findByCond(final InvoiceInfoSearchCond cond, final int start, final int count);
	
	/**
	 * ��ȡ��ǰ���汾����ʶ
	 * @return ���汾����ʶ
	 */
	
	public String getMaxRacode();
	

}
