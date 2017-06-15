package com.deliverik.framework.user.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.user.model.Action;
import com.deliverik.framework.user.model.condition.ActionSearchCond;

/**
 * <p>
 * �˵���Ϣҵ���߼�
 * </p>
 */
public interface ActionBL extends BaseBL {
	
	/**
	 * ���ݼ�������ȡ�ò˵���Ϣ����
	 * 
	 * @param cond �˵���Ϣ��������
	 * @return �˵���Ϣ����
	 */
	
	public int getActionSearchCount(ActionSearchCond cond);

	/**
	 * ���ݲ˵���Ϣ����ȡ�ò˵���Ϣ
	 * 
	 * @param actname �˵���Ϣ����
	 * @return �˵���Ϣ
	 * @throws BLException 
	 */
	public Action searchActionByKey(String actname) throws BLException;
	
	/**
	 * ���ݼ�������ȡ�ò˵���Ϣ�б�
	 * 
	 * @param cond �˵���Ϣ��������
	 * @return �˵���Ϣ�б�
	 */
	
	public List<Action> searchAction(ActionSearchCond cond);
	
	/**
	 * ���ݼ�������ȡ�ò˵���Ϣ�б�(��ҳ��ѯ��)
	 * 
	 * @param cond �˵���Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �˵���Ϣ�б�
	 */
	
	public List<Action> searchAction(ActionSearchCond cond, int start, int count);
	
	/**
	 * ����˵���Ϣ����
	 * 
	 * @param action ����Ĳ˵���Ϣ
	 * @return �����˵���Ϣ
	 * @throws BLException
	 */
	public Action registAction(Action action) throws BLException;
	
	/**
	 * ɾ���˵���Ϣ����
	 * 
	 * @param action ɾ���Ĳ˵���Ϣ
	 * @return
	 * @throws BLException
	 */
	public void deleteAction(Action action) throws BLException;
	
	/**
	 * ���ݲ˵���Ϣ����ɾ���˵���Ϣ����
	 * 
	 * @param actname ɾ���˵���Ϣ������
	 * @return
	 * @throws BLException
	 */
	public void deleteActionByKey(String actname) throws BLException;


	/**
	 * ����˵���Ϣ����
	 * 
	 * @param action ����˵���Ϣ
	 * @return �����˵���Ϣ
	 * @throws BLException
	 */
	public Action updateAction(Action action) throws BLException;
	
	/**
	 * ��ѯ�û��˵�Ȩ��
	 * @param userid �û�ID
	 * @return �û��˵�Ȩ��
	 */
	public List<Action> searchUserAction(String userid);
	
	/**
     * һ���˵�����ֵȡ��
     * 
     * @param �˵�ID
     * @return �Ӳ˵�����ֵ
     */
    public String getActnameNextValue(String parActname);
}
