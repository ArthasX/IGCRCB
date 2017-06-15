package com.deliverik.framework.user.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.condition.OrganizationSearchCond;
import com.deliverik.framework.user.model.dao.OrganizationTBDAO;

/**
 * <p>
 * ������Ϣҵ���߼�ʵ��
 * </p>
 */
public class OrganizationBLImpl extends BaseBLImpl implements OrganizationBL {
	
	/** ������Ϣ��ز���DAO */
	protected OrganizationTBDAO organizationTBDAO;

	/**
	 * ������Ϣ��ز���DAO�趨
	 * @param organizationTBDAO ������Ϣ��ز���DAO
	 */
	public void setOrganizationTBDAO(OrganizationTBDAO organizationTBDAO) {
		this.organizationTBDAO = organizationTBDAO;
	}
	
	/**
	 * ���ݼ�������ȡ�û�����Ϣ�������
	 * 
	 * @param cond ������Ϣ��������
	 * @return ������Ϣ�������
	 */
	public int getOrganizationSearchCount(OrganizationSearchCond cond){

		return organizationTBDAO.getSearchCount(cond);
	}

	
	/**
	 * ���ݻ�����Ϣ����ȡ�û�����Ϣ
	 * 
	 * @param orgid ������Ϣ����
	 * @return ������Ϣ
	 * @throws BLException 
	 */
	public Organization searchOrganizationByKey(Integer orgid) throws BLException{

		return checkExistOrganization(orgid);
	}
	
	/**
	 * ���ݼ�������ȡ�û�����Ϣ�б�
	 * 
	 * @param cond ������Ϣ��������
	 * @return ������Ϣ��������б�
	 */

	public List<Organization> searchOrganization(OrganizationSearchCond cond){

		List<Organization> ret = organizationTBDAO.findByCond(cond,0,0);
		return ret;
	}

	/**
	 * ���ݼ�������ȡ�û�����Ϣ�б�
	 * 
	 * @param cond ������Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return ������Ϣ��������б�
	 */
	public List<Organization> searchOrganization(OrganizationSearchCond cond, int start, int count){

		List<Organization> ret = organizationTBDAO.findByCond(cond,start,count);
		return ret;
	}
	
	/**
	 * ���������������������¼��ã�ƽ̨������
	 * @param cond ��������
	 * @param orgsyscoding ���������
	 * @return ��������б�
	 */
	public List<Organization> searchOrganization(OrganizationSearchCond cond,String orgsyscoding){
		List<Organization> ret = organizationTBDAO.findByCond(cond,orgsyscoding);
		return ret;
	}

	/**
	 * ���������Ϣ����
	 * 
	 * @param organization ����Ļ�����Ϣ����
	 * @return ������Ϣ
	 * @throws BLException
	 */
	public Organization registOrganization(Organization Organization) throws BLException{
		Organization ret = organizationTBDAO.save(Organization);
		return ret;
	}

	/**
	 * ���������Ϣ����
	 * 
	 * @param organization ����Ļ�����Ϣ����
	 * @return ������Ϣ
	 * @throws BLException
	 */
	public Organization updateOrganization(Organization organization) throws BLException{
		checkExistOrganization(organization.getOrgid());
		Organization ret = organizationTBDAO.save(organization);
		return ret;
	}

	/**
	 * ɾ��������Ϣ����
	 * 
	 * @param organization ɾ���Ļ�����Ϣ����
	 * @return
	 * @throws BLException
	 */
	public void deleteOrganization(Organization organization) throws BLException{
		checkExistOrganization(organization.getOrgid());
		organizationTBDAO.delete(organization);
	}
	
	/**
	 * ���ݻ�����Ϣ����ɾ��������Ϣ����
	 * 
	 * @param orgid ɾ��������Ϣ������
	 * @return
	 * @throws BLException
	 */

	public void deleteOrganizationByKey(Integer orgid) throws BLException {
		Organization organization = checkExistOrganization(orgid);
		organizationTBDAO.delete(organization);
		
	}
	
	/**
	 * ������Ϣ���ڼ��
	 * 
	 * @param orgid ������ϢID
	 * @return ������Ϣ
	 * @throws BLException 
	 */
	protected Organization checkExistOrganization(Integer orgid) throws BLException{
		Organization info = organizationTBDAO.findByPK(orgid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","����");
		}
		
		return info;
	}

}
