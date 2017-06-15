package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0117VWInfo;
import com.deliverik.framework.soc.asset.model.condition.SOC0117VWSearchCond;



/**
 * �ʲ���ϢDAO�ӿ�
 * 
 */
public interface SOC0117VWDAO extends BaseHibernateDAO<SOC0117VWInfo> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<SOC0117VWInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0117VWInfo findByPK(Serializable pk);
	

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0117VWSearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0117VWInfo> findByCond(final SOC0117VWSearchCond cond, final int start, final int count);
	
	public List<SOC0117VWInfo> findByCond(final SOC0117VWSearchCond cond,final String id);
	public List<SOC0117VWInfo> findByCondCoding(final SOC0117VWSearchCond cond);
	
	/**
	 * ��ȡ���EID��
	 * @param cond
	 * @return
	 */
	public List<SOC0117VWInfo> findMaxEidByCond(final SOC0117VWSearchCond cond);
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
	public List<SOC0117VWInfo> searchEntityForExport(SOC0117VWSearchCond cond);
	/**
	 * ��ѯģ�����ʲ��������°�Ӧ����Դר�ã�
	 * @param esyscoding
	 * @return
	 */
	public List<Map<String, Object>> getEntityNumNEW(String rootErcode);
}
