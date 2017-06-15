package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.annotation.IdGeneratorMethod;
import com.deliverik.framework.workflow.prd.model.IG413Info;
import com.deliverik.framework.workflow.prd.model.condition.IG413SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG413TB;

/**
 * �����¼�������ϢDAOʵ��
 * 
 */
@SuppressWarnings("deprecation")
public class IG413DAOImpl extends
		BaseHibernateDAOImpl<IG413Info> implements IG413DAO {

	/**
	 * ���캯��
	 */
	public IG413DAOImpl() {
		super(IG413TB.class);
	}

	/**
	 * ȫ������
	 * 
	 * @return ���������
	 */
	public List<IG413Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("pdid"));
		c.addOrder(Order.asc("psdid"));
		c.addOrder(Order.asc("pedorder"));
		List<IG413Info> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param pedid����
	 * @return �������
	 */
	public IG413Info findByPK(Serializable pedid) {

		IG413Info result = super.findByPK(pedid);
		if (result == null)
			return null;

		return result;
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond��������
	 * @return �����������
	 */
	public int getSearchCount(final IG413SearchCond cond) {
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
	public List<IG413Info> findByCond(
			final IG413SearchCond cond, final int start,
			final int count) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("pdid"));
		c.addOrder(Order.asc("psdid"));
		c.addOrder(Order.asc("pedorder"));
		List<IG413Info> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG413SearchCond cond) {
		DetachedCriteria c = getDetachedCriteria();
		//���̶���ID
		if(StringUtils.isNotEmpty(cond.getPdid())){
			c.add(Expression.eq("pdid", cond.getPdid()));
		}
		//״̬ID
		if(StringUtils.isNotEmpty(cond.getPsdid())){
			c.add(Expression.eq("psdid", cond.getPsdid()));
		}
		//�¼�����
		if(StringUtils.isNotEmpty(cond.getPedtype())){
			c.add(Expression.eq("pedtype", cond.getPedtype()));
		}
		//����
		if(StringUtils.isNotEmpty(cond.getPedid_like())){
			c.add(Expression.like("pedid", cond.getPedid_like() + "%"));
		}
		return c;
	}
	
	/**
	 * PEDID����ֵȡ��
	 * 
	 * @param ����״̬ID
	 * @return PEDID����ֵ
	 */
	@SuppressWarnings("rawtypes")
	@IdGeneratorMethod("psdid")
	public String getPedidSequenceNextValue(String psdid) {
		String sql =  "SELECT MAX(ped.pedid) FROM IG413TB ped WHERE ped.pedid LIKE :psdid";
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
