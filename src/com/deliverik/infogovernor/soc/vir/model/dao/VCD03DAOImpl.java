/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.vir.model.VCD03Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VCD03SearchCond;
import com.deliverik.infogovernor.soc.vir.model.entity.VCD03TB;

/**
  * ����: ��Դ���������ϢDAOʵ��
  * ��������: ��Դ���������ϢDAOʵ��
  * ������¼: 2014/02/25
  * �޸ļ�¼: 
  */
public class VCD03DAOImpl extends BaseHibernateDAOImpl<VCD03Info> implements VCD03DAO {

	/**
	 * ���캯��
	 */
	public VCD03DAOImpl(){
		super(VCD03TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<VCD03Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public VCD03Info findByPK(Serializable pk) {
		VCD03Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final VCD03SearchCond cond){
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
	public List<VCD03Info> findByCond(final VCD03SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(VCD03SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//��ĿID
		if(cond.getPid() != null && cond.getPid() > 0){
			c.add(Restrictions.eq("pid", cond.getPid()));
		}
		//����ID
		if(cond.getPrid() != null && cond.getPrid() > 0){
			c.add(Restrictions.eq("prid", cond.getPrid()));
		}
		return c;
	}

}