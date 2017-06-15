package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0109Info;

/**
 * �ʲ�������Ϣ��������֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM01061VO extends BaseVO implements Serializable{
	
	/** �ʲ�������Ϣ��������� */
	Map<String,List<SOC0109Info>> configurationMap;

	/**
	 * ���캯��
	 * @param configurationMap���ʲ�������Ϣ�������
	 */
	public IGASM01061VO(Map<String, List<SOC0109Info>> configurationMap) {
		this.configurationMap = configurationMap;
	}
	
	/**
	 * �ʲ�������Ϣ���������ȡ��
	 * @return �ʲ�������Ϣ���������
	 */
	public Map<String, List<SOC0109Info>> getConfigurationMap() {
		return configurationMap;
	}
}


