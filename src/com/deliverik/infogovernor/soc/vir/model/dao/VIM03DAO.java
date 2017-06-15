/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.vir.model.VIM03Info;
import com.deliverik.infogovernor.soc.vir.model.condition.Vim03SearchCond;

/**
  * ����: ��Դ���������Ϣ��DAO�ӿ�
  * ��������: ��Դ���������Ϣ��DAO�ӿ�
  * ������¼: 2014/02/13
  * �޸ļ�¼: 
  */
public interface VIM03DAO extends BaseHibernateDAO<VIM03Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<VIM03Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public VIM03Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final Vim03SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<VIM03Info> findByCond(
			final Vim03SearchCond cond, final int start,
			final int count);
	
	public  List<Object[]>  getOrgCountByMonth(String sDate);
	
	/**
     * ��ѯһ�������ڵ���Դ��������
     * 
     * @param sDate
     * @return
     */
    public List<Object[]> getOrgCount(String sDate);
    
    /**
     * ��������ȡ��
     *
     * @param cond ��������
     * @return ��������
     */
    public Integer  getVMCount4HostCountByCond(final Vim03SearchCond cond);

    /**
     * ��ȡ����������ĸ���
     *
     * @param cond ��������
     * @return ��������б�
     */
    public List<Object[]> getVMCount4HostByCond(final Vim03SearchCond cond, final int start, final int count);
}