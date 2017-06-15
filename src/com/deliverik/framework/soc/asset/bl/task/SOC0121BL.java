/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0121Info;
import com.deliverik.framework.soc.asset.model.SOC0132VW;
import com.deliverik.framework.soc.asset.model.SOC0133VW;
import com.deliverik.framework.soc.asset.model.condition.SOC0121SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0140VW;
import com.deliverik.framework.soc.asset.model.entity.SOC0141VW;
import com.deliverik.framework.soc.asset.model.entity.SOC0121TB;

/**
  * 概述: 快照关系表业务逻辑接口
  * 功能描述: 快照关系表业务逻辑接口
  * 创建记录: 2011/04/20
  * 修改记录：2011/7/13 增加IBM逻辑图显示 王龙宇
  * 修改记录: 
  */
public interface SOC0121BL extends BaseBL {

	/**
	 * 快照关系表实例取得
	 *
	 * @return 快照关系表实例
	 */
	public SOC0121TB getSnapshotRelationTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0121Info> searchSnapshotRelation();

	/**
	 * 主键检索处理
	 *
	 * @param pk主键
	 * @return 检索结果
	 */
	public SOC0121Info searchSnapshotRelationByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0121SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0121Info> searchSnapshotRelation(
			SOC0121SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0121Info> searchSnapshotRelation(
			SOC0121SearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance新增实例
	 * @return 新增实例
	 */
	public SOC0121Info registSnapshotRelation(SOC0121Info instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance修改实例
	 * @return 修改实例
	 */
	public SOC0121Info updateSnapshotRelation(SOC0121Info instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk主键
	 */
	public void deleteSnapshotRelationByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance删除实例
	 */
	public void deleteSnapshotRelation(SOC0121Info instance)
		throws BLException;
	
	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0141VW> searchSnapshotEntityVW(SOC0121SearchCond cond);
	
	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0140VW> searchDiskFromSnapshotEntityVW(SOC0121SearchCond cond);
	
	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<String> searchDaFromSnapshotEntityVW(SOC0121SearchCond cond);
	
	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<String> searchFaFromSnapshotEntityVW(SOC0121SearchCond cond,String strStorageEilabel);
	
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
    public List<SOC0133VW> searchSwitchZoneByCond(final SOC0121SearchCond cond);
	
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
    public List<SOC0132VW> searchSwitchPortByCond(final SOC0121SearchCond cond);	
    
    /**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0121TB> searchSwitchRelationByCond(SOC0121SearchCond cond1,SOC0121SearchCond cond2);

	/**
	 * 
	 * @Description: [通过条件关系查询faport]
	 * @author	wanglongyu@diliverik.com, 2011-7-13
	 * @param cond
	 * @param strStorageEilabel
	 * @return List<ShowEntityVW>
	 */
	public List<SOC0140VW> searchIBMFaPortFromSnapshotEntityVW(SOC0121SearchCond cond,String strStorageEilabel);
	/**
	 * 
	 * @Description: [通过条件关系查询diskserial属性]
	 * @author	wanglongyu@diliverik.com, 2011-7-13
	 * @param cond
	 * @return List<ShowEntityVW> 用于高亮显示的faport集合
	 */
	public List<SOC0140VW> searchIBMDiskSerialFromSnapshotEntityVW(SOC0121SearchCond cond);
	/**
	 * 
	 * @Description: [通过条件关系查询diskpack属性]
	 * @author	wanglongyu@diliverik.com, 2011-7-13
	 * @param cond
	 * @return List<ShowEntityVW> 用于高亮显示的disk pack集合
	 */
	public List<SOC0140VW> searchIBMDiskPackFromSnapshotEntityVW(SOC0121SearchCond cond);
	/**
	 * 
	 * @Description: [通过条件关系查询fa属性]
	 * @author	wanglongyu@diliverik.com, 2011-7-13
	 * @param cond
	 * @return List<ShowEntityVW> 用于高亮显示的fa集合
	 */
	public List<SOC0140VW> searchIBMFaFromSnapshotEntityVW(SOC0121SearchCond cond);
	/**
	 * 
	 * @Description: [通过条件关系查询da loc属性]
	 * @author	wanglongyu@diliverik.com, 2011-7-13
	 * @param cond
	 * @return List<ShowEntityVW> 用于高亮显示的da loc集合
	 */
	public List<SOC0140VW> searchIBMDaLocFromSnapshotEntityVW(SOC0121SearchCond cond);
	/**
	 * 
	 * @Description: [通过条件关系查询da pair属性]
	 * @author	wanglongyu@diliverik.com, 2011-7-13
	 * @param cond
	 * @return List<ShowEntityVW> 用于高亮显示的da pair集合
	 */
	public List<SOC0140VW> searchIBMDaPairFromSnapshotEntityVW(SOC0121SearchCond cond);
	/**
	 * 
	 * @Description: [通过条件关系查询da interface属性]
	 * @author	wanglongyu@diliverik.com, 2011-7-13
	 * @param cond
	 * @return List<ShowEntityVW> 用于高亮显示的da interface集合
	 */
	public List<SOC0140VW> searchIBMDaInterfaceFromSnapshotEntityVW(SOC0121SearchCond cond);

	/**
	 * 出图用拓扑关系
	 * @return
	 */
	public List<SOC0121Info> searchShowStorageIOSnapshotRelation();
	
}