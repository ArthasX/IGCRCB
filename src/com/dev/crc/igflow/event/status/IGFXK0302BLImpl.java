/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.dev.crc.igflow.event.status;

import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prr.bl.task.IG898BL;
import com.deliverik.framework.workflow.prr.model.IG898Info;
import com.deliverik.framework.workflow.prr.model.condition.IG898SearchCondImpl;
import com.deliverik.infogovernor.fxk.bl.IGFXK03BLType;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨-���ռƻ�ִ�нڵ�ǰ����
 * </p>
 * <p>
 * Description: 
 * </p>
 * 
 * @version 1.0
 */
public class IGFXK0302BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{
	
	protected IG898BL ig898BL;
	/** ������API */
	protected FlowSetBL flowSetBL;
	
	public void setIg898BL(IG898BL ig898BL) {
		this.ig898BL = ig898BL;
	}
	/**
	 * ������API�趨
	 * @param flowSetBL ������API
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		//���ʽ����ѯʵ������
		IG898SearchCondImpl cond = new IG898SearchCondImpl();
		cond.setPrid(bean.getLogInfo().getPrid());	//������Ϣ����(prid)
		cond.setPidname(IGFXK03BLType.RISK_TABLE_NAME); //��ѯ�ı��ʽ������
		
		//��ѯָ��������Ϣ�еı��ʽ���������б���������Ϣ
		List<IG898Info> lst_ig898_job = ig898BL.searchIG898(cond);
		//��������������Ϣ���������������û�м�¼ֵ����ѯ��Ӧ�Ĺ�������ʱ��
		if(lst_ig898_job != null && lst_ig898_job.size() > 0){	//begin if3
			//��װ�����б��Ϻ�Map��Ϣ
			List<IG898Info> lst_job = new ArrayList<IG898Info>();
			
			//�������̵ı��ʽ��
			for (IG898Info ig898Info : lst_ig898_job) {
				//��װ���������ļ���
				if(IGFXK03BLType.RISK_TABLE_NAME_COLNAMEUM_MANAGER.equals(ig898Info.getPvcolname())){
					lst_job.add(ig898Info);
				}
			}
			//��ȡ��������Ϣ
			List<String> lst_user = new ArrayList<String>();
			for (IG898Info ig898Info : lst_job) {
				//��ȡ������ID(������ID)
				//��ȡ�����˽�ɫID(�����˽�ɫID)
				if(!lst_user.contains(ig898Info.getPvalue())){
					String userid = ig898Info.getPvalue().split("_user_")[0];
					Integer roleid = Integer.valueOf(ig898Info.getPvalue().split("_user_")[2]);
					StatusParticipant statusParticipantInfo = new StatusParticipant(bean.getLogInfo());
				    statusParticipantInfo.setRoleid(roleid);
				    statusParticipantInfo.setUserid(userid);
				    statusParticipantInfo.setStatusname("ִ��");
				    flowSetBL.setStatusParticipant(statusParticipantInfo);
				    
				    lst_user.add(ig898Info.getPvalue());
				}
				
			}
		}
	}

	/**
	 * ����
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
	}
}
