/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.vir.model.VCD01Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VCD01SearchCond;
import com.deliverik.infogovernor.soc.vir.model.entity.VCD01TB;

/**
  * ����: vCloud ServiceInstanceDAOʵ��
  * ��������: vCloud ServiceInstanceDAOʵ��
  * ������¼: 2014/02/25
  * �޸ļ�¼: 
  */
public class VCD01DAOImpl extends
		BaseHibernateDAOImpl<VCD01Info> implements VCD01DAO {

	/**
	 * ���캯��
	 */
	public VCD01DAOImpl(){
		super(VCD01TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<VCD01Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public VCD01Info findByPK(Serializable pk) {
		VCD01Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final VCD01SearchCond cond){
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
	public List<VCD01Info> findByCond(final VCD01SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(VCD01SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}