/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;

import com.deliverik.framework.asset.model.ImportVersionInfo;
import com.deliverik.framework.base.BaseVO;

/**
 * ����: ���������Ϣ��Ӻ���ϢVO
 * ��������: ���������Ϣ��Ӻ���ϢVO
 * ������¼: 2011/05/03
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGASM20061VO extends BaseVO implements Serializable{
	
	/**
	 * ���������Ϣ��Ӻ���Ϣ
	 */
	protected ImportVersionInfo importVersionInfo;
	
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
	public IGASM20061VO(ImportVersionInfo importVersionInfo) {
		this.importVersionInfo = importVersionInfo;
	}

	/**
	 * ���������Ϣ��Ӻ���Ϣ
	 * @return ���������Ϣ��Ӻ���Ϣ
	 */
	public ImportVersionInfo getImportVersionInfo() {
		return importVersionInfo;
	}

	/**
	 * ���������Ϣ��Ӻ���Ϣ
	 * @param importVersionInfo���������Ϣ��Ӻ���Ϣ
	 */
	public void setImportVersionInfo(ImportVersionInfo importVersionInfo) {
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
