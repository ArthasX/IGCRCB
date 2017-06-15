package com.deliverik.infogovernor.soc.cim.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.soc.asset.model.SOC0110Info;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0128Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.SOC0163Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0910Form;


public class IGCIM09DTO extends BaseDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private IGCIM0910Form igcim0910Form;
	private int maxSearchCount;
	private User user;
	private String eiorgname;
	private SOC0124Info entityItemVWInfo;
	private boolean flag;
	private Map<String,List<SOC0129Info>> configItemVWInfoMap;
	private List<SOC0128Info> configItemVersionTime;
	private Locale locale;
	private String userid;
	private String username;
	private List<SOC0124Info> EntityItemVWInfoList;
	private List<SOC0163Info> EntityVWInfoList;
	private SOC0119Info EntityItemRelation;
	private SOC0110Info entityRelation;
	private List<CodeDetail> RelationList;
	private int ParCount;

	
	/** 设备关系删除对象 */
	protected String[] deleteEntityItemRelation;
	
	
	/** 资产项关系信息2件数 */
	protected int cldCount;
	/** 快照生成时间 */
	protected String createtime;
	
	/** 是否显示逻辑关系MAP */
	protected Map<String,String> showRelationMap;
	
	/** 域版本 */
	protected Integer domainversion;
	
	/** 域ID */
	protected Integer domainid;
	/** 翻页用DTO */
	protected PagingDTO pagingDto;
	
	/** 设备信息检索条件 */
	protected SOC0124SearchCond entityItemVWSearchCond;

	/** 设备所属机构name */
	protected String orgname;
	
	/** 机构层次码 */
	protected String orgsyscoding;
	
	/** 模型层次码 */
	protected String esyscoding;
	
	/** 模型名称 */
	protected String ename;
	
	/** 设备删除对象 */
	protected String[] deleteEntityItem;
	

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}


	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public boolean getFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public Map<String, List<SOC0129Info>> getConfigItemVWInfoMap() {
		return configItemVWInfoMap;
	}

	public void setConfigItemVWInfoMap(
			Map<String, List<SOC0129Info>> configItemVWInfoMap) {
		this.configItemVWInfoMap = configItemVWInfoMap;
	}

	public List<SOC0128Info> getConfigItemVersionTime() {
		return configItemVersionTime;
	}

	public void setConfigItemVersionTime(List<SOC0128Info> configItemVersionTime) {
		this.configItemVersionTime = configItemVersionTime;
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

	

	public String getOrgsyscoding() {
		return orgsyscoding;
	}

	public void setOrgsyscoding(String orgsyscoding) {
		this.orgsyscoding = orgsyscoding;
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

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
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

	public Integer getDomainversion() {
		return domainversion;
	}

	public void setDomainversion(Integer domainversion) {
		this.domainversion = domainversion;
	}

	public Integer getDomainid() {
		return domainid;
	}

	public void setDomainid(Integer domainid) {
		this.domainid = domainid;
	}

	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	public SOC0124SearchCond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	public void setEntityItemVWSearchCond(SOC0124SearchCond entityItemVWSearchCond) {
		this.entityItemVWSearchCond = entityItemVWSearchCond;
	}

	public String[] getDeleteEntityItem() {
		return deleteEntityItem;
	}

	public void setDeleteEntityItem(String[] deleteEntityItem) {
		this.deleteEntityItem = deleteEntityItem;
	}

	public List<SOC0124Info> getEntityItemVWInfoList() {
		return EntityItemVWInfoList;
	}

	public void setEntityItemVWInfoList(List<SOC0124Info> entityItemVWInfoList) {
		EntityItemVWInfoList = entityItemVWInfoList;
	}

	

	public List<CodeDetail> getRelationList() {
		return RelationList;
	}

	public void setRelationList(List<CodeDetail> relationList) {
		RelationList = relationList;
	}

	public SOC0119Info getEntityItemRelation() {
		return EntityItemRelation;
	}

	public void setEntityItemRelation(SOC0119Info entityItemRelation) {
		EntityItemRelation = entityItemRelation;
	}

	public int getParCount() {
		return ParCount;
	}

	public void setParCount(int parCount) {
		ParCount = parCount;
	}



	public String[] getDeleteEntityItemRelation() {
		return deleteEntityItemRelation;
	}

	public void setDeleteEntityItemRelation(String[] deleteEntityItemRelation) {
		this.deleteEntityItemRelation = deleteEntityItemRelation;
	}

	public int getCldCount() {
		return cldCount;
	}

	public void setCldCount(int cldCount) {
		this.cldCount = cldCount;
	}



	public SOC0110Info getEntityRelation() {
		return entityRelation;
	}

	public void setEntityRelation(SOC0110Info entityRelation) {
		this.entityRelation = entityRelation;
	}



	public List<SOC0163Info> getEntityVWInfoList() {
		return EntityVWInfoList;
	}

	public void setEntityVWInfoList(List<SOC0163Info> entityVWInfoList) {
		EntityVWInfoList = entityVWInfoList;
	}

	public IGCIM0910Form getIgcim0910Form() {
		return igcim0910Form;
	}

	public void setIgcim0910Form(IGCIM0910Form igcim0910Form) {
		this.igcim0910Form = igcim0910Form;
	}
	
	
}
