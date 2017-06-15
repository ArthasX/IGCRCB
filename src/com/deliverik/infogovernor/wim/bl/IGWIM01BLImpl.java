/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.wim.bl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.wim.bl.task.WorkDefinitionBL;
import com.deliverik.infogovernor.wim.dto.IGWIM01DTO;

/**
 * @Description 工作项管理BL实现
 * 
 * @date 2017年6月9日16:24:25
 * 
 * @author WangLiang
 *
 */
public class IGWIM01BLImpl extends BaseBLImpl implements IGWIM01BL{
	
	static Log log = LogFactory.getLog(IGWIM01BLImpl.class);
	
	/** 工作项管理BL注入 */
	protected WorkDefinitionBL workDefinitionBL;
	
	/**
	 * 工作项管理BL设定
	 * @param 工作项管理BL
	 */
	public void setWorkDefinitionBL(WorkDefinitionBL workDefinitionBL) {
		this.workDefinitionBL = workDefinitionBL;
	}

	/**
	 * @Description 工作项登记
	 * @param dto IGWIM01DTO
	 * @return IGWIM01DTO
	 * @throws BLException
	 */
	public IGWIM01DTO insertWorkDefinitionAction(IGWIM01DTO dto) throws BLException {
		
		return null;
	}
}
