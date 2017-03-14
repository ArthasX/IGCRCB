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
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.condition.RoleSearchCond;
import com.deliverik.infogovernor.sym.form.IGSYM0302Form;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_��ɫ����_DTO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSYM03DTO extends BaseDTO implements Serializable {
	
	/**
	 * ��ɫ����
	 */
	
	protected Role role;
	/**
	 * ��ɫ��ѯBean
	 */
	
	protected RoleSearchCond roleSearchCond;
	
	/**
	 * ��ɫ����List
	 */
	
	protected List<Role> roleList;

	/**
	 * �����ѯ������¼��
	 */
	
	protected int maxSearchCount;

	/**
	 * ��ҳBean
	 */
	
	protected PagingDTO pagingDto;
	
	/**
	 * ��ɫɾ������
	 */
	
	protected String[] deleteRoleid;
	
	/**
	 * ����ý�ɫ������Ϣ
	 */
	protected IGSYM0302Form igsym0302Form;
	
	/**��������*/
	private Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
	
	/**
	 * ÿ����������������
	 */
	
	protected  Map<Integer,String> completenameMap;
	
	/**
	 * ÿ���ʲ��������ݵ���������
	 */
	
	protected  Map<Integer,String> completeassetnameMap;
	
	protected String roletype;//�ʲ�����������igsym03blimpl��̨���ݲ�����
	
	protected String subtype;//�ʲ�����������igsym03blimpl��̨���ݲ�����
	
	protected String isItDrivers;
	
	/** �Ƿ���Ϊ���ڵ� 1����    0���� */
	protected String isRoot;
	
	public String getIsRoot() {
		return isRoot;
	}

	public void setIsRoot(String isRoot) {
		this.isRoot = isRoot;
	}

	public String getSubtype() {
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	public String getRoletype() {
		return roletype;
	}

	public void setRoletype(String roletype) {
		this.roletype = roletype;
	}

	public Map<Integer, String> getCompleteassetnameMap() {
		return completeassetnameMap;
	}

	public void setCompleteassetnameMap(Map<Integer, String> completeassetnameMap) {
		this.completeassetnameMap = completeassetnameMap;
	}

	public Map<Integer, String> getCompletenameMap() {
		return completenameMap;
	}

	public void setCompletenameMap(Map<Integer, String> completenameMap) {
		this.completenameMap = completenameMap;
	}

	public Map<String, TreeNode> getTreeNodeMap() {
		return treeNodeMap;
	}

	public void setTreeNodeMap(Map<String, TreeNode> treeNodeMap) {
		this.treeNodeMap = treeNodeMap;
	}

	/**
	 * ��ȡ��ɫ����
	 * @return Role
	 */
	
	public Role getRole() {
		return role;
	}

	/**
	 * ���ý�ɫ����
	 * @param role Role
	 */
	
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * ��ȡ��ɫ��ѯBean
	 * @return RoleSearchCond
	 */
	
	public RoleSearchCond getRoleSearchCond() {
		return roleSearchCond;
	}

	/**
	 * ���ý�ɫ��ѯBean
	 * @param roleSearchCond RoleSearchCond
	 */
	
	public void setRoleSearchCond(
			RoleSearchCond roleSearchCond) {
		this.roleSearchCond = roleSearchCond;
	}

	/**
	 * ��ȡ��ɫ����List
	 * @return List<Role>
	 */
	
	public List<Role> getRoleList() {
		return roleList;
	}

	/**
	 * ���ý�ɫ����List
	 * @param roleList List<Role>
	 */
	
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
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
	 * ��ȡ��ɫɾ������
	 * @return String[]
	 */
	
	public String[] getDeleteRoleid() {
		return deleteRoleid;
	}

	/**
	 * ���ý�ɫɾ������
	 * @param deleteRoleid String[]
	 */
	
	public void setDeleteRoleid(String[] deleteRoleid) {
		this.deleteRoleid = deleteRoleid;
	}

	/**
	 * ��ȡ����ý�ɫ������Ϣ
	 * @return IGSYM0302Form
	 */
	
	public IGSYM0302Form getIgsym0302Form() {
		return igsym0302Form;
	}

	/**
	 * ���ñ���ý�ɫ������Ϣ
	 * @return igsym0302Form IGSYM0302Form
	 */
	
	public void setIgsym0302Form(IGSYM0302Form igsym0302Form) {
		this.igsym0302Form = igsym0302Form;
	}

	public String getIsItDrivers() {
		return isItDrivers;
	}

	public void setIsItDrivers(String isItDrivers) {
		this.isItDrivers = isItDrivers;
	}

}
