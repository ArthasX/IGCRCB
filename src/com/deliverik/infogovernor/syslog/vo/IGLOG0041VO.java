/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.syslog.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.syslog.model.Mss00003Info;
import com.deliverik.infogovernor.syslog.model.Mss00004VWInfo;

/**
 * <p>
 * Title : ��ع���ƽ̨
 * </p>
 * <p>
 * Description: �������_�澯����ģ�����_��ѯVO
 * </p>
 * 
 * @author wangrongguang@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGLOG0041VO extends BaseVO implements Serializable {

	/**
	 * ģ��list
	 */
	private List<Mss00004VWInfo> mss00004InfoList;
	
	/** �Զ������ģ���б� */
	protected List<Mss00003Info> myTempList;
	
	/** �澯�����б� */
	protected String alarmPriorities;
	
	protected String couldReturn;
	
	
	public String getCouldReturn() {
		return couldReturn;
	}

	public void setCouldReturn(String couldReturn) {
		this.couldReturn = couldReturn;
	}
	
	public String getAlarmPriorities() {
		return alarmPriorities;
	}

	public void setAlarmPriorities(String alarmPriorities) {
		this.alarmPriorities = alarmPriorities;
	}

	/**
	 * ���췽��
	 * 
	 * @param mss00004InfoList
	 */
	public IGLOG0041VO(){}
	
	public IGLOG0041VO(List<Mss00004VWInfo> mss00004InfoList) {
		this.mss00004InfoList = mss00004InfoList;
	}

	/**
	 * ��ȡ
	 * 
	 * @return List<Mss00004Info>
	 */
	public List<Mss00004VWInfo> getMss00004InfoList() {
		return mss00004InfoList;
	}

	/**
	 * �Զ������ģ���б�ȡ��
	 */
	public List<Mss00003Info> getMyTempList() {
		return myTempList;
	}

	/**
	 * �Զ������ģ���б��趨
	 */
	public void setMyTempList(List<Mss00003Info> myTempList) {
		this.myTempList = myTempList;
	}

	/**
	 * ģ��list�趨
	 */
	public void setMss00004InfoList(List<Mss00004VWInfo> mss00004InfoList) {
		this.mss00004InfoList = mss00004InfoList;
	}
	
}
