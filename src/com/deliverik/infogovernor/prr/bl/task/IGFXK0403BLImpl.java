/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.bl.task;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.ProcessInfoDefinitionInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.infogovernor.asset.model.dao.RiskPointVMDAO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ����δѡ�еķ��յ�ͼ����
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGFXK0403BLImpl implements WorkFlowEventHandlerBL{
	
	/** ��־���� */
	private static final Log log = LogFactory.getLog(IGFXK0403BLImpl.class);
	
	private List<Map<String, Object>> listMap;
	
	/** ��ѯ��API */
	protected FlowSearchBL flowSearchBL;
	
	/** ������API */
	protected FlowSetBL flowSetBL;

	/**
	 * @return the flowSearchBL
	 */
	public FlowSearchBL getFlowSearchBL() {
		return flowSearchBL;
	}

	/**
	 * @return the listMap
	 */
	public List<Map<String, Object>> getListMap() {
		return listMap;
	}

	/**
	 * @param listMap the listMap to set
	 */
	public void setListMap(List<Map<String, Object>> listMap) {
		this.listMap = listMap;
	}

	/**
	 * @return the flowSetBL
	 */
	public FlowSetBL getFlowSetBL() {
		return flowSetBL;
	}

	/**
	 * ��ѯ��API�趨
	 * @param flowSearchBL ��ѯ��API
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
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
		
	}

	@SuppressWarnings("unchecked")
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		log.debug("================���˱��ʽ��������ʼ=================");
		//��ѯ�����
		Map<String, ProcessInfoDefinitionInfo> def = flowSearchBL.searchProcessTableColumnDef(bean.getLogInfo().getPrid());
		Object list = flowSearchBL.searchPublicTableValue("��������", bean.getLogInfo().getPrid(), null);
		List<Map<String, Object>> dataList = (List<Map<String, Object>>) list;
		if(dataList != null){
			int idx_one = 0;
			for(Map<String, Object> map:dataList){
				idx_one ++;
				if(map.get("���յ�") != null){
					List<Map<String, String>> tempList = (List<Map<String, String>>) map.get("���յ�");
					int idx_two = 0;
					for(Map<String, String> dataMap:tempList){
						idx_two ++;
						if(idx_two == 1){
							continue;
						}
						if(!".".equals(dataMap.get("ѡ��"))){
							flowSetBL.deletePublicTableFormValue(def, "��������#���յ�", bean.getLogInfo().getPrid(), idx_one + "_" + idx_two);
						}
					}
				}
				if(map.get("�����") != null){
					List<Map<String, String>> tempList = (List<Map<String, String>>) map.get("�����");
					int idx_two = 0;
					for(Map<String, String> dataMap:tempList){
						idx_two ++;
						if(idx_two == 1){
							continue;
						}
						if(!".".equals(dataMap.get("ѡ��"))){
							flowSetBL.deletePublicTableFormValue(def, "��������#�����", bean.getLogInfo().getPrid(), idx_one + "_" + idx_two);
						}
					}
				}
			}
		}
		
		
		
		this.listMap = dataList;
		log.debug("================���˱��ʽ����������=================");
	}
	
}
