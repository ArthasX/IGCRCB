/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0104Info;

/**
 * ����: ���������Ϣ��Ӻ���ϢVO
 * ��������: ���������Ϣ��Ӻ���ϢVO
 * ������¼: 2011/05/019
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGCIM03051VO extends BaseVO implements Serializable {
	
	/**���������Ӻ���Ϣ*/
	protected SOC0104Info SOC0104Info;

	/**
	 * sOC0104Infoȡ��
	 *
	 * @return sOC0104Info sOC0104Info
	 */
	public SOC0104Info getSOC0104Info() {
		return SOC0104Info;
	}

	/**
	 * sOC0104Info�趨
	 *
	 * @param info sOC0104Info
	 */
	public void setSOC0104Info(SOC0104Info info) {
		SOC0104Info = info;
	}

	/**
	 * @param info
	 */
	public IGCIM03051VO(SOC0104Info info) {
		super();
		SOC0104Info = info;
	}
	
	

	
	

}
