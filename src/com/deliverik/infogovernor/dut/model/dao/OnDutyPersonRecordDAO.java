/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.dut.model.OnDutyPersonRecordInfo;
import com.deliverik.infogovernor.dut.model.condition.OnDutyPersonRecordSearchCond;

/**
 * ����: �ճ�ά��DAO�ӿ�
 * ��������: �ճ�ά��DAO�ӿ�
 * ������¼: 2012/04/01
 * �޸ļ�¼: 
 */
public interface OnDutyPersonRecordDAO extends BaseHibernateDAO<OnDutyPersonRecordInfo> {
    
    /**
     * ȫ������
     * @return ���������
     */
    public List<OnDutyPersonRecordInfo> findAll();

    /**
     * ������������
     * @param ODPRID ����
     * @return �������
     */
    public OnDutyPersonRecordInfo findByPK(Serializable ODPRID);
    

    /**
     * ���������������ȡ��
     * @param cond ��������
     * @return �����������
     */
    public int getSearchCount(final OnDutyPersonRecordSearchCond cond);

    /**
     * ������������
     * @param cond ��������
     * @param start ������¼��ʼ�к�
     * @param count ������¼����
     * @return ��������б�
     */
    public List<OnDutyPersonRecordInfo> findByCond(final OnDutyPersonRecordSearchCond cond, final int start, final int count);
}
