/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * Title : InfoGovernor ��Ϣ�������ƽ̨
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

	/** �¼�ID */
	protected String eventId;

	/** �¼����� */
	protected String eventName;

	/** �¼��ȼ� */
	protected Integer labels;

	/** �����ѯ������¼�� */
	protected int maxSearchCount;
	
	/** �����ֶ� */
	protected String fingerprint;

	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;
	
	protected IGDRM1602Form igdrm1602Form;
	protected IGDRM1601Form igdrm1601Form;
	protected IGDRM1603Form igdrm1603Form;
	protected IGDRM1604Form igdrm1604Form;
	/** �¼��������� */
	protected EventssInfo eventssInfo;
	
	/** �¼������������� */
	protected List<EventssInfo> eventssInfoList;
	
	/** �¼�Ӱ�췶Χ�������� */
	protected List<ScopesInfo> scopesInfoList;
	
	protected Map<String,List<ScopesInfo>> EventssScopesMap;

	/**
	 * eventId ȡ��
	 * 
	 * @return eventId eventId
	 */
	
	public String getEventId() {
		return eventId;
	}
	
	/**
	 * eventId �趨
	 * 
	 * @return eventId eventId
	 */

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	
	/**
	 * eventName ȡ��
	 * 
	 * @return eventName eventName
	 */

	public String getEventName() {
		return eventName;
	}
	
	/**
	 * eventName �趨
	 * 
	 * @return eventName eventName
	 */

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	/**
	 * labels ȡ��
	 * 
	 * @return labels labels
	 */

	public Integer getLabels() {
		return labels;
	}
	
	/**
	 * labels �趨
	 * 
	 * @return labels labels
	 */

	public void setLabels(Integer labels) {
		this.labels = labels;
	}
	
	/**
	 * maxSearchCount ȡ��
	 * 
	 * @return maxSearchCount maxSearchCount
	 */

	public int getMaxSearchCount() {
		return maxSearchCount;
	}
	
	/**
	 * maxSearchCount �趨
	 * 
	 * @return maxSearchCount maxSearchCount
	 */


	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}
	/**
	 * fingerprint ȡ��
	 * 
	 * @return fingerprint fingerprint
	 */


	public String getFingerprint() {
		return fingerprint;
	}
	
	/**
	 * fingerprint �趨
	 * 
	 * @return fingerprint fingerprint
	 */

	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}
	
	/**
	 * pagingDto ȡ��
	 * 
	 * @return pagingDto pagingDto
	 */

	public PagingDTO getPagingDto() {
		return pagingDto;
	}
	
	/**
	 * pagingDto �趨
	 * 
	 * @return pagingDto pagingDto
	 */

	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}
	
	/**
	 * igdrm1602Form ȡ��
	 * 
	 * @return igdrm1602Form igdrm1602Form
	 */

	public IGDRM1602Form getIgdrm1602Form() {
		return igdrm1602Form;
	}
	
	/**
	 * igdrm1603Form �趨
	 * 
	 * @return igdrm1603Form igdrm1603Form
	 */

	public void setIgdrm1603Form(IGDRM1603Form igdrm1603Form) {
		this.igdrm1603Form = igdrm1603Form;
	}
	
	/**
	 * igdrm1603Form ȡ��
	 * 
	 * @return igdrm1603Form igdrm1603Form
	 */

	public IGDRM1603Form getIgdrm1603Form() {
		return igdrm1603Form;
	}
	
	/**
	 * igdrm1602Form �趨
	 * 
	 * @return igdrm1602Form igdrm1602Form
	 */

	public void setIgdrm1602Form(IGDRM1602Form igdrm1602Form) {
		this.igdrm1602Form = igdrm1602Form;
	}
	
	/**
	 * igdrm1604Form ȡ��
	 * 
	 * @return igdrm1604Form igdrm1604Form
	 */

	public IGDRM1604Form getIgdrm1604Form() {
		return igdrm1604Form;
	}
	
	/**
	 * igdrm1604Form �趨
	 * 
	 * @return igdrm1604Form igdrm1604Form
	 */

	public void setIgdrm1604Form(IGDRM1604Form igdrm1604Form) {
		this.igdrm1604Form = igdrm1604Form;
	}
	
	/**
	 * igdrm1601Form ȡ��
	 * 
	 * @return igdrm1601Form igdrm1601Form
	 */

	public IGDRM1601Form getIgdrm1601Form() {
		return igdrm1601Form;
	}
	
	/**
	 * igdrm1601Form �趨
	 * 
	 * @return igdrm1601Form igdrm1601Form
	 */

	public void setIgdrm1601Form(IGDRM1601Form igdrm1601Form) {
		this.igdrm1601Form = igdrm1601Form;
	}
	
	/**
	 * eventssInfo ȡ��
	 * 
	 * @return eventssInfo eventssInfo
	 */

	public EventssInfo getEventssInfo() {
		return eventssInfo;
	}
	
	/**
	 * eventssInfo �趨
	 * 
	 * @return eventssInfo eventssInfo
	 */

	public void setEventssInfo(EventssInfo eventssInfo) {
		this.eventssInfo = eventssInfo;
	}
	
	/**
	 * eventssInfoList ȡ��
	 * 
	 * @return eventssInfoList eventssInfoList
	 */

	public List<EventssInfo> getEventssInfoList() {
		return eventssInfoList;
	}
	
	/**
	 * eventssInfoList �趨
	 * 
	 * @return eventssInfoList eventssInfoList
	 */

	public void setEventssInfoList(List<EventssInfo> eventssInfoList) {
		this.eventssInfoList = eventssInfoList;
	}
	
	/**
	 * eventssInfoList ȡ��
	 * 
	 * @return eventssInfoList eventssInfoList
	 */


	public List<ScopesInfo> getScopesInfoList() {
		return scopesInfoList;
	}

	/**
	 * eventssInfoList �趨
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
