/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.framework.workflow;

import java.util.List;
import java.util.Map;

import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.RoleSearchCond;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBean;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG731Info;
import com.deliverik.framework.workflow.prd.model.IG893Info;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG731SearchCond;
import com.deliverik.framework.workflow.prr.model.CurrentMonthWorkVWInfo;
import com.deliverik.framework.workflow.prr.model.IG036Info;
import com.deliverik.framework.workflow.prr.model.IG113Info;
import com.deliverik.framework.workflow.prr.model.IG224Info;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG463Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG500ONLYInfo;
import com.deliverik.framework.workflow.prr.model.IG505Info;
import com.deliverik.framework.workflow.prr.model.IG506Info;
import com.deliverik.framework.workflow.prr.model.IG512Info;
import com.deliverik.framework.workflow.prr.model.IG561Info;
import com.deliverik.framework.workflow.prr.model.IG561VWInfo;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.IG602Info;
import com.deliverik.framework.workflow.prr.model.IG677Info;
import com.deliverik.framework.workflow.prr.model.IG711Info;
import com.deliverik.framework.workflow.prr.model.IG715Info;
import com.deliverik.framework.workflow.prr.model.IG898Info;
import com.deliverik.framework.workflow.prr.model.IG899Info;
import com.deliverik.framework.workflow.prr.model.IG933Info;
import com.deliverik.framework.workflow.prr.model.condition.CurrentMonthWorkVWSearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG036SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG113SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG224SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG463SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG512SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG561SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG677SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG711SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG898SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG899SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG036TB;
import com.deliverik.framework.workflow.prr.model.entity.IG337TB;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;
import com.deliverik.framework.workflow.prr.model.entity.IG506TB;
import com.deliverik.framework.workflow.prr.model.entity.IG512TB;
import com.deliverik.framework.workflow.prr.model.entity.IG599TB;
import com.deliverik.framework.workflow.prr.model.entity.IG898PK;

/**
 * <p>
 * ���̴���ҵ���߼�
 * </p>
 * 
 */

public interface WorkFlowOperationBL extends BaseBL{
	
	
	/**
	 * <p>
	 * ������Ϣ����ʵ��ȡ��
	 * <p>
	 * 
	 * @return ������Ϣ����ʵ��
	 */
	public IG500TB getProcessRecordTBInstance();
	
	/**
	 * <p>
	 * ���̱�����Ϣ����ʵ��ȡ��
	 * <p>
	 * 
	 * @return ���̱�����Ϣ����ʵ��
	 */
	public IG599TB getProcessInfoTBInstance();

	/**
	 * <p>
	 * ��������Ϣ����ʵ��ȡ��
	 * <p>
	 * 
	 * @return ��������Ϣ����ʵ��
	 */
	public IG337TB getProcessParticipantTBInstance();

	/**
	 * <p>
	 * ��־��Ϣ����ʵ��ȡ��
	 * <p>
	 * 
	 * @return ��־��Ϣ����ʵ��
	 */
	public IG036TB getRecordLogTBInstance();
	
	/**
	 * <p>
	 * �µ����̹�ϵ��Ϣ����ʵ��ȡ��
	 * <p>
	 * 
	 * @return �µ����̹�ϵ��Ϣ����ʵ��ȡ��
	 */
	
	public IG512TB getProcessRecordRelationTBInstance();
	
	
	/**
	 * <p>
	 * ���̷���
	 * </p>
	 * 
	 * @param processRecord ������Ϣ
	 * @param user ��ǰ��¼�û�
	 * @param roleid �����ɫID
	 * @param comment ��־����
	 * @param desc ��־����������Ϣ
	 * @param filemap ����
	 * @return ������Ϣ
	 * @throws BLException
	 *
	 */
	public IG500Info createProcessRecord(IG500Info processRecord, User user, Integer roleid,
			String comment, String desc, Map<Integer, FormFile> filemap, String type, String pbdid, String prstatus)
			throws BLException;

	/**
	 * <p>
	 * ���̷���
	 * </p>
	 * 
	 * @param processRecord ������Ϣ
	 * @param participantList ���̲�������Ϣ
	 * @param processInfoList ���̱�����Ϣ
	 * @param user ��ǰ��¼�û�
	 * @param roleid �����ɫID
	 * @param comment ��־����
	 * @param desc ��־����������Ϣ
	 * @param filemap ����
	 * @return ������Ϣ
	 * @throws BLException
	 *
	 */
	public IG500Info createProcessRecord(IG500Info processRecord, List<IG337Info> participantList,
			List<IG599Info> processInfoList, User user, Integer roleid, 
			String comment, String desc, Map<Integer, FormFile> filemap,String type, String pbdid, String prstatus)
			throws BLException;

	/**
	 * <p>
	 * ����״̬ԾǨ
	 * </p>
	 * 
	 * @param srcStatus ����ԾǨʱ״̬����ԭ״̬
	 * @param processRecord ������Ϣ
	 * @param user ��ǰ��¼�û�
	 * @param roleid �����ɫID
	 * @param comment ��־����
	 * @param desc ��־����������Ϣ
	 * @param filemap ����
	 * @param authorizeuser��Ȩ���û���Ϣ
	 * @return ������Ϣ
	 * @throws BLException
	 *
	 */
	public IG500Info updateProcessRecord(String srcStatus,IG500Info processRecord,
			User user, Integer roleid, String comment, String desc, Map<Integer, FormFile> filemap,
			String type,User authorizeuser, String pbdid, String prstatus)
			throws BLException;
	
	/**
	 * <p>
	 * ������Ϣ����(����״̬���ı�)
	 * </p>
	 * 
	 * @param processRecord ������Ϣ
	 * @param user ��ǰ��¼�û�
	 * @param roleid �����ɫID
	 * @param comment ��־����
	 * @param desc ��־����������Ϣ
	 * @param filemap ����
	 * @param authorizeuser��Ȩ���û���Ϣ
	 * @return ������Ϣ
	 * @throws BLException
	 *
	 */
	public IG500Info updateProcessRecord(IG500Info processRecord,
			User user, Integer roleid, String comment, String desc,
			Map<Integer, FormFile> filemap,String type, User authorizeuser, String pbdid, String prstatus)
	throws BLException;
	
	/**
	 * <p>
	 * ������Ϣ����(����״̬���ı�,����¼��־��Ϣ)
	 * </p>
	 * 
	 * @param processRecord ������Ϣ
	 * @return ������Ϣ
	 * @throws BLException
	 *
	 */
	public IG500Info updateProcessRecord(IG500Info processRecord) throws BLException;
	
	/**
	 * <p>
	 * ָ������ID��ѯ������Ϣ
	 * </p>
	 * 
	 * @param prid ����ID
	 * @return ������Ϣ
	 * @throws BLException 
	 *
	 */
	public IG500Info searchProcessRecordByKey(Integer prid) throws BLException;
	
	/**
	 * <p>
	 * ָ�������Ų�ѯ������Ϣ
	 * </p>
	 * 
	 * @param prserialnum ���̹�����
	 * @return ������Ϣ
	 * @throws BLException 
	 *
	 */
	public IG500Info searchProcessRecordBySerialnum(String prserialnum) throws BLException;

	/**
	 * ���ݼ�������ȡ��������Ϣ�б���ҳ��ѯ�ã�
	 * 
	 * @param cond ������Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return ������Ϣ��������б�
	 */
	public List<IG500Info> searchProcessRecord(IG500SearchCond cond, int start, int count);
	
	/**
	 * ���ݼ���������������������ȡ��������Ϣ�б���ҳ��ѯ�ã�
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG500Info> queryIG500EntityListByProcessInfo(IG500SearchCond cond, int start, int count);
	
	/**
	 * ���ݼ�������ȡ��������Ϣ�б�
	 * 
	 * @param cond ������Ϣ��������
	 * @return ������Ϣ��������б�
	 */
	public List<IG500Info> searchProcessRecord(IG500SearchCond cond);

	/**
	 * <p>
	 * ���ݼ�������ȡ��������Ϣ����
	 * </p>
	 * 
	 * @param cond ������Ϣ��������
	 * @return ������Ϣ����
	 */
	public int getProcessRecordSearchCount(IG500SearchCond cond);
	
	/**
	 * ���ݼ�������ȡ��������Ϣ�б������¼�������״̬����ƽ̨������
	 * 
	 * @param cond ������Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return ������Ϣ��������б�
	 */
	public List<IG500Info> searchProcessRecordSubStatusList(IG500SearchCond cond, int start, int count);

	/**
	 * ���ݼ�������ȡ��������Ϣ�б������¼�������״̬����ƽ̨������
	 * 
	 * @param cond ������Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return ������Ϣ��������б�
	 */
	public List<IG500ONLYInfo> searchProcessRecordONLYSubStatusList(IG500SearchCond cond, int start, int count);
	
	/**
	 * <p>
	 * ���ݼ�������ȡ��������Ϣ�����������¼�������״̬����ƽ̨������
	 * </p>
	 * 
	 * @param cond ������Ϣ��������
	 * @return ������Ϣ����
	 */
	public int getProcessRecordSubStatusSearchCount(IG500SearchCond cond);

	/**
	 * <p>
	 * ���ݼ�������ȡ��������Ϣ�����������¼�������״̬����ƽ̨������
	 * </p>
	 * 
	 * @param cond ������Ϣ��������
	 * @return ������Ϣ����
	 */
	public int getProcessRecordONLYSubStatusSearchCount(IG500SearchCond cond);
	
	/**
	 * <p>
	 * ָ������ID��ѯ���̷�����
	 * </p>
	 * 
	 * @param prid ����ID
	 * @param initStatus ���̷���״̬
	 * @return ���̷�������Ϣ
	 *
	 */
	public IG337Info searchProcessOpener(Integer prid,String initStatus);
	
	/**
	 * <p>
	 * Description: ��ȡָ��������
	 * </p>
	 * 
	 * @param ppid ������ID
	 * @return ��������Ϣ
	 * @throws BLException 
	 */
	
	public IG337Info searchProcessParticipantByKey(Integer ppid) throws BLException;

	/**
	 * <p>
	 * ָ������ID������״̬��ѯδ�����������Ϣ
	 * </p>
	 * 
	 * @param prid ����ID
	 * @param status ����״̬
	 * @return δ�����������Ϣ
	 *
	 */
	public List<IG337Info> searchProcessParticipantTodoRole(Integer prid, String status);
	
	/**
	 * <p>
	 * ָ������ID������״̬����������״̬��ѯδ�����������Ϣ
	 * </p>
	 * 
	 * @param prid ����ID
	 * @param status ����״̬
	 * @param ppsubstatus ��������״̬
	 * @return δ�����������Ϣ
	 *
	 */
	public List<IG337Info> searchProcessParticipantTodoRole(Integer prid, String status, String ppsubstatus);
	
	/**
	 * <p>
	 * ָ������ID������״̬��ѯ�Ѵ����������Ϣ
	 * </p>
	 * 
	 * @param prid ����ID
	 * @param status ����״̬
	 * @return �Ѵ����������Ϣ
	 *
	 */
	public List<IG337Info> searchProcessParticipantDoneRole(Integer prid, String status);
	
	/**
	 * <p>
	 * ָ������ID������״̬����������״̬��ѯ�Ѵ����������Ϣ
	 * </p>
	 * 
	 * @param prid ����ID
	 * @param status ����״̬
	 * @param ppsubstatus ��������״̬
	 * @return �Ѵ����������Ϣ
	 *
	 */
	public List<IG337Info> searchProcessParticipantDoneRole(Integer prid, String status, String ppsubstatus);

	/**
	 * <p>
	 * ���̲���������
	 * </p>
	 * 
	 * @param processParticipant ��������Ϣ
	 * @param user ��ǰ��¼�û�
	 * @param roleid �����ɫID
	 * @param comment ��־����
	 * @param desc ��־����������Ϣ
	 * @param filemap ����
	 * @param authorizeuser��Ȩ���û���Ϣ
	 * @return ��������Ϣ
	 * @throws BLException
	 *
	 */
	public IG337Info addProcessParticipant(IG337Info processParticipant,
			User user, Integer roleid, String comment, String desc, Map<Integer, FormFile> filemap,
			String type, User authorizeuser, String pbdid, String prstatus) throws BLException;
	
	/**
	 * <p>
	 * ���̲���������
	 * </p>
	 * @param processParticipant ��������Ϣ
	 * @return ��������Ϣ
	 * @throws BLException
	 *
	 */
	public IG337Info addProcessParticipant(IG337Info processParticipant) throws BLException;

	/**
	 * <p>
	 * ���̲�����ɾ��
	 * </p>
	 * 
	 * @param processParticipant ��������Ϣ
	 * @param user ��ǰ��¼�û�
	 * @param roleid �����ɫID
	 * @param comment ��־����
	 * @param desc ��־����������Ϣ
	 * @param filemap ����
	 * @return ��������Ϣ
	 * @throws BLException
	 *
	 */
	public void removeProcessParticipant(IG337Info processParticipant,
			User user, Integer roleid, String comment, String desc,
			Map<Integer, FormFile> filemap,String type,User authorizeuser, String pbdid, String prstatus) throws BLException;
	
	/**
	 * <p>
	 * ���̲�����ɾ��
	 * ����¼��־
	 * </p>
	 * @param processParticipant ��������Ϣ
	 * @throws BLException
	 */
	
	public void removeProcessParticipant(IG337Info processParticipant) throws BLException;

	/**
	 * <p>
	 * ��������Ϣ����(״̬���ı�)
	 * </p>
	 * 
	 * @param processParticipant ��������Ϣ
	 * @param user ��ǰ��¼�û�
	 * @param roleid �����ɫID
	 * @param comment ��־����
	 * @param desc ��־����������Ϣ
	 * @param filemap ����
	 * @param List<ProcessInfo> ���̱�����Ϣ����
	 * @return ��������Ϣ
	 * @throws BLException
	 *
	 */
	public IG337Info updateProcessParticipant(IG337Info processParticipant,
			User user, Integer roleid, String comment, String desc, Map<Integer, FormFile> filemap,
			String type,List<IG599Info> prInfoList, User authorizeuser, String pbdid, String prstatus) throws BLException;

	/**
	 * <p>
	 * ��������Ϣ����(״̬���ı�,����¼��־��Ϣ��
	 * </p>
	 * 
	 * @param processParticipant ��������Ϣ
	 * @return ��������Ϣ
	 * @throws BLException
	 *
	 */

	public IG337Info updateProcessParticipant(IG337Info processParticipant) throws BLException;
	/**
	 * <p>
	 * ָ������ID������״̬��ѯδ��������߽�ɫID��Ϣ
	 * </p>
	 * 
	 * @param prid ����ID
	 * @param status ����״̬
	 * @return δ��������߽�ɫID��Ϣ
	 *
	 */
	public List<Integer> searchProcessParticipantTodoRoleId(Integer prid,String status);

	/**
	 * <p>
	 * ָ������ID���û�ID������״̬��ѯ��������Ϣ
	 * </p>
	 * 
	 * @param prid ����ID
	 * @param userId �û�ID
	 * @param status ����״̬
	 * @return ��������Ϣ
	 *
	 */
	public IG337Info searchProcessParticipant(Integer prid,String userId, String status);

	/**
	 * <p>
	 * ָ������ID����ɫID������״̬��ѯ��������Ϣ
	 * </p>
	 * 
	 * @param prid ����ID
	 * @param roleId ��ɫID
	 * @param status ����״̬
	 * @return ��������Ϣ
	 *
	 */
	public IG337Info searchProcessParticipant(Integer prid,Integer roleId, String status);

	/**
	 * <p>
	 * ָ������ID������״̬��ѯ��������Ϣ
	 * </p>
	 * 
	 * @param prid ����ID
	 * @param status ����״̬
	 * @return ��������Ϣ
	 *
	 */
	public List<IG337Info> searchProcessParticipant(Integer prid, String status) throws BLException;
	
	/**
	 * <p>
	 * ���ݼ���������ѯ��������Ϣ
	 * </p>
	 * 
	 * @param IG337SearchCond ��������Ϣ��������
	 * @return ��������Ϣ
	 *
	 */
	public List<IG337Info> searchProcessParticipants(IG337SearchCond cond);

	/**
	 * <p>
	 * ָ������ID������״̬��ѯδ��������ߵ�����
	 * </p>
	 * 
	 * @param prid ����ID
	 * @param status ����״̬
	 * @return δ��������ߵ�����
	 *
	 */
	public int getTodoProcessParticipantCount(Integer prid, String status);

	/**
	 * <p>
	 * ��־����,roleidΪnull�򲻼�¼������ɫ����
	 * </p>
	 * 
	 * @param prid ����ID
	 * @param user ��ǰ��¼�û�
	 * @param roleid �����ɫID
	 * @param comment ��־����
	 * @param desc ��־����������Ϣ
	 * @param filemap ����
	 * @param type ��־���� 0ϵͳ��־��1��׼��2���أ�3�ύ��4��ֹ��5����
	 * @param pbdid ����ťID
	 * @return ��������Ϣ
	 * @return ��־��Ϣ
	 * @throws BLException
	 *
	 */
	public IG036Info addRecordLog(Integer prid, User user, Integer roleid, String comment,
			String desc, Map<Integer, FormFile> filemap,String type, String pbdid, String prstatus) throws BLException;
	
	/**
	 * ������־��Ϣ����
	 * @param info �޸�������־��Ϣ
	 * @throws BLException 
	 */
	public void updateRecordLog(IG036Info info) throws BLException;
	/**
	 * <p>
	 * ָ������ID��ѯ������ʷ��¼
	 * </p>
	 * 
	 * @param prid ����ID
	 * @return ������ʷ��¼
	 *
	 */
	public Map<IG036Info, List<Attachment>> searchRecordLog(Integer prid);

	/**
	 * <p>
	 * ��ѯ��ϵͳ����Ա��������п����ӵĲ����߽�ɫ
	 * </p>
	 * 
	 * @param processParticipantList ��������Ϣ
	 * @return �����п����ӵĲ����߽�ɫ
	 *
	 */
	public List<Role> getRoleNotInProcessParticipants(List<IG337Info> processParticipantList);
	
	/**
	 * <p>
	 * ��ѯ�����п����ӵ�������ɫ
	 * </p>
	 * 
	 * @param  processParticipantList ����ӵ�������ɫ
	 * @return �����п����ӵ�������ɫ
	 *
	 */
	public List<Role> getApproveRolesNotAdd(List<IG337Info> processParticipantList);

	/**
	 * <p>
	 * ָ������ID���û�ID������״̬��ѯ�û��ɴ����ɫ��Ϣ
	 * </p>
	 * 
	 * @param prid ����ID
	 * @param userId �û�ID
	 * @param status ����״̬
	 * 
	 * @return �û��ɴ����ɫ��Ϣ
	 *
	 */
	public List<UserRoleInfo> getUserRolesInProcessParticipants(Integer prid, String userId, String status);
	
	/**
	 * <p>
	 * ָ������ID���û�ID������״̬��ѯ�û��ɴ����ɫ��Ϣ
	 * </p>
	 * 
	 * @param prid ����ID
	 * @param userId �û�ID
	 * @param status ����״̬
	 * 
	 * @return �û��ɴ����ɫ��Ϣ
	 *
	 */
	public List<IG337Info> getUserRolesInProcessParticipants(Integer prid, String userId, String status, String na);

	/**
	 * <p>
	 * ��ѯָ�����̶�������̱���������Ϣ
	 * </p>
	 * 
	 * @param processDefinitionId ���̶���ID
	 * @return  ���̱���������Ϣ
	 */
	public List<IG007Info> getProcessInfoDefs(String processDefinitionId);
	
	/**
	 * <p>
	 * ��ѯָ�����̶�������̱���������Ϣ(������ȱʡ����)��ƽ̨������
	 * </p>
	 * 
	 * @param processDefinitionId ���̶���ID
	 * @return  ���̱���������Ϣ
	 */
	public List<IG007Info> getProcessInfoDefsNoDefault(String processDefinitionId);
	
	/**
	 * <p>
	 * ��ѯ���̷���ʱ����������̱�����Ϣ
	 * </p>
	 * 
	 * @param prid ����ID
	 * @return ���̱�����Ϣ
	 *
	 */
	public List<IG599Info> getProcessInfo(Integer prid);
	
	/**
	 * <p>
	 * ��ѯ���̱�����Ϣ
	 * </p>
	 * 
	 * @param piid ���̱���ID
	 * @return ���̱�����Ϣ
	 * @throws BLException 
	 *
	 */
	public IG599Info getProcessInfoByID(Integer piid) throws BLException;
	
	/**
	 * <p>
	 * ���̱�����Ϣ�趨
	 * </p>
	 * 
	 * @param processInfoList ���̱�����Ϣ
	 *
	 */
	public List<IG599Info> saveOrUpdProcessInfos(List<IG599Info> processInfoList) throws BLException;
	/**
	 * <p>
	 * ���̱�����Ϣ�趨
	 * </p>
	 * 
	 * @param processInfoList ���̱�����Ϣ
	 *
	 */
	public IG599Info saveProcessInfo(IG599Info processInfo) throws BLException;
	
	/**
	 * <p>
	 * ��ѯָ����ѯ�����µ�����ģ����Ϣ
	 * </p>
	 * 
	 * @param ProcessTemplateSearchCond ����ģ���ѯ����
	 * @return ����ģ����Ϣ
	 *
	 */
	public List<IG259Info> getActiveProcessTemplates() throws BLException;
	
	/**
	 * ��ѯָ������ģ��
	 * @param ptid ����ģ��ID
	 * @return ����ģ��
	 * @throws BLException 
	 */
	public IG259Info getProcessTemplateByKey(Integer ptid) throws BLException;

	/**
	 * ��ѯָ���������Ͷ�����Ϣ
	 * @param pdid �������Ͷ�����ϢID
	 * @return �������Ͷ�����Ϣ
	 * @throws BLException
	 */
	public IG380Info getProcessDefinitionByKey(String pdid) throws BLException;
	
	/**
	 * <p>
	 * ָ���û�id���������Ͳ�ѯ���û������δ�رյ�������Ϣ
	 * </p>
	 * 
	 * @param userId �û�id
	 * @param prtype ��������
	 * @return ������Ϣ
	 */
	public List<IG500Info> getActiveProcessRecordsInitByUser(String userId, String prtype);
	
	/**
	 * <p>
	 * ָ����ɫid���������Ͳ�ѯ�ý�ɫ�����δ�رյ�������Ϣ
	 * </p>
	 * 
	 * @param roleId ��ɫid
	 * @param prtype ��������
	 * @return ������Ϣ
	 */
	public List<IG500Info> getActiveProcessRecordsInitByRole(Integer roleId, String prtype);
	
	/**
	 * <p>
	 * ָ����ɫid���������Ͳ�ѯδ�رյ�������Ϣ
	 * </p>
	 * 
	 * @param roleId ��ɫid
	 * @param prtype ��������
	 * @return ������Ϣ
	 */
	public List<IG677Info> getWorkAssignedToMyManyRole(Integer roleId, String prtype);
	
	/**
	 * <p>
	 * ָ���û�id���������Ͳ�ѯδ�رյ�������Ϣ
	 * </p>
	 * 
	 * @param userId �û�id
	 * @param prtype ��������
	 * @return ������Ϣ
	 */
	public List<IG677Info> getWorkAssignedToMe(String userId, String prtype,String pdid,String prstatus);
	
	/**
	 * ָ���������Ͳ�ѯδ�رյ�������Ϣ
	 * 
	 * @param prtype ��������
	 * @return ������Ϣ
	 */
	public List<IG500Info> getAllActiveProcessRecords(String prtype);
	
	/**
	 * ȱʡ�����˲�ѯ��ƽ̨������
	 * @param pdid ��������ID
	 * @return  ȱʡ�������б�
	 */
	public Map<String,List<IG337Info>> getDefaultApprovors(String pdid);
	
	/**
	 * ȱʡ���������˲�ѯ��ƽ̨������
	 * @param pdid ��������ID
	 * @return  ȱʡ�����������б�
	 */
	public List<IG337Info> getDefaultApprovorDispatcher(String pdid);
	
	/**
	 * ָ���û�ID������ID��ѯ���û���������̵Ĵ����ɫ��Ϣ
	 * @param userid �û�ID
	 * @param prid ����ID
	 * @return �����ɫ��Ϣ
	 */
	public List<IG337Info> queryRolemanager(String userid , Integer prid);
	
	/**
	 * ����������Ϣ������������ƽ̨������
	 * @param cond ���������������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ����������Ϣ�б�
	 */
	public List<IG500Info> queryServiceRequestList(IG500SearchCond cond, int start, int count);
	
	/**
	 * ����������Ϣ����������¼��ȡ�ã�ƽ̨������
	 * @param cond ���������������
	 * @return ����������Ϣ��¼��
	 */
	public int queryServiceRequestListCount(IG500SearchCond cond);
	
	/**
	 * ָ���û�δ��������������������
	 * @param userid �û�ID
	 * @return ��������б�
	 */
	public List<IG500Info> queryActiveProcessByUserid(String userid);

	/**
	 * ���̷����߽�ɫδ��������������������
	 * @param roleId ���̷��ɽ�ɫID
	 * @param prtype ��������
	 * @return ������Ϣ
	 */
	public List<IG677Info> getWorkAssignedToFPRole(Integer roleId, String prtype);
	
	/**
	 * ���ָ���û��Ƿ����ָ�����̲鿴Ȩ�ޣ�Ŀǰֻ֧�ֱ����������
	 * @param userid �û�ID
	 * @param prid ����ID
	 * @return Ȩ�ޱ�ʶ
	 */
	public boolean checkLookDetailPermission(String userid, Integer prid);

	/**
	 * ������ָ������ɫʱ,�ڽ�ɫ�����˵��ҵĹ�������ʾ����������Ϣ
	 * @param userid �û�ID
	 * @return
	 */
	public List<IG677Info> queryActiveProcessByFPRoleid(String userid);

	/**
	 * ָ���û���ش�������������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @param closeFlag ��ѯ�رձ�־��0���Ѵ���1��δ��������������
	 * @param dealFlag  ��ѯ�����־��0���ѹرգ�1��δ�رգ�����������
	 * @return ��������б�
	 */
	public List<IG500Info> queryCorrelationProcessByUserid(final IG677SearchCond cond, 
			final int start, final int count, final int closeFlag, final int dealFlag);
	
	/**
	 * ָ���û���ش�������������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @param closeFlag ��ѯ�رձ�־��0���Ѵ���1��δ��������������
	 * @param dealFlag  ��ѯ�����־��0���ѹرգ�1��δ�رգ�����������
	 * @return �����������
	 */
	public int queryCorrelationProcessByUseridCount(final IG677SearchCond cond, 
			final int start, final int count, final int closeFlag, final int dealFlag);
	
	/**
	 * ָ����ɫδ��������������������
	 * @param roleid ��ɫID
	 * @return ��������б�
	 */
	public List<IG500Info> queryActiveProcessByRoleid(Integer roleid);
	
	/**
	 * <p>
	 * ���̹�ϵ����
	 * </p>
	 * 
	 * @param processRecordRelation ���̹�ϵ��Ϣ
	 * @return ���̹�ϵ��Ϣ
	 * @throws BLException
	 *
	 */
	public IG512Info createProcessRecordRelation(IG512Info processRecordRelation) throws BLException;
	
	/**
	 * <p>
	 * ���ݼ�������ȡ�����̹�ϵ
	 * </p>
	 * 
	 * @param cond ���̹�ϵ��Ϣ��������
	 * @return ���̹�ϵ��Ϣ��������б�
	 *
	 */
	public List<IG512Info> searchProcessRecordRelation(IG512SearchCond cond);
	
	/**
	 * ���̹�ϵ������ʱ����������
	 * 
	 * @param processRecordRelationList ���̹�ϵ�б�
	 * 
	 */
	public void orderByTimeAsc(List<IG512Info> processRecordRelationList);
	
	/**
	 * ����״̬��־����
	 * 
	 * @param prid ����ID
	 * @param prpdid �Զ�����������ID�����Զ������̴���null��
	 * @param prtype ��������
	 * @param fromstatus ����ԭ״̬
	 * @param tostatus ����ԾǨ״̬
	 * @param statustype ����״̬���ͣ�0��ʼ��1��ͨ��2����
	 * @return ����״̬��־
	 * @throws BLException 
	 */
	public void addRecordStatusLog(Integer prid, String prpdid, String prtype, String fromstatus,
			String tostatus, int statustype, Integer pgrid) throws BLException;
	
	/**
	 * ����״̬��־����
	 * 
	 * @param prid ����ID
	 * @param prpdid �Զ�����������ID�����Զ������̴���null��
	 * @param prtype ��������
	 * @param fromstatus ����ԭ״̬
	 * @param tostatus ����ԾǨ״̬����
	 * @param statustype ����״̬���ͣ�0��ʼ��1��ͨ��2����
	 * @return ����״̬��־
	 * @throws BLException 
	 */
	public void addRecordStatusLog(IG500Info processRecord, IG333Info fpsd, Integer psdnum,
			String[] tostatus, int statustype, User user, Integer roleid, User authorizeuser, String pbdid) throws BLException;
	
	/**
	 * ��ǰ����״̬��־��Ϣȡ��
	 * 
	 * @param prid ����ID
	 * @param status ����״̬
	 * @return ��ǰ����״̬��־��Ϣ
	 * @throws BLException 
	 */
	public List<IG224Info> searchCurrentRecordStatusLog(Integer prid, String status) throws BLException;
	
	/**
	 * ��ǰ����״̬��ʶ����ȡ��
	 * 
	 * @param prid ����ID
	 * @return ��ǰ����״̬��ʶ����
	 * @throws BLException 
	 */
	public List<String> searchCurrentRecordStatus(Integer prid) throws BLException;
	
	/**
	 * <p>
	 * ָ������״̬��־��ѯ
	 * </p>
	 * 
	 * @param prid ����ID
	 * @return ָ������״̬��־
	 *
	 */
	public List<IG224Info> searchRecordStatusLog(Integer prid);
	
	/**
	 * <p>
	 * ��������ID��ѯ�����˸����̵����̼�¼
	 * </p>
	 * 
	 * @param prid ����ID
	 * @return ���̼�¼
	 *
	 */

	public List<IG500Info> searchProcessRecordsByPrid(Integer prid) throws BLException;

	
	/**
	 * <p>
	 * ���ݲ�ѯ������ѯ���̱�����Ϣ
	 * </p>
	 * @param IG599SearchCond ���̱�����ѯ����
	 * @return ���̱�����Ϣ 
	 */
	public List<IG599Info> searchProcessInfoByCond(IG599SearchCond cond);
	
	/**
	 * <p>
	 * ���ݲ�ѯ������ѯ���̱���������Ϣ
	 * </p>
	 * @param IG007SearchCond ���̱��������ѯ����
	 * @return ���̱���������Ϣ 
	 */
	public List<IG007Info> searchProcessInfoDefByCond(IG007SearchCond cond);
	
	/**
	 * ��������
	 * 
	 * @param processRecord ���̼�¼����
	 * @param user	        �û�
	 * @param roleid		��ɫID
	 * @param filemap		����map
	 * @param pts           ��������
	 * @param prInfoList	���̱�����Ϣ
	 * @param rlcomment	    ��־��Ϣ
	 * @param psdid	        ����״̬ID
	 * @param action	    ������ʶ
	 * @param authorizeuser	��Ȩ���û���Ϣ
	 */
	public IG500Info launchProcess(IG500Info processRecord,
			User user, Integer roleid, Map<Integer, FormFile> filemap,
			String pts,List<IG599Info> prInfoList,String rlcomment,
			String psdid, String action, User authorizeuser)
			throws BLException;
	
	/**
	 * ƥ��ԾǨ������ƥ�䷵����һ״̬id����ƥ�䷵��Null
	 *
	 * @param user �û�
	 * @param fpsdid ��ǰ����״̬ID
	 * @param roleid ��ɫID
	 * @param action ������ť����
	 * @param prid ����ID
	 * @param List<ProcessInfo> ���̱�����Ϣ����
	 * @return Integer ԾǨ�������״̬ID
	 */
	public String checkAndTransitionForCreate(User user,String fpsdid,Integer roleid,String action,
			Integer prid,List<IG599Info> piList, User authorizeuser) throws BLException;
	
	/**
	 * ƥ��ԾǨ����(��ά�ƻ���)
	 *
	 * @param user �û�
	 * @param fpsdid ��ǰ����״̬ID
	 * @param roleid ��ɫID
	 * @param action ������ť����
	 * @param prid ����ID
	 * @param List<ProcessInfo> ���̱�����Ϣ����
	 * @return Integer ԾǨ�������״̬ID
	 */
	public String checkAndTransition(User user,String fpsdid,Integer roleid,String action,Integer prid,
			List<IG599Info> piList) throws BLException;
	
	/**
	 * ƥ��ԾǨ������ƥ�䷵����һ״̬id����ƥ�䷵��Null(�����Զ�������ʱʹ��)
	 *
	 * @param user �û�
	 * @param fpsdid ��ǰ����״̬ID
	 * @param roleid ��ɫID
	 * @param action ������ť����
	 * @param prid ����ID
	 * @param List<ProcessInfo> ���̱�����Ϣ����
	 * @param authorizeuser��Ȩ���û���Ϣ
	 * @return Integer ԾǨ�������״̬ID
	 */
	public String checkAndTransitionForHandel(User user,String fpsdid,Integer roleid,String action,
			Integer prid,String nodeType,
			Map<Integer, List<String>> participants,String ppsuper,User authorizeuser) throws BLException;
	
	
	/**
	 * ��ȡ��һ����״̬��ID
	 * @param fpsdid ��ǰ����״̬ID
	 * @param roleid ��ɫID
	 * @param action ������ť����
	 * @param List<ProcessInfo> ���̱�����Ϣ����
	 * @return IG333 ԾǨ�������״̬
	 * @throws BLException
	 */
	public IG333Info checkTransition(String fpsdid,Integer roleid,String action,List<IG599Info> piList) throws BLException;
	
	/**
	 * <p>
	 * Description: ��Ӳ�����
	 * </p>
	 * 
	 * @param tpsdid tpsdid
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @update   
	 */
	
	public List<IG337Info> addParticipants(String tpsdid,User user,Integer prid,Integer roleid,String desc,String nodetype,
			Map<Integer, List<String>> participants,String ppsuper, User authorizeuser, String pbdid, String prstatus) throws BLException;
	
	
	/**
	 * <p>
	 * Description: ����ԾǨ 
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	
	public void doFlow(Integer prid, User user,Integer roleid, String datetime, String rolename,
			String psdid,String action,String desc,String nodeType,
			Map<Integer, List<String>> participants, String ppsuper, User authorizeuser) throws BLException;
	
	/**
	 * ������תJSPȡ��
	 * 
	 * @param pdid���̶���ID
	 * @param prid����ID
	 * @param pjdtypeҳ������
	 * @param user��¼�û���Ϣ
	 */
	public String searchForwardJsp(String pdid, Integer prid, String pjdtype, User user) throws BLException;
	
	/**
	 * ���ӱ���־��Ϣ
	 * 
	 * @param List<ProcessInfo> ���̱�����Ϣ����
	 * @param IG036Info	   ������־
	 * @return �Ƿ񱣴�ɹ�,�ɹ��Ƿ���true,������ı�����������ʱ����false
	 */
	public boolean addRecordLogVarInfo(List<IG599Info> prInfoList,IG036Info rl)throws BLException;
	
	/**
	 * ����������־��ѯ��������־��Ӧ�ı���־��Ϣ
	 * 
	 * @param IG036Info ������־
	 * @return ����־��Ϣ
	 */
	public List<IG113Info> searchRecordLogVarInfo(IG036Info recordLog) throws BLException;
	
	
	/**
	 * ����������־ID��ѯ��������־��Ӧ�ı���־��Ϣ
	 * 
	 * @param rlid ������־ID
	 * @return ����־��Ϣ
	 */
	public List<IG113Info> searchRecordLogVarInfoByRecordId(Integer rlid) throws BLException;
	
	/**
	 * ��ѯ����־
	 * @param cond
	 * @return
	 * @throws BLException
	 */
	public List<IG113Info> searchRecordLogVarInfoByCond(IG113SearchCond cond) throws BLException;
	
	/**
	 * <p>
	 * ָ��������ʷ��¼��ѯ(�Զ�������ʹ��)
	 * </p>
	 * 
	 * @param prid ����ID
	 * @return ָ��������ʷ��¼
	 *
	 */

	public List<IG036Info> searchRecordLogForProcessDef(Integer prid) throws BLException;
	
	/**
	 * �����û���ɫ���ҽ�ɫ��־
	 * 
	 * @param RecordLogSearchCond���̶���ID
	 */
	public List<IG036Info> searchUserRoleRecondLog(IG036SearchCond cond);
	
	
	/**
	 * �Զ�������������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public int searchProcessRecordCountForSelfDef(IG500SearchCond cond);
	
	
	
	/**
	 * �Զ�������������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG500Info> searchProcessRecordForSelfDef(IG500SearchCond cond, int start, int count);
	
	
	/**
	 * �Զ���������ع�������������¼��
	 * @return �Զ�����������������¼��
	 */
	public int searchProcessRecordCountForRelatedWork(IG500SearchCond cond);
	
	
	
	/**
	 * �Զ�������������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG500Info> searchProcessRecordForRelatedWork(IG500SearchCond cond, int start, int count);
	
	/**
	 * ��ȡ���̲����߱���Ȩ��
	 * @param psdid����״̬ID
	 * @param roleid���̲����߽�ɫID
	 * @return ���̲����߱���Ȩ���б�
	 */
	public List<IG893Info> searchParticipantVariableVW(String psdid , Integer roleid);
	
	/**
	 * ����ָ����ɫֵ�����ύȨ��
	 * @param prid����ID
	 * @param roleid���̲����߽�ɫID
	 * @throws BLException 
	 */
	public void grantDutyPerson(Integer prid , Integer roleid) throws BLException;
	
	/**
	 * ��������ʱ���ݼ�������ȡ�ý�ɫ��Ϣ�б�(�Զ������̷���ʱ��ѯ������֧�ֵĽ�ɫʹ��)
	 * @param processParticipantList
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	
	public List<Role> getRoleForPRR(List<IG337Info> processParticipantList,RoleSearchCond cond, int start, int count);
	
	/**
	 * ���̶���ʱ���ݼ�������ȡ�ý�ɫ��Ϣ�б�(�Զ������̷���ʱ��ѯ������֧�ֵĽ�ɫʹ��)
	 * @param processParticipantList
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	
	public List<Role> getRoleForSelfPRD(RoleSearchCond cond, int start, int count);
	
	/**
	 * �������̱���ID��ȡ���̱�������ֵ��Ϣ����
	 * @param piid ���̱���ID
	 * @throws BLException 
	 */
	public IG599Info searchProcessInfoByPiid(Integer piid) throws BLException;
	
	/**
	 * ���̹���Ա�޸ı���Ϣ
	 * 
	 */
	public void editVarInfo(IG500Info processRecord,User user, Integer roleid, Map<Integer, FormFile> filemap,
			List<IG599Info> prInfoList,String rlcomment, String prstatus) throws BLException;
	
	/**
	 * ɾ������
	 * @param prid
	 * @throws BLException
	 */
	public void delProcessRecord(Integer prid) throws BLException;
	
	/**
	 * �������ʲ���ϵ�趨
	 * @param ig731
	 */
	public IG731Info saveProcessInfoEntity(IG731Info processInfoEntity) throws BLException;

	/**
	 * �������ʲ���ϵ��Ϣ��ѯ
	 * @param prid ����ID
	 * @return
	 */
	public List<IG731Info> searchProcessInfoEntityByPrid(Integer prid);
	
	/**
	 * ��������ʲ�����
	 * @param cond ��������
	 * @return �������
	 */
	public List<IG731Info> searchProcessInfoEntityByCond(IG731SearchCond cond);

	/**
	 * �������ʲ���ϵ��Ϣɾ������
	 * @param pieid �����ʲ���ϵID
	 */
	public void deleteProcessInfoEntityById(Integer pieid) throws BLException;
	
	//ȡprocessinfo����
	public  List<Attachment> searchProcessInofAtt(String piattkey);
	//�ı���󶨸����ϴ������ظ���ID
	public IG599Info addProcessInfo(Map<Integer, FormFile> filemap) throws BLException ;
	public IG599Info updateProcessInfo(Map<Integer, FormFile> filemap,IG599Info pi) throws BLException;
	public void updateProcessInfo(IG599Info pi) throws BLException;
	public void addProcessInfoAtt(Map<Integer, FormFile> filemap,String attkey) throws BLException;
//	public String addAtt(Map<Integer, FormFile> filemap) throws BLException;
	//�ı���󶨸���ɾ������
	public  Attachment delAttachment(String attkey) throws BLException;


	public IG500Info launchProcess(IG500Info processRecord,
			User user, Integer roleid, Map<Integer, FormFile> filemap,Map<String, FormFile> filemapMuti,
			String pts,List<IG599Info> prInfoList,String rlcomment,
			String psdid, String action,Map<String,List<Attachment>> copyMap, User authorizeuser,
			Map<Integer, String> processInfoEntityMap,Map<String, Object> tableFormValueMap,
			Map<String, List<IG506TB>> participantFormValueMap,String isServiceStart,Integer parprid)
			throws BLException;
	
	/**
	 * �Զ������̹ر�״̬������Ϣ����ȡ��
	 * ��ȱʡ�����Ͷ��������������ͨģʽ����ɫ���ˣ�OAģʽ���û�ID���ˣ�
	 * @param ����ID
	 * @param ���̶���ID
	 * @param �û�ID
	 * @return ���̱�������ֵ��Ϣ����
	 */
	public List<IG599Info> searchProcessInfoForClose(Integer prid, String pdid, String userid);
	
	/**
	 * �Զ������̹ر�״̬������Ϣ����ȡ��
	 * ��ȱʡ�����Ͷ��������������ͨģʽ����ɫ���ˣ�OAģʽ���û�ID���ˣ�
	 * @param ����ID
	 * @param ���̶���ID
	 * @param �û�ID
	 * @return ���̱�������ֵ��Ϣ����
	 */
	public List<IG599Info> searchProcessInfoForSee(Integer prid, String pdid, String userid);
	
	
	/**
	 * ����˽�б�������
	 * 
	 * @param lst_ProcessInfo ����������
	 * @param roleid ��ɫID
	 * @param userid �û�ID
	 * @throws BLException 
	 */
	public void registProcessPrivateInfo(List<IG599Info> lst_ProcessInfo, Integer roleid, String userid, String orgid) throws BLException;
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG899Info> searchProcessPrivateInfo(IG899SearchCond cond) throws BLException;
	
	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG899Info updateProcessPrivateInfo(IG899Info instance) throws BLException;
	
	/**
	 * ����ִ���˼�������
	 * @param userid �û�ID
	 * @param prid ����ID
	 * @return ��������б�
	 */
	public List<IG602Info> searchProcessExecutors(String userid, Integer prid);
	
	/**
	 * ���̿ɷ����˼�������
	 * @param roleid ��ɫID
	 * @param prid ����ID
	 * @return ��������б�
	 */
	public List<IG602Info> searchSuperAssignExecutors(Integer roleid, Integer prid);
	
	/**
	 * <p>
	 * Description: ��Ӳ�����
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @update   
	 */
	public void addParticipant(User user,Integer prid, String pdid, String psdcode,
			String executorRoleid, String executorUserid, String ppsuper,User authorizeuser, String pbdid, String prstatus) throws BLException;
	

	
	/**
	 * ���̴�����ť�¼�
	 * 
	 * @param processRecord������Ϣ
	 * @param fpsd����Դ״̬��Ϣ
	 * @param tpsd����ԾǨ״̬��Ϣ
	 * @param user��¼�û���Ϣ
	 * @param roleid�����ɫID
	 * @param authorizeuser��Ȩ���û���Ϣ
	 */
	public void processStatusButtonTreatmentExecute(WorkFlowStatusEventBean bean) throws BLException;
	
	/**
	 * ����֪ͨ
	 * @param status ״̬��ʶ
	 * @param lst_Userid �û�ID�б�
	 * @param sms ��������
	 * @param lst_Roleid ��ɫID�б�
	 * @param title ����
	 * @param content �ʼ�����
	 * @param ig500 ������Ϣ
	 * @throws BLException
	 */
	public void sendMessage(String status, List<String> lst_Userid, String sms,
			List<Integer> lst_Roleid, String title, String content, IG500Info ig500) throws BLException;
	
	/**
	 * ��ȡ���̲��������Ȩ��
	 * @param psdid����״̬ID
	 * @param roleid���̲����߽�ɫID
	 * @return ���̲����߱���Ȩ���б�
	 */
	public List<IG893Info> searchParticipantMaxVariableVW(String psdid , Integer roleid,Map<IG333Info, List<IG337Info>> ls_proStatusParticipantMap);
	
	/**
	 * ���ܣ����������������ȡ��(�ɸ��ݱ���ѯ)
	 * @param cond ��������
	 * @return �����������
	 */
	public int queryIG500EntityCount(IG500SearchCond cond);
	
	/**
	 * ���ܣ����е�ǰ�����˵ı��¹�����ѯȡ��(���ݵ�ǰ�£��͵�ǰ��¼�˽�ɫ)
	 * @param cond ��������
	 * @return �������
	 */
	public List<CurrentMonthWorkVWInfo> SearchCurrentWorkWithManage(CurrentMonthWorkVWSearchCond cond,int start,int count);
	
	/**
	 * ���ܣ����е�ǰ�����˵ı��¹�����ѯȡ��(���ݵ�ǰ�£��͵�ǰ��¼�˽�ɫ)
	 * @param cond ��������
	 * @return �������
	 */
	public int SearchCurrentWorkWithManageCount(CurrentMonthWorkVWSearchCond cond);
	
	/**
	 * ȡ���������ֵ
	 * @param prid
	 * @param value
	 * @return
	 * @throws BLException
	 */
	public String getProcessFormValue(Integer prid,String value) throws BLException;
	
	/**
	 * ȡ����Ա���ֵ
	 * @param prid ��������
	 * @param pvList ��Ա���ֵʵ�弯��
	 * @param value ��ֵ
	 * @return
	 */
	public String getParticipantFormValue(Integer prid,List<IG506TB> pvList,String value) throws BLException;
	
	/**
	 * �������в�ѯ
	 * @param pdid ���̶�������
	 * @return 
	 * @throws BLException
	 */
	public Map<String, List<IG007Info>> initTableFormAction(String pdid) throws BLException;
	
	/**
	 * ��������ֵ���洦��
	 * @param process ������Ϣ
	 * @param column_value ֵ����
	 * @param column_pidid �ж�����������
	 * @param column_rownum ���кż���
	 * @throws BLException
	 */
	public void saveTableFormValue(IG500Info process,String[] column_value,String[] column_pidid,String[] column_rownum,Map<Integer, FormFile> fileMap,String fileStr,String fileDelStr) throws BLException;
	
	/**
	 * �����ʲ����е��ʲ���Ϣ
	 * �ʲ���Ӧ�ı���Ϣ������ʱ���쳣
	 * @param processInfoList ��ֵ����
	 * @param processInfoEntityMap �ʲ���Ϣmap
	 * @throws BLException
	 */
	public Map<String,String> saveProcessInfoEntity(List<IG599Info> processInfoList,Map<Integer, String> processInfoEntityMap) throws BLException;
	
	/**
	 * ���ܣ����������������ȡ��(�ɸ��ݱ���ѯ)
	 * @param cond ��������
	 * @return �����������
	 */
	public int searchProcessCount(IG500SearchCond cond,String type)throws BLException;
	
	/**
	 * ���ݼ���������������������ȡ��������Ϣ�б���ҳ��ѯ�ã�
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG500Info> searchProcessByType(IG500SearchCond cond, int start, int count,String type)throws BLException;
	
	/**
	 * <p>
	 * Description: ���ݲ�ѯ������ȡָ��������Ա
	 * </p>
	 * 
	 * @param cond ProcessParticipantSearchCond
	 * @return List<ProcessParticipant>
	 * @author liupeng@deliverik.com
	 */
	public List<IG337Info> searchIG337InfoRun(IG337SearchCond cond);
	
	
	/**
	 * ��������������ѯ�������
	 * @param prid ��������
	 * @return �����������
	 * @throws BLException
	 */
	public List<IG505Info> searchIG505InfoByprid(Integer prid) throws BLException;
	
	/**
	 * ��������������ѯ��Ա���
	 * @param prid ��������
	 * @return ��Ա�������
	 * @throws BLException
	 */
	public List<IG506Info> searchIG506InfoByprid(Integer prid) throws BLException;
	
	/**
	 * ��������������ѯ��������񹤵���ϵ
	 * @param prid ��������
	 * @return ��������񹤵���ϵʵ�弯��
	 * @throws BLException
	 */
	public List<IG715Info> searchServiceProcessRecordRelationByPrid(Integer prid) throws BLException;
	
	/**
	 * ע����ʽ��ֵ
	 * @param entity ���ʽ��ֵʵ��
	 * @return ���ʽ��ֵʵ��
	 * @throws BLException
	 */
	public IG898Info registTableFormValue(IG898Info entity) throws BLException;
	
	/**
	 * ���ʽ��ֵ��ѯ
	 * @param cond ��ѯ����ʵ��
	 * @return ���ʽ��ֵ����
	 * @throws BLException
	 */
	public List<IG898Info> searchTableFormValue(IG898SearchCond cond) throws BLException;
	
	/**
	 * �����������ʽ��
	 * @param pk ����
	 * @return ���ʽ��ʵ��
	 * @throws BLException
	 */
	public IG898Info searchTableFormValueByKey(IG898PK pk) throws BLException;
	
	/**
	 * ɾ�����ʽ��ֵ
	 * @param entitys ���ʽ��ʵ�弯��
	 * @throws BLException
	 */
	public void deleteTableFormValue(List<IG898Info> entitys) throws BLException;
	
	/**
	 * �����������񹤵�
	 * @param sfid ���񹤵�����
	 * @return ���񹤵���Ϣ
	 * @throws BLException
	 */
	public IG933Info searchServiceFormByKey(Integer sfid) throws BLException;
	
	/**
	 * ��Ȩ��������
	 * @param cond ��������
	 * @return �������
	 * @throws BLException
	 */
	public List<IG463Info> searchProcessProxyWork(IG463SearchCond cond) throws BLException;
	
	/**
	 * ������Ȩ����
	 * @param entity ��Ȩ����ʵ��
	 * @throws BLException
	 */
	public void updateProcessProxyWork(IG463Info entity) throws BLException;
	
	/**
	 * �û���Ȩ����
	 * @param cond ��������
	 * @return �������
	 * @throws BLException
	 */
	public List<IG711Info> searchProcessAccredit(IG711SearchCond cond) throws BLException;
	
	/**
	 * ��ѯָ����ܱ���key����������
	 * @param type ��������
	 * @param pdid ������ID
	 * @param key ����ʵ��key
	 * @param isClose true����ѯ�ѹرգ�false����ѯδ�رգ�null����ѯȫ������������ֹ
	 * @return ��������
	 */
	public List<Integer> searchRegulatoryReportDetailByKey(String type, String pdid, String key, Boolean isClose) throws BLException;
	
	/**
	 * ���ܣ����ݹ�����ʶ��ѯ��ǰ�����ˮ��
	 * @param prserialnum ������ʶ
	 * @return �����ˮ��
	 */
	public String searchMaxPrserialnum(String prserialnum);
	
	/**
	 * ���鵱ǰ״̬���в������Ƿ�����ɣ�
	 * ���ȫ����������򰴴���ʱ�����һ�������ߵĴ����¼����״̬ԾǨ��
	 * ����в�����δ���������κβ���.
	 * 
	 * @param prid ����ID
	 * @throws BLException 
	 */
	public void checkAllUserWorkDone(Integer prid) throws BLException;
	
	/**
	 * ��ȡ���̵�ǰ״̬��ʾ����
	 * @param prid ����ID
	 * @return ���̵�ǰ״̬��ʾ����
	 */
	public String searchCurrentStatusName(Integer prid) throws BLException;
	
	/**
	 * ��ȡ���̵�ǰ״̬
	 * @param prid ����ID
	 * @return ���̵�ǰ״̬
	 */
	public List<String> searchCurrentStatus(Integer prid) throws BLException;
	
	/**
	 * ״̬��־����
	 * @param cond �������� 
	 * @return
	 */
	public List<IG224Info> searchProcessStatusLog(IG224SearchCond cond);
	
	/**
	 * ��������
	 * @param cond
	 * @return
	 * @throws BLException
	 */
	public List<IG677Info> searchIG677InfoByCond(IG677SearchCond cond) throws BLException;
	
	/**
	 * У���Ƿ��ǹ���״̬
	 * @param prid ����ID
	 * @param psdid ״̬ID
	 * @return �Ƿ��ǹ���״̬
	 */
	public boolean checkPendStatus(Integer prid, String psdid);
	
    /**
     * ״̬��˽�б�ֵ��ѯ
     * @Title: searchStatusValue
     * @Description: ״̬��˽�б�ֵ��ѯ
     * @param pdid ����id ���汾��
     * @param psdid �ڵ�id
     * @param prid ����Ϊ�գ�����ʱ��
     * @return Map</key pidid,valueΪĬ��ֵ/ʵ�ʴ洢ֵ> 
     * @throws BLException
     */
    public Map<String,IG561Info> searchStatusValue(String pdid,String psdid,String prid) throws BLException;

    /**
     * ״̬��˽�б���������
     * @Title: registIG561Info
     * @Description: ״̬������������
     * @param list599 ���б�
     * @param psdid �ڵ�id
     * @param userid �û�id
     * @param entitySaveMap �ʲ�������map
     * @throws BLException
     * wyw
     */
    public void registIG561Info(List<IG599Info> list599, String psdid,String userid,Map<String,String> entitySaveMap) throws BLException;

    /** 
     * 
     * @Title: searchIG561VW 
     * @Description: TODO ״̬��˽�б��رսڵ��ѯ
     * @param prid ����id
     * @param userid �û�id
     * @return List<IG561VWInfo>    
     * List<IG561VWInfo>  �Ѿ����û�Ȩ�޵�IG560TB  
     * @throws BLException
     * wyw
     */
    public List<IG561VWInfo> searchIG561VW(String prid, String userid, boolean isAdmin)throws BLException;
    
    /**
     * @Description: ״̬��˽�б�ֵ����
     * @param cond 561״̬��˽�б�ֵ��¼���������
     * @return List<IG561Info>
     */
    public List<IG561Info> searchIG561Info(IG561SearchCondImpl cond)throws BLException;

    /** 
     * @Title: searchProcessByTypeStatusAndParticanpant 
     * @Description:  �ɵ�wkm���̲�ѯ ���ӵ��������·�װ��ѯ�� 
     * @return    
     * List<IG500Info>    
     * @throws 
     */
    public List<Map<String, Object>> searchProcessByTypeStatusAndParticanpant(IG500SearchCond prSearchCond, int i, int j, String type)throws BLException;

    /**
     * @param prid ���𳡾����������id
     * @param emcproeiname ר��Ԥ���ʲ�����
     * @param sceneeiname �����ʲ�����
     * @param scenepdid �����������̵����̶���id
     * @param propentime �����������̵����̷���ʱ��
     * @throws BLException 
     */
    public void send(Integer prid,String emcproeiname,String sceneeiname,String scenepdid,String propentime) throws BLException;
    
    /**
     * ��ȡ������������Ϣ
     * @param prid ���𳡾��������̵�����id
     * @return
     * @throws BLException
     */
    public List<UserRoleInfo> getSceneParticipant(Integer prid) throws BLException;
}
