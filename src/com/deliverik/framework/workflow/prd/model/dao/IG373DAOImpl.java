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
import com.deliverik.framework.workflow.prd.model.IG373Info;
import com.deliverik.framework.workflow.prd.model.condition.IG373SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG373TB;

/**
  * ����: ���̱���ʼ���¼������DAOʵ��
  * ��������: ���̱���ʼ���¼������DAOʵ��
  * ������¼: 2012/07/03
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class IG373DAOImpl extends
		BaseHibernateDAOImpl<IG373Info> implements IG373DAO {

	/**
	 * ���캯��
	 */
	public IG373DAOImpl(){
		super(IG373TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG373Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG373Info findByPK(Serializable pk) {
		IG373Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG373SearchCond cond){
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
	public List<IG373Info> findByCond(final IG373SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG373SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//���̶���ID
		if(StringUtils.isNotEmpty(cond.getPdid())){
			c.add(Expression.eq("pdid", cond.getPdid()));
		}
		//����״̬ID
		if(StringUtils.isNotEmpty(cond.getPsdid())){
			c.add(Expression.eq("psdid", cond.getPsdid()));
		}
		return c;
	}
	
	/**
	 * PIIDID����ֵȡ��
	 * 
	 * @param ����״̬ID
	 * @return PIIDID����ֵ
	 */
	@SuppressWarnings("rawtypes")
	public String getPiididSequenceNextValue(String psdid) {
		String sql =  "SELECT MAX(pid.piidid) FROM IG373TB pid WHERE pid.piidid LIKE :psdid";
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