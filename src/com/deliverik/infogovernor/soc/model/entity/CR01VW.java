/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.soc.model.CR01VWInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �ɼ�������Ϣ��ʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@Entity
@IdClass(CR01PK.class)
@SuppressWarnings("serial")
public class CR01VW extends BaseEntity implements CR01VWInfo{
	
	/** �豸��ʶ */
	@Id
	protected String host;
	
	/** �ɼ�ʱ�� */
	@Id
	protected String collecttime;
	
	/** �ɼ����� */
	@Id
	protected String command;
	
	/** �ɼ����˳�� */
	@Id
	protected Integer cdataorder;
	
	/** �ɼ���� */
	protected String cdata;
	
	/** ����ʱ�� */
	protected String inserttime;
	
	/** ������� */
	protected String category;
	
	/** �ؼ��� */
	protected String keys;
	
	/** ƽ̨IP */
	@Id
	protected String ip;
	
	/** server�� */
	@Id
	protected String servername;
	
	/** server���� */
	@Id
	protected String servertype;

	/**
	 * ������ʶȡ��
	 * @return ������ʶ
	 */
	public String getHost() {
		return host;
	}

	/**
	 * ����i��ʶ�趨
	 * @param host ������ʶ
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * �ɼ�ʱ��ȡ��
	 * @return �ɼ�ʱ��
	 */
	public String getCollecttime() {
		return collecttime;
	}

	/**
	 * �ɼ�ʱ���趨
	 * @param collecttime �ɼ�ʱ��
	 */
	public void setCollecttime(String collecttime) {
		this.collecttime = collecttime;
	}

	/**
	 * �ɼ�����ȡ��
	 * @return �ɼ�����
	 */
	public String getCommand() {
		return command;
	}

	/**
	 * �ɼ������趨
	 * @param command �ɼ�����
	 */
	public void setCommand(String command) {
		this.command = command;
	}

	/**
	 * �ɼ����˳��ȡ��
	 * @return �ɼ����˳��
	 */
	public Integer getCdataorder() {
		return cdataorder;
	}

	/**
	 * �ɼ����˳���趨
	 * @param cdataorder �ɼ����˳��
	 */
	public void setCdataorder(Integer cdataorder) {
		this.cdataorder = cdataorder;
	}

	/**
	 * �ɼ����ȡ��
	 * @return �ɼ����
	 */
	public String getCdata() {
		return cdata;
	}

	/**
	 * �ɼ�����趨
	 * @param cdata �ɼ����
	 */
	public void setCdata(String cdata) {
		this.cdata = cdata;
	}

	/**
	 * ����ʱ��ȡ��
	 * @return ����ʱ��
	 */
	public String getInserttime() {
		return inserttime;
	}

	/**
	 * ����ʱ���趨
	 * @param inserttime ����ʱ��
	 */
	public void setInserttime(String inserttime) {
		this.inserttime = inserttime;
	}
	
	/**
	 * �������ȡ��
	 * @return �������
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * ��������趨
	 * @param category �������
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * �ؼ���ȡ��
	 * @return �ؼ���
	 */
	public String getKeys() {
		return keys;
	}

	/**
	 * �ؼ����趨
	 * @param keys �ؼ���
	 */
	public void setKeys(String keys) {
		this.keys = keys;
	}

	/**
	 * ����ȡ��
	 * @return ����
	 */
	public Serializable getPK() {
		return new CR01PK(host, collecttime, command, cdataorder, ip, servername, servertype);
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getServername() {
		return servername;
	}

	public void setServername(String servername) {
		this.servername = servername;
	}

	public String getServertype() {
		return servertype;
	}

	public void setServertype(String servertype) {
		this.servertype = servertype;
	}
	
	
}
