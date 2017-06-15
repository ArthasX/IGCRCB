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
import com.deliverik.framework.workflow.prd.model.IG243Info;
import com.deliverik.framework.workflow.prd.model.condition.IG243SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG243TB;

/**
  * ����: ���̱��ⶨ���DAOʵ��
  * ��������: ���̱��ⶨ���DAOʵ��
  * ������¼: 2012/03/30
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class IG243DAOImpl extends
		BaseHibernateDAOImpl<IG243Info> implements IG243DAO {

	/**
	 * ���캯��
	 */
	public IG243DAOImpl(){
		super(IG243TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG243Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG243Info findByPK(Serializable pk) {
		IG243Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG243SearchCond cond){
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
	public List<IG243Info> findByCond(final IG243SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG243SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getPdid())){
			c.add(Expression.eq("pdid", cond.getPdid()));
		}
		if(StringUtils.isNotEmpty(cond.getPtdid_like())){
			c.add(Expression.like("ptdid", cond.getPtdid_like() + "%"));
		}
		return c;
	}
	
	/**
	 * PTDID����ֵȡ��
	 * 
	 * @param ���̶���ID
	 * @return PTDID����ֵ
	 */
	@SuppressWarnings("rawtypes")
	public String getPtdidSequenceNextValue(String pdid) {
		String sql =  "SELECT MAX(ptd.ptdid) FROM IG243TB ptd WHERE ptd.ptdid LIKE :pdid";
		NamedParamMap p = getNamedParamMap();
		p.setString("pdid", pdid + "%");
		List l = findByNamedParamMap(sql, p);
		if( l.size() == 0 || StringUtils.isEmpty((String)l.get(0))) {
			return pdid + StringUtils.leftPad("1", IGPRDCONSTANTS.ID_SUFFIX_LENGTH, "0");
		} else {
			String id = (String)l.get(0);
			return pdid + StringUtils.leftPad((Integer.parseInt(id.replaceFirst(pdid, "")) + 1) + "", IGPRDCONSTANTS.ID_SUFFIX_LENGTH, "0"); 
		}
	}

}