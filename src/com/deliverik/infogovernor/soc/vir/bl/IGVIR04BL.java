/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR04DTO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 虚拟资源回收申请BL接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IGVIR04BL extends BaseBL{

	/**
	 * 获取VM信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR04DTO getApplyVMInfAction(IGVIR04DTO dto) throws BLException;

	/**
	 * 保存回收虚机信息操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR04DTO saveRecycleVMInfoAction(IGVIR04DTO dto) throws BLException;

	/**
	 * 查询待回收虚拟资源
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR04DTO getRecycleVMInfAction(IGVIR04DTO dto) throws BLException;

	/**
	 * 取得回收进度
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR04DTO getProgressAction(IGVIR04DTO dto) throws BLException;

}
