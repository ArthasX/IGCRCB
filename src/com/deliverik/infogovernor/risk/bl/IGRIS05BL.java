/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.risk.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.risk.dto.IGRIS05DTO;
/**
 * @Description: ��������ѯ
 * @Author  
 * @20140709     �½� 
 * @Version V1.0
 */
public interface IGRIS05BL extends BaseBL {

	/**������ⱨ���ѯ*/
	public IGRIS05DTO searchRiskCount(IGRIS05DTO dto) throws BLException;
}
