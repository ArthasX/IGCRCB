package com.deliverik.infogovernor.drm.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0118VWInfo;
import com.deliverik.framework.soc.asset.model.SOC0128Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;

/**
 * �豸��ϸ��Ϣ�֣�
 * 
 * @author
 * 
 */
@SuppressWarnings("serial")
public class IGDRM04301VO extends BaseVO implements Serializable {

	/** �豸��Ϣ */
	protected SOC0118VWInfo entityItemData;

	/** �ʲ���������Ϣ������� */
	protected Map<String, List<SOC0129Info>> configItemVWInfoMap;

	/** �豸������������ */
	protected String eiorgname;

	/** Ȩ�ޱ�ʶ */
	protected Boolean flag;

	/** �ʲ��汾�б� */
	protected List<SOC0128Info> configItemVersionTime;

	/** �豸�Ƿ����ϼܱ�־λ */
	protected String inJiguiFlg;

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public String getEiorgname() {
		return eiorgname;
	}

	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}

	/**
	 * ���캯��
	 * 
	 * @param entityItemData
	 *            ���ʲ�����Ϣ
	 * @param configItemVWInfoMap
	 *            ���ʲ���������Ϣ�������
	 */
	public IGDRM04301VO(SOC0118VWInfo entityItemData,
			Map<String, List<SOC0129Info>> configItemVWInfoMap) {
		this.entityItemData = entityItemData;
		this.configItemVWInfoMap = configItemVWInfoMap;
	}

	/**
	 * �豸��Ϣȡ��
	 * 
	 * @return �豸��Ϣ
	 */
	public SOC0118VWInfo getEntityData() {
		return entityItemData;
	}

	/**
	 * �ʲ���������Ϣ�������ȡ��
	 * 
	 * @return �ʲ���������Ϣ�������
	 */
	public Map<String, List<SOC0129Info>> getConfigItemVWInfoMap() {
		return configItemVWInfoMap;
	}

	/**
	 * �ʲ��汾�б�ȡ��
	 * 
	 * @return �ʲ��汾�б�
	 */
	public List<SOC0128Info> getConfigItemVersionTime() {
		return configItemVersionTime;
	}

	/**
	 * �ʲ��汾�б��趨
	 * 
	 * @param configItemVersionTime
	 *            �ʲ��汾�б�
	 */
	public void setConfigItemVersionTime(List<SOC0128Info> configItemVersionTime) {
		this.configItemVersionTime = configItemVersionTime;
	}

	/**
	 * @return the inJiguiFlg
	 */
	public String getInJiguiFlg() {
		return inJiguiFlg;
	}

	/**
	 * @param inJiguiFlg
	 *            the inJiguiFlg to set
	 */
	public void setInJiguiFlg(String inJiguiFlg) {
		this.inJiguiFlg = inJiguiFlg;
	}
}
