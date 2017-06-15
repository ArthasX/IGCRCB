/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.user.model.entity.UserTB;
import com.deliverik.framework.workflow.prr.model.IG463Info;

/**
 * <p>概述:流程代办工作信息实体</p>
 * <p>功能描述：1.流程初始化</p>
 * <p>          2.流程查询</p>
 * <p>创建记录：</p>
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="IG463")
public class IG463TB extends BaseEntity implements Serializable, Cloneable, IG463Info {
	/** 流程代办工作信息ID */
	@Id
	@TableGenerator(
		    name="IG463_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="IG463_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG463_TABLE_GENERATOR")
	
	/** 授权工作ID*/
	protected Integer ppwid;
	
	/** 流程ID*/
	protected Integer ppwprid;
	
	/** 流程类型*/
	protected String ppwprtype;
	
	/** 流程编号*/
	protected String ppwprserialnum;
	
	/** 流程标题*/
	protected String ppwprtitle;
	
	/** 授权人ID*/
	protected String ppwauthorizeuserid;
	
	/** 代理人ID*/
	protected String ppwproxyuserid;
	
	/** 代理人姓名*/
	protected String ppwproxyusername ;
	
	/** 代理人处理时间*/
	protected String ppwoptiontime;
	
	/** 关闭标识*/
	protected String ppwcloseflag;
	
	@OneToOne
	@JoinColumn(name="ppwauthorizeuserid", referencedColumnName="userid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	/** 授权人TB*/
	protected UserTB userTB;
	/**
	 * 功能：授权工作ID取得
	 * 
	 * @return 授权工作ID
	 */
	public Integer getPpwid() {
		return ppwid;
	}
	
	/**
	 * 功能：授权工作ID设定
	 *
	 * @param ppwid 授权工作ID
	 */
	public void setPpwid(Integer ppwid) {
		this.ppwid = ppwid;
	}
	
	/**
	 * 功能：流程id取得
	 * 
	 * @return 流程id
	 */
	public Integer getPpwprid() {
		return ppwprid;
	}
	
	/**
	 * 功能：流程id设定
	 *
	 * @param ppwprid 流程id
	 */
	public void setPpwprid(Integer ppwprid) {
		this.ppwprid = ppwprid;
	}
	
	/**
	 * 功能：流程类型取得
	 * 
	 * @return 流程类型
	 */
	public String getPpwprtype() {
		return ppwprtype;
	}
	
	/**
	 * 功能：流程类型设定
	 *
	 * @param ppwprtype 流程类型
	 */
	public void setPpwprtype(String ppwprtype) {
		this.ppwprtype = ppwprtype;
	}
	
	/**
	 * 功能：流程编号取得
	 * 
	 * @return 流程编号
	 */
	public String getPpwprserialnum() {
		return ppwprserialnum;
	}
	
	/**
	 * 功能：流程编号设定
	 *
	 * @param ppwprserialnum 流程编号
	 */
	public void setPpwprserialnum(String ppwprserialnum) {
		this.ppwprserialnum = ppwprserialnum;
	}
	
	/**
	 * 功能：流程标题取得
	 * 
	 * @return 流程标题
	 */
	public String getPpwprtitle() {
		return ppwprtitle;
	}
	
	/**
	 * 功能：流程标题设定
	 *
	 * @param ppwprtitle 流程标题
	 */
	public void setPpwprtitle(String ppwprtitle) {
		this.ppwprtitle = ppwprtitle;
	}
	
	/**
	 * 功能：授权人id取得
	 * 
	 * @return 授权人id
	 */
	public String getPpwauthorizeuserid() {
		return ppwauthorizeuserid;
	}
	
	/**
	 * 功能：授权人id设定
	 *
	 * @param ppwauthorizeuserid 授权人id
	 */
	public void setPpwauthorizeuserid(String ppwauthorizeuserid) {
		this.ppwauthorizeuserid = ppwauthorizeuserid;
	}
	
	/**
	 * 功能：代理人id取得
	 * 
	 * @return 代理人id
	 */
	public String getPpwproxyuserid() {
		return ppwproxyuserid;
	}
	
	/**
	 * 功能：代理人id设定
	 *
	 * @param ppwproxyuserid 代理人id
	 */
	public void setPpwproxyuserid(String ppwproxyuserid) {
		this.ppwproxyuserid = ppwproxyuserid;
	}
	
	/**
	 * 功能：代理人姓名取得
	 * 
	 * @return 代理人姓名
	 */
	public String getPpwproxyusername() {
		return ppwproxyusername;
	}
	
	/**
	 * 功能：代理人姓名设定
	 *
	 * @param ppwproxyusername 代理人姓名
	 */
	public void setPpwproxyusername(String ppwproxyusername) {
		this.ppwproxyusername = ppwproxyusername;
	}
	
	/**
	 * 功能：代理人处理时间取得
	 * 
	 * @return 代理人处理时间
	 */
	public String getPpwoptiontime() {
		return ppwoptiontime;
	}
	
	/**
	 * 功能：代理人处理时间设定
	 *
	 * @param ppwoptiontime 代理人处理时间
	 */
	public void setPpwoptiontime(String ppwoptiontime) {
		this.ppwoptiontime = ppwoptiontime;
	}
	
	/**
	 * 功能：关闭标志取得
	 * 
	 * @return 关闭标志
	 */
	public String getPpwcloseflag() {
		return ppwcloseflag;
	}
	
	/**
	 * 功能：关闭标志设定
	 *
	 * @param ppwcloseflag 关闭标志
	 */
	public void setPpwcloseflag(String ppwcloseflag) {
		this.ppwcloseflag = ppwcloseflag;
	}

	@Override
	public Serializable getPK() {
		
		return null;
	}

	/**
	 * 功能：授权人TB取得
	 * @return userTB
	 */
	public UserTB getUserTB() {
		return userTB;
	}

	/**
	 * 功能：授权人TB设置
	 * @param userTB
	 */
	public void setUserTB(UserTB userTB) {
		this.userTB = userTB;
	}
	
	

	
}
