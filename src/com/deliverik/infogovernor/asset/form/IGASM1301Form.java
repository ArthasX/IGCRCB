package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.asset.model.condition.IG011SearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * �豸ͳ�Ʒ�����ϢFORM
 * 
 */
@SuppressWarnings("serial")
public class IGASM1301Form extends BaseForm implements IG011SearchCond{


	/** ��ʼʱ���*/
	protected String ciupdtime_to;
	
	/** ��ʼʱ���� */
	protected String ciupdtime_from;
	
	protected String eiorgsyscoding_q;
	
	protected String eiorgsyscoding_qname;
	
	protected String orgType;//0�������� 1ʹ�û���
	
	protected String orgname;
	
	/** �ʲ�ģ���ϼ������*/
	protected String eparcoding;
	
	

	/**
	 * �ʲ�ģ���ϼ������ȡ��
	 * @return �ʲ�ģ���ϼ������
	 */
	public String getEparcoding() {
		return eparcoding;
	}

	/**
	 * �ʲ�ģ���ϼ�������趨
	 *
	 * @param eparcoding �ʲ�ģ���ϼ������
	 */
	public void setEparcoding(String eparcoding) {
		this.eparcoding = eparcoding;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public String getEiorgsyscoding_q() {
		return eiorgsyscoding_q;
	}

	public String getEiorgsyscoding_qname() {
		return eiorgsyscoding_qname;
	}

	public void setEiorgsyscoding_q(String eiorgsyscoding_q) {
		this.eiorgsyscoding_q = eiorgsyscoding_q;
	}

	public void setEiorgsyscoding_qname(String eiorgsyscoding_qname) {
		this.eiorgsyscoding_qname = eiorgsyscoding_qname;
	}

	public String getCiupdtime_to() {
		return ciupdtime_to;
	}

	public void setCiupdtime_to(String ciupdtime_to) {
		this.ciupdtime_to = ciupdtime_to;
	}

	public String getCiupdtime_from() {
		return ciupdtime_from;
	}

	public void setCiupdtime_from(String ciupdtime_from) {
		this.ciupdtime_from = ciupdtime_from;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}


	
}
