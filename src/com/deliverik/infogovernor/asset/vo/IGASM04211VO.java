/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;

import com.deliverik.framework.asset.model.IG499Info;
import com.deliverik.framework.base.BaseVO;

/**
 * 概述: 合同应付款登记VO
 * 功能描述: 合同应付款登记VO
 * 创建记录: 2012/04/11
 * 修改记录: 2012/11/27 LuJiayuan 增加标识判断是否显示图像按钮
 */
@SuppressWarnings("serial")
public class IGASM04211VO extends BaseVO implements Serializable {
	
	
	/** 合同信息检索结果 */
	protected IG499Info entityItemCompactVWInfo;
	
	/** 合同所属机构名称 */
	protected String eiorgname;

	/** 图像扫描XML */
	protected String picuXml;
	
	/** 图像查看XML */
	protected String picsXml;
	
	/** 开户行 */
	protected String kaihuhang;
	
	/** 开户账号 */
	protected String kaihuzhanghao;
	
	/** 开户名称 */
	protected String kaihumingcheng;
	
	/** 图像显示标识 */
	protected Boolean image_flag;
	
	/**
	 * 构造函数
	 */
	public IGASM04211VO() {
		super();
	}

	/**
	 * 合同信息检索结果取得
	 * @return 合同信息检索结果
	 */
	public IG499Info getEntityItemCompactVWInfo() {
		return entityItemCompactVWInfo;
	}

	
	/**
	 * 合同信息检索结果设定
	 * @param entityItemCompactVWInfo合同信息检索结果
	 */
	public void setEntityItemCompactVWInfo(
			IG499Info entityItemCompactVWInfo) {
		this.entityItemCompactVWInfo = entityItemCompactVWInfo;
	}




	/**
	 * 合同所属机构名称取得
	 * @return 合同所属机构名称
	 */
	public String getEiorgname() {
		return eiorgname;
	}

	/**
	 * 合同所属机构名称设定
	 * @param eiorgname合同所属机构名称
	 */
	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}

	public String getPicuXml() {
		return picuXml;
	}

	public void setPicuXml(String picuXml) {
		this.picuXml = picuXml;
	}

	public String getPicsXml() {
		return picsXml;
	}

	public void setPicsXml(String picsXml) {
		this.picsXml = picsXml;
	}

	public String getKaihuhang() {
		return kaihuhang;
	}

	public void setKaihuhang(String kaihuhang) {
		this.kaihuhang = kaihuhang;
	}

	public String getKaihuzhanghao() {
		return kaihuzhanghao;
	}

	public void setKaihuzhanghao(String kaihuzhanghao) {
		this.kaihuzhanghao = kaihuzhanghao;
	}

	public String getKaihumingcheng() {
		return kaihumingcheng;
	}

	public void setKaihumingcheng(String kaihumingcheng) {
		this.kaihumingcheng = kaihumingcheng;
	}
	
	/**
	 * 图像显示标识取得
	 *
	 * @return image_flag 图像显示标识
	 */
	public Boolean getImage_flag() {
		return image_flag;
	}
	/**
	 * 图像显示标识设定
	 *
	 * @param image_flag 图像显示标识
	 */
	public void setImage_flag(Boolean image_flag) {
		this.image_flag = image_flag;
	}
}