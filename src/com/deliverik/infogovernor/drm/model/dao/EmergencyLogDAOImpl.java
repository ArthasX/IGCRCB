/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.drm.model.EmergencyLogInfo;
import com.deliverik.infogovernor.drm.model.condition.EmergencyLogSearchCond;
import com.deliverik.infogovernor.drm.model.entity.EmergencyLogTB;

/**
 * ������Ӧ����־��Ϣ��DAOʵ��
 * ����������Ӧ����־��Ϣ��DAOʵ��
 * ������¼��2014/05/19
 * (1)�����뽵������������EmergencyLogTB�е��ֶ���Ϊ��������ֻ�Ǽ�����û�漰���ӹ�ϵ
 * �޸ļ�¼��
 */
@SuppressWarnings("deprecation")
public class EmergencyLogDAOImpl extends BaseHibernateDAOImpl<EmergencyLogInfo> implements EmergencyLogDAO {
	/**
	 * ���캯��
	 */
	public EmergencyLogDAOImpl(){
		super(EmergencyLogTB.class);
	}
	
	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	@Override
    public List<EmergencyLogInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("elid"));//ȫ������Ĭ�ϰ�������������
		return findByCriteria(c);
	}
	
	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	@Override
    public EmergencyLogInfo findByPK(Serializable pk) {
		EmergencyLogInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final EmergencyLogSearchCond cond){
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
	public List<EmergencyLogInfo> findByCond(final EmergencyLogSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(EmergencyLogSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//Ӧ���������ID(��ȫƥ��)
		if(StringUtils.isNotEmpty(cond.getElprid_eq())){
			c.add(Expression.eq("elprid", Integer.parseInt(cond.getElprid_eq())));
		}
		//��־��Ϣ����(��ȫƥ��)
		if(StringUtils.isNotEmpty(cond.getEllitype_eq())){
			c.add(Expression.eq("ellitype", cond.getEllitype_eq()));
		}
		if(cond.getPsdid_in()!=null&&cond.getPsdid_in().length>0){
			c.add(Expression.in("elpsdid", cond.getPsdid_in()));
		}
		if(cond.getPrid_in()!=null&&cond.getPrid_in().length>0){
			c.add(Expression.in("elprid", cond.getPrid_in()));
		}
		//��������������
		if(cond.getAscs() != null){
			for(String asc : cond.getAscs()){
				if(StringUtils.isNotEmpty(asc)){
					c.addOrder(Order.asc(asc));
				}
			}
		}
		//��������������
		if(cond.getDesc() != null){
			for(String desc : cond.getDesc()){
				if(StringUtils.isNotEmpty(desc)){
					c.addOrder(Order.desc(desc));
				}
			}
		}
		return c;
	}
}