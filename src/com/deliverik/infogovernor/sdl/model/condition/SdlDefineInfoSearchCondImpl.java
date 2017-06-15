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
 * Description: 服务管理_服务水平管理_服务水平标准查询MODEL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */
public class SdlDefineInfoSearchCondImpl implements SdlDefineInfoSearchCond {

	/**年度*/
	protected String sdiyear;

	/**相关资产ID*/
	protected Integer sdieiid;

	/**资产名称 */
	protected String sdieiname;
	
	/**
	 * 获取年度
	 * @return 年度
	 */
	public String getSdiyear() {
		return sdiyear;
	}

	/**
	 * 设置年度
	 * @param sdiyear 年度
	 */
	public void setSdiyear(String sdiyear) {
		this.sdiyear = sdiyear;
	}

	/**
	 * 获取相关资产ID
	 * @return 相关资产ID
	 */
	public Integer getSdieiid() {
		return sdieiid;
	}

	/**
	 * 设置相关资产ID
	 * @param sdieiid 相关资产ID
	 */
	public void setSdieiid(Integer sdieiid) {
		this.sdieiid = sdieiid;
	}

	/**
	 * 获取相关资产名字
	 * @return 相关资产名字
	 */
	public String getSdieiname() {
		return sdieiname;
	}

	/**
	 * 设置相关资产名字
	 * @param sdieiname 相关资产名字
	 */
	public void setSdieiname(String sdieiname) {
		this.sdieiname = sdieiname;
	}
	
}
