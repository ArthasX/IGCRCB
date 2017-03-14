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
import com.deliverik.infogovernor.soc.cim.form.IGCIM2001Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM2002Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM2003Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM2004Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM2005Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM2006Form;


public class IGCIM20DTO extends BaseDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private IGCIM2001Form igcim2001Form;
	private IGCIM2002Form igcim2002Form;
	private IGCIM2003Form igcim2003Form;
	private IGCIM2004Form igcim2004Form;
	private IGCIM2005Form igcim2005Form;
	private IGCIM2006Form igcim2006Form;
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
	private Map<String,List<SOC0119Info>> parEntityItemRelationMap;
	private Map<String,List<SOC0110Info>> parEntityRelationMap;
	/** 资产项关系管理信息检索结果2 */
	protected Map<String,List<SOC0119Info>> cldEntityItemRelationMap;
	protected Map<String,List<SOC0110Info>> cldEntityRelationMap;
	
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
	
	public IGCIM2001Form getIgcim2001Form() {
		return igcim2001Form;
	}

	public void setIgcim2001Form(IGCIM2001Form igcim2001Form) {
		this.igcim2001Form = igcim2001Form;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public IGCIM2002Form getIgcim2002Form() {
		return igcim2002Form;
	}

	public void setIgcim2002Form(IGCIM2002Form igcim2002Form) {
		this.igcim2002Form = igcim2002Form;
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

	public IGCIM2004Form getIgcim2004Form() {
		return igcim2004Form;
	}

	public void setIgcim2004Form(IGCIM2004Form igcim2004Form) {
		this.igcim2004Form = igcim2004Form;
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

	public IGCIM2003Form getIgcim2003Form() {
		return igcim2003Form;
	}

	public void setIgcim2003Form(IGCIM2003Form igcim2003Form) {
		this.igcim2003Form = igcim2003Form;
	}

	public IGCIM2005Form getIgcim2005Form() {
		return igcim2005Form;
	}

	public void setIgcim2005Form(IGCIM2005Form igcim2005Form) {
		this.igcim2005Form = igcim2005Form;
	}

	public IGCIM2006Form getIgcim2006Form() {
		return igcim2006Form;
	}

	public void setIgcim2006Form(IGCIM2006Form igcim2006Form) {
		this.igcim2006Form = igcim2006Form;
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

	public Map<String, List<SOC0119Info>> getParEntityItemRelationMap() {
		return parEntityItemRelationMap;
	}

	public void setParEntityItemRelationMap(
			Map<String, List<SOC0119Info>> parEntityItemRelationMap) {
		this.parEntityItemRelationMap = parEntityItemRelationMap;
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

	public Map<String, List<SOC0119Info>> getCldEntityItemRelationMap() {
		return cldEntityItemRelationMap;
	}

	public void setCldEntityItemRelationMap(
			Map<String, List<SOC0119Info>> cldEntityItemRelationMap) {
		this.cldEntityItemRelationMap = cldEntityItemRelationMap;
	}

	public SOC0110Info getEntityRelation() {
		return entityRelation;
	}

	public void setEntityRelation(SOC0110Info entityRelation) {
		this.entityRelation = entityRelation;
	}

	public Map<String, List<SOC0110Info>> getParEntityRelationMap() {
		return parEntityRelationMap;
	}

	public void setParEntityRelationMap(
			Map<String, List<SOC0110Info>> parEntityRelationMap) {
		this.parEntityRelationMap = parEntityRelationMap;
	}

	public Map<String, List<SOC0110Info>> getCldEntityRelationMap() {
		return cldEntityRelationMap;
	}

	public void setCldEntityRelationMap(
			Map<String, List<SOC0110Info>> cldEntityRelationMap) {
		this.cldEntityRelationMap = cldEntityRelationMap;
	}

	public List<SOC0163Info> getEntityVWInfoList() {
		return EntityVWInfoList;
	}

	public void setEntityVWInfoList(List<SOC0163Info> entityVWInfoList) {
		EntityVWInfoList = entityVWInfoList;
	}
	
	
}
