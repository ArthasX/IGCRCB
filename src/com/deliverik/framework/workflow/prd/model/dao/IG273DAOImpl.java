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
import com.deliverik.framework.workflow.prd.model.IG273Info;
import com.deliverik.framework.workflow.prd.model.condition.IG273SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG273TB;

/**
 * 
 * ����״̬ԾǨ����DAOʵ��
 * @author maozhipeng@deliverik.com
 *
 */
@SuppressWarnings("deprecation")
public class IG273DAOImpl extends BaseHibernateDAOImpl<IG273Info> implements IG273DAO{
	/**
	 * ���캯��
	 */
	public IG273DAOImpl(){
		super(IG273TB.class);
	}
	
	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<IG273Info> findAll(){
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("ptdid"));
		List<IG273Info> ret = findByCriteria(c);
		return ret;
	}

	/**
	 * ������������
	 * @param ptdid ����
	 * @return �������
	 */
	public IG273Info findByPK(Serializable ptdid){
		
		IG273Info processTransitionDef = super.findByPK(ptdid);
		
		if(processTransitionDef == null) return null;

		return processTransitionDef;
	}
	

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG273SearchCond cond){
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
	public List<IG273Info> findByCond(final IG273SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		List<IG273Info> ret = findByCriteria(c);
		return ret;
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG273SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getFpsdid())){
			c.add(Expression.eq("fpsdid", cond.getFpsdid()));
		}
		if( !StringUtils.isEmpty(cond.getPtdcond())){
			c.add(Expression.eq("ptdcond", cond.getPtdcond()));
		}
		if( !StringUtils.isEmpty(cond.getPtdcond_like())){
			c.add(Expression.like("ptdcond", "%" + cond.getPtdcond_like() + "%"));
		}
		if( !StringUtils.isEmpty(cond.getPtdname())){
			c.add(Expression.eq("ptdname", cond.getPtdname()));
		}
		if( !StringUtils.isEmpty(cond.getPtdtype())){
			c.add(Expression.eq("ptdtype", cond.getPtdtype()));
		}
		if(StringUtils.isNotEmpty(cond.getTpsdid())){
			c.add(Expression.eq("tpsdid", cond.getTpsdid()));
		}
		//ȱʡ
		if( cond.isDefaultRule()){
			c.add(Expression.eq("ptdtype", IGPRDCONSTANTS.COND_TYPE_DEFAULT));
		}
		//��ȱʡ
		if( cond.isNotDefaultRule()){
			c.add(Expression.ne("ptdtype", IGPRDCONSTANTS.COND_TYPE_DEFAULT));
		}
		if(StringUtils.isNotEmpty(cond.getPtdid_like())){
			c.add(Expression.like("ptdid", cond.getPtdid_like() + "%"));
		}
		return c;
	}
	
	/**
	 * PTDID����ֵȡ��
	 * 
	 * @param ����״̬ID
	 * @return PTDID����ֵ
	 */
	@SuppressWarnings("rawtypes")
	public String getPtdidSequenceNextValue(String psdid) {
		String sql =  "SELECT MAX(ptd.ptdid) FROM IG273TB ptd WHERE ptd.ptdid LIKE :psdid";
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
