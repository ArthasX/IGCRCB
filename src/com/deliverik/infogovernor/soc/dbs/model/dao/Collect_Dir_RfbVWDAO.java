/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
 package com.deliverik.infogovernor.soc.dbs.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Dir_RfbVWInfo;
import com.deliverik.infogovernor.soc.dbs.model.condition.Collect_BusySearchCond;



/**
 * 
 * @Description:�洢������ϢDAO�ӿ�
 * @Author
 * @History
 * @Version V1.0
 */
public interface Collect_Dir_RfbVWDAO extends BaseHibernateDAO<Collect_Dir_RfbVWInfo>{

	 /**
     * ȫ������
     * @return ���������
     */
    public List<Collect_Dir_RfbVWInfo> findAll();
    /**
     * ������������
     * @param id ����
     * @return �������
     */
    public Collect_Dir_RfbVWInfo findByPK(Serializable id);

	 /**
     * ������������
     * @param cond ��������
     * @param start ������¼��ʼ�к�
     * @param count ������¼����
     * @return ��������б�
     */
    public List<Collect_Dir_RfbVWInfo> findByCond(final Collect_BusySearchCond cond, final int start, final int count);
    
      
}

