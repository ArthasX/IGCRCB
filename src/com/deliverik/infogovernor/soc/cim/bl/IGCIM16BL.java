package com.deliverik.infogovernor.soc.cim.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM16DTO;

public interface IGCIM16BL extends BaseBL{
	
	/**
	 * 保存密码信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM16DTO insertSoc0501Info(IGCIM16DTO dto) throws BLException;
	/**
	 * 保存密码关联关系
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM16DTO insertSoc0502Info(IGCIM16DTO dto) throws BLException;
	/**
	 * 获取密码关联关系
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM16DTO getSoc0502Info(IGCIM16DTO dto) throws BLException;
	/**
	 * 获取密码信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM16DTO getSoc0501Info(IGCIM16DTO dto) throws BLException;
	/**
	 * 密码信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM16DTO deleteSoc0501Info(IGCIM16DTO dto) throws BLException;
	/**
	 * 删除密码关联关系
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM16DTO deleteSoc0502Info(IGCIM16DTO dto) throws BLException;
	
	/**
	 * 查询设备
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM16DTO searchSoc0124List(IGCIM16DTO dto) throws BLException;
	/**
	 * 查询关联业务系统
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM16DTO searchBusiessList(IGCIM16DTO dto) throws BLException;
	
	/**
	 * 保存密码关联关系
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM16DTO insertBusiessRelation(IGCIM16DTO dto) throws BLException;
	
	/**
	 * 设备依赖关系画面初期化处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM16DTO initIGCIM1632BelongAction(IGCIM16DTO dto) throws BLException ;
	
	/**
	 * 删除关系
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM16DTO delRelation (IGCIM16DTO dto) throws BLException;
	
	/**
	 * 初始化添加密码关联关系页面数据
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM16DTO initIGCIM1632EditAction(IGCIM16DTO dto) throws BLException;
	
	/**
	 * 密码拓扑关系画面初期化处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM16DTO initIGCIM1634TopoBelongAction(IGCIM16DTO dto) throws BLException ;
	
	/**
	 * 查询设备
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM16DTO searchSoc0163List(IGCIM16DTO dto) throws BLException;
}
