/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG222Info;
import com.deliverik.framework.workflow.prd.model.IG309Info;
import com.deliverik.framework.workflow.prd.model.condition.IG222SearchCond;

/**
 * 
 * ���̲����߶���DAO�ӿ�
 * @author maozhipeng@deliverik.com
 *
 */
public interface IG222DAO extends BaseHibernateDAO<IG222Info> {
	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<IG222Info> findAll();

	/**
	 * ������������
	 * @param psdid ����
	 * @return �������
	 */
	public IG222Info findByPK(Serializable ppdid);
	

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG222SearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG222Info> findByCond(final IG222SearchCond cond, final int start, final int count);
	
	/**
	 * ��ȡָ���û����еķ������̵Ľ�ɫ
	 * @param userid �û�ID
	 * @param pdid ���̶���ID
	 * @return �����ɫ�����б�
	 */
	
	public List<LabelValueBean> searchInitProcessParticipantRole(String userid, String pdid);
	
	/**
	 * ��ȡ�������̵Ľ�ɫ(��ά�ƻ�)
	 * @param pdid ���̶���ID
	 * @return �����ɫ�����б�
	 */
	public List<LabelValueBean> searchInitProcessParticipantRoleAll(String pdid);
	
	/**
	 * PPDID����ֵȡ��
	 * 
	 * @param ����״̬ID
	 * @return PPDID����ֵ
	 */
	public String getPpdidSequenceNextValue(String psdid);
	
	/**
	 * �����߿��Ӱ�ť��ѯ
	 * 
	 * @param psdid ״̬ID
	 * @param roleid ��ɫID
	 * @return ���Ӱ�ť�б�
	 */
	public List<IG309Info> searchVisibleButton(final String psdid, final Integer roleid);
	
	/**
	 * ������ȱʡ���Ӱ�ť��ѯ
	 * 
	 * @param psdid ״̬ID
	 * @return ȱʡ���Ӱ�ť�б�
	 */
	public List<IG309Info> searchDefaultVisibleButton(final String psdid);
	
	/**
	 * ͬ��ɫ�������ύԾǨ��ť��ѯ����ͨȨ�ޣ�
	 * 
	 * @param psdid ״̬ID
	 * @return ��ť�б�
	 */
	public Map<String, String> searchRoleCommitNormalAuth(final String psdid);
	
	/**
	 * ͬ��ɫ�������ύԾǨ��ť��ѯ��ȱʡȨ�ޣ�
	 * 
	 * @param psdid ״̬ID
	 * @return ��ť�б�
	 */
	public List<String> searchRoleCommitDefaultAuth(final String psdid);
	
	
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG222Info> findByCondRun(final IG222SearchCond cond);
	
}
