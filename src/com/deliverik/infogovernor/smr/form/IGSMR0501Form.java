/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��ʷ���ݷ�����Ϣform
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGSMR0501Form extends BaseForm{

	/** �����ʶ */
	protected String prtype;
	
	/** ���̶���ID */
	protected String pdid;
	
	/** ��ǰ�������� */
	protected Integer currentPrid;
	
	/** ���ư�ť��ʶ */
	protected String showCopy;

	/**
	 * �����ʶȡ��
	 * @return prtype �����ʶ
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * �����ʶ�趨
	 * @param prtype �����ʶ
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
	 * ��ǰ��������ȡ��
	 * @return currentPrid ��ǰ��������
	 */
	public Integer getCurrentPrid() {
		return currentPrid;
	}

	/**
	 * ��ǰ���������趨
	 * @param currentPrid ��ǰ��������
	 */
	public void setCurrentPrid(Integer currentPrid) {
		this.currentPrid = currentPrid;
	}

	/**
	 * ���ư�ť��ʶȡ��
	 * @return showCopy ���ư�ť��ʶ
	 */
	public String getShowCopy() {
		return showCopy;
	}

	/**
	 * ���ư�ť��ʶ�趨
	 * @param showCopy ���ư�ť��ʶ
	 */
	public void setShowCopy(String showCopy) {
		this.showCopy = showCopy;
	}
}
