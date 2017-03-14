/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG931Info;
import com.deliverik.framework.workflow.prd.model.condition.IG931SearchCond;

/**
  * ����: ȱʡ״̬�����߹����������Ͷ����DAO�ӿ�
  * ��������: ȱʡ״̬�����߹����������Ͷ����DAO�ӿ�
  * ������¼: 2012/10/18
  * �޸ļ�¼: 
  */
public interface IG931DAO extends BaseHibernateDAO<IG931Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG931Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG931Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG931SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG931Info> findByCond(
			final IG931SearchCond cond, final int start,
			final int count);
	
	/**
     * psprpid����ֵȡ��
     * 
     * @param ����״̬ID
     * @return psprpid����ֵ
     */
    public String getDpsprpidSequenceNextValue(String psdid);
    
    /**
     * ��ط�������״̬Ϊ����״̬��Ĭ��Ȩ�޵���ط�����Ϣȡ��
     * 
     * @param cond��������
     * @return ��������б�
     */
    public List<IG931Info> getIg931RelevantPdidfindByCond(final IG931SearchCond cond);
    
    /**
     * ��ط�������״̬Ϊ����״̬��Ĭ��Ȩ�޵���ط�����Ϣ����ȡ��
     * @param cond ��������
     * @return �������
     */
    public int getIg931RelevantPdidCount(final IG931SearchCond cond);
    
    /**
     * ��ط���ɷ������̵����̶�����Ϣȡ�ã�����IG931����ȡ��IG380����Ϣ��
     * 
     * @param cond��������
     * @return ��������б�
     */
    public List<IG380Info> getIg380InfoByIg931Cond(final IG931SearchCond cond);
}