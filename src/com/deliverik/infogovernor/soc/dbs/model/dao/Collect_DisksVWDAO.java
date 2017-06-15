/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
 package com.deliverik.infogovernor.soc.dbs.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.dbs.model.Collect_DisksVWInfo;
import com.deliverik.infogovernor.soc.dbs.model.condition.Collect_BusySearchCond;



/**
 * 
 * @Description:�洢������ϢDAO�ӿ�
 * @Author
 * @History
 * @Version V1.0
 */
public interface Collect_DisksVWDAO extends BaseHibernateDAO<Collect_DisksVWInfo>{

	 /**
     * ȫ������
     * @return ���������
     */
    public List<Collect_DisksVWInfo> findAll();
    /**
     * ������������
     * @param id ����
     * @return �������
     */
    public Collect_DisksVWInfo findByPK(Serializable id);

	 /**
     * ������������
     * @param cond ��������
     * @param start ������¼��ʼ�к�
     * @param count ������¼����
     * @return ��������б�
     */
    public List<Collect_DisksVWInfo> findByCond(final Collect_BusySearchCond cond, final int start, final int count);
       
    /**
     * ��ȡȫ����������
     * @param cond ��������
     * @param start ������¼��ʼ�к�
     * @param count ������¼����
     * @return ��������б�
     */
    public List<Collect_DisksVWInfo> findDisksDeviceName(final Collect_BusySearchCond cond, final int start, final int count);
    

	public List<Collect_DisksVWInfo> CX_findDisksDeviceName(
			final Collect_BusySearchCond cond, final int start,final int count);
	public List<Collect_DisksVWInfo> findDisksByCond_CX(
			final	Collect_BusySearchCond cond, final int start,final int count);
}

