/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
/**
 * 
 */
package com.deliverik.infogovernor.iam.form;

import java.io.Serializable;

import com.deliverik.framework.base.BaseForm;

/**
 * @author zhaomin
 *
 */
/**
 * ����: �����������ѯform
 * ���������������������ѯ
 * �����ˣ�����
 * ������¼�� 2012-7-25
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGIAM0201Form extends BaseForm implements Serializable {

	/**
	 * ��ȼƻ�
	 */
	private String iajYear_q;
	/**
	 * ��������
	 */
	private String iajName_like;
	/**
	 * ������ĿID
	 */
	private Integer iajIapId_q;
	
	private String iajiapname;
	
	/**
	 * ��ȡiajYear_q
	 * @return fiajYear_q iajYear_q
	 */
	public String getIajYear_q() {
		return iajYear_q;
	}
	/**
	 * ����iajYear_q
	 * @param iajYear_q  iajYear_q
	 */
	public void setIajYear_q(String iajYear_q) {
		this.iajYear_q = iajYear_q;
	}
	/**
	 * ��ȡiajName_like
	 * @return fiajName_like iajName_like
	 */
	public String getIajName_like() {
		return iajName_like;
	}
	/**
	 * ����iajName_like
	 * @param iajName_like  iajName_like
	 */
	public void setIajName_like(String iajName_like) {
		this.iajName_like = iajName_like;
	}
	/**
	 * ��ȡiajIapId_q
	 * @return fiajIapId_q iajIapId_q
	 */
	public Integer getIajIapId_q() {
		return iajIapId_q;
	}
	/**
	 * ����iajIapId_q
	 * @param iajIapId_q  iajIapId_q
	 */
	public void setIajIapId_q(Integer iajIapId_q) {
		this.iajIapId_q = iajIapId_q;
	}
	public String getIajiapname() {
		return iajiapname;
	}
	public void setIajiapname(String iajiapname) {
		this.iajiapname = iajiapname;
	}
	
}
