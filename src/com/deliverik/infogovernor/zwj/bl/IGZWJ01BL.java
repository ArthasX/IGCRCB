/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.zwj.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.zwj.dto.IGZWJ01DTO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �侯��Ժ�������BL�ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IGZWJ01BL extends BaseBL{

	public IGZWJ01DTO searchOrgnameAction(IGZWJ01DTO dto) throws BLException;
	
	public IGZWJ01DTO searchUserInfoAction(IGZWJ01DTO dto) throws BLException;
}
