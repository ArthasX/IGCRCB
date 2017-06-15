/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prd.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.prd.dto.IGPRD03DTO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description:�����鶨�幤��BL�ӿ�
 * </p>
 * 
 * @version 1.0
 */
public interface IGPRD03BL extends BaseBL{

	
	/**
	 * ��ѯ�����鶨��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	
	public IGPRD03DTO searchProcessGroupDefinition(IGPRD03DTO dto) throws BLException;
	
	/**
	 * ����������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD03DTO upgradeProcessGroupDefinition(IGPRD03DTO dto)throws BLException;
	
	/**
	 * ���������鶨��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD03DTO regProcessGroupDefinition(IGPRD03DTO dto)throws BLException;
	
	/**
	 * ������༭ҳ���ʼ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD03DTO initPGDforEdit(IGPRD03DTO dto)throws BLException;
	
	/**
	 * ������������̶���ҳ���ʼ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD03DTO initPGDRelition(IGPRD03DTO dto)throws BLException;
	
	/**
	 * ����������ڳ�Ա���̶���
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD03DTO addMember(IGPRD03DTO dto)throws BLException;
	
	/**
	 * ɾ���������ڳ�Ա���̶���
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD03DTO delMember(IGPRD03DTO dto)throws BLException;
	
	/**
	 * �޸�������״̬
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD03DTO changeStatus(IGPRD03DTO dto) throws BLException;
	
	/**
	 * �����鷢��
	 * @param dto IGPRD03DTO
	 * @return IGPRD03DTO
	 * @throws BLException
	 */
	public IGPRD03DTO LaunchAction(IGPRD03DTO dto) throws BLException;

    /** 
     * @Title: flexUploadFile 
     * @Description:  flex����������ʽ�ϴ������߼� 
     * @param dto    
     * void    
     * @throws 
     */
    public void flexUploadFile(IGPRD03DTO dto)throws Exception;
}
