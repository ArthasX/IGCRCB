/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.nms.model.condition;

/**
  * 概述: 子网区域信息检索条件接口
  * 功能描述: 子网区域信息检索条件接口
  * 创建记录: 2014/01/07
  * 修改记录: 
  */
public interface NMS17SearchCond {

    /**
     * 主键取得
     *
     * @return 主键
     */
    public String getId();

    /**
     * 所属组主键取得
     *
     * @return 所属组主键
     */
    public Integer getGid();

    /**
     * 所属组版本取得
     *
     * @return 所属组版本
     */
    public Integer getGversion();

    /**
     * 所属用户（全网时为空）取得
     *
     * @return 所属用户（全网时为空）
     */
    public String getUserid();

    /**
     * x坐标取得
     *
     * @return x坐标
     */
    public String getX();

    /**
     * y坐标取得
     *
     * @return y坐标
     */
    public String getY();

    /**
     * 宽度取得
     *
     * @return 宽度
     */
    public String getWidth();

    /**
     * 高度取得
     *
     * @return 高度
     */
    public String getHeight();

    /**
     * 获取拓扑展现类型（1：全网拓扑图2：网络设备拓扑图）
     * @return 拓扑展现类型（1：全网拓扑图2：网络设备拓扑图） 
     */
    public String getType();
}