package com.deliverik.infogovernor.drm.form;

import com.deliverik.framework.base.BaseForm;

/**
 * Ӧ������
 * Ԥ��ͳ����ȡForm
 * 
 * @author zhangjian
 *
 */
@SuppressWarnings("serial")
public class IGDRM1802Form extends BaseForm {

	/**�Ǽ�ʱ����ʼ*/
	protected String eiinstimeFrom;
	/**�Ǽ�ʱ����ֹ*/
	protected String eiinstimeTo;
	
	/**�ʲ��㼶��*/
	protected String esyscoding;
	
	/**��ѯ��ʶ*/
	protected String searchFlag;
	
	protected String einame;
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
	public String getEsyscoding() {
		return esyscoding;
	}
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
	public String getSearchFlag() {
		return searchFlag;
	}
	public void setSearchFlag(String searchFlag) {
		this.searchFlag = searchFlag;
	}
	public String getEiname() {
		return einame;
	}
	public void setEiname(String einame) {
		this.einame = einame;
	}
	
	
}
