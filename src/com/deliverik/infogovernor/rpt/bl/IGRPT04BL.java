/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.rpt.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.rpt.dto.IGRPT04DTO;

/**
 * ����: ����ͳ�ƽӿ�
 * ��������: ����ͳ�ƽӿ�
 * ������¼: 2012/07/03
 * �޸ļ�¼: 
 */
public interface IGRPT04BL extends BaseBL {

	/**��ʼ����������*/
	public IGRPT04DTO initReport(IGRPT04DTO dto) throws BLException;
	
	/**
     * �����������Ϣȡ��
     * 
     * @param IGRPT04DTO dto
     * @return IGRPT04DTO
     */
    public IGRPT04DTO getCustomConfigurationInfo(IGRPT04DTO dto) throws BLException ;
	
}
