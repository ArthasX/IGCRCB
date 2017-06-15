/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.model;

import com.deliverik.framework.base.BaseModel;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 用户拓扑视图信息实体接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface NMS09Info extends BaseModel {
	
	/**
	 * 主键取得
	 * @return id 主键
	 */
	public Integer getId();

	/**
	 * 组ID取得
	 * @return gid 组ID
	 */
	public Integer getGid();

	/**
	 * 组版本取得
	 * @return gversion 组版本
	 */
	public Integer getGversion();

	/**
	 * 用户ID取得
	 * @return userid 用户ID
	 */
	public String getUserid();

	/**
	 * 拓扑图取得
	 * @return xml 拓扑图
	 */
	public String getXml();

	/**
     * 获取面板宽度
     * @return 面板宽度 
     */
    public String getWidth() ;

    /**
     * 获取面板高度
     * @return 面板高度 
     */
    public String getHeight();
    
	/**
	 * 创建时间取得
	 * @return instime 创建时间
	 */
	public String getInstime();
	
	/**
     * 获取拓扑展现类型（1：全网拓扑图2：网络设备拓扑图）
     * @return 拓扑展现类型（1：全网拓扑图2：网络设备拓扑图） 
     */
    public String getShowtype();
}
