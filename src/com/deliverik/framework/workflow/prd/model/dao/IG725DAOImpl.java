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
import com.deliverik.framework.workflow.annotation.IdGeneratorMethod;
import com.deliverik.framework.workflow.prd.model.IG725Info;
import com.deliverik.framework.workflow.prd.model.condition.IG725SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG725TB;

/**
  * ����: ȱʡ�����߰�ť�����DAOʵ��
  * ��������: ȱʡ�����߰�ť�����DAOʵ��
  * ������¼: 2012/04/18
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class IG725DAOImpl extends
		BaseHibernateDAOImpl<IG725Info> implements IG725DAO {

	/**
	 * ���캯��
	 */
	public IG725DAOImpl(){
		super(IG725TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG725Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG725Info findByPK(Serializable pk) {
		IG725Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG725SearchCond cond){
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
	public List<IG725Info> findByCond(final IG725SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG725SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//״̬ID
		if(StringUtils.isNotEmpty(cond.getPsdid())){
			c.add(Expression.eq("psdid", cond.getPsdid()));
		}
		//��ťID
		if(StringUtils.isNotEmpty(cond.getPbdid())){
			c.add(Expression.eq("pbdid", cond.getPbdid()));
		}
		//����
		if(StringUtils.isNotEmpty(cond.getPdbdid_like())){
			c.add(Expression.like("pdbdid", cond.getPdbdid_like() + "%"));
		}
		return c;
	}
	/**
	 * PSDID����ֵȡ��
	 * 
	 * @param ���̶���ID
	 * @return PSDID����ֵ
	 */
	@SuppressWarnings("rawtypes")
	@IdGeneratorMethod("psdid")
	public String getPdbdidSequenceNextValue(String psdid) {
		String sql =  "SELECT MAX(p.pdbdid) FROM IG725TB p WHERE p.pdbdid LIKE :psdid";
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