package com.deliverik.infogovernor.soc.cim.bl;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM18DTO;

public interface IGCIM18BL extends BaseBL{
	
	/**
	 * CI手动采集查询处理
	 * @param dto
	 * @return
	 */
	public IGCIM18DTO getCIHQServerList(IGCIM18DTO dto)throws Exception;
	
	/**
	 * CI手动采集启动处理
	 * @param dto
	 * @throws Exception
	 */
	public IGCIM18DTO startServer(IGCIM18DTO dto)throws Exception;
	
	
	/**
	 * CI手动采集停止处理
	 * @param dto
	 * @throws Exception
	 */
	public IGCIM18DTO stopServer(IGCIM18DTO dto)throws Exception;
	
	/**
	 * CI手动采集查询处理
	 * @param dto
	 * @throws Exception
	 */
	public IGCIM18DTO searchServer(IGCIM18DTO dto)throws Exception;
}
