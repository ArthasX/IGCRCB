/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR13DTO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 虚机资源管理BL接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IGVIR13BL extends BaseBL{

	/**
	 * 查询vCenter信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR13DTO searchVCenterAction(IGVIR13DTO dto) throws BLException;

	/**
	 * 获取主机操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR13DTO getHostsAction(IGVIR13DTO dto) throws BLException;

	/**
	 * vm信息查询操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR13DTO searchVMInfoAction(IGVIR13DTO dto) throws BLException;

	/**
	 * 初始化虚机信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR13DTO initVmInfoAction(IGVIR13DTO dto) throws BLException;

	/**
	 * 虚机信息编辑
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR13DTO editVmInfoAction(IGVIR13DTO dto) throws BLException;
}
