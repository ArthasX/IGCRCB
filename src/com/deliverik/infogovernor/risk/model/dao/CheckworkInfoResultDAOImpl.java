/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.risk.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.risk.model.CheckworkInfoResultInfo;
import com.deliverik.infogovernor.risk.model.condition.CheckworkInfoResultSearchCond;
import com.deliverik.infogovernor.risk.model.entity.CheckworkInfoResultTB;

/**
  * ����: ��鹤��������������DAOʵ��
  * ��������: ��鹤��������������DAOʵ��
  * ������¼: 2014/09/02
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class CheckworkInfoResultDAOImpl extends
		BaseHibernateDAOImpl<CheckworkInfoResultInfo> implements CheckworkInfoResultDAO {

	/**
	 * ���캯��
	 */
	public CheckworkInfoResultDAOImpl(){
		super(CheckworkInfoResultTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CheckworkInfoResultInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CheckworkInfoResultInfo findByPK(Serializable pk) {
		CheckworkInfoResultInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CheckworkInfoResultSearchCond cond){
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
	public List<CheckworkInfoResultInfo> findByCond(final CheckworkInfoResultSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(CheckworkInfoResultSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//��鹤��id
		if( cond.getRcrid()!=null && !(cond.getRcrid().equals("0"))){
			c.add(Restrictions.eq("rcrid",cond.getRcrid()));
		}
		//�������id
		if( cond.getCwrid()!=null && !(cond.getCwrid().equals("0"))){
			c.add(Restrictions.eq("cwrid", cond.getCwrid()));
		}
		//����id
		if( cond.getCwirid()!=null && !(cond.getCwirid().equals("0"))){
			c.add(Restrictions.eq("cwirid", cond.getCwirid()));
		}
		return c;
	}

}