/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.fxk.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description:  页面显示
 * </p>
 * 2014-6-19
 * @author zhangq@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGFXK07011VO extends BaseVO implements Serializable{
	
	/** 风险提示相关信息集合 */
    protected List<IGFXK07012VO> voList;
    
    /**风险提示单条相关信息集合*/
    protected IGFXK07012VO igfxk07012vo;

	/**
	 * 风险提示单条相关信息集合取得
	 * @return igfxk07012vo 风险提示单条相关信息集合
	 */
	public IGFXK07012VO getIgfxk07012vo() {
		return igfxk07012vo;
	}

	/**
	 * 风险提示单条相关信息集合设定
	 * @param igfxk07012vo 风险提示单条相关信息集合
	 */
	public void setIgfxk07012vo(IGFXK07012VO igfxk07012vo) {
		this.igfxk07012vo = igfxk07012vo;
	}

	/**
	 * 风险提示相关信息集合取得
	 * @return voList 风险提示相关信息集合
	 */
	public List<IGFXK07012VO> getVoList() {
		return voList;
	}

	/**
	 * 风险提示相关信息集合设定
	 * @param voList 风险提示相关信息集合
	 */
	public void setVoList(List<IGFXK07012VO> voList) {
		this.voList = voList;
	}
}
