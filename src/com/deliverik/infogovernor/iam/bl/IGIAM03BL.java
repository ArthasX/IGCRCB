/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.iam.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.iam.dto.IGIAM03DTO;

/**
 * 概述: 审计报告逻辑业务接口
 * 功能描述：
 * 创建人：惠涌智
 * 创建记录： 2012-8-8
 * 修改记录：
 */
public interface IGIAM03BL extends BaseBL {
	/**
	 * 查询设计报告信息
	 * @param dto
	 * @return
	 */
	public IGIAM03DTO searchIAM03DTOAction(IGIAM03DTO dto) ;
	
	/**
	 * 审计报告详细信息查看
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGIAM03DTO dsearchIAMAction(IGIAM03DTO dto) throws BLException ;
	
	/**
	 * 保存审计报告
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGIAM03DTO insertIAMAction(IGIAM03DTO dto) throws BLException ;
	
	/**
	 * 删除审计报告
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGIAM03DTO deleteIAMAction(IGIAM03DTO dto) throws BLException ;
	
	/**
	 * 更新审计报告信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGIAM03DTO updateIAMAction(IGIAM03DTO dto) throws BLException ;
}	
