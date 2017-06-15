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
 * 机构信息DAO实现
 * 
 */
@SuppressWarnings("deprecation")
public class OrganizationTBDAOImpl extends BaseHibernateDAOImpl<Organization> implements OrganizationTBDAO {

	/**
	 * 构造函数
	 */
	public OrganizationTBDAOImpl(){
		super(OrganizationTB.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<Organization> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("orgid"));
		List<Organization> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param orgid 主键
	 * @return 检索结果
	 */
	public Organization findByPK(Serializable orgid) {

		Organization org = super.findByPK(orgid);
		if(org == null) return null;

		return org;
	}
	
	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final OrganizationSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
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
	 * 条件检索处理，页面树形显示机构用
	 * @param cond 检索条件
	 * @return 检索结果列表
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
	 * 条件检索处理，新增机构下级用
	 * @param cond 检索条件
	 * @param orgsyscoding 机构层次码
	 * @return 检索结果列表
	 */
	public List<Organization> findByCond(final OrganizationSearchCond cond,final String orgsyscoding) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("orgsyscoding"));
		List<Organization> ret = findByCriteria(c);
		return ret;
	}
	
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(OrganizationSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//机构名称
		if( !StringUtils.isEmpty(cond.getOrgname())){
			c.add(Expression.eq("orgname", cond.getOrgname()));
		}	
		//机构名称
		if( !StringUtils.isEmpty(cond.getOrgname_q())){
			c.add(Expression.like("orgname", "%"+cond.getOrgname_q()+"%"));
		}	
		//上级机构层次码
		if( cond.getOrgpar()!=null && StringUtils.isEmpty(cond.getOrgparid())){
			c.add(Expression.eq("orgpar", cond.getOrgpar()));
		}
		//上级机构层次码
		if( cond.getOrgsuper()!=null && cond.getOrgsuper()!=0){
			c.add(Expression.ne("orgpar", "0"));
		}
		//上级机构层次码
		if( !StringUtils.isEmpty(cond.getOrgparstr_q())){
			c.add(Expression.like("orgsyscoding", cond.getOrgparstr_q()+"%"));
			c.add(Expression.ne("orgsyscoding", cond.getOrgparstr_q()));
		}	
		
		//树形显示用
		if( !StringUtils.isEmpty(cond.getIs_in_use())){
			c.add(Expression.eq("orgstatus", cond.getIs_in_use()));
		}	
		//上级机构层次码
		if( !StringUtils.isEmpty(cond.getOrgparid()) ){
			c.add(Expression.eq("orgpar", cond.getOrgparid()));
		}	
		
		//角色管理域显示机构名称用
		if( !StringUtils.isEmpty(cond.getOrgsyscoding())){
			c.add(Expression.eq("orgsyscoding", cond.getOrgsyscoding()));
		}
		
		//角色管理域树（资产权限控制）
		if( !StringUtils.isEmpty(cond.getRoledomain_q())){
			c.add(Expression.like("orgsyscoding", cond.getRoledomain_q()+"%"));
		}
		//角色管理域根结点的完整名称（资产权限控制）
		if( !StringUtils.isEmpty(cond.getComplete_name())){
			String syscode = cond.getComplete_name();
			c.add(Expression.ge("orgsyscoding", syscode.substring(0,4)));
			c.add(Expression.le("orgsyscoding", syscode));
		}
		
		//机构查询是否显示停用按钮
		if( !StringUtils.isEmpty(cond.getOrgsyscoding_q()) ){
			c.add(Expression.eq("orgpar", cond.getOrgsyscoding_q()));
		}	
		
		//查该结点的全名
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
