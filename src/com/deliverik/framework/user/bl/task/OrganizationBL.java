package com.deliverik.framework.user.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.condition.OrganizationSearchCond;

/**
 * <p>
 * ������Ϣҵ���߼�
 * </p>
 */

public interface OrganizationBL extends BaseBL {

	/**
	 * ���ݼ�������ȡ�û�����Ϣ����
	 * 
	 * @param cond ������Ϣ��������
	 * @return ������Ϣ����
	 */
	
	public int getOrganizationSearchCount(OrganizationSearchCond cond);

	/**
	 * ���ݻ�����Ϣ����ȡ�û�����Ϣ
	 * 
	 * @param orgid ������Ϣ����
	 * @return ������Ϣ
	 * @throws BLException 
	 */
	public Organization searchOrganizationByKey(Integer orgid) throws BLException;
	
	/**
	 * ���ݼ�������ȡ�û�����Ϣ�б�
	 * 
	 * @param cond ������Ϣ��������
	 * @return ������Ϣ�б�
	 */
	
	public List<Organization> searchOrganization(OrganizationSearchCond cond);
	
	/**
	 * ���ݼ�������ȡ�û�����Ϣ�б�(��ҳ��ѯ��)
	 * 
	 * @param cond ������Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return ������Ϣ�б�
	 */
	public List<Organization> searchOrganization(OrganizationSearchCond cond, int start, int count);
	
	/**
	 * ����������������ƽ̨������
	 * @param cond ��������
	 * @param orgsyscoding ���������
	 * @return ��������б�
	 */
	public List<Organization> searchOrganization(OrganizationSearchCond cond,String orgsyscoding);
	
	/**
	 * ���������Ϣ����
	 * 
	 * @param organization ����Ļ�����Ϣ
	 * @return ����������Ϣ
	 * @throws BLException
	 */
	public Organization registOrganization(Organization organization) throws BLException;
	
	/**
	 * ɾ��������Ϣ����
	 * 
	 * @param organization ɾ���Ļ�����Ϣ
	 * @return
	 * @throws BLException
	 */
	public void deleteOrganization(Organization organization) throws BLException;
	
	/**
	 * ���ݻ�����Ϣ����ɾ��������Ϣ����
	 * 
	 * @param orgid ɾ��������Ϣ������
	 * @return
	 * @throws BLException
	 */
	public void deleteOrganizationByKey(Integer orgid) throws BLException;


	/**
	 * ���������Ϣ����
	 * 
	 * @param organization ����Ļ�����Ϣ
	 * @return ����������Ϣ
	 * @throws BLException
	 */
	public Organization updateOrganization(Organization organization) throws BLException;

}
