/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.drm.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.dto.IGDRM05DTO;

/**
 * 专项预案资产管理BL
 * 
 * @author zyl
 *
 * 2015-2-27 09:40:00
 */

public interface IGDRM05BL extends BaseBL {


	/**
	 * 初始化专项预案资产新增页面
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM05DTO init0501Action(IGDRM05DTO dto) throws BLException;
	/**
	 * 专项预案最大编号
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM05DTO getSpecialPlanMaxNumber(IGDRM05DTO dto)throws BLException;
	
	/**
	 * 初始化树
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM05DTO initNodeMap(IGDRM05DTO dto)throws BLException;
	/**
	 * 专项预案资产保存操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM05DTO regSpecialPlanResource(IGDRM05DTO dto)throws BLException, FileNotFoundException, IOException;
	/**
	 * 专项预案资产查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM05DTO searchSpeicalPlanResource(IGDRM05DTO dto)throws BLException;
	/**
	 * 专项预案信息删除处理
	 *
	 * @param dto IGASM05DTO
	 * @return IGASM05DTO
	 */
	public IGDRM05DTO deleteEntityItemAction(IGDRM05DTO dto) throws BLException;
	/**
	 * 专项预案资产配置信息编辑处理
	 *
	 * @param dto IGDRM05DTO
	 * @return IGDRM05DTO
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public IGDRM05DTO editEntityItemAction(IGDRM05DTO dto) throws BLException, FileNotFoundException, IOException ;
	/**
	 * 专项预案资产配置信息编辑画面初期化处理
	 *
	 * @param dto IGDRM05DTO
	 * @return IGDRM05DTO
	 */
	public IGDRM05DTO initIGDRM0504Action(IGDRM05DTO dto) throws BLException ;
	/**
	 * 专项预案配置信息历史记录画面初期化处理
	 *
	 * @param dto IGDRM05DTO
	 * @return IGDRM05DTO
	 */
	public IGDRM05DTO initIGDRM0503Action(IGDRM05DTO dto) throws BLException;
	/**
	 * 配置信息历史记录画面初期化处理
	 *
	 * @param dto IGDRM05DTO
	 * @return IGDRM05DTO
	 */
	public IGDRM05DTO ClickVersionShow(IGDRM05DTO dto) throws BLException;
	/**
	 * 资产配置项信息版本比较画面初期化处理
	 * 
	 * @param dto
	 *            IGDRM05DTO
	 * @return IGDRM05DTO
	 * @throws BLException
	 */
	public IGDRM05DTO versionCompare(IGDRM05DTO dto) throws BLException;
	/**
	 * 专项预案关系管理画面初期化处理
	 *
	 * @param dto IGDRM05DTO
	 * @return IGDRM05DTO
	 */
	public IGDRM05DTO initIGDRM0506Action(IGDRM05DTO dto) throws BLException ;
	
	/**
	 * 专项预案关系删除处理
	 *
	 * @param dto IGDRM05DTO
	 * @return IGDRM05DTO
	 */
	public IGDRM05DTO deleteEntityItemRelationAction(IGDRM05DTO dto) throws BLException;

	/**
	 * 专项预案关系登记处理
	 *
	 * @param dto IGDRM05DTO
	 * @return IGDRM05DTO
	 */
	public IGDRM05DTO insertEntityItemRelationAction(IGDRM05DTO dto) throws BLException;
	
	/**
	 * 专项预案关系编辑画面初期化处理
	 *
	 * @param dto IGDRM05DTO
	 * @return IGDRM05DTO
	 */
	public IGDRM05DTO initIGDRM0507Action(IGDRM05DTO dto) throws BLException;

	/**
	 * 专项预案关系变更处理处理
	 *
	 * @param dto IGDRM05DTO
	 * @return IGDRM05DTO
	 */
	public IGDRM05DTO updateEntityItemRelationAction(IGDRM05DTO dto) throws BLException;
	
	/**
	 *	获取专项预案关联关系处理
	 *
	 * @param dto IGDRM05DTO
	 * @return IGDRM05DTO
	 */
	public IGDRM05DTO searchRelationListAction(IGDRM05DTO dto) throws BLException ;
	
	/**
	 * 查询流程的详细信息
	 * @param dto
	 * @return
	 */
	public IGDRM05DTO searchFlowDetail(IGDRM05DTO dto) throws BLException ;
}
