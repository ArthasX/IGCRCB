/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.dev.vim.igflow.event.status;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.infogovernor.soc.vir.bl.task.VCD03BL;
import com.deliverik.infogovernor.soc.vir.model.VCD03Info;
import com.deliverik.infogovernor.soc.vir.model.entity.VCD03TB;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��Դ����������������������
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGVIM3001BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {

	/** ��־����ȡ�� */
	private static Log log = LogFactory.getLog(IGVIM3001BLImpl.class);
	
	/** ��ѯ��API */
	protected FlowSearchBL flowSearchBL;
	
	/** VMBL */
	protected VCD03BL vcd03BL;
	
    /**
	 * ��ѯ��API�趨
	 * @param flowSearchBL ��ѯ��API
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * VMBL�趨
	 * @param vcd03BL VMBL
	 */
	public void setVcd03BL(VCD03BL vcd03bl) {
		vcd03BL = vcd03bl;
	}

	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
        log.debug("======== ��Դ���������������������̴���ʼ========");
        
        Integer prid = bean.getLogInfo().getPrid();
        String vmids = flowSearchBL.searchPublicProcessInfo(prid, "�������");
        
        if (StringUtils.isNotEmpty(vmids)) {
            String[] vmidarr = vmids.split("#");
            for (String vmid : vmidarr) {
            	VCD03Info info = vcd03BL.searchVCD03ByPK(Integer.parseInt(vmid));
                VCD03TB tb = (VCD03TB) SerializationUtils.clone(info);
                tb.setPrid(prid);
                vcd03BL.updateVCD03(tb);
            }
        }
        
        log.debug("======== ��Դ���������������������̴������ ========");
    }

    public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {

        
    }
}
