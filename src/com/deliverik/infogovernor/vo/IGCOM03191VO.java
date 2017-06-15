/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.asset.model.IG002Info;
import com.deliverik.framework.asset.model.IG013Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.SOC0130Info;
import com.deliverik.framework.soc.asset.SOC0131Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;

/**
 * ����: �豸��ϵ��ϢVO
 * ��������: �豸��ϵ��ϢVO
 * ������¼: 2011/05/04
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGCOM03191VO extends BaseVO implements Serializable{
	
	/** ��������Ϣ */
	protected IG688Info entityItemData;
	
	
	/** �ʲ���������Ϣ������� */
	protected Map<String,List<IG002Info>> configItemVWInfoMap;
	
	/** Ȩ�ޱ�ʶ */
	protected Boolean flag;
	
	/** �ʲ���������Ϣ�������(SOC) */
	protected Map<String,Map<String,List<IG002Info>>> configInfoMap;
	
	/** �豸��ϵ��FS-LV-VG�� */
	protected List<SOC0130Info> fsLvVgInfoList;
	
	/** �豸��ϵ��VG-PV-META�� */
	protected List<SOC0131Info> vgPvMetaInfoList;
	
	/** �ʲ�ģ������ */
	protected String ename;
	
	/** �豸������������ */
	protected String eiorgname;
	
	/** �ʲ���Ϣ */
	protected IG013Info entityItem;
	
	protected Map<String,List<String>> cname_map;
	
	protected Map<String,List<String>> einame_map;
	
	
	protected List<String> namelist;
	
	protected Map<String,Map<String,String>> eimap;
	
	private SOC0118Info soc0118Info;
	
	public SOC0118Info getSoc0118Info() {
		return soc0118Info;
	}

	public void setSoc0118Info(SOC0118Info soc0118Info) {
		this.soc0118Info = soc0118Info;
	}
	
	public Map<String, Map<String, String>> getEimap() {
		return eimap;
	}

	public void setEimap(Map<String, Map<String, String>> eimap) {
		this.eimap = eimap;
	}
	
	public List<String> getNamelist() {
		return namelist;
	}

	public void setNamelist(List<String> namelist) {
		this.namelist = namelist;
	}

	public Map<String, List<String>> getEiname_map() {
		return einame_map;
	}

	public void setEiname_map(Map<String, List<String>> einame_map) {
		this.einame_map = einame_map;
	}
	
	
	public Map<String, List<String>> getCname_map() {
		return cname_map;
	}

	public void setCname_map(Map<String, List<String>> cname_map) {
		this.cname_map = cname_map;
	}
	
	public IG688Info getEntityItemData() {
		return entityItemData;
	}

	public void setEntityItemData(IG688Info entityItemData) {
		this.entityItemData = entityItemData;
	}

	
	public IG013Info getEntityItem() {
		return entityItem;
	}

	public void setEntityItem(IG013Info entityItem) {
		this.entityItem = entityItem;
	}

	public Map<String, Map<String, List<IG002Info>>> getConfigInfoMap() {
		return configInfoMap;
	}

	public void setConfigInfoMap(
			Map<String, Map<String, List<IG002Info>>> configInfoMap) {
		this.configInfoMap = configInfoMap;
	}

	
	
	public Boolean getFlag() {
		return flag;
	}

//	public Map<String, List<ConfigItemVWInfo>> getConfigInfoMap() {
//		return configInfoMap;
//	}
//
//	public void setConfigInfoMap(Map<String, List<ConfigItemVWInfo>> configInfoMap) {
//		this.configInfoMap = configInfoMap;
//	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
	

	/**
	 * ���캯��
	 * @param entityItemData���ʲ�����Ϣ
	 * @param configItemVWInfoMap���ʲ���������Ϣ�������
	 */
	public IGCOM03191VO(IG688Info entityItemData,Map<String,List<IG002Info>> configItemVWInfoMap) {
		this.entityItemData = entityItemData;
		this.configItemVWInfoMap = configItemVWInfoMap;
	}
	
	/**
	 * ���캯��
	 */
	public IGCOM03191VO(List<SOC0130Info> fsLvVgInfoList,
			List<SOC0131Info> vgPvMetaInfoList) {
		super();
		this.fsLvVgInfoList = fsLvVgInfoList;
		this.vgPvMetaInfoList = vgPvMetaInfoList;
	}

	
	/**
	 * ��������Ϣȡ��
	 * @return ��������Ϣ
	 */
	public IG688Info getEntityData() {
		return entityItemData;
	}

	public Map<String, List<IG002Info>> getConfigItemVWInfoMap() {
		return configItemVWInfoMap;
	}

	/**
	 * �豸��ϵ��FS-LV-VG��ȡ��
	 * @return �豸��ϵ��FS-LV-VG��
	 */
	public List<SOC0130Info> getFsLvVgInfoList() {
		return fsLvVgInfoList;
	}
	
	/**
	 * �豸��ϵ��FS-LV-VG���趨
	 * @param igcom0319Form�豸��ϵ��FS-LV-VG��
	 */
	public void setFsLvVgInfoList(List<SOC0130Info> fsLvVgInfoList) {
		this.fsLvVgInfoList = fsLvVgInfoList;
	}
	
	/**
	 * �豸��ϵ��VG-PV-META��ȡ��
	 * @return �豸��ϵ��VG-PV-META��
	 */
	public List<SOC0131Info> getVgPvMetaInfoList() {
		return vgPvMetaInfoList;
	}

	/**
	 * �豸��ϵ��VG-PV-META���趨
	 * @param vgPvMetaBean�豸��ϵ��VG-PV-META��
	 */
	public void setVgPvMetaInfoList(List<SOC0131Info> vgPvMetaInfoList) {
		this.vgPvMetaInfoList = vgPvMetaInfoList;
	}
	
	/**
	 * �ʲ�ģ������ȡ��
	 * @return �ʲ�ģ������
	 */
	public String getEname() {
		return ename;
	}

	/**
	 * �ʲ�ģ�������趨
	 * @param ename�ʲ�ģ������
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}

	/**
	 * �豸������������
	 * @return �豸������������
	 */
	public String getEiorgname() {
		return eiorgname;
	}

	/**
	 * �豸������������
	 * @param eiorgname�豸������������
	 */
	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}

	

	
	
	
	
	
}


