/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.sym.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.sym.model.CustomReport;
import com.deliverik.infogovernor.sym.model.condition.CustomReportSearchCond;

/**
 * 
 * @Description:���Ʊ���DAO�ӿ�
 * @Author
 * @History
 * @Version V1.0
 */
public interface CustomReportDAO extends BaseHibernateDAO<CustomReport> {
    /**
     * ȫ������
     * @return ���������
     */
    public List<CustomReport> findAll();
    /**
     * ������������
     * @param id ����
     * @return �������
     */
    public CustomReport findByPK(Serializable id);
    /**
     * ���������������ȡ��
     * @param cond ��������
     * @return �����������
     */
    public int getSearchCount(final CustomReportSearchCond cond);
    /**
     * ������������
     * @param cond ��������
     * @param start ������¼��ʼ�к�
     * @param count ������¼����
     * @return ��������б�
     */
    public List<CustomReport> findByCond(final CustomReportSearchCond cond, final int start, final int count);
}

