package com.deliverik.infogovernor.smr.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.smr.dto.IGSMR09DTO;

/**
 * ����:���ֳ���ܱ���DashBoard��̨����
 * �����ˣ���ʡ
 * ������¼�� 2013-09-10
 */
public interface IGSMR09BL extends BaseBL{
	
	/**
	 * ��ȡ���ӽ��ױ����ϼƺ͵��ӽ��׽��ϼ�
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSMR09DTO getElecTransTotal(IGSMR09DTO dto) throws BLException;
	
	/**
	 * ���н��ױ�������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSMR09DTO getMultiBankTransCount(IGSMR09DTO dto) throws BLException;
	
	/**
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSMR09DTO getTechnologyInfo(IGSMR09DTO dto) throws BLException;
	
	/**
	 * ������Ϣ�Ƽ�Ͷ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSMR09DTO getPieGraph(IGSMR09DTO dto) throws BLException;
	
	/**
	 * ��Ϣ�Ƽ�������ԴͶ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSMR09DTO getPieGraph1(IGSMR09DTO dto) throws BLException;
	
	/**
	 * ���ڶ��еڶ�����ͼ
	 * �걨
	 */
	public IGSMR09DTO getTechnologyAudit(IGSMR09DTO dto) throws BLException;
	
	/**
	 * ���ױ������Ʒ���
	 * ���� 
	 */
	public IGSMR09DTO getMultiBankTransCountTrend(IGSMR09DTO dto) throws BLException;
	
	/**
	 * ��������ҵ���ģ
	 * ����
	 */
	public IGSMR09DTO getElecWorkScale(IGSMR09DTO dto) throws BLException;
	
	/**
	 * �Ҳ��һ�к�ͼ
	 * �걨 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSMR09DTO getPersonnel(IGSMR09DTO dto) throws BLException ;

	/**
	 * ���н��׷�������
	 * ���� 
	 */
	public IGSMR09DTO getMultiBankTransMoney(IGSMR09DTO dto) throws BLException;

	/**
	 * ���׽�����Ʒ���
	 * ���� 
	 */
	public IGSMR09DTO getMultiBankTransMoneyTrend(IGSMR09DTO dto) throws BLException;

	/**
	 * ���ڶ��е�һ����ͼ
	 * �걨
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSMR09DTO getTechnologyNumber(IGSMR09DTO dto) throws BLException;

	/**
	 * �����Ŀ���
	 * �Ҳ�����б�ͼ
	 * �걨
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSMR09DTO getBarGraph(IGSMR09DTO dto) throws BLException;

	/**
	 * �Ҳ�ڶ���������ͼ
	 * �걨
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSMR09DTO getTechnologySort(IGSMR09DTO dto) throws BLException;
	
	/**
	 * ��Ϣ�Ƽ���Ŀ��������
	 * ϵͳ���ռ��
	 * ����ͼ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSMR09DTO getQuarAnalysePieGraph(IGSMR09DTO dto) throws BLException;
	
	/**
	 * ��Ϣ�Ƽ���Ŀ��������
	 * ��һ����Ŀ�������
	 * �Ҳ�����ͼ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSMR09DTO getQuarAnalyseTrendGraph(IGSMR09DTO dto) throws BLException;
	
	/**
	 * ��Ϣ�Ƽ���Ŀ��������
	 * ��Ŀ��ϸ
	 * �ϲ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSMR09DTO getQuarAnalyseGridGraph(IGSMR09DTO dto) throws BLException;
}
