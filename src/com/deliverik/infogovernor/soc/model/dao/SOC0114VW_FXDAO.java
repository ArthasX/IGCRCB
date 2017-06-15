/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.model.SOC0114VWInfo;
import com.deliverik.infogovernor.soc.model.condition.SOC0114VW_FXSearchCond;

/**
 * ����: SOC0114VW_FXDAO�ӿ�
 * ��������: SOC0114VW_FXDAO�ӿ�
 * ������¼: 2013/10/26
 * �޸ļ�¼: 
 */
public interface SOC0114VW_FXDAO extends BaseHibernateDAO<SOC0114VWInfo> {
	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public List<SOC0114VWInfo> findByCond(final SOC0114VW_FXSearchCond cond);
	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public List<SOC0114VWInfo> findByCondForBJ(final SOC0114VW_FXSearchCond cond);
	
	/**
	 * ��������eiid��ȡ��������
	 * @param string
	 * @return
	 */
	public String getEitype(String eiid);
}