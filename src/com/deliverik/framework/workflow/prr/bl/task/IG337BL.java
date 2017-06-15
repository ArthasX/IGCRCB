/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG602Info;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG337TB;

/**
 * <p>
 * ���̲����û���Ϣҵ���߼�
 * </p>
 */
public interface IG337BL extends BaseBL {

	/**
	 * <p>
	 * ����ָ�����̵Ĵ�����Ա
	 * </p>
	 * 
	 * @param ig337Info ���̲����û���Ϣ
	 * @return ���̲����û���Ϣ
	 * @throws BLException
	 */
	
	public IG337Info registIG337Info(IG337Info ig337Info) throws BLException;
	
	/**
	 * <p>
	 * ����ָ�����̵Ĵ�����Ա
	 * </p>
	 * 
	 * @param ig337InfoList ���̲����û���Ϣ����
	 * @throws BLException
	 */
	
	public void registIG337Info(List<IG337Info> ig337InfoList) throws BLException;
	
	/**
	 * <p>
	 * ɾ��ָ�����̵Ĵ�����Ա
	 * </p>
	 * 
	 * @param ig337Info ���̲����û���Ϣ
	 * @throws BLException
	 */
	
	public void deleteIG337Info(IG337Info ig337Info) throws BLException;
	
	/**
	 * <p>
	 * ɾ��ָ�����̵Ĵ�����Ա
	 * </p>
	 * 
	 * @param ig337InfoList ���̲����û���Ϣ����
	 * @throws BLException
	 */
	
	public void deleteIG337Info(List<IG337Info> ig337InfoList) throws BLException;
	
	/**
	 * <p>
	 * �޸�ָ�����̵Ĵ�����Ա
	 * </p>
	 * 
	 * @param ig337Info ���̲����û���Ϣ
	 * @return ���̲����û���Ϣ
	 * @throws BLException
	 */
	
	public IG337Info updateIG337Info(IG337Info ig337Info) throws BLException;
	
	/**
	 * <p>
	 * ��ȡָ������״̬��δ�������̲����û�
	 * </p>
	 * 
	 * @param processId ���̼�¼ID
	 * @param status ����״̬
	 * @return δ�������̲����û�����
	 */
	
	public List<IG337Info> getIG337InfoTodoRoles(Integer processId, String status);
	
	/**
	 * <p>
	 * ��ȡָ������״̬���Ѵ������̲����û�
	 * </p>
	 * 
	 * @param processId ���̼�¼ID
	 * @param status ����״̬
	 * @return �Ѵ������̲����û�����
	 */
	
	public List<IG337Info> getIG337InfoDoneRoles(Integer processId, String status);
	
	/**
	 * <p>
	 * ��������ID��״̬��ȡָ����ɫ�Ĳ�����Ա
	 * </p>
	 * 
	 * @param processId ���̼�¼ID
	 * @param roleid ��ɫID
	 * @param status ����״̬
	 * @return ���̲����û���Ϣ
	 */
	
	public IG337Info getIG337Info(Integer processId, Integer roleid, String status);
	
	/**
	 * <p>
	 * ��������ID��״̬��ȡָ��������Ա
	 * </p>
	 * 
	 * @param processId ���̼�¼ID
	 * @param userid �û�ID
	 * @param status ����״̬
	 * @return ���̲����û���Ϣ
	 */
	
	public IG337Info getIG337Info(Integer processId, String userid, String status);

	/**
	 * <p>
	 * ��������ID��״̬��ȡָ��������Ա
	 * </p>
	 * 
	 * @param processId ���̼�¼ID
	 * @param status ����״̬
	 * @return ���̲����û���Ϣ����
	 */
	
	public List<IG337Info> getIG337Infos(Integer processId, Integer roleid, String status) throws BLException;
	
	/**
	 * <p>
	 * ���ݲ�ѯ������ȡָ��������Ա
	 * </p>
	 * 
	 * @param cond ���̲����û���Ϣ��������
	 * @return ���̲����û���Ϣ����
	 */
	
	public List<IG337Info> getIG337Infos(IG337SearchCond cond);
	
	/**
	 * <p>
	 * ��������ID��״̬��ȡδ������Ա����
	 * </p>
	 * 
	 * @param processId ���̼�¼ID
	 * @param status ����״̬
	 * @return �������
	 */
	
	public int getTodoIG337InfoCount(Integer processId, String status);
	
	/**
	 * <p>
	 * ��ȡ���̲����û�ʵ��
	 * </p>
	 * 
	 * @return ���̲����û���Ϣʵ��
	 */
	
	public IG337TB getIG337TBInstance();
	
	/**
	 * <p>
	 * ���ݲ�����ID��ȡָ����������Ϣ
	 * </p>
	 * 
	 * @param ppid ������ID
	 * @return ��������Ϣ
	 * @throws BLException 
	 */
	
	public IG337Info searchIG337InfoByKey(Integer ppid) throws BLException;
	
	/**
	 * ָ���û���������̴����ɫ��������
	 * @param userid �û�ID
	 * @param prid ����ID
	 * @return ��������б�
	 */
	public List<IG337Info> queryRolemanager(final String userid , final Integer prid);
	
	/**
	 * <p>
	 * ��ȡָ�����̵ķ�����
	 * </p>
	 * 
	 * @param processId ����ID
	 * @param openStatus ���̲����û�״̬
	 * @return ���̲����û���Ϣ
	 */
	
	public IG337Info getProcessOpener(Integer processId,String openStatus);
	
	/**
	 * ����ִ���˼�������
	 * @param userid �û�ID
	 * @param prid ����ID
	 * @return ��������б�
	 */
	public List<IG602Info> searchIG602Info(String userid, Integer prid);
	
	/**
	 * ���̿ɷ����˼�������
	 * @param roleid ��ɫID
	 * @param prid ����ID
	 * @return ��������б�
	 */
	public List<IG602Info> searchSuperAssignExecutors(Integer roleid, Integer prid);

	/**
	 * <p>
	 * ���ݲ�ѯ������ȡָ��������Ա
	 * </p>
	 * 
	 * @param cond ���̲����û���Ϣ��������
	 * @return ���̲����û���Ϣ����
	 */
	
	public List<IG337Info> searchIG337InfoRun(IG337SearchCond cond);
	
	/**
     * <p>
     * Description: ��ѯ���̲����߽����еĹ�������
     * </p>
     * 
     * @param cond ProcessParticipantSearchCond
     * @return List<ProcessParticipant>
     */
    public int searchParticipateNumberOfJobs(IG337SearchCond cond);
}
