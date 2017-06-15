/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.model.IG992Info;
import com.deliverik.framework.workflow.prd.model.condition.IG992SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG992TB;

/**
  * ����: �����ⲿ���ö����DAOʵ��
  * ��������: �����ⲿ���ö����DAOʵ��
  * ������¼: 2012/04/20
  * �޸ļ�¼: 
  */
public class IG992DAOImpl extends
		BaseHibernateDAOImpl<IG992Info> implements IG992DAO {

	/**
	 * ���캯��
	 */
	public IG992DAOImpl(){
		super(IG992TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG992Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG992Info findByPK(Serializable pk) {
		IG992Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG992SearchCond cond){
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
	public List<IG992Info> findByCond(final IG992SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG992SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
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