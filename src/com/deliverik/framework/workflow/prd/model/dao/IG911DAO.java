/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG911Info;
import com.deliverik.framework.workflow.prd.model.condition.IG911SearchCond;

/**
  * ����: ״̬�����߹����������Ͷ����DAO�ӿ�
  * ��������: ״̬�����߹����������Ͷ����DAO�ӿ�
  * ������¼: 2012/10/18
  * �޸ļ�¼: 
  */
public interface IG911DAO extends BaseHibernateDAO<IG911Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG911Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG911Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG911SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG911Info> findByCond(
			final IG911SearchCond cond, final int start,
			final int count);

	/**
     * psprpid����ֵȡ��
     * 
     * @param ����״̬ID
     * @return psprpid����ֵ
     */
    public String getPsprpidSequenceNextValue(String psdid);
    
    /**
     * ��ط�������״̬Ϊ����״̬��״̬��������ط�����Ϣȡ��
     * 
     * @param cond��������
     * @return ��������б�
     */
    public List<IG911Info> getIg911RelevantPdidfindByCond(final IG911SearchCond cond);
    
    /**
     * ��ط�������״̬Ϊ����״̬��״̬��������ط�����Ϣ����ȡ��
     * @param cond ��������
     * @return �������
     */
    public int getIg911RelevantPdidCount(final IG911SearchCond cond);
    
    /**
     * ��ط���ɷ������̵����̶�����Ϣȡ�ã�����IG911����ȡ��IG380����Ϣ��
     * 
     * @param cond��������
     * @return ��������б�
     */
    public List<IG380Info> getIg380InfoByIg911Cond(final IG911SearchCond cond);
}