/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.rpt.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.rpt.dto.IGRPT03DTO;

/**
 * ����: ����ͳ�ƽӿ�
 * ��������: ����ͳ�ƽӿ�
 * ������¼: 2012/07/03
 * �޸ļ�¼: 
 */
public interface IGRPT03BL extends BaseBL {

	/**��ʼ����������*/
	public IGRPT03DTO initReport(IGRPT03DTO dto) throws BLException;
	
	/**��ʼ��������ѯ����*/
	public IGRPT03DTO initHostSearch(IGRPT03DTO dto) throws BLException;
	
	/**����·��ת��*/
	public IGRPT03DTO capacityBirtForm(IGRPT03DTO dto) throws BLException;
}
