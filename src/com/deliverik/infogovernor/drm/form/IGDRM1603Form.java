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
 * Description:
 * </p>
 * 
 * @author zhangying@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDRM1603Form extends BaseForm {
	
	/** ����ID */
	protected Integer upEventid;
	
	/**�¼�����*/
	protected String upEventname;
	
	/**�¼���ǩ*/
	protected Integer upLabels;  
	
	/**�¼�����*/
	protected String upEventdes;  
	
	/**��־*/
	protected String flag; 

	/**
	 * upEventid ȡ��
	 * 
	 * @return upEventid upEventid
	 */
	public Integer getUpEventid() {
		return upEventid;
	}
	
	/**
	 * upEventid �趨
	 * 
	 * @return upEventid upEventid
	 */

	public void setUpEventid(Integer upEventid) {
		this.upEventid = upEventid;
	}

	/**
	 * upEventname ȡ��
	 * 
	 * @return upEventname upEventname
	 */
	public String getUpEventname() {
		return upEventname;
	}

	/**
	 * upEventname �趨
	 * 
	 * @return upEventname upEventname
	 */
	public void setUpEventname(String upEventname) {
		this.upEventname = upEventname;
	}

	/**
	 * upLabels ȡ��
	 * 
	 * @return upLabels upLabels
	 */
	public Integer getUpLabels() {
		return upLabels;
	}

	/**
	 * upLabels �趨
	 * 
	 * @return upLabels upLabels
	 */
	public void setUpLabels(Integer upLabels) {
		this.upLabels = upLabels;
	}

	/**
	 * flag ȡ��
	 * 
	 * @return flag flag
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * flag �趨
	 * 
	 * @return flag flag
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * upEventdes ȡ��
	 * 
	 * @return upEventdes upEventdes
	 */
	public String getUpEventdes() {
		return upEventdes;
	}

	/**
	 * upEventdes �趨
	 * 
	 * @return upEventdes upEventdes
	 */
	public void setUpEventdes(String upEventdes) {
		this.upEventdes = upEventdes;
	}
	
	

}
