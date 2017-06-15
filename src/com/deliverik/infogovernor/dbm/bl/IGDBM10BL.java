/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.dbm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dbm.dto.IGDBM10DTO;

/**
 * @概述锦州银行渠道业务实时情况首页BL
 * @功能描述 1.渠道业务实时情况         
 *			2.db2信息        
 *			3.备份情况及HCAMP状态         
 *			4.cpu占用率TOP5
 *			5.Omnibus事件警告
 * @创建记录：李旭峙    2010/12/01
 * @version 1.0
 */

public interface IGDBM10BL extends BaseBL {

	/**
	 * 功能: 渠道业务实时情况
	 * @param  IGDBM10DTO dto
	 * @return 渠道业务实时数据
	 * @throws BLException
	 */
	public IGDBM10DTO getChannelsBusinessRealtime(IGDBM10DTO dto) throws BLException;
	
	/**
	 * 功能: db2信息
	 * @param  IGDBM10DTO dto
	 * @return db2信息数据
	 * @throws BLException
	 */
	public IGDBM10DTO getDB2Information(IGDBM10DTO dto) throws BLException;
	
	/**
	 * 功能: 备份情况及HCAMP状态
	 * @param  IGDBM10DTO dto
	 * @return 备份情况及HCAMP状态值
	 * @throws BLException
	 */
	public IGDBM10DTO getBackupAndHCAMPType(IGDBM10DTO dto) throws BLException;
	
	/**
	 * 功能:cpu占用率TOP5
	 * @param  IGDBM10DTO dto
	 * @return cpu占用率TOP5值
	 * @throws BLException
	 */
	public IGDBM10DTO getCPUOccupancyrateTOP5(IGDBM10DTO dto) throws BLException;
	
	/**
	 * 功能: Omnibus事件警告
	 * @param  IGDBM10DTO dto
	 * @return Omnibus事件警告值
	 * @throws BLException
	 */
	public IGDBM10DTO getOmnibusEventWarning(IGDBM10DTO dto) throws BLException;
}
