/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.xls.prj.dto;

import java.util.List;

import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.infogovernor.prj.model.InvestUseInfoVW;

/**
 * ����: Ͷ��ʹ�����������DTO
 * ����������Ͷ��ʹ�����������DTO
 * �����ˣ���͢־
 * ������¼�� 2012-5-22
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGPRJ0101ExcelDTO extends ExcelDTO{
	/** Ͷ��ʹ����ϸ���� */
	private List<InvestUseInfoVW> investUseInfoList;
	
	/** ��Ŀ���� */
	protected List<CodeDetail> ppqCodeList;
	/** ��Ŀ���� */
	protected List<CodeDetail> ptypeCodeList;

	/**
	 * ��Ŀ����ȡ��
	 * @return ppqCodeList ��Ŀ����
	 */
	public List<CodeDetail> getPpqCodeList() {
		return ppqCodeList;
	}

	/**
	 * ��Ŀ�����趨
	 * @param ppqCodeList ��Ŀ����
	 */
	public void setPpqCodeList(List<CodeDetail> ppqCodeList) {
		this.ppqCodeList = ppqCodeList;
	}

	/**
	 * ��Ŀ����ȡ��
	 * @return ptypeCodeList ��Ŀ����
	 */
	public List<CodeDetail> getPtypeCodeList() {
		return ptypeCodeList;
	}

	/**
	 * ��Ŀ�����趨
	 * @param ptypeCodeList ��Ŀ����
	 */
	public void setPtypeCodeList(List<CodeDetail> ptypeCodeList) {
		this.ptypeCodeList = ptypeCodeList;
	}

	/**
	 * Ͷ��ʹ����ϸ����ȡ��
	 * @return investUseInfoList Ͷ��ʹ����ϸ����
	 */
	public List<InvestUseInfoVW> getInvestUseInfoList() {
		return investUseInfoList;
	}

	/**
	 * Ͷ��ʹ����ϸ�����趨
	 * @param investUseInfoList Ͷ��ʹ����ϸ����
	 */
	public void setInvestUseInfoList(List<InvestUseInfoVW> investUseInfoList) {
		this.investUseInfoList = investUseInfoList;
	}
}
