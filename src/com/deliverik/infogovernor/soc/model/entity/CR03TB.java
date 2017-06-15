/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.model.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.soc.asset.model.entity.SOC0113TB;
import com.deliverik.infogovernor.soc.model.CR03Info;

/**
  * ����: ����ԭ������������ϵ��ʵ��
  * ��������: ����ԭ������������ϵ��ʵ��
  * ������¼: 2013/04/08
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(CR03PK.class)
@Table(name="CR03" )
public class CR03TB extends BaseEntity implements Serializable,Cloneable, CR03Info {
	
	@Id
	/** �ɼ�ʱ�� */
	protected String collecttime;
	
	@Id
	protected String ip;
	
	/** �������� */
	protected String tablename;

	/** ������ʶ */
	@Id
	protected String host;
	
	/** ״̬ */
	protected String status;
	
	/** ���� */
	protected Integer type;
	
	/** ��ʾʱ�� */
	@Transient
	protected String showtime;
	
	/** server�� */
	@Id
	protected String servername;
	


	/** �������������Ϣ */
	@ManyToOne
	@JoinColumn(name="type", referencedColumnName="impTypeid",  updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected SOC0113TB soc0113TB;
	
	

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getTablename() {
		return tablename;
	}

	/**
	 * ���������趨
	 *
	 * @param tablename ��������
	 */
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	/**
	 * ������ʶȡ��
	 *
	 * @return ������ʶ
	 */
	public String getHost() {
		return host;
	}

	/**
	 * ������ʶ�趨
	 *
	 * @param host ������ʶ
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * ״̬ȡ��
	 * @return ״̬
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * ״̬�趨
	 * @param status ״̬
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * ����ȡ��
	 * @return ����
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * �����趨
	 * @param type ����
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * ��ʾʱ��ȡ��
	 * @return ��ʾʱ��
	 */
	public String getShowtime() {
		if(StringUtils.isNotEmpty(collecttime)){
			try{
				SimpleDateFormat d1 = new SimpleDateFormat("yyyyMMddHHmmss");
				SimpleDateFormat d2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				showtime = d2.format(d1.parse(collecttime));
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return showtime;
	}

	

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}


	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return new CR03PK(type, ip, host,collecttime);
	}

	/**
	 * �������������Ϣȡ��
	 *
	 * @return soc0113TB �������������Ϣ
	 */
	@Basic(optional=false)
	public SOC0113TB getSoc0113TB() {
		return soc0113TB;
	}

	/**
	 * �������������Ϣ�趨
	 *
	 * @param soc0113TB �������������Ϣ
	 */
	public void setSoc0113TB(SOC0113TB soc0113TB) {
		this.soc0113TB = soc0113TB;
	}

	public String getCollecttime() {
		return collecttime;
	}

	public void setCollecttime(String collecttime) {
		this.collecttime = collecttime;
	}

	public void setShowtime(String showtime) {
		this.showtime = showtime;
	}

	public String getServername() {
		return servername;
	}

	public void setServername(String servername) {
		this.servername = servername;
	}
	
}