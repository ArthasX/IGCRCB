package com.deliverik.infogovernor.crc.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2401Cond;
import com.deliverik.infogovernor.crc.model.entity.IGCRC2401VW;
/**
 * ����: �¼�ƽ�����ʱ��DAO�ӿ�
 * �޸ļ�¼: 
 */
public interface IGCRC2401DAO extends BaseHibernateDAO<IGCRC2401VW>{
	/**
	 * �¼�ƽ�����ʱ��
	 */
	public List<IGCRC2401VW> getFindStatistics(IGCRC2401Cond cond);
	
	
	/**
	 *  ʱ��ƽ�����ʱ�� 
	 *  ȷ��ʱ��---��ʼʱ��
	 * @param cond
	 * @return
	 */
	public List<IGCRC2401VW> getFindStatisticsConfirm(IGCRC2401Cond cond);
}
