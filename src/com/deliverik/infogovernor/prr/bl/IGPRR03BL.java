/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.prr.dto.IGPRR03DTO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �Զ������̸�������bl�ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IGPRR03BL extends BaseBL{

	/**
	 * ��ɫ��Ϣ��ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR03DTO searchRoleListAction(IGPRR03DTO dto) throws BLException;

	/**
	 * ��ѯ��ɫ������Ϣ
	 * @param dto
	 * @return
	 */
	public IGPRR03DTO searchIG001InfoListAction(IGPRR03DTO dto) throws BLException;

	/**
	 * ��ɫ������Ϣɾ������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR03DTO deleteIG001Action(IGPRR03DTO dto) throws BLException;

	/**
	 * ��ɫ������Ϣ��������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR03DTO addIG001InfoAction(IGPRR03DTO dto) throws BLException;

	/**
	 * ��ѯ�û���Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR03DTO searchUserRoleAction(IGPRR03DTO dto) throws BLException;

	/**
	 * ���˽�ɫ��Ϣ��ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR03DTO searchRoleidNotInAction(IGPRR03DTO dto) throws BLException;

}
