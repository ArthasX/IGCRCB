/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.model.IG211Info;
import com.deliverik.framework.workflow.prd.model.condition.IG211SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG211TB;

/**
 * ����״̬����ǰ����DAOʵ��
 *
 */
@SuppressWarnings("deprecation")
public class IG211DAOImpl extends BaseHibernateDAOImpl<IG211Info> implements IG211DAO {
	

	/**
	 * ���캯��
	 */
	public IG211DAOImpl(){
		super(IG211TB.class);
	}
	
	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<IG211Info> findAll(){
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("psidid"));
		List<IG211Info> ret = findByCriteria(c);
		return ret;
	}

	/**
	 * ������������
	 * @param psidid ����
	 * @return �������
	 */
	public IG211Info findByPK(Serializable psidid){
		
		IG211Info processStatusInfoDef = super.findByPK(psidid);
		
		if(processStatusInfoDef == null) return null;

		return processStatusInfoDef;
	}	

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG211SearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG211Info> findByCond(final IG211SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		List<IG211Info> ret = findByCriteria(c);
		return ret;
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG211SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();		
		
		if(StringUtils.isNotEmpty(cond.getPsdid())){
			c.add(Expression.eq("psdid", cond.getPsdid()));
		}
		if(StringUtils.isNotEmpty(cond.getPsidid_like())){
			c.add(Expression.like("psidid", cond.getPsidid_like() + "%"));
		}
		return c;
	}
	
	/**
	 * PSIDID����ֵȡ��
	 * 
	 * @param ����״̬ID
	 * @return PSIDID����ֵ
	 */
	@SuppressWarnings("rawtypes")
	public String getPsididSequenceNextValue(String psdid) {
		String sql =  "SELECT MAX(psid.psidid) FROM IG211TB psid WHERE psid.psidid LIKE :psdid";
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
