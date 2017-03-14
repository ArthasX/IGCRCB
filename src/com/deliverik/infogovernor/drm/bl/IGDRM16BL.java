/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.dto.IGDRM16DTO;


/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author zhangying@deliverik.com
 * @version 1.0
 */
public interface IGDRM16BL extends BaseBL {
	
	/**
     * @Description: ��ѯ�¼���������
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM16DTO    
     * @throws
     */
	public IGDRM16DTO getEventssList(IGDRM16DTO dto);
	
	
	/**
	 * @throws BLException 
     * @Description: ��ѯ��������
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM16DTO    
     * @throws
     */
	public IGDRM16DTO getList(IGDRM16DTO dto) throws BLException;
	
	/**
     * @Description: ɾ���¼�һ������
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM16DTO    
     * @throws
     */
	public IGDRM16DTO deleteEventssAction(IGDRM16DTO dto) throws BLException;
	/**
     * @Description: �����¼�һ������
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM16DTO    
     * @throws
     */
	public IGDRM16DTO insertEventssAction(IGDRM16DTO dto) throws BLException;
	/**
     * @Description:ȡ���¼�һ������
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM16DTO    
     * @throws
     */
	public IGDRM16DTO searchEventssByPK(IGDRM16DTO dto) throws BLException;
	/**
     * @Description:�޸��¼�һ������
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM16DTO    
     * @throws
     */
	public IGDRM16DTO updateEventssAction(IGDRM16DTO dto) throws BLException;

	 /**
     * @Description: �¼�Ӱ�췶Χ�Ǽ�/�޸�/ɾ��
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM06DTO    
     * @throws
     */
    public IGDRM16DTO editScopeAction(IGDRM16DTO dto)throws BLException;
    
    /**
     * @Description:�޸��¼��ȼ�
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM16DTO    
     * @throws
     */
	public IGDRM16DTO updateEventssLabelsAction(IGDRM16DTO dto) throws BLException;
	
	
	 /**
     * @Description:��ȡ�¼��ȼ����ֵ
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM16DTO    
     * @throws
     */
	public IGDRM16DTO searchMaxLabelsAction(IGDRM16DTO dto) throws BLException;
}
