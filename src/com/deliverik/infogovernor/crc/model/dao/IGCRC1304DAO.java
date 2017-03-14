package com.deliverik.infogovernor.crc.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.crc.model.IGCRC1303VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC1304Cond;
/**
 * ����: �ȶԽ��DAO�ӿ�
 * ��������: �ȶԽ��DAO�ӿ�
 * ������¼: ʷ���� 2014/07/22
 * �޸ļ�¼: 
 */
public interface IGCRC1304DAO extends BaseHibernateDAO<IGCRC1303VWInfo>{
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IGCRC1304Cond cond);
	
	/**
     * ���ݶ���ȶԽ��
     * 
     * @param cond ��������
     * @param version �汾
     * @return ��������б�
     */
    public List<IGCRC1303VWInfo> searchIGCRC1304VWInfo(final IGCRC1304Cond cond, final int start,
			final int count);
    /**
     * ��ѯ�����ĵ�
     * @return
     */
    public List<String> searchType();
    
    /**
	 * ��ѯ�����ص��ĵ��Ĳ���
	 * @return
	 */
    public List<String> searchDownDepart();
    
    /**
     * ��ѯ�����ĵ�������ID
     * @return
     */
    public List<Integer> searchTypeID(IGCRC1304Cond cond);
}
