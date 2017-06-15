/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
 package com.deliverik.infogovernor.rpt.model.dao;

 import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.rpt.model.SOC0203Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0203SearchCond;


/**
 * 
 * @Description:�Զ����������б�DAO�ӿ�
 * @Author
 * @History
 * @Version V1.0
 * �޸ļ�¼��2012/08/09 ��ReportConfigurationDAO������ΪSOC0203DAO
 */
public interface SOC0203DAO extends BaseHibernateDAO<SOC0203Info> {
    /**
     * ȫ������
     * @return ���������
     */
    public List<SOC0203Info> findAll();
    /**
     * ������������
     * @param id ����
     * @return �������
     */
    public SOC0203Info findByPK(Serializable id);
    /**
     * ���������������ȡ��
     * @param cond ��������
     * @return �����������
     */
    public int getSearchCount(final SOC0203SearchCond cond);
    /**
     * ������������
     * @param cond ��������
     * @param start ������¼��ʼ�к�
     * @param count ������¼����
     * @return ��������б�
     */
    public List<SOC0203Info> findByCond(final SOC0203SearchCond cond, final int start, final int count);
}

