package com.deliverik.infogovernor.soc.vir.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0128Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.vir.form.IGVIR0602Form;
import com.deliverik.infogovernor.soc.vir.form.IGVIR0603Form;
import com.deliverik.infogovernor.soc.vir.form.IGVIR0604Form;
import com.deliverik.infogovernor.soc.vir.form.IGVIR0605Form;
import com.deliverik.infogovernor.soc.vir.form.IGVIR0606Form;

/**
 * 虚拟化管理业务用DTO
 * 
 */
@SuppressWarnings("serial")
public class IGVIR06DTO extends BaseDTO implements Serializable{
	
	protected String treeXml;
	
	protected String eiid;
	
	/** 应用配置信息 */
	protected IGVIR0602Form igvir0602Form;
	
	protected IGVIR0603Form igvir0603Form;
	protected IGVIR0604Form igvir0604Form;
	protected IGVIR0605Form igvir0605Form;
	protected IGVIR0606Form igvir0606Form;
	private String eiversion ;
	private String ename ;
	
	protected Locale locale;
	
	/** 翻页用DTO */
	protected PagingDTO pagingDto;
	
	/** 设备信息检索条件 */
	protected SOC0124SearchCond entityItemVWSearchCond;
	
	/** 设备所属机构名称 */
	protected String eiorgname;
	
	/** 设备配置信息画面设备信息 */
	protected SOC0124Info entityItemVWInfo;
	
	/** 资产版本列表 */
	protected List<SOC0128Info> configItemVersionTime;
	
	/** 权限标识 */
	protected Boolean flag;
	
	/** 用户对象 */
	private User user;
	
	/** 检索最大件数 */
	protected int maxSearchCount;
	
	/** 资产项配置信息检索结果 */
	protected Map<String,List<SOC0129Info>> configItemVWInfoMap;
	
	/** 设备检索结果 */
	protected List<SOC0124Info> entityItemVWInfoList;
	
	/** 域ID */
	protected Integer domainid;
	
	/** 域版本 */
	protected Integer domainversion;
	
	/** 快照生成时间 */
	protected String createtime;
	
	/** 是否显示逻辑关系MAP */
	protected Map<String,String> showRelationMap;
	
	protected String esyscoding ;
	protected String orgname ;
	protected String orgsyscoding ;
	
	protected String userid;
	
	protected String username;
	
	public String getEiid() {
		return eiid;
	}

	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	public String getTreeXml() {
		return treeXml;
	}

	public void setTreeXml(String treeXml) {
		this.treeXml = treeXml;
	}

	public IGVIR0602Form getIgvir0602Form() {
		return igvir0602Form;
	}

	public void setIgvir0602Form(IGVIR0602Form igvir0602Form) {
		this.igvir0602Form = igvir0602Form;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public String getEiorgname() {
		return eiorgname;
	}

	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}

	public SOC0124Info getEntityItemVWInfo() {
		return entityItemVWInfo;
	}

	public void setEntityItemVWInfo(SOC0124Info entityItemVWInfo) {
		this.entityItemVWInfo = entityItemVWInfo;
	}

	public List<SOC0128Info> getConfigItemVersionTime() {
		return configItemVersionTime;
	}

	public void setConfigItemVersionTime(List<SOC0128Info> configItemVersionTime) {
		this.configItemVersionTime = configItemVersionTime;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	public Map<String, List<SOC0129Info>> getConfigItemVWInfoMap() {
		return configItemVWInfoMap;
	}

	public void setConfigItemVWInfoMap(
			Map<String, List<SOC0129Info>> configItemVWInfoMap) {
		this.configItemVWInfoMap = configItemVWInfoMap;
	}

	public IGVIR0603Form getIgvir0603Form() {
		return igvir0603Form;
	}

	public void setIgvir0603Form(IGVIR0603Form igvir0603Form) {
		this.igvir0603Form = igvir0603Form;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public IGVIR0604Form getIgvir0604Form() {
		return igvir0604Form;
	}

	public void setIgvir0604Form(IGVIR0604Form igvir0604Form) {
		this.igvir0604Form = igvir0604Form;
	}

	public IGVIR0605Form getIgvir0605Form() {
		return igvir0605Form;
	}

	public void setIgvir0605Form(IGVIR0605Form igvir0605Form) {
		this.igvir0605Form = igvir0605Form;
	}

	public IGVIR0606Form getIgvir0606Form() {
		return igvir0606Form;
	}

	public void setIgvir0606Form(IGVIR0606Form igvir0606Form) {
		this.igvir0606Form = igvir0606Form;
	}

	public String getEiversion() {
		return eiversion;
	}

	public void setEiversion(String eiversion) {
		this.eiversion = eiversion;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public SOC0124SearchCond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	public void setEntityItemVWSearchCond(SOC0124SearchCond entityItemVWSearchCond) {
		this.entityItemVWSearchCond = entityItemVWSearchCond;
	}

	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	public List<SOC0124Info> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	public void setEntityItemVWInfoList(List<SOC0124Info> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}

	public Integer getDomainid() {
		return domainid;
	}

	public void setDomainid(Integer domainid) {
		this.domainid = domainid;
	}

	public Integer getDomainversion() {
		return domainversion;
	}

	public void setDomainversion(Integer domainversion) {
		this.domainversion = domainversion;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public Map<String, String> getShowRelationMap() {
		return showRelationMap;
	}

	public void setShowRelationMap(Map<String, String> showRelationMap) {
		this.showRelationMap = showRelationMap;
	}

	public String getEsyscoding() {
		return esyscoding;
	}

	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public String getOrgsyscoding() {
		return orgsyscoding;
	}

	public void setOrgsyscoding(String orgsyscoding) {
		this.orgsyscoding = orgsyscoding;
	}
	
}


