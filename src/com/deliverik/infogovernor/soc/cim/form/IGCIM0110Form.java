/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.cim.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 配置源数据显示form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCIM0110Form extends BaseForm {

	/** 设备主键 */
	protected Integer eiid;
	
	/** 文件名字 */
	protected String host;
	
	/** 表名 */
	protected String tablename;

	/** 历史版本开始时间 */
	protected String collecttimeFrom;
	
	/** 历史版本结束时间 */
	protected String collecttimeTo;
	
	/** 是否为首次访问 */
	protected String firstAccess;
	
	/** ip */
	protected String ip;
	
	/** server类型 */
	protected String type;
	
	protected String collecttime;
	
	protected String servername;
	
	
	public String getCollecttime() {
		return collecttime;
	}

	public void setCollecttime(String collecttime) {
		this.collecttime = collecttime;
	}

	/**
	 * 设备主键取得
	 * @return 设备主键
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 设备主键设定
	 * @param eiid 设备主键
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}
	
	/**
	 * 表名取得
	 * @return 表名
	 */
	public String getTablename() {
		return tablename;
	}

	/**
	 * 表名设定
	 * @param tablenames 表名
	 */
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	/**
	 * 历史版本开始时间取得
	 * @return 历史版本开始时间
	 */
	public String getCollecttimeFrom() {
		return collecttimeFrom;
	}

	/**
	 * 历史版本开始时间设定
	 * @param vdatestart 历史版本开始时间
	 */
	public void setCollecttimeFrom(String collecttimeFrom) {
		this.collecttimeFrom = collecttimeFrom;
	}

	/**
	 * 历史版本结束时间取得
	 * @return 历史版本结束时间
	 */
	public String getCollecttimeTo() {
		return collecttimeTo;
	}

	/**
	 * 历史版本结束时间设定
	 * @param vdatestart 历史版本结束时间
	 */
	public void setCollecttimeTo(String collecttimeTo) {
		this.collecttimeTo = collecttimeTo;
	}
	
	/**
	 * 是否为首次访问取得
	 * @return 是否为首次访问
	 */
	public String getFirstAccess() {
		return firstAccess;
	}

	/**
	 * 是否为首次访问设定
	 * @param firstAccess 是否为首次访问
	 */
	public void setFirstAccess(String firstAccess) {
		this.firstAccess = firstAccess;
	}
	
	/**
	 * 重写reset方法
	 */
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		this.tablename = null;
		this.collecttimeTo = null;
		this.collecttimeFrom = null;
		this.firstAccess = null;
	}

	/**
	 * 文件名字取得
	 *
	 * @return host 文件名字
	 */
	
	public String getHost() {
		return host;
	}

	/**
	 * 文件名字设定
	 *
	 * @param host 文件名字
	 */
	
	public void setHost(String host) {
		this.host = host;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getServername() {
		return servername;
	}

	public void setServername(String servername) {
		this.servername = servername;
	}
	
}
