package com.deliverik.framework.user.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.condition.OrganizationSearchCond;

/**
 * <p>
 * 机构信息业务逻辑
 * </p>
 */

public interface OrganizationBL extends BaseBL {

	/**
	 * 根据检索条件取得机构信息条数
	 * 
	 * @param cond 机构信息检索条件
	 * @return 机构信息条数
	 */
	
	public int getOrganizationSearchCount(OrganizationSearchCond cond);

	/**
	 * 根据机构信息主键取得机构信息
	 * 
	 * @param orgid 机构信息主键
	 * @return 机构信息
	 * @throws BLException 
	 */
	public Organization searchOrganizationByKey(Integer orgid) throws BLException;
	
	/**
	 * 根据检索条件取得机构信息列表
	 * 
	 * @param cond 机构信息检索条件
	 * @return 机构信息列表
	 */
	
	public List<Organization> searchOrganization(OrganizationSearchCond cond);
	
	/**
	 * 根据检索条件取得机构信息列表(分页查询用)
	 * 
	 * @param cond 机构信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 机构信息列表
	 */
	public List<Organization> searchOrganization(OrganizationSearchCond cond, int start, int count);
	
	/**
	 * 机构条件检索处理（平台保留）
	 * @param cond 检索条件
	 * @param orgsyscoding 机构层次码
	 * @return 检索结果列表
	 */
	public List<Organization> searchOrganization(OrganizationSearchCond cond,String orgsyscoding);
	
	/**
	 * 保存机构信息处理
	 * 
	 * @param organization 保存的机构信息
	 * @return 保存后机构信息
	 * @throws BLException
	 */
	public Organization registOrganization(Organization organization) throws BLException;
	
	/**
	 * 删除机构信息处理
	 * 
	 * @param organization 删除的机构信息
	 * @return
	 * @throws BLException
	 */
	public void deleteOrganization(Organization organization) throws BLException;
	
	/**
	 * 根据机构信息主键删除机构信息处理
	 * 
	 * @param orgid 删除机构信息的主键
	 * @return
	 * @throws BLException
	 */
	public void deleteOrganizationByKey(Integer orgid) throws BLException;


	/**
	 * 变更机构信息处理
	 * 
	 * @param organization 变更的机构信息
	 * @return 变更后机构信息
	 * @throws BLException
	 */
	public Organization updateOrganization(Organization organization) throws BLException;

}
