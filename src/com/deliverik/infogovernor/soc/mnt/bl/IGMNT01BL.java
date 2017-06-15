/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.soc.mnt.bl;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.mnt.dto.IGMNT01DTO;
import com.deliverik.infogovernor.soc.mnt.model.MonitorTypeInfo;
import com.deliverik.infogovernor.soc.mnt.model.SOC0301Info;
/**
 * 概述:监控管理业务接口
 * 功能描述：
 * 创建记录：张楠    2012/02/09
 */
public interface IGMNT01BL extends BaseBL{

	
	/**
	 * 监控类型树查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO searchMonitorTypeTreeAction(IGMNT01DTO dto) throws BLException;
	
	/**
	 * 监控类型阀值查询
	 */
	public IGMNT01DTO searchMonitorTypeDefAction(IGMNT01DTO dto) throws BLException;

	/**
	 * 监控类型阀值修改
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public void updateMonitorTypeDefAction(IGMNT01DTO dto) throws BLException;

	/**
	 * 监控类型查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO searchMonitorTypeAction(IGMNT01DTO dto) throws BLException;

	/**
	 * 监控对象登记
	 * @param dto
	 * @throws BLException
	 */
	public IGMNT01DTO insertMonitorObject(IGMNT01DTO dto) throws BLException;

	/**
	 * 监控对象查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO searchMonitorObjectAction(IGMNT01DTO dto) throws BLException;

	/**
	 * 监控对象主键查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO searchMonitorObjectByPKAction(IGMNT01DTO dto) throws BLException;

	/**
	 * 监控对象阀值信息查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO searchMonitorObjectDefAction(IGMNT01DTO dto) throws BLException;

	/**
	 * 监控对象修改
	 * @param dto
	 * @throws BLException
	 */
	public void updateMonitorObjectAction(IGMNT01DTO dto) throws BLException;

	/**
	 * 监控对象状态修改
	 * @param dto
	 * @throws BLException
	 */
	public void updateMonitorObjectStatusAction(IGMNT01DTO dto) throws BLException;

	/**
	 * 监控对象名称查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO searchMoNameAction(IGMNT01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * 查询资产模型名称
	 * </p>
	 * 
	 * @param dto IGMNT01DTO
	 * @return IGMNT01DTO
	 * @throws BLException
	 */
	public IGMNT01DTO searchEntityNameAction(IGMNT01DTO dto) throws BLException;
	
	/**
	 * 资产项信息查询
	 *
	 * @param dto IGMNT01DTO
	 * @return IGMNT01DTO
	 */
	public IGMNT01DTO searchEntityItemAction(IGMNT01DTO dto) throws BLException;

	/**
	 * 主键检索监控类型
	 * @param dto
	 * @return
	 */
	public MonitorTypeInfo searchMonitorTypeByPK(IGMNT01DTO dto) throws BLException;

	/**
	 * 存储登记处理
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO insertSymmInfoAction(IGMNT01DTO dto) throws BLException;

	/**
	 * 存储CodeDetail表信息添加处理
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO insertCodeDetailInfoAction(IGMNT01DTO dto) throws BLException;

	/**
	 * 获取该存储类型的报表
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO searchCodeDetailListActioin(IGMNT01DTO dto) throws BLException;

	/**
	 * 自动报表添加处理
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO registSOC0203Action(IGMNT01DTO dto) throws BLException;

	/**
	 * 普通报表添加处理
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO registReportFileDefinitionAction(IGMNT01DTO dto) throws BLException;

	/**
	 * 存储其它信息删除处理
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO deleteSymmOtherInfoAction(IGMNT01DTO dto) throws BLException;

	/**
	 * 存储删除处理
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO deleteSymmInfoAction(IGMNT01DTO dto) throws BLException;

	/**
	 * 删除监控对象
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO deleteMonitorObject(IGMNT01DTO dto) throws BLException;

	/**
	 * 资产类型层次码检索
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO searchEsyscodingAction(IGMNT01DTO dto) throws BLException;

	/**
	 * 检索存储基本信息实体表
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO searchCollect_Symmetrix_Info(IGMNT01DTO dto) throws BLException;
	
	/**
	 * 查询debug监控初始化信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO searchDebugTaskInitAction(IGMNT01DTO dto) throws BLException;
	/**
	 * 开始执行监控任务
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO insertDebugTaskAction(IGMNT01DTO dto) throws BLException;
	
	/**
	 * 生成一个解析bat,并调用
	*/
	public void createParseBat(String mtId) ;
	
	/**
	 * 生成一个模拟bat,并调用
	*/
	public void createBat(String mtSSn,String mtId,String mtCname,String mtKpi,Integer mtInterval,Integer mtNum) ;

	/**
	 * 取得实时性能集合
	 * @param mtId
	 * @return
	 * @throws BLException
	 */
	public Map<String, List<SOC0301Info>> getDataMap(int mtId) throws BLException;

	/**
	 * 更新容量阈值
	 * @param dto
	 * @throws BLException
	 */
	public void updateCapacityObject(IGMNT01DTO dto) throws BLException;

}
