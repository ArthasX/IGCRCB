/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.smr.model.entity.BatchExamineVW;

/**
 * ����:��������vo 
 * ������������������vo 
 * �����ˣ�����͢
 * ������¼�� 2013-08-08
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGSMR11031VO extends BaseVO {

	/** �걨�б� */
	protected List<BatchExamineVW> lst_Report;

	/**
	 * �걨�б�ȡ��
	 * 
	 * @return �걨�б�
	 */
	public List<BatchExamineVW> getLst_Report() {
		return lst_Report;
	}

	/**
	 * �걨�б��趨
	 * 
	 * @param lst_Report �걨�б�
	 */
	public void setLst_Report(List<BatchExamineVW> lst_Report) {
		this.lst_Report = lst_Report;
	}
}
