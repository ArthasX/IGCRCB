/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.drm.model.EmergencyLogInfo;

/**
 * ������Ӧ����־��Ϣ��ʵ��
 * ����������Ӧ����־��Ϣ��ʵ��
 * ������¼��2014/05/19
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
@Entity
@Table(name="emergencylog")
public class EmergencyLogTB extends BaseEntity implements Serializable, Cloneable, EmergencyLogInfo {
	/**����ID*/
    @Id
    @TableGenerator(
        name="EMERGENCYLOG_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
        pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
        pkColumnValue="EMERGENCYLOG_SEQUENCE", initialValue=1, allocationSize=1
    )
    @GeneratedValue(strategy = GenerationType.TABLE, generator="EMERGENCYLOG_TABLE_GENERATOR")
	protected Integer elid;
	/**Ӧ����������ID*/
	protected Integer elprid;
	/**��־��Ϣ����*/
	protected String ellitype;
	/**��־��Ϣ����ʱ��*/
	protected String ellidtime;
	/**��־��Ϣ�������û�ID*/
	protected String eluserid;
	/**��־��Ϣ�������û�����*/
	protected String elusername;
	/**��־��Ϣ����*/
	protected String elliinfo;
	/**��־״̬ID*/
	protected String elpsdid;

	/**��־״̬����*/
	protected String elpsdname;
	
	/**������Ϣ*/
	protected String operate;
	/**
	 * Getter and Setter
	 */
	@Override
	/**
	 * ����ȡ��
	 * @return elid
	 */
	public Serializable getPK() {
		return elid;
	}
	/**
	 * ����IDȡ��
	 * @return elid
	 */
	public Integer getElid() {
		return elid;
	}
	/**
	 * ����ID�趨
	 * @param ecid
	 */
	public void setElid(Integer elid) {
		this.elid = elid;
	}
	
	/**
	 * Ӧ����������IDȡ��
	 * @return elprid
	 */
	public Integer getElprid() {
		return elprid;
	}
	/**
	 * Ӧ����������ID�趨
	 * @param elprid
	 */
	public void setElprid(Integer elprid) {
		this.elprid = elprid;
	}
	
	/**
	 * ��־��Ϣ����ȡ��
	 * @return ellitype
	 */
	public String getEllitype() {
		return ellitype;
	}
	/**
	 * ��־��Ϣ�����趨
	 * @param ellitype
	 */
	public void setEllitype(String ellitype) {
		this.ellitype = ellitype;
	}
	
	/**
	 * ��־��Ϣ����ʱ��ȡ��
	 * @return ellidtime
	 */
	public String getEllidtime() {
		return ellidtime;
	}
	/**
	 * ��־��Ϣ����ʱ���趨
	 * @param ellidtime
	 */
	public void setEllidtime(String ellidtime) {
		this.ellidtime = ellidtime;
	}
	
	/**
	 * ��־��Ϣ�������û�IDȡ��
	 * @return eluserid
	 */
	public String getEluserid() {
		return eluserid;
	}
	/**
	 * ��־��Ϣ�������û�ID�趨
	 * @param eluserid
	 */
	public void setEluserid(String eluserid) {
		this.eluserid = eluserid;
	}
	
	/**
	 * ��־��Ϣ�������û�����ȡ��
	 * @return elusername
	 */
	public String getElusername() {
		return elusername;
	}
	/**
	 * ��־��Ϣ�������û������趨
	 * @param elusername
	 */
	public void setElusername(String elusername) {
		this.elusername = elusername;
	}
	
	/**
	 * ��־��Ϣ����ȡ��
	 * @return elliinfo
	 */
	public String getElliinfo() {
		return elliinfo;
	}
	/**
	 * ��־��Ϣ�����趨
	 * @param elliinfo
	 */
	public void setElliinfo(String elliinfo) {
		this.elliinfo = elliinfo;
	}
	public String getElpsdid() {
		return elpsdid;
	}
	public void setElpsdid(String elpsdid) {
		this.elpsdid = elpsdid;
	}
	public String getElpsdname() {
		return elpsdname;
	}
	public void setElpsdname(String elpsdname) {
		this.elpsdname = elpsdname;
	}
	/**  
	 * ��ȡoperate  
	 * @return operate 
	 */
	public String getOperate() {
		return operate;
	}
	/**  
	 * ����operate  
	 * @param operate
	 */
	
	public void setOperate(String operate) {
		this.operate = operate;
	}
	
}