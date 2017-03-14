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
import com.deliverik.framework.workflow.prd.model.IG213Info;
import com.deliverik.framework.workflow.prd.model.condition.IG213SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG213TB;

/**
 * 
 * ���̽�ɫ��Ȩ����DAOʵ��
 *
 */
@SuppressWarnings("deprecation")
public class IG213DAOImpl extends BaseHibernateDAOImpl<IG213Info> implements IG213DAO{

	/**
	 * ���캯��
	 */
	public IG213DAOImpl(){
		super(IG213TB.class);
	}
	
	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<IG213Info> findAll(){
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("prtdid"));
		List<IG213Info> ret = findByCriteria(c);
		return ret;
	}

	/**
	 * ������������
	 * @param psdid ����
	 * @return �������
	 */
	public IG213Info findByPK(Serializable prtdid){
		
		IG213Info processRoleTypeDef = super.findByPK(prtdid);
		
		if(processRoleTypeDef == null) return null;

		return processRoleTypeDef;
	}
	

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG213SearchCond cond){
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
	public List<IG213Info> findByCond(final IG213SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		List<IG213Info> ret = findByCriteria(c);
		return ret;
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG213SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();		
		if(StringUtils.isNotEmpty(cond.getPdid())){
			c.add(Expression.eq("pdid", cond.getPdid()));
		}		
		if(StringUtils.isNotEmpty(cond.getPrtdid_like())){
			c.add(Expression.like("prtdid", cond.getPrtdid_like() + "%"));
		}
		return c;
	}	
	
	/**
	 * PRTDID����ֵȡ��
	 * 
	 * @param ���̶���ID
	 * @return PRTDID����ֵ
	 */
	@SuppressWarnings("rawtypes")
	public String getPrtdidSequenceNextValue(String pdid) {
		String sql =  "SELECT MAX(prt.prtdid) FROM IG213TB prt WHERE prt.prtdid LIKE :pdid";
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
