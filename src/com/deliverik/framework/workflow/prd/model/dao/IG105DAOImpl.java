/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prd.model.IG105Info;
import com.deliverik.framework.workflow.prd.model.condition.IG105SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG105TB;

/**
 * ����: ���̲����趨��ϢDAOʵ��
 * �������������̲����趨��ϢDAOʵ��
 * ������¼������    2010/11/26
 * �޸ļ�¼��
 */
@SuppressWarnings("deprecation")
public class IG105DAOImpl extends
		BaseHibernateDAOImpl<IG105Info> implements IG105DAO {

	/**
	 * ���캯��
	 */
	public IG105DAOImpl() {
		super(IG105TB.class);
	}

	/**
	 * ���ܣ�ȫ������
	 * 
	 * @return ���������
	 */
	public List<IG105Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		List<IG105Info> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ���ܣ�������������
	 * 
	 * @param pk����
	 * @return �������
	 */
	public IG105Info findByPK(Serializable pk) {

		IG105Info result = super.findByPK(pk);
		if (result == null)
			return null;

		return result;
	}

	/**
	 * ���ܣ����������������ȡ��
	 * 
	 * @param cond��������
	 * @return �����������
	 */
	public int getSearchCount(final IG105SearchCond cond) {
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * ���ܣ�������������
	 * 
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<IG105Info> findByCond(
			final IG105SearchCond cond, final int start,
			final int count) {
		DetachedCriteria c = getCriteria(cond);
		List<IG105Info> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ���ܣ�������������
	 * 
	 * @param cond��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG105SearchCond cond) {
		DetachedCriteria c = getDetachedCriteria();
		//����ID
		if(StringUtils.isNotEmpty(cond.getPdid())){
			c.add(Expression.eq("pdid", cond.getPdid()));
		}
		//�汾��
		if(cond.getPsdversion() != null && cond.getPsdversion() > 0){
			c.add(Expression.eq("psdversion", cond.getPsdversion()));
		}
		//����״̬
		if(StringUtils.isNotEmpty(cond.getPrstatus())){
			c.add(Expression.eq("prstatus", cond.getPrstatus()));
		}
		//���̽����̶�
		if(StringUtils.isNotEmpty(cond.getPrurgency())){
			c.add(Expression.eq("prurgency", cond.getPrurgency()));
		}
		return c;
	}
	
	/**
	 * ���ܣ���ȡָ�����̶���ID��ǰ�������汾��
	 * @param pdid���̶���ID
	 * @return ��ǰ�������汾��
	 */
	@SuppressWarnings("rawtypes")
	public Integer getMaxgPsdversion(String pdid){
		String sql =  "SELECT MAX(psd.psdversion) FROM IG105TB psd WHERE psd.pdid = :pdid";
		NamedParamMap p = getNamedParamMap();
		p.setString("pdid", pdid);
		List l = findByNamedParamMap(sql, p);
		if( l.size() == 0 ) return 0;
		if(l.get(0) == null)return 0;
		return (Integer) l.get(0);
	}

}
