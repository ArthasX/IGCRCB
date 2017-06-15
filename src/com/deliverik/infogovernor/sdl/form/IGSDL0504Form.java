/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.sdl.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.sdl.model.condition.SdlYearSummarySearchCond;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务水平管理_统计查询Form
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSDL0504Form extends BaseForm implements SdlYearSummarySearchCond{

	/**年度*/
	protected String year;

	/**相关资产ID*/
	protected Integer eiid;

	/**资产名称 */
	protected String einame;
	
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
	 * 获取相关资产ID
	 * @return 相关资产ID
	 */
	public Integer getEiid() {
		if(eiid != null && eiid != 0){
			return eiid;
		}else{
			return null;
		}
	}

	/**
	 * 设置相关资产ID
	 * @param eiid 相关资产ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
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
	
}
