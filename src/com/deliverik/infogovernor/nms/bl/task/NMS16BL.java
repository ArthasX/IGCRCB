/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.nms.model.NMS16Info;
import com.deliverik.infogovernor.nms.model.condition.NMS16SearchCond;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 设备组关系信息实体BL接口
 * </p>
 * 
 * @version 1.0
 */
public interface NMS16BL extends NMSBaseBL {	
	
	/**
	 * 升版处理
	 */
	public void upateVersion();
	
	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public NMS16Info searchByPK(String pk) throws BLException;
	
	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(NMS16SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<NMS16Info> search(NMS16SearchCond cond);
	
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<NMS16Info> search(NMS16SearchCond cond, int start,int count);
	
	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public NMS16Info regist(NMS16Info instance) throws BLException;
	
	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public List<NMS16Info> regist(List<NMS16Info> instances) throws BLException;
	
	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public NMS16Info update(NMS16Info instance) throws BLException;
	
	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void delete(String pk) throws BLException;
	
	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void delete(NMS16Info instance) throws BLException;
	
	/**
	 * 删除表
	 */
	public void dropTable();
	
	/**
     * 校验当前表是否存在
     * @return true 存在 false 不存在
     */
    public boolean checkTableExits();
}
