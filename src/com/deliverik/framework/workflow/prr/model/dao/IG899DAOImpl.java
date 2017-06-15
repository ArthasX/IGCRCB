/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.IG899Info;
import com.deliverik.framework.workflow.prr.model.condition.IG899SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG899TB;

/**
  * ����: ����˽�б�����DAOʵ��
  * ��������: ����˽�б�����DAOʵ��
  * ������¼: 2012/03/27
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class IG899DAOImpl extends
		BaseHibernateDAOImpl<IG899Info> implements IG899DAO {

	/**
	 * ���캯��
	 */
	public IG899DAOImpl(){
		super(IG899TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG899Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG899Info findByPK(Serializable pk) {
		IG899Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG899SearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG899Info> findByCond(final IG899SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG899SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//���̱�������ID
		if(StringUtils.isNotEmpty(cond.getPidid())){
			c.add(Expression.eq("pidid", cond.getPidid()));
		}
		//���̱���ֵID
		if(cond.getPiid() != null && cond.getPiid() > 0){
			c.add(Expression.eq("piid", cond.getPiid()));
		}
		//���̲����ߵĽ�ɫID
		if(cond.getRoleid() != null && cond.getRoleid() > 0){
			c.add(Expression.eq("roleid", cond.getRoleid()));
		}
		//���̲�����ID
		if(StringUtils.isNotEmpty(cond.getUserid())){
			c.add(Expression.eq("userid", cond.getUserid()));
		}
		//���̲����ߵĻ�����
		if(StringUtils.isNotEmpty(cond.getOrgid())){
			c.add(Expression.eq("orgid", cond.getOrgid()));
		}
		return c;
	}

}