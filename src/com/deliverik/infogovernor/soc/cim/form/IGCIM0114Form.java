/**
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.cim.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ����: �ɼ���ѯ������ϸ�Ա�Form
 * ��������: �ɼ���ѯ������ϸ�Ա�Form
 * ������¼: zhangnan 2013-6-6
 * �޸ļ�¼: 
 */
public class IGCIM0114Form extends BaseForm{

	private static final long serialVersionUID = -3488451147077991287L;

	/**����*/
	protected String keys;
	
	/**������*/
	protected String tablenames;
	
	/**��������*/
	protected String host;
	
	/**�ɼ�ʱ��*/
	protected String collecttime;
	
	/** ƽ̨IP */
	protected String ip;
	
	/** server���� */
	protected String type;
	
	protected String servername;
	
	

	public String getServername() {
		return servername;
	}

	public void setServername(String servername) {
		this.servername = servername;
	}

	/**
	 * ����ȡ��
	 *
	 * @return keys ����
	 */
	
	public String getKeys() {
		return keys;
	}

	/**
	 * �����趨
	 *
	 * @param keys ����
	 */
	
	public void setKeys(String keys) {
		this.keys = keys;
	}

	/**
	 * ������ȡ��
	 *
	 * @return tablename ������
	 */
	
	public String getTablenames() {
		return tablenames;
	}

	/**
	 * �������趨
	 *
	 * @param tablename ������
	 */
	
	public void setTablenames(String tablenames) {
		this.tablenames = tablenames;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return host ��������
	 */
	
	public String getHost() {
		return host;
	}

	/**
	 * ���������趨
	 *
	 * @param host ��������
	 */
	
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * �ɼ�ʱ��ȡ��
	 *
	 * @return collecttime �ɼ�ʱ��
	 */
	
	public String getCollecttime() {
		return collecttime;
	}

	/**
	 * �ɼ�ʱ���趨
	 *
	 * @param collecttime �ɼ�ʱ��
	 */
	
	public void setCollecttime(String collecttime) {
		this.collecttime = collecttime;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
	
}
