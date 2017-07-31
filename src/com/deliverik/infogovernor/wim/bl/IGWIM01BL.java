/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.wim.bl;

import java.text.ParseException;

import org.springframework.beans.BeansException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.wim.dto.IGWIM01DTO;

/**
 * @Description ���������BL�ӿ�
 * 
 * @date 2017��6��9��16:12:59
 * 
 * @author WangLiang
 *
 */
public interface IGWIM01BL extends BaseBL{

	/**
	 * @Description �������Ǽ�
	 * @param dto IGWIM01DTO
	 * @return IGWIM01DTO
	 * @throws BLException
	 */
	public IGWIM01DTO registerWorkDefinitionAction(IGWIM01DTO dto) throws BLException;
	
	/**
	 * @Description ���������
	 * @param dto IGWIM01DTO
	 * @return IGWIM01DTO
	 * @throws BLException
	 */
	public IGWIM01DTO updateWorkDefinitionAction(IGWIM01DTO dto) throws BLException;
	
	/**
	 * @Description ������������ʼ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGWIM01DTO workDefinitionInitAction(IGWIM01DTO dto) throws BLException;
	
	/**
	 * @Description ����ʵ����ʱ�������/����
	 * @param dto IGWIM01DTO ���� WorkDefinitionInfo��Ϣ��addOrRemoveFlag�������ʱ�������/�Ƴ���ʶaddOrRemoveFlag
	 * @return IGWIM01DTO
	 * @throws BLException
	 */
	public IGWIM01DTO jobManageAction(IGWIM01DTO dto) throws BLException;
	
	/**
	 * @Description �������ѯ
	 * @param dto
	 * @return IGWIM01DTO
	 * @throws BLException
	 */
	public IGWIM01DTO searchWorkDefinition(IGWIM01DTO dto) throws BLException;
	
	/**
	 * @Description ��������Ϣɾ������
	 * @param dto IGWIM01DTO
	 * @return IGRIS06DTO
	 * @throws BLException
	 */
	public IGWIM01DTO deleteWorkDefinitoinAction(IGWIM01DTO dto) throws BLException;
	
	/**
	 * @Description ������״̬�޸�
	 * @param dto IGWIM01DTO
	 * @return IGWIM01DTO
	 * @throws BLException
	 */
	public IGWIM01DTO updateWorkDefinitionStatusAction(IGWIM01DTO dto) throws BLException, BeansException, ParseException;
	
	/**
	 * @Description ������ʵ��
	 * @param dto IGWIM01DTO
	 * @return IGWIM01DTO
	 * @throws BLException
	 */
	public IGWIM01DTO registerWorkInstanceAction(IGWIM01DTO dto) throws BLException;
	
	/**
	 * @Description ����������־
	 * @param dto IGWIM01DTO
	 * @return IGWIM01DTO
	 * @throws BLException
	 */
	public IGWIM01DTO registerWorkLogAction(IGWIM01DTO dto) throws BLException;
	
	/**
	 * @Description ���������ݵ���
	 * @param dto IGWIM01DTO
	 * @return IGWIM01DTO
	 * @throws BLException
	 */
	public IGWIM01DTO importData(IGWIM01DTO dto) throws BLException;
	
	/**
	 * @Description ��ѯ�û��Ƿ������ĸ��������ϸ�λ
	 * @param dto IGWIM01DTO userid:�û�id
	 * @return IGWIM01DTO
	 */
	public IGWIM01DTO searchIsLeader(IGWIM01DTO dto) throws BLException;
}
