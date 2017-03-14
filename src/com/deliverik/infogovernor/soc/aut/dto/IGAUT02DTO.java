/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.soc.aut.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.aut.form.IGAUT0201Form;
import com.deliverik.infogovernor.soc.aut.form.IGAUT0202Form;
import com.deliverik.infogovernor.soc.aut.form.IGAUT0203Form;
import com.deliverik.infogovernor.soc.aut.form.IGAUT0204Form;
import com.deliverik.infogovernor.soc.aut.form.IGAUT0205Form;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程管理_变更管理DTO
 * </p>
 * 
 * 
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGAUT02DTO extends BaseDTO implements Serializable {

	protected IGAUT0201Form igaut0201Form;
	protected IGAUT0202Form igaut0202Form;
	protected IGAUT0203Form igaut0203Form;
	protected IGAUT0204Form igaut0204Form;
	protected IGAUT0205Form igaut0205Form;
	
	protected Locale locale;
	
	protected List<SOC0124Info> entityItemVWInfoList;

	/** 域ID */
	protected Integer domainid;
	
	/** 域版本 */
	protected Integer domainversion;
	/** 快照生成时间 */
	protected String createtime;
	
	/** 是否显示逻辑关系MAP */
	protected Map<String,String> showRelationMap;
	
	protected User user;
	
	protected String orgname;
	protected String orgsyscoding;
	protected String ename;
	protected String esyscoding;
	protected boolean flag;
	protected Integer maxSearchCount;
	protected PagingDTO pagingDto;
	
	
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

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public Integer getDomainid() {
		return domainid;
	}

	public void setDomainid(Integer domainid) {
		this.domainid = domainid;
	}

	public List<SOC0124Info> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	public void setEntityItemVWInfoList(List<SOC0124Info> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public IGAUT0201Form getIgaut0201Form() {
		return igaut0201Form;
	}

	public void setIgaut0201Form(IGAUT0201Form igaut0201Form) {
		this.igaut0201Form = igaut0201Form;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEsyscoding() {
		return esyscoding;
	}

	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	public boolean getFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public Integer getMaxSearchCount() {
		return maxSearchCount;
	}

	public void setMaxSearchCount(Integer maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	public IGAUT0202Form getIgaut0202Form() {
		return igaut0202Form;
	}

	public void setIgaut0202Form(IGAUT0202Form igaut0202Form) {
		this.igaut0202Form = igaut0202Form;
	}

	public IGAUT0203Form getIgaut0203Form() {
		return igaut0203Form;
	}

	public void setIgaut0203Form(IGAUT0203Form igaut0203Form) {
		this.igaut0203Form = igaut0203Form;
	}

	public IGAUT0204Form getIgaut0204Form() {
		return igaut0204Form;
	}

	public void setIgaut0204Form(IGAUT0204Form igaut0204Form) {
		this.igaut0204Form = igaut0204Form;
	}

	public IGAUT0205Form getIgaut0205Form() {
		return igaut0205Form;
	}

	public void setIgaut0205Form(IGAUT0205Form igaut0205Form) {
		this.igaut0205Form = igaut0205Form;
	}

	
	
}
