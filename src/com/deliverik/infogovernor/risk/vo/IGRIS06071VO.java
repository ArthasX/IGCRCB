package com.deliverik.infogovernor.risk.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0151Info;
import com.deliverik.infogovernor.asset.model.CheckItemVWInfo;
import com.deliverik.infogovernor.risk.form.IGRIS0614Form;

public class IGRIS06071VO extends BaseVO implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	/**检查项资产查询集合*/
	private  List<CheckItemVWInfo> itemList;
	
	/**建议检查频度集合获取*/
	protected List<SOC0151Info> checkfrequencyList;
	
	/**检查项属性信息集合*/
	protected List<SOC0109Info> soc0109List;
	
	protected IGRIS0614Form igris0614form;

	/** 检查项信息集合  */	
	private List<IGRIS06141VO> checkitemInfoList;
	
	/** 检查项附件 */
	protected List<Attachment> attachmentDataList;
	
	/**
	 * igris0614form取得
	 * @return igris0614form igris0614form
	 */
	public IGRIS0614Form getIgris0614form() {
		return igris0614form;
	}

	/**
	 * igris0614form设定
	 * @param igris0614form igris0614form
	 */
	public void setIgris0614form(IGRIS0614Form igris0614form) {
		this.igris0614form = igris0614form;
	}

	/**
	 * 检查项资产查询集合取得
	 * @return itemList 检查项资产查询集合
	 */
	public List<CheckItemVWInfo> getItemList() {
		return itemList;
	}

	/**
	 * 检查项资产查询集合设定
	 * @param itemList 检查项资产查询集合
	 */
	public void setItemList(List<CheckItemVWInfo> itemList) {
		this.itemList = itemList;
	}

	/**
	 * 建议检查频度集合获取取得
	 * @return checkfrequencyList 建议检查频度集合获取
	 */
	public List<SOC0151Info> getCheckfrequencyList() {
		return checkfrequencyList;
	}

	/**
	 * 建议检查频度集合获取设定
	 * @param checkfrequencyList 建议检查频度集合获取
	 */
	public void setCheckfrequencyList(List<SOC0151Info> checkfrequencyList) {
		this.checkfrequencyList = checkfrequencyList;
	}

	/**
	 * 检查项属性信息集合取得
	 * @return soc0109List 检查项属性信息集合
	 */
	public List<SOC0109Info> getSoc0109List() {
		return soc0109List;
	}

	/**
	 * 检查项属性信息集合设定
	 * @param soc0109List 检查项属性信息集合
	 */
	public void setSoc0109List(List<SOC0109Info> soc0109List) {
		this.soc0109List = soc0109List;
	}

	/**
	 * 检查项信息集合取得
	 * @return checkitemInfoList  检查项信息集合
	 */
	public List<IGRIS06141VO> getCheckitemInfoList() {
		return checkitemInfoList;
	}

	/**
	 * 检查项信息集合设定
	 * @param checkitemInfoList  检查项信息集合
	 */
	public void setCheckitemInfoList(List<IGRIS06141VO> checkitemInfoList) {
		this.checkitemInfoList = checkitemInfoList;
	}

	/**
	 * 检查项附件取得
	 * @return attachmentDataList  检查项附件
	 */
	public List<Attachment> getAttachmentDataList() {
		return attachmentDataList;
	}

	/**
	 * 检查项附件设定
	 * @param attachmentDataList  检查项附件
	 */
	public void setAttachmentDataList(List<Attachment> attachmentDataList) {
		this.attachmentDataList = attachmentDataList;
	}


}
