/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.smr.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.smr.model.RemindConfigureInfo;
import com.deliverik.infogovernor.smr.model.condition.RemindConfigureSearchCond;
import com.deliverik.infogovernor.smr.model.entity.RemindConfigureTB;

/**
  * ����: �������ñ�DAOʵ��
  * ��������: �������ñ�DAOʵ��
  * ������¼: 2013/08/05
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class RemindConfigureDAOImpl extends
		BaseHibernateDAOImpl<RemindConfigureInfo> implements RemindConfigureDAO {

	/**
	 * ���캯��
	 */
	public RemindConfigureDAOImpl(){
		super(RemindConfigureTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RemindConfigureInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RemindConfigureInfo findByPK(Serializable pk) {
		RemindConfigureInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RemindConfigureSearchCond cond){
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
	public List<RemindConfigureInfo> findByCond(final RemindConfigureSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(RemindConfigureSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//��
		if(StringUtils.isNotEmpty(cond.getRcyear())){
			c.add(Expression.eq("rcyear", cond.getRcyear()));
		}
		//����
		if(StringUtils.isNotEmpty(cond.getRctype())){
			c.add(Expression.eq("rctype", cond.getRctype()));
		}
		return c;
	}

}