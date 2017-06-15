/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prd.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG202Info;

/**
 * ����Ϣ��Ϣ��������֣�
 * 
 * @author liupeng@deliverik.com
 *
 */
@SuppressWarnings("serial")
public class IGPRD01101VO extends BaseVO implements Serializable{
	
	/** ����Ϣ��Ϣ������� */
	protected List<IG007Info> processInfoDefList;
	protected List<IG202Info> processInfoDefGeneralList;
	/** ��������Ϣ */
	protected IG007Info processInfoDef;
	
	/**
	 * ���캯��
	 * @param processInfoDef������Ϣ��Ϣ�������
	 */
	public IGPRD01101VO(List<IG007Info> processInfoDefList) {
		this.processInfoDefList = processInfoDefList;
	}
	public IGPRD01101VO() {
	}
	
	/**
	 * ����Ϣ��Ϣ�������ȡ��
	 * @return ����Ϣ��Ϣ�������
	 */
	public List<IG007Info> getProcessInfoDefList() {
		return processInfoDefList;
	}

	public List<IG202Info> getProcessInfoDefGeneralList() {
		return processInfoDefGeneralList;
	}
	public void setProcessInfoDefGeneralList(
			List<IG202Info> processInfoDefGeneralList) {
		this.processInfoDefGeneralList = processInfoDefGeneralList;
	}
	/**
	 * ��������Ϣȡ��
	 * @return processInfoDef ��������Ϣ
	 */
	public IG007Info getProcessInfoDef() {
		return processInfoDef;
	}
	/**
	 * ��������Ϣ�趨
	 * @param processInfoDef ��������Ϣ
	 */
	public void setProcessInfoDef(IG007Info processInfoDef) {
		this.processInfoDef = processInfoDef;
	}
	
}


