/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.crc.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.crc.model.IGCRC1301VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC1301Cond;

/**
 * ����: �ȶԽ��DAO�ӿ�
 * ��������: �ȶԽ��DAO�ӿ�
 * ������¼: 2014/07/15
 * �޸ļ�¼: 
 */
public interface IGCRC1301DAO extends BaseHibernateDAO<IGCRC1301VWInfo> {
	
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IGCRC1301Cond cond);
	
	/**
     * ���ݶ���ȶԽ��
     * 
     * @param cond ��������
     * @param version �汾
     * @return ��������б�
     */
    public List<IGCRC1301VWInfo> searchIGCRC1301VWInfo(final IGCRC1301Cond cond, final int start,
			final int count);
    
    
    
    public List<IGCRC1301VWInfo> searchIGCRC1302VWInfo(final IGCRC1301Cond cond, final int start,
			final int count);
}
