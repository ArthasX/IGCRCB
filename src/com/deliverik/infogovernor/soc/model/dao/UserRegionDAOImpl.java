/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.model.UserRegionInfo;
import com.deliverik.infogovernor.soc.model.condition.UserRegionSearchCond;
import com.deliverik.infogovernor.soc.model.entity.UserRegionTB;

/**
  * ����: UserRegionDAOʵ��
  * ��������: UserRegionDAOʵ��
  * ������¼: 2014/01/10
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class UserRegionDAOImpl extends
		BaseHibernateDAOImpl<UserRegionInfo> implements UserRegionDAO {

	/**
	 * ���캯��
	 */
	public UserRegionDAOImpl(){
		super(UserRegionTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<UserRegionInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public UserRegionInfo findByPK(Serializable pk) {
		UserRegionInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final UserRegionSearchCond cond){
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
	public List<UserRegionInfo> findByCond(final UserRegionSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(UserRegionSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if( StringUtils.isNotEmpty(cond.getFLEXID()) ){
			c.add(Expression.eq("flexID", cond.getFLEXID() ));
		}
		if( StringUtils.isNotEmpty(cond.getUSERID()) ){
			c.add(Expression.eq("UserID", cond.getUSERID() ));
		}
		return c;
	}

}