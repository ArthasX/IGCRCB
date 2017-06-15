/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.drm.form.IGDRM1601Form;
import com.deliverik.infogovernor.drm.form.IGDRM1602Form;
import com.deliverik.infogovernor.drm.form.IGDRM1603Form;
import com.deliverik.infogovernor.drm.form.IGDRM1604Form;
import com.deliverik.infogovernor.drm.model.EventssInfo;
import com.deliverik.infogovernor.drm.model.ScopesInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author zhangying@deliverik.com
 * @version 1.0
 */
public class IGDRM16DTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 事件ID */
	protected String eventId;

	/** 事件名称 */
	protected String eventName;

	/** 事件等级 */
	protected Integer labels;

	/** 允许查询的最大记录数 */
	protected int maxSearchCount;
	
	/** 保留字段 */
	protected String fingerprint;

	/** 分页用DTO */
	protected PagingDTO pagingDto;
	
	protected IGDRM1602Form igdrm1602Form;
	protected IGDRM1601Form igdrm1601Form;
	protected IGDRM1603Form igdrm1603Form;
	protected IGDRM1604Form igdrm1604Form;
	/** 事件级别数据 */
	protected EventssInfo eventssInfo;
	
	/** 事件级别所有数据 */
	protected List<EventssInfo> eventssInfoList;
	
	/** 事件影响范围所有数据 */
	protected List<ScopesInfo> scopesInfoList;
	
	protected Map<String,List<ScopesInfo>> EventssScopesMap;

	/**
	 * eventId 取得
	 * 
	 * @return eventId eventId
	 */
	
	public String getEventId() {
		return eventId;
	}
	
	/**
	 * eventId 设定
	 * 
	 * @return eventId eventId
	 */

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	
	/**
	 * eventName 取得
	 * 
	 * @return eventName eventName
	 */

	public String getEventName() {
		return eventName;
	}
	
	/**
	 * eventName 设定
	 * 
	 * @return eventName eventName
	 */

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	/**
	 * labels 取得
	 * 
	 * @return labels labels
	 */

	public Integer getLabels() {
		return labels;
	}
	
	/**
	 * labels 设定
	 * 
	 * @return labels labels
	 */

	public void setLabels(Integer labels) {
		this.labels = labels;
	}
	
	/**
	 * maxSearchCount 取得
	 * 
	 * @return maxSearchCount maxSearchCount
	 */

	public int getMaxSearchCount() {
		return maxSearchCount;
	}
	
	/**
	 * maxSearchCount 设定
	 * 
	 * @return maxSearchCount maxSearchCount
	 */


	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}
	/**
	 * fingerprint 取得
	 * 
	 * @return fingerprint fingerprint
	 */


	public String getFingerprint() {
		return fingerprint;
	}
	
	/**
	 * fingerprint 设定
	 * 
	 * @return fingerprint fingerprint
	 */

	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}
	
	/**
	 * pagingDto 取得
	 * 
	 * @return pagingDto pagingDto
	 */

	public PagingDTO getPagingDto() {
		return pagingDto;
	}
	
	/**
	 * pagingDto 设定
	 * 
	 * @return pagingDto pagingDto
	 */

	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}
	
	/**
	 * igdrm1602Form 取得
	 * 
	 * @return igdrm1602Form igdrm1602Form
	 */

	public IGDRM1602Form getIgdrm1602Form() {
		return igdrm1602Form;
	}
	
	/**
	 * igdrm1603Form 设定
	 * 
	 * @return igdrm1603Form igdrm1603Form
	 */

	public void setIgdrm1603Form(IGDRM1603Form igdrm1603Form) {
		this.igdrm1603Form = igdrm1603Form;
	}
	
	/**
	 * igdrm1603Form 取得
	 * 
	 * @return igdrm1603Form igdrm1603Form
	 */

	public IGDRM1603Form getIgdrm1603Form() {
		return igdrm1603Form;
	}
	
	/**
	 * igdrm1602Form 设定
	 * 
	 * @return igdrm1602Form igdrm1602Form
	 */

	public void setIgdrm1602Form(IGDRM1602Form igdrm1602Form) {
		this.igdrm1602Form = igdrm1602Form;
	}
	
	/**
	 * igdrm1604Form 取得
	 * 
	 * @return igdrm1604Form igdrm1604Form
	 */

	public IGDRM1604Form getIgdrm1604Form() {
		return igdrm1604Form;
	}
	
	/**
	 * igdrm1604Form 设定
	 * 
	 * @return igdrm1604Form igdrm1604Form
	 */

	public void setIgdrm1604Form(IGDRM1604Form igdrm1604Form) {
		this.igdrm1604Form = igdrm1604Form;
	}
	
	/**
	 * igdrm1601Form 取得
	 * 
	 * @return igdrm1601Form igdrm1601Form
	 */

	public IGDRM1601Form getIgdrm1601Form() {
		return igdrm1601Form;
	}
	
	/**
	 * igdrm1601Form 设定
	 * 
	 * @return igdrm1601Form igdrm1601Form
	 */

	public void setIgdrm1601Form(IGDRM1601Form igdrm1601Form) {
		this.igdrm1601Form = igdrm1601Form;
	}
	
	/**
	 * eventssInfo 取得
	 * 
	 * @return eventssInfo eventssInfo
	 */

	public EventssInfo getEventssInfo() {
		return eventssInfo;
	}
	
	/**
	 * eventssInfo 设定
	 * 
	 * @return eventssInfo eventssInfo
	 */

	public void setEventssInfo(EventssInfo eventssInfo) {
		this.eventssInfo = eventssInfo;
	}
	
	/**
	 * eventssInfoList 取得
	 * 
	 * @return eventssInfoList eventssInfoList
	 */

	public List<EventssInfo> getEventssInfoList() {
		return eventssInfoList;
	}
	
	/**
	 * eventssInfoList 设定
	 * 
	 * @return eventssInfoList eventssInfoList
	 */

	public void setEventssInfoList(List<EventssInfo> eventssInfoList) {
		this.eventssInfoList = eventssInfoList;
	}
	
	/**
	 * eventssInfoList 取得
	 * 
	 * @return eventssInfoList eventssInfoList
	 */


	public List<ScopesInfo> getScopesInfoList() {
		return scopesInfoList;
	}

	/**
	 * eventssInfoList 设定
	 * 
	 * @return eventssInfoList eventssInfoList
	 */
	public void setScopesInfoList(List<ScopesInfo> scopesInfoList) {
		this.scopesInfoList = scopesInfoList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Map<String, List<ScopesInfo>> getEventssScopesMap() {
		return EventssScopesMap;
	}

	public void setEventssScopesMap(Map<String, List<ScopesInfo>> eventssScopesMap) {
		EventssScopesMap = eventssScopesMap;
	}
	
}
