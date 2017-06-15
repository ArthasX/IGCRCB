/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.csebank.lom.model.dao;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.RecptionGuestInfo;
import com.csebank.lom.model.condition.RecptionGuestInfoCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;


/**
 * �Ӵ����˲�ѯDAO�ӿ�
 * @author lipeng@deliverik.com
 */
public interface RecptionGuestInfoDAO extends BaseHibernateDAO<RecptionGuestInfo> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<RecptionGuestInfo> findAll();

	/**
	 * ������������
	 * @param RID ����
	 * @return �������
	 */
	public RecptionGuestInfo findByPK(Serializable iid);
	

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RecptionGuestInfoCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RecptionGuestInfo> findByCond(final RecptionGuestInfoCond cond, final int start, final int count);
	
	/**
	 * ��ȡ��ǰ���汾����ʶ
	 * @return ���汾����ʶ
	 */
	
	public String getMaxRacode();
	

}
