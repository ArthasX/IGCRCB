/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.cim.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.cim.model.IG500VWInfo;
import com.deliverik.infogovernor.soc.cim.model.condition.IG500VWSearchCond;

/**
 * 
 * �ʲ��������dao�ӿ�
 * 
 */
public interface IG500VWDAO extends BaseHibernateDAO<IG500VWInfo> {
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����������
	 */
	public List<IG500VWInfo> findByCond(final IG500VWSearchCond cond);
}
