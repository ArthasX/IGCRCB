package com.deliverik.infogovernor.soc.cim.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM20DTO;

/**
 * 网络管理BL
 * @author Administrator
 *
 */
public interface IGCIM20BL {
	
	/**
	 * 获取设备编号最大值
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM20DTO searchEntityItemLableAction(IGCIM20DTO dto) throws BLException ;
	
	/**
	 * 设备信息登记处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM20DTO insertEntityItemAction(IGCIM20DTO dto) throws BLException;
	/**
	 * 设备配置信息编辑画面初期化处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM20DTO initIGCIM2002Action(IGCIM20DTO dto) throws BLException ;
	
	/**
	 * 设备配置信息编辑处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public IGCIM20DTO editEntityItemAction(IGCIM20DTO dto) throws BLException,FileNotFoundException,IOException;
	
	/**
	 * 判断登陆用户是否是设备资产管理角色负责人
	 * 
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 * @throws BLException 
	 */
	public IGCIM20DTO checkEntityItemDomain(IGCIM20DTO dto) throws BLException;
	
	/**
	 * 设备信息删除处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM20DTO deleteEntityItemAction(IGCIM20DTO dto) throws BLException;
	
	/**
	 * 设备信息查询处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM20DTO searchEntityItemAction(IGCIM20DTO dto) throws BLException;
	
	/**
	 *	获取应用关联关系处理
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM20DTO searchRelationListActionApp(IGCIM20DTO dto) throws BLException;
	
	/**
	 * 应用关系登记处理
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM20DTO insertEntityItemRelationActionApp(IGCIM20DTO dto) throws BLException ;
	
	/**
	 * 应用关系变更处理处理
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM20DTO updateEntityItemRelationActionApp(IGCIM20DTO dto) throws BLException;
	
	/**
	 * 应用关系编辑画面初期化处理
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM20DTO initIGCIM2006Action(IGCIM20DTO dto) throws BLException;
	
	/**
	 * 应用关系管理画面初期化处理
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM20DTO initIGCIM2005Action(IGCIM20DTO dto) throws BLException ;
	
	/**
	 * 应用关系删除处理
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM20DTO deleteEntityItemRelationActionApp(IGCIM20DTO dto) throws BLException;

	/**
	 * 网络设备升级大版本
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM20DTO updateVersion(IGCIM20DTO dto) throws BLException;
}
