/**
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.cim.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ����: �ɼ���ѯ֮��������ϸ��ѯForm
 * ��������: �ɼ���ѯ֮��������ϸ��ѯForm
 * ������¼: yanglongquan 2013-5-31
 * �޸ļ�¼: 
 */
public class IGCIM0112Form extends BaseForm{

	private static final long serialVersionUID = -3488451147077991287L;

	/**����*/
	protected String keys;
	
	/**������*/
	protected String tablename;
	
	/**��������*/
	protected String host;
	
	/**�ɼ�ʱ��*/
	protected String collecttime;
	
	/** server���� */
	protected String type;
	
	/** ƽ̨IP */
	protected String ip;
	
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
	
	public String getTablename() {
		return tablename;
	}

	/**
	 * �������趨
	 *
	 * @param tablename ������
	 */
	
	public void setTablename(String tablename) {
		this.tablename = tablename;
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
	
	/**
	 * ����ȡ��
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * �����趨
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * ƽ̨ipȡ��
	 * @return
	 */
	public String getIp() {
		return ip;
	}
	
	/**
	 * ƽ̨ip�趨
	 * @param ip
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	
	
	
}
