/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.xls.prj.dto;

import java.util.List;

import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.prj.model.InvestContractInfoVW;

/**
 * ����: Ͷ�ʺ�ͬ��ϸ����dto
 * ����������Ͷ�ʺ�ͬ��ϸ����dto
 * �����ˣ���͢־
 * ������¼�� 2012-5-25
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGPRJ0110ExcelDTO extends ExcelDTO{
	/** Ͷ�ʺ�ͬ��ϸ���� */
	private List<InvestContractInfoVW> investContractList;

	/**
	 * Ͷ�ʺ�ͬ��ϸ����ȡ��
	 * @return investContractList Ͷ�ʺ�ͬ��ϸ����
	 */
	public List<InvestContractInfoVW> getInvestContractList() {
		return investContractList;
	}

	/**
	 * Ͷ�ʺ�ͬ��ϸ�����趨
	 * @param investContractList Ͷ�ʺ�ͬ��ϸ����
	 */
	public void setInvestContractList(List<InvestContractInfoVW> investContractList) {
		this.investContractList = investContractList;
	}
}
