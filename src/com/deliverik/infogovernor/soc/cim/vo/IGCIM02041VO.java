/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0120Info;

/**
 * 资产下拉数据标识列表ＶＯ
 * 
 * @author
 * 
 */
public class IGCIM02041VO extends BaseVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 已添加资产
	 */
	private List<SOC0120Info> ownImportVersion;
	
	/**
	 * 未添加资产
	 */
	private List<SOC0120Info> otherImportVersion;
	
	
	/**
	 * 构造函数
	 * @param ownImportVersion
	 * @param otherImportVersion
	 */
	public IGCIM02041VO(List<SOC0120Info> ownImportVersion,List<SOC0120Info> otherImportVersion){
		this.otherImportVersion = otherImportVersion;
		this.ownImportVersion = ownImportVersion;
	}
	/**
	 * 已添加资产取得
	 * @return 已添加资产
	 */
	public List<SOC0120Info> getOwnImportVersion() {
		return ownImportVersion;
	}
	/**
	 * 已添加资产设定
	 * @param ownImportVersion已添加资产
	 */
	public void setOwnImportVersion(List<SOC0120Info> ownImportVersion) {
		this.ownImportVersion = ownImportVersion;
	}
	/**
	 * 未添加资产取得
	 * @return 未添加资产
	 */
	public List<SOC0120Info> getOtherImportVersion() {
		return otherImportVersion;
	}
	/**
	 * 未添加资产设定
	 * @param otherImportVersion未添加资产
	 */
	public void setOtherImportVersion(List<SOC0120Info> otherImportVersion) {
		this.otherImportVersion = otherImportVersion;
	}
	
}
