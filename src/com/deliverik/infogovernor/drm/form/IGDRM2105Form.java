package com.deliverik.infogovernor.drm.form;

import com.deliverik.framework.base.BaseForm;

@SuppressWarnings("serial")
public class IGDRM2105Form extends BaseForm {

	/** 页面模式 */
	protected String mode = "0";
	
	/** 专项预案ID */
	protected Integer eiid;
	
	/** 预案名称 */
	protected String einame_like;
	
	/** 被删除预案ID集合 */
	protected Integer[] selectedEiids;
	
	/** 业务系统ID */
	protected Integer usinessSystemId;
	
	/*** 业务系统名称 */
	protected String usinessSystemName;
	
	/** 场景ID */
	protected Integer sceneId;
	
	/** 场景名称 */
	protected String sceneName;
	
	/** 应急资源ID */
	protected Integer drmResourceId;
	
	/** 应急资源名称 */
	protected String drmResourceName;

	/**
	 * 页面模式取得
	 * @return mode 页面模式 查询:0, 管理:1
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * 页面模式设定
	 * @param mode 页面模式 查询:0, 管理:1
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * 专项预案ID取得
	 * @return eiid 专项预案ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 专项预案ID设定
	 * @param eiid 专项预案ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * 预案名称取得
	 * @return einame_like 预案名称
	 */
	public String getEiname_like() {
		return einame_like;
	}

	/**
	 * 预案名称设定
	 * @param einame_like 预案名称
	 */
	public void setEiname_like(String einame_like) {
		this.einame_like = einame_like;
	}

	/**
	 * 被删除预案ID集合取得
	 * @return selectedEiids 被删除预案ID集合
	 */
	public Integer[] getSelectedEiids() {
		return selectedEiids;
	}

	/**
	 * 被删除预案ID集合设定
	 * @param selectedEiids 被删除预案ID集合
	 */
	public void setSelectedEiids(Integer[] selectedEiids) {
		this.selectedEiids = selectedEiids;
	}

	/**
	 * 业务系统ID取得
	 * @return usinessSystemId 业务系统ID
	 */
	public Integer getUsinessSystemId() {
		return usinessSystemId;
	}

	/**
	 * 业务系统ID设定
	 * @param usinessSystemId 业务系统ID
	 */
	public void setUsinessSystemId(Integer usinessSystemId) {
		this.usinessSystemId = usinessSystemId;
	}

	/**
	 * 业务系统名称取得
	 * @return usinessSystemName 业务系统名称
	 */
	public String getUsinessSystemName() {
		return usinessSystemName;
	}

	/**
	 * 业务系统名称设定
	 * @param usinessSystemName 业务系统名称
	 */
	public void setUsinessSystemName(String usinessSystemName) {
		this.usinessSystemName = usinessSystemName;
	}

	/**
	 * 场景ID取得
	 * @return sceneId 场景ID
	 */
	public Integer getSceneId() {
		return sceneId;
	}

	/**
	 * 场景ID设定
	 * @param sceneId 场景ID
	 */
	public void setSceneId(Integer sceneId) {
		this.sceneId = sceneId;
	}

	/**
	 * 场景名称取得
	 * @return sceneName 场景名称
	 */
	public String getSceneName() {
		return sceneName;
	}

	/**
	 * 场景名称设定
	 * @param sceneName 场景名称
	 */
	public void setSceneName(String sceneName) {
		this.sceneName = sceneName;
	}

	/**
	 * 应急资源ID取得
	 * @return drmResourceId 应急资源ID
	 */
	public Integer getDrmResourceId() {
		return drmResourceId;
	}

	/**
	 * 应急资源ID设定
	 * @param drmResourceId 应急资源ID
	 */
	public void setDrmResourceId(Integer drmResourceId) {
		this.drmResourceId = drmResourceId;
	}

	/**
	 * 应急资源名称取得
	 * @return drmResourceName 应急资源名称
	 */
	public String getDrmResourceName() {
		return drmResourceName;
	}

	/**
	 * 应急资源名称设定
	 * @param drmResourceName 应急资源名称
	 */
	public void setDrmResourceName(String drmResourceName) {
		this.drmResourceName = drmResourceName;
	}

}
