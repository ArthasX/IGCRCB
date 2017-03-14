package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0151Info;

/**
 * 检查项登录后信息ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM31021VO extends BaseVO implements Serializable{
	
	/** 检查项登录后信息 */
	protected SOC0118Info entityItemData;
	
	/**风险指标--是否关键指标下拉*/
	protected List<SOC0151Info> keyIndexList;
	
	/**风险指标--指标模板下拉*/
	protected List<SOC0151Info> titList;
	
	/**风险指标--阀值下拉*/
	protected List<SOC0151Info> thresholdList;
	
	/**风险指标属性信息集合*/
	protected List<SOC0109Info> soc0109List;
	
	/** 风险指标附件*/
	protected String attachFile;
	
	
	
	/**
	 * 构造函数
	 * @param entityData　检查项登录后信息
	 */
	public IGASM31021VO(SOC0118Info entityItemData) {
		this.entityItemData = entityItemData;
	}
	
	/**
	 * 检查项登录后信息取得
	 * @return 检查项登录后信息
	 */
	public SOC0118Info getEntityData() {
		return entityItemData;
	}

	/**
	 * 风险指标--是否关键指标下拉取得
	 * @return list集合
	 */
	public List<SOC0151Info> getKeyIndexList() {
		return keyIndexList;
	}
	/**
	 * 风险指标--是否关键指标下拉设定
	 */
	public void setKeyIndexList(List<SOC0151Info> keyIndexList) {
		this.keyIndexList = keyIndexList;
	}
	/**
	 * 风险指标--指标模板下拉取得
	 * @return list集合
	 */
	public List<SOC0151Info> getTitList() {
		return titList;
	}
	/**
	 * 风险指标--指标模板下拉设定
	 */
	public void setTitList(List<SOC0151Info> titList) {
		this.titList = titList;
	}
	/**
	 * 风险指标--阀值下拉取得
	 * @return list集合
	 */
	public List<SOC0151Info> getThresholdList() {
		return thresholdList;
	}
	/**
	 * 风险指标--阀值下拉设定
	 */
	public void setThresholdList(List<SOC0151Info> thresholdList) {
		this.thresholdList = thresholdList;
	}

	public List<SOC0109Info> getSoc0109List() {
		return soc0109List;
	}

	public void setSoc0109List(List<SOC0109Info> soc0109List) {
		this.soc0109List = soc0109List;
	}

	public String getAttachFile() {
		return attachFile;
	}

	public void setAttachFile(String attachFile) {
		this.attachFile = attachFile;
	}

	

}


