/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.sym.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.sym.model.Priority;
import com.deliverik.infogovernor.sym.model.condition.PrioritySearchCond;

/**
 * ����:���ȼ�DAO�ӿ�
 * ����������1. ȫ������
 * 			2.���������������ȡ��
 * 			3.������������
 * ������¼��fangyunlong@deliverik.com    2010/12/14
 */
public interface PriorityDAO extends BaseHibernateDAO<Priority> {
    /**
     * ȫ������
     * @return ���������
     */
    public List<Priority> findAll();

    /**
     * ���������������ȡ��
     * @param cond ��������
     * @return �����������
     */
    public int getSearchCount(final PrioritySearchCond cond);
    /**
     * ������������
     * @param cond ��������
     * @param start ������¼��ʼ�к�
     * @param count ������¼����
     * @return ��������б�
     */
    public List<Priority> findByCond(final PrioritySearchCond cond, final int start, final int count);
}

