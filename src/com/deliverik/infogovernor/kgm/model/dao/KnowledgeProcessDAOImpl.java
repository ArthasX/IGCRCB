/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.kgm.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.kgm.model.KnowledgeProcess;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeProcessSearchCond;
import com.deliverik.infogovernor.kgm.model.entity.KnowledgeProcessTB;

/**
 * ����: ֪ʶ���̹�����ϢDAOʵ��
 * ����������֪ʶ���̹�����ϢDAOʵ��
 * ������¼������ 2010/12/07
 * �޸ļ�¼��
 */
@SuppressWarnings("deprecation")
public class KnowledgeProcessDAOImpl extends
		BaseHibernateDAOImpl<KnowledgeProcess> implements KnowledgeProcessDAO {
	
	/**
	 * ���캯��
	 */
	public KnowledgeProcessDAOImpl() {
		super(KnowledgeProcessTB.class);
	}

	/**
	 * ȫ������
	 * 
	 * @return ���������
	 */
	public List<KnowledgeProcess> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		List<KnowledgeProcess> ret = findByCriteria(c);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param kpid����
	 * @return �������
	 */
	public KnowledgeProcess findByPK(Serializable kpid) {
		KnowledgeProcess result = super.findByPK(kpid);
		if (result == null)
			return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond
	 *            ��������
	 * @return �����������
	 */
	public int getSearchCount(final KnowledgeProcessSearchCond cond) {
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * ������������
	 * 
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<KnowledgeProcess> findByCond(
			final KnowledgeProcessSearchCond cond, final int start,
			final int count) {
		DetachedCriteria c = getCriteria(cond);
		List<KnowledgeProcess> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<KnowledgeProcess> findByCond_KnowledgeProcess(
			final KnowledgeProcessSearchCond cond, final int start,
			final int count) {
		DetachedCriteria c = getCriteria_KnowledgeProcess(cond);
		c.addOrder(Order.asc("connecttype"));
		List<KnowledgeProcess> ret = findByCriteria(c, start, count);
		
		return ret;
	}
	
	/**
	 * ������������
	 * 
	 * @param cond��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(KnowledgeProcessSearchCond cond) {
		DetachedCriteria c = getDetachedCriteria();
		//֪ʶID
		if(cond.getKnid() != null && cond.getKnid() > 0){
			c.add(Expression.eq("knid", cond.getKnid()));
		}
		//֪ʶ�汾
		if(cond.getKnversion() != null && cond.getKnversion() > 0){
			c.add(Expression.eq("knversion", cond.getKnversion()));
		}
		//����ID
		if(cond.getPrid() != null && cond.getPrid() > 0){
			c.add(Expression.eq("prid", cond.getPrid()));
		}
		//���񹤵�ID
		if(cond.getSfid() != null && cond.getSfid() > 0){
			c.add(Expression.eq("sfid", cond.getSfid()));
		}
		//��������
		if(StringUtils.isNotEmpty(cond.getConnecttype())){
			c.add(Expression.eq("connecttype", cond.getConnecttype()));
		}
		return c;
	}
	
	/**
	 * ������������(�������̺ͷ��񹤵�)
	 * 
	 * @param cond��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria_KnowledgeProcess(KnowledgeProcessSearchCond cond) {
		DetachedCriteria c = getDetachedCriteria();
		//֪ʶID
		if(cond.getKnid() != null && cond.getKnid() > 0){
			c.add(Expression.eq("knid", cond.getKnid()));
		}
		//��������
		if(StringUtils.isNotEmpty(cond.getConnecttype())){
			c.add(Expression.not(Expression.eq("connecttype", cond.getConnecttype())));
		}
		if(cond.getKpEffect() != null ){
			c.add(Expression.eq("kpEffect", cond.getKpEffect()));
		}
		return c;
	}
}
