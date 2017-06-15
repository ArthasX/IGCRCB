/*
 * ��������������������޹�˾��Ȩ����,��������Ȩ��.
 */
package com.deliverik.infogovernor.soc.vir.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR02DTO;

/**
 * ���⻯��Դ����ҵ���߼��ӿ�
 *
 * 
 */
public interface IGVIR02BL extends BaseBL {

    /**
     * ��vCenter�ϻ�ȡ�����ģ��
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR02DTO getTemplate(IGVIR02DTO dto) throws BLException;
    
    /**
     * ����������Ŀ�������Ϣ
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR02DTO saveApplyVMInfo(IGVIR02DTO dto) throws BLException;
    
    /**
     * ��ȡ������Ŀ�����Ϣ
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR02DTO getApplyVMInf(IGVIR02DTO dto) throws BLException;
    
    /**
     * ����������Ŀ�������Ϣ
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR02DTO saveVMInfo4Approve(IGVIR02DTO dto) throws BLException;
    
    /**
     * ����vCenter id��ѯhost�б�
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR02DTO searchHostByVcid(IGVIR02DTO dto) throws BLException;
    
    /**
     * ����������ѯ����
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR02DTO searchNetLabelByHost(IGVIR02DTO dto) throws BLException;
    
    /**
     * �����������Ĳ�ѯ����
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR02DTO searchNetLabelByDatacenter(IGVIR02DTO dto) throws BLException;
    
    /**
     * ��ȡ������Ŀ�����Ϣ
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR02DTO getApplyVMList(IGVIR02DTO dto) throws BLException;
    
    /**
     * ��ѯ��������
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR02DTO searchDatacenterByVcid(IGVIR02DTO dto) throws BLException;
    
    /**
     * ��ѯ��Դ��
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR02DTO searchResourcePoolByVcid(IGVIR02DTO dto) throws BLException;
    
    /**
     * ��ѯ���������־
     * 
     * @return
     * @throws BLException
     */
    public IGVIR02DTO searchDeployLog(IGVIR02DTO dto) throws BLException;
}
