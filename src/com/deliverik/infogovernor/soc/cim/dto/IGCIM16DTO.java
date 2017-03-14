package com.deliverik.infogovernor.soc.cim.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.SOC0110Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0163Info;
import com.deliverik.framework.soc.asset.model.SOC0501Info;
import com.deliverik.framework.soc.asset.model.SOC0502Info;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1601Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1611Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1631Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1632Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1633Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1634Form;

/**
 * 人员配置管理业务用DTO
 * 
 */
@SuppressWarnings("serial")
public class IGCIM16DTO extends BaseDTO implements Serializable{

	
	private IGCIM1601Form igcim1601Form;
	private IGCIM1611Form igcim1611Form;
	private List<SOC0501Info> soc0501List;
	private List<SOC0502Info> soc0502List;
	private SOC0501Info soc0501Info;
	private SOC0502Info soc0502Info;
	
	private IGCIM1631Form igcim1631Form;
	private IGCIM1632Form igcim1632Form;
	private IGCIM1633Form igcim1633Form;
	private SOC0118Info soc0118Info;
	private SOC0119Info soc0119Info;
	private SOC0124Info soc0124Info;
	
	private List<SOC0118Info> soc0118List;
	private List<SOC0119Info> soc0119List;
	private List<SOC0124Info> soc0124List;
	private List<SOC0163Info> soc0163List;
	private User user;
	private Locale locale;
	private String eiorgname;
	private boolean flag;
	private Map<String, List<SOC0110Info>> rlnmap ;
	private List<SOC0110Info> eiBelongRelationList;
	private String[] DeleteEntityItemRelation;
	
	private IGCIM1634Form igcim1634Form;
	
	private String topoXML;
	
	
	public String getTopoXML() {
		return topoXML;
	}
	public void setTopoXML(String topoXML) {
		this.topoXML = topoXML;
	}
	public IGCIM1634Form getIgcim1634Form() {
		return igcim1634Form;
	}
	public void setIgcim1634Form(IGCIM1634Form igcim1634Form) {
		this.igcim1634Form = igcim1634Form;
	}
	public String[] getDeleteEntityItemRelation() {
		return DeleteEntityItemRelation;
	}
	public void setDeleteEntityItemRelation(String[] deleteEntityItemRelation) {
		DeleteEntityItemRelation = deleteEntityItemRelation;
	}
	public List<SOC0110Info> getEiBelongRelationList() {
		return eiBelongRelationList;
	}
	public void setEiBelongRelationList(List<SOC0110Info> eiBelongRelationList) {
		this.eiBelongRelationList = eiBelongRelationList;
	}
	public Map<String, List<SOC0110Info>> getRlnmap() {
		return rlnmap;
	}
	public void setRlnmap(Map<String, List<SOC0110Info>> rlnmap) {
		this.rlnmap = rlnmap;
	}
	public boolean getFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public SOC0124Info getSoc0124Info() {
		return soc0124Info;
	}
	public void setSoc0124Info(SOC0124Info soc0124Info) {
		this.soc0124Info = soc0124Info;
	}
	public String getEiorgname() {
		return eiorgname;
	}
	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public IGCIM1632Form getIgcim1632Form() {
		return igcim1632Form;
	}
	public void setIgcim1632Form(IGCIM1632Form igcim1632Form) {
		this.igcim1632Form = igcim1632Form;
	}
	public Locale getLocale() {
		return locale;
	}
	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	public List<SOC0124Info> getSoc0124List() {
		return soc0124List;
	}
	public void setSoc0124List(List<SOC0124Info> soc0124List) {
		this.soc0124List = soc0124List;
	}
	/** 检索最大件数 */
	protected int maxSearchCount;
	
	/** 翻页用DTO */
	protected PagingDTO pagingDto;
	
	
	public IGCIM1601Form getIgcim1601Form() {
		return igcim1601Form;
	}
	public void setIgcim1601Form(IGCIM1601Form igcim1601Form) {
		this.igcim1601Form = igcim1601Form;
	}
	public IGCIM1611Form getIgcim1611Form() {
		return igcim1611Form;
	}
	public void setIgcim1611Form(IGCIM1611Form igcim1611Form) {
		this.igcim1611Form = igcim1611Form;
	}
	public List<SOC0501Info> getSoc0501List() {
		return soc0501List;
	}
	public void setSoc0501List(List<SOC0501Info> soc0501List) {
		this.soc0501List = soc0501List;
	}
	public List<SOC0502Info> getSoc0502List() {
		return soc0502List;
	}
	public void setSoc0502List(List<SOC0502Info> soc0502List) {
		this.soc0502List = soc0502List;
	}
	public int getMaxSearchCount() {
		return maxSearchCount;
	}
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}
	public PagingDTO getPagingDto() {
		return pagingDto;
	}
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}
	public SOC0501Info getSoc0501Info() {
		return soc0501Info;
	}
	public void setSoc0501Info(SOC0501Info soc0501Info) {
		this.soc0501Info = soc0501Info;
	}
	public SOC0502Info getSoc0502Info() {
		return soc0502Info;
	}
	public void setSoc0502Info(SOC0502Info soc0502Info) {
		this.soc0502Info = soc0502Info;
	}
	
	public IGCIM1631Form getIgcim1631Form() {
		return igcim1631Form;
	}
	public void setIgcim1631Form(IGCIM1631Form igcim1631Form) {
		this.igcim1631Form = igcim1631Form;
	}
	public SOC0118Info getSoc0118Info() {
		return soc0118Info;
	}
	public void setSoc0118Info(SOC0118Info soc0118Info) {
		this.soc0118Info = soc0118Info;
	}
	public SOC0119Info getSoc0119Info() {
		return soc0119Info;
	}
	public void setSoc0119Info(SOC0119Info soc0119Info) {
		this.soc0119Info = soc0119Info;
	}
	public List<SOC0118Info> getSoc0118List() {
		return soc0118List;
	}
	public void setSoc0118List(List<SOC0118Info> soc0118List) {
		this.soc0118List = soc0118List;
	}
	public List<SOC0119Info> getSoc0119List() {
		return soc0119List;
	}
	public void setSoc0119List(List<SOC0119Info> soc0119List) {
		this.soc0119List = soc0119List;
	}
	public IGCIM1633Form getIgcim1633Form() {
		return igcim1633Form;
	}
	public void setIgcim1633Form(IGCIM1633Form igcim1633Form) {
		this.igcim1633Form = igcim1633Form;
	}
	public List<SOC0163Info> getSoc0163List() {
		return soc0163List;
	}
	public void setSoc0163List(List<SOC0163Info> soc0163List) {
		this.soc0163List = soc0163List;
	}
	
}


