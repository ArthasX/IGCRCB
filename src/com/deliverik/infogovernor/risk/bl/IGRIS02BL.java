package com.deliverik.infogovernor.risk.bl;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.risk.dto.IGRIS02DTO;
import com.deliverik.infogovernor.risk.model.RiskCheckResult;


/**
 * ���ռ��ҵ���߼��ӿ�
 *
 *
 */
public interface IGRIS02BL extends BaseBL {

	/**
	 * <p>
	 * Description: ��ʼ������Ӧ�ý��еķ��ռ��
	 * </p>
	 */
	public void initRiskCheckResult(IGRIS02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ���ռ������
	 * </p>
	 */
	public IGRIS02DTO insertRiskCheckAction(IGRIS02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ���ռ������ʼ��
	 * </p>
	 */
	public IGRIS02DTO initupdateRiskCheckAction(IGRIS02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ���ռ����
	 * </p>
	 */
	public IGRIS02DTO updateRiskCheckAction(IGRIS02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ���ռ���ѯ
	 * </p>
	 */
	
	public IGRIS02DTO searchRiskCheckAction(IGRIS02DTO dto) throws BLException;
	
	/**
	 * ����������ʼ������
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS02DTO searchRiskAuditDefAction(IGRIS02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ����������
	 * </p>
	 */
	
	public IGRIS02DTO insertRiskAuditDefAction(IGRIS02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ���ռ�����״̬
	 * </p>
	 */
	
	public IGRIS02DTO changeRiskCheckStatusAction(IGRIS02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ���ռ��鿴ҳ
	 * </p>
	 */
	
	public IGRIS02DTO readRiskCheckAction(IGRIS02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ���ռ������ѯ
	 * </p>
	 */
	
	public IGRIS02DTO searchRiskCheckResultAction(IGRIS02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ���ռ��������
	 * </p>
	 */
	
	public IGRIS02DTO insertRiskCheckResultAction(IGRIS02DTO dto) throws BLException;
	
	
	public IGRIS02DTO insertCheckStrategAction(IGRIS02DTO dto) throws BLException;
	
	
	
	
	/**
	 * <p>
	 * Description: ���ռ�����ձ���ѯ
	 * </p>
	 */
	
	public IGRIS02DTO searchRiskCheckResultReportByDayAction(IGRIS02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ���ռ�����׶β�ѯ
	 * </p>
	 */
	
	public IGRIS02DTO searchRiskCheckResultReportByPeriodAction(IGRIS02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ���һ�η��ռ������ѯ
	 * </p>
	 */
	
	public IGRIS02DTO searchLastRiskCheckResultReportAction(IGRIS02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ��鹤���ල��ѯ
	 * </p>
	 */
	public IGRIS02DTO searchSuperviseRiskCheckResultReportAction(IGRIS02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ���һ�η��ռ������ѯ(ͳ�Ʒ���ҳ��ʾʹ��)
	 * </p>
	 */
	
	public List<RiskCheckResult> searchLastRiskCheckResultToVo() throws BLException;
	
	/**
	 * <p>
	 * Description: ���ռ�����鿴ҳ
	 * </p>
	 */
	
	public IGRIS02DTO readRiskCheckResultReportAction(IGRIS02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ����quartzִ�����ڱ��ʽ
	 * </p>
	 */
	public String getCronInfo(String periodType,String startDate);
	
	/**
	 * <p>
	 * Description: ���ռ��Ǽǳ�ʼ��
	 * </p>
	 */
	public IGRIS02DTO dispRiskCheckAction(IGRIS02DTO dto) throws BLException;
	public IGRIS02DTO sel(IGRIS02DTO dto);
	
	public IGRIS02DTO searchCheckWorkResulReportAction(IGRIS02DTO dto) throws BLException;
	
	public IGRIS02DTO changeCheckStrategyStatusAction(IGRIS02DTO dto) throws BLException;
	

	public IGRIS02DTO changeCheckStrategyStatusOnlyAction(IGRIS02DTO dto) throws BLException;
	
	public IGRIS02DTO selPoint(IGRIS02DTO dto) throws BLException;
	
	public IGRIS02DTO copyCheckStrategyStatusAction(IGRIS02DTO dto) throws BLException;
	
	
	/**	
	 * ���ܣ����ݼ�����id��ѯ������
	 * @param dto
	 * @return
	 * @throws BLException
	 * �޸ļ�¼��null 	
	 */	
	public IGRIS02DTO searchCheckStrategyByCsid(IGRIS02DTO dto) throws BLException;

	/**
	 * ���ܣ����������鹤��ָ������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGRIS02DTO batchFlowAction(IGRIS02DTO dto) throws BLException;

	/**
	 * ���ܣ���ʼ������ҳ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGRIS02DTO initIGRIS0402Action(IGRIS02DTO dto) throws BLException;

	public IGRIS02DTO assignAction(IGRIS02DTO dto) throws BLException;
}
