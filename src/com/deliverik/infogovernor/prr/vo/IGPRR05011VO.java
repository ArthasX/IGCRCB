/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG483Info;

/**
 * ����: �������ѯVO
 * ��������: �������ѯVO
 * ������¼: 2015/02/03
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGPRR05011VO extends BaseVO{

	/** �������б� */
	protected List<IG483Info> lst_IG483Info;

	/**
	 * �������б�ȡ��
	 * @return �������б�
	 */
	public List<IG483Info> getLst_IG483Info() {
		return lst_IG483Info;
	}

	/**
	 * �������б��趨
	 * @param lst_IG483Info �������б�
	 */
	public void setLst_IG483Info(List<IG483Info> lst_IG483Info) {
		this.lst_IG483Info = lst_IG483Info;
	}
	
}
