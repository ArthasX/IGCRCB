/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
 package com.deliverik.infogovernor.soc.dbs.model.dao;

 import java.io.Serializable;
import java.util.List;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Symmetrix_Info;
import com.deliverik.infogovernor.soc.dbs.model.condition.Collect_Symmetrix_InfoSearchCond;
import com.deliverik.infogovernor.soc.dbs.model.dao.Collect_Symmetrix_InfoDAO;


/**
 * 
 * @Description:�洢������ϢDAO�ӿ�
 * @Author
 * @History
 * @Version V1.0
 */
public interface Collect_Symmetrix_InfoDAO extends BaseHibernateDAO<Collect_Symmetrix_Info> {
    /**
     * ȫ������
     * @return ���������
     */
    public List<Collect_Symmetrix_Info> findAll();
    /**
     * ������������
     * @param id ����
     * @return �������
     */
    public Collect_Symmetrix_Info findByPK(Serializable id);
    /**
     * ���������������ȡ��
     * @param cond ��������
     * @return �����������
     */
    public int getSearchCount(final Collect_Symmetrix_InfoSearchCond cond);
    /**
     * ������������
     * @param cond ��������
     * @param start ������¼��ʼ�к�
     * @param count ������¼����
     * @return ��������б�
     */
    public List<Collect_Symmetrix_Info> findByCond(final Collect_Symmetrix_InfoSearchCond cond, final int start, final int count);
}

