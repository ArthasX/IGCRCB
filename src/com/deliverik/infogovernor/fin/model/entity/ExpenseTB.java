package com.deliverik.infogovernor.fin.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.fin.model.Expense;


/**
 * 
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="Expense")
public class ExpenseTB extends BaseEntity implements Serializable, Cloneable, Expense {

	@Id
	@TableGenerator(
		    name="EXPENSE_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="EXPENSE_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="EXPENSE_TABLE_GENERATOR")
	protected Integer exid;

	protected Integer bid;
	
	protected String exdesc;
	
	protected Double examount;
	
	protected String exinfo;
	
	protected String exstatus;
	
	protected String exreqid;
	
	protected String exreqname;
	
	protected String exinittime;
	
	protected String exopentime;
	
	protected String exapvid;
	
	protected String exapvname;
	
	protected String exclosetime;
	
	protected String exattkey;
	
	protected String exeiinfo;
	
	protected String exprinfo;
	
	protected String expinfo;
	
	protected String exorginfo;
	
	protected String btitle;
	
	
	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	/**
	 * 
	 * @return 
	 */
	public Serializable getPK() {
		return exid;
	}

	/**
	 * @return 
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof ExpenseTB))
			return false;
		Expense target = (Expense) obj;
		if (!(getExid()==target.getExid()))
			return false;

		return true;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.fin.model.entity.Expense#getExid()
	 */
	public Integer getExid() {
		return exid;
	}

	public void setExid(Integer exid) {
		this.exid = exid;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.fin.model.entity.Expense#getBid()
	 */
	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.fin.model.entity.Expense#getExdesc()
	 */
	public String getExdesc() {
		return exdesc;
	}

	public void setExdesc(String exdesc) {
		this.exdesc = exdesc;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.fin.model.entity.Expense#getExamount()
	 */
	public Double getExamount() {
		return examount;
	}

	public void setExamount(Double examount) {
		this.examount = examount;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.fin.model.entity.Expense#getExinfo()
	 */
	public String getExinfo() {
		return exinfo;
	}

	public void setExinfo(String exinfo) {
		this.exinfo = exinfo;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.fin.model.entity.Expense#getExstatus()
	 */
	public String getExstatus() {
		return exstatus;
	}

	public void setExstatus(String exstatus) {
		this.exstatus = exstatus;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.fin.model.entity.Expense#getExreqid()
	 */
	public String getExreqid() {
		return exreqid;
	}

	public void setExreqid(String exreqid) {
		this.exreqid = exreqid;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.fin.model.entity.Expense#getExreqname()
	 */
	public String getExreqname() {
		return exreqname;
	}

	public void setExreqname(String exreqname) {
		this.exreqname = exreqname;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.fin.model.entity.Expense#getExinittime()
	 */
	public String getExinittime() {
		return exinittime;
	}

	public void setExinittime(String exinittime) {
		this.exinittime = exinittime;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.fin.model.entity.Expense#getExopentime()
	 */
	public String getExopentime() {
		return exopentime;
	}

	public void setExopentime(String exopentime) {
		this.exopentime = exopentime;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.fin.model.entity.Expense#getExapvid()
	 */
	public String getExapvid() {
		return exapvid;
	}

	public void setExapvid(String exapvid) {
		this.exapvid = exapvid;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.fin.model.entity.Expense#getExapvname()
	 */
	public String getExapvname() {
		return exapvname;
	}

	public void setExapvname(String exapvname) {
		this.exapvname = exapvname;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.fin.model.entity.Expense#getExclosetime()
	 */
	public String getExclosetime() {
		return exclosetime;
	}

	public void setExclosetime(String exclosetime) {
		this.exclosetime = exclosetime;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.fin.model.entity.Expense#getExattkey()
	 */
	public String getExattkey() {
		return exattkey;
	}

	public void setExattkey(String exattkey) {
		this.exattkey = exattkey;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.fin.model.entity.Expense#getExeiinfo()
	 */
	public String getExeiinfo() {
		return exeiinfo;
	}

	public void setExeiinfo(String exeiinfo) {
		this.exeiinfo = exeiinfo;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.fin.model.entity.Expense#getExprinfo()
	 */
	public String getExprinfo() {
		return exprinfo;
	}

	public void setExprinfo(String exprinfo) {
		this.exprinfo = exprinfo;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.fin.model.entity.Expense#getExpinfo()
	 */
	public String getExpinfo() {
		return expinfo;
	}

	public void setExpinfo(String expinfo) {
		this.expinfo = expinfo;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.fin.model.entity.Expense#getExorginfo()
	 */
	public String getExorginfo() {
		return exorginfo;
	}

	public void setExorginfo(String exorginfo) {
		this.exorginfo = exorginfo;
	}

}