/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prd.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description:���̲�ѯ��ʾ�п������Form 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRD0146Form extends BaseForm{

	/** ���̶���ID */
	protected String pdid;
	
	/** ��ѯ��ʾ�ж���ID */
	protected String[] sid;
	
	/** ��� */
	protected Integer[] columnWidth;

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
	 * ��ѯ��ʾ�ж���IDȡ��
	 * @return sid ��ѯ��ʾ�ж���ID
	 */
	public String[] getSid() {
		return sid;
	}

	/**
	 * ��ѯ��ʾ�ж���ID�趨
	 * @param sid ��ѯ��ʾ�ж���ID
	 */
	public void setSid(String[] sid) {
		this.sid = sid;
	}

	/**
	 * ���ȡ��
	 * @return columnWidth ���
	 */
	public Integer[] getColumnWidth() {
		return columnWidth;
	}

	/**
	 * ����趨
	 * @param columnWidth ���
	 */
	public void setColumnWidth(Integer[] columnWidth) {
		this.columnWidth = columnWidth;
	}
}
