/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.IG545Info;
import com.deliverik.framework.base.BaseVO;

/**
 * �ʲ��������ݱ�ʶ�б�֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCIM04091VO extends BaseVO implements Serializable{
	
	/** �ʲ��������ݱ�ʶ�б� */
	protected List<IG545Info> configurationCodeDetailList;

	/**
	 * ���캯��
	 * @param configurationCodeDetailBeanList���ʲ��������ݱ�ʶ�б�
	 */
	public IGCIM04091VO(List<IG545Info> configurationCodeDetailList) {
		this.configurationCodeDetailList = configurationCodeDetailList;
	}

	public List<IG545Info> getConfigurationCodeDetailList() {
		return configurationCodeDetailList;
	}

}


