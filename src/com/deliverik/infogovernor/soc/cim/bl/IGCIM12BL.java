package com.deliverik.infogovernor.soc.cim.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM12DTO;

/**
 * 基础数据管理业务逻辑接口
 *
 * 
 */
public interface IGCIM12BL extends BaseBL {


	/**
	 * <p>
	 * 查询entity树
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	public IGCIM12DTO searchEntityTreeAction(IGCIM12DTO dto) throws BLException;
	
	
	/**
	 * 资产属性历史版本信息显示处理
	 * @param dto
	 * @return
	 * @throws BLException
	 * @author wangxing
	 */
	public IGCIM12DTO initIGCIM1203Action(IGCIM12DTO dto) throws BLException;

	/**
	 * 资产属性版本比较处理
	 * @param dto
	 * @return
	 * @throws BLException
	 * @author wangxing
	 */
	public IGCIM12DTO initIGCIM1204Action(IGCIM12DTO dto)throws BLException;
	
}
