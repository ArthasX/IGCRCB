/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.dto;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.condition.OrganizationSearchCond;
import com.deliverik.infogovernor.sym.form.IGSYM0101Form;
import com.deliverik.infogovernor.sym.form.IGSYM0102Form;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_��������_DTO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class IGSYM01DTO extends BaseDTO implements Serializable {
	
	/**
	 * ��������
	 */
	
	protected Organization organization;
	/**
	 * ������ѯBean
	 */
	
	protected OrganizationSearchCond organizationSearchCond;
	
	/**
	 * ��������List
	 */
	
	protected List<Organization> organizationCondList;
	
	/**
	 * ��������List�������б��ã�
	 */
	
	protected List<Organization> organizationList;

	/**
	 * �����ѯ������¼��
	 */
	
	protected int maxSearchCount;

	/**
	 * ��ҳBean
	 */
	
	protected PagingDTO pagingDto;
	
	/**
	 * ����ɾ������
	 */
	
	protected String[] deleteOrgid;
	/**
	 * ����״̬�仯����
	 */
	
	protected  Integer changeOrgid;
	
	/**
	 * ÿ����������������
	 */
	
	protected  Map<Integer,String> completenameMap;
	
	/**
	 * ÿ�������Ƿ���ʾͣ�ð�ť
	 */
	
	protected  Map<Integer,String> buttonMap;
	
	/**
	 * ÿ�������Ƿ���ʾ���ð�ť
	 */
	
	protected  Map<Integer,String> startbuttonMap;
	
	

	public Map<Integer, String> getStartbuttonMap() {
		return startbuttonMap;
	}

	public void setStartbuttonMap(Map<Integer, String> startbuttonMap) {
		this.startbuttonMap = startbuttonMap;
	}

	public Map<Integer, String> getButtonMap() {
		return buttonMap;
	}

	public void setButtonMap(Map<Integer, String> buttonMap) {
		this.buttonMap = buttonMap;
	}

	public Map<Integer, String> getCompletenameMap() {
		return completenameMap;
	}

	public void setCompletenameMap(Map<Integer, String> completenameMap) {
		this.completenameMap = completenameMap;
	}

	public Integer getChangeOrgid() {
		return changeOrgid;
	}

	public void setChangeOrgid(Integer changeOrgid) {
		this.changeOrgid = changeOrgid;
	}

	/**
	 * ����û���������Ϣ
	 */
	protected IGSYM0102Form igsym0102Form;
	
	/**
	 * ����û���������Ϣ
	 */
	protected IGSYM0101Form igsym0101Form;
	
	
	/**������*/
	private Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
	
	
	

	public IGSYM0101Form getIgsym0101Form() {
		return igsym0101Form;
	}

	public void setIgsym0101Form(IGSYM0101Form igsym0101Form) {
		this.igsym0101Form = igsym0101Form;
	}

	public Map<String, TreeNode> getTreeNodeMap() {
		return treeNodeMap;
	}

	public void setTreeNodeMap(Map<String, TreeNode> treeNodeMap) {
		this.treeNodeMap = treeNodeMap;
	}

	/**
	 * ��ȡ��������
	 * @return Organization
	 */
	
	public Organization getOrganization() {
		return organization;
	}

	/**
	 * ���û�������
	 * @param organization Organization
	 */
	
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	/**
	 * ��ȡ������ѯBean
	 * @return OrganizationSearchCond
	 */
	
	public OrganizationSearchCond getOrganizationSearchCond() {
		return organizationSearchCond;
	}

	/**
	 * ���û�����ѯBean
	 * @param organizationSearchCond OrganizationSearchCond
	 */
	
	public void setOrganizationSearchCond(
			OrganizationSearchCond organizationSearchCond) {
		this.organizationSearchCond = organizationSearchCond;
	}

	/**
	 * ��ȡ��������List
	 * @return List<Organization>
	 */
	
	public List<Organization> getOrganizationCondList() {
		return organizationCondList;
	}
	
	/**
	 * ��ȡ��������List�������б��ã�
	 * @return List<Organization>
	 */
	
	public List<Organization> getOrganizationList() {
		return organizationList;
	}

	/**
	 * ���û�������List
	 * @param organizationCondList List<Organization>
	 */
	
	public void setOrganizationCondList(List<Organization> organizationCondList) {
		this.organizationCondList = organizationCondList;
	}
	
	/**
	 * ���û�������List�������б��ã�
	 * @param organizationList List<Organization>
	 */
	
	public void setOrganizationList(List<Organization> organizationList) {
		this.organizationList = organizationList;
	}
	
	/**
	 * ��ȡ�����ѯ������¼��
	 * @return int
	 */
	
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * ���������ѯ������¼��
	 * @param maxSearchCount int
	 */
	
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * ��ȡ��ҳBean
	 * @return PagingDTO
	 */
	
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * ���÷�ҳBean
	 * @param pagingDto PagingDTO
	 */
	
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * ��ȡ����ɾ������
	 * @return String[]
	 */
	
	public String[] getDeleteOrgid() {
		return deleteOrgid;
	}

	/**
	 * ���û���ɾ������
	 * @param deleteOrgid String[]
	 */
	
	public void setDeleteOrgid(String[] deleteOrgid) {
		this.deleteOrgid = deleteOrgid;
	}

	/**
	 * ��ȡ����û���������Ϣ
	 * @return IGSYM0102Form
	 */
	
	public IGSYM0102Form getIgsym0102Form() {
		return igsym0102Form;
	}

	/**
	 * ���ñ���û���������Ϣ
	 * @return igsym0102Form IGSYM0102Form
	 */
	
	public void setIgsym0102Form(IGSYM0102Form igsym0102Form) {
		this.igsym0102Form = igsym0102Form;
	}

}
