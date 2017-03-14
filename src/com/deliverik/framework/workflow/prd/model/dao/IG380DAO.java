/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.user.model.condition.UserRoleSearchCond;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG913Info;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG913SearchCond;

/**
 * <p>����:�������Ͷ���DAO�ӿ�</p>
 * <p>����������1.��������ȫ������</p>
 * <p>          2.������ѯ�����</p>
 * <p>          3.������ѯ</p>
 * <p>          4.������ѯ���</p>
 * <p>          5.��������������Ա��ɫ����SearchCond ȫ��������</p>
 * <p>          6.��������������Ա��ɫ����SearchCond��</p>
 * <p>          7.����������ά�ƻ��ã�</p>
 * <p>������¼��</p>
 * <p>�޸ļ�¼����ʢ�	2010-12-13</p>
 */
public interface IG380DAO extends BaseHibernateDAO<IG380Info> {

	/**
	 * ���ܣ���������ȫ������
	 * @return �������Ͷ�������
	 */
	public List<IG380Info> findAll();
	
	/**
	 * ���ܣ�������ѯ�����
	 * @param cond
	 * @return ��ѯ�������
	 */
	public int getSearchCount(final IG380SearchCond cond);

	/**
	 * ��ѯ���°汾��¼����
	 * @param cond ��������
	 * @return �������
	 */
	public int getSearchLastCount(final IG380SearchCond cond);
	
	/**
	 * ��ѯ��ʷ�汾��¼����
	 * @param cond ��������
	 * @return �������
	 */
	public int getSearchHistoryCount(final IG380SearchCond cond);

	/**
	 * ���ܣ�������ѯ
	 * @param prid
	 * @return IG380Info
	 */
	public IG380Info findByPK(Serializable prid);

	public List<IG380Info> findByCond(final IG380SearchCond cond, final int start, final int count);
	
	
	public List<IG380Info> findLastByCond(final IG380SearchCond cond, final int start, final int count);
	
	
	public List<IG380Info> findHistoryByCond(final IG380SearchCond cond, final int start, final int count);
	
	/**
	 * ָ���û��ɷ����Զ������̲�ѯ����
	 * @param userid �û�ID
	 * @param pdstatus �Զ�������״̬
	 * @return ָ���û��ɷ����Զ��������б�
	 */
	public List<IG380Info> findSelfDefinitionByUserId(final String userid, final String pdstatus);
	
	/**
	 * ���ܣ���������������Ա��ɫ����SearchCond��
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG380Info> findSelfDefinitionByUserIdCom(final UserRoleSearchCond cond, final Integer ptid
			, final String pdstatus);
	
	/**
	 * PDID����ֵȡ��
	 * @param pdid_one ģ���ʶ
	 * 
	 * @return PDID����ֵ
	 */
	public String getPdidSequenceNextValue(String firstsite,String pdsequence);
	
	/**
	 * ���̶������洦��
	 * 
	 * @param pdid ���̶���ID
	 */
	public String upgradeProcessDefVersion(String pdid);

	/**
	 * ���̶��帴�ƴ���
	 * 
	 * @param pdid ���̶���ID
	 * @param pdsequence ���ж���
	 */
	public String copyProcessDefVersion(String pdid,String pdsequence);
	
	/**
	 * ���ܣ�����������ά�ƻ��ã�
	 * @return ��������б�
	 */
	public List<IG380Info> findSelfDefinitionAll();

	/**
     * ��ѯ��ط�����Զ�������������Ϣ
     * 
     * @param cond��������
     * @return ��������б�
     */
    public List<IG913Info> relevantProcessfindByCond(final IG913SearchCond cond);
    
    /**
     * ��ѯȱʡȨ�޵���ط�����Զ�������������Ϣ
     * 
     * @param cond��������
     * @return ��������б�
     */
    public List<IG913Info> relevantProcessfindByCondDefault(final IG913SearchCond cond);
}
