/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;

import com.deliverik.framework.asset.model.EiDomainDefInfo;
import com.deliverik.framework.base.BaseVO;

/**
 * ����: �ʲ�������Ӻ���ϢVO
 * ��������: �ʲ�������Ӻ���ϢVO
 * ������¼: 2011/04/25
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGASM20021VO extends BaseVO implements Serializable{
	/**
	 * �ʲ�������Ӻ���Ϣ
	 */
	protected EiDomainDefInfo eiDomainDefInfo;
	/**
	 * �ʲ�����eiddid
	 */
	protected Integer eiddid;
	/**
	 * �ʲ�����汾��
	 */
	protected Integer version;

	/**
	 * ���캯��
	 * @param eiDomainDefInfo�ʲ�������Ӻ���Ϣ
	 */
	public IGASM20021VO(EiDomainDefInfo eiDomainDefInfo) {
		this.eiDomainDefInfo = eiDomainDefInfo;
	}
	/**
	 * �ʲ�������Ӻ���Ϣȡ��
	 * @return �ʲ�������Ӻ���Ϣ
	 */
	public EiDomainDefInfo getEiDomainDefInfo() {
		return eiDomainDefInfo;
	}
	/**
	 * �ʲ�������Ӻ���Ϣ����
	 * @param eiDomainDefInfo �ʲ�������Ӻ���Ϣ
	 */
	public void setEiDomainDefInfo(EiDomainDefInfo eiDomainDefInfo) {
		this.eiDomainDefInfo = eiDomainDefInfo;
	}
	/**
	 * �ʲ�����eiddidȡ��
	 * @return �ʲ�����eiddid
	 */
	public Integer getEiddid() {
		return eiddid;
	}
	/**
	 * �ʲ�����eiddid�趨
	 * @param eiddid�ʲ�����eiddid
	 */
	public void setEiddid(Integer eiddid) {
		this.eiddid = eiddid;
	}
	/**
	 * �ʲ�����汾��ȡ��
	 * @return �ʲ�����汾��
	 */
	public Integer getVersion() {
		return version;
	}
	/**
	 * �ʲ�����汾���趨
	 * @param version�ʲ�����汾��
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
}
