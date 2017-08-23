package com.deliverik.infogovernor.crc.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond;
import com.deliverik.infogovernor.crc.model.IGCRC0301VWInfo;

/**
 * ����: �����ѯDAO�ӿ�
 * ��������: �����ѯDAO�ӿ�
 * ������¼: 2017/08/07
 * �޸ļ�¼: 
 */
public interface IGCRC0301DAO extends BaseHibernateDAO<IGCRC0301VWInfo> {

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<IGCRC0301VWInfo> queryIG500EntityListByProcessInfo(final IG500SearchCond cond, final int start, final int count);
	
	/**
	 * ���ܣ����������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int queryIG500EntityCount(final IG500SearchCond cond);
}
