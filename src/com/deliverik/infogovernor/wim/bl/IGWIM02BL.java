/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.wim.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.wim.dto.IGWIM02DTO;

/**
 * @Description 工作管理BL接口
 * 
 * @date 2017年6月14日13:51:16
 * 
 * @author zyl
 *
 */
public interface IGWIM02BL extends BaseBL{

	/**
	 * @Description 工作查询，通过工作时间，从而获取所在的周，展示一周的工作
	 * @param dto IGWIM02DTO
	 * @return IGWIM02DTO
	 * @throws BLException
	 */
	public IGWIM02DTO getCurrentWorkByDateAction(IGWIM02DTO dto) throws BLException ;
	/**
	 * @Description 获取中心部门
	 * @param dto IGWIM02DTO
	 * @return IGWIM02DTO
	 * @throws BLException
	 * @author zyl
	 */
	public IGWIM02DTO getCenterOrgAction(IGWIM02DTO dto) throws BLException ;
	/**
	 * @Description 获取中心部门下的人
	 * 格式：List<Map<orgid,orgid>,Map<orgname,orgname>,Map<username,username>,Map<userid,userid>>
	 * @param dto IGWIM02DTO
	 * @return IGWIM02DTO
	 * @throws BLException
	 * @author zyl
	 */
	public IGWIM02DTO getCenterOrgUserAction(IGWIM02DTO dto) throws BLException;
	/**
	 * @Description 周期工作确认处理初始化
	 * @param dto IGWIM02DTO
	 * @return IGWIM02DTO
	 * @throws BLException
	 * @author zyl
	 */
	public IGWIM02DTO confirmCycleWorkInit(IGWIM02DTO dto) throws BLException ;
	/**
	 * @Description 周期工作确认处理
	 * @param dto IGWIM02DTO
	 * @return IGWIM02DTO
	 * @throws BLException
	 * @author zyl
	 */
	public IGWIM02DTO confirmCycleWork(IGWIM02DTO dto) throws BLException ;
	/**
	 * @Description 当天工作确认处理初始化
	 * @param dto IGWIM02DTO
	 * @return IGWIM02DTO
	 * @throws BLException
	 * @author zyl
	 * @modifier WangLiang
	 * @modifyContent 工作定义加入了超时停止处理时间（天），确认初始化时需要将系统日期和超时停止处理时间作比较，若已超时则不允许执行人确认/保存工作
	 */
	public IGWIM02DTO confirmTodayWorkInit(IGWIM02DTO dto) throws BLException ;
	/**
	 * @Description 当天工作确认处理
	 * @param dto IGWIM02DTO
	 * @return IGWIM02DTO
	 * @throws BLException
	 * @author zyl
	 */
	public IGWIM02DTO confirmTodayWork(IGWIM02DTO dto) throws BLException;
	
	/**
	 * @Description 工作信息统计查询
	 * @param dto IGWIM02DTO
	 * @return IGWIM02DTO
	 * @throws BLException
	 * @author songzhihui
	 */
	public IGWIM02DTO countSearch(IGWIM02DTO dto) throws BLException;
	
	/**
	 * @Description 工作信息统计查询导出
	 * @param dto IGWIM02DTO
	 * @return IGWIM02DTO
	 * @throws BLException
	 * @author songzhihui
	 */
	public IGWIM02DTO searchExport(IGWIM02DTO dto) throws BLException;
	
	/**
	 * @Description 首页工作查看
	 * @param dto IGWIM02DTO
	 * @return IGWIM02DTO
	 * @throws BLException
	 * @author zyl
	 */
	public IGWIM02DTO findTodayWorkByCondForFirstPage(IGWIM02DTO dto) throws BLException;
	/**
	 * 查询当前工作已经用时多久了，所有日志里填的处理时间之和
	 * @param cond 只用到了实例id-wiid
	 * @return
	 */
	public IGWIM02DTO getTotalExcuteTime(IGWIM02DTO dto);
	/**
	 * 查询当前登录用户权限（1、科技部领导（总经理），2、中心负责人，3、普通用户）
	 * @param cond 只用到了实例id-wiid
	 * @return
	 */
	public IGWIM02DTO getPermissionByUser(IGWIM02DTO dto);
	
}
