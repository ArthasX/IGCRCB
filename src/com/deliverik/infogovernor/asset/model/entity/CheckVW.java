/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.asset.model.CheckVWInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: 
 * </p>
 * 
 * @author shenbing@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
public class CheckVW implements Serializable,
Cloneable,CheckVWInfo {

	@Id
	/** ���� */
	protected String eiid;
	
	/** syscoding */
	protected String syscoding;

	/** ��鷽�� */
	protected String checkMethod;
	
	/**������Ƶ��*/
	protected String checkfrequency;

	/**
	 * syscodingȡ��
	 * @return syscoding syscoding
	 */
	public String getSyscoding() {
		return syscoding;
	}

	/**
	 * eiidȡ��
	 * @return eiid eiid
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * eiid�趨
	 * @param eiid eiid
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}
	
	/**
	 * syscoding�趨
	 * @param syscoding syscoding
	 */
	public void setSyscoding(String syscoding) {
		this.syscoding = syscoding;
	}

	/**
	 * ��鷽��ȡ��
	 * @return checkMethod ��鷽��
	 */
	public String getCheckMethod() {
		return checkMethod;
	}

	/**
	 * ��鷽���趨
	 * @param checkMethod ��鷽��
	 */
	public void setCheckMethod(String checkMethod) {
		this.checkMethod = checkMethod;
	}

	/**
	 * ������Ƶ��ȡ��
	 * @return checkfrequency ������Ƶ��
	 */
	public String getCheckfrequency() {
		return checkfrequency;
	}

	/**
	 * ������Ƶ���趨
	 * @param checkfrequency ������Ƶ��
	 */
	public void setCheckfrequency(String checkfrequency) {
		this.checkfrequency = checkfrequency;
	}
	
	public String getFingerPrint() {
		return null;
	}

}
