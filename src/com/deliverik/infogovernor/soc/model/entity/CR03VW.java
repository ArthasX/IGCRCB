/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.model.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import org.apache.commons.lang.StringUtils;
import com.deliverik.infogovernor.soc.model.CR03VWInfo;

/**
  * ����: cr03��ҳ��չʾ��װ��
  * ��������: cr03��ҳ��չʾ��װ��
  * ������¼: 2013/07/15 ��ʡ
  */
@SuppressWarnings("serial")
@Entity
@IdClass(CR03VWPK.class)
public class CR03VW implements Serializable,Cloneable, CR03VWInfo {
	
	/** ���ɼ�ʱ�� */
	protected String maxctime;
	
	/** ��С�ɼ�ʱ�� */
	@Id
	protected String minctime;
	
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
	@Id
	protected Integer type;
	
//	/** ��ʾʱ�� */
//	@Transient
//	protected String maxshowtime;
//	
//	@Transient
//	protected String minshowtime;
	
	/** ģ���� */
	protected String imptypename;
	
	/** �ű��� */
	@Id
	protected String servername;

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
	public String getShowtime(String time) {
		String showtime = "";
		if(StringUtils.isNotEmpty(time)){
			try{
				SimpleDateFormat d1 = new SimpleDateFormat("yyyyMMddHHmmss");
				SimpleDateFormat d2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				showtime = d2.format(d1.parse(time));
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return showtime;
	}

	
	public String getMaxctime() {
		String showtime = "";
		if(StringUtils.isNotEmpty(maxctime)){
			try{
				SimpleDateFormat d1 = new SimpleDateFormat("yyyyMMddHHmmss");
				SimpleDateFormat d2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				showtime = d2.format(d1.parse(maxctime));
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return showtime;
	}

	public void setMaxctime(String maxctime) {
		this.maxctime = maxctime;
	}

	public String getMinctime() {
		return this.minctime;
	}

	public void setMinctime(String minctime) {
		this.minctime = minctime;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMaxshowtime() {
		return getShowtime(maxctime);
	}

//	public void setMaxshowtime(String maxshowtime) {
//		this.maxshowtime = maxshowtime;
//	}

	public String getMinshowtime() {
		return getShowtime(minctime);
	}

//	public void setMinshowtime(String minshowtime) {
//		this.minshowtime = minshowtime;
//	}


	public String getImptypename() {
		return imptypename;
	}

	public void setImptypename(String imptypename) {
		this.imptypename = imptypename;
	}

	public String getServername() {
		return servername;
	}

	public void setServername(String servername) {
		this.servername = servername;
	}
	
}