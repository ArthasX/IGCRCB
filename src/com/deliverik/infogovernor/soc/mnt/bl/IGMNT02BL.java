/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.soc.mnt.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.mnt.dto.IGMNT02DTO;
/**
 * ����:������ع���ӿ�
 * ����������
 * ������¼��
 */
public interface IGMNT02BL extends BaseBL{
	/**
	 * ��������list��ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT02DTO searchSOC0423Action(IGMNT02DTO dto) throws BLException;
	
	/**
	 * ��������ɾ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT02DTO deleteSOC0423Action(IGMNT02DTO dto) throws BLException;
	/**
	 * �����������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT02DTO updateSOC0423Action(IGMNT02DTO dto) throws BLException;
	/**
	 * ���������ع��� ��ȡhostlist for select
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT02DTO initHostListSelectAction(IGMNT02DTO dto) throws BLException;
    /**
     * <p>
	 * Description: ������־��ѯ
	 * </p>
     * @param dto
     * @return IGMNT02DTO
     * @throws BLException
	 * @update
     */
	public IGMNT02DTO searchSOC0305Action(IGMNT02DTO dto) throws BLException;

	public IGMNT02DTO getEiImportProgrammeAction(IGMNT02DTO dto) throws BLException;

	public IGMNT02DTO searchSOC0305ByCond(IGMNT02DTO dto) throws BLException;
	
	public IGMNT02DTO updateSOC0305(IGMNT02DTO dto) throws BLException;

	public IGMNT02DTO getAlarmSeverity(IGMNT02DTO dto) throws BLException;

	public IGMNT02DTO getCiList(IGMNT02DTO dto) throws BLException;
	/**
	 * ��ѯ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT02DTO searchSOC0306Action(IGMNT02DTO dto) throws BLException;
	
	/**
	 * �������ڲ�ѯ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT02DTO popSOC0306Action(IGMNT02DTO dto) throws BLException ;
}
