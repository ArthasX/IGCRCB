package com.deliverik.infogovernor.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0605Info;

/**
 * ��ʷ��¼��Ϣ�֣�
 * 
 * @author
 * @updateDate 2014/04/17 LuJiayuan
 * (1)����ΪSOC��Ӧ�ı����ͼ
 */
@SuppressWarnings("serial")
public class IGCOM03081VO extends BaseVO implements Serializable{
	
	/** �ʲ�����Ϣ */
//	protected IG688Info entityItemData;
	/** �ʲ�����Ϣ */
	protected SOC0605Info entityItemData;
	
	/** �ʲ���������Ϣ������� */
//	protected Map<String,List<IG800Info>> configItemMap;
	/** �ʲ���������Ϣ������� */
	protected Map<String,List<SOC0107Info>> configItemMap;	
	
	/** Ȩ�ޱ�ʶ */
	protected Boolean flag;
	
	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	/**
	 * ���캯��
	 * @param entityItemData���ʲ�����Ϣ
	 * @param configItemMap���ʲ���������Ϣ�������
	 */
	public IGCOM03081VO(SOC0605Info entityItemData,Map<String,List<SOC0107Info>> configItemMap) {
		this.entityItemData = entityItemData;
		this.configItemMap = configItemMap;
	}
	
	/**
	 * �ʲ�����Ϣȡ��
	 * @return �ʲ�����Ϣ
	 */
	public SOC0605Info getEntityData() {
		return entityItemData;
	}
	
	/**
	 * �ʲ���������Ϣ�������ȡ��
	 * @return �ʲ���������Ϣ�������
	 */
	public Map<String, List<SOC0107Info>> getConfigItemMap() {
		return configItemMap;
	}
}