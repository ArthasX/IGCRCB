/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dut.dto.IGDUT04DTO;

/**
 * 延时解锁BL
 */
public interface IGDUT04BL extends BaseBL {

	/**
	 * 延时解锁登记
	 * @param dto
	 * @return
	 */
	public IGDUT04DTO insertEntityAction(IGDUT04DTO dto) throws BLException;

	/**
	 * 条件检索延时解锁信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDUT04DTO searchDelayByCond(IGDUT04DTO dto) throws BLException;

	/**
	 * 延时解锁变更初期显示处理
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDUT04DTO initDelayAudit(IGDUT04DTO dto) throws BLException;

	/**
	 * 延时解锁变更处理
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDUT04DTO updateDelayAuditAction(IGDUT04DTO dto) throws BLException;

	/**
	 * 延时解锁删除处理
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDUT04DTO deleteDelayAction(IGDUT04DTO dto) throws BLException;

	/**
	 * 取得申请标题下拉列表项
	 * @return
	 */
	public IGDUT04DTO getTitle(IGDUT04DTO dto) throws BLException;
}
