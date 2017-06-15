/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prd.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG233Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;

/**
 * ����״̬��Ϣ��������֣�
 * 
 * @author liupeng@deliverik.com
 *
 */
@SuppressWarnings("serial")
public class IGPRD01051VO extends BaseVO implements Serializable{
	
	/** ����״̬��Ϣ������� */
	protected List<IG333Info> processStatusDefList;
	
	/** ���ɽڵ���Ϣ���� */
	protected List<IG233Info> apList;

	public List<IG333Info> getProcessStatusDefList() {
		return processStatusDefList;
	}

	public void setProcessStatusDefList(List<IG333Info> processStatusDefList) {
		this.processStatusDefList = processStatusDefList;
	}
	
	/**
	 * ���ɽڵ���Ϣ����ȡ��
	 * @return ���ɽڵ���Ϣ����
	 */
	public List<IG233Info> getApList() {
		return apList;
	}

	/**
	 * ���ɽڵ���Ϣ�����趨
	 * @param apList ���ɽڵ���Ϣ����
	 */
	public void setApList(List<IG233Info> apList) {
		this.apList = apList;
	}
}


