/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author zhangying@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDRM1602Form extends BaseForm {

	/** �¼�ID */
	private Integer eventId;

	/** �¼����� */
	private String seventName;

	/** �¼����� */
	private Integer labels;
	
	/** �¼����� */
	private String seventDes;
	
	/** ɾ��һ�� */
	private Integer deleteEid;
	
	/**
	 * eventId ȡ��
	 * 
	 * @return eventid eventid
	 */

	public Integer getEventId() {
		return eventId;
	}

	/**
	 * eventId �趨
	 * 
	 * @param eventid  eventid          
	 */
	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}


	/**
	 * labels ȡ��
	 * 
	 * @return labels labels
	 */
	public Integer getLabels() {
		return labels;
	}

	/**
	 * labels �趨
	 * 
	 * @return labels labels
	 */
	public void setLabels(Integer labels) {
		this.labels = labels;
	}
	
	/**
	 * deleteEid ȡ��
	 * 
	 * @return deleteEid deleteEid
	 */
	
	public Integer getDeleteEid() {
		return deleteEid;
	}

	/**
	 * deleteEid �趨
	 * 
	 * @return deleteEid deleteEid
	 */
	public void setDeleteEid(Integer deleteEid) {
		this.deleteEid = deleteEid;
	}

	public String getSeventName() {
		return seventName;
	}

	public void setSeventName(String seventName) {
		this.seventName = seventName;
	}

	public String getSeventDes() {
		return seventDes;
	}

	public void setSeventDes(String seventDes) {
		this.seventDes = seventDes;
	}
	

}
