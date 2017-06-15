package com.deliverik.infogovernor.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.asset.model.IG002Info;
import com.deliverik.framework.asset.model.IG013Info;
import com.deliverik.framework.asset.model.IG117Info;
import com.deliverik.framework.asset.model.IG313Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.asset.model.IG800Info;
import com.deliverik.framework.asset.model.condition.IG013SearchCond;
import com.deliverik.framework.asset.model.condition.IG117SearchCond;
import com.deliverik.framework.asset.model.condition.IG688SearchCond;
import com.deliverik.framework.asset.model.condition.IG800SearchCond;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.soc.asset.SOC0130Info;
import com.deliverik.framework.soc.asset.SOC0131Info;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0128Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.SOC0132VW;
import com.deliverik.framework.soc.asset.model.SOC0133VW;
import com.deliverik.framework.soc.asset.model.SOC0139VW;
import com.deliverik.framework.soc.asset.model.SOC0605Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0121SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.form.IGCOM0303Form;
import com.deliverik.infogovernor.form.IGCOM0304Form;
import com.deliverik.infogovernor.form.IGCOM0305Form;
import com.deliverik.infogovernor.form.IGCOM0307Form;
import com.deliverik.infogovernor.form.IGCOM0308Form;
import com.deliverik.infogovernor.form.IGCOM0314Form;
import com.deliverik.infogovernor.form.IGCOM0318Form;
import com.deliverik.infogovernor.form.IGCOM0319Form;
import com.deliverik.infogovernor.form.IGCOM0320Form;
import com.deliverik.infogovernor.form.IGCOM0321Form;
import com.deliverik.infogovernor.form.IGCOM0322Form;
import com.deliverik.infogovernor.form.IGCOM0324Form;
import com.deliverik.infogovernor.form.IGCOM0328Form;
import com.deliverik.infogovernor.form.IGCOM0329Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0147Form;

/**
 * 查询HELP业务用DTO
 * 
 */
@SuppressWarnings("serial")
public class IGCOM03DTO extends BaseDTO implements Serializable{
	
	protected SOC0121SearchCond snapshotRelationSearchCond;

	protected IG117SearchCond entitySearchCond;
	
	protected IG013SearchCond entityItemSearchCond;
	
	protected IG800SearchCond configItemSearchCond;

	protected List<IG117Info> entityList;
	
	/** 设备关系（FS-LV-VG） */
	protected List<SOC0130Info> fsLvVgInfoList;
	
	/** 设备关系（VG-PV-META） */
	protected List<SOC0131Info> vgPvMetaInfoList;
	
	/** 设备所属机构名称 */
	protected String eiorgname;
	
	/** 资产项id */
	protected Integer eiid;
	
	/** 资产模型名称 */
	protected String ename;
	
	/** 资产模型层次码 */
	protected String esyscoding;

	protected int maxSearchCount;

	protected PagingDTO pagingDto;

	/** 资产项信息检索条件 */
	protected IG688SearchCond entityItemVWSearchCond;
	/** 资产项信息检索条件 */
	protected SOC0124SearchCond soc0214SearchCond;
	
	/** 资产项检索结果 */
	protected List<IG688Info> entityItemVWInfoList;
	
	/** 资产项检索结果 */
	protected List<SOC0124Info> soc0124List;

	/** 配置详细信息用检索条件 */
	protected IGCOM0303Form igcom0303Form;
	
	/** 配置详细信息用检索条件 */
	protected IGCOM0328Form igcom0328Form;
	
	/** 配置详细信息用检索条件 */
	protected IGCOM0318Form igcom0318Form;
	
	/** 配置详细信息用检索条件 */
	protected IGCOM0319Form igcom0319Form;
	
	/** 配置详细信息用检索条件 */
	protected IGCOM0320Form igcom0320Form;
	
	/** 配置详细信息用检索条件 */
	protected IGCOM0322Form igcom0322Form;
		
	/** 配置信息检索结果 */
	protected List<SOC0107Info> configItemList;

	/** 配置项信息 */
	protected IG688Info entityItemVWInfo;

	/** 数据详细信息用检索条件 */
	protected IGCOM0304Form igcom0304Form;
	
	/** 数据详细信息检索结果集 */
	protected List<CodeDetail> codeDetailList;
	
	/** 数据分类信息检索结果集 */
	protected List<LabelValueBean> codeCategorylList;
	
	/** 资产项关系管理信息检索结果1 */
	protected Map<String,List<IG313Info>> parEntityItemRelationMap;
	/** 资产项配置信息检索结果 */
	protected Map<String,List<IG002Info>> configItemVWInfoMap;
	
	/** 资产项配置信息检索结果 */
	protected Map<String,List<IG800Info>> configItemMap;
	
	/** 资产项配置信息检索结果(SOC) */
	protected Map<String,Map<String,List<IG002Info>>> configInfoMap;
	
	private Map<String,String> configItem;
	
	/** 资产信息 */
	protected IG013Info entityItem;
	
	/** 用户对象 */
	private User user;
	
	/** 权限标识 */
	protected Boolean flag;
	
	/** 资产配置项信息版本比较显示画面FORM */
	protected IGCOM0307Form igcom0307Form;
	
	/** 资产关系图FORM */
	protected IGCOM0305Form igcom0305Form;
	
	/** 配置信息历史记录画面FORM */
	protected IGCOM0308Form igcom0308Form;
	
	protected Map<String,List<IG002Info>> emap;
	
	protected Map<String,List<String>> cname_map;
	
	protected Map<String,List<String>> einame_map;
	
	protected String srname;
	
	protected List<String> namelist;
	
	protected Map<String,Map<String,String>> eimap;
	
	/** 拓扑图FORM */
	protected IGCOM0314Form igcom0314Form;
	
	/** 影响分析图FORM */
	protected IGCOM0321Form igcom0321Form;
	
	/** 域拓扑图FORM */
	protected IGCOM0324Form igcom0324Form;
	
	/** 关系图XML */
	protected String graphXml;
	
	/** 所选EIID */
	protected String selEiid;
	
	/** 存储图用的XML*/
	private String strXml;
	
	private String storageEiname;
	
	/**交换机属性*/
	private SOC0139VW switchConfigItem;
	
	/**端口属性*/
	private List<SOC0132VW> portList;
	
	/**Zone属性*/
    private List<SOC0133VW> zoneList;
    
    private SOC0118Info soc0118Info;
    
    private SOC0124Info soc0124Info;
    
	/** 资产项配置信息检索结果 */
	protected Map<String,List<SOC0129Info>> soc0129InfoVWMap;
	
	/** 资产项配置信息检索结果 */
	protected Map<String,List<SOC0107Info>> soc0107InfoMap;
	
	private IGCIM0147Form igcim0147Form;
    
	/** 资产版本列表 */
	protected List<SOC0128Info> configItemVersionTime;
	
	protected IGCOM0329Form igcom0329Form;
	
	protected List<LabelValueBean> esyscodingList;
	
	protected List<SOC0118Info> entityItemList;
	

	public List<LabelValueBean> getEsyscodingList() {
		return esyscodingList;
	}

	public void setEsyscodingList(List<LabelValueBean> esyscodingList) {
		this.esyscodingList = esyscodingList;
	}

	public IGCOM0329Form getIgcom0329Form() {
		return igcom0329Form;
	}

	public void setIgcom0329Form(IGCOM0329Form igcom0329Form) {
		this.igcom0329Form = igcom0329Form;
	}

	public Map<String, List<SOC0129Info>> getSoc0129InfoVWMap() {
		return soc0129InfoVWMap;
	}

	public void setSoc0129InfoVWMap(Map<String, List<SOC0129Info>> soc0129InfoVWMap) {
		this.soc0129InfoVWMap = soc0129InfoVWMap;
	}

	public SOC0124Info getSoc0124Info() {
		return soc0124Info;
	}

	public void setSoc0124Info(SOC0124Info soc0124Info) {
		this.soc0124Info = soc0124Info;
	}

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

	public String getSrname() {
		return srname;
	}

	public void setSrname(String srname) {
		this.srname = srname;
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

	public Map<String, List<IG002Info>> getEmap() {
		return emap;
	}

	public void setEmap(Map<String, List<IG002Info>> emap) {
		this.emap = emap;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
	
	
	public Map<String, List<IG002Info>> getConfigItemVWInfoMap() {
		return configItemVWInfoMap;
	}

	public void setConfigItemVWInfoMap(
			Map<String, List<IG002Info>> configItemVWInfoMap) {
		this.configItemVWInfoMap = configItemVWInfoMap;
	}

	public Map<String, List<IG800Info>> getConfigItemMap() {
		return configItemMap;
	}

	public void setConfigItemMap(Map<String, List<IG800Info>> configItemMap) {
		this.configItemMap = configItemMap;
	}

	/**
	 * 
	 * @return 
	 */
	public IG117SearchCond getEntitySearchCond() {
	    return this.entitySearchCond;
	}

	/**
	 * 
	 * @param
	 */
	public void setEntitySearchCond(IG117SearchCond entitySearchCond) {
	    this.entitySearchCond = entitySearchCond;
	}

	public List<IG117Info> getEntityList() {
		return entityList;
	}

	public void setEntityList(List<IG117Info> entityList) {
		this.entityList = entityList;
	}

	/**
	 * 
	 * @return maxSearchCount
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}


	/**
	 * 
	 * @return pagingDto
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * 
	 * @param maxSearchCount
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * 
	 * @param pagingDto
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * 资产项信息检索条件取得
	 * @return 资产项信息检索条件
	 */
	public IG688SearchCond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	/**
	 * 资产项信息检索条件设定
	 *
	 * @param entityItemVWSearchCond 资产项信息检索条件
	 */
	public void setEntityItemVWSearchCond(
			IG688SearchCond entityItemVWSearchCond) {
		this.entityItemVWSearchCond = entityItemVWSearchCond;
	}

	/**
	 * 资产项检索结果取得
	 * @return 资产项检索结果
	 */
	public List<IG688Info> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	/**
	 * 资产项检索结果设定
	 *
	 * @param entityItemVWInfoList 资产项检索结果
	 */
	public void setEntityItemVWInfoList(List<IG688Info> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}

	/**
	 * 配置详细信息用检索条件取得
	 * @return 配置详细信息用检索条件
	 */
	public IGCOM0303Form getIgcom0303Form() {
		return igcom0303Form;
	}

	/**
	 * 配置详细信息用检索条件设定
	 *
	 * @param igcom0303Form 配置详细信息用检索条件
	 */
	public void setIgcom0303Form(IGCOM0303Form igcom0303Form) {
		this.igcom0303Form = igcom0303Form;
	}

	/**
	 * 配置项信息取得
	 * @return 配置项信息
	 */
	public IG688Info getEntityItemVWInfo() {
		return entityItemVWInfo;
	}

	/**
	 * 配置项信息设定
	 *
	 * @param entityItemVWInfo 配置项信息
	 */
	public void setEntityItemVWInfo(IG688Info entityItemVWInfo) {
		this.entityItemVWInfo = entityItemVWInfo;
	}

	/**
	 * 配置信息检索结果取得
	 * @return 配置信息检索结果
	 */
	public List<SOC0107Info> getConfigItemList() {
		return configItemList;
	}

	/**
	 * 配置信息检索结果设定
	 *
	 * @param configItemList 配置信息检索结果
	 */
	public void setConfigItemList(List<SOC0107Info> configItemList) {
		this.configItemList = configItemList;
	}

	/**
	 * 数据详细信息用检索条件取得
	 * @return 数据详细信息用检索条件
	 */
	public IGCOM0304Form getIgcom0304Form() {
		return igcom0304Form;
	}

	/**
	 * 数据详细信息用检索条件设定
	 *
	 * @param igcom0304Form 数据详细信息用检索条件
	 */
	public void setIgcom0304Form(IGCOM0304Form igcom0304Form) {
		this.igcom0304Form = igcom0304Form;
	}

	/**
	 * 数据详细信息检索结果集取得
	 * @return 数据详细信息检索结果集
	 */
	public List<CodeDetail> getCodeDetailList() {
		return codeDetailList;
	}

	/**
	 * 数据详细信息检索结果集设定
	 *
	 * @param codeDetailList 数据详细信息检索结果集
	 */
	public void setCodeDetailList(List<CodeDetail> codeDetailList) {
		this.codeDetailList = codeDetailList;
	}

	/**
	 * 数据分类信息检索结果集取得
	 * @return 数据分类信息检索结果集
	 */
	public List<LabelValueBean> getCodeCategorylList() {
		return codeCategorylList;
	}

	/**
	 * 数据分类信息检索结果集设定
	 *
	 * @param codeCategorylList 数据分类信息检索结果集
	 */
	public void setCodeCategorylList(List<LabelValueBean> codeCategorylList) {
		this.codeCategorylList = codeCategorylList;
	}

	/**
	 * 资产项id取得
	 * @return 资产项id
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 资产项id设定
	 *
	 * @param eiid 资产项id
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}
	
	/**
	 * 资产项关系管理信息检索结果1取得
	 * @return 资产项关系管理信息检索结果1
	 */
	public Map<String, List<IG313Info>> getParEntityItemRelationMap() {
		return parEntityItemRelationMap;
	}

	/**
	 * 资产项关系管理信息检索结果1设定
	 *
	 * @param username 资产项关系管理信息检索结果1
	 */
	public void setParEntityItemRelationMap(
			Map<String, List<IG313Info>> parEntityItemRelationMap) {
		this.parEntityItemRelationMap = parEntityItemRelationMap;
	}

	/**
	 * 资产模型名称取得
	 * @return 资产模型名称
	 */
	public String getEname() {
		return ename;
	}

	/**
	 * 资产模型名称设定
	 *
	 * @param eiid 资产模型名称
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}

	/**
	 * 资产模型层次码取得
	 * @return 资产模型层次码
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * 资产模型层次码设定
	 *
	 * @param eiid 资产模型层次码
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * 资产配置项信息版本比较显示画面FORM取得
	 * @return 资产配置项信息版本比较显示画面FORM
	 */
	public IGCOM0307Form getIgcom0307Form() {
		return igcom0307Form;
	}

	/**
	 * 资产配置项信息版本比较显示画面FORM设定
	 *
	 * @param igcom0307Form 资产配置项信息版本比较显示画面FORM
	 */
	public void setIgcom0307Form(IGCOM0307Form igcom0307Form) {
		this.igcom0307Form = igcom0307Form;
	}

	/**
	 * 资产关系图FORM取得
	 * @return 资产关系图FORM
	 */
	public IGCOM0305Form getIgcom0305Form() {
		return igcom0305Form;
	}

	/**
	 * 资产关系图FORM设定
	 *
	 * @param igcom0305Form 资产关系图FORM
	 */
	public void setIgcom0305Form(IGCOM0305Form igcom0305Form) {
		this.igcom0305Form = igcom0305Form;
	}

	/**
	 * 配置信息历史记录画面FORM取得
	 * @return 配置信息历史记录画面FORM
	 */
	public IGCOM0308Form getIgcom0308Form() {
		return igcom0308Form;
	}

	/**
	 * 配置信息历史记录画面FORM设定
	 *
	 * @param igcom0308Form 配置信息历史记录画面FORM
	 */
	public void setIgcom0308Form(IGCOM0308Form igcom0308Form) {
		this.igcom0308Form = igcom0308Form;
	}

	/**
	 * 拓扑图FORM取得
	 * @return 拓扑图FORM
	 */
	public IGCOM0314Form getIgcom0314Form() {
		return igcom0314Form;
	}

	/**
	 * 拓扑图FORM设定
	 *
	 * @param igcom0314Form 拓扑图FORM
	 */
	public void setIgcom0314Form(IGCOM0314Form igcom0314Form) {
		this.igcom0314Form = igcom0314Form;
	}
	
	
	/**
	 * 影响分析图Form
	 * 
	 * @return 影响分析图
	 */
	public IGCOM0321Form getIgcom0321Form() {
		return igcom0321Form;
	}

	/**
	 * 影响分析图设定
	 * 
	 * @param igcom0321Form 影响分析图
	 */
	public void setIgcom0321Form(IGCOM0321Form igcom0321Form) {
		this.igcom0321Form = igcom0321Form;
	}

	/**
	 * 关系图XML取得
	 * 
	 * @return 关系图XML
	 */
	public String getGraphXml() {
		return graphXml;
	}

	/**
	 * 关系图XML设定
	 * @param graphXml关系图XML
	 */
	public void setGraphXml(String graphXml) {
		this.graphXml = graphXml;
	}

	/**
	 * 所选EIID取得
	 * 
	 * @return 所选EIID
	 */
	public String getSelEiid() {
		return selEiid;
	}

	/**
	 * 所选EIID设定
	 * 
	 * @param selEiid所选EIID
	 */
	public void setSelEiid(String selEiid) {
		this.selEiid = selEiid;
	}

	public IGCOM0318Form getIgcom0318Form() {
		return igcom0318Form;
	}

	public void setIgcom0318Form(IGCOM0318Form igcom0318Form) {
		this.igcom0318Form = igcom0318Form;
	}

	public IGCOM0319Form getIGCOM0319Form() {
		return igcom0319Form;
	}

	public void setIGCOM0319Form(IGCOM0319Form IGCOM0319Form) {
		this.igcom0319Form = IGCOM0319Form;
	}

	public IGCOM0320Form getIGCOM0320Form() {
		return igcom0320Form;
	}

	public void setIGCOM0320Form(IGCOM0320Form IGCOM0320Form) {
		this.igcom0320Form = IGCOM0320Form;
	}

	public Map<String, String> getConfigItem() {
		return configItem;
	}

	public void setConfigItem(Map<String, String> configItem) {
		this.configItem = configItem;
	}

	public SOC0121SearchCond getSnapshotRelationSearchCond() {
		return snapshotRelationSearchCond;
	}

	public void setSnapshotRelationSearchCond(
			SOC0121SearchCond snapshotRelationSearchCond) {
		this.snapshotRelationSearchCond = snapshotRelationSearchCond;
	}

	public IG013SearchCond getEntityItemSearchCond() {
		return entityItemSearchCond;
	}

	public void setEntityItemSearchCond(IG013SearchCond entityItemSearchCond) {
		this.entityItemSearchCond = entityItemSearchCond;
	}

	public IGCOM0319Form getIgcom0319Form() {
		return igcom0319Form;
	}

	public void setIgcom0319Form(IGCOM0319Form igcom0319Form) {
		this.igcom0319Form = igcom0319Form;
	}

	public IGCOM0320Form getIgcom0320Form() {
		return igcom0320Form;
	}

	public void setIgcom0320Form(IGCOM0320Form igcom0320Form) {
		this.igcom0320Form = igcom0320Form;
	}

	public IG800SearchCond getConfigItemSearchCond() {
		return configItemSearchCond;
	}

	public void setConfigItemSearchCond(IG800SearchCond configItemSearchCond) {
		this.configItemSearchCond = configItemSearchCond;
	}

	/**
	 * 设备关系（FS-LV-VG）取得
	 * @return fsLvVgInfoList设备关系（FS-LV-VG）
	 */
	public List<SOC0130Info> getFsLvVgInfoList() {
		return fsLvVgInfoList;
	}
	
	/**
	 * 设备关系（FS-LV-VG）设定
	 * @param fsLvVgInfoList设备关系（FS-LV-VG）
	 */
	public void setFsLvVgInfoList(List<SOC0130Info> fsLvVgInfoList) {
		this.fsLvVgInfoList = fsLvVgInfoList;
	}
	
	/**
	 * 设备关系（VG-PV-META）取得
	 * @return 设备关系（VG-PV-META）
	 */
	public List<SOC0131Info> getVgPvMetaInfoList() {
		return vgPvMetaInfoList;
	}
	
	/**
	 * 设备关系（VG-PV-META）设定
	 * @param vgPvMetaBeanList设备关系（VG-PV-META）
	 */
	public void setVgPvMetaInfoList(List<SOC0131Info> vgPvMetaInfoList) {
		this.vgPvMetaInfoList = vgPvMetaInfoList;
	}
	
	/**
	 * 设备所属机构名称取得
	 * @return 设备所属机构名称
	 */
	public String getEiorgname() {
		return eiorgname;
	}

	/**
	 * 设备所属机构名称设定
	 * @param eiorgname设备所属机构名称
	 */
	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}

	public IGCOM0322Form getIgcom0322Form() {
		return igcom0322Form;
	}

	public void setIgcom0322Form(IGCOM0322Form igcom0322Form) {
		this.igcom0322Form = igcom0322Form;
	}

	public String getStrXml() {
		return strXml;
	}

	public void setStrXml(String strXml) {
		this.strXml = strXml;
	}

	public String getStorageEiname() {
		return storageEiname;
	}

	public void setStorageEiname(String storageEiname) {
		this.storageEiname = storageEiname;
	}

	/**
	 * 域拓扑图FORM取得
	 * 
	 * @return 域拓扑图FORM
	 */
	public IGCOM0324Form getIgcom0324Form() {
		return igcom0324Form;
	}

	/**
	 * 域拓扑图FORM设定
	 * 
	 * @param igcom0324Form 域拓扑图FORM
	 */
	public void setIgcom0324Form(IGCOM0324Form igcom0324Form) {
		this.igcom0324Form = igcom0324Form;
	}

	public SOC0139VW getSwitchConfigItem() {
		return switchConfigItem;
	}

	public void setSwitchConfigItem(SOC0139VW switchConfigItem) {
		this.switchConfigItem = switchConfigItem;
	}

	public List<SOC0132VW> getPortList() {
		return portList;
	}

	public void setPortList(List<SOC0132VW> portList) {
		this.portList = portList;
	}

	public List<SOC0133VW> getZoneList() {
		return zoneList;
	}

	public void setZoneList(List<SOC0133VW> zoneList) {
		this.zoneList = zoneList;
	}

	/**
	 * 资产项信息检索条件取得
	 *
	 * @return soc0214SearchCond 资产项信息检索条件
	 */
	public SOC0124SearchCond getSoc0214SearchCond() {
		return soc0214SearchCond;
	}

	/**
	 * 资产项信息检索条件设定
	 *
	 * @param soc0214SearchCond 资产项信息检索条件
	 */
	public void setSoc0214SearchCond(SOC0124SearchCond soc0214SearchCond) {
		this.soc0214SearchCond = soc0214SearchCond;
	}

	/**
	 * 资产项检索结果取得
	 *
	 * @return soc0124List 资产项检索结果
	 */
	public List<SOC0124Info> getSoc0124List() {
		return soc0124List;
	}

	/**
	 * 资产项检索结果设定
	 *
	 * @param soc0124List 资产项检索结果
	 */
	public void setSoc0124List(List<SOC0124Info> soc0124List) {
		this.soc0124List = soc0124List;
	}

	public IGCOM0328Form getIgcom0328Form() {
		return igcom0328Form;
	}

	public void setIgcom0328Form(IGCOM0328Form igcom0328Form) {
		this.igcom0328Form = igcom0328Form;
	}

	public IGCIM0147Form getIgcim0147Form() {
		return igcim0147Form;
	}

	public void setIgcim0147Form(IGCIM0147Form igcim0147Form) {
		this.igcim0147Form = igcim0147Form;
	}

	public Map<String, List<SOC0107Info>> getSoc0107InfoMap() {
		return soc0107InfoMap;
	}

	public void setSoc0107InfoMap(Map<String, List<SOC0107Info>> soc0107InfoMap) {
		this.soc0107InfoMap = soc0107InfoMap;
	}

	public List<SOC0128Info> getConfigItemVersionTime() {
		return configItemVersionTime;
	}

	public void setConfigItemVersionTime(List<SOC0128Info> configItemVersionTime) {
		this.configItemVersionTime = configItemVersionTime;
	}

	public List<SOC0118Info> getEntityItemList() {
		return entityItemList;
	}

	public void setEntityItemList(List<SOC0118Info> entityItemList) {
		this.entityItemList = entityItemList;
	}

	//SOC补充
	/** 资产项配置信息检索结果SOC */
	protected Map<String,List<SOC0107Info>> configItemMapSOC;
	/** 配置项信息SOC */
	protected SOC0605Info entityItemVWInfoSOC;


	/**
	 * 资产项配置信息检索结果SOC取得
	 * @return configItemMapSOC
	 */
	public Map<String, List<SOC0107Info>> getConfigItemMapSOC() {
		return configItemMapSOC;
	}
	/**
	 * 资产项配置信息检索结果SOC设定
	 * @param configItemMapSOC
	 */
	public void setConfigItemMapSOC(Map<String, List<SOC0107Info>> configItemMapSOC) {
		this.configItemMapSOC = configItemMapSOC;
	}

	/**
	 * 配置项信息SOC取得
	 * @return entityItemVWInfoSOC
	 */
	public SOC0605Info getEntityItemVWInfoSOC() {
		return entityItemVWInfoSOC;
	}
	/**
	 * 配置项信息SOC设定
	 * @param entityItemVWInfoSOC
	 */
	public void setEntityItemVWInfoSOC(SOC0605Info entityItemVWInfoSOC) {
		this.entityItemVWInfoSOC = entityItemVWInfoSOC;
	}
}