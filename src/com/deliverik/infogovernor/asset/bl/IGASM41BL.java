/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM41DTO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: 
 * </p>
 * 
 * @author shenbing@deliverik.com
 * @version 1.0
 */
public interface IGASM41BL extends BaseBL {
	/**
	 * ���ռ��ͳ�Ʋ�ѯ����
	 *
	 * @param dto IGASM41DTO
	 * @return IGASM41DTO
	 */
	public IGASM41DTO searchEntityItemAction(IGASM41DTO dto) throws BLException;
}
