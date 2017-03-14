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
import com.deliverik.infogovernor.risk.model.CheckWorkResultInfo;
import com.deliverik.infogovernor.risk.model.condition.CheckWorkResultSearchCond;
import com.deliverik.infogovernor.risk.model.entity.CheckWorkResultTB;

/**
  * ����: �������DAOʵ��
  * ��������: �������DAOʵ��
  * ������¼: 2014/09/02
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class CheckWorkResultDAOImpl extends
		BaseHibernateDAOImpl<CheckWorkResultInfo> implements CheckWorkResultDAO {

	/**
	 * ���캯��
	 */
	public CheckWorkResultDAOImpl(){
		super(CheckWorkResultTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CheckWorkResultInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CheckWorkResultInfo findByPK(Serializable pk) {
		CheckWorkResultInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CheckWorkResultSearchCond cond){
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
	public List<CheckWorkResultInfo> findByCond(final CheckWorkResultSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(CheckWorkResultSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if( cond.getCsid()!=null && !(cond.getCsid().equals("0"))){
			c.add(Restrictions.eq("csid", cond.getCsid()));
		}
		//
		if(StringUtils.isNotEmpty(cond.getCwrid_in())){
			c.add(Restrictions.in("cwrid", cond.getCwrid_inSet()));
		}
		//��鷽ʽ
		if(StringUtils.isNotEmpty(cond.getCwrtestmode())){
			c.add(Restrictions.eq("cwrtestmode", cond.getCwrtestmode()));
		}
		//����������
		if(StringUtils.isNotEmpty(cond.getCwrname())){
			c.add(Restrictions.like("cwrname","%"+cond.getCwrname()+"%"));
		}
		//������
		if(StringUtils.isNotEmpty(cond.getCwrusername())){
			c.add(Restrictions.like("cwrusername","%"+cond.getCwrusername()+"%"));
		}
		//�ƻ���ʼʱ��
		if(StringUtils.isNotEmpty(cond.getCwrplandate_from()) && StringUtils.isNotEmpty(cond.getCwrplandate_to())){
			c.add(Restrictions.ge("cwrplandate",cond.getCwrplandate_from()));
			c.add(Restrictions.le("cwrplandate",cond.getCwrplandate_to()));
		}else if(StringUtils.isNotEmpty(cond.getCwrplandate_from())){
			c.add(Restrictions.ge("cwrplandate",cond.getCwrplandate_from()));
		}else if(StringUtils.isNotEmpty(cond.getCwrplandate_to())){
			c.add(Restrictions.le("cwrplandate",cond.getCwrplandate_to()));
		}		
		//���ʱ��
		if(StringUtils.isNotEmpty(cond.getCwrrealtime_from()) && StringUtils.isNotEmpty(cond.getCwrrealtime_to())){
			c.add(Restrictions.ge("cwrrealtime",cond.getCwrrealtime_from()));
			c.add(Restrictions.le("cwrrealtime",cond.getCwrrealtime_to()));
		}else if(StringUtils.isNotEmpty(cond.getCwrrealtime_from())){
			c.add(Restrictions.ge("cwrrealtime",cond.getCwrrealtime_from()));
		}else if(StringUtils.isNotEmpty(cond.getCwrrealtime_to())){
			c.add(Restrictions.le("cwrrealtime",cond.getCwrrealtime_to()));
		}	
		return c;
	}

}