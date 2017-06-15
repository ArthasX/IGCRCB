/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.dut.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.dut.model.DutyPerson;
import com.deliverik.infogovernor.dut.model.DutyPlan;

/**
 * ֵ�������ʵ��
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="DutyPlan")
public class DutyPlanTB extends BaseEntity implements Serializable, Cloneable, DutyPlan {
	
	@Id
	@TableGenerator(
		    name="DUTYPLAN_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="DUTYPLAN_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="DUTYPLAN_TABLE_GENERATOR")
	protected Integer dpid;
	protected String dadcategory;
	protected String dptime;
	protected String dptype;
	protected String dpstatus;
	protected String dpquestion;
	protected String dpinfo;
	protected String dpuserid;
	protected String dpusername;
	protected String dpcretime;
	protected String dpupdtime;
	protected String dpfintime;
	protected String dpremarks;
	
	/**
	 * ֵ����
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "dpid")
	@NotFound(action = NotFoundAction.IGNORE)
	protected List<DutyPersonTB> dutyPersonList;
	public Integer getDpid() {
		return dpid;
	}
	public void setDpid(Integer dpid) {
		this.dpid = dpid;
	}
	public String getDadcategory() {
		return dadcategory;
	}
	public void setDadcategory(String dadcategory) {
		this.dadcategory = dadcategory;
	}
	public String getDptime() {
		return dptime;
	}
	public void setDptime(String dptime) {
		this.dptime = dptime;
	}
	public String getDptype() {
		return dptype;
	}
	public void setDptype(String dptype) {
		this.dptype = dptype;
	}
	public String getDpstatus() {
		return dpstatus;
	}
	public void setDpstatus(String dpstatus) {
		this.dpstatus = dpstatus;
	}
	public String getDpquestion() {
		return dpquestion;
	}
	public void setDpquestion(String dpquestion) {
		this.dpquestion = dpquestion;
	}
	public String getDpinfo() {
		return dpinfo;
	}
	public void setDpinfo(String dpinfo) {
		this.dpinfo = dpinfo;
	}
	public String getDpuserid() {
		return dpuserid;
	}
	public void setDpuserid(String dpuserid) {
		this.dpuserid = dpuserid;
	}
	public String getDpusername() {
		return dpusername;
	}
	public void setDpusername(String dpusername) {
		this.dpusername = dpusername;
	}
	public String getDpcretime() {
		return dpcretime;
	}
	public void setDpcretime(String dpcretime) {
		this.dpcretime = dpcretime;
	}
	public String getDpupdtime() {
		return dpupdtime;
	}
	public void setDpupdtime(String dpupdtime) {
		this.dpupdtime = dpupdtime;
	}
	public String getDpfintime() {
		return dpfintime;
	}
	public void setDpfintime(String dpfintime) {
		this.dpfintime = dpfintime;
	}
	/**
	 * dpremarksȡ��
	 *
	 * @return dpremarks dpremarks
	 */
	public String getDpremarks() {
		return dpremarks;
	}
	/**
	 * dpremarks�趨
	 *
	 * @param dpremarks dpremarks
	 */
	public void setDpremarks(String dpremarks) {
		this.dpremarks = dpremarks;
	}
	@Override
	public Serializable getPK() {
		return dpid;
	}
	/**
	 * 
	 * ֵ����ȡ��
	 * @return ֵ����
	 */
	public List<DutyPersonTB> getDutyPersonList() {
		return dutyPersonList;
	}
	
	/**
     * 
	 * ȫ��ֵ��������ȡ��
	 * @return ȫ��ֵ��������
	 */
	public String getDutyPersonName() {
		if(dutyPersonList != null) {
			StringBuffer usersinfo = new StringBuffer();
			for(DutyPerson dp : dutyPersonList) {
				usersinfo.append(dp.getDperusername()).append("&nbsp;&nbsp;&nbsp;&nbsp;");
			}
			return usersinfo.toString();
		} else {
			return "";
		}
	}
	
}
