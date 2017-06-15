/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0120Info;

/**
 * �ʲ��������ݱ�ʶ�б�֣�
 * 
 * @author
 * 
 */
public class IGCIM02041VO extends BaseVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * ������ʲ�
	 */
	private List<SOC0120Info> ownImportVersion;
	
	/**
	 * δ����ʲ�
	 */
	private List<SOC0120Info> otherImportVersion;
	
	
	/**
	 * ���캯��
	 * @param ownImportVersion
	 * @param otherImportVersion
	 */
	public IGCIM02041VO(List<SOC0120Info> ownImportVersion,List<SOC0120Info> otherImportVersion){
		this.otherImportVersion = otherImportVersion;
		this.ownImportVersion = ownImportVersion;
	}
	/**
	 * ������ʲ�ȡ��
	 * @return ������ʲ�
	 */
	public List<SOC0120Info> getOwnImportVersion() {
		return ownImportVersion;
	}
	/**
	 * ������ʲ��趨
	 * @param ownImportVersion������ʲ�
	 */
	public void setOwnImportVersion(List<SOC0120Info> ownImportVersion) {
		this.ownImportVersion = ownImportVersion;
	}
	/**
	 * δ����ʲ�ȡ��
	 * @return δ����ʲ�
	 */
	public List<SOC0120Info> getOtherImportVersion() {
		return otherImportVersion;
	}
	/**
	 * δ����ʲ��趨
	 * @param otherImportVersionδ����ʲ�
	 */
	public void setOtherImportVersion(List<SOC0120Info> otherImportVersion) {
		this.otherImportVersion = otherImportVersion;
	}
	
}
