/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.crc.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.crc.model.IGCRC2101VWInfo;
import com.deliverik.infogovernor.crc.model.IGCRC2102VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2101Cond;

/**
 * ����: �ȶԽ��DAO�ӿ�
 * ��������: �ȶԽ��DAO�ӿ�
 * ������¼:  yukexin 2014-8-7 09:34:11
 * �޸ļ�¼: 
 */
public interface IGCRC2101DAO extends BaseHibernateDAO<IGCRC2101VWInfo>{
	
	/**
     * ���ݶ���ȶԽ��
     * 
     * @param cond ��������
     * @param start ��ʼid
     * @param count ÿҳ������
     * @return ��������б�
     */
    public List<IGCRC2101VWInfo> searchIGCRC2101VWInfo(final IGCRC2101Cond cond, final int start,
			final int count);
    
    /**
     * ���ݶ���ȶԽ��
     * 
     * @param cond ��������
     * @return ��������б�
     */
    public List<IGCRC2101VWInfo> searchIGCRC2101VWInfo(final IGCRC2101Cond cond);
    
    /**	
     * ���ܣ���ѯ���������б�
     * @return ���������б�
     * �޸ļ�¼��null 	
     */	
    public List<IGCRC2102VWInfo> searchDepartmentBeanList();
}
