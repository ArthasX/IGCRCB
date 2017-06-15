/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sym.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.sym.model.MSGFILTERInfo;
import com.deliverik.infogovernor.sym.model.condition.MSGFILTERSearchCond;
import com.deliverik.infogovernor.sym.model.entity.MSGFILTERTB;

/**
  * ����: MSGFILTERDAOʵ��
  * ��������: MSGFILTERDAOʵ��
  * ������¼: 2013/08/21
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class MSGFILTERDAOImpl extends
		BaseHibernateDAOImpl<MSGFILTERInfo> implements MSGFILTERDAO {

	/**
	 * ���캯��
	 */
	public MSGFILTERDAOImpl(){
		super(MSGFILTERTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<MSGFILTERInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public MSGFILTERInfo findByPK(Serializable pk) {
		MSGFILTERInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final MSGFILTERSearchCond cond){
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
	public List<MSGFILTERInfo> findByCond(final MSGFILTERSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(MSGFILTERSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//���澯IP��Ϊ��ʱ
		if(cond!=null){
			if (StringUtils.isNotEmpty(cond.getDeviceip())) {
				c.add(Restrictions.like("deviceip", "%" + cond.getDeviceip() + "%"));
				}
			}
		return c;
	}

}