/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.condition;


/**
  * ����: ʵ����·ͼ��������ʵ��
  * ��������: ʵ����·ͼ��������ʵ��
  * ������¼: 2011/05/24
  * �޸ļ�¼: 
  */
public class EiLinkMapSearchCondImpl implements
		EiLinkMapSearchCond {
	
	/** ��ID */
	protected Integer domainid_eq;

	/** ��汾 */
	protected Integer domainversion_eq;
	
	/** �ʲ�ID */
	protected Integer eiid_eq;
	
	/** ����ʱ�� */
	protected String createtime_eq;
	
	/** ��ͼ��� */
	protected String linkflag_eq;
	
	/** �ʲ������ */
	protected String esyscoding_eq;
	
	protected Integer otherEiid;

	/**
	 * ��IDȡ��
	 * 
	 * @return ��ID
	 */
	public Integer getDomainid_eq() {
		return domainid_eq;
	}

	/**
	 * ��ID�趨
	 * 
	 * @param domainid_eq ��ID
	 */
	public void setDomainid_eq(Integer domainid_eq) {
		this.domainid_eq = domainid_eq;
	}

	/**
	 * ��汾ȡ��
	 * 
	 * @return ��汾
	 */
	public Integer getDomainversion_eq() {
		return domainversion_eq;
	}

	/**
	 * ��汾�趨
	 * 
	 * @param domainversion_eq ��汾
	 */
	public void setDomainversion_eq(Integer domainversion_eq) {
		this.domainversion_eq = domainversion_eq;
	}

	/**
	 * �ʲ�IDȡ��
	 * 
	 * @return �ʲ�ID
	 */
	public Integer getEiid_eq() {
		return eiid_eq;
	}

	/**
	 * �ʲ�ID�趨
	 * 
	 * @param eiid_eq �ʲ�ID
	 */
	public void setEiid_eq(Integer eiid_eq) {
		this.eiid_eq = eiid_eq;
	}

	/**
	 * ����ʱ��ȡ��
	 * 
	 * @return ����ʱ��
	 */
	public String getCreatetime_eq() {
		return createtime_eq;
	}

	/**
	 * ����ʱ���趨
	 * 
	 * @param createtime_eq ����ʱ��
	 */
	public void setCreatetime_eq(String createtime_eq) {
		this.createtime_eq = createtime_eq;
	}

	/**
	 * ��ͼ���ȡ��
	 * 
	 * @return ��ͼ���
	 */
	public String getLinkflag_eq() {
		return linkflag_eq;
	}

	/**
	 * ��ͼ����趨
	 * 
	 * @param linkflag_eq ��ͼ���
	 */
	public void setLinkflag_eq(String linkflag_eq) {
		this.linkflag_eq = linkflag_eq;
	}
	
	/**
	 * �ʲ������ȡ��
	 *
	 * @return �ʲ������
	 */
	public String getEsyscoding_eq() {
		return esyscoding_eq;
	}

	/**
	 * �ʲ�������趨
	 *
	 * @param esyscoding_eq �ʲ������
	 */
	public void setEsyscoding_eq(String esyscoding_eq) {
		this.esyscoding_eq = esyscoding_eq;
	}

	/**
	 * otherEiidȡ��
	 *
	 * @return otherEiid otherEiid
	 */
	public Integer getOtherEiid() {
		return otherEiid;
	}

	/**
	 * otherEiid�趨
	 *
	 * @param otherEiid otherEiid
	 */
	public void setOtherEiid(Integer otherEiid) {
		this.otherEiid = otherEiid;
	}
	
}