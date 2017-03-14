/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.dto;

import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.infogovernor.smr.form.IGSMR0501Form;
import com.deliverik.infogovernor.smr.form.IGSMR0502Form;
import com.deliverik.infogovernor.smr.model.ReportHistoryVWInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������ҵ���߼�����dto
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGSMR05DTO extends BaseDTO{
	
	/** ��ʷ������Ϣ��ѯform */
	protected IGSMR0501Form igsmr0501Form;
	
	/** �˵��form */
	protected IGSMR0502Form igsmr0502Form;
	
	/** ������Ϣ���� */
	protected List<ReportHistoryVWInfo> reportHistoryVWInfoList;

	/**
	 * ��ʷ������Ϣ��ѯformȡ��
	 * @return igsmr0501Form ��ʷ������Ϣ��ѯform
	 */
	public IGSMR0501Form getIgsmr0501Form() {
		return igsmr0501Form;
	}

	/**
	 * ��ʷ������Ϣ��ѯform�趨
	 * @param igsmr0501Form ��ʷ������Ϣ��ѯform
	 */
	public void setIgsmr0501Form(IGSMR0501Form igsmr0501Form) {
		this.igsmr0501Form = igsmr0501Form;
	}

	/**
	 * ������Ϣ����ȡ��
	 * @return reportHistoryVWInfoList ������Ϣ����
	 */
	public List<ReportHistoryVWInfo> getReportHistoryVWInfoList() {
		return reportHistoryVWInfoList;
	}

	/**
	 * ������Ϣ�����趨
	 * @param reportHistoryVWInfoList ������Ϣ����
	 */
	public void setReportHistoryVWInfoList(
			List<ReportHistoryVWInfo> reportHistoryVWInfoList) {
		this.reportHistoryVWInfoList = reportHistoryVWInfoList;
	}

	/**
	 * �˵��formȡ��
	 * @return igsmr0502Form �˵��form
	 */
	public IGSMR0502Form getIgsmr0502Form() {
		return igsmr0502Form;
	}

	/**
	 * �˵��form�趨
	 * @param igsmr0502Form �˵��form
	 */
	public void setIgsmr0502Form(IGSMR0502Form igsmr0502Form) {
		this.igsmr0502Form = igsmr0502Form;
	}
}
