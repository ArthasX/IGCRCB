/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.dev.vim.igflow.event.status;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.infogovernor.soc.vir.bl.task.VIM07BL;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM07TB;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���õ�����Ϣ
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGVIM0401BLImpl implements WorkFlowEventHandlerBL{
	
	/** ��ѯ��API */
	protected FlowSearchBL flowSearchBL;
	
	/** ���������ϢBL */
	protected VIM07BL vim07BL;

	/**
	 * ��ѯ��API�趨
	 * @param flowSearchBL ��ѯ��API
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * ���������ϢBL�趨
	 * @param vim07BL ���������ϢBL
	 */
	public void setVim07BL(VIM07BL vim07bl) {
		this.vim07BL = vim07bl;
	}

	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		//��ѯ��ֵ
		String value = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "������Ϣ");
		if(StringUtils.isNotEmpty(value)){
			String[] ids = value.split("#");
			if(ids != null && ids.length > 0){
				for(String id:ids){
					VIM07TB entity = (VIM07TB) vim07BL.searchVim07ByPK(Integer.valueOf(id));
					entity.setPrid(bean.getLogInfo().getPrid());
					vim07BL.updateVim07(entity);
				}
			}
		}
	}

	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
	}

}
