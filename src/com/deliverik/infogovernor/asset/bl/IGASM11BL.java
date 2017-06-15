/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM11DTO;

/**
 * @Description: �������ù���ҵ���߼��ӿ�
 * @Author  
 * @History 2009-8-18     �½�
 * @Version V2.0
 */
public interface IGASM11BL extends BaseBL {


	/**
	 * ������Ϣ���������ʾ
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO initIGASM1101Action(IGASM11DTO dto) throws BLException;
	
	/**
	 * ������Ϣ�ǼǴ���
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO insertComputerRoomInfoAction(IGASM11DTO dto) throws BLException, FileNotFoundException, IOException;
	
	/**
	 * ������Ϣɾ������
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO deleteComputerRoomInfoAction(IGASM11DTO dto) throws BLException;

	/**
	 * ������Ϣ�༭���������ʾ
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO initIGASM1102Action(IGASM11DTO dto) throws BLException;
	
	/**
	 * ������Ϣ����༭���������ʾ
	 * 
	 * @param dto
	 * @return IGASM11DTO
	 * @throws BLException
	 */
	public IGASM11DTO initEditIGASM1102Action(IGASM11DTO dto) throws BLException;
	
	/**
	 * ������Ϣ���´���
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO updateComputerRoomAction(IGASM11DTO dto) throws BLException, FileNotFoundException, IOException;
	
	/**
	 * ����ƽ��ͼ���������ʾ
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO initIGASM1104Action(IGASM11DTO dto) throws BLException;
	
	/**
	 * ����ѡ���������ʾ
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO initIGASM1105Action(IGASM11DTO dto) throws BLException;
	
	/**
	 * �����趨����
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO setComputerContainerAction(IGASM11DTO dto) throws BLException;
	
	/**
	 * �����Ƴ�����
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO moveoutComputerContainerAction(IGASM11DTO dto) throws BLException;
	
	/**
	 * �����б��������ʾ
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO initIGASM1111Action(IGASM11DTO dto) throws BLException;
	
	/**
	 * ������Ϣ�ǼǴ���
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO insertComputerContainerInfoAction(IGASM11DTO dto) throws BLException;
	
	/**
	 * ������Ϣ�༭���������ʾ
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO initIGASM1112Action(IGASM11DTO dto) throws BLException;
	
	/**
	 * ������Ϣ���´���
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO updateComputerContainerAction(IGASM11DTO dto) throws BLException;
	
	/**
	 * ������Ϣɾ������
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO deleteComputerContainerInfoAction(IGASM11DTO dto) throws BLException;

	/**
	 * ����ƽ��ͼ���������ʾ
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO initIGASM1114Action(IGASM11DTO dto) throws BLException;
	
	/**
	 * �豸ѡ���������ʾ
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO initIGASM1115Action(IGASM11DTO dto) throws BLException;
	
	/**
	 * �豸�趨����
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO setComputerDeviceAction(IGASM11DTO dto) throws BLException;
	
	/**
	 * �豸�Ƴ�����
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO moveoutComputerDeviceAction(IGASM11DTO dto) throws BLException;
	
	/**
	 * �豸������ϸ��Ϣ������ڻ�����
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO initIGASM1116Action(IGASM11DTO dto) throws BLException;
	
	/**
	 * ������Ϣ��ȡ������
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO getContainerNameByEiid(IGASM11DTO dto) throws BLException;

	/**
	 * ������Ϣ��ȡ������
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO getRoomNameByEiid(IGASM11DTO dto) throws BLException;
	
	/**
	 * ȡ�����ϼܵĻ����б���װ��XML
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO getJiguiXml(IGASM11DTO dto) throws BLException;
	
	/**
	 * ȡ��δ�ϼܵĻ����б���װ��XML
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO getToolsXml(IGASM11DTO dto) throws BLException;
	
	/**
	 * ȡ�ù����ذ���Ϣ����װ��XML
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO getGuodaoXml(IGASM11DTO dto) throws BLException;
	
	/**
	 * ȡ��ͼ����Ϣ����װ��XML
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO getLegendXml(IGASM11DTO dto) throws BLException;
	
	/**
	 * ȡ�ù�ϵ������Ϣ����װ��XML
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO getRelateRoomXml(IGASM11DTO dto) throws BLException;
	
	/**
	 * ȡ����Ч������Ϣ����װ��XML
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO getWuXiaoXml(IGASM11DTO dto) throws BLException;
	
	/**
	 * 3D����֧��IP��ѯ
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO getEquipmentAndIpAction(IGASM11DTO dto) throws BLException;
	
	/**
	 * ͬ���澯ϵͳ
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO getSynchronizationAlarmSystem(IGASM11DTO dto) throws BLException;
}
