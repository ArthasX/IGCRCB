/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prd.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.prd.dto.IGPRD02DTO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description:���̶��幤��BL�ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IGPRD02BL extends BaseBL{

	/**
	 * �û���ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD02DTO searchUserInfoList(IGPRD02DTO dto) throws BLException;

	/**
	 * ��ʼ�����̼�����Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD02DTO initProccessDefinitionInfoAction(IGPRD02DTO dto) throws BLException;

}
