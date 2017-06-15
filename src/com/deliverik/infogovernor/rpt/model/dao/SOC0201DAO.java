/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
 package com.deliverik.infogovernor.rpt.model.dao;

 import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.rpt.model.SOC0201Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0201SearchCond;


/**
 * 
 * @Description:�Զ��������ɱ�DAO�ӿ�
 * @Author
 * @History
 * @Version V1.0
 * �޸ļ�¼��2012/08/09 ��REPORT_GDATA_ITEMDAO������ΪSOC0201DAO
 */
public interface SOC0201DAO extends BaseHibernateDAO<SOC0201Info> {
    /**
     * ȫ������
     * @return ���������
     */
    public List<SOC0201Info> findAll();
    /**
     * ������������
     * @param id ����
     * @return �������
     */
    public SOC0201Info findByPK(Serializable id);
    /**
     * ���������������ȡ��
     * @param cond ��������
     * @return �����������
     */
    public int getSearchCount(final SOC0201SearchCond cond);
    /**
     * ������������
     * @param cond ��������
     * @param start ������¼��ʼ�к�
     * @param count ������¼����
     * @return ��������б�
     */
    public List<SOC0201Info> findByCond(final SOC0201SearchCond cond, final int start, final int count);
}

