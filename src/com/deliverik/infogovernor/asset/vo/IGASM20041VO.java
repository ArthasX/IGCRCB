/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.ImportVersionInfo;
import com.deliverik.framework.base.BaseVO;

/**
 * 资产下拉数据标识列表ＶＯ
 * 
 * @author
 * 
 */
public class IGASM20041VO extends BaseVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 已添加资产
	 */
	private List<ImportVersionInfo> ownImportVersion;
	
	/**
	 * 未添加资产
	 */
	private List<ImportVersionInfo> otherImportVersion;
	
	
	/**
	 * 构造函数
	 * @param ownImportVersion
	 * @param otherImportVersion
	 */
	public IGASM20041VO(List<ImportVersionInfo> ownImportVersion,List<ImportVersionInfo> otherImportVersion){
		this.otherImportVersion = otherImportVersion;
		this.ownImportVersion = ownImportVersion;
	}
	/**
	 * 已添加资产取得
	 * @return 已添加资产
	 */
	public List<ImportVersionInfo> getOwnImportVersion() {
		return ownImportVersion;
	}
	/**
	 * 已添加资产设定
	 * @param ownImportVersion已添加资产
	 */
	public void setOwnImportVersion(List<ImportVersionInfo> ownImportVersion) {
		this.ownImportVersion = ownImportVersion;
	}
	/**
	 * 未添加资产取得
	 * @return 未添加资产
	 */
	public List<ImportVersionInfo> getOtherImportVersion() {
		return otherImportVersion;
	}
	/**
	 * 未添加资产设定
	 * @param otherImportVersion未添加资产
	 */
	public void setOtherImportVersion(List<ImportVersionInfo> otherImportVersion) {
		this.otherImportVersion = otherImportVersion;
	}
	
}
