/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.form;

import com.deliverik.framework.base.BaseForm;

/**
  * ����: �������Ա�б��ѯForm
  * ��������: �������Ա�б��ѯForm
  * ������¼: 2015/02/03
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
public class IGPRR0502Form extends BaseForm {
	
	/** ������ID */
	protected Integer pgrid;

	/**
	 * ������IDȡ��
	 * @return ������ID
	 */
	public Integer getPgrid() {
		return pgrid;
	}

	/**
	 * ������ID�趨
	 * @param pgrid ������ID
	 */
	public void setPgrid(Integer pgrid) {
		this.pgrid = pgrid;
	}

}