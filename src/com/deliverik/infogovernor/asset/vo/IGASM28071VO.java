package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0151Info;
import com.deliverik.infogovernor.asset.form.IGASM2814Form;
import com.deliverik.infogovernor.asset.model.CheckItemVWInfo;

public class IGASM28071VO extends BaseVO implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	/**检查项资产查询集合*/
	private  List<CheckItemVWInfo> itemList;
	
	/**建议检查频度集合获取*/
	protected List<SOC0151Info> checkfrequencyList;
	
	/**检查项属性信息集合*/
	protected List<SOC0109Info> soc0109List;
	
	protected IGASM2814Form igasm2814form;

	/**
	 * igasm2814form取得
	 * @return igasm2814form igasm2814form
	 */
	public IGASM2814Form getIgasm2814form() {
		return igasm2814form;
	}

	/**
	 * igasm2814form设定
	 * @param igasm2814form igasm2814form
	 */
	public void setIgasm2814form(IGASM2814Form igasm2814form) {
		this.igasm2814form = igasm2814form;
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


}
