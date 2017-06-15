/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM11DTO;

/**
 * @Description: 机房配置管理业务逻辑接口
 * @Author  
 * @History 2009-8-18     新建
 * @Version V2.0
 */
public interface IGASM11BL extends BaseBL {


	/**
	 * 机房信息画面初期显示
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO initIGASM1101Action(IGASM11DTO dto) throws BLException;
	
	/**
	 * 机房信息登记处理
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO insertComputerRoomInfoAction(IGASM11DTO dto) throws BLException, FileNotFoundException, IOException;
	
	/**
	 * 机房信息删除处理
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO deleteComputerRoomInfoAction(IGASM11DTO dto) throws BLException;

	/**
	 * 机房信息编辑画面初期显示
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO initIGASM1102Action(IGASM11DTO dto) throws BLException;
	
	/**
	 * 机房信息变更编辑画面初期显示
	 * 
	 * @param dto
	 * @return IGASM11DTO
	 * @throws BLException
	 */
	public IGASM11DTO initEditIGASM1102Action(IGASM11DTO dto) throws BLException;
	
	/**
	 * 机房信息更新处理
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO updateComputerRoomAction(IGASM11DTO dto) throws BLException, FileNotFoundException, IOException;
	
	/**
	 * 机房平面图画面初期显示
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO initIGASM1104Action(IGASM11DTO dto) throws BLException;
	
	/**
	 * 机柜选择画面初期显示
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO initIGASM1105Action(IGASM11DTO dto) throws BLException;
	
	/**
	 * 机柜设定处理
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO setComputerContainerAction(IGASM11DTO dto) throws BLException;
	
	/**
	 * 机柜移除处理
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO moveoutComputerContainerAction(IGASM11DTO dto) throws BLException;
	
	/**
	 * 机柜列表画面初期显示
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO initIGASM1111Action(IGASM11DTO dto) throws BLException;
	
	/**
	 * 机柜信息登记处理
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO insertComputerContainerInfoAction(IGASM11DTO dto) throws BLException;
	
	/**
	 * 机柜信息编辑画面初期显示
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO initIGASM1112Action(IGASM11DTO dto) throws BLException;
	
	/**
	 * 机柜信息更新处理
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO updateComputerContainerAction(IGASM11DTO dto) throws BLException;
	
	/**
	 * 机柜信息删除处理
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO deleteComputerContainerInfoAction(IGASM11DTO dto) throws BLException;

	/**
	 * 机柜平面图画面初期显示
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO initIGASM1114Action(IGASM11DTO dto) throws BLException;
	
	/**
	 * 设备选择画面初期显示
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO initIGASM1115Action(IGASM11DTO dto) throws BLException;
	
	/**
	 * 设备设定处理
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO setComputerDeviceAction(IGASM11DTO dto) throws BLException;
	
	/**
	 * 设备移除处理
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO moveoutComputerDeviceAction(IGASM11DTO dto) throws BLException;
	
	/**
	 * 设备配置详细信息画面初期化处理
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO initIGASM1116Action(IGASM11DTO dto) throws BLException;
	
	/**
	 * 机柜信息获取机柜名
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO getContainerNameByEiid(IGASM11DTO dto) throws BLException;

	/**
	 * 机柜信息获取机房名
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO getRoomNameByEiid(IGASM11DTO dto) throws BLException;
	
	/**
	 * 取得已上架的机柜列表并组装成XML
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO getJiguiXml(IGASM11DTO dto) throws BLException;
	
	/**
	 * 取得未上架的机柜列表并组装成XML
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO getToolsXml(IGASM11DTO dto) throws BLException;
	
	/**
	 * 取得过道地板信息并组装成XML
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO getGuodaoXml(IGASM11DTO dto) throws BLException;
	
	/**
	 * 取得图例信息并组装成XML
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO getLegendXml(IGASM11DTO dto) throws BLException;
	
	/**
	 * 取得关系机房信息并组装成XML
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO getRelateRoomXml(IGASM11DTO dto) throws BLException;
	
	/**
	 * 取得无效地区信息并组装成XML
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO getWuXiaoXml(IGASM11DTO dto) throws BLException;
	
	/**
	 * 3D机房支持IP查询
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO getEquipmentAndIpAction(IGASM11DTO dto) throws BLException;
	
	/**
	 * 同步告警系统
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO getSynchronizationAlarmSystem(IGASM11DTO dto) throws BLException;
}
