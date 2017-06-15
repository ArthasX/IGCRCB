/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowOptBL;
import com.deliverik.framework.igflow.parameter.ProcessRecord;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;

/**
 * �������̷�����BL
 */
public class WorkFlowGroupProcessLaunchBLImpl extends BaseBLImpl implements WorkFlowGroupProcessLaunchBL {
	
	/** ���̴�����API */
	public FlowOptBL flowOptBL;
	
	/**
	 * ���̴�����API�趨
	 * @param flowOptBL ���̴�����API
	 */
	public void setFlowOptBL(FlowOptBL flowOptBL) {
		this.flowOptBL = flowOptBL;
	}

	/**
	 * �������̷�����
	 * 
	 * @return ����ID
	 * @throws BLException
	 */
	public final Integer launchProcess(Integer groupID, String groupDefID, String pdid, String title, 
			String executorID, Integer executorRoleID) throws BLException {
		//��־��Ϣ
    	WorkFlowLog logInfo = new WorkFlowLog();
    	logInfo.setAuthuserid(null);
    	logInfo.setExecutorid(executorID);
    	//������Ϣ
		ProcessRecord processRecord = new ProcessRecord(logInfo);
		//�ݲ�У�����̶����Ƿ�ͣ��???????????????????????????????????????????
		processRecord.setDefid(pdid);
		logInfo.setExecutorRoleid(executorRoleID);
		processRecord.setLogInfo(logInfo);
		processRecord.setTitle(title);
		//processRecord.setDescription(processGroupInfo.getDescription());
		processRecord.setDefstatus(IGPRDCONSTANTS.PD_STATUS_ENABLE);//���̶����������״̬
		processRecord.setGroupID(groupID);//������ʵ��ID
		processRecord.setGroupDefID(groupDefID);//�����鶨��ID
		
		//�����Զ���������Ϣ
		setProcessRecord(processRecord);
		
		//��������
		return flowOptBL.initProcessAction(processRecord);
	}
	
	/**
	 * �������̷��������Ϣ������д
	 * 
	 * @throws BLException
	 */
	public void setProcessRecord(ProcessRecord processRecord) throws BLException {
		
	};

}
