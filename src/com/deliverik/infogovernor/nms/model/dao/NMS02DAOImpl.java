/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.model.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.nms.model.NMS02Info;
import com.deliverik.infogovernor.nms.model.condition.NMS02SearchCond;
import com.deliverik.infogovernor.nms.model.entity.NMS02TB;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: SNMP������ϢDAOʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("deprecation")
public class NMS02DAOImpl extends BaseHibernateDAOImpl<NMS02Info> implements NMS02DAO {
	/**
	 * ���췽��
	 */
	public NMS02DAOImpl(){
		super(NMS02TB.class);
	}
	
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(NMS02SearchCond cond){
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
	public List<NMS02Info> findByCond(NMS02SearchCond cond, int start, int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(NMS02SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//ɾ����ʶ 
		if( !StringUtils.isEmpty(cond.getDeleteflag())){
			c.add(Expression.eq("deleteflag", cond.getDeleteflag()));
		}
		//SNMP�汾
		if(cond.getSnmpVersion() != null && cond.getSnmpVersion() > 0){
			c.add(Expression.eq("snmpVersion", cond.getSnmpVersion()));
		}
		//�˿�
		if(cond.getSnmpPort() != null && cond.getSnmpPort() > 0){
			c.add(Expression.eq("snmpPort", cond.getSnmpPort()));
		}
		//��ȡ������
		if( !StringUtils.isEmpty(cond.getReadCommit())){
			c.add(Expression.eq("readCommit", cond.getReadCommit()));
		}
		//V3��ȫ�û�
		if( !StringUtils.isEmpty(cond.getSnmpUser())){
			c.add(Expression.eq("snmpUser", cond.getSnmpUser()));
		}
		//V3�����֤����
		if( !StringUtils.isEmpty(cond.getSnmpPassword())){
			c.add(Expression.eq("snmpPassword", cond.getSnmpPassword()));
		}
		return c;
	}
}
