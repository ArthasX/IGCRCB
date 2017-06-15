package com.deliverik.framework.user.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.condition.OrganizationSearchCond;
import com.deliverik.framework.user.model.dao.OrganizationTBDAO;

/**
 * <p>
 * 机构信息业务逻辑实现
 * </p>
 */
public class OrganizationBLImpl extends BaseBLImpl implements OrganizationBL {
	
	/** 机构信息相关操作DAO */
	protected OrganizationTBDAO organizationTBDAO;

	/**
	 * 机构信息相关操作DAO设定
	 * @param organizationTBDAO 机构信息相关操作DAO
	 */
	public void setOrganizationTBDAO(OrganizationTBDAO organizationTBDAO) {
		this.organizationTBDAO = organizationTBDAO;
	}
	
	/**
	 * 根据检索条件取得机构信息结果条数
	 * 
	 * @param cond 机构信息检索条件
	 * @return 机构信息结果条数
	 */
	public int getOrganizationSearchCount(OrganizationSearchCond cond){

		return organizationTBDAO.getSearchCount(cond);
	}

	
	/**
	 * 根据机构信息主键取得机构信息
	 * 
	 * @param orgid 机构信息主键
	 * @return 机构信息
	 * @throws BLException 
	 */
	public Organization searchOrganizationByKey(Integer orgid) throws BLException{

		return checkExistOrganization(orgid);
	}
	
	/**
	 * 根据检索条件取得机构信息列表
	 * 
	 * @param cond 机构信息检索条件
	 * @return 机构信息检索结果列表
	 */

	public List<Organization> searchOrganization(OrganizationSearchCond cond){

		List<Organization> ret = organizationTBDAO.findByCond(cond,0,0);
		return ret;
	}

	/**
	 * 根据检索条件取得机构信息列表
	 * 
	 * @param cond 机构信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 机构信息检索结果列表
	 */
	public List<Organization> searchOrganization(OrganizationSearchCond cond, int start, int count){

		List<Organization> ret = organizationTBDAO.findByCond(cond,start,count);
		return ret;
	}
	
	/**
	 * 条件检索处理，新增机构下级用（平台保留）
	 * @param cond 检索条件
	 * @param orgsyscoding 机构层次码
	 * @return 检索结果列表
	 */
	public List<Organization> searchOrganization(OrganizationSearchCond cond,String orgsyscoding){
		List<Organization> ret = organizationTBDAO.findByCond(cond,orgsyscoding);
		return ret;
	}

	/**
	 * 保存机构信息处理
	 * 
	 * @param organization 保存的机构信息数据
	 * @return 机构信息
	 * @throws BLException
	 */
	public Organization registOrganization(Organization Organization) throws BLException{
		Organization ret = organizationTBDAO.save(Organization);
		return ret;
	}

	/**
	 * 变更机构信息处理
	 * 
	 * @param organization 变更的机构信息数据
	 * @return 机构信息
	 * @throws BLException
	 */
	public Organization updateOrganization(Organization organization) throws BLException{
		checkExistOrganization(organization.getOrgid());
		Organization ret = organizationTBDAO.save(organization);
		return ret;
	}

	/**
	 * 删除机构信息处理
	 * 
	 * @param organization 删除的机构信息数据
	 * @return
	 * @throws BLException
	 */
	public void deleteOrganization(Organization organization) throws BLException{
		checkExistOrganization(organization.getOrgid());
		organizationTBDAO.delete(organization);
	}
	
	/**
	 * 根据机构信息主键删除机构信息处理
	 * 
	 * @param orgid 删除机构信息的主键
	 * @return
	 * @throws BLException
	 */

	public void deleteOrganizationByKey(Integer orgid) throws BLException {
		Organization organization = checkExistOrganization(orgid);
		organizationTBDAO.delete(organization);
		
	}
	
	/**
	 * 机构信息存在检查
	 * 
	 * @param orgid 机构信息ID
	 * @return 机构信息
	 * @throws BLException 
	 */
	protected Organization checkExistOrganization(Integer orgid) throws BLException{
		Organization info = organizationTBDAO.findByPK(orgid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","机构");
		}
		
		return info;
	}

}
