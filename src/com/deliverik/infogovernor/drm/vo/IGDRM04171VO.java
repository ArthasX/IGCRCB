/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.drm.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.ConfigurationCodeDetailBean;

/**
 * �ʲ��������ݱ�ʶ�б�֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGDRM04171VO extends BaseVO implements Serializable{
	
	/** �ʲ��������ݱ�ʶ�б� */
	protected List<ConfigurationCodeDetailBean> configurationCodeDetailBeanList;

	/**
	 * ���캯��
	 * @param configurationCodeDetailBeanList���ʲ��������ݱ�ʶ�б�
	 */
	public IGDRM04171VO(List<ConfigurationCodeDetailBean> configurationCodeDetailBeanList) {
		this.configurationCodeDetailBeanList = configurationCodeDetailBeanList;
	}
	
	/**
	 * �ʲ��������ݱ�ʶ�б�ȡ��
	 * @return �ʲ��������ݱ�ʶ�б�����
	 */
	public List<ConfigurationCodeDetailBean> getConfigurationCodeDetailBeanList() {
		return configurationCodeDetailBeanList;
	}
}


