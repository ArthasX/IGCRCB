/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.vir.model.VCD05Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VCD05SearchCond;
import com.deliverik.infogovernor.soc.vir.model.entity.VCD05TB;

/**
  * ����: vCloud����ģ��DAOʵ��
  * ��������: vCloud����ģ��DAOʵ��
  * ������¼: 2014/02/25
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class VCD05DAOImpl extends
		BaseHibernateDAOImpl<VCD05Info> implements VCD05DAO {

	/**
	 * ���캯��
	 */
	public VCD05DAOImpl(){
		super(VCD05TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<VCD05Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public VCD05Info findByPK(Serializable pk) {
		VCD05Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final VCD05SearchCond cond){
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
	public List<VCD05Info> findByCond(final VCD05SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(VCD05SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}