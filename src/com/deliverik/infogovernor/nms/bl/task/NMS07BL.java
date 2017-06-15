/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.nms.model.NMS07Info;
import com.deliverik.infogovernor.nms.model.condition.NMS07SearchCond;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 链路信息实体BL接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface NMS07BL extends NMSBaseBL {
	
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
	public NMS07Info searchByPK(String pk) throws BLException;
	
	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(NMS07SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<NMS07Info> search(NMS07SearchCond cond);
	
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<NMS07Info> search(NMS07SearchCond cond, int start,int count);
	
	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public NMS07Info regist(NMS07Info instance) throws BLException;
	
	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public List<NMS07Info> regist(List<NMS07Info> instances) throws BLException;
	
	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public NMS07Info update(NMS07Info instance) throws BLException;
	
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
	public void delete(NMS07Info instance) throws BLException;
	
	/**
	 * 删除表
	 */
	public void dropTable();
}
