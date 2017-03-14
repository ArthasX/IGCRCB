package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.asset.model.IG612Info;
import com.deliverik.framework.base.BaseVO;

/**
 * �ʲ�����Ĭ��ֵ�֣�
 * 
 */
@SuppressWarnings("serial")
public class IGASM01141VO extends BaseVO implements Serializable{
	
	/** �ʲ�����Ĭ��ֵ���� */
	protected Map<String,List<IG612Info>> map_IG612Info;

	/**
	 * ���캯��
	 * @param map_IG612Info �ʲ�����Ĭ��ֵ����
	 */
	public IGASM01141VO(Map<String,List<IG612Info>> map_IG612Info) {
		this.map_IG612Info = map_IG612Info;
	}
	
	/**
	 * �ʲ�����Ĭ��ֵ����ȡ��
	 * 
	 * @return �ʲ�����Ĭ��ֵ����
	 */
	public Map<String, List<IG612Info>> getMap_IG612Info() {
		return map_IG612Info;
	}
}