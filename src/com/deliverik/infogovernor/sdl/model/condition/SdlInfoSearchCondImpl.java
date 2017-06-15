/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sdl.model.condition;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务水平管理_服务水平信息查询MODEL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class SdlInfoSearchCondImpl implements SdlInfoSearchCond {

	/**类别*/
	protected String sitype;

	/**开始时间*/
	protected String sibegin;
	
	/**结束时间*/
	protected String siend;

	/**相关资产ID*/
	protected Integer sieiid;

	/**相关流程ID*/
	protected Integer siprid;
	
	/**评分*/
	protected String simark;

	/**
	 * 获取类别
	 * 
	 * @return 类别
	 */
	public String getSitype() {
		return sitype;
	}

	/**
	 * 设置类别
	 * @param sitype 类别
	 */
	public void setSitype(String sitype) {
		this.sitype = sitype;
	}

	/**
	 * 获取开始时间
	 * 
	 * @return 开始时间
	 */
	public String getSibegin() {
		return sibegin;
	}

	/**
	 * 设置开始时间
	 * @param sibegin 开始时间
	 */
	public void setSibegin(String sibegin) {
		this.sibegin = sibegin;
	}

	/**
	 * 获取结束时间
	 * 
	 * @return 结束时间
	 */
	public String getSiend() {
		return siend;
	}

	/**
	 * 设置结束时间
	 * @param siend 结束时间
	 */
	public void setSiend(String siend) {
		this.siend = siend;
	}

	/**
	 * 获取相关资产ID
	 * 
	 * @return 相关资产ID
	 */
	public Integer getSieiid() {
		return sieiid;
	}

	/**
	 * 设置相关资产ID
	 * @param sieiid 相关资产ID
	 */
	public void setSieiid(Integer sieiid) {
		this.sieiid = sieiid;
	}

	/**
	 * 获取相关流程ID
	 * 
	 * @return 相关流程ID
	 */
	public Integer getSiprid() {
		return siprid;
	}

	/**
	 * 设置相关流程ID
	 * @param siprid 相关流程ID
	 */
	public void setSiprid(Integer siprid) {
		this.siprid = siprid;
	}

	/**
	 * 获取评分
	 * 
	 * @return 评分
	 */
	public String getSimark() {
		return simark;
	}

	/**
	 * 设置评分
	 * @param simark 评分
	 */
	public void setSimark(String simark) {
		this.simark = simark;
	}
	
}
