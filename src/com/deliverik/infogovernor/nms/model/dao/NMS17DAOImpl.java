/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.nms.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.nms.model.NMS17Info;
import com.deliverik.infogovernor.nms.model.condition.NMS17SearchCond;
import com.deliverik.infogovernor.nms.model.entity.NMS17TB;

/**
  * ����: ����������ϢDAOʵ��
  * ��������: ����������ϢDAOʵ��
  * ������¼: 2014/01/07
  * �޸ļ�¼: 
  */
public class NMS17DAOImpl extends
		BaseHibernateDAOImpl<NMS17Info> implements NMS17DAO {

	/**
	 * ���캯��
	 */
	public NMS17DAOImpl(){
		super(NMS17TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<NMS17Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public NMS17Info findByPK(Serializable pk) {
		NMS17Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final NMS17SearchCond cond){
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
	public List<NMS17Info> findByCond(final NMS17SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(NMS17SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(null != cond.getGid()){
		    c.add(Restrictions.eq("gid", cond.getGid()));
		}
		if(null != cond.getGversion()){
		    c.add(Restrictions.eq("gversion", cond.getGversion()));
		}
		if(StringUtils.isNotEmpty(cond.getUserid())){
		    c.add(Restrictions.eq("userid", cond.getUserid()));
		}
		return c;
	}

}