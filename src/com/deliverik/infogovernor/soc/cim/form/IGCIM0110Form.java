/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.cim.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ����Դ������ʾform
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCIM0110Form extends BaseForm {

	/** �豸���� */
	protected Integer eiid;
	
	/** �ļ����� */
	protected String host;
	
	/** ���� */
	protected String tablename;

	/** ��ʷ�汾��ʼʱ�� */
	protected String collecttimeFrom;
	
	/** ��ʷ�汾����ʱ�� */
	protected String collecttimeTo;
	
	/** �Ƿ�Ϊ�״η��� */
	protected String firstAccess;
	
	/** ip */
	protected String ip;
	
	/** server���� */
	protected String type;
	
	protected String collecttime;
	
	protected String servername;
	
	
	public String getCollecttime() {
		return collecttime;
	}

	public void setCollecttime(String collecttime) {
		this.collecttime = collecttime;
	}

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
	 * ����ȡ��
	 * @return ����
	 */
	public String getTablename() {
		return tablename;
	}

	/**
	 * �����趨
	 * @param tablenames ����
	 */
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	/**
	 * ��ʷ�汾��ʼʱ��ȡ��
	 * @return ��ʷ�汾��ʼʱ��
	 */
	public String getCollecttimeFrom() {
		return collecttimeFrom;
	}

	/**
	 * ��ʷ�汾��ʼʱ���趨
	 * @param vdatestart ��ʷ�汾��ʼʱ��
	 */
	public void setCollecttimeFrom(String collecttimeFrom) {
		this.collecttimeFrom = collecttimeFrom;
	}

	/**
	 * ��ʷ�汾����ʱ��ȡ��
	 * @return ��ʷ�汾����ʱ��
	 */
	public String getCollecttimeTo() {
		return collecttimeTo;
	}

	/**
	 * ��ʷ�汾����ʱ���趨
	 * @param vdatestart ��ʷ�汾����ʱ��
	 */
	public void setCollecttimeTo(String collecttimeTo) {
		this.collecttimeTo = collecttimeTo;
	}
	
	/**
	 * �Ƿ�Ϊ�״η���ȡ��
	 * @return �Ƿ�Ϊ�״η���
	 */
	public String getFirstAccess() {
		return firstAccess;
	}

	/**
	 * �Ƿ�Ϊ�״η����趨
	 * @param firstAccess �Ƿ�Ϊ�״η���
	 */
	public void setFirstAccess(String firstAccess) {
		this.firstAccess = firstAccess;
	}
	
	/**
	 * ��дreset����
	 */
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		this.tablename = null;
		this.collecttimeTo = null;
		this.collecttimeFrom = null;
		this.firstAccess = null;
	}

	/**
	 * �ļ�����ȡ��
	 *
	 * @return host �ļ�����
	 */
	
	public String getHost() {
		return host;
	}

	/**
	 * �ļ������趨
	 *
	 * @param host �ļ�����
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
