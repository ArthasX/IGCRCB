/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG500Info;

/**
 * ����: �������Ա��ѯVO
 * ��������: �������Ա��ѯVO
 * ������¼: 2015/02/03
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGPRR05021VO extends BaseVO {

	/** �������Ա�б� */
	protected List<IG500Info> lst_IG500Info;

	/**
	 * �������Ա�б�ȡ��
	 * @return �������Ա�б�
	 */
	public List<IG500Info> getLst_IG500Info() {
		return lst_IG500Info;
	}

	/**
	 * �������Ա�б��趨
	 * @param lst_IG500Info �������Ա�б�
	 */
	public void setLst_IG500Info(List<IG500Info> lst_IG500Info) {
		this.lst_IG500Info = lst_IG500Info;
	}
	
}
