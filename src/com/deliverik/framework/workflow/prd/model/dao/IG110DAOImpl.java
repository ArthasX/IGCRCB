/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prd.model.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.model.IG110Info;
import com.deliverik.framework.workflow.prd.model.condition.IG110SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG110TB;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��ѯ��ʾ�ж���ʵ��DAOʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IG110DAOImpl extends BaseHibernateDAOImpl<IG110Info> implements IG110DAO{
	
	/**
	 * ���췽��
	 */
	public IG110DAOImpl(){
		super(IG110TB.class);
	}

	/**
	 * ��������
	 * @param cond ��������
	 * @param start 
	 * @param count
	 * @return
	 */
	public List<IG110Info> findByCond(IG110SearchCond cond, int start, int count) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("sid"));
		return findByCriteria(c, start, count);
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG110SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getPdid())){
			c.add(Restrictions.eq("pdid", cond.getPdid()));
		}
		return c;
	}
	
	/**
	 * ȡ����һ��ID
	 * @param pdid ���̶���ID
	 * @return ʵ��ID
	 */
	@SuppressWarnings("rawtypes")
	public String getNextId(String pdid){
		String sql = "SELECT MAX(s.sid) FROM IG110TB s WHERE s.sid like :pdid";
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

	/**
	 * �������̶���idɾ����ʾ��
	 * 
	 * @param pdid
	 */
	public void deleteByPdid(String pdid) {
		String sql = "delete from ig110 where pdid = :pdid";
		SQLQuery q = getSession().createSQLQuery(sql);
		q.setParameter("pdid", pdid);
		q.executeUpdate();
	}
}
