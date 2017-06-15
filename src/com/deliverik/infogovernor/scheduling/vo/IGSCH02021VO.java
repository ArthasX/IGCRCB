/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.scheduling.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.infogovernor.scheduling.form.IGSCH0201Form;

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
public class IGSCH02021VO extends BaseVO implements Serializable {

	private IGSCH0201Form igsch0201Form;
	
	/**���̱���*/
	private List<IG007Info> processInfoDefList;

	public List<IG007Info> getProcessInfoDefList() {
		return processInfoDefList;
	}

	public void setProcessInfoDefList(List<IG007Info> processInfoDefList) {
		this.processInfoDefList = processInfoDefList;
	}

	public IGSCH0201Form getIgsch0201Form() {
		return igsch0201Form;
	}

	public void setIgsch0201Form(IGSCH0201Form igsch0201Form) {
		this.igsch0201Form = igsch0201Form;
	}

}
