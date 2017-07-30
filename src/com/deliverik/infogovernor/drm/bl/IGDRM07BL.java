/*
 * ���������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.drm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.dto.IGDRM07DTO;

/**
 * ����BL 
 * 2015��3��6��09:14:09
 */

public interface IGDRM07BL extends BaseBL {
	   /**
     * @Description: ������������ڵ�������ʾ 
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM07DTO    
     * @throws
     */
	public IGDRM07DTO initIGDRM0701DefAction(IGDRM07DTO dto)throws BLException;
	/**
	 * @Description: ����ʵʩ�ڵ�������ʾ 
	 * @param dto
	 * @return
	 * @throws BLException    
	 * IGDRM07DTO    
	 * @throws
	 */
	public IGDRM07DTO initIGDRM0701ImplAction(IGDRM07DTO dto)throws BLException;
	/**
	 * �ʲ�����Ϣnew��ѯ
	 * 
	 * @param dto
	 *            IGDRM07DTO
	 * @return IGASM03DTO
	 */
	public IGDRM07DTO searchEntityItem0702Action(IGDRM07DTO dto) throws BLException;
	/**
	 * <p> ��ѯ�ʲ�ģ������ </p>
	 * 
	 * @param dto
	 *            IGDRM07DTO
	 * @return IGDRM07DTO
	 * @throws BLException
	 */

	public IGDRM07DTO searchEntityNameActionSOC(IGDRM07DTO dto) throws BLException;
	/**
	 * ������ϵ�ʲ�����Ϣ��ѯ
	 * 
	 * @param dto
	 *            IGDRM07DTO
	 * @return IGDRM07DTO
	 */
	public IGDRM07DTO searchEntityItemRelation(IGDRM07DTO dto) throws BLException;
	
	/**
	 * @Description: ����ʵʩ�ڵ�������ʾ 
	 * @param dto
	 * @return
	 * @throws BLException    
	 * IGDRM07DTO    
	 * @throws
	 */
	public IGDRM07DTO searchProcess(IGDRM07DTO dto)throws BLException;
	/**
	 * @Description: ȫ��������ѯ
	 * @param dto
	 * @return
	 * @throws BLException    
	 * IGDRM07DTO    
	 * @throws
	 */
	public IGDRM07DTO initIGDRM0701ALLProcessAction(IGDRM07DTO dto)throws BLException;
	
	/**
	 * ��ȡ�ʲ���ϸ��Ϣ
	 * �������ʲ�����
	 * 
	 * @param dto    IGDRM07DTO
	 * @return IGDRM07DTO
	 */
	public IGDRM07DTO getEntityFullInfo(IGDRM07DTO dto) throws BLException;
	
	/**
	 * �ʲ�����Ϣ��ѯ,����ҳ
	 *
	 * @param dto IGCOM03DTO
	 * @return IGCOM03DTO
	 */
	public IGDRM07DTO searchEntityItemActionNoPage(IGDRM07DTO dto) throws BLException;
	
	/** ��ѯ�����������̽ڵ����������Ϣ */
	public IGDRM07DTO searchProcessDefineUser(IGDRM07DTO dto) throws BLException;
	/** ��ѯ��֯�ܹ��µĽ�ɫ���� */
	public IGDRM07DTO searchRoleAndUser(IGDRM07DTO dto) throws BLException;
	/**��ѯ����������Ϣ*/
	public IGDRM07DTO searchDrillDetail(IGDRM07DTO dto,String flowType) throws BLException;
	
	/**
	 * ������������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM07DTO exportDrillDetail(IGDRM07DTO dto) throws BLException;
	
	  /**
     *����prid��ѯ����ʵ�� 
     * @param dto
     * @return
     * @throws BLException 
     */
    public IGDRM07DTO searchDrillByPrid(IGDRM07DTO dto) throws BLException;
}