package com.deliverik.framework.user.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.condition.OrganizationSearchCond;
import com.deliverik.framework.user.model.entity.OrganizationTB;
import com.deliverik.framework.utility.CommonDefineUtils;

/**
 * ������ϢDAOʵ��
 * 
 */
@SuppressWarnings("deprecation")
public class OrganizationTBDAOImpl extends BaseHibernateDAOImpl<Organization> implements OrganizationTBDAO {

	/**
	 * ���캯��
	 */
	public OrganizationTBDAOImpl(){
		super(OrganizationTB.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<Organization> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("orgid"));
		List<Organization> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param orgid ����
	 * @return �������
	 */
	public Organization findByPK(Serializable orgid) {

		Organization org = super.findByPK(orgid);
		if(org == null) return null;

		return org;
	}
	
	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final OrganizationSearchCond cond){
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
	public List<Organization> findByCond(final OrganizationSearchCond cond, final int start, final int count) {
		DetachedCriteria c = getCriteria(cond);
		if(CommonDefineUtils.SORT_BY_ORGSYSCODING.equals(cond.getSortType())){
			c.addOrder(Order.asc("orgpar"));
			c.addOrder(Order.asc("orgsyscoding"));
		}else{
			c.addOrder(Order.asc("orgpar"));
			c.addOrder(Order.asc("orgsyscoding"));
		}
		
		List<Organization> ret = findByCriteria(c, start, count);
		return ret;
	}
	
	/**
	 * ������������ҳ��������ʾ������
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<Organization> findByCond(final OrganizationSearchCond cond) {
		DetachedCriteria c = getCriteria(cond);
		if(!StringUtils.isEmpty(cond.getRoledomain_q())){
			c.addOrder(Order.asc("orgsyscoding"));
		}else if(!StringUtils.isEmpty(cond.getComplete_name())){
			c.addOrder(Order.asc("orgid"));
		}else if(CommonDefineUtils.SORT_BY_ORGSYSCODING.equals(cond.getSortType())){
			c.addOrder(Order.asc("orgpar"));
			c.addOrder(Order.asc("orgsyscoding"));
		}else{
			c.addOrder(Order.asc("orgsyscoding"));
		}
		List<Organization> ret = findByCriteria(c);
		return ret;
	}
	
	/**
	 * ���������������������¼���
	 * @param cond ��������
	 * @param orgsyscoding ���������
	 * @return ��������б�
	 */
	public List<Organization> findByCond(final OrganizationSearchCond cond,final String orgsyscoding) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("orgsyscoding"));
		List<Organization> ret = findByCriteria(c);
		return ret;
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(OrganizationSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//��������
		if( !StringUtils.isEmpty(cond.getOrgname())){
			c.add(Expression.eq("orgname", cond.getOrgname()));
		}	
		//��������
		if( !StringUtils.isEmpty(cond.getOrgname_q())){
			c.add(Expression.like("orgname", "%"+cond.getOrgname_q()+"%"));
		}	
		//�ϼ����������
		if( cond.getOrgpar()!=null && StringUtils.isEmpty(cond.getOrgparid())){
			c.add(Expression.eq("orgpar", cond.getOrgpar()));
		}
		//�ϼ����������
		if( cond.getOrgsuper()!=null && cond.getOrgsuper()!=0){
			c.add(Expression.ne("orgpar", "0"));
		}
		//�ϼ����������
		if( !StringUtils.isEmpty(cond.getOrgparstr_q())){
			c.add(Expression.like("orgsyscoding", cond.getOrgparstr_q()+"%"));
			c.add(Expression.ne("orgsyscoding", cond.getOrgparstr_q()));
		}	
		
		//������ʾ��
		if( !StringUtils.isEmpty(cond.getIs_in_use())){
			c.add(Expression.eq("orgstatus", cond.getIs_in_use()));
		}	
		//�ϼ����������
		if( !StringUtils.isEmpty(cond.getOrgparid()) ){
			c.add(Expression.eq("orgpar", cond.getOrgparid()));
		}	
		
		//��ɫ��������ʾ����������
		if( !StringUtils.isEmpty(cond.getOrgsyscoding())){
			c.add(Expression.eq("orgsyscoding", cond.getOrgsyscoding()));
		}
		
		//��ɫ�����������ʲ�Ȩ�޿��ƣ�
		if( !StringUtils.isEmpty(cond.getRoledomain_q())){
			c.add(Expression.like("orgsyscoding", cond.getRoledomain_q()+"%"));
		}
		//��ɫ������������������ƣ��ʲ�Ȩ�޿��ƣ�
		if( !StringUtils.isEmpty(cond.getComplete_name())){
			String syscode = cond.getComplete_name();
			c.add(Expression.ge("orgsyscoding", syscode.substring(0,4)));
			c.add(Expression.le("orgsyscoding", syscode));
		}
		
		//������ѯ�Ƿ���ʾͣ�ð�ť
		if( !StringUtils.isEmpty(cond.getOrgsyscoding_q()) ){
			c.add(Expression.eq("orgpar", cond.getOrgsyscoding_q()));
		}	
		
		//��ý���ȫ��
		if(null!=cond.getSyscoding_area() &&  cond.getSyscoding_area().size()>0){
			c.add(Expression.in("orgsyscoding", cond.getSyscoding_area()));
		}
		
		if(null!=cond.getNot_in_syscoding_area() &&  cond.getNot_in_syscoding_area().size()>0){
			c.add(Expression.not(Expression.in("orgsyscoding", cond.getNot_in_syscoding_area())));
		}
		
		if( !StringUtils.isEmpty(cond.getXbtype()) ){
			c.add(Expression.like("orgsyscoding", cond.getXbtype()+"%"));
		}	
		
		if( !StringUtils.isEmpty(cond.getOrgname_like()) ){
			c.add(Expression.like("orgname", "%-"+cond.getOrgname_like()));
		}
		return c;
	}
	
}
