/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.model.condition;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ������ʷ���¼��ͼ��ѯ����ʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class ReportHistoryVWSearchCondImpl implements ReportHistoryVWSearchCond{

	/** ������ */
	protected String prtype;
	
	/** ���̶���ID */
	protected String pdid;
	
	/** ��ǰ����ID */
	protected Integer currentPrid;

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
	 * ���̶���IDȡ��
	 * @return pdid ���̶���ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ���̶���ID�趨
	 * @param pdid ���̶���ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ��ǰ����IDȡ��
	 * @return currentPrid ��ǰ����ID
	 */
	public Integer getCurrentPrid() {
		return currentPrid;
	}

	/**
	 * ��ǰ����ID�趨
	 * @param currentPrid ��ǰ����ID
	 */
	public void setCurrentPrid(Integer currentPrid) {
		this.currentPrid = currentPrid;
	}
}
