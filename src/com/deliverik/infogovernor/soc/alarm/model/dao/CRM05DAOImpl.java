/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.alarm.model.CRM05Info;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM05SearchCond;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM05TB;

/**
  * ����: CRM05DAOʵ��
  * ��������: CRM05DAOʵ��
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class CRM05DAOImpl extends
		BaseHibernateDAOImpl<CRM05Info> implements CRM05DAO {

	/**
	 * ���캯��
	 */
	public CRM05DAOImpl(){
		super(CRM05TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CRM05Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CRM05Info findByPK(Serializable pk) {
		CRM05Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CRM05SearchCond cond){
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
	public List<CRM05Info> findByCond(final CRM05SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		
		c.addOrder(Order.desc("uploadtime"));//����ʱ���ɽ���Զ����
		
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(CRM05SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getFilename_like())){
			c.add( Expression.like("filename", "%"+cond.getFilename_like()+"%") );
		}
		if(StringUtils.isNotEmpty(cond.getUploadtime_begin() )){
			c.add( Expression.ge("uploadtime", cond.getUploadtime_begin()+" 00:00:00") );
		}
		if(StringUtils.isNotEmpty(cond.getUploadtime_end() )){
			c.add( Expression.le("uploadtime", cond.getUploadtime_end()+" 23:59:59") );
		}
		return c;
	}

}