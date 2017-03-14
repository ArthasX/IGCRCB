package com.deliverik.framework.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
 * 数据信息主键定义
 *
 * @author 
 */
@SuppressWarnings("serial")
public class CodeDetailDefTBPK extends BasePK implements Serializable{

	/** 数据分类CD */
	protected String ccid ;
	
	/** 数据CD */
	protected String cid;

	/**
	 * 
	 */
	public CodeDetailDefTBPK(){}
	
	/**
	 * 数据信息主键定义构造函数
	 */
	public CodeDetailDefTBPK(String ccid, String cid) {
		super();
		this.ccid = ccid;
		this.cid = cid;
	}

	/**
	 * 数据分类CD取得
	 * @return 数据分类CD
	 */
	public String getCcid() {
		return ccid;
	}

	/**
	 * 数据分类CD设定
	 *
	 * @param ccid 数据分类CD
	 */
	public void setCcid(String ccid) {
		this.ccid = ccid;
	}

	/**
	 * 数据CD取得
	 * @return 数据CD
	 */
	public String getCid() {
		return cid;
	}


	/**
	 * 数据CD设定
	 *
	 * @param cid 数据CD
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}

}
