/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prd.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG992Info;

/**
 * �ⲿ�¼�tianjia��Ϣ��������֣�
 * 
 * @author liupeng@deliverik.com
 *
 */
@SuppressWarnings("serial")
public class IGPRD01611VO extends BaseVO implements Serializable{
	
	/**
	 * ���캯��
	 * @param processInfoDef������Ϣ��Ϣ�������
	 */
	public IGPRD01611VO(List<IG992Info> processExternalDefList) {
		this.ProcessExternalDefList = processExternalDefList;
	}
	
	protected List<IG992Info> ProcessExternalDefList;

	public List<IG992Info> getProcessExternalDefList() {
		return ProcessExternalDefList;
	}

	public void setProcessEventDefList(
			List<IG992Info> ProcessEventDefList) {
		this.ProcessExternalDefList = ProcessEventDefList;
	}
	
}


