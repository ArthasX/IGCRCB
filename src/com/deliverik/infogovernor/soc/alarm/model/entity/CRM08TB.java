/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.alarm.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Parameter;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.model.entity.CodeDetailTB;
import com.deliverik.infogovernor.soc.alarm.model.CRM08Info;

/**
  * 概述: CRM08实体
  * 功能描述: CRM08实体
  * 创建记录: 2013/07/30
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="CRM08")
public class CRM08TB extends BaseEntity implements Serializable,
		Cloneable, CRM08Info {

	/** RULETEMPID */
	@Id
	@GeneratedValue(generator = "RULETEMPID")
	@GenericGenerator(name = "RULETEMPID", strategy = "sequence", 
			parameters = { @Parameter(name = "sequence", 
						value = "crm08_seq") })
	protected Integer ruletempid;

	/** RULETEMPNAME */
	protected String ruletempname;

	/** CATEGORYCCID */
	protected String categoryccid;

	/** RULECONDITION */
	protected Integer rulecondition;

	/** TEMPSTATE */
	protected Integer tempstate;
	
	protected Integer alarmlevel;
	
	protected String categorycid;
	
	protected String detail;
	
	protected String createtime;
	
	protected String typecid;
	
	protected String typeccid;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="ruletempid", referencedColumnName="ruletempid", updatable=false, insertable= false)
	@NotFound(action = NotFoundAction.IGNORE)
	protected List<CRM07TB> crm07TBList;
	
	public List<CRM07TB> getCrm07TBList() {
		return crm07TBList;
	}

	public void setCrm07TBList(List<CRM07TB> crm07TBList) {
		this.crm07TBList = crm07TBList;
	}
	
	@OneToOne
	@JoinColumns({
		@JoinColumn(name="categoryccid", referencedColumnName="ccid" ,updatable=false, insertable= false),
		@JoinColumn(name="categorycid", referencedColumnName="cid",updatable=false, insertable= false)
		})
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected CodeDetailTB codeDetailTB;
	
	public CodeDetailTB getCodeDetailTB() {
		return codeDetailTB;
	}

	public void setCodeDetailTB(CodeDetailTB codeDetailTB) {
		this.codeDetailTB = codeDetailTB;
	}

	public String getTypecid() {
		return typecid;
	}

	public void setTypecid(String typecid) {
		this.typecid = typecid;
	}

	public String getTypeccid() {
		return typeccid;
	}

	public void setTypeccid(String typeccid) {
		this.typeccid = typeccid;
	}

	public Integer getRuletempid() {
		return ruletempid;
	}

	public void setRuletempid(Integer ruletempid) {
		this.ruletempid = ruletempid;
	}

	public String getRuletempname() {
		return ruletempname;
	}

	public void setRuletempname(String ruletempname) {
		this.ruletempname = ruletempname;
	}

	public String getCategoryccid() {
		return categoryccid;
	}

	public void setCategoryccid(String categoryccid) {
		this.categoryccid = categoryccid;
	}

	public Integer getRulecondition() {
		return rulecondition;
	}

	public void setRulecondition(Integer rulecondition) {
		this.rulecondition = rulecondition;
	}

	public Integer getTempstate() {
		return tempstate;
	}

	public void setTempstate(Integer tempstate) {
		this.tempstate = tempstate;
	}

	public Integer getAlarmlevel() {
		return alarmlevel;
	}

	public void setAlarmlevel(Integer alarmlevel) {
		this.alarmlevel = alarmlevel;
	}

	public String getCategorycid() {
		return categorycid;
	}

	public void setCategorycid(String categorycid) {
		this.categorycid = categorycid;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	@Override
	public Serializable getPK() {
		return ruletempid;
	}
	

}