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
import com.deliverik.framework.workflow.prd.model.IG132Info;
import com.deliverik.framework.workflow.prd.model.condition.IG132SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG132TB;

/**
  * ����: �����߰�ť������Ϣ��DAOʵ��
  * ��������: �����߰�ť������Ϣ��DAOʵ��
  * ������¼: 2012/04/18
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class IG132DAOImpl extends
		BaseHibernateDAOImpl<IG132Info> implements IG132DAO {

	/**
	 * ���캯��
	 */
	public IG132DAOImpl(){
		super(IG132TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG132Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG132Info findByPK(Serializable pk) {
		IG132Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG132SearchCond cond){
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
	public List<IG132Info> findByCond(final IG132SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG132SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getPpdid())){
			c.add(Expression.eq("ppdid", cond.getPpdid()));
		}
		if(StringUtils.isNotEmpty(cond.getPpbdid_like())){
			c.add(Expression.like("ppbdid", cond.getPpbdid_like() + "%"));
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
	public String getPpbdidSequenceNextValue(String ppbdid) {
		String sql =  "SELECT MAX(p.ppbdid) FROM IG132TB p WHERE p.ppbdid LIKE :ppbdid";
		NamedParamMap p = getNamedParamMap();
		p.setString("ppbdid", ppbdid + "%");
		List l = findByNamedParamMap(sql, p);
		if( l.size() == 0 || StringUtils.isEmpty((String)l.get(0))) {
			return ppbdid + StringUtils.leftPad("1", IGPRDCONSTANTS.ID_SUFFIX_LENGTH, "0");
		} else {
			String id = (String)l.get(0);
			return ppbdid + StringUtils.leftPad((Integer.parseInt(id.replaceFirst(ppbdid, "")) + 1) + "", IGPRDCONSTANTS.ID_SUFFIX_LENGTH, "0"); 
		}
	}
}