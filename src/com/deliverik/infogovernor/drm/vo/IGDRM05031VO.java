package com.deliverik.infogovernor.drm.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0128Info;
import com.deliverik.infogovernor.vo.IGCOM03072VO;

/**
 * ��Ա��ʷ��¼��Ϣ�֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGDRM05031VO extends BaseVO implements Serializable{
	
	/** �ʲ�����Ϣ */
	protected SOC0124Info entityItemData;
	
	/** �ʲ���������Ϣ������� */
	protected Map<String,List<SOC0107Info>> configItemMap;

	/** ��Ա������������ */
	protected String eiorgname;
	
	/** Ȩ�ޱ�ʶ */
	protected Boolean flag;
	
	/** �ʲ��汾�б� */
	protected List<SOC0128Info> configItemVersionTime;
	
	/** �ʲ���������Ϣ������� */
	protected List<SOC0107Info> configItemList;
	
	/** ��ʾVO */
	protected List<IGCOM03072VO> voList;
	
	/** �汾���� */
	protected Map<String, String> versionDate;
	
	/** �汾���� */
	protected Integer versionsize = 0;
	
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
	 * @param entityItemData���ʲ�����Ϣ
	 * @param configItemMap���ʲ���������Ϣ�������
	 */
	public IGDRM05031VO(SOC0124Info entityItemData,Map<String,List<SOC0107Info>> configItemMap) {
		this.entityItemData = entityItemData;
		this.configItemMap = configItemMap;
	}
	
	/**
	 * �ʲ�����Ϣȡ��
	 * @return �ʲ�����Ϣ
	 */
	public SOC0124Info getEntityData() {
		return entityItemData;
	}
	
	/**
	 * �ʲ���������Ϣ�������ȡ��
	 * @return �ʲ���������Ϣ�������
	 */
	public Map<String, List<SOC0107Info>> getConfigItemMap() {
		return configItemMap;
	}
	
	/**
	 * �ʲ��汾�б�ȡ��
	 * @return �ʲ��汾�б�
	 */
	public List<SOC0128Info> getConfigItemVersionTime() {
		return configItemVersionTime;
	}

	/**
	 * �ʲ��汾�б��趨
	 *
	 * @param configItemVersionTime �ʲ��汾�б�
	 */
	public void setConfigItemVersionTime(
			List<SOC0128Info> configItemVersionTime) {
		this.configItemVersionTime = configItemVersionTime;
	}

	public SOC0124Info getEntityItemData() {
		return entityItemData;
	}

	public void setEntityItemData(SOC0124Info entityItemData) {
		this.entityItemData = entityItemData;
	}

	public List<SOC0107Info> getConfigItemList() {
		return configItemList;
	}

	public void setConfigItemList(List<SOC0107Info> configItemList) {
		this.configItemList = configItemList;
	}

	public List<IGCOM03072VO> getVoList() {
		return voList;
	}

	public void setVoList(List<IGCOM03072VO> voList) {
		this.voList = voList;
	}

	public Map<String, String> getVersionDate() {
		return versionDate;
	}

	public void setVersionDate(Map<String, String> versionDate) {
		this.versionDate = versionDate;
	}

	public Integer getVersionsize() {
		return versionsize;
	}

	public void setVersionsize(Integer versionsize) {
		this.versionsize = versionsize;
	}

	public void setConfigItemMap(Map<String, List<SOC0107Info>> configItemMap) {
		this.configItemMap = configItemMap;
	}
	
}


