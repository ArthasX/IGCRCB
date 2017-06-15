package com.deliverik.framework.user.bl.task;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.user.model.Action;
import com.deliverik.framework.user.model.condition.ActionSearchCond;
import com.deliverik.framework.user.model.dao.ActionTBDAO;

/**
 * <p>
 * �˵���Ϣҵ���߼�ʵ��
 * </p>
 */
public class ActionBLImpl extends BaseBLImpl implements ActionBL {
	
	/** �˵���Ϣ��ز���DAO */
	
	protected ActionTBDAO actionTBDAO;

	/**
	 * �˵���Ϣ��ز���DAO�趨
	 * @param actionTBDAO �˵���Ϣ��ز���DAO
	 */
	
	public void setActionTBDAO(ActionTBDAO actionTBDAO) {
		this.actionTBDAO = actionTBDAO;
	}
	
	/**
	 * ���ݼ�������ȡ�ò˵���Ϣ�������
	 * 
	 * @param cond �˵���Ϣ��������
	 * @return �˵���Ϣ�������
	 */
	public int getActionSearchCount(ActionSearchCond cond){

		return actionTBDAO.getSearchCount(cond);
	}

	
	/**
	 * ���ݲ˵���Ϣ����ȡ�ò˵���Ϣ
	 * 
	 * @param actname �˵���Ϣ����
	 * @return �˵���Ϣ
	 * @throws BLException 
	 */
	public Action searchActionByKey(String actname) throws BLException{

		return checkExistAction(actname);
	}
	
	/**
	 * ���ݼ�������ȡ�ò˵���Ϣ�б�
	 * 
	 * @param cond �˵���Ϣ��������
	 * @return �˵���Ϣ��������б�
	 */

	public List<Action> searchAction(ActionSearchCond cond){

		List<Action> ret = actionTBDAO.findByCond(cond,0,0);
		return ret;
	}

	/**
	 * ���ݼ�������ȡ�ò˵���Ϣ�б�
	 * 
	 * @param cond �˵���Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �˵���Ϣ��������б�
	 */
	public List<Action> searchAction(ActionSearchCond cond, int start, int count){

		List<Action> ret = actionTBDAO.findByCond(cond,start,count);
		return ret;
	}

	/**
	 * ����˵���Ϣ����
	 * 
	 * @param action ����Ĳ˵���Ϣ����
	 * @return �˵���Ϣ
	 * @throws BLException
	 */
	public Action registAction(Action Action) throws BLException{
		Action ret = actionTBDAO.save(Action);
		return ret;
	}

	/**
	 * ����˵���Ϣ����
	 * 
	 * @param action ����Ĳ˵���Ϣ����
	 * @return �˵���Ϣ
	 * @throws BLException
	 */
	public Action updateAction(Action action) throws BLException{
		checkExistAction(action.getActname());
		Action ret = actionTBDAO.save(action);
		return ret;
	}

	/**
	 * ɾ���˵���Ϣ����
	 * 
	 * @param action ɾ���Ĳ˵���Ϣ����
	 * @return
	 * @throws BLException
	 */
	public void deleteAction(Action action) throws BLException{
		checkExistAction(action.getActname());
		actionTBDAO.delete(action);
	}
	
	/**
	 * ���ݲ˵���Ϣ����ɾ���˵���Ϣ����
	 * 
	 * @param actname ɾ���˵���Ϣ������
	 * @return
	 * @throws BLException
	 */

	public void deleteActionByKey(String actname) throws BLException {
		Action action = checkExistAction(actname);
		actionTBDAO.delete(action);
	}
	
	/**
	 * �˵���Ϣ���ڼ��
	 * 
	 * @param actname �˵���ϢID
	 * @return �˵���Ϣ
	 * @throws BLException 
	 */
	protected Action checkExistAction(String actname) throws BLException{
		Action info = actionTBDAO.findByPK(actname);
		if( info == null) {
			throw new BLException("IGCO10000.E004","�˵�����");
		}
		
		return info;
	}
	
	/**
	 * ��ѯ�û��˵�Ȩ��
	 * @param userid �û�ID
	 * @return �û��˵�Ȩ��
	 */
	public List<Action> searchUserAction(String userid) {
		return actionTBDAO.findUserAction(userid);
	}
	
	/**
     * һ���˵�����ֵȡ��
     * 
     * @param �˵�ID
     * @return �Ӳ˵�����ֵ
     */
    public String getActnameNextValue(String parActname) {
        if (!StringUtils.isEmpty(parActname)) {
            return actionTBDAO.getActnameNextValue(parActname);
        } else {
            return "";
        }
    }
}
