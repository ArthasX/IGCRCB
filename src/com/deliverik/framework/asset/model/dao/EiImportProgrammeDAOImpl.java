/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.deliverik.framework.asset.model.EiImportProgrammeInfo;
import com.deliverik.framework.asset.model.condition.EiImportProgrammeSearchCond;
import com.deliverik.framework.asset.model.entity.EiImportProgrammeTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
  * ����: �����������DAOʵ��
  * ��������: �����������DAOʵ��
  * ������¼: 2011/05/05
  * �޸ļ�¼: 
  */
public class EiImportProgrammeDAOImpl extends
		BaseHibernateDAOImpl<EiImportProgrammeInfo> implements EiImportProgrammeDAO {

	/**
	 * ���캯��
	 */
	public EiImportProgrammeDAOImpl(){
		super(EiImportProgrammeTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<EiImportProgrammeInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public EiImportProgrammeInfo findByPK(Serializable pk) {
		EiImportProgrammeInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final EiImportProgrammeSearchCond cond){
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
	public List<EiImportProgrammeInfo> findByCond(final EiImportProgrammeSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(EiImportProgrammeSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}