/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dbm.model.condition;

import java.util.List;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �Ƽ�����ͳ�Ʒ�����ѯ����ʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class ScienceOperationReportSearchCondImpl implements
		ScienceOperationReportSearchCond {

	/** ������ */
	protected String pivarname;
	
	/** ����ѡֵ */
	protected String pidoptions;
	
	/** ���̷���ʱ�� */
	protected String propentime_like;
	
	/** �������ͷ�Χ */
	protected List<String> prpdid_in;

	/**
	 * ������ȡ��
	 * @return pivarname ������
	 */
	public String getPivarname() {
		return pivarname;
	}

	/**
	 * �������趨
	 * @param pivarname ������
	 */
	public void setPivarname(String pivarname) {
		this.pivarname = pivarname;
	}

	/**
	 * ����ѡֵȡ��
	 * @return pidoptions ����ѡֵ
	 */
	public String getPidoptions() {
		return pidoptions;
	}

	/**
	 * ����ѡֵ�趨
	 * @param pidoptions ����ѡֵ
	 */
	public void setPidoptions(String pidoptions) {
		this.pidoptions = pidoptions;
	}

	/**
	 * ���̷���ʱ��ȡ��
	 * @return propentime_like ���̷���ʱ��
	 */
	public String getPropentime_like() {
		return propentime_like;
	}

	/**
	 * ���̷���ʱ���趨
	 * @param propentime_like ���̷���ʱ��
	 */
	public void setPropentime_like(String propentime_like) {
		this.propentime_like = propentime_like;
	}

	/**
	 * �������ͷ�Χȡ��
	 * @return prpdid_in �������ͷ�Χ
	 */
	public List<String> getPrpdid_in() {
		return prpdid_in;
	}

	/**
	 * �������ͷ�Χ�趨
	 * @param prpdid_in �������ͷ�Χ
	 */
	public void setPrpdid_in(List<String> prpdid_in) {
		this.prpdid_in = prpdid_in;
	}
}
