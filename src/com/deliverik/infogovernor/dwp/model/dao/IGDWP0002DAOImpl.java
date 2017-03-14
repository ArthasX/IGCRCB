/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dwp.model.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.dwp.model.IGDWP0002Info;
import com.deliverik.infogovernor.dwp.model.condition.IGDWP0002SearchCond;
import com.deliverik.infogovernor.dwp.model.entity.IGDWP0002TB;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �ճ������ƻ�������ϢDAOʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGDWP0002DAOImpl extends BaseHibernateDAOImpl<IGDWP0002Info> implements IGDWP0002DAO{

	/**
	 * ���캯��
	 */
	public IGDWP0002DAOImpl(){
		super(IGDWP0002TB.class);
	}
	
	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IGDWP0002SearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}
	
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IGDWP0002Info> findByCond(IGDWP0002SearchCond cond,int start, int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}
	
	/**
	 * ������������
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IGDWP0002SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getPlanid() != null && cond.getPlanid() > 0){
			c.add(Restrictions.eq("planid", cond.getPlanid()));
		}
		return c;
	}
}
