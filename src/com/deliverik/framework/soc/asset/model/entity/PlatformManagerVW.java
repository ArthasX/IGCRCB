/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.framework.soc.asset.model.PlatformManagerInfo;

/**
 * ����: ҵ��ϵͳ����Աȱʧ��ͼ
 * ��������: ҵ��ϵͳ����Աȱʧ��ͼ
 * ������¼: 2013/12/11
 * �޸ļ�¼: 
 */
@Entity
public class PlatformManagerVW implements Serializable,Cloneable,PlatformManagerInfo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	/**ҵ��ϵͳeiid*/
	private Integer eiid;
	/**ҵ��ϵͳ����*/
	private String	eiName;
	/**ҵ��ϵͳ�Ǽ���Ա*/
	private String eiUserName;
	/**ҵ��ϵͳ�Ǽ�����*/
	private String eiInsDate;
	/**����ԱA*/
	private String magea;
	/**����ԱB*/
	private String mageb;

	public Integer getEiid() {
		return eiid;
	}

	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	public String getEiName() {
		return eiName;
	}

	public void setEiName(String eiName) {
		this.eiName = eiName;
	}

	public String getEiUserName() {
		return eiUserName;
	}

	public void setEiUserName(String eiUserName) {
		this.eiUserName = eiUserName;
	}

	public String getEiInsDate() {
		return eiInsDate;
	}

	public void setEiInsDate(String eiInsDate) {
		this.eiInsDate = eiInsDate;
	}

	public String getMagea() {
		return magea;
	}

	public void setMagea(String magea) {
		this.magea = magea;
	}

	public String getMageb() {
		return mageb;
	}

	public void setMageb(String mageb) {
		this.mageb = mageb;
	}
	
	
	
	
}