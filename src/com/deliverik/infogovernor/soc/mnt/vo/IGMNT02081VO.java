/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.mnt.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0305Info;

/**
 * ����: ������־�����֣�
 * ��������: ������־�����֣�
 * ������¼: 2011/06/09
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGMNT02081VO extends BaseVO implements Serializable{
	
	/**������־ */
    protected SOC0305Info soc0305Info;

	/**
	 * ������־ȡ��
	 *
	 * @return soc0305Info ������־
	 */
	public SOC0305Info getSoc0305Info() {
		return soc0305Info;
	}

	/**
	 * ������־�趨
	 *
	 * @param soc0305Info ������־
	 */
	public void setSoc0305Info(SOC0305Info soc0305Info) {
		this.soc0305Info = soc0305Info;
	}

}
