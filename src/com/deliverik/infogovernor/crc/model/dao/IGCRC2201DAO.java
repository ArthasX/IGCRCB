/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.crc.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.crc.model.IGCRC2201VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2201Cond;

/**	
 * ����:�������ͳ��Dao�ӿ�
 * ������¼��yukexin    2014-8-15 ����5:17:57	
 * �޸ļ�¼��null
 */	
public interface IGCRC2201DAO extends BaseHibernateDAO<IGCRC2201VWInfo> {

	/**
	 * �������ͳ�Ƽ���
	 * 
	 * @param cond
	 * @return List<ChangeTreadVWInfo>
	 */
	public List<IGCRC2201VWInfo> searchChangeTreadVW(final IGCRC2201Cond cond);
}
