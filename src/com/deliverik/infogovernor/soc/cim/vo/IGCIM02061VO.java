/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0120Info;

/**
 * ����: ���������Ϣ��Ӻ���ϢVO
 * ��������: ���������Ϣ��Ӻ���ϢVO
 * ������¼: 2011/05/03
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGCIM02061VO extends BaseVO implements Serializable{
	
	/**
	 * ���������Ϣ��Ӻ���Ϣ
	 */
	protected SOC0120Info importVersionInfo;
	
	/**
	 * ����汾
	 */
	protected Integer impversion;
	
	/**
	 * �������ʵ����
	 */
	protected String impeiname;
	
	/**
	 * ���캯��
	 * @param eiDomainDefInfo�ʲ�Ԥ������Ӻ���Ϣ
	 */
	public IGCIM02061VO(SOC0120Info importVersionInfo) {
		this.importVersionInfo = importVersionInfo;
	}

	/**
	 * ���������Ϣ��Ӻ���Ϣ
	 * @return ���������Ϣ��Ӻ���Ϣ
	 */
	public SOC0120Info getImportVersionInfo() {
		return importVersionInfo;
	}

	/**
	 * ���������Ϣ��Ӻ���Ϣ
	 * @param importVersionInfo���������Ϣ��Ӻ���Ϣ
	 */
	public void setImportVersionInfo(SOC0120Info importVersionInfo) {
		this.importVersionInfo = importVersionInfo;
	}

	/**
	 * ����汾
	 * @return ����汾
	 */
	public Integer getImpversion() {
		return impversion;
	}

	/**
	 * ����汾
	 * @param impversion����汾
	 */
	public void setImpversion(Integer impversion) {
		this.impversion = impversion;
	}

	/**
	 * �������ʵ����
	 * @return �������ʵ����
	 */
	public String getImpeiname() {
		return impeiname;
	}

	/**
	 * �������ʵ����
	 * @param impeiname�������ʵ����
	 */
	public void setImpeiname(String impeiname) {
		this.impeiname = impeiname;
	}
	
	

}
