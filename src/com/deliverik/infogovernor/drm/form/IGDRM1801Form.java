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
public class IGDRM1801Form extends BaseForm {

	/**�Ǽ�ʱ����ʼ*/
	protected String eiinstimeFrom;
	/**�Ǽ�ʱ����ֹ*/
	protected String eiinstimeTo;
	/**
	 *  eiinstimeFrom��ȡ
	 * @return  eiinstimeFrom
	 */
	public String getEiinstimeFrom() {
		return eiinstimeFrom;
	}
	/**
	 * eiinstimeFrom�趨
	 * @param eiinstimeFrom 
	 */
	public void setEiinstimeFrom(String eiinstimeFrom) {
		this.eiinstimeFrom = eiinstimeFrom;
	}
	/**
	 *  eiinstimeTo��ȡ
	 * @return  eiinstimeTo
	 */
	public String getEiinstimeTo() {
		return eiinstimeTo;
	}
	/**
	 * eiinstimeTo�趨
	 * @param eiinstimeTo 
	 */
	public void setEiinstimeTo(String eiinstimeTo) {
		this.eiinstimeTo = eiinstimeTo;
	}
	
	
}
