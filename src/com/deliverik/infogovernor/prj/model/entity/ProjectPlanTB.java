package com.deliverik.infogovernor.prj.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.prj.model.ProjectPlan;


/**
 * 
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="ProjectPlan")
public class ProjectPlanTB extends BaseEntity implements Serializable, Cloneable, ProjectPlan {

	@Id
	@TableGenerator(
		    name="PROJECTPLAN_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="PROJECTPLAN_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="PROJECTPLAN_TABLE_GENERATOR")
	protected Integer pplid;

	protected Integer pid;
	
	protected String pplinfo;
	
	protected Integer pplversion;
	
	protected String pplstatus;
	
	protected String ppldesc;
	
	protected String ppldate;
	
	protected String ppltitle;
	
	protected String pplclosetime;
	
	protected String pplopentime;
	
	protected String pplshuttime;
	
	/**
	 * ¸½¼þ
	 * @return
	 */
	protected String pplriskatt;
	
	/**
	 * 
	 * @return 
	 */
	public Serializable getPK() {
		return pplid;
	}

	/**
	 * @return 
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof ProjectPlanTB))
			return false;
		ProjectPlan target = (ProjectPlan) obj;
		if (!(getPplid()==target.getPplid()))
			return false;

		return true;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.prj.model.entity.ProjectPlan#getPplid()
	 */
	public Integer getPplid() {
		return pplid;
	}

	public void setPplid(Integer pplid) {
		this.pplid = pplid;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.prj.model.entity.ProjectPlan#getPid()
	 */
	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.prj.model.entity.ProjectPlan#getPplinfo()
	 */
	public String getPplinfo() {
		return pplinfo;
	}

	public void setPplinfo(String pplinfo) {
		this.pplinfo = pplinfo;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.prj.model.entity.ProjectPlan#getPplversion()
	 */
	public Integer getPplversion() {
		return pplversion;
	}

	public void setPplversion(Integer pplversion) {
		this.pplversion = pplversion;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.prj.model.entity.ProjectPlan#getPplstatus()
	 */
	public String getPplstatus() {
		return pplstatus;
	}

	public void setPplstatus(String pplstatus) {
		this.pplstatus = pplstatus;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.prj.model.entity.ProjectPlan#getPpldesc()
	 */
	public String getPpldesc() {
		return ppldesc;
	}

	public void setPpldesc(String ppldesc) {
		this.ppldesc = ppldesc;
	}

	public String getPpldate() {
		return ppldate;
	}

	public void setPpldate(String ppldate) {
		this.ppldate = ppldate;
	}

	public String getPpltitle() {
		return ppltitle;
	}

	public void setPpltitle(String ppltitle) {
		this.ppltitle = ppltitle;
	}

	public String getPplclosetime() {
		return pplclosetime;
	}

	public void setPplclosetime(String pplclosetime) {
		this.pplclosetime = pplclosetime;
	}

	public String getPplriskatt() {
		return pplriskatt;
	}

	public void setPplriskatt(String pplriskatt) {
		this.pplriskatt = pplriskatt;
	}

	public String getPplopentime() {
		return pplopentime;
	}

	public void setPplopentime(String pplopentime) {
		this.pplopentime = pplopentime;
	}

	public String getPplshuttime() {
		return pplshuttime;
	}

	public void setPplshuttime(String pplshuttime) {
		this.pplshuttime = pplshuttime;
	}

	
}
