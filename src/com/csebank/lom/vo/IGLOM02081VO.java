/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.csebank.lom.vo;

import java.util.List;

import com.csebank.lom.model.GoutstockVWInfo;
import com.csebank.lom.model.Gstock;
import com.deliverik.framework.base.BaseVO;

/**
 * @author duchong
 *
 */
public class IGLOM02081VO extends BaseVO {

	private static final long serialVersionUID = 1L;
	
	/** ��Ʒ��Ϣ*/
	private List<Gstock> itemsCategoryList;
	
	/** ��������Ʒ��Ϣ���� */
	private List<GoutstockVWInfo> goutstockList;
	
	

	/**
	 * @return the goutstockList
	 */
	public List<GoutstockVWInfo> getGoutstockList() {
		return goutstockList;
	}

	/**
	 * @param goutstockList the goutstockList to set
	 */
	public void setGoutstockList(List<GoutstockVWInfo> goutstockList) {
		this.goutstockList = goutstockList;
	}

	/**
	 * @return the itemsCategoryList
	 */
	public List<Gstock> getItemsCategoryList() {
		return itemsCategoryList;
	}

	/**
	 * @param itemsCategoryList the itemsCategoryList to set
	 */
	public void setItemsCategoryList(List<Gstock> itemsCategoryList) {
		this.itemsCategoryList = itemsCategoryList;
	}

	
	
}
