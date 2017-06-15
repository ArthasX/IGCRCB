package com.deliverik.infogovernor.soc.model.condition;


/**
 * ���ռ����Ϣ��ѯ����ʵ��
 * 
 */
public class SocRelationSearchCondImpl implements SocRelationSearchCond {

	/** �ʲ�label */
	protected String sreilabel;
	
	/** �����ʲ�label */
	protected String srpareilabel;
	
	/** �����ʲ�coding */
	protected String sresycoding;
	
	/** �����ʲ��������� */
	protected String srename;
	
	/** Ԥ��1(����汾��) */
	protected String srkey1;
	
	/** �汾�� */
	protected Integer version;
	
	/**
	 * �汾��
	 * @return �汾��
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * �汾���趨
	 *
	 * @param version �汾��
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
	
	
	/**
	 * Ԥ��1(����汾��)
	 * @return Ԥ��1(����汾��)
	 */
	public String getSrkey1() {
		return srkey1;
	}

	/**
	 * Ԥ��1(����汾��)�趨
	 *
	 * @param srkey1 Ԥ��1(����汾��)
	 */
	public void setSrkey1(String srkey1) {
		this.srkey1 = srkey1;
	}

	/**
	 * �ʲ�label
	 * @return �ʲ�label
	 */
	public String getSreilabel() {
		return sreilabel;
	}

	/**
	 * �ʲ�label�趨
	 *
	 * @param sreilabel �ʲ�label
	 */
	public void setSreilabel(String sreilabel) {
		this.sreilabel = sreilabel;
	}

	
	/**
	 * �����ʲ�label
	 * @return �����ʲ�label
	 */
	public String getSrpareilabel() {
		return srpareilabel;
	}

	/**
	 * �����ʲ�label�趨
	 *
	 * @param srpareilabel �����ʲ�label
	 */
	public void setSrpareilabel(String srpareilabel) {
		this.srpareilabel = srpareilabel;
	}

	/**
	 * �����ʲ�coding
	 * @return �����ʲ�coding
	 */
	public String getSresycoding() {
		return sresycoding;
	}

	/**
	 * �����ʲ�coding�趨
	 *
	 * @param sresycoding �����ʲ�coding
	 */
	public void setSresycoding(String sresycoding) {
		this.sresycoding = sresycoding;
	}

	/**
	 * �����ʲ���������
	 * @return �����ʲ���������
	 */
	public String getSrename() {
		return srename;
	}

	/**
	 * �����ʲ����������趨
	 *
	 * @param srename �����ʲ���������
	 */
	public void setSrename(String srename) {
		this.srename = srename;
	}
}
