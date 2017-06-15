/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.drm.model.SigninInfo;
import com.deliverik.infogovernor.drm.model.condition.SigninSearchCond;

/**
  * ����: ǩ����DAO�ӿ�
  * ��������: ǩ����DAO�ӿ�
  * ������¼: 2015/03/12
  * �޸ļ�¼: 
  */
public interface SigninDAO extends BaseHibernateDAO<SigninInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SigninInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SigninInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SigninSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SigninInfo> findByCond(
			final SigninSearchCond cond, final int start,
			final int count);
	/**
	 * ��ѯǩ����Ϣ
	 */
		public List<Map<String,Object>> searchSignInList(String userid,Integer prid,boolean isDrill) ;
		
		/**
		 * ����ǩ������Ӧ��ָ������prid
		 * @param drillPrid ��������id
		 * @param directPrid Ӧ��ָ������prid
		 * @return
		 */
		public int setDirectPrid(Integer drillPrid,Integer directPrid);
		/**
		 * ����ǩ�����г�������prid
		 * @param directPrid ָ������prid
		 * @param scenePrid ��������prid
		 * @return
		 */
		public int setScenePrid(Integer directPrid,Integer scenePrid);
		/**
		 * ��ԭ������Ա��Ϣ  ɾ��
		 * @param ecprid
		 */
		public void delWDP (Integer ecprid);
		/**
		 * ��ԭ������Ա��Ϣ  �޸�
		 * @param ecprid
		 */
		public void updWDP (Integer ecprid);
		/**
		 * dashboard ��Ա��Ϣ��ʼ����Ϣ
		 */
		public List<Map<String,Object>> searchSigninInitData(Integer ecprid);
		/**
		 * ����ǩ�����г�������prid
		 * 
		 * @param drillPrid
		 *            ��������id
		 * @param scenePrid
		 *            ��������prid
		 * @return
		 */
	public int setScenePridFormDrill(Integer drillPrid, Integer scenePrid);
		/**
		 * ��ѯ������
		 * @param ecprid
		 * @return
		 */
		public List<Map<String,Object>> searchSigninPeopleDataByCond(Integer ecprid);
}