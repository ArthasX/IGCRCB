/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG111Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程查询条件定义实体
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name="IG111")
public class IG111TB extends BaseEntity implements IG111Info{
	
	/** 主键 */
	@Id
	protected String qid;
	
	/** 流程定义ID */
	protected String pdid;
	
	/** 查询方式 */
	protected String qmode;
	
	/** 查询条件标识 */
	protected String qtype;
	
	/** 查询条件标识 */
	protected String qflag;
	
	/** 标识名称 */
	protected String qname;
	
	/** 表单定义实体 */
	@Transient
	protected IG007Info pid;
	
	/**
	 * 主键取得
	 * @return qid 主键
	 */
	public String getQid() {
		return qid;
	}

	/**
	 * 主键设定
	 * @param qid 主键
	 */
	public void setQid(String qid) {
		this.qid = qid;
	}

	/**
	 * 流程定义ID取得
	 * @return pdid 流程定义ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程定义ID设定
	 * @param pdid 流程定义ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 查询方式取得
	 * @return qmode 查询方式
	 */
	public String getQmode() {
		return qmode;
	}

	/**
	 * 查询方式设定
	 * @param qmode 查询方式
	 */
	public void setQmode(String qmode) {
		this.qmode = qmode;
	}

	/**
	 * 查询条件标识取得
	 * @return qtype 查询条件标识
	 */
	public String getQtype() {
		return qtype;
	}

	/**
	 * 查询条件标识设定
	 * @param qtype 查询条件标识
	 */
	public void setQtype(String qtype) {
		this.qtype = qtype;
	}

	/**
	 * 查询条件标识取得
	 * @return qflag 查询条件标识
	 */
	public String getQflag() {
		return qflag;
	}

	/**
	 * 查询条件标识设定
	 * @param qflag 查询条件标识
	 */
	public void setQflag(String qflag) {
		this.qflag = qflag;
	}

	/**
	 * 标识名称取得
	 * @return qname 标识名称
	 */
	public String getQname() {
		return qname;
	}

	/**
	 * 标识名称设定
	 * @param qname 标识名称
	 */
	public void setQname(String qname) {
		this.qname = qname;
	}
	
	/**
	 * 表单定义实体取得
	 * @return pid 表单定义实体
	 */
	public IG007Info getPid() {
		if(pid == null && "pi".equals(qtype)){
			WorkFlowDefinitionBL bl = (WorkFlowDefinitionBL) WebApplicationSupport.getBean("workFlowDefinitionBL");
			try {
				pid = bl.searchProcessInfoDefByKey(qflag);
			} catch (BLException e) {
			}
		}
		return pid;
	}

	/**
	 * 表单定义实体设定
	 * @param pid 表单定义实体
	 */
	public void setPid(IG007Info pid) {
		this.pid = pid;
	}

	/**
	 * 主键取得
	 * @return 主键
	 */
	public Serializable getPK() {
		return this.qid;
	}

}
