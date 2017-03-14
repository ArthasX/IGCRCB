package com.deliverik.framework.user.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.user.model.RoleAction;
import com.deliverik.framework.user.model.condition.RoleActionSearchCond;

/**
 * <p>
 * ��ɫ�˵���Ȩ��Ϣҵ���߼�
 * </p>
 */
public interface RoleActionBL extends BaseBL {
	

	/**
	 * ���ݼ�������ȡ�ý�ɫ�˵���Ȩ��Ϣ����
	 * 
	 * @param cond ��ɫ�˵���Ȩ��Ϣ��������
	 * @return ��ɫ�˵���Ȩ��Ϣ����
	 */
	
	public int getRoleActionSearchCount(RoleActionSearchCond cond);

	/**
	 * ���ݽ�ɫ�˵���Ȩ��Ϣ����ȡ�ý�ɫ�˵���Ȩ��Ϣ
	 * 
	 * @param raid ��ɫ�˵���Ȩ��Ϣ����
	 * @return ��ɫ�˵���Ȩ��Ϣ
	 * @throws BLException 
	 */
	public RoleAction searchRoleActionByKey(Integer raid) throws BLException;
	
	/**
	 * ���ݼ�������ȡ�ý�ɫ�˵���Ȩ��Ϣ�б�
	 * 
	 * @param cond ��ɫ�˵���Ȩ��Ϣ��������
	 * @return ��ɫ�˵���Ȩ��Ϣ�б�
	 */
	
	public List<RoleAction> searchRoleAction(RoleActionSearchCond cond);
	
	/**
	 * ���ݼ�������ȡ�ý�ɫ�˵���Ȩ��Ϣ�б�(��ҳ��ѯ��)
	 * 
	 * @param cond ��ɫ�˵���Ȩ��Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return ��ɫ�˵���Ȩ��Ϣ�б�
	 */
	
	public List<RoleAction> searchRoleAction(RoleActionSearchCond cond, int start, int count);
	
	/**
	 * �����ɫ�˵���Ȩ��Ϣ����
	 * 
	 * @param action ����Ľ�ɫ�˵���Ȩ��Ϣ
	 * @return ������ɫ�˵���Ȩ��Ϣ
	 * @throws BLException
	 */
	public RoleAction registRoleAction(RoleAction action) throws BLException;
	
	/**
	 * ɾ����ɫ�˵���Ȩ��Ϣ����
	 * 
	 * @param action ɾ���Ľ�ɫ�˵���Ȩ��Ϣ
	 * @return
	 * @throws BLException
	 */
	public void deleteRoleAction(RoleAction action) throws BLException;
	
	/**
	 * ���ݽ�ɫ�˵���Ȩ��Ϣ����ɾ����ɫ�˵���Ȩ��Ϣ����
	 * 
	 * @param raid ɾ����ɫ�˵���Ȩ��Ϣ������
	 * @return
	 * @throws BLException
	 */
	public void deleteRoleActionByKey(Integer raid) throws BLException;

	/**
	 * �����ɫ�˵���Ȩ��Ϣ����
	 * 
	 * @param action ����Ľ�ɫ�˵���Ȩ��Ϣ
	 * @return ������ɫ�˵���Ȩ��Ϣ
	 * @throws BLException
	 */
	public RoleAction updateRoleAction(RoleAction action) throws BLException;
	
}
