/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.drm.igflow.status;

import java.util.Date;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.infogovernor.drm.IGDRMCONSTANTS;
import com.deliverik.infogovernor.drm.bl.task.DrillplanitemBL;
import com.deliverik.infogovernor.drm.model.DrillplanitemInfo;
import com.deliverik.infogovernor.drm.model.entity.DrillplanitemTB;
import com.deliverik.infogovernor.drm.util.IGDRMEmergencyTools;

/**
 * Ӧ����������-�رսڵ�ǰ����
 * 
 * ���������ƻ���ͼƻ������ �޸�״̬Ϊ������
 * 
 * @author zyl
 *
 * 2015��3��16��13:34:06
 */
public class IGDRMEVENT0703BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
    static Log log = LogFactory.getLog(IGDRMEVENT0703BLImpl.class);
    /**����API*/
    private FlowSearchBL flowSearchBL;
    /**�ƻ�����BL*/
    private DrillplanitemBL drillplanitemBL;
    /**
     * �����ƻ��������
     */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
    }
	
	/**
	 * �����ƻ�����ǰ����
	 */
    public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
    	log.debug("========�����ƻ����������������ƻ���ͼƻ������ʼ========");
		Integer prid = bean.getLogInfo().getPrid();
		
		//�ƻ�����id 
		String jobId = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(),IGDRMCONSTANTS.PLAN_JOB_NAME);
		if(jobId!=null&&!"".equals(jobId)){

			DrillplanitemInfo rpiInfo = drillplanitemBL.searchDrillplanitemByPK(Integer.parseInt(jobId));
			if(rpiInfo!=null){
				
				DrillplanitemTB dpiTB = (DrillplanitemTB) SerializationUtils.clone(rpiInfo);
				//ʵ�ʿ�ʼʱ���趨
				Date nowDateTime = new Date();
				String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
				dpiTB.setStatus("������");
				dpiTB.setActstarttime(datetime);
				dpiTB.setPrid(prid);
				drillplanitemBL.updateDrillplanitem(dpiTB);
			}
		}
		
		log.debug("========�����ƻ����������������ƻ���ͼƻ���������========");
		
		//�����ַͨ��ҵ��ϵͳID����ҵ��ϵͳӦ������״̬
		IGDRMEmergencyTools.changeSystemState(prid, "ҵ��ϵͳ", "0",null);
    }

	/**
	 * @param ����API the flowSearchBL to set
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * @param �ƻ�����BL the drillplanitemBL to set
	 */
	public void setDrillplanitemBL(DrillplanitemBL drillplanitemBL) {
		this.drillplanitemBL = drillplanitemBL;
	}


    
}
