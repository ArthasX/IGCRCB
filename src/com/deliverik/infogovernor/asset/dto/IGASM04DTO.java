package com.deliverik.infogovernor.asset.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.asset.model.IG499Info;
import com.deliverik.framework.asset.model.condition.IG499SearchCond;
import com.deliverik.framework.asset.model.condition.IG688SearchCond;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0128Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.form.IGASM0402Form;
import com.deliverik.infogovernor.asset.form.IGASM0404Form;
import com.deliverik.infogovernor.asset.form.IGASM0405Form;
import com.deliverik.infogovernor.asset.form.IGASM0406Form;
import com.deliverik.infogovernor.asset.form.IGASM0407Form;
import com.deliverik.infogovernor.asset.form.IGASM0412Form;
import com.deliverik.infogovernor.asset.form.IGASM0421Form;
import com.deliverik.infogovernor.asset.form.IGASM0422Form;


/**
 * 
 * 概述: 合同配置管理业务用DTO
 * 功能描述: 合同配置管理业务用DTO
 * 创建记录: 2012/04/11
 * 修改记录: 2012/11/26 LuJiayuan 增加标识判断是否显示图像按钮
 */
@SuppressWarnings("serial")
public class IGASM04DTO extends BaseDTO implements Serializable{

	/** 合同信息 */
	protected IGASM0402Form igasm0402Form;
	
	/** 合同付款信息 */
	protected IGASM0422Form igasm0422Form;
	
	/** 合同付款信息 */
	protected IGASM0421Form igasm0421Form;
	
	/** 合同信息检索条件 */
	protected IG688SearchCond entityItemVWSearchCond;
	
	/** 合同信息检索条件 */
	protected IG499SearchCond entityItemCompactVWSearchCond;
	
	/** 检索最大件数 */
	protected int maxSearchCount;

	/** 翻页用DTO */
	protected PagingDTO pagingDto;

	/** 合同检索结果 */
	protected List<SOC0124Info> entityItemVWInfoList;

	/** 合同信息检索结果 */
	protected List<IG499Info> entityItemCompactVWInfoList;
	
	/** 合同信息检索结果 */
	protected IG499Info entityItemCompactVWInfo;
	
	/** 合同删除对象 */
	protected String[] deleteEntityItem;

	/** 合同配置信息 */
	protected IGASM0404Form igasm0404Form;
	
	/** 合同配置信息检索结果 */
	protected List<SOC0129Info> configItemVWInfoList;

	/** 合同配置信息画面合同信息 */
	protected SOC0124Info entityItemVWInfo;

	/** 合同配置信息历史记录检索条件 */
	protected IGASM0405Form igasm0405Form;
	
	/** 合同配置信息历史记录检索结果 */
	protected List<SOC0107Info> configItemList;
	
	/** 合同关系管理检索条件 */
	protected IGASM0406Form igasm0406Form;
	
	/** 资产项关系管理信息检索结果1 */
	protected List<SOC0119Info> parEntityItemRelationList;
	
	/** 资产项关系管理信息检索结果2 */
	protected List<SOC0119Info> cldEntityItemRelationList;
	
	/** 合同关系编辑信息 */
	protected IGASM0407Form igasm0407Form;
	
	/** 合同关系编辑后信息 */
	protected SOC0119Info entityItemRelation;
	
	/** 资产管理关系下拉列表 */
	protected List<LabelValueBean> relationList;

	/** 合同关系删除对象 */
	protected String[] deleteEntityItemRelation;
	
	/** 资产项配置信息检索结果 */
	protected Map<String,List<SOC0129Info>> configItemVWInfoMap;
	
	protected Map<String,List<SOC0119Info>> parEntityItemRelationMap;
	protected Map<String,List<SOC0119Info>> cldEntityItemRelationMap;
	protected int parCount;
	protected int cldCount;
	
	/** 资产项配置信息检索结果 */
	protected Map<String,List<SOC0107Info>> configItemMap;
	
	/** 合同所属机构名称 */
	protected String eiorgname;
	
	/** 合同信息修改 */
	protected IGASM0412Form igasm0412Form;
	
	/** 用户对象 */
	private User user;
	
	/** 权限标识 */
	protected Boolean flag;
	
	/** 机构层次码 */
	protected String orgsyscoding;
	
	/** 机构名称 */
	protected String orgname;
	
	/** 模型层次码 */
	protected String esyscoding;
	
	/** 模型名称 */
	protected String ename;
	
	/** 资产版本列表 */
	protected List<SOC0128Info> configItemVersionTime;
	
	protected List<LabelValueBean> selectList;
	
	/** 报表数据内容  */
	private List<IG499Info> reportDataList;
	
	/** 图像扫描XML */
	protected String picuXml;
	
	/** 图像查看XML */
	protected String picsXml;

	/** 初始化合同相关显示列表 */
	protected Map<String,String> dismap;
	
	/** 开户行 */
	protected String kaihuhang;
	
	/** 开户账号 */
	protected String kaihuzhanghao;
	
	/** 开户名称 */
	protected String kaihumingcheng;
	
	protected Boolean image_flag;
	
	public Map<String, String> getDismap() {
		return dismap;
	}

	public void setDismap(Map<String, String> dismap) {
		this.dismap = dismap;
	}

	public String getPicuXml() {
		return picuXml;
	}

	public void setPicuXml(String picuXml) {
		this.picuXml = picuXml;
	}

	public String getPicsXml() {
		return picsXml;
	}

	public void setPicsXml(String picsXml) {
		this.picsXml = picsXml;
	}

	public List<LabelValueBean> getSelectList() {
		return selectList;
	}

	public void setSelectList(List<LabelValueBean> selectList) {
		this.selectList = selectList;
	}

	public String getOrgsyscoding() {
		return orgsyscoding;
	}

	public void setOrgsyscoding(String orgsyscoding) {
		this.orgsyscoding = orgsyscoding;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public String getEsyscoding() {
		return esyscoding;
	}

	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
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
	
	public IGASM0412Form getIgasm0412Form() {
		return igasm0412Form;
	}

	public void setIgasm0412Form(IGASM0412Form igasm0412Form) {
		this.igasm0412Form = igasm0412Form;
	}

	public String getEiorgname() {
		return eiorgname;
	}

	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}
	
	public Map<String, List<SOC0119Info>> getParEntityItemRelationMap() {
		return parEntityItemRelationMap;
	}

	public void setParEntityItemRelationMap(
			Map<String, List<SOC0119Info>> parEntityItemRelationMap) {
		this.parEntityItemRelationMap = parEntityItemRelationMap;
	}

	public Map<String, List<SOC0119Info>> getCldEntityItemRelationMap() {
		return cldEntityItemRelationMap;
	}

	public void setCldEntityItemRelationMap(
			Map<String, List<SOC0119Info>> cldEntityItemRelationMap) {
		this.cldEntityItemRelationMap = cldEntityItemRelationMap;
	}

	public int getParCount() {
		return parCount;
	}

	public void setParCount(int parCount) {
		this.parCount = parCount;
	}

	public int getCldCount() {
		return cldCount;
	}

	public void setCldCount(int cldCount) {
		this.cldCount = cldCount;
	}
	/**
	 * 合同信息取得
	 * @return 合同信息
	 */
	public IGASM0402Form getIgasm0402Form() {
		return igasm0402Form;
	}

	/**
	 * 合同信息设定
	 *
	 * @param igasm0402Form 合同信息
	 */
	public void setIgasm0402Form(IGASM0402Form igasm0402Form) {
		this.igasm0402Form = igasm0402Form;
	}

	/**
	 * 合同信息检索条件取得
	 * @return 合同信息检索条件
	 */
	public IG688SearchCond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	/**
	 * 合同信息检索条件设定
	 *
	 * @param entityItemVWSearchCond 合同信息检索条件
	 */
	public void setEntityItemVWSearchCond(
			IG688SearchCond entityItemVWSearchCond) {
		this.entityItemVWSearchCond = entityItemVWSearchCond;
	}

	/**
	 * 检索最大件数取得
	 * @return 检索最大件数
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * 检索最大件数设定
	 *
	 * @param maxSearchCount 检索最大件数
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * 翻页用DTO取得
	 * @return 翻页用DTO
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * 翻页用DTO设定
	 *
	 * @param pagingDto 翻页用DTO
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * 合同检索结果取得
	 * @return 合同检索结果
	 */
	public List<SOC0124Info> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	/**
	 * 合同检索结果设定
	 *
	 * @param entityItemVWInfoList 合同检索结果
	 */
	public void setEntityItemVWInfoList(List<SOC0124Info> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}

	/**
	 * 合同删除对象取得
	 * @return 合同删除对象
	 */
	public String[] getDeleteEntityItem() {
		return deleteEntityItem;
	}

	/**
	 * 合同删除对象设定
	 *
	 * @param deleteEntityItem 合同删除对象
	 */
	public void setDeleteEntityItem(String[] deleteEntityItem) {
		this.deleteEntityItem = deleteEntityItem;
	}

	/**
	 * 合同配置信息取得
	 * @return 合同配置信息
	 */
	public IGASM0404Form getIgasm0404Form() {
		return igasm0404Form;
	}


	/**
	 * 合同配置信息检索条件设定
	 *
	 * @param igasm0404Form 合同配置信息检索条件
	 */
	public void setIgasm0404Form(IGASM0404Form igasm0404Form) {
		this.igasm0404Form = igasm0404Form;
	}

	/**
	 * 合同配置信息检索结果取得
	 * @return 合同配置信息检索结果
	 */
	public List<SOC0129Info> getConfigItemVWInfoList() {
		return configItemVWInfoList;
	}

	/**
	 * 合同配置信息检索结果设定
	 *
	 * @param configItemVWInfoList 合同配置信息检索结果
	 */
	public void setConfigItemVWInfoList(List<SOC0129Info> configItemVWInfoList) {
		this.configItemVWInfoList = configItemVWInfoList;
	}

	/**
	 * 合同配置信息画面合同信息取得
	 * @return 合同配置信息画面合同信息
	 */
	public SOC0124Info getEntityItemVWInfo() {
		return entityItemVWInfo;
	}

	/**
	 * 合同配置信息画面合同信息设定
	 *
	 * @param entityItemVWInfo 合同配置信息画面合同信息
	 */
	public void setEntityItemVWInfo(SOC0124Info entityItemVWInfo) {
		this.entityItemVWInfo = entityItemVWInfo;
	}

	/**
	 * 合同配置信息历史记录检索条件取得
	 * @return 合同配置信息历史记录检索条件
	 */
	public IGASM0405Form getIgasm0405Form() {
		return igasm0405Form;
	}

	/**
	 * 合同配置信息历史记录检索条件设定
	 *
	 * @param igasm0405Form 合同配置信息历史记录检索条件
	 */
	public void setIgasm0405Form(IGASM0405Form igasm0405Form) {
		this.igasm0405Form = igasm0405Form;
	}

	/**
	 * 合同配置信息历史记录检索结果取得
	 * @return 合同配置信息历史记录检索结果
	 */
	public List<SOC0107Info> getConfigItemList() {
		return configItemList;
	}

	/**
	 * 合同配置信息历史记录检索结果设定
	 *
	 * @param configItemList 合同配置信息历史记录检索结果
	 */
	public void setConfigItemList(List<SOC0107Info> configItemList) {
		this.configItemList = configItemList;
	}

	/**
	 * 合同关系管理检索条件取得
	 * @return 合同关系管理检索条件
	 */
	public IGASM0406Form getIgasm0406Form() {
		return igasm0406Form;
	}

	/**
	 * 合同关系管理检索条件设定
	 *
	 * @param igasm0406Form 合同关系管理检索条件
	 */
	public void setIgasm0406Form(IGASM0406Form igasm0406Form) {
		this.igasm0406Form = igasm0406Form;
	}

	/**
	 * 资产项关系管理信息检索结果1取得
	 * @return 资产项关系管理信息检索结果1
	 */
	public List<SOC0119Info> getParEntityItemRelationList() {
		return parEntityItemRelationList;
	}

	/**
	 * 资产项关系管理信息检索结果1设定
	 *
	 * @param parEntityItemRelationList 资产项关系管理信息检索结果1
	 */
	public void setParEntityItemRelationList(
			List<SOC0119Info> parEntityItemRelationList) {
		this.parEntityItemRelationList = parEntityItemRelationList;
	}

	/**
	 * 资产项关系管理信息检索结果2取得
	 * @return 资产项关系管理信息检索结果2
	 */
	public List<SOC0119Info> getCldEntityItemRelationList() {
		return cldEntityItemRelationList;
	}

	/**
	 * 资产项关系管理信息检索结果2设定
	 *
	 * @param cldEntityItemRelationList 资产项关系管理信息检索结果2
	 */
	public void setCldEntityItemRelationList(
			List<SOC0119Info> cldEntityItemRelationList) {
		this.cldEntityItemRelationList = cldEntityItemRelationList;
	}

	/**
	 * 合同关系编辑信息取得
	 * @return 编辑信息
	 */
	public IGASM0407Form getIgasm0407Form() {
		return igasm0407Form;
	}

	/**
	 * 合同关系编辑信息设定
	 *
	 * @param igasm0407Form 合同关系编辑信息
	 */
	public void setIgasm0407Form(IGASM0407Form igasm0407Form) {
		this.igasm0407Form = igasm0407Form;
	}

	/**
	 * 合同关系编辑后信息取得
	 * @return 合同关系编辑后信息
	 */
	public SOC0119Info getEntityItemRelation() {
		return entityItemRelation;
	}

	/**
	 * 合同关系编辑后信息设定
	 *
	 * @param entityItemRelation 合同关系编辑后信息
	 */
	public void setEntityItemRelation(SOC0119Info entityItemRelation) {
		this.entityItemRelation = entityItemRelation;
	}

	/**
	 * 合同关系删除对象取得
	 * @return 合同关系删除对象
	 */
	public String[] getDeleteEntityItemRelation() {
		return deleteEntityItemRelation;
	}

	/**
	 * 合同关系删除对象设定
	 *
	 * @param entityItemRelation 合同关系删除对象
	 */
	public void setDeleteEntityItemRelation(String[] deleteEntityItemRelation) {
		this.deleteEntityItemRelation = deleteEntityItemRelation;
	}
	
	/**
	 * 资产管理关系下拉列表取得
	 * @return 资产管理关系下拉列表
	 */
	public List<LabelValueBean> getRelationList() {
		return relationList;
	}
	
	/**
	 * 资产管理关系下拉列表设定
	 *
	 * @param username 资产管理关系下拉列表
	 */
	public void setRelationList(List<LabelValueBean> relationList) {
		this.relationList = relationList;
	}
	
	/**
	 * 资产项配置信息检索结果取得
	 * @return 资产项配置信息检索结果
	 */
	public Map<String, List<SOC0107Info>> getConfigItemMap() {
		return configItemMap;
	}
	/**
	 * 资产项配置信息检索结果设定
	 *
	 * @param configItemMap 资产项配置信息检索结果
	 */
	public void setConfigItemMap(
			Map<String, List<SOC0107Info>> configItemMap) {
		this.configItemMap = configItemMap;
	}
	
	/**
	 * 资产项配置信息检索结果取得
	 * @return 资产项配置信息检索结果
	 */
	public Map<String, List<SOC0129Info>> getConfigItemVWInfoMap() {
		return configItemVWInfoMap;
	}
	/**
	 * 资产项配置信息检索结果设定
	 *
	 * @param configItemVWInfoMap 资产项配置信息检索结果
	 */
	public void setConfigItemVWInfoMap(
			Map<String, List<SOC0129Info>> configItemVWInfoMap) {
		this.configItemVWInfoMap = configItemVWInfoMap;
	}
	
	/**
	 * 资产版本列表取得
	 * @return 资产版本列表
	 */
	public List<SOC0128Info> getConfigItemVersionTime() {
		return configItemVersionTime;
	}

	/**
	 * 资产版本列表设定
	 *
	 * @param configItemVersionTime 资产版本列表
	 */
	public void setConfigItemVersionTime(
			List<SOC0128Info> configItemVersionTime) {
		this.configItemVersionTime = configItemVersionTime;
	}

	public IG499SearchCond getEntityItemCompactVWSearchCond() {
		return entityItemCompactVWSearchCond;
	}

	public void setEntityItemCompactVWSearchCond(
			IG499SearchCond entityItemCompactVWSearchCond) {
		this.entityItemCompactVWSearchCond = entityItemCompactVWSearchCond;
	}

	public List<IG499Info> getEntityItemCompactVWInfoList() {
		return entityItemCompactVWInfoList;
	}

	public void setEntityItemCompactVWInfoList(
			List<IG499Info> entityItemCompactVWInfoList) {
		this.entityItemCompactVWInfoList = entityItemCompactVWInfoList;
	}

	public IGASM0422Form getIgasm0422Form() {
		return igasm0422Form;
	}

	public void setIgasm0422Form(IGASM0422Form igasm0422Form) {
		this.igasm0422Form = igasm0422Form;
	}

	/**
	 * 报表数据内容取得
	 *
	 * @return reportDataList 报表数据内容
	 */
	public List<IG499Info> getReportDataList() {
		return reportDataList;
	}

	/**
	 * 报表数据内容设定
	 *
	 * @param reportDataList 报表数据内容
	 */
	public void setReportDataList(List<IG499Info> reportDataList) {
		this.reportDataList = reportDataList;
	}
	
	public IGASM0421Form getIgasm0421Form() {
		return igasm0421Form;
	}

	public void setIgasm0421Form(IGASM0421Form igasm0421Form) {
		this.igasm0421Form = igasm0421Form;
	}

	public IG499Info getEntityItemCompactVWInfo() {
		return entityItemCompactVWInfo;
	}

	public void setEntityItemCompactVWInfo(
			IG499Info entityItemCompactVWInfo) {
		this.entityItemCompactVWInfo = entityItemCompactVWInfo;
	}

	public String getKaihuhang() {
		return kaihuhang;
	}

	public void setKaihuhang(String kaihuhang) {
		this.kaihuhang = kaihuhang;
	}

	public String getKaihuzhanghao() {
		return kaihuzhanghao;
	}

	public void setKaihuzhanghao(String kaihuzhanghao) {
		this.kaihuzhanghao = kaihuzhanghao;
	}

	public String getKaihumingcheng() {
		return kaihumingcheng;
	}

	public void setKaihumingcheng(String kaihumingcheng) {
		this.kaihumingcheng = kaihumingcheng;
	}

	/**
	 * image_flag取得
	 *
	 * @return image_flag image_flag
	 */
	public Boolean getImage_flag() {
		return image_flag;
	}
	/**
	 * image_flag设定
	 *
	 * @param image_flag image_flag
	 */
	public void setImage_flag(Boolean image_flag) {
		this.image_flag = image_flag;
	}
}


