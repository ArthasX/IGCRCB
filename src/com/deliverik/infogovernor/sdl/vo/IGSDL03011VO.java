/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sdl.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.sdl.model.SdlDefineInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务水平管理_标准VO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSDL03011VO extends BaseVO implements Serializable {
	
	/**标准信息List*/
	protected List<SdlDefineInfo> sdlDefineInfoList;
	
	/**
	 * 获取标准信息List
	 * @return List<SdlDefineInfo>
	 */
	
	public List<SdlDefineInfo> getSdlDefineInfoList() {
		return sdlDefineInfoList;
	}
	/**
	 * 构造函数
	 * @param  
	 *
	 */
	public IGSDL03011VO() {
	}
	/**
	 * 构造函数
	 * @param sdlDefineInfoList List<SdlDefineInfo>
	 */
	public IGSDL03011VO(List<SdlDefineInfo> sdlDefineInfoList) {
		this.sdlDefineInfoList = sdlDefineInfoList;
	}
}
