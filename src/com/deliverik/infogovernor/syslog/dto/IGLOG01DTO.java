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
	
	/** ʵʱ�豸��־Form */
	protected IGLOG0101Form iglog0101Form;
	
	/**������Ϣ��ѯҳ */
	protected IGLOG0114Form iglog0114Form;
	
	/** ��ά��Ա */
	protected String isMaintain;
	
	public IGLOG0114Form getIglog0114Form() {
		return iglog0114Form;
	}

	public void setIglog0114Form(IGLOG0114Form iglog0114Form) {
		this.iglog0114Form = iglog0114Form;
	}
	
	/** ��ʷ�豸��־Form */
	protected IGLOG0102Form iglog0102Form;
	
	/** ���������� */
	protected int maxSearchCount;
	
	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;
	
	/** ���ʻ���Ϣ */
	protected Locale locale;
	
	/** �豸ʵʱ��־�б� */
	protected List<Mss00008Info> sysLogList;
	
	/** �豸��ʷ��־�б� */
	protected List historySysLogList;
	
	protected List CheckedsyslogList;
	
	public List getCheckedsyslogList() {
		return CheckedsyslogList;
	}

	public void setCheckedsyslogList(List checkedsyslogList) {
		CheckedsyslogList = checkedsyslogList;
	}
	/** �澯�����б� */
	protected List<CodeDetail> alarmPrioritiesList;
	
	protected List<CodeDetail> ruleli=null;
	/** �澯�����б�(�ַ�����ʽ) */
	protected String alarmPrioritiesStr;
	
	public List<CodeDetail> getRuleli() {
		return ruleli;
	}

	public void setRuleli(List<CodeDetail> ruleli) {
		this.ruleli = ruleli;
	}
	/** ʵʱ����ˢ��Ƶ�� */
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
	/**�澯����*/
	protected Integer totalcount;
	
	/** �豸ʵʱ�澯��Ϣ�б�(������) */
	protected List<IGLOG0003VO> list_vo;
	
	/**���α���Ϣ**/
	protected IGLOG0114VO mssinfo13_vo;
	/** ʵʱsyslogʵ�� */
	protected Mss00008Info syslogbean;
	
	protected User user;
	

	public Mss00008Info getSyslogbean() {
		return syslogbean;
	}

	public void setSyslogbean(Mss00008Info syslogbean) {
		this.syslogbean = syslogbean;
	}

	/**
	 * �豸ʵʱ�澯��Ϣ�б�(������)ȡ��
	 */
	public List<IGLOG0003VO> getList_vo() {
		return list_vo;
	}

	/**
	 * �豸ʵʱ�澯��Ϣ�б�(������)�趨
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
	 * ��ά��Ա��ʶȡ��
	 *
	 * @return isMaintain ��ά��Ա
	 */
	public String getIsMaintain() {
		return isMaintain;
	}
	
	/**
	 * ��ά��Ա�趨
	 *
	 * @param isMaintain ��ά��Ա
	 */
	public void setIsMaintain(String isMaintain) {
		this.isMaintain = isMaintain;
	}
}
