/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.drm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.dto.IGDRM06DTO;

/**
 * �����ƻ�BL 
 * 2015-2-12 ����11:02:20
 */

public interface IGDRM06BL extends BaseBL {
    /**
     * @Description: �����ƻ���ʾ 
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM06DTO    
     * @throws
     */
    public IGDRM06DTO initIGDRM0601Action(IGDRM06DTO dto)throws BLException;
    /**
     * @Description: �����ƻ���ѯ
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM06DTO    
     * @throws
     */
    public IGDRM06DTO searchIGDRM0602Action(IGDRM06DTO dto)throws BLException;
    /**
     * @Description: �����ƻ�����
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM06DTO    
     * @throws
     */
    public IGDRM06DTO drillplanToJudgeAction(IGDRM06DTO dto)throws BLException;
    /**
     * @Description: �����ƻ�����
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM06DTO    
     * @throws
     */
    public IGDRM06DTO drillplanJudgeAction(IGDRM06DTO dto)throws BLException;
    /**
     * @Description: �����ƻ��Ǽ�
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM06DTO    
     * @throws
     */
    public IGDRM06DTO insertDrillplanAction(IGDRM06DTO dto)throws BLException;
    /**
     * @Description: �����ƻ�ɾ��
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM06DTO    
     * @throws
     */
    public IGDRM06DTO deleteDrillplanAction(IGDRM06DTO dto)throws BLException;
    /**
     * @Description: �����ƻ���Ŀ��ʼ��
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM06DTO    
     * @throws
     */
    public IGDRM06DTO initDrillPlanItemAction(IGDRM06DTO dto)throws BLException;
    
    /**
     * @Description: �����ƻ����Ǽ�/�޸�/ɾ��
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM06DTO    
     * @throws
     */
    public IGDRM06DTO editDrillPlanItemAction(IGDRM06DTO dto)throws BLException;
    
    /**
     * @Description: �����ƻ���Ŀ��ͼ��ѯ ������������ʾ��
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM06DTO    
     * @throws
     */
    public IGDRM06DTO searchDrillPlanItemVWAction(IGDRM06DTO dto)throws BLException;
    /** 
     * @Title: searchDrillPlanVWAction 
     * @Description: TODO ������ѯ ������������Ŀ
     * @param dto
     * @return    
     * IGDRM06DTO    
     * @throws 
     */
    public IGDRM06DTO searchDrillPlanVWAction(IGDRM06DTO dto)throws BLException;
    
}
