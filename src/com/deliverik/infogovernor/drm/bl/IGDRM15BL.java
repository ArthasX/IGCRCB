/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.dto.IGDRM15DTO;

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
public interface IGDRM15BL extends BaseBL {
	
	/**
     * @Description: ��ѯ��ѵ�ƻ���������
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM15DTO    
     * @throws
     */
	public IGDRM15DTO searchTrainplanList(IGDRM15DTO dto);
	
	
	/**
	 * @throws BLException 
     * @Description: ��ѯ��ѵ�ƻ�����ѵ������������
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM15DTO    
     * @throws
     */
//	public IGDRM15DTO getList(IGDRM15DTO dto) throws BLException;
	
	/**
     * @Description: ɾ����ѵ�ƻ�һ������
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM15DTO    
     * @throws
     */
	public IGDRM15DTO deleteTrainplanAction(IGDRM15DTO dto) throws BLException;
	/**
     * @Description: ������ѵ�ƻ�һ������
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM15DTO    
     * @throws
     */
	public IGDRM15DTO insertTrainplanAction(IGDRM15DTO dto) throws BLException;
	/**
     * @Description:ȡ����ѵ�ƻ�һ������
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM15DTO    
     * @throws
     */
	public IGDRM15DTO updateTrainPlanMission(IGDRM15DTO dto) throws BLException;
	/**
     * @Description:������ѵ�ƻ�һ������
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM15DTO    
     * @throws
     */
	//public IGDRM15DTO updateTrainplanAction(IGDRM15DTO dto) throws BLException;

	 /**
     * @Description: ��ѵ�ƻ��Ǽ�/�޸�/ɾ��
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM06DTO    
     * @throws
     */
  //  public IGDRM15DTO editTrainmissionAction(IGDRM15DTO dto)throws BLException;
	
	/**
     * @Description: ��ѵ�ƻ��Ǽ�/�޸�/ɾ��
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM06DTO    
     * @throws
     */
    public IGDRM15DTO searchTrainPlanMissionAction(IGDRM15DTO dto)throws BLException;
	
    
    /**
     * ������ѵ�ƻ�
     * @param igdrm15dto IGDRM15DTO 
     */
    public IGDRM15DTO createTrainingPlan(IGDRM15DTO dto) throws BLException ;

    /**
	 * ��ѵ�ƻ�����ɾ������
	 * @param dto IGDRM15DTO
	 * @return IGDRM15DTO
	 */
	public IGDRM15DTO deleteEntityItemAction(IGDRM15DTO dto) throws BLException;
}
