/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.wim.bl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.wim.bl.task.WorkDefinitionBL;
import com.deliverik.infogovernor.wim.dto.IGWIM01DTO;

/**
 * @Description ���������BLʵ��
 * 
 * @date 2017��6��9��16:24:25
 * 
 * @author WangLiang
 *
 */
public class IGWIM01BLImpl extends BaseBLImpl implements IGWIM01BL{
	
	static Log log = LogFactory.getLog(IGWIM01BLImpl.class);
	
	/** ���������BLע�� */
	protected WorkDefinitionBL workDefinitionBL;
	
	/**
	 * ���������BL�趨
	 * @param ���������BL
	 */
	public void setWorkDefinitionBL(WorkDefinitionBL workDefinitionBL) {
		this.workDefinitionBL = workDefinitionBL;
	}

	/**
	 * @Description ������Ǽ�
	 * @param dto IGWIM01DTO
	 * @return IGWIM01DTO
	 * @throws BLException
	 */
	public IGWIM01DTO insertWorkDefinitionAction(IGWIM01DTO dto) throws BLException {
		
		return null;
	}
}
