package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.asset.model.IG800Info;
import com.deliverik.framework.asset.model.IG887Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.base.BaseVO;

/**
 * �ʲ�����ʷ��¼��Ϣ�֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM02051VO extends BaseVO implements Serializable{
	
	/** �ʲ�����Ϣ */
	protected IG688Info entityItemData;
	
	/** �ʲ���������Ϣ������� */
	protected Map<String,List<IG800Info>> configItemMap;
	
	/** Ȩ�ޱ�ʶ */
	protected Boolean flag;
	
	/** �ʲ��汾�б� */
	protected List<IG887Info> configItemVersionTime;
	
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
	public IGASM02051VO(IG688Info entityItemData,Map<String,List<IG800Info>> configItemMap) {
		this.entityItemData = entityItemData;
		this.configItemMap = configItemMap;
	}
	
	/**
	 * �ʲ�����Ϣȡ��
	 * @return �ʲ�����Ϣ
	 */
	public IG688Info getEntityData() {
		return entityItemData;
	}
	
	/**
	 * �ʲ���������Ϣ�������ȡ��
	 * @return �ʲ���������Ϣ�������
	 */
	public Map<String, List<IG800Info>> getConfigItemMap() {
		return configItemMap;
	}
	

	/**
	 * �ʲ��汾�б�ȡ��
	 * @return �ʲ��汾�б�
	 */
	public List<IG887Info> getConfigItemVersionTime() {
		return configItemVersionTime;
	}

	/**
	 * �ʲ��汾�б��趨
	 *
	 * @param configItemVersionTime �ʲ��汾�б�
	 */
	public void setConfigItemVersionTime(
			List<IG887Info> configItemVersionTime) {
		this.configItemVersionTime = configItemVersionTime;
	}
	
}


