package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCond;



/**
 * �ʲ���ϢDAO�ӿ�
 * 
 */
public interface SOC0117DAO extends BaseHibernateDAO<SOC0117Info> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<SOC0117Info> findAll();

	/**
	 * ������������
	 * @param eid ����
	 * @return �������
	 */
	public SOC0117Info findByPK(Serializable eid);
	

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0117SearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0117Info> findByCond(final SOC0117SearchCond cond, final int start, final int count);
	
	public List<SOC0117Info> findByCond(final SOC0117SearchCond cond,final String id);
	public List<SOC0117Info> findByCondCoding(final SOC0117SearchCond cond);
	
	/**
	 * ��ȡ���EID��
	 * @param cond
	 * @return
	 */
	public List<SOC0117Info> findMaxEidByCond(final SOC0117SearchCond cond);
	/**
	 * ��ѯģ�����ʲ�����
	 * @param esyscoding
	 * @return
	 */
	public List<Map<String, Object>> getEntityNum(String rootEsyscoding);
	
	/**
	 * ��ȡ���EID��,����������
	 * @param cond
	 * @return
	 */
	public Integer findMaxEidByCondNotLikeCM();

	/**
	 * ��ȡ�ɵ���һ���ʲ��б�
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0117Info> searchEntityForExport(SOC0117SearchCond cond);
	/**
	 * ��ѯģ�����ʲ��������°�Ӧ����Դר�ã�
	 * @param esyscoding
	 * @return
	 */
	public List<Map<String, Object>> getEntityNumNEW(String rootErcode);
}
