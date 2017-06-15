/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.syslog.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.syslog.model.condition.Mss00002SearchCond;
import com.deliverik.infogovernor.syslog.model.condition.Mss00011SearchCond;
import com.deliverik.infogovernor.syslog.vo.IGLOG0041VO;

/**
 * <p>
 * Title : InfoGovernor ��־�澯����
 * </p>
 * <p>
 * Description: ��ع��� >> ������� >> �澯�������Form
 * </p>
 * 
 * @author wangrongguang@deliverik.com
 * @version 1.0
 */

public class IGLOG0021Form extends BaseForm implements Mss00011SearchCond,Mss00002SearchCond{
	
	private static final long serialVersionUID = -7806752326705441563L;
	
	private String ruleid;
	private String devicestate;
	private String[] deleteId;
	private String name_like; 
	private String type_eq;
	private String esyscoding;
	private String typeid;
	private String deviceid;
	private String maxalarmtime;
	private String maxalarmnum;
	protected String devicename;
	/** ��ѡ���������б� */
	protected String[] ruletempids;
	/** �豸ip */
	protected String deviceip;
	
	/** �豸ip */
	protected String deviceip2;
	/** ����ģ��id */
	protected Integer ruletempid;
	
	private IGLOG0041VO vo;
	
	
	public String getName_like() {
		return name_like;
	}
	public void setName_like(String name_like) {
		this.name_like = name_like;
	}
	public String getType_eq() {
		return type_eq;
	}
	public void setType_eq(String type_eq) {
		this.type_eq = type_eq;
	}
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
	public String getEsyscoding() {
		return esyscoding;
	}
	public void setVo(IGLOG0041VO vo) {
		this.vo = vo;
	}
	public IGLOG0041VO getVo() {
		return vo;
	}
	public void setDeleteId(String[] deleteId) {
		this.deleteId = deleteId;
	}
	public String[] getDeleteId() {
		return deleteId;
	}
	public String getRuleid() {
		return ruleid;
	}
	public void setRuleid(String ruleid) {
		this.ruleid = ruleid;
	}
	public String getTypeid() {
		return typeid;
	}
	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}
	public String getDeviceid() {
		return deviceid;
	}
	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}
	
	public String getDevicestate() {
		return devicestate;
	}
	public void setDevicestate(String devicestate) {
		this.devicestate = devicestate;
	}
	/**
	 * ����ģ��idȡ��
	 */
	public Integer getRuletempid() {
		return ruletempid;
	}
	/**
	 * ����ģ��id�趨
	 */
	public void setRuletempid(Integer ruletempid) {
		this.ruletempid = ruletempid;
	}
	public String getMaxalarmtime() {
		return maxalarmtime;
	}
	public void setMaxalarmtime(String maxalarmtime) {
		this.maxalarmtime = maxalarmtime;
	}
	public String getMaxalarmnum() {
		return maxalarmnum;
	}
	public void setMaxalarmnum(String maxalarmnum) {
		this.maxalarmnum = maxalarmnum;
	}
	public String getDevicename() {
		return devicename;
	}
	public void setDevicename(String devicename) {
		this.devicename = devicename;
	}
	public String[] getRuletempids() {
		return ruletempids;
	}
	public void setRuletempids(String[] ruletempids) {
		this.ruletempids = ruletempids;
	}
	public String getDeviceip() {
		return deviceip;
	}
	public void setDeviceip(String deviceip) {
		this.deviceip = deviceip;
	}
	public String getDeviceip2() {
		return deviceip2;
	}
	public void setDeviceip2(String deviceip2) {
		this.deviceip2 = deviceip2;
	}
	
}
