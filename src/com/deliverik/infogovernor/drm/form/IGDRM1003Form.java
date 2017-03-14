package com.deliverik.infogovernor.drm.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 数据分类列表画面FORM
 *  
 */
@SuppressWarnings("serial")
public class IGDRM1003Form extends BaseForm{

	/** 数据分类CD */
	protected String ccid ;
	
	/** 数据分类名 */
	protected String ccname ;
	
	/** 数据分类说明 */
	protected String ccinfo ;
	
	/** 数据分类编辑标识 */
	protected String cceditable ;
	
	/** 数据分类的上级数据分类ID（树形基础数据用） */
	protected String pccid ;
	
	/** 树形基础数据支持最大级别 */
	protected String pcflag ;
	
	
	
	public String getCcname() {
		return ccname;
	}

	public void setCcname(String ccname) {
		this.ccname = ccname;
	}

	public String getCcinfo() {
		return ccinfo;
	}

	public void setCcinfo(String ccinfo) {
		this.ccinfo = ccinfo;
	}

	public String getCceditable() {
		return cceditable;
	}

	public void setCceditable(String cceditable) {
		this.cceditable = cceditable;
	}

	public String getPccid() {
		return pccid;
	}

	public void setPccid(String pccid) {
		this.pccid = pccid;
	}

	public String getPcflag() {
		return pcflag;
	}

	public void setPcflag(String pcflag) {
		this.pcflag = pcflag;
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

}
