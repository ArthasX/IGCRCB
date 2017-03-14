/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
 package com.deliverik.infogovernor.soc.mnt.model.dao;

 import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.mnt.model.SOC0306Info;
import com.deliverik.infogovernor.soc.mnt.model.condition.SOC0306SearchCond;


/**
 * 
 * @Description:���������Ϣ��ͼDAO�ӿ�
 * @Author
 * @History
 * @Version V1.0
 */
public interface SOC0306DAO extends BaseHibernateDAO<SOC0306Info> {
    /**
     * ȫ������
     * @return ���������
     */
    public List<SOC0306Info> findAll();
    /**
     * ������������
     * @param id ����
     * @return �������
     */
    public SOC0306Info findByPK(Serializable id);
    /**
     * ���������������ȡ��
     * @param cond ��������
     * @return �����������
     */
    public int getSearchCount(final SOC0306SearchCond cond);
    /**
     * ������������
     * @param cond ��������
     * @param start ������¼��ʼ�к�
     * @param count ������¼����
     * @return ��������б�
     */
    public List<SOC0306Info> findByCond(final SOC0306SearchCond cond, final int start, final int count);
    
    /**
     * ��ѯȱʧ�����ܵ�������
     * @param yestoday ���������
     * @return ��������б�
     */
    @SuppressWarnings("unchecked")
    public List searchSymmetrixAlarm(final String yestoday);
}

