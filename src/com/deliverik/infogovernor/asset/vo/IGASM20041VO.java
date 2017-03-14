/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.ImportVersionInfo;
import com.deliverik.framework.base.BaseVO;

/**
 * �ʲ��������ݱ�ʶ�б�֣�
 * 
 * @author
 * 
 */
public class IGASM20041VO extends BaseVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * ������ʲ�
	 */
	private List<ImportVersionInfo> ownImportVersion;
	
	/**
	 * δ����ʲ�
	 */
	private List<ImportVersionInfo> otherImportVersion;
	
	
	/**
	 * ���캯��
	 * @param ownImportVersion
	 * @param otherImportVersion
	 */
	public IGASM20041VO(List<ImportVersionInfo> ownImportVersion,List<ImportVersionInfo> otherImportVersion){
		this.otherImportVersion = otherImportVersion;
		this.ownImportVersion = ownImportVersion;
	}
	/**
	 * ������ʲ�ȡ��
	 * @return ������ʲ�
	 */
	public List<ImportVersionInfo> getOwnImportVersion() {
		return ownImportVersion;
	}
	/**
	 * ������ʲ��趨
	 * @param ownImportVersion������ʲ�
	 */
	public void setOwnImportVersion(List<ImportVersionInfo> ownImportVersion) {
		this.ownImportVersion = ownImportVersion;
	}
	/**
	 * δ����ʲ�ȡ��
	 * @return δ����ʲ�
	 */
	public List<ImportVersionInfo> getOtherImportVersion() {
		return otherImportVersion;
	}
	/**
	 * δ����ʲ��趨
	 * @param otherImportVersionδ����ʲ�
	 */
	public void setOtherImportVersion(List<ImportVersionInfo> otherImportVersion) {
		this.otherImportVersion = otherImportVersion;
	}
	
}
