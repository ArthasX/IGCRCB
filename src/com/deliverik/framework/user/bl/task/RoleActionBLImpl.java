package com.deliverik.framework.user.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.user.model.RoleAction;
import com.deliverik.framework.user.model.condition.RoleActionSearchCond;
import com.deliverik.framework.user.model.dao.RoleActionTBDAO;

/**
 * <p>
 * ��ɫ�˵���Ȩ��Ϣҵ���߼�ʵ��
 * </p>
 */
public class RoleActionBLImpl extends BaseBLImpl implements RoleActionBL {
	
	/** ��ɫ�˵���Ȩ��Ϣ��ز���DAO */
	
	protected RoleActionTBDAO roleActionTBDAO;

	/**
	 * ��ɫ�˵���Ȩ��Ϣ��ز���DAO�趨
	 * @param roleActionTBDAO ��ɫ�˵���Ȩ��Ϣ��ز���DAO
	 */
	
	public void setRoleActionTBDAO(RoleActionTBDAO roleActionTBDAO) {
		this.roleActionTBDAO = roleActionTBDAO;
	}
	
	/**
	 * ���ݼ�������ȡ�ý�ɫ�˵���Ȩ��Ϣ�������
	 * 
	 * @param cond ��ɫ�˵���Ȩ��Ϣ��������
	 * @return ��ɫ�˵���Ȩ��Ϣ�������
	 */
	public int getRoleActionSearchCount(RoleActionSearchCond cond){

		return roleActionTBDAO.getSearchCount(cond);
	}

	
	/**
	 * ���ݽ�ɫ�˵���Ȩ��Ϣ����ȡ�ý�ɫ�˵���Ȩ��Ϣ
	 * 
	 * @param raid ��ɫ�˵���Ȩ��Ϣ����
	 * @return ��ɫ�˵���Ȩ��Ϣ
	 * @throws BLException 
	 */
	public RoleAction searchRoleActionByKey(Integer raid) throws BLException{

		return checkExistRoleAction(raid);
	}
	
	/**
	 * ���ݼ�������ȡ�ý�ɫ�˵���Ȩ��Ϣ�б�
	 * 
	 * @param cond ��ɫ�˵���Ȩ��Ϣ��������
	 * @return ��ɫ�˵���Ȩ��Ϣ��������б�
	 */

	public List<RoleAction> searchRoleAction(RoleActionSearchCond cond){

		List<RoleAction> ret = roleActionTBDAO.findByCond(cond,0,0);
		return ret;
	}

	/**
	 * ���ݼ�������ȡ�ý�ɫ�˵���Ȩ��Ϣ�б�
	 * 
	 * @param cond ��ɫ�˵���Ȩ��Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return ��ɫ�˵���Ȩ��Ϣ��������б�
	 */
	public List<RoleAction> searchRoleAction(RoleActionSearchCond cond, int start, int count){

		List<RoleAction> ret = roleActionTBDAO.findByCond(cond,start,count);
		return ret;
	}

	/**
	 * �����ɫ�˵���Ȩ��Ϣ����
	 * 
	 * @param roleAction ����Ľ�ɫ�˵���Ȩ��Ϣ����
	 * @return ��ɫ�˵���Ȩ��Ϣ
	 * @throws BLException
	 */
	public RoleAction registRoleAction(RoleAction RoleAction) throws BLException{
		RoleAction ret = roleActionTBDAO.save(RoleAction);
		return ret;
	}

	/**
	 * �����ɫ�˵���Ȩ��Ϣ����
	 * 
	 * @param roleAction ����Ľ�ɫ�˵���Ȩ��Ϣ����
	 * @return ��ɫ�˵���Ȩ��Ϣ
	 * @throws BLException
	 */
	public RoleAction updateRoleAction(RoleAction roleAction) throws BLException{
		checkExistRoleAction(roleAction.getRaid());
		RoleAction ret = roleActionTBDAO.save(roleAction);
		return ret;
	}

	/**
	 * ɾ����ɫ�˵���Ȩ��Ϣ����
	 * 
	 * @param roleAction ɾ���Ľ�ɫ�˵���Ȩ��Ϣ����
	 * @return
	 * @throws BLException
	 */
	public void deleteRoleAction(RoleAction roleAction) throws BLException{
		checkExistRoleAction(roleAction.getRaid());
		roleActionTBDAO.delete(roleAction);
	}
	
	/**
	 * ���ݽ�ɫ�˵���Ȩ��Ϣ����ɾ����ɫ�˵���Ȩ��Ϣ����
	 * 
	 * @param raid ɾ����ɫ�˵���Ȩ��Ϣ������
	 * @return
	 * @throws BLException
	 */

	public void deleteRoleActionByKey(Integer raid) throws BLException {
		RoleAction roleAction = checkExistRoleAction(raid);
		roleActionTBDAO.delete(roleAction);
	}
	
	/**
	 * ��ɫ�˵���Ȩ��Ϣ���ڼ��
	 * 
	 * @param raid ��ɫ�˵���Ȩ��ϢID
	 * @return ��ɫ�˵���Ȩ��Ϣ
	 * @throws BLException 
	 */
	protected RoleAction checkExistRoleAction(Integer raid) throws BLException{
		RoleAction info = roleActionTBDAO.findByPK(raid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","��ɫ�˵���Ȩ");
		}
		
		return info;
	}
	
}
