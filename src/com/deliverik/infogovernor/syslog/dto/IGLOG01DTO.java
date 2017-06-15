package com.deliverik.infogovernor.syslog.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.syslog.form.IGLOG0101Form;
import com.deliverik.infogovernor.syslog.form.IGLOG0102Form;
import com.deliverik.infogovernor.syslog.form.IGLOG0114Form;
import com.deliverik.infogovernor.syslog.model.Mss00008Info;
import com.deliverik.infogovernor.syslog.model.Mss00013Info;
import com.deliverik.infogovernor.syslog.vo.IGLOG0003VO;
import com.deliverik.infogovernor.syslog.vo.IGLOG0114VO;

@SuppressWarnings("serial")
public class IGLOG01DTO extends BaseDTO implements Serializable{
	
	/** 实时设备日志Form */
	protected IGLOG0101Form iglog0101Form;
	
	/**屏蔽信息查询页 */
	protected IGLOG0114Form iglog0114Form;
	
	/** 运维人员 */
	protected String isMaintain;
	
	public IGLOG0114Form getIglog0114Form() {
		return iglog0114Form;
	}

	public void setIglog0114Form(IGLOG0114Form iglog0114Form) {
		this.iglog0114Form = iglog0114Form;
	}
	
	/** 历史设备日志Form */
	protected IGLOG0102Form iglog0102Form;
	
	/** 检索最大件数 */
	protected int maxSearchCount;
	
	/** 翻页用DTO */
	protected PagingDTO pagingDto;
	
	/** 国际化信息 */
	protected Locale locale;
	
	/** 设备实时日志列表 */
	protected List<Mss00008Info> sysLogList;
	
	/** 设备历史日志列表 */
	protected List historySysLogList;
	
	protected List CheckedsyslogList;
	
	public List getCheckedsyslogList() {
		return CheckedsyslogList;
	}

	public void setCheckedsyslogList(List checkedsyslogList) {
		CheckedsyslogList = checkedsyslogList;
	}
	/** 告警级别列表 */
	protected List<CodeDetail> alarmPrioritiesList;
	
	protected List<CodeDetail> ruleli=null;
	/** 告警级别列表(字符串形式) */
	protected String alarmPrioritiesStr;
	
	public List<CodeDetail> getRuleli() {
		return ruleli;
	}

	public void setRuleli(List<CodeDetail> ruleli) {
		this.ruleli = ruleli;
	}
	/** 实时数据刷新频率 */
	protected String refreshRate;
	
	public List<Mss00013Info>li=null;
	
	public List<Mss00013Info> getLi() {
		return li;
	}

	public void setLi(List<Mss00013Info> li) {
		this.li = li;
	}
	
	public IGLOG0114VO getMssinfo13_vo() {
		return mssinfo13_vo;
	}

	public void setMssinfo13_vo(IGLOG0114VO mssinfo13_vo) {
		this.mssinfo13_vo = mssinfo13_vo;
	}
	/**告警总数*/
	protected Integer totalcount;
	
	/** 设备实时告警信息列表(带流程) */
	protected List<IGLOG0003VO> list_vo;
	
	/**屏蔽表信息**/
	protected IGLOG0114VO mssinfo13_vo;
	/** 实时syslog实体 */
	protected Mss00008Info syslogbean;
	
	protected User user;
	

	public Mss00008Info getSyslogbean() {
		return syslogbean;
	}

	public void setSyslogbean(Mss00008Info syslogbean) {
		this.syslogbean = syslogbean;
	}

	/**
	 * 设备实时告警信息列表(带流程)取得
	 */
	public List<IGLOG0003VO> getList_vo() {
		return list_vo;
	}

	/**
	 * 设备实时告警信息列表(带流程)设定
	 */
	public void setList_vo(List<IGLOG0003VO> list_vo) {
		this.list_vo = list_vo;
	}
	
	
	public Integer getTotalcount() {
		return totalcount;
	}

	public void setTotalcount(Integer totalcount) {
		this.totalcount = totalcount;
	}

	public String getRefreshRate() {
		return refreshRate;
	}

	public void setRefreshRate(String refreshRate) {
		this.refreshRate = refreshRate;
	}
	
	
	public String getAlarmPrioritiesStr() {
		return alarmPrioritiesStr;
	}

	public void setAlarmPrioritiesStr(String alarmPrioritiesStr) {
		this.alarmPrioritiesStr = alarmPrioritiesStr;
	}

	public List<CodeDetail> getAlarmPrioritiesList() {
		return alarmPrioritiesList;
	}

	public void setAlarmPrioritiesList(List<CodeDetail> alarmPrioritiesList) {
		this.alarmPrioritiesList = alarmPrioritiesList;
	}


	public IGLOG0102Form getIglog0102Form() {
		return iglog0102Form;
	}

	public void setIglog0102Form(IGLOG0102Form iglog0102Form) {
		this.iglog0102Form = iglog0102Form;
	}
	public List getHistorySysLogList() {
		return historySysLogList;
	}

	public void setHistorySysLogList(List historySysLogList) {
		this.historySysLogList = historySysLogList;
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

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public IGLOG0101Form getIglog0101Form() {
		return iglog0101Form;
	}

	public void setIglog0101Form(IGLOG0101Form iglog0101Form) {
		this.iglog0101Form = iglog0101Form;
	}

	public List<Mss00008Info> getSysLogList() {
		return sysLogList;
	}

	public void setSysLogList(List<Mss00008Info> sysLogList) {
		this.sysLogList = sysLogList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	/**
	 * 运维人员标识取得
	 *
	 * @return isMaintain 运维人员
	 */
	public String getIsMaintain() {
		return isMaintain;
	}
	
	/**
	 * 运维人员设定
	 *
	 * @param isMaintain 运维人员
	 */
	public void setIsMaintain(String isMaintain) {
		this.isMaintain = isMaintain;
	}
}
