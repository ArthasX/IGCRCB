/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.smr.model.entity.ReportHistorySearchVW;

/**
 * ����:ͨ�ò�ѯvo 
 * ����������ͨ�ò�ѯvo 
 * �����ˣ�����͢
 * ������¼�� 2013-08-14
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGSMR03051VO extends BaseVO {

	/** ͨ�ò�ѯ���*/
	protected List<ReportHistorySearchVW> list_rhs;

	public List<ReportHistorySearchVW> getList_rhs() {
		return list_rhs;
	}

	public void setList_rhs(List<ReportHistorySearchVW> list_rhs) {
		this.list_rhs = list_rhs;
	}
	
	
}
