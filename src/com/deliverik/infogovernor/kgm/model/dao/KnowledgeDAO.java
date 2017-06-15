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
 * ����: ֪ʶ����ϢDAO�ӿ�
 * ����������֪ʶ����Ϣ��ϢDAO�ӿ�
 * ������¼��wangxiaoqiang 2010/12/07
 * �޸ļ�¼��
 */
public interface KnowledgeDAO extends BaseHibernateDAO<Knowledge> {
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
     * ���������������ȡ��
     * @param cond ��������
     * @return �����������
     */
    public int getSearchNotCheckCount(final KnowledgeSearchCond cond);
    
	/**
	 * ���ܣ���ȡָ��ID��ǰ���id��
	 * @param knid���̶���ID
	 * @return ���id��
	 */
	public Integer getMaxgKnid();
	
	/**
	 * ���ܣ���ȡָ��ID��ǰ���id��
	 * @param knid���̶���ID
	 * @return ���id��
	 */
	public Integer getMaxVersion(Integer knid);
	
    /**
     * ������������
     * @param cond ��������
     * @param start ������¼��ʼ�к�
     * @param count ������¼����
     * @return ��������б�
     */
    public List<Knowledge> findByCond(final KnowledgeSearchCond cond, final int start, final int count);
    
    /**
     * ������������֪ʶ����ʷ�汾��ѯ��
     * @param cond ��������
     * @param start ������¼��ʼ�к�
     * @param count ������¼����
     * @return ��������б�
     */
    public List<Knowledge> findByCond_History(final KnowledgeSearchCond cond, final int start, final int count);
    
    /**
     * ����֪ʶid������ǰ��Ч֪ʶ����
     * @param cond ��������
     * @return ��������б�
     */
    public Knowledge findByKnid(final KnowledgeSearchCond cond);
    
    /**
     * ֪ʶ���к�ȡ��ȡ��
     * @return ֪ʶ���к�ȡ��
     */
    public String getKnserial();
}

