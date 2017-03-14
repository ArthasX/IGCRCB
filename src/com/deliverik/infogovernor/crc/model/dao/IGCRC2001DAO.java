package com.deliverik.infogovernor.crc.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.crc.model.IGCRC2001VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2001Cond;

/**
 * ����: ��ȹ���ͳ��DAO�ӿ�
 * ������¼:  lianghongyang 2014-8-7 09:34:11
 * �޸ļ�¼: 
 */
public interface IGCRC2001DAO extends BaseHibernateDAO<IGCRC2001VWInfo>{
	/**
	 * ��ѯ��ȹ���ͳ��
	 */
	public List<IGCRC2001VWInfo> getFindStatistics(IGCRC2001Cond cond);
	
}
