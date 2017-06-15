/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.model.condition;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 专项预案查询条件实体
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class SpecialPlanSearchCondImpl implements SpecialPlanSearchCond{

	/** 预案名称模糊匹配 */
	protected String einame_like;
	
	/** 业务系统ID */
	protected Integer usinessSystemId;
	
	/** 场景ID */
	protected Integer sceneId;
	
	/** 应急资源ID */
	protected Integer drmResourceId;

	/**
	 * 预案名称模糊匹配取得
	 * @return einame_like 预案名称模糊匹配
	 */
	public String getEiname_like() {
		return einame_like;
	}

	/**
	 * 预案名称模糊匹配设定
	 * @param einame_like 预案名称模糊匹配
	 */
	public void setEiname_like(String einame_like) {
		this.einame_like = einame_like;
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

}
