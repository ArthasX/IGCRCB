/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prd.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG480Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �����鶨�������Ϣ��ʾVO
 * </p>
 * 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRD03011VO extends BaseVO{
	
	public IGPRD03011VO(){
		
	}
	
	public IGPRD03011VO(List<IG480Info> processGroupDefineList){
		
		this.processGroupDefineList = processGroupDefineList;
	}
	
	

	
	protected List<IG480Info> processGroupDefineList;
	
	
	
	

	/**
	 * processGroupDefineList   ȡ��
	 * @return processGroupDefineList processGroupDefineList
	 */
	public List<IG480Info> getProcessGroupDefineList() {
		return processGroupDefineList;
	}

	/**
	 * processGroupDefineList   �趨
	 * @param processGroupDefineList processGroupDefineList
	 */
	public void setProcessGroupDefineList(List<IG480Info> processGroupDefineList) {
		this.processGroupDefineList = processGroupDefineList;
	}

	
	
	
}
