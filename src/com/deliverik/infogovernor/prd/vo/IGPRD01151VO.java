/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prd.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG273Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;

/**
 * ���̲��нڵ��������Ϣ��������֣�
 * 
 * 
 */
@SuppressWarnings("serial")
public class IGPRD01151VO extends BaseVO implements Serializable {

	/** ��������Ϣ������� */
	protected List<IG273Info> processTransitionDefList;

	/** ����״̬��Ϣ */
	protected IG333Info processStatusDef;

	/**
	 * ���캯��
	 * 
	 * @param processTransitionDef��������Ϣ�������
	 * @param processStatusDef����״̬��Ϣ
	 */
	public IGPRD01151VO(List<IG273Info> processTransitionDefList,
			IG333Info processStatusDef) {
		this.processTransitionDefList = processTransitionDefList;
		this.processStatusDef = processStatusDef;
	}

	/**
	 * ��������Ϣ�������ȡ��
	 * 
	 * @return ��������Ϣ�������
	 */
	public List<IG273Info> getProcessTransitionDefList() {
		return processTransitionDefList;
	}

	/**
	 * ����״̬��Ϣȡ��
	 * 
	 * @return ����״̬��Ϣ
	 */
	public IG333Info getProcessStatusDef() {
		return processStatusDef;
	}

}
