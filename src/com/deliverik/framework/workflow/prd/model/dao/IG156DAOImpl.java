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
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.model.IG156Info;
import com.deliverik.framework.workflow.prd.model.condition.IG156SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG156TB;

/**
  * ����: ����״̬��ť�����DAOʵ��
  * ��������: ����״̬��ť�����DAOʵ��
  * ������¼: 2012/04/13
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class IG156DAOImpl extends
		BaseHibernateDAOImpl<IG156Info> implements IG156DAO {

	/**
	 * ���캯��
	 */
	public IG156DAOImpl(){
		super(IG156TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG156Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG156Info findByPK(Serializable pk) {
		IG156Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG156SearchCond cond){
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
	public List<IG156Info> findByCond(final IG156SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG156SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getPsdid())){
			c.add(Expression.eq("psdid", cond.getPsdid()));
		}
		if(StringUtils.isNotEmpty(cond.getPseid_like())){
			c.add(Expression.like("pseid", cond.getPseid_like() + "%"));
		}
		if(StringUtils.isNotEmpty(cond.getPsebuttonid())){
			c.add(Expression.eq("psebuttonid", cond.getPsebuttonid()));
		}
		return c;
	}
	
	/**
	 * PEEID����ֵȡ��
	 * 
	 * @param ����״̬ID
	 * @return PEEID����ֵ
	 */
	@SuppressWarnings("rawtypes")
	public String getPedidSequenceNextValue(String psdid) {
		String sql =  "SELECT MAX(p.pseid) FROM IG156TB p WHERE p.pseid LIKE :psdid";
		NamedParamMap p = getNamedParamMap();
		p.setString("psdid", psdid + "%");
		List l = findByNamedParamMap(sql, p);
		if( l.size() == 0 || StringUtils.isEmpty((String)l.get(0))) {
			return psdid + StringUtils.leftPad("1", IGPRDCONSTANTS.ID_SUFFIX_LENGTH, "0");
		} else {
			String id = (String)l.get(0);
			return psdid + StringUtils.leftPad((Integer.parseInt(id.replaceFirst(psdid, "")) + 1) + "", IGPRDCONSTANTS.ID_SUFFIX_LENGTH, "0"); 
		}
	}
}