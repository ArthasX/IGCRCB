/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;

import com.deliverik.framework.asset.model.IG545Info;
import com.deliverik.framework.base.BaseVO;

/**
 * �ʲ��������ݱ�ʶ�б�֣�
 * 
 * @author
 * 
 */
public class IGCIM04111VO extends BaseVO implements Serializable {

	private static final long serialVersionUID = 1L;
	/** �ʲ��������ݱ�ʶ�б� */
	private IG545Info configurationCodeDetail;

	public IG545Info getConfigurationCodeDetail() {
		return configurationCodeDetail;
	}

	public void setConfigurationCodeDetail(
			IG545Info configurationCodeDetail) {
		this.configurationCodeDetail = configurationCodeDetail;
	}

}
