package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.CodeCategoryInfo;
import com.deliverik.framework.model.CodeDetail;

/**
 * 数据分类列表信息检索结果ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGSYM11011VO extends BaseVO implements Serializable{
	
	/** 数据分类列表信息检索结果 */
	protected List<CodeCategoryInfo> codeCategoryInfoList;
	
	/**影响程度*/
	protected List<CodeDetail> primpactList; 
	
	/**紧急程度*/
	protected List<CodeDetail> prurgencyList; 
	
	/**影响程度长度*/
	protected String primpactSize; 
	
	/**紧急程度长度*/
	protected String prurgencySize; 
	
	/**
	 * 构造函数
	 */
	public IGSYM11011VO() {
	}
	
	/**
	 * 构造函数
	 * @param entityData　数据分类列表信息检索结果
	 */
	public IGSYM11011VO(List<CodeCategoryInfo> codeCategoryInfoList) {
		this.codeCategoryInfoList = codeCategoryInfoList;
	}
	
	/**
	 * 数据分类列表信息检索结果取得
	 * @return 数据分类列表信息检索结果
	 */
	public List<CodeCategoryInfo> getCodeCategoryInfoList() {
		return codeCategoryInfoList;
	}

	public List<CodeDetail> getPrimpactList() {
		return primpactList;
	}

	public void setPrimpactList(List<CodeDetail> primpactList) {
		this.primpactList = primpactList;
	}

	public List<CodeDetail> getPrurgencyList() {
		return prurgencyList;
	}

	public void setPrurgencyList(List<CodeDetail> prurgencyList) {
		this.prurgencyList = prurgencyList;
	}

	public String getPrimpactSize() {
		return primpactSize;
	}

	public void setPrimpactSize(String primpactSize) {
		this.primpactSize = primpactSize;
	}

	public String getPrurgencySize() {
		return prurgencySize;
	}

	public void setPrurgencySize(String prurgencySize) {
		this.prurgencySize = prurgencySize;
	}

}


