/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
 package com.deliverik.infogovernor.kgm.model.dao;

 import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.kgm.model.Knowledge;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeSearchCond;

/**
 * ����: ����֪ʶDAO�ӿ�
 * ��������������֪ʶ��ϢDAO�ӿ�
 * ������¼��wangxiaoqiang 2010/12/07
 * �޸ļ�¼��
 */
public interface KnowledgeVWDAO extends BaseHibernateDAO<Knowledge> {
    /**
     * ȫ������
     * @return ���������
     */
    public List<Knowledge> findAll();
    /**
     * ������������
     * @param id ����
     * @return �������
     */
    public Knowledge findByPK(Serializable id);
    /**
     * ���������������ȡ��
     * @param cond ��������
     * @return �����������
     */
    public int getSearchCount(final KnowledgeSearchCond cond);
    /**
     * ������������
     * @param cond ��������
     * @param start ������¼��ʼ�к�
     * @param count ������¼����
     * @return ��������б�
     */
    public List<Knowledge> findByCond(final KnowledgeSearchCond cond, final int start, final int count);
}

