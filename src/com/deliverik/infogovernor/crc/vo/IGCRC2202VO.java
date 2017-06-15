/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.crc.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;


/**	
 * 概述: 变更统计页面显示列
 * 创建记录：yukexin    2014-8-20 10:12:18
 * 修改记录：null
 */	
public class IGCRC2202VO extends BaseVO implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 主键 */
	private String typeId;
	
	/** 分类名 */
	private String typeName;

	/** 总数 */
	private Integer totalnum;

	/** 评审通过数量 */
	private Integer passnum;

	/** 评审通过率 */
	private String passrate;

	/** 成功数量 */
	private Integer successnum;

	/** 成功率 */
	private String successrate;

	/**
	 * 主键取得
	 * @return typeId  主键
	 */
	public String getTypeId() {
		return typeId;
	}
	public IGCRC2202VO() {
		super();
	}

	public IGCRC2202VO(String typeId, String typeName, Integer totalnum,
			Integer passnum, String passrate, Integer successnum,
			String successrate) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
		this.totalnum = totalnum;
		this.passnum = passnum;
		this.passrate = passrate;
		this.successnum = successnum;
		this.successrate = successrate;
	}
	
	/**
	 * 主键设定
	 * @param typeId  主键
	 */
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	/**
	 * 分类名取得
	 * @return typeName  分类名
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * 分类名设定
	 * @param typeName  分类名
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/**
	 * 总数取得
	 * @return totalnum  总数
	 */
	public Integer getTotalnum() {
		return totalnum;
	}

	/**
	 * 总数设定
	 * @param totalnum  总数
	 */
	public void setTotalnum(Integer totalnum) {
		this.totalnum = totalnum;
	}

	/**
	 * 评审通过数量取得
	 * @return passnum  评审通过数量
	 */
	public Integer getPassnum() {
		return passnum;
	}

	/**
	 * 评审通过数量设定
	 * @param passnum  评审通过数量
	 */
	public void setPassnum(Integer passnum) {
		this.passnum = passnum;
	}

	/**
	 * 评审通过率取得
	 * @return passrate  评审通过率
	 */
	public String getPassrate() {
		return passrate;
	}

	/**
	 * 评审通过率设定
	 * @param passrate  评审通过率
	 */
	public void setPassrate(String passrate) {
		this.passrate = passrate;
	}

	/**
	 * 成功数量取得
	 * @return successnum  成功数量
	 */
	public Integer getSuccessnum() {
		return successnum;
	}

	/**
	 * 成功数量设定
	 * @param successnum  成功数量
	 */
	public void setSuccessnum(Integer successnum) {
		this.successnum = successnum;
	}

	/**
	 * 成功率取得
	 * @return successrate  成功率
	 */
	public String getSuccessrate() {
		return successrate;
	}

	/**
	 * 成功率设定
	 * @param successrate  成功率
	 */
	public void setSuccessrate(String successrate) {
		this.successrate = successrate;
	}

}
