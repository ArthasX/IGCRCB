package com.deliverik.infogovernor.drm.bl;

import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.dto.IGDRM21DTO;

/**
 * ����: 
 * ��������: 
 * ������¼: 
 * �޸ļ�¼: 
 */
public interface IGDRM21BL extends BaseBL{
	
	/**
	 * Ԥ���������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	IGDRM21DTO searchEntityItemLableAction(IGDRM21DTO dto) throws BLException ;

	/**
	 * 
	 * Ԥ����Ϣ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	IGDRM21DTO insertEntityItemAction(IGDRM21DTO dto) throws BLException;

	/**
	 * ������ʼ����Ԥ����������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	IGDRM21DTO initPlanInfo4Create(IGDRM21DTO dto)throws BLException;
	
	/**
	 * ��ѯԤ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	IGDRM21DTO getPlanSectionTree(IGDRM21DTO dto) throws BLException;

	/**
	 * ��ѯԤ����Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	IGDRM21DTO searchPlan(IGDRM21DTO dto)throws BLException;

	/**
	 * Ԥ������������Ϣ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	IGDRM21DTO savePlanInfo(IGDRM21DTO dto)throws BLException;

	/**
	 * ����Ԥ�����ı���Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	IGDRM21DTO savePlanInfoContent(IGDRM21DTO dto)throws BLException;

	/**
	 * ��ʼ�����ı���Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	IGDRM21DTO initUeditorInfo(IGDRM21DTO dto)throws BLException;

	/**
	 * ���¸��ı���Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	IGDRM21DTO updatePlanInfoContent(IGDRM21DTO dto)throws BLException;

	/**
	 * ��ʼ��������Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	IGDRM21DTO initStoryboardInfo(IGDRM21DTO dto)throws BLException;

	/**
	 * ��ѯҵ��ϵͳ��Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	IGDRM21DTO searchEntityDisp(IGDRM21DTO dto)throws BLException;

	/**
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	IGDRM21DTO viewStoryboardInfo(IGDRM21DTO dto) throws BLException;

	/**
	 * ר��Ԥ����ѯ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM21DTO searchSpecialPlanAction(IGDRM21DTO dto) throws BLException;

	/**
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	IGDRM21DTO initSoc0118EditInfo(IGDRM21DTO dto) throws BLException;

	/**
	 * �����豸��Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	IGDRM21DTO updateEntityItemAction(IGDRM21DTO dto) throws BLException;

	/**
	 * ɾ����ѡ���Ԥ����Ϣ
	 * @return
	 * @throws BLException
	 */
	IGDRM21DTO deleteSelectedSoc0118(IGDRM21DTO dto) throws BLException;

	/**
	 * ��������Ԥ����Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	IGDRM21DTO loadAllReservePlan(IGDRM21DTO dto)throws BLException;

	/**
	 * ����Ԥ�����ı�����
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	IGDRM21DTO loadPlanTextContent(IGDRM21DTO dto) throws BLException;
	
	/**
	 * ר��Ԥ����������
	 * @param dto
	 * @return
	 * @throws BLException
	 * @throws IOException 
	 */
	public IGDRM21DTO exportSpecialPlanAction(IGDRM21DTO dto) throws BLException, IOException;
	

	/**
	 * ���س�����Ϣ
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM21DTO loadPlanScenceHtml(IGDRM21DTO dto) throws BLException;

	/**
	 * ����Ԥ���е���֯�ܹ���Ϣ
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM21DTO loadPlanOrgHTML(IGDRM21DTO dto) throws BLException;

	/**
	 * ����Ԥ���е�Ӧ����Դ��Ϣ
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM21DTO loadPlanResourceHTML(IGDRM21DTO dto) throws BLException;

}
