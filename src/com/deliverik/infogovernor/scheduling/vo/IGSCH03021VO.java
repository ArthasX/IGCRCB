/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.scheduling.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.infogovernor.scheduling.form.IGSCH0301Form;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_�������_��ѯVO
 * </p>
 * 
 * @author maozhipengpeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSCH03021VO extends BaseVO implements Serializable {

	private IGSCH0301Form igsch0301Form;

	private List<IG007Info> processInfoDefList;
	
	
	public List<IG007Info> getProcessInfoDefList() {
		return processInfoDefList;
	}

	public void setProcessInfoDefList(List<IG007Info> processInfoDefList) {
		this.processInfoDefList = processInfoDefList;
	}

	public IGSCH0301Form getIgsch0301Form() {
		return igsch0301Form;
	}

	public void setIgsch0301Form(IGSCH0301Form igsch0301Form) {
		this.igsch0301Form = igsch0301Form;
	}

	
}
