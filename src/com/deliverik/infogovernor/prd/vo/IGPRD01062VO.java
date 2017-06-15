/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prd.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG413Info;

/**
 * ǰ����tianjia��Ϣ��������֣�
 * 
 * @author liupeng@deliverik.com
 *
 */
@SuppressWarnings("serial")
public class IGPRD01062VO extends BaseVO implements Serializable{
	
	/** ����Ϣ��Ϣ������� */
	protected List<IG007Info> processInfoDefList;
	
	/** ǰ���������� */
	protected List<IG413Info> processEventDefList;
	
	
	public List<IG413Info> getProcessEventDefList() {
		return processEventDefList;
	}

	public void setProcessEventDefList(List<IG413Info> processEventDefList) {
		this.processEventDefList = processEventDefList;
	}

	/**�����б���Ϣ*/
	protected Map<Integer,String[]> optionMap;
	
	public Map<Integer, String[]> getOptionMap() {
		return optionMap;
	}

	public void setOptionMap(Map<Integer, String[]> optionMap) {
		this.optionMap = optionMap;
	}
	/**
	 * ���캯��
	 * @param processInfoDef������Ϣ��Ϣ�������
	 */
	public IGPRD01062VO(List<IG413Info> processEventDefList) {
		this.processEventDefList = processEventDefList;
	}
	
	/**
	 * ����Ϣ��Ϣ�������ȡ��
	 * @return ����Ϣ��Ϣ�������
	 */
	public List<IG007Info> getProcessInfoDefList() {
		return processInfoDefList;
	}
}


