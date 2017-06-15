/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.drm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.dto.IGDRM17DTO;

/**
 * <p>
 * Title : InfoGovernor 模块名称
 * </p>
 * <p>
 * Description:培训记录处理BL接口
 * </p>
 * 
 * @author zhangbo@deliverik.com
 * @version 1.0
 */
public interface IGDRM17BL extends BaseBL {

	/**
	 * 培训记录查询操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM17DTO searchTrainAction(IGDRM17DTO dto) throws BLException;

	/**
	 * 初始化培训记录信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM17DTO initTrainRecordAction(IGDRM17DTO dto) throws BLException;

	/**
	 * 培训记录新增操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM17DTO insertTrainRecordAction(IGDRM17DTO dto) throws BLException;

	/**
	 * 培训记录修改操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM17DTO changeTrainRecordAction(IGDRM17DTO dto) throws BLException;

	/**
	 * 培训记录删除操作
	 * @param dto
	 * @throws BLException
	 */
	public IGDRM17DTO  delTrainRecordAction(IGDRM17DTO dto)throws BLException;
	
	/**
	 * 查询用户信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM17DTO searchUserRoleAction(IGDRM17DTO dto)throws BLException;
	
	/**
	 * 培训记录批量删除删除操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM17DTO deleteEntityItemAction(IGDRM17DTO dto)throws BLException;
	
}
