package com.deliverik.framework.model.condition;


/**
 * 数据分类信息查询条件实现
 * 
 */
public class CodeCategorySearchCondImpl implements CodeCategorySearchCond {

	/** 分类CD */
	protected String ccid ;
	
	/** 上级分类CD */
	protected String pccid ;
	
	/** 分类编辑标识 */
	protected String cceditable;
	
	/** 是否层次数据 */
	protected boolean tree;
	
	/**
	 * 分类CD取得
	 * @return 分类CD
	 */
	public String getCcid() {
		return ccid;
	}

	/**
	 * 分类CD设定
	 *
	 * @param ccid 分类CD
	 */
	public void setCcid(String ccid) {
		this.ccid = ccid;
	}

	/**
	 * 分类编辑标识取得
	 * @return 分类编辑标识
	 */
	public String getCceditable () {
		return cceditable;
	}

	/**
	 * 分类编辑标识设定
	 *
	 * @param cceditable 分类编辑标识
	 */
	public void setCceditable(String cceditable) {
		this.cceditable = cceditable;
	}

	/**
	 * 上级分类CD取得
	 * @return 上级分类CD
	 */
	public String getPccid() {
		return pccid;
	}

	/**
	 * 上级分类CD设定
	 *
	 * @param pccid 上级分类CD
	 */
	public void setPccid(String pccid) {
		this.pccid = pccid;
	}

	/**
	 * 是否层次数据取得
	 * @return 是否层次数据
	 */
	public boolean isTree() {
		return tree;
	}

	/**
	 * 是否层次数据设定
	 *
	 * @param tree 是否层次数据
	 */
	public void setTree(boolean tree) {
		this.tree = tree;
	}

}
