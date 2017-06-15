package com.deliverik.framework.model.condition;

/**
 * 附件信息检索条件实现
 */
public class AttachmentSearchCondImpl implements AttachmentSearchCond {

	/** 附件名称 */
	protected String attname;
	
	/** 附件索引 */
	protected String attkey;

	/**
	 * 附件名称取得
	 * @return 附件名称
	 */
	public String getAttname() {
		return attname;
	}

	/**
	 * 附件名称设定
	  * @param attname 附件名称
	 */
	public void setAttname(String attname) {
		this.attname = attname;
	}
	
	/**
	 * 附件索引取得
	 * @return 附件索引
	 */
	public String getAttkey(){
		return attkey;
	}
	
	/**
	 * 附件索引设定
	  * @param attkey 附件索引
	 */
	public void setAttkey(String attkey){
		this.attkey = attkey;
	}
}
