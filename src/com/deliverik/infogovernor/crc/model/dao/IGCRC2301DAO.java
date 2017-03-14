/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.crc.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.crc.model.IGCRC2301VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2301Cond;

/**
 * ����: �ȶԽ��DAO�ӿ�
 * ��������: �ȶԽ��DAO�ӿ�
 * ������¼:  yukexin 2014-8-12 11:08:46
 * �޸ļ�¼: 
 */
public interface IGCRC2301DAO extends BaseHibernateDAO<IGCRC2301VWInfo>{
    
    /**
     * ���ݶ���ȶԽ��
     * 
     * @param cond ��������
     * @return ��������б�
     */
    public List<IGCRC2301VWInfo> searchIGCRC2301VWInfo(final IGCRC2301Cond cond);
    
    
    /**
	 * ������������
	 * 		��ѯ�����ش���
	 * @param cond ��������
	 * @return ��������б�
	 */
    public List<Integer> searchList(final IGCRC2301Cond cond);
    
    /**
	 * ������������
	 *		��ѯ������������ 
	 * @param cond ��������
	 * @return ��������б�
	 */
    public List<Integer> searchListSum(final IGCRC2301Cond cond);
    
}
