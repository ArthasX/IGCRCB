package com.deliverik.infogovernor.prj.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.prj.model.ProjectLog;


/**
 * 
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="ProjectLog")
public class ProjectLogTB extends BaseEntity implements Serializable, Cloneable, ProjectLog {

	@Id
	@TableGenerator(
		    name="PROJECTLOG_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="PROJECTLOG_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="PROJECTLOG_TABLE_GENERATOR")
	protected Integer plid;

	protected Integer pid;
	
	protected Integer plroleid;
	
	protected String plrolename;
	
	protected String pluserid;
	
	protected String plusername;
	
	protected String plinfo;
	
	protected String pltype;
	
	protected String pltime;
	
	protected String plattkey;
	
	
	/**
	 * 
	 * @return 
	 */
	public Serializable getPK() {
		return plid;
	}

	/**
	 * @return 
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof ProjectLogTB))
			return false;
		ProjectLog target = (ProjectLog) obj;
		if (!(getPlid()==target.getPlid()))
			return false;

		return true;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.prj.model.entity.ProjectLog#getPlid()
	 */
	public Integer getPlid() {
		return plid;
	}

	public void setPlid(Integer plid) {
		this.plid = plid;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.prj.model.entity.ProjectLog#getPid()
	 */
	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.prj.model.entity.ProjectLog#getPlroleid()
	 */
	public Integer getPlroleid() {
		return plroleid;
	}

	public void setPlroleid(Integer plroleid) {
		this.plroleid = plroleid;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.prj.model.entity.ProjectLog#getPlrolename()
	 */
	public String getPlrolename() {
		return plrolename;
	}

	public void setPlrolename(String plrolename) {
		this.plrolename = plrolename;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.prj.model.entity.ProjectLog#getPluserid()
	 */
	public String getPluserid() {
		return pluserid;
	}

	public void setPluserid(String pluserid) {
		this.pluserid = pluserid;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.prj.model.entity.ProjectLog#getPlusername()
	 */
	public String getPlusername() {
		return plusername;
	}

	public void setPlusername(String plusername) {
		this.plusername = plusername;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.prj.model.entity.ProjectLog#getPlinfo()
	 */
	public String getPlinfo() {
		return plinfo;
	}

	public void setPlinfo(String plinfo) {
		this.plinfo = plinfo;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.prj.model.entity.ProjectLog#getPltype()
	 */
	public String getPltype() {
		return pltype;
	}

	public void setPltype(String pltype) {
		this.pltype = pltype;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.prj.model.entity.ProjectLog#getPltime()
	 */
	public String getPltime() {
		return pltime;
	}

	public void setPltime(String pltime) {
		this.pltime = pltime;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.prj.model.entity.ProjectLog#getPlattkey()
	 */
	public String getPlattkey() {
		return plattkey;
	}

	public void setPlattkey(String plattkey) {
		this.plattkey = plattkey;
	}


}
