package com.deliverik.infogovernor.drm.form;

import com.deliverik.framework.base.BaseForm;

/**
 * Ӧ������
 * Ԥ��ͳ��Form
 * 
 * @author kenZ
 *
 */
@SuppressWarnings("serial")
public class IGDRM1811Form extends BaseForm {

	/**�Ǽ�ʱ����ʼ*/
	protected String drillTimeFrom;
	/**�Ǽ�ʱ����ֹ*/
	protected String drillTimeTo;
	public String getDrillTimeFrom() {
		return drillTimeFrom;
	}
	public void setDrillTimeFrom(String drillTimeFrom) {
		this.drillTimeFrom = drillTimeFrom;
	}
	public String getDrillTimeTo() {
		return drillTimeTo;
	}
	public void setDrillTimeTo(String drillTimeTo) {
		this.drillTimeTo = drillTimeTo;
	}


	
	
}
