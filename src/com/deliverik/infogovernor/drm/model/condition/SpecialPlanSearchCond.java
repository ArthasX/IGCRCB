/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.model.condition;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 专项预案查询条件接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface SpecialPlanSearchCond {

	/**
	 * 预案名称模糊匹配取得
	 * @return einame_like 预案名称模糊匹配
	 */
	public String getEiname_like();
	
	/**
	 * 业务系统ID取得
	 * @return usinessSystemId 业务系统ID
	 */
	public Integer getUsinessSystemId();
	
	/**
	 * 场景ID取得
	 * @return sceneId 场景ID
	 */
	public Integer getSceneId();
	
	/**
	 * 应急资源ID取得
	 * @return drmResourceId 应急资源ID
	 */
	public Integer getDrmResourceId();
}
