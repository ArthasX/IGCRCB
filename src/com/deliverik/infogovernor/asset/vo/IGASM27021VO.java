package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0151Info;

/**
 * 风险点登录后信息ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM27021VO extends BaseVO implements Serializable{
	
	/** 风险点登录后信息 */
	protected SOC0118Info entityItemData;
	/**风险严重等级集合获取*/
	protected List<SOC0151Info> gradeList;
	
	/**风险级别集合获取*/
	protected List<SOC0151Info> levelList;
	
	/**风险点可能性*/
	protected List<SOC0151Info> possibleList;
	/**风险标识集合*/
	protected List<SOC0151Info> signList;
	
	/**检查项属性信息集合*/
	protected List<SOC0109Info> soc0109List;
	
	/**
	 * 检查项属性信息集合取得
	 * @return soc0109List 检查项属性信息集合
	 */
	public List<SOC0109Info> getSoc0109List() {
		return soc0109List;
	}

	/**
	 * 检查项属性信息集合设定
	 * @param soc0109List 检查项属性信息集合
	 */
	public void setSoc0109List(List<SOC0109Info> soc0109List) {
		this.soc0109List = soc0109List;
	}

	/**
	 * 风险严重等级集合获取取得
	 * @return gradeList 风险严重等级集合获取
	 */
	public List<SOC0151Info> getGradeList() {
		return gradeList;
	}

	/**
	 * 风险严重等级集合获取设定
	 * @param gradeList 风险严重等级集合获取
	 */
	public void setGradeList(List<SOC0151Info> gradeList) {
		this.gradeList = gradeList;
	}

	/**
	 * 风险级别集合获取取得
	 * @return levelList 风险级别集合获取
	 */
	public List<SOC0151Info> getLevelList() {
		return levelList;
	}

	/**
	 * 风险级别集合获取设定
	 * @param levelList 风险级别集合获取
	 */
	public void setLevelList(List<SOC0151Info> levelList) {
		this.levelList = levelList;
	}

	/**
	 * 风险点可能性取得
	 * @return possibleList 风险点可能性
	 */
	public List<SOC0151Info> getPossibleList() {
		return possibleList;
	}

	/**
	 * 风险点可能性设定
	 * @param possibleList 风险点可能性
	 */
	public void setPossibleList(List<SOC0151Info> possibleList) {
		this.possibleList = possibleList;
	}

	/**
	 * 风险标识集合取得
	 * @return signList 风险标识集合
	 */
	public List<SOC0151Info> getSignList() {
		return signList;
	}

	/**
	 * 风险标识集合设定
	 * @param signList 风险标识集合
	 */
	public void setSignList(List<SOC0151Info> signList) {
		this.signList = signList;
	}


	
	/**
	 * 构造函数
	 * @param entityData　风险点登录后信息
	 */
	public IGASM27021VO(SOC0118Info entityItemData) {
		this.entityItemData = entityItemData;
	}
	
	/**
	 * 风险点登录后信息取得
	 * @return 风险点登录后信息
	 */
	public SOC0118Info getEntityData() {
		return entityItemData;
	}
}


