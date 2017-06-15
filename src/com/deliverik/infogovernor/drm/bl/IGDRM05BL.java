/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.drm.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.dto.IGDRM05DTO;

/**
 * ר��Ԥ���ʲ�����BL
 * 
 * @author zyl
 *
 * 2015-2-27 09:40:00
 */

public interface IGDRM05BL extends BaseBL {


	/**
	 * ��ʼ��ר��Ԥ���ʲ�����ҳ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM05DTO init0501Action(IGDRM05DTO dto) throws BLException;
	/**
	 * ר��Ԥ�������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM05DTO getSpecialPlanMaxNumber(IGDRM05DTO dto)throws BLException;
	
	/**
	 * ��ʼ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM05DTO initNodeMap(IGDRM05DTO dto)throws BLException;
	/**
	 * ר��Ԥ���ʲ��������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM05DTO regSpecialPlanResource(IGDRM05DTO dto)throws BLException, FileNotFoundException, IOException;
	/**
	 * ר��Ԥ���ʲ���ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM05DTO searchSpeicalPlanResource(IGDRM05DTO dto)throws BLException;
	/**
	 * ר��Ԥ����Ϣɾ������
	 *
	 * @param dto IGASM05DTO
	 * @return IGASM05DTO
	 */
	public IGDRM05DTO deleteEntityItemAction(IGDRM05DTO dto) throws BLException;
	/**
	 * ר��Ԥ���ʲ�������Ϣ�༭����
	 *
	 * @param dto IGDRM05DTO
	 * @return IGDRM05DTO
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public IGDRM05DTO editEntityItemAction(IGDRM05DTO dto) throws BLException, FileNotFoundException, IOException ;
	/**
	 * ר��Ԥ���ʲ�������Ϣ�༭������ڻ�����
	 *
	 * @param dto IGDRM05DTO
	 * @return IGDRM05DTO
	 */
	public IGDRM05DTO initIGDRM0504Action(IGDRM05DTO dto) throws BLException ;
	/**
	 * ר��Ԥ��������Ϣ��ʷ��¼������ڻ�����
	 *
	 * @param dto IGDRM05DTO
	 * @return IGDRM05DTO
	 */
	public IGDRM05DTO initIGDRM0503Action(IGDRM05DTO dto) throws BLException;
	/**
	 * ������Ϣ��ʷ��¼������ڻ�����
	 *
	 * @param dto IGDRM05DTO
	 * @return IGDRM05DTO
	 */
	public IGDRM05DTO ClickVersionShow(IGDRM05DTO dto) throws BLException;
	/**
	 * �ʲ���������Ϣ�汾�Ƚϻ�����ڻ�����
	 * 
	 * @param dto
	 *            IGDRM05DTO
	 * @return IGDRM05DTO
	 * @throws BLException
	 */
	public IGDRM05DTO versionCompare(IGDRM05DTO dto) throws BLException;
	/**
	 * ר��Ԥ����ϵ��������ڻ�����
	 *
	 * @param dto IGDRM05DTO
	 * @return IGDRM05DTO
	 */
	public IGDRM05DTO initIGDRM0506Action(IGDRM05DTO dto) throws BLException ;
	
	/**
	 * ר��Ԥ����ϵɾ������
	 *
	 * @param dto IGDRM05DTO
	 * @return IGDRM05DTO
	 */
	public IGDRM05DTO deleteEntityItemRelationAction(IGDRM05DTO dto) throws BLException;

	/**
	 * ר��Ԥ����ϵ�ǼǴ���
	 *
	 * @param dto IGDRM05DTO
	 * @return IGDRM05DTO
	 */
	public IGDRM05DTO insertEntityItemRelationAction(IGDRM05DTO dto) throws BLException;
	
	/**
	 * ר��Ԥ����ϵ�༭������ڻ�����
	 *
	 * @param dto IGDRM05DTO
	 * @return IGDRM05DTO
	 */
	public IGDRM05DTO initIGDRM0507Action(IGDRM05DTO dto) throws BLException;

	/**
	 * ר��Ԥ����ϵ���������
	 *
	 * @param dto IGDRM05DTO
	 * @return IGDRM05DTO
	 */
	public IGDRM05DTO updateEntityItemRelationAction(IGDRM05DTO dto) throws BLException;
	
	/**
	 *	��ȡר��Ԥ��������ϵ����
	 *
	 * @param dto IGDRM05DTO
	 * @return IGDRM05DTO
	 */
	public IGDRM05DTO searchRelationListAction(IGDRM05DTO dto) throws BLException ;
	
	/**
	 * ��ѯ���̵���ϸ��Ϣ
	 * @param dto
	 * @return
	 */
	public IGDRM05DTO searchFlowDetail(IGDRM05DTO dto) throws BLException ;
}
