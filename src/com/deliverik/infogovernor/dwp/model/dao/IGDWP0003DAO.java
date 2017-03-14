/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dwp.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.dwp.model.IGDWP0003Info;
import com.deliverik.infogovernor.dwp.model.condition.IGDWP0003SearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �ճ������ƻ�����ϢDAO�ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IGDWP0003DAO extends BaseHibernateDAO<IGDWP0003Info>{

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IGDWP0003SearchCond cond);
	
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IGDWP0003Info> findByCond(IGDWP0003SearchCond cond,int start, int count);
}
