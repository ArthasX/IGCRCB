package com.dev.ext.igflow.event.button;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.PublicProcessInfoValue;
import com.deliverik.framework.igflow.resultset.ParticipantInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusButtonHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/**
 * <p>
 * ���������̷���״̬�ύ��ť��������
 * �ж�Ŀ�겿���Ƿ���ڣ��趨Ŀ�겿���Ƿ���ڱ�ֵ
 * </p>
 */
public class IGEVENT0401BLImpl extends BaseBLImpl implements
		WorkFlowStatusButtonHandlerBL {
	
	static Log log = LogFactory.getLog(IGEVENT0401BLImpl.class);
	
	/** ��ѯ�๦��API�� */
	private FlowSearchBL flowSearchBL;
	
	/** ���¹���API�� */
	private FlowSetBL flowSetBL;
	
	/**
	 * ��ѯ�๦��API���趨
	 * 
	 * @param flowSearchBL ���¹���API���ѯ�๦��API��
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * ���¹���API���趨
	 * 
	 * @param flowSetBL ���¹���API��
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}


	public void statusButtonTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		
		if (bean.getLogInfo().getPrid()!=null){
			log.debug("����ť����1");
			//��ѯ���Ŵ������״̬������
			List<ParticipantInfo> pInfoList = this.flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "���Ŵ������");
			
			PublicProcessInfoValue ppivInfo = new PublicProcessInfoValue(bean.getLogInfo());
			
			//����
			ppivInfo.setFormname("Ŀ�겿��");
	
			if (pInfoList != null && pInfoList.size() > 0){
				//����һ���������Ƿ���ڱ�ֵΪ1			
				//��ֵ
				ppivInfo.setFormvalue(pInfoList.get(0).getRolename());			
			}
			
			this.flowSetBL.setPublicProcessInfoValue(ppivInfo);

			PublicProcessInfoValue ppivInfo1 = new PublicProcessInfoValue(bean.getLogInfo());
			
			//����
			ppivInfo1.setFormname("Ŀ�겿���Ƿ����");
	
			if (pInfoList != null && pInfoList.size() > 0){
				//����Ŀ�겿���Ƿ���ڱ�ֵΪ1			
				//��ֵ
				ppivInfo1.setFormvalue("1");			
			} else {
				//����Ŀ�겿���Ƿ���ڱ�ֵΪ0			
				//��ֵ
				ppivInfo1.setFormvalue("0");			
			}
			this.flowSetBL.setPublicProcessInfoValue(ppivInfo1);
		} else {
			log.debug("����ť����2");
		}
		
	}

}
