/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.dbs.bl;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.dbs.dto.IGDBS01DTO;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Symmetrix_Monitor_Rt;

/**
 * @����SOC EMC��ά�洢����ƽ̨��ҳBL
 * @�������� 1. ��IOPS/������
 *			2. ��������Ϣ
 *			3. ���д���ʡ�����������
 *			4. ��IOPS/������
 *			5. ��������Ϣ
 * 			6. �Ҷ�д���ʡ�����������
 *			7. ҵ���������
 *			8. ����KPI
 *			9.��ά������ʾ
 * @������¼��������    2010/12/09
 * @version 1.0
 */

public interface IGDBS01BL extends BaseBL {

	/**
	 * ����: ��ά������ʾ
	 * @param  IGDBS01DTO dto
	 * @return ��ά����xml����
	 * @throws BLException
	 */
	public IGDBS01DTO getOperationManagement(IGDBS01DTO dto) throws BLException;
	
	/**
	 * ����: ҵ���������
	 * @param  IGDBS01DTO dto
	 * @return ҵ����������
	 * @throws BLException
	 */
	public IGDBS01DTO getBusinessRus(IGDBS01DTO dto) throws BLException;
	
	/**
	 * ����: ����KPI
	 * @param  IGDBS01DTO dto
	 * @return ����KPI
	 * @throws BLException
	 */
//	public IGDBS01DTO getProcessKPI(IGDBS01DTO dto) throws BLException;
	
	/**
	 * ����: IOPS/������
	 * @param  IGDBS01DTO dto
	 * @return IOPS/������
	 * @throws BLException
	 */
	public IGDBS01DTO  getIOPSandThroughput1(IGDBS01DTO dto) throws BLException;
	
	/**
	 * ����: IOPS/������
	 * @param  IGDBS01DTO dto
	 * @return IOPS/������
	 * @throws BLException
	 */
	public IGDBS01DTO  getIOPSandThroughputCX(IGDBS01DTO dto) throws BLException;
	
	/**
	 * ����: IOPS/������
	 * @param  IGDBS01DTO dto
	 * @return IOPS/������
	 * @throws BLException
	 */
	public IGDBS01DTO  getIOPSandThroughput2(IGDBS01DTO dto) throws BLException;
	
	/**
	 * ����: ������/д����/����������
	 * @param  IGDBS01DTO dto
	 * @return ������/д����/����������
	 * @throws BLException
	 */
	public IGDBS01DTO  getReadperWriteperHitper1(IGDBS01DTO dto) throws BLException;
	
	/**
	 * ����: ������/д����/����������
	 * @param  IGDBS01DTO dto
	 * @return ������/д����/����������
	 * @throws BLException
	 */
	public IGDBS01DTO  getReadperWriteperHitper2(IGDBS01DTO dto) throws BLException;
	
	/**
	 * ����: ������ϸ��Ϣ
	 * @param  IGDBS01DTO dto
	 * @return ������ϸ��Ϣ
	 * @throws BLException
	 */
	public IGDBS01DTO  getHostInfo1(IGDBS01DTO dto) throws BLException;
	
	/**
	 * ����: ������ϸ��Ϣ
	 * @param  IGDBS01DTO dto
	 * @return ������ϸ��Ϣ
	 * @throws BLException
	 */
	public IGDBS01DTO  getHostInfo2(IGDBS01DTO dto) throws BLException;
	
	/**
	 * DashBoard����ʵʱ���ݵ���
	 */
	public List<Collect_Symmetrix_Monitor_Rt> getSymmetrixMonitorData();
	
	/**
	 * ���ɸ澯��Ϣ
	 * @param dataListAll
	 */
	public void getWarnInfo(List<Collect_Symmetrix_Monitor_Rt> dataListAll)throws BLException;
	/**
	 * get�洢��ͼ
	 * @param dataListAll
	 */
	public IGDBS01DTO  getPieAll(IGDBS01DTO dto) throws BLException;
	/**
	 * �澯��ѯ��ϢgetWarningList
	 * @param dataListAll
	 */
	public IGDBS01DTO  getWarningList(IGDBS01DTO dto) throws BLException;

}
