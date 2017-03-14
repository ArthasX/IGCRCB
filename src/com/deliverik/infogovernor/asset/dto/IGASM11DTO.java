package com.deliverik.infogovernor.asset.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.EquipmentInquireVWInfo;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0601Info;
import com.deliverik.framework.soc.asset.model.SOC0602Info;
import com.deliverik.framework.soc.asset.model.SOC0603Info;
import com.deliverik.framework.soc.asset.model.SOC0605Info;
import com.deliverik.framework.soc.asset.model.SOC0606Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0605SearchCond;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.form.IGASM1102Form;
import com.deliverik.infogovernor.asset.form.IGASM1104Form;
import com.deliverik.infogovernor.asset.form.IGASM1105Form;
import com.deliverik.infogovernor.asset.form.IGASM1112Form;
import com.deliverik.infogovernor.asset.form.IGASM1114Form;
import com.deliverik.infogovernor.asset.form.IGASM1115Form;
import com.deliverik.infogovernor.asset.form.IGASM1116Form;
import com.deliverik.infogovernor.asset.form.IGASM1120Form;

/**
 * @Description: 机房配置管理业务用DTO
 * @Author  
 * @History 2009-8-19     新建
 * @History 2010-5-07     0000428: 增加机房属性管理
 * @Version V2.0
 */
@SuppressWarnings("serial")
public class IGASM11DTO extends BaseDTO implements Serializable{

	/** 机房信息 */
	protected IGASM1102Form igasm1102Form;
	
	/** 检索最大件数 */
	protected int maxSearchCount;

	/** 翻页用DTO */
	protected PagingDTO pagingDto;

	/** 机房检索结果 */
	protected List<SOC0601Info> computerRoomVWInfoList;

	/** 机房删除对象 */
	protected String[] deleteEntityItem;

	/** 机房信息检索条件 */
	protected SOC0605SearchCond entityItemVWSearchCond;
	
	/**已上架机柜XML */
	protected String jiguiXml;
	
	/**未上架机柜XML */
	protected String toolsXml;
	
	/**过道地板XML */
	protected String guodaoXML;
	
	/** 当前隔断EIID */
	protected Integer eiid;
	/**无效地区地板XML */
	protected String wuxiaoXML;
	
	/**图例信息XML */
	protected String legendXML;
	
	/**关联机房XML */
	protected String relateRoomXML;
	
	/**3D机房支持IP查询Form */
	protected IGASM1120Form igasm1120Form;

	/**3D机房支持IP查询结果 */
	List<EquipmentInquireVWInfo> eilist;
	
	public String getRelateRoomXML() {
		return relateRoomXML;
	}

	public void setRelateRoomXML(String relateRoomXML) {
		this.relateRoomXML = relateRoomXML;
	}

	/** 机柜信息 */
	protected IGASM1112Form igasm1112Form;
	
	/** 机房平面图画面用检索条件 */
	protected IGASM1104Form igasm1104Form;
	
	/** 机房平面图画面用基本信息 */
	protected SOC0601Info computerRoomVWInfo;
	
	/** 机房所属机柜检索结果 */
	protected List<SOC0603Info> computerContainerVWInfoList;

	/** 机柜选择画面用检索条件 */
	protected IGASM1105Form igasm1105Form;
	
	/** 机柜平面图画面用检索条件 */
	protected IGASM1114Form igasm1114Form;
	
	/** 机柜平面图画面用基本信息 */
	protected SOC0603Info computerContainerVWInfo;
	
	/** 机柜所属设备检索结果 */
	protected List<SOC0602Info> computerDeviceVWInfoList;

	/** 设备选择画面用检索条件 */
	protected IGASM1115Form igasm1115Form;
	
	/** 设备配置详细信息用检索条件 */
	protected IGASM1116Form igasm1116Form;
	
	/** 设备配置信息检索结果 */
	protected List<SOC0107Info> configItemList;

	/** 设备信息 */
	protected SOC0605Info entityItemVWInfo;

	/** 资产项配置信息检索结果 */
	protected Map<String,List<SOC0107Info>> configItemMap;
	
	/** 资产项配置信息检索结果 */
	protected Map<String,List<SOC0606Info>> configItemVWInfoMap;
	
	/** 用户对象 */
	protected User user;
	
	/** 权限标识 */
	protected Boolean flag;
	
	protected List<SOC0109Info> configurationList;
	protected List<SOC0606Info> configItemVWInfoList;
	
	/** 设备高度LIST */
	protected List<LabelValueBean> cubicalHeigthList;
	
	/** 设备高度 */
	protected String cubicalHeigth;
	
	public Map<String, List<SOC0107Info>> getConfigItemMap() {
		return configItemMap;
	}

	public void setConfigItemMap(Map<String, List<SOC0107Info>> configItemMap) {
		this.configItemMap = configItemMap;
	}

	public Map<String, List<SOC0606Info>> getConfigItemVWInfoMap() {
		return configItemVWInfoMap;
	}

	public void setConfigItemVWInfoMap(
			Map<String, List<SOC0606Info>> configItemVWInfoMap) {
		this.configItemVWInfoMap = configItemVWInfoMap;
	}

	/**
	 * 机房信息取得
	 * @return 机房信息
	 */
	public IGASM1102Form getIgasm1102Form() {
		return igasm1102Form;
	}

	/**
	 * 机房信息设定
	 *
	 * @param igasm1102Form 机房信息
	 */
	public void setIgasm1102Form(IGASM1102Form igasm1102Form) {
		this.igasm1102Form = igasm1102Form;
	}

	/**
	 * 机房信息检索条件取得
	 * @return 机房信息检索条件
	 */
	public SOC0605SearchCond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	/**
	 * 机房信息检索条件设定
	 *
	 * @param entityItemVWSearchCond 机房信息检索条件
	 */
	public void setEntityItemVWSearchCond(
			SOC0605SearchCond entityItemVWSearchCond) {
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
	 * 机房检索结果取得
	 * @return 机房检索结果
	 */
	public List<SOC0601Info> getComputerRoomVWInfoList() {
		return computerRoomVWInfoList;
	}

	/**
	 * 机房检索结果设定
	 *
	 * @param entityItemVWInfoList 机房检索结果
	 */
	public void setComputerRoomVWInfoList(List<SOC0601Info> computerRoomVWInfoList) {
		this.computerRoomVWInfoList = computerRoomVWInfoList;
	}

	/**
	 * 机房删除对象取得
	 * @return 机房删除对象
	 */
	public String[] getDeleteEntityItem() {
		return deleteEntityItem;
	}

	/**
	 * 机房删除对象设定
	 *
	 * @param deleteEntityItem 机房删除对象
	 */
	public void setDeleteEntityItem(String[] deleteEntityItem) {
		this.deleteEntityItem = deleteEntityItem;
	}

	/**
	 * 机柜信息取得
	 * @return 机柜信息
	 */
	public IGASM1112Form getIgasm1112Form() {
		return igasm1112Form;
	}

	/**
	 * 机柜信息设定
	 *
	 * @param igasm1112Form 机柜信息
	 */
	public void setIgasm1112Form(IGASM1112Form igasm1112Form) {
		this.igasm1112Form = igasm1112Form;
	}

	/**
	 * 机房平面图画面用检索条件取得
	 * @return 机房平面图画面用检索条件
	 */
	public IGASM1104Form getIgasm1104Form() {
		return igasm1104Form;
	}

	/**
	 * 机房平面图画面用检索条件设定
	 *
	 * @param igasm1104Form 机房平面图画面用检索条件
	 */
	public void setIgasm1104Form(IGASM1104Form igasm1104Form) {
		this.igasm1104Form = igasm1104Form;
	}

	/**
	 * 机房平面图画面用基本信息取得
	 * @return 机房平面图画面用基本信息
	 */
	public SOC0601Info getComputerRoomVWInfo() {
		return computerRoomVWInfo;
	}

	/**
	 * 机房平面图画面用基本信息设定
	 *
	 * @param computerRoomVWInfo 机房平面图画面用基本信息
	 */
	public void setComputerRoomVWInfo(SOC0601Info computerRoomVWInfo) {
		this.computerRoomVWInfo = computerRoomVWInfo;
	}

	/**
	 * 机房所属机柜检索结果取得
	 * @return 机房所属机柜检索结果
	 */
	public List<SOC0603Info> getComputerContainerVWInfoList() {
		return computerContainerVWInfoList;
	}

	/**
	 * 机房所属机柜检索结果设定
	 *
	 * @param computerContainerVWInfoList 机房所属机柜检索结果
	 */
	public void setComputerContainerVWInfoList(
			List<SOC0603Info> computerContainerVWInfoList) {
		this.computerContainerVWInfoList = computerContainerVWInfoList;
	}

	/**
	 * 机柜选择画面用检索条件取得
	 * @return 机柜选择画面用检索条件
	 */
	public IGASM1105Form getIgasm1105Form() {
		return igasm1105Form;
	}

	/**
	 * 机柜选择画面用检索条件设定
	 *
	 * @param igasm1105Form 机柜选择画面用检索条件
	 */
	public void setIgasm1105Form(IGASM1105Form igasm1105Form) {
		this.igasm1105Form = igasm1105Form;
	}

	/**
	 * 机柜平面图画面用检索条件取得
	 * @return 机柜平面图画面用检索条件
	 */
	public IGASM1114Form getIgasm1114Form() {
		return igasm1114Form;
	}

	/**
	 * 机柜平面图画面用检索条件设定
	 *
	 * @param igasm1114Form 机柜平面图画面用检索条件
	 */
	public void setIgasm1114Form(IGASM1114Form igasm1114Form) {
		this.igasm1114Form = igasm1114Form;
	}

	/**
	 * 机柜平面图画面用基本信息取得
	 * @return 机柜平面图画面用基本信息
	 */
	public SOC0603Info getComputerContainerVWInfo() {
		return computerContainerVWInfo;
	}

	/**
	 * 机柜平面图画面用基本信息设定
	 *
	 * @param computerContainerVWInfo 机柜平面图画面用基本信息
	 */
	public void setComputerContainerVWInfo(
			SOC0603Info computerContainerVWInfo) {
		this.computerContainerVWInfo = computerContainerVWInfo;
	}

	/**
	 * 机柜所属设备检索结果取得
	 * @return 机柜所属设备检索结果
	 */
	public List<SOC0602Info> getComputerDeviceVWInfoList() {
		return computerDeviceVWInfoList;
	}

	/**
	 * 机柜所属设备检索结果设定
	 *
	 * @param computerDeviceVWInfoList 机柜所属设备检索结果
	 */
	public void setComputerDeviceVWInfoList(
			List<SOC0602Info> computerDeviceVWInfoList) {
		this.computerDeviceVWInfoList = computerDeviceVWInfoList;
	}

	/**
	 * 设备选择画面用检索条件取得
	 * @return 设备选择画面用检索条件
	 */
	public IGASM1115Form getIgasm1115Form() {
		return igasm1115Form;
	}

	/**
	 * 设备选择画面用检索条件设定
	 *
	 * @param igasm1115Form 设备选择画面用检索条件
	 */
	public void setIgasm1115Form(IGASM1115Form igasm1115Form) {
		this.igasm1115Form = igasm1115Form;
	}

	/**
	 * 设备配置详细信息用检索条件取得
	 * @return 设备配置详细信息用检索条件
	 */
	public IGASM1116Form getIgasm1116Form() {
		return igasm1116Form;
	}

	/**
	 * 设备配置详细信息用检索条件设定
	 *
	 * @param igasm1116Form 设备配置详细信息用检索条件
	 */
	public void setIgasm1116Form(IGASM1116Form igasm1116Form) {
		this.igasm1116Form = igasm1116Form;
	}

	/**
	 * 设备信息取得
	 * @return 设备信息
	 */
	public SOC0605Info getEntityItemVWInfo() {
		return entityItemVWInfo;
	}

	/**
	 * 设备信息设定
	 *
	 * @param entityItemVWInfo 设备信息
	 */
	public void setEntityItemVWInfo(SOC0605Info entityItemVWInfo) {
		this.entityItemVWInfo = entityItemVWInfo;
	}

	/**
	 * 设备配置信息检索结果取得
	 * @return 设备配置信息检索结果
	 */
	public List<SOC0107Info> getConfigItemList() {
		return configItemList;
	}

	/**
	 * 设备配置信息检索结果设定
	 *
	 * @param configItemList 设备配置信息检索结果
	 */
	public void setConfigItemList(List<SOC0107Info> configItemList) {
		this.configItemList = configItemList;
	}

	/**
	 * 用户对象取得
	 * @return 用户对象
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 用户对象设定
	 *
	 * @param user 用户对象
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * 权限标识取得
	 * @return 权限标识
	 */
	public Boolean getFlag() {
		return flag;
	}

	/**
	 * 权限标识设定
	 *
	 * @param flag 权限标识
	 */
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public List<SOC0109Info> getConfigurationList() {
		return configurationList;
	}

	public void setConfigurationList(List<SOC0109Info> configurationList) {
		this.configurationList = configurationList;
	}

	public List<SOC0606Info> getConfigItemVWInfoList() {
		return configItemVWInfoList;
	}

	public void setConfigItemVWInfoList(List<SOC0606Info> configItemVWInfoList) {
		this.configItemVWInfoList = configItemVWInfoList;
	}

	public String getJiguiXml() {
		return jiguiXml;
	}

	public void setJiguiXml(String jiguiXml) {
		this.jiguiXml = jiguiXml;
	}

	public String getToolsXml() {
		return toolsXml;
	}

	public void setToolsXml(String toolsXml) {
		this.toolsXml = toolsXml;
	}

	public String getGuodaoXML() {
		return guodaoXML;
	}

	public void setGuodaoXML(String guodaoXML) {
		this.guodaoXML = guodaoXML;
	}

	public Integer getEiid() {
		return eiid;
	}

	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}
	/**
	 * 无效地区取得
	 * @return 无效地区
	 */
	public String getWuxiaoXML() {
		return wuxiaoXML;
	}
	/**
	 * 无效地区设定
	 *
	 * @param 无效地区
	 */
	public void setWuxiaoXML(String wuxiaoXML) {
		this.wuxiaoXML = wuxiaoXML;
	}
	/**
	 * 图例信息取得
	 * @return 图例信息
	 */
	public String getLegendXML() {
		return legendXML;
	}
	/**
	 * 图例信息设定
	 *
	 * @param 图例信息
	 */
	public void setLegendXML(String legendXML) {
		this.legendXML = legendXML;
	}

	public List<LabelValueBean> getCubicalHeigthList() {
		return cubicalHeigthList;
	}

	public void setCubicalHeigthList(List<LabelValueBean> cubicalHeigthList) {
		this.cubicalHeigthList = cubicalHeigthList;
	}

	public String getCubicalHeigth() {
		return cubicalHeigth;
	}

	public void setCubicalHeigth(String cubicalHeigth) {
		this.cubicalHeigth = cubicalHeigth;
	}
	/**
	 * 3D机房支持IP查询Form取得
	 * @return 3D机房支持IP查询Form
	 */
	public IGASM1120Form getIgasm1120Form() {
		return igasm1120Form;
	}
	/**
	 * 3D机房支持IP查询Form设定
	 *
	 * @param 3D机房支持IP查询Form
	 */
	public void setIgasm1120Form(IGASM1120Form igasm1120Form) {
		this.igasm1120Form = igasm1120Form;
	}
	/**
	 * 3D机房支持IP查询结果取得
	 * @return 3D机房支持IP查询结果
	 */
	public List<EquipmentInquireVWInfo> getEilist() {
		return eilist;
	}
	/**
	 * 3D机房支持IP查询结果设定
	 *
	 * @param 3D机房支持IP查询结果
	 */
	public void setEilist(List<EquipmentInquireVWInfo> eilist) {
		this.eilist = eilist;
	}
	/**所属机柜Id*/
	protected String computerContainerId ;
	
	/**
	 *所属机柜Id取得
	 * @return 所属机柜Id
	 */
	public String getComputerContainerId() {
		return computerContainerId;
	}
	/**
	 * 所属机柜Id设定
	 *
	 * @param computerContainerId 所属机柜Id
	 */
	public void setComputerContainerId(String computerContainerId) {
		this.computerContainerId = computerContainerId;
	}
}


