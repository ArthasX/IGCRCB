/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.dev.crc.igflow.event.status;

import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prr.bl.task.IG036BL;
import com.deliverik.framework.workflow.prr.model.IG036Info;
import com.deliverik.framework.workflow.prr.model.condition.IG036SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.entity.IG036TB;
import com.deliverik.infogovernor.drm.util.IGDRMEmergencyTools;

/**	
 * ����:��� ���������
 * ����Զ�̷�������ʱ��attkey
 *         
 */

public class IGCRC3003BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{

	/**��־����ȡ��*/
	static Log log = LogFactory.getLog(IGCRC3003BLImpl.class);
	
    /** ��ѯ�๦��API�� */
    private FlowSearchBL flowSearchBL;
    
    /** ��־��Ϣ���� */
	private IG036BL ig036BL;

	/**
	 * ע���ѯ����API��
	 * 
	 * @param flowSearchBL
	 */
    public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
        this.flowSearchBL = flowSearchBL;
    }
      
	/**
	 * @param ig036bl the ��־��Ϣ���� to set
	 */
	public void setIg036BL(IG036BL ig036bl) {
		ig036BL = ig036bl;
	}
    
	/**
	 * ǰ����
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		Integer prid = bean.getLogInfo().getPrid();
		//�����ַͨ��ҵ��ϵͳID����ҵ��ϵͳӦ������״̬
		IGDRMEmergencyTools.changeFlowSystemState(prid, "0",null);
	}

	/**
	 * ����
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		log.debug("=================����Զ�̷�������ʱ��attkey����ʼ=================");
		Integer prid = bean.getLogInfo().getPrid();
		String attkey = flowSearchBL.searchPublicProcessInfo(prid, "���ظ���ID");
		IG036SearchCondImpl cond = new IG036SearchCondImpl();
		cond.setNotEqualrlType("0");
		cond.setPrid(prid);
		List<IG036Info> ig036List = ig036BL.searchIG036InfoByCond(cond);
		if(ig036List != null && ig036List.size() > 0 && attkey!= null && !"".equals(attkey)){
			IG036Info ig036Info = ig036List.get(0);
			IG036TB ig036tb = (IG036TB)SerializationUtils.clone(ig036Info);
			ig036tb.setRlattkey(attkey);
			ig036BL.updateG036Info(ig036tb);
		}
		
		log.debug("=================����Զ�̷�������ʱ��attkey�������=================");
	}


}
