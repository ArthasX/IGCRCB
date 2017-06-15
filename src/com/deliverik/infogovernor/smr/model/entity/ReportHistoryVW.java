/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.smr.model.ReportHistoryVWInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ������ʷ���¼��ͼʵ��ʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@Entity
public class ReportHistoryVW implements ReportHistoryVWInfo{

	/** �������� */
	@Id
	protected Integer prid;
	
	/** ���ʶ */
	protected String key;
	
	/** ������ */
	protected String prtype;
	
	/** ˵�� */
	protected String reportdesc;

	/**
	 * ��������ȡ��
	 * @return prid ��������
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ���������趨
	 * @param prid ��������
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ���ʶȡ��
	 * @return key ���ʶ
	 */
	public String getKey() {
		return key;
	}

	/**
	 * ���ʶ�趨
	 * @param key ���ʶ
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * ������ȡ��
	 * @return prtype ������
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * �������趨
	 * @param prtype ������
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	/**
	 * ˵��ȡ��
	 * @return reportdesc ˵��
	 */
	public String getReportdesc() {
		return reportdesc;
	}

	/**
	 * ˵���趨
	 * @param reportdesc ˵��
	 */
	public void setReportdesc(String reportdesc) {
		this.reportdesc = reportdesc;
	}
	
	
}
