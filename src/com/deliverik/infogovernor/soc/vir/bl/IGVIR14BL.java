/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR14DTO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �����Դ����BL�ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IGVIR14BL extends BaseBL{

    /**
     * ��ѯδ�رյ���ά���̺���Դ������������
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR14DTO getProcessCountAction(IGVIR14DTO dto) throws BLException;
    
    /**
     * ��ѯδ�رյ���ά���̺���Դ���������б�
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR14DTO searchProcessList(IGVIR14DTO dto) throws BLException;
    
    /**
     * ��ȡ����������ĸ���
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR14DTO getVMCount4HostActon(IGVIR14DTO dto) throws BLException;
    
    /**
     * ��Դ����ͳ�����ݲ�ѯ
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR14DTO searchVMApplyStatisticsDataAction(IGVIR14DTO dto) throws BLException;

    /**
     * ��ʼ��������Ϣ
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR14DTO searchVCenterConnectionAction(IGVIR14DTO dto) throws BLException;

    /**
     * Host��Ϣ��ѯ
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR14DTO searchHostInfosAction(IGVIR14DTO dto) throws BLException;

}
