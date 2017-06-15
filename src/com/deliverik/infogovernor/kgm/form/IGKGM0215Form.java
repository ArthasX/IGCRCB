/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.kgm.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;


/**
 * 概述: 知识弹出明细页面Form
 * 功能描述：知识弹出明细页面Form
 * 创建记录：刘鹏 2010/12/10
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGKGM0215Form extends BaseForm{

	/** 知识ID */
	protected Integer knid;
	
	/** 知识明细页面返回标识 */
	protected String knflag;
	
	protected String rlcomment;
	
	/** 打开知识明细页面的流程ID */
	protected Integer prid;
	
	/** 打开知识明细页面的服务工单ID */
	protected Integer sfid;
	
	/**知识版本*/
	protected Integer knversion;
	
	/**
	 * 知识版本取得
	 * @return 知识版本
	 */
	public Integer getKnversion() {
		return knversion;
	}

	/**
	 * 知识版本设定
	 * @param knversion 知识版本
	 */
	public void setKnversion(Integer knversion) {
		this.knversion = knversion;
	}

	/**
	 * 知识ID取得
	 * @return 知识ID
	 */
	public Integer getKnid() {
		return knid;
	}

	/**
	 * 知识ID设定
	 * @param knid知识ID
	 */
	public void setKnid(Integer knid) {
		this.knid = knid;
	}

	/**
	 * 知识明细页面返回标识取得
	 * @return 知识明细页面返回标识
	 */
	public String getKnflag() {
		return knflag;
	}

	/**
	 * 知识明细页面返回标识设定
	 * @param knflag知识明细页面返回标识
	 */
	public void setKnflag(String knflag) {
		this.knflag = knflag;
	}

	/**
	 * 打开知识明细页面的流程ID取得
	 * @return 打开知识明细页面的流程ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 打开知识明细页面的流程ID设定
	 * @param prid打开知识明细页面的流程ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
	
	/**
	 * 打开知识明细页面的服务工单ID取得
	 * @return 打开知识明细页面的服务工单ID
	 */
	public Integer getSfid() {
		return sfid;
	}

	/**
	 * 打开知识明细页面的服务工单ID设定
	 * @param sfid打开知识明细页面的服务工单ID
	 */
	public void setSfid(Integer sfid) {
		this.sfid = sfid;
	}

	@Override
	public void reset(ActionMapping mapping,HttpServletRequest request){
		super.reset(mapping, request);
		this.prid = null;
		this.knid = null;
		this.sfid = null;
	}

	public String getRlcomment() {
		return rlcomment;
	}

	public void setRlcomment(String rlcomment) {
		this.rlcomment = rlcomment;
	}

}
