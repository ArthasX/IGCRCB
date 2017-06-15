/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.vir.model.VCD02Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VCD02SearchCond;
import com.deliverik.infogovernor.soc.vir.model.entity.VCD02TB;

/**
  * ����: ������Դ��Ŀ��ϢDAOʵ��
  * ��������: ������Դ��Ŀ��ϢDAOʵ��
  * ������¼: 2014/02/25
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class VCD02DAOImpl extends
		BaseHibernateDAOImpl<VCD02Info> implements VCD02DAO {

	/**
	 * ���캯��
	 */
	public VCD02DAOImpl(){
		super(VCD02TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<VCD02Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public VCD02Info findByPK(Serializable pk) {
		VCD02Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final VCD02SearchCond cond){
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
	public List<VCD02Info> findByCond(final VCD02SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(VCD02SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}