/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.fxk.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.fxk.dto.IGFXK04DTO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 风险评估BL接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IGFXK04BL extends BaseBL{

	/**
	 * 模型树查询
	 * @param dto
	 * @return
	 */
	public IGFXK04DTO searchAsmModelTree(IGFXK04DTO dto) throws BLException;

	/**
	 * 风险点查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGFXK04DTO searchAsm013Action(IGFXK04DTO dto) throws BLException;

	/**
	 * 检查项查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGFXK04DTO searchAsm014Action(IGFXK04DTO dto) throws BLException;

	/**
	 * 查询相关风险清单
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGFXK04DTO getRelationProcess(IGFXK04DTO dto) throws BLException;
	
	/**
	 * 模型树查询ZTree
	 * @param dto
	 * @return
	 */
	public String searchAsmModelZTree(IGFXK04DTO dto) throws BLException;
	
}
