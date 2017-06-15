/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

 package com.deliverik.infogovernor.rpt.model.condition;


/**
 * 
 * @Description:自动报表配置列表Cond类
 * @Author
 * @History
 * @Version V1.0
 * 修改记录：2012/08/09 将ReportConfigurationSearchCondImpl表名改为SOC0203SearchCondImpl
 */
public class SOC0203SearchCondImpl implements SOC0203SearchCond{
	/**
	 *报表文件的名称
	 */
	protected String r_path;

	/**
	 *报表文件的名称取得
	 * 
	 * @return 报表文件的名称
	 */
	public String getR_path() {
		return r_path;
	}

	/**
	 *报表文件的名称设定
	 * 
	 * @param r_path报表文件的名称
	 */
	public void setR_path(String r_path) {
		this.r_path = r_path;
	}

	/**
	 *报表文件的中文含义
	 */
	protected String r_title;

	/**
	 *报表文件的中文含义取得
	 * 
	 * @return 报表文件的中文含义
	 */
	public String getR_title() {
		return r_title;
	}

	/**
	 *报表文件的中文含义设定
	 * 
	 * @param r_title报表文件的中文含义
	 */
	public void setR_title(String r_title) {
		this.r_title = r_title;
	}

	/**
	 *报表运行时所用的参数
	 */
	protected String para;

	/**
	 *报表运行时所用的参数取得
	 * 
	 * @return 报表运行时所用的参数
	 */
	public String getPara() {
		return para;
	}

	/**
	 *报表运行时所用的参数设定
	 * 
	 * @param para报表运行时所用的参数
	 */
	public void setPara(String para) {
		this.para = para;
	}
	
	/** 数据ID */
	protected String dataid;

	/**
	 * 数据ID
	 * @return 数据ID
	 */
	public String getDataid() {
		return dataid;
	}

	/**
	 * 数据ID
	 * @param dataid数据ID
	 */
	public void setDataid(String dataid) {
		this.dataid = dataid;
	}
	
	

}

