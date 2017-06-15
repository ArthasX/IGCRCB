/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.sdl.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.sdl.model.condition.SdlInfoSearchCond;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务水平管理_统计查询（信息查询）Form
 * </p>
 * 
 * @author maozhipeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSDL0502Form extends BaseForm implements SdlInfoSearchCond{

	/**年度*/
	protected String year;

	/**相关资产ID*/
	protected Integer sieiid;

	/**资产名称 */
	protected String einame;
	
	/**月份*/
	protected String month;
	
	/**类别*/
	protected String sitype;
	
	/**开始时间*/
	protected String sibegin;
	
	/**结束时间*/
	protected String siend;
	
	/**信息ID*/
	protected Integer siid;
	
	public Integer getSiid() {
		return siid;
	}

	public void setSiid(Integer siid) {
		this.siid = siid;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getSitype() {
		return sitype;
	}

	public void setSitype(String sitype) {
		this.sitype = sitype;
	}

	/**
	 * 获取年度
	 * @return 年度
	 */
	public String getYear() {
		return year;
	}

	/**
	 * 设置年度
	 * @param year 年度
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * 获取相关资产名字
	 * @return 相关资产名字
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * 设置相关资产名字
	 * @param einame 相关资产名字
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	public Integer getSieiid() {
		return sieiid;
	}

	public void setSieiid(Integer sieiid) {
		this.sieiid = sieiid;
	}

	public String getSibegin() {
		return sibegin;
	}

	public void setSibegin(String sibegin) {
		this.sibegin = sibegin;
	}

	public String getSiend() {
		return siend;
	}

	public void setSiend(String siend) {
		this.siend = siend;
	}

	public String getSimark() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getSiprid() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
