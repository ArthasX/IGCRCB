/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.IG545Bean;
import com.deliverik.framework.base.BaseVO;

/**
 * �ʲ��������ݱ�ʶ�б�֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCIM04071VO extends BaseVO implements Serializable{
	
	/** �ʲ��������ݱ�ʶ�б� */
	protected List<IG545Bean> configurationCodeDetailBeanList;

	/**
	 * ���캯��
	 * @param configurationCodeDetailBeanList���ʲ��������ݱ�ʶ�б�
	 */
	public IGCIM04071VO(List<IG545Bean> configurationCodeDetailBeanList) {
		this.configurationCodeDetailBeanList = configurationCodeDetailBeanList;
	}
	
	/**
	 * �ʲ��������ݱ�ʶ�б�ȡ��
	 * @return �ʲ��������ݱ�ʶ�б�����
	 */
	public List<IG545Bean> getConfigurationCodeDetailBeanList() {
		return configurationCodeDetailBeanList;
	}
}


