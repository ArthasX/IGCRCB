/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.drm.igflow.status;

import java.util.Date;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;
import com.deliverik.infogovernor.drm.IGDRMCONSTANTS;
import com.deliverik.infogovernor.drm.bl.task.DrillplanitemBL;
import com.deliverik.infogovernor.drm.model.DrillplanitemInfo;
import com.deliverik.infogovernor.drm.model.entity.DrillplanitemTB;

/**
 * Ӧ����������-�����ƻ��������
 * 
 * ���������ƻ���ͼƻ������
 * 
 * @author zyl
 *
 * 2015��3��16��13:34:06
 */
public class IGDRMEVENT0701BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
    static Log log = LogFactory.getLog(IGDRMEVENT0701BLImpl.class);
    /**����API*/
    private FlowSearchBL flowSearchBL;
    /**�ƻ�����BL*/
    private DrillplanitemBL drillplanitemBL;
    /**����ʵ��BL*/
    private IG500BL ig500BL;
    
    /**
     * �����ƻ��������
     */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		log.debug("========�����ƻ����������������ƻ���ͼƻ������ʼ========");
		Integer prid = bean.getLogInfo().getPrid();
		
		////��<��������>��ֵ���Ƶ�prdesc�ֶ���
		IG500TB ig500tb = (IG500TB)ig500BL.searchIG500InfoByKey(prid);
		ig500tb.setPrdesc(flowSearchBL.searchPublicProcessInfo(prid, IGDRMCONSTANTS.DRILL_FORM_DRCONTENT));
		ig500BL.updateIG500Info(ig500tb);
		
		//�ƻ�����id 
		String jobId = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(),IGDRMCONSTANTS.PLAN_JOB_NAME);
		if(jobId!=null&&!"".equals(jobId)){

			DrillplanitemInfo rpiInfo = drillplanitemBL.searchDrillplanitemByPK(Integer.parseInt(jobId));
			if(rpiInfo!=null){
				//�ƻ��ڷ���ʱ ������������Ϊ���̵�����
				ig500tb.setPrtitle(rpiInfo.getDiname());
				ig500BL.updateIG500Info(ig500tb);
				
				DrillplanitemTB dpiTB = (DrillplanitemTB) SerializationUtils.clone(rpiInfo);
				//ʵ�ʿ�ʼʱ���趨
				Date nowDateTime = new Date();
				String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
				dpiTB.setStatus("������");
				dpiTB.setActstarttime(datetime);
				dpiTB.setPrid(prid);
				drillplanitemBL.updateDrillplanitem(dpiTB);
			}
		}else{
			//�ƻ���������
			String jobname = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(),IGDRMCONSTANTS.PLAN_JOB_FORM_NAME);
			//�ƻ��ڷ���ʱ ������������Ϊ���̵�����
			if(StringUtils.isNotEmpty(jobname)){
				ig500tb.setPrtitle(jobname);
				ig500BL.updateIG500Info(ig500tb);
			}
		}
		
		log.debug("========�����ƻ����������������ƻ���ͼƻ���������========");
		
    }
	
	/**
	 * 
	 */
    public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
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

	/**
	 * @param ig500bl the ����ʵ��BL to set
	 */
	public void setIg500BL(IG500BL ig500bl) {
		ig500BL = ig500bl;
	}


    
}
