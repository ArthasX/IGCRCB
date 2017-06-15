package com.deliverik.infogovernor.soc.vir.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR06DTO;

/**
 * 设备配置管理业务逻辑接口
 *
 * 
 */
public interface IGVIR06BL extends BaseBL {

	/**
	 * 阜新拓扑，虚拟化管理关系树
	 * @param dto
	 * @return
	 */
	public IGVIR06DTO getVMWareTree(IGVIR06DTO dto) throws BLException;
	/**
	 * 虚拟化分析信息编辑画面初期化处理
	 *
	 * @param dto 
	 * @return 
	 */
	public IGVIR06DTO initIGVIR0602Action(IGVIR06DTO dto) throws BLException;
	
	/**
	 * 应用配置信息编辑处理
	 *
	 * @param dto 
	 * @return 
	 */
	public IGVIR06DTO editEntityItemActionApp(IGVIR06DTO dto) throws BLException,
	FileNotFoundException, IOException;
	
	/**
	 * 判断登陆用户是否是设备资产管理角色负责人
	 * 
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 * @throws BLException 
	 */
	public IGVIR06DTO checkEntityItemDomain(IGVIR06DTO dto) throws BLException;
	
	/**
	 * 0604设备信息查询处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGVIR06DTO searchEntityItem0604Action(IGVIR06DTO dto) throws BLException;
	
	/**
	 * 0606设备信息查询处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGVIR06DTO searchEntityItem0606Action(IGVIR06DTO dto) throws BLException;
	
	/**
	 * 0605设备信息查询处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGVIR06DTO searchEntityItem0605Action(IGVIR06DTO dto) throws BLException;

}
