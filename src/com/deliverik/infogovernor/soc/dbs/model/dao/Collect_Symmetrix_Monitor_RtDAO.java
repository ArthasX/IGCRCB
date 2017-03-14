/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
 package com.deliverik.infogovernor.soc.dbs.model.dao;

 import java.util.Date;
import java.util.List;
 import java.io.Serializable;
 import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Symmetrix_Monitor_Rt;
import com.deliverik.infogovernor.soc.dbs.model.condition.Collect_Symmetrix_Monitor_RtSearchCond;
import com.deliverik.infogovernor.soc.dbs.model.dao.Collect_Symmetrix_Monitor_RtDAO;


/**
 * 
 * @Description:�洢ʵʱ��ϢDAO�ӿ�
 * @Author
 * @History
 * @Version V1.0
 */
public interface Collect_Symmetrix_Monitor_RtDAO extends BaseHibernateDAO<Collect_Symmetrix_Monitor_Rt> {
    /**
     * ȫ������
     * @return ���������
     */
    public List<Collect_Symmetrix_Monitor_Rt> findAll();
    /**
     * ������������
     * @param id ����
     * @return �������
     */
    public Collect_Symmetrix_Monitor_Rt findByPK(Serializable id);
    /**
     * ���������������ȡ��
     * @param cond ��������
     * @return �����������
     */
    public int getSearchCount(final Collect_Symmetrix_Monitor_RtSearchCond cond);
    /**
     * ������������
     * @param cond ��������
     * @param start ������¼��ʼ�к�
     * @param count ������¼����
     * @return ��������б�
     */
    public List<Collect_Symmetrix_Monitor_Rt> findByCond(final Collect_Symmetrix_Monitor_RtSearchCond cond, final int start, final int count);
    
    /**
	 * ��ȡ���ʱ��
	 * @return
	 */
	public Date getMaxSaveTime(final Collect_Symmetrix_Monitor_RtSearchCond cond);
}

