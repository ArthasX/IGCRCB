/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.form;

import com.deliverik.framework.base.BaseForm;

/**
 * �ʲ���ϵͼ����FORM
 * 
 */
@SuppressWarnings("serial")
public class IGCOM0321Form extends BaseForm {

	/** �ʲ�ID */
	protected String eiid;
	
	/** ��ϵͼXML */
	protected String graphXml;
	
	/** ���������б�XML */
	protected String hostXml;
	
	/** ��ѡ����EIID */
	protected String selectHost;
	
	/** ��ѡ�������� */
	protected String selectHostIndex;
	
	/** Ȩ�ޱ�ʶ */
	protected Boolean flag;
	
	/** ��ϵ�� */
	protected String eircount;
	
	/** ��ID */
	protected Integer domainid;

	/** Domain�汾 */
	protected Integer domainversion;
	
	/** ����ʱ�� */
	protected String updatetime;
	
	/**
	 * �ʲ�IDȡ��
	 * @return �ʲ�ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * �ʲ�ID�趨
	 *
	 * @param eiid �ʲ�ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * ��ϵͼXMLȡ��
	 * 
	 * @return ��ϵͼXML
	 */
	public String getGraphXml() {
		return graphXml;
	}

	/**
	 * ��ϵͼXML�趨
	 * @param graphXml��ϵͼXML
	 */
	public void setGraphXml(String graphXml) {
		this.graphXml = graphXml;
	}
	
	/**
	 * ���������б�XMLȡ��
	 * @return ���������б�XML
	 */
	public String getHostXml() {
		return hostXml;
	}

	/**
	 * ���������б�XML�趨
	 * @param hostXml���������б�XML
	 */
	public void setHostXml(String hostXml) {
		this.hostXml = hostXml;
	}
	
	/**
	 * ��ѡ����EIIDȡ��
	 * @return ��ѡ����EIID
	 */
	public String getSelectHost() {
		return selectHost;
	}

	/**
	 * ��ѡ����EIID�趨
	 * @param selectHost��ѡ����EIID
	 */
	public void setSelectHost(String selectHost) {
		this.selectHost = selectHost;
	}

	/**
	 * ��ѡ��������ȡ��
	 * @return ��ѡ��������
	 */
	public String getSelectHostIndex() {
		return selectHostIndex;
	}

	/**
	 * ��ѡ���������趨
	 * @param selectHostIndex��ѡ��������
	 */
	public void setSelectHostIndex(String selectHostIndex) {
		this.selectHostIndex = selectHostIndex;
	}

	/**
	 * Ȩ�ޱ�ʶȡ��
	 * @return Ȩ�ޱ�ʶ
	 */
	public Boolean getFlag() {
		return flag;
	}

	/**
	 * Ȩ�ޱ�ʶ�趨
	 *
	 * @param flag Ȩ�ޱ�ʶ
	 */
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	/**
	 * ��ϵ��ȡ��
	 * @return ��ϵ��
	 */
	public String getEircount() {
		return eircount;
	}

	/**
	 * ��ϵ���趨
	 *
	 * @param eircount ��ϵ��
	 */
	public void setEircount(String eircount) {
		this.eircount = eircount;
	}
	
	/**
	 * ��IDȡ��
	 *
	 * @return ��ID
	 */
	public Integer getDomainid() {
		return domainid;
	}

	/**
	 * ��ID�趨
	 *
	 * @param domainid ��ID
	 */
	public void setDomainid(Integer domainid) {
		this.domainid = domainid;
	}

	/**
	 * Domain�汾ȡ��
	 *
	 * @return Domain�汾
	 */
	public Integer getDomainversion() {
		return domainversion;
	}

	/**
	 * Domain�汾�趨
	 *
	 * @param domainversion Domain�汾
	 */
	public void setDomainversion(Integer domainversion) {
		this.domainversion = domainversion;
	}
	
	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getUpdatetime() {
		return updatetime;
	}

	/**
	 * ����ʱ���趨
	 *
	 * @param updatetime ����ʱ��
	 */
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	
}
