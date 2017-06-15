/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.drm.igflow.status;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;
import com.deliverik.infogovernor.drm.IGDRMCONSTANTS;

/**
 * Ӧ��ָ������-������(�¼��ϱ�) �ڵ� ����
 * 
 * �ж��Ƿ���ͨ����ͨ�¼�������Ӧ�����������������¼�����������ָ�����̵�����
 * 
 * @author �Ž�
 *
 *         2015-3-11 ����10:24:34
 */
public class IGDRMEVENT0902BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
    static Log log = LogFactory.getLog(IGDRMEVENT0902BLImpl.class);
    
    private FlowSearchBL flowSearchBL;
    
    private FlowSetBL flowSetBL;
    
    private IG500BL ig500BL;
    
	/**
	 * flowSetBL   �趨
	 * @param flowSetBL flowSetBL
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * �������������е�Ԥ���ʲ���Ԥ���ʲ�
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		
		Integer prid = bean.getLogInfo().getPrid();
		//2015��5��25��12:46:42���¼������н����¼����������¼����Զ�����Ӧ��ָ��
    	String pridForHurry = flowSearchBL.searchPublicProcessInfo(prid, "�����¼�prid");
    	if(StringUtils.isNotEmpty(pridForHurry)){
    		IG500Info ig500Info = ig500BL.searchIG500InfoByKey(Integer.parseInt(pridForHurry));
    		IG500TB ig500TB = (IG500TB) SerializationUtils.clone(ig500Info);
    		ig500TB.setPrstatus("#");
    		ig500BL.updateIG500Info(ig500TB);
    	}
		////��<��������>��ֵ���Ƶ�prdesc�ֶ���
		IG500TB ig500tb = (IG500TB)ig500BL.searchIG500InfoByKey(prid);
		ig500tb.setPrdesc(flowSearchBL.searchPublicProcessInfo(prid, IGDRMCONSTANTS.EC_FORM_ECDESC));
		ig500tb.setPrtitle(flowSearchBL.searchPublicProcessInfo(prid, IGDRMCONSTANTS.EC_FORM_ECNAME));
		ig500BL.updateIG500Info(ig500tb);
    }
	
	/**
	 * 
	 */
    public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
    	
    }

	/**
	 * ig500BL   �趨
	 * @param ig500BL ig500BL
	 */
	public void setIg500BL(IG500BL ig500bl) {
		ig500BL = ig500bl;
	}
}
