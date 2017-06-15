/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prd.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.prd.dto.IGPRD10DTO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̶���BL�ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IGPRD10BL extends BaseBL{

	/**
	 * ���̶�����Ϣ��ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD10DTO searchLastProcessDefinitionAction(IGPRD10DTO dto) throws BLException;

	/**
	 * �������̶�����Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD10DTO initProcessDefinitionAction(IGPRD10DTO dto) throws BLException;

	/**
	 * �������̶������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD10DTO changeProcessDefinitionAction(IGPRD10DTO dto) throws BLException;

	/**
	 * ȡ�ýڵ㰴ť��Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD10DTO searchProcessStepButtonAction(IGPRD10DTO dto) throws BLException;

}
