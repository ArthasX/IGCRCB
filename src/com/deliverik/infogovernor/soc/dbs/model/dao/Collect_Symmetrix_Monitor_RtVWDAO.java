/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
 package com.deliverik.infogovernor.soc.dbs.model.dao;

 import java.util.Date;
import java.util.List;
 import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Symmetrix_Monitor_RtVWInfo;
import com.deliverik.infogovernor.soc.dbs.model.condition.Collect_Symmetrix_Monitor_RtVWSearchCond;
import com.deliverik.infogovernor.soc.dbs.model.dao.Collect_Symmetrix_Monitor_RtVWDAO;


/**
 * 
 * @Description:�洢ʵʱ��Ϣ��ͼDAO�ӿ�
 * @Author
 * @History
 * @Version V1.0
 */
public interface Collect_Symmetrix_Monitor_RtVWDAO extends BaseHibernateDAO<Collect_Symmetrix_Monitor_RtVWInfo> {
   
    /**
     * ������������
     * @param cond ��������
     * @return ��������б�
     */
    public List<Collect_Symmetrix_Monitor_RtVWInfo> findByCond(final Collect_Symmetrix_Monitor_RtVWSearchCond cond);
    
    /**
	 * ��ȡ���ʱ��
	 * @return
	 */
	public Date getMaxSaveTime(final Collect_Symmetrix_Monitor_RtVWSearchCond cond);
}

