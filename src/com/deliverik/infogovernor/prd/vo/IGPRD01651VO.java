/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prd.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG373Info;

/**
 * ����: ����ʼ�����ò�ѯVO
 * ��������: ����ʼ�����ò�ѯVO
 * ������¼: 2012/04/11
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGPRD01651VO extends BaseVO implements Serializable{

	/** ����ʼ�������б� */
	protected List<IG373Info> lst_IG373Info;
	
	/**
	 * ����ʼ�������б�ȡ��
	 * 
	 * @return ����ʼ�������б�
	 */
	public List<IG373Info> getLst_IG373Info() {
		return lst_IG373Info;
	}

	/**
	 * ����ʼ�������б��趨
	 * 
	 * @param lst_IG373Info ����ʼ�������б�
	 */
	public void setLst_IG373Info(List<IG373Info> lst_IG373Info) {
		this.lst_IG373Info = lst_IG373Info;
	}
	
}


