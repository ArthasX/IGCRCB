package com.deliverik.infogovernor.crc.model.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.crc.dto.IGCRC02DTO;
import com.deliverik.infogovernor.crc.model.IgalarmInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 告警信息查询VO
 * </p>
 * 
 * @author changhao@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGCRC0203VO extends BaseVO {
	
	/***
	 * 告警信息列表
	 */
	private List<IgalarmInfo> igalarmInfos;
	
	/** 告警信息  */	
	private IgalarmInfo igalarmInfo;
	
	/** 主机名称排序状态码(1为降序 2为升序) */
	private String appnamestatus;
	
	/** ip地址排序状态码(1为降序 2为升序) */
	private String ipaddrstatus;
	
	/** 触发时间排序状态码(1为降序 2为升序) */
	private String lasttimestatus;
	
	/** 恢复时间排序状态码(1为降序 2为升序) */
	private String recoverytimestatus;
	
	
	/***
	 * 告警信息VO初始化
	 */
	public IGCRC0203VO(IGCRC02DTO dto){
		igalarmInfos = dto.getIgalarmInfos();
	}

	public IGCRC0203VO() {
		super();
	}

	/**
	 * 告警信息获取
	 * @return 告警信息列表
	 */
	public List<IgalarmInfo> getIgalarmInfos() {
		return igalarmInfos;
	}

	/**
	 * 告警信息设置
	 * @param igalarmInfos 告警信息列表
	 */
	public void setIgalarmInfos(List<IgalarmInfo> igalarmInfos) {
		this.igalarmInfos = igalarmInfos;
	}

	/**
	 * 告警信息取得
	 * @return igalarmInfo  告警信息
	 */
	public IgalarmInfo getIgalarmInfo() {
		return igalarmInfo;
	}

	/**
	 * 告警信息设定
	 * @param igalarmInfo  告警信息
	 */
	public void setIgalarmInfo(IgalarmInfo igalarmInfo) {
		this.igalarmInfo = igalarmInfo;
	}

	/**
	 * 主机名称排序状态码(1为降序 2为升序)取得
	 * 
	 * @return 主机名称排序状态码
	 */
	public String getAppnamestatus() {
		return appnamestatus;
	}

	/**
	 * 主机名称排序状态码(1为降序 2为升序)设置
	 * 
	 * @param 主机名称排序状态码
	 */
	public void setAppnamestatus(String appnamestatus) {
		this.appnamestatus = appnamestatus;
	}

	/**
	 * ip地址排序状态码(1为降序 2为升序)取得
	 * 
	 * @return ip地址排序状态码(1为降序 2为升序)
	 */
	public String getIpaddrstatus() {
		return ipaddrstatus;
	}

	/**
	 * ip地址排序状态码(1为降序 2为升序)设置
	 * 
	 * @param  ip地址排序状态码(1为降序 2为升序)
	 */
	public void setIpaddrstatus(String ipaddrstatus) {
		this.ipaddrstatus = ipaddrstatus;
	}

	/**
	 * 触发时间排序状态码(1为降序 2为升序)取得
	 * 
	 * @return 触发时间排序状态码(1为降序 2为升序)
	 */
	public String getLasttimestatus() {
		return lasttimestatus;
	}

	/**
	 * 触发时间排序状态码(1为降序 2为升序)设置
	 * 
	 * @param 触发时间排序状态码(1为降序 2为升序)
	 */
	public void setLasttimestatus(String lasttimestatus) {
		this.lasttimestatus = lasttimestatus;
	}

	/**
	 * 恢复时间排序状态码(1为降序 2为升序)取得
	 * 
	 * @return 恢复时间排序状态码(1为降序 2为升序)
	 */
	public String getRecoverytimestatus() {
		return recoverytimestatus;
	}

	/**
	 * 恢复时间排序状态码(1为降序 2为升序)设置
	 * 
	 * @param 恢复时间排序状态码(1为降序 2为升序)
	 */
	public void setRecoverytimestatus(String recoverytimestatus) {
		this.recoverytimestatus = recoverytimestatus;
	}

	
	
	
	
	
}
