/*
 * ��������������������޹�˾��Ȩ����,��������Ȩ��.
 */
package com.deliverik.infogovernor.soc.vir.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR03DTO;

/**
 * ���⻯��Դ����ҵ���߼��ӿ�
 *
 * 
 */
public interface IGVIR03BL extends BaseBL {
    
    /**
     * ��ѯ��Ŀ�б�
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR03DTO searchProjectList(IGVIR03DTO dto) throws BLException;
    
    /**
     * ��ȡ������Ŀ�����Ϣ
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR03DTO getApplyVMInf(IGVIR03DTO dto) throws BLException;
    
    /**
     * ���������������Ϣ
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR03DTO saveApplyVMInfo(IGVIR03DTO dto) throws BLException;
}
