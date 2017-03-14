/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.dev.crc.igflow.event.status;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.igflow.resultset.ParticipantInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/***
 * ���򿪷����� - ���ɽڵ㴦���˳�ʼ��
 * @time 2014/07/13
 * @author taoye
 * @version 1.0
 * @mail taoye@deliverik.com
 */
public class IGSVC0103BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{
	
	/**��־����ȡ��*/
	static Log log = LogFactory.getLog(IGCRC0401BLImpl.class);
	
	/** ���¹���API�� */
	private FlowSetBL flowSetBL;
    
    /** ���̲�ѯ����API�� */
    private FlowSearchBL flowSearchBL;
    
	/**
	 * ע����¹���API��
	 * 
	 * @param flowSetBL
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

    /**
     * @param ���̲�ѯ����API�� the flowSearchBL to set
     */
    public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
        this.flowSearchBL = flowSearchBL;
    }
    
	/**
     * ����
     */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
	}
	
	/**
	 * ǰ������Ӳ�����
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		
	    log.debug("========���򿪷����̷��ɽڵ�ǰ����ʼ========");

	    //��ȡ���̲�������Ϣ
	    List<ParticipantInfo> participantInfos =  flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "����");
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
	    ParticipantInfo info = null;
	    long l = 0;
	    for(ParticipantInfo pp:participantInfos){
	    	if(StringUtils.isNotEmpty(pp.getPpproctime())){
	    		try {
	    			Date date = sdf.parse(pp.getPpproctime());
	    			if(date.getTime() > l){
	    				l = date.getTime();
	    				info = pp;
	    			}
	    		} catch (ParseException e) {
	    			log.error("",e);
	    		}
	    	}
	    }
	    //�趨״̬������
	    StatusParticipant statusParticipant = new StatusParticipant(bean.getLogInfo());
	    statusParticipant.setStatusname("����");
	    statusParticipant.setUserid(info.getUserid());
	    statusParticipant.setRoleid(info.getRoleid());
	    //��Ӳ����ɫ�Ͳ�����
	    flowSetBL.setStatusParticipant(statusParticipant);
	    
		log.debug("========���򿪷����̷��ɽڵ�ǰ�������========");
	}
}

