/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.cim.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ����Դ���ݱȽϰ汾form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCIM0111Form extends BaseForm{

	/** �豸���� */
	protected Integer eiid;
	
	/** �������� */
	protected String tablenames;
	
	/**�ɼ��ļ���*/
	protected String host;
	
	/** ƽ̨IP */
	protected String ip;
	
	/** server���� */
	protected String type;
	
	protected String servername;
	
	/**
	 * �豸����ȡ��
	 * @return �豸����
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * �豸�����趨
	 * @param eiid �豸����
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getTablenames() {
		return tablenames;
	}

	/**
	 * ���������趨
	 * @param tablenames ��������
	 */
	public void setTablenames(String tablenames) {
		this.tablenames = tablenames;
	}

	/**
	 * �ɼ��ļ���ȡ��
	 *
	 * @return host �ɼ��ļ���
	 */
	
	public String getHost() {
		return host;
	}

	/**
	 * �ɼ��ļ����趨
	 *
	 * @param host �ɼ��ļ���
	 */
	
	public void setHost(String host) {
		this.host = host;
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

	public String getServername() {
		return servername;
	}

	public void setServername(String servername) {
		this.servername = servername;
	}
}
