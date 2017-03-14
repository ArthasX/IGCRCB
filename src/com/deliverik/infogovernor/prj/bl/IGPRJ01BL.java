/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.prj.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.prj.dto.IGPRJ01DTO;

public interface IGPRJ01BL {
	
	public IGPRJ01DTO insertEntityAction(IGPRJ01DTO dto) throws BLException;
	
	public IGPRJ01DTO findProjectByCond(IGPRJ01DTO dto) throws BLException;
	
	public IGPRJ01DTO findProjectById(IGPRJ01DTO dto) throws BLException;
	
	public IGPRJ01DTO insertProjectLog(IGPRJ01DTO dto) throws BLException;
	
	public IGPRJ01DTO closeProject(IGPRJ01DTO dto) throws BLException;
	
	public IGPRJ01DTO findAllProject(IGPRJ01DTO dto) throws BLException;
	
	public IGPRJ01DTO getPrincipal(IGPRJ01DTO dto) throws BLException;//������
	
	public IGPRJ01DTO removePrincipal(IGPRJ01DTO dto) throws BLException;
	
	public IGPRJ01DTO addPrincipal(IGPRJ01DTO dto) throws BLException;
	
	public IGPRJ01DTO getParticipant(IGPRJ01DTO dto) throws BLException;//������
	
	/**
	 * ������Ŀ���ͱ��룬������Ŀ��������
	 */
	public IGPRJ01DTO findProjectTypeAction(IGPRJ01DTO dto);
	
	public IGPRJ01DTO removeParticipant(IGPRJ01DTO dto) throws BLException;
	
	public IGPRJ01DTO addParticipant(IGPRJ01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: �����־�����ʾ
	 * </p>
	 */
	public IGPRJ01DTO findProjectLogType(IGPRJ01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ������־�����ϸ��Ϣ��ʾ
	 * </p>
	 */
	public IGPRJ01DTO searchProjectLogTypeMessage(IGPRJ01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ��Ŀɾ������
	 * </p>
	 */
	public IGPRJ01DTO removeProject(IGPRJ01DTO dto) throws BLException;
	
	/**
	 * ��Ŀ������Ϣ�޸�
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRJ01DTO updateProject(IGPRJ01DTO dto)throws BLException;
	
	/**
	 * ��Ŀ������Ϣ��ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRJ01DTO selectProject(IGPRJ01DTO dto) throws BLException ;
	
	/**
	 * Ͷ��ʹ�������������ѯ
	 * @param dto
	 * @return
	 */
	public IGPRJ01DTO exportSearchAction(IGPRJ01DTO dto);
	
	/***
	 * Ͷ����ʹ�ú�ͬ��ϸ��������ѯ
	 * @param dto
	 * @return
	 */
	public IGPRJ01DTO exportSearchInvestCaAction(IGPRJ01DTO dto);
	
}
