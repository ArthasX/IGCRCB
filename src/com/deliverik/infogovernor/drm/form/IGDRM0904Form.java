/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.drm.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * </p>
 * 
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGDRM0904Form extends BaseForm{
	
	private Integer ptid;
	
	/**Ӧ������prid*/
	private String drillPrid;
	
	/**
	 * ptid   ȡ��
	 * @return ptid ptid
	 */
	public Integer getPtid() {
		return ptid;
	}
	/**
	 * ptid   �趨
	 * @param ptid ptid
	 */
	public void setPtid(Integer ptid) {
		this.ptid = ptid;
	}
	/**
	 * drillPrid   ȡ��
	 * @return drillPrid drillPrid
	 */
	public String getDrillPrid() {
		return drillPrid;
	}
	/**
	 * drillPrid   �趨
	 * @param drillPrid drillPrid
	 */
	public void setDrillPrid(String drillPrid) {
		this.drillPrid = drillPrid;
	}
	
}
