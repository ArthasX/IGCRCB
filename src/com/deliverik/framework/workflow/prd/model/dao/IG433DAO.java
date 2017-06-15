/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
 package com.deliverik.framework.workflow.prd.model.dao;


 import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG433Info;
import com.deliverik.framework.workflow.prd.model.condition.IG433SearchCond;


 /**
  * ����:��������dao�ӿ�
  * ���������������������ʵ����в���
  *           
  * ������¼���κ���    2010/11/26
  */
public interface IG433DAO extends BaseHibernateDAO<IG433Info> {
    /**
     * ȫ������
     * @return ���������
     */
    public List<IG433Info> findAll();
    /**
     * ������������
     * @param id ����
     * @return �������
     */
    public IG433Info findByPK(Serializable id);
    /**
     * ���������������ȡ��
     * @param cond ��������
     * @return �����������
     */
    public int getSearchCount(final IG433SearchCond cond);
    /**
     * ������������(��ͼ)
     * @param cond ��������
     * @param start ������¼��ʼ�к�
     * @param count ������¼����
     * @return ��������б�
     */
    public List<IG433Info> findByCond(final IG433SearchCond cond, final int start, final int count);
    
    /**
     * ������������(ʵ��)
     * @param cond ��������
     * @param start ������¼��ʼ�к�
     * @param count ������¼����
     * @return ��������б�
     */
    public List<IG433Info> findByCond_Entity(final IG433SearchCond cond, final int start, final int count);
}

