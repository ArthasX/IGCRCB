/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.drm.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0151Info;

/**
 * �ʲ��������ݱ�ʶ�б�֣�
 * 
 * @author
 * 
 */
public class IGDRM04211VO extends BaseVO implements Serializable {

	private static final long serialVersionUID = 1L;
	/** �ʲ��������ݱ�ʶ�б� */
	private SOC0151Info configurationCodeDetail;

	public SOC0151Info getConfigurationCodeDetail() {
		return configurationCodeDetail;
	}

	public void setConfigurationCodeDetail(
			SOC0151Info configurationCodeDetail) {
		this.configurationCodeDetail = configurationCodeDetail;
	}

}
