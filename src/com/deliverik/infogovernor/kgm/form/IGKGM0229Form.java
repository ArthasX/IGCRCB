/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.kgm.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ����: ֪ʶ��־��ѯ
 * ����������֪ʶ��־��ѯForm
 * ������¼�� 2011-5-30 �½�
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGKGM0229Form extends BaseForm {

	/** ֪ʶID */
	protected Integer klkid;

	/**
	 * ֪ʶID�趨
	 * @param klkid ֪ʶID
	 */
	public void setKlkid(Integer klkid) {
		this.klkid = klkid;
	}

	/**
	 * ֪ʶIDȡ��
	 * @return klkid ֪ʶID
	 */
	public Integer getKlkid() {
		return klkid;
	}

}
