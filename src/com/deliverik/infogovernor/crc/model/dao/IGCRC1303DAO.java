package com.deliverik.infogovernor.crc.model.dao;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.crc.model.IGCRC1303VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC1303Cond;

/**
 * ����: �ȶԽ��DAO�ӿ�
 * ��������: �ȶԽ��DAO�ӿ�
 * ������¼:  ʷ���� 2014/07/22
 * �޸ļ�¼: 
 */
public interface IGCRC1303DAO extends BaseHibernateDAO<IGCRC1303VWInfo>{
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IGCRC1303Cond cond);
	
	/**
     * ���ݶ���ȶԽ��
     * 
     * @param cond ��������
     * @param version �汾
     * @return ��������б�
     */
    public List<IGCRC1303VWInfo> searchIGCRC1303VWInfo(final IGCRC1303Cond cond, final int start,
			final int count);
    
    
    /**
     * ����ÿ���ĵ����ĵ�����
     * 
     * @param cond ��������
     * @param version �汾
     * @return ��������б�
     */
    public List<String> searchType();
    
    /**
     * �������ر��е�ÿ����¼���ĵ�����
     * 
     * @param cond ��������
     * @param version �汾
     * @return ��������б�
     */
    public List<String> searchDownType();
}
