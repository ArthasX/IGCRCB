/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.svc.bl;


import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.svc.dto.IGSVC01DTO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̹���_����̨ҵ���߼��ӿ�
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public interface IGSVC01BL extends BaseBL {
	
	/**
	 * <p>
	 * �ҵķ��𣬻�ȡ�û������δ�رյ�����
	 * </p>
	 * 
	 * @param dto
	 * @return IGSVC01DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */
	
	public IGSVC01DTO getWorkInitByMe(IGSVC01DTO dto) throws BLException;
	/**
	 * <p>
	 * �ҵķ��𣬻�ȡ�û��������������
	 * </p>
	 * @param dto
	 * @return IGSVC01DTO
	 * @throws BLException
	 */
	public IGSVC01DTO getWorkInitByMeForAll(IGSVC01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * ��ط��𣬻�ȡ�û�������Ľ�ɫ�����δ�رյ�����
	 * </p>
	 * 
	 * @param dto
	 * @return IGSVC01DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */
	
	public IGSVC01DTO getWorkInitByMyManyRole(IGSVC01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * ��ع�������ȡָ���û�������Ľ�ɫ�����δ�رյ�����
	 * </p>
	 * 
	 * @param dto
	 * @return IGSVC01DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */
	
	public IGSVC01DTO getWorkAssignedToMyManyRole(IGSVC01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * �ҵĹ�������ȡָ���û������δ�رյ�����
	 * </p>
	 * 
	 * @param dto
	 * @return IGSVC01DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */
	
	public IGSVC01DTO getWorkAssignedToMe(IGSVC01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * �����ල����ȡ����δ�رյ�����
	 * </p>
	 * 
	 * @param dto
	 * @return IGSVC01DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */
	
	public IGSVC01DTO getAllActiveProcessRecords(IGSVC01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * ��ѯ���̼�¼
	 * </p>
	 * 
	 * @param dto
	 * @return IGSVC01DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */
	
	public IGSVC01DTO getProcessRecords(IGSVC01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * ��ѯ���̼�¼
	 * </p>
	 * 
	 * @param dto
	 * @return IGSVC01DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */
	
	public IGSVC01DTO getProcessRecordsForLook(IGSVC01DTO dto) throws BLException;

	
	/**
	 * <p>
	 * ��ѯ��ʷ����
	 * </p>
	 * 
	 * @param dto
	 * @return IGSVC01DTO
	 * @throws BLException
	 * @author zhaojun@deliverik.com
	 */
	
	public IGSVC01DTO getDoneProcessRecordsForLook(IGSVC01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * ��ѯ���̼�¼(֪ʶ���ʹ��)
	 * </p>
	 * 
	 * @param dto
	 * @return IGSVC01DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */
	
	public IGSVC01DTO getProcessRecordsForKGM(IGSVC01DTO dto) throws BLException;

	/**
	 * ��ֹ������ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSVC01DTO getDiscontinueWork(IGSVC01DTO dto) throws BLException;
	
	public IGSVC01DTO getPrtypeList(IGSVC01DTO dto);
}
