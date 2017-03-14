/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0111Info;

/**
 * ����: �ʲ�������Ӻ���ϢVO
 * ��������: �ʲ�������Ӻ���ϢVO
 * ������¼: 2011/04/25
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGCIM02021VO extends BaseVO implements Serializable{
	/**
	 * �ʲ�������Ӻ���Ϣ
	 */
	protected SOC0111Info soc0111Info;
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
	public IGCIM02021VO(SOC0111Info soc0111Info) {
		this.soc0111Info = soc0111Info;
	}
	/**
	 * �ʲ�������Ӻ���Ϣȡ��
	 * @return �ʲ�������Ӻ���Ϣ
	 */
	public SOC0111Info getSoc0111Info() {
		return soc0111Info;
	}
	/**
	 * �ʲ�������Ӻ���Ϣ����
	 * @param eiDomainDefInfo �ʲ�������Ӻ���Ϣ
	 */
	public void setSoc0111Info(SOC0111Info soc0111Info) {
		this.soc0111Info = soc0111Info;
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
