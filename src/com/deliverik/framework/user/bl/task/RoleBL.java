package com.deliverik.framework.user.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.condition.RoleSearchCond;

/**
 * <p>
 * ��ɫ��Ϣҵ���߼�
 * </p>
 */
public interface RoleBL extends BaseBL {
	
	/**
	 * ���ݼ�������ȡ�ý�ɫ��Ϣ����
	 * 
	 * @param cond ��ɫ��Ϣ��������
	 * @return ��ɫ��Ϣ����
	 */
	
	public int getRoleSearchCount(RoleSearchCond cond);

	/**
	 * ���ݽ�ɫ��Ϣ����ȡ�ý�ɫ��Ϣ
	 * 
	 * @param roleid ��ɫ��Ϣ����
	 * @return ��ɫ��Ϣ
	 * @throws BLException 
	 */
	public Role searchRoleByKey(Integer roleid) throws BLException;
	
	/**
	 * ���ݼ�������ȡ�ý�ɫ��Ϣ�б�
	 * 
	 * @param cond ��ɫ��Ϣ��������
	 * @return ��ɫ��Ϣ�б�
	 */
	
	public List<Role> searchRole(RoleSearchCond cond);
	
	/**
	 * ���ݼ�������ȡ�ý�ɫ��Ϣ�б�(��ҳ��ѯ��)
	 * 
	 * @param cond ��ɫ��Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return ��ɫ��Ϣ�б�
	 */
	
	public List<Role> searchRole(RoleSearchCond cond, int start, int count);
	
	/**
	 * �����ɫ��Ϣ����
	 * 
	 * @param role ����Ľ�ɫ��Ϣ����
	 * @return ��ɫ��Ϣ
	 * @throws BLException
	 */
	public Role registRole(Role role) throws BLException;
	
	/**
	 * ɾ����ɫ��Ϣ����
	 * 
	 * @param role ɾ���Ľ�ɫ��Ϣ����
	 * @return
	 * @throws BLException
	 */
	public void deleteRole(Role role) throws BLException;
	
	/**
	 * ���ݽ�ɫ��Ϣ����ɾ����ɫ��Ϣ����
	 * 
	 * @param roleid ɾ����ɫ��Ϣ������
	 * @return
	 * @throws BLException
	 */
	public void deleteRoleByKey(Integer roleid) throws BLException;


	/**
	 * �����ɫ��Ϣ����
	 * 
	 * @param role ����Ľ�ɫ��Ϣ����
	 * @return ��ɫ��Ϣ
	 * @throws BLException
	 */
	public Role updateRole(Role role) throws BLException;
	
	/**
	 * ���̹���Ա��ɫ�ж�
	 * 
	 * @param roleid ��ɫ��ϢID
	 * @return true:��,false:��
	 * @throws BLException 
	 *
	 */
	
	public boolean isProcessAdminRole(Integer roleid) throws BLException;
	
	/**
	 * ���̷����߽�ɫ�ж�
	 * 
	 * @param roleid ��ɫ��ϢID
	 * @return true:��,false:��
	 * @throws BLException 
	 *
	 */
	
	public boolean isProcessDispatchRole(Integer roleid) throws BLException;
	
	/**
	 * ָ����ɫ��������Χ�����̽�ɫȡ�ã����ݲ���flag�ж��Ƿ�������̹���Ա
	 * true:��,false:��
	 * @param roleid ��ɫ��ϢID
	 * @param flag �Ƿ�������̹���Ա
	 * @return ��ɫ��Ϣ�б�
	 *
	 */
	
	public List<Role> getRoleDomain(Integer roleid, boolean flag) throws BLException;
	
	/**
	 * <p>
	 * ��ȡϵͳ�п��Է��ɵĽ�ɫ���ϣ��Ȳ���ϵͳ�е����̹����ɫ
	 * </p>
	 * 
	 * @return ���Է��ɵĽ�ɫ����
	 *
	 */

	public List<Role> getRolesNotInProcess();
	
	/**
	 * <p>
	 * ��ȡָ���Ľ�ɫ
	 * </p>
	 * 
	 * @param roleId ��ɫID
	 * @return ָ���Ľ�ɫ����
	 * @throws BLException
	 *
	 */
	
	public Role getRole(Integer roleId) throws BLException;
	
	/**
	 * <p>
	 * ��ȡָ�����͵Ľ�ɫ
	 * </p>
	 * 
	 * @param roletype ��ɫ����
	 * @return ָ���Ľ�ɫ����
	 *
	 */

	public List<Role> getRoleByType(String roletype);
	
	/**
	 * <p>
	 * ��ȡϵͳ�е�������ɫ
	 * </p>
	 * 
	 * @return ϵͳ�е�������ɫ����
	 *
	 */

	public List<Role> getApproveRoles();
	
	/**
	 * ���ݼ�������ȡ�ý�ɫ��Ϣ�������(�Զ������̷���ʱ��ѯ������֧�ֵĽ�ɫʹ��)
	 * 
	 * @param cond ��ɫ��Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return ��ɫ��Ϣ��������б�
	 */
	public int searchRoleCountForSelfDef(RoleSearchCond cond);
	
	
	/**
	 * ���ݼ�������ȡ�ý�ɫ��Ϣ�б�(�Զ������̷���ʱ��ѯ������֧�ֵĽ�ɫʹ��)
	 * 
	 * @param cond ��ɫ��Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return ��ɫ��Ϣ��������б�
	 */
	public List<Role> searchRoleForSelfDef(RoleSearchCond cond, int start, int count);
}
