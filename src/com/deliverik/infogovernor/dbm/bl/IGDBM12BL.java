/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dbm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dbm.dto.IGDBM12DTO;



/**
 * @��������ũ�����пƼ�����Dashboard BL
 * @�������� 	 1. 
 *           2. 
 *           3. 
 *           4. ��ѯҵ�񲿺ͿƼ�����������
 * @������¼ �ﶫ��  2014/07/17
 * @version 1.0
 */
public interface IGDBM12BL extends BaseBL{
	
	/**
	 * ���������ͳ������ȡ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDBM12DTO getRcclass(IGDBM12DTO dto) throws BLException;
	
	/**
	 * 
	 * �������⼰����ռ������ȡ��
	 * 
	 * @return dto
	 * @throws BLException
	 */
	public IGDBM12DTO getRcclassByMonth(IGDBM12DTO dto) throws BLException;

	
	/**
	 * ����: ��ѯҵ�񲿺ͿƼ�����������
	 * @param  IGDBM12DTO dto
	 * @return ��������ֵ
	 * @throws BLException
	 */
	public IGDBM12DTO getPieValue(IGDBM12DTO dto)throws BLException;
	
	/**
	 * ��ȹ�����������ȡ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDBM12DTO getRcTestMode(IGDBM12DTO dto) throws BLException;
	
	/**
	 * ��Ϣ��ȫ����������������ȡ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDBM12DTO getRiskCheckResult(IGDBM12DTO dto) throws BLException;
	
	/**
	 * ���⼰�����������ȡ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDBM12DTO getQuestions(IGDBM12DTO dto) throws BLException;
	
	/**
	 * ����:�����Ŵ������������Ʒ���xml
	 * @param IGDBM12DTO dto
	 * @return �����Ŵ������������Ʒ���
	 * @throws BLException
	 */
	public IGDBM12DTO setEventAvgCost(IGDBM12DTO dto)  throws BLException;

	/**
	 * �������������ռ������ȡ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDBM12DTO getWorkOrderAction(IGDBM12DTO dto) throws BLException;

	/**
	 * ������ռ��ͳ������ȡ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDBM12DTO getChangeResultAction(IGDBM12DTO dto) throws BLException;

	/**
	 * �����������Ա�����ȡ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDBM12DTO getQotnDataAction(IGDBM12DTO dto) throws BLException;

	/**
	 * ����:���ɴ�����ҳ����ƻ�����xml
	 * @param IGDBM03DTO dto
	 * @return ����ƻ�����
	 * @throws BLException
	 */
	public IGDBM12DTO setChangePlan(IGDBM12DTO dto) throws BLException;

	/**
	 * ʱ�����Ʒ�������ȡ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDBM12DTO getEventTrendAction(IGDBM12DTO dto) throws BLException;
	public IGDBM12DTO getBusinessDepart(IGDBM12DTO dto) throws BLException;
	public IGDBM12DTO getScienceDepart(IGDBM12DTO dto) throws BLException;

	/**
	 * ���̲�ѯ������ʼ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDBM12DTO searchProcessRecordAction(IGDBM12DTO dto) throws BLException;

	/**
	 * ��鹤����ѯ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDBM12DTO searchRiskWorkAction(IGDBM12DTO dto) throws BLException;

	//�Ƽ����� start����������
	/**
	 * ����: ��ȡ ���ղ��Ź������-���ӱ�����
	 * @param  IGDBM12DTO dto
	 * @return  ���ղ��Ź��� ����ֵ
	 * @throws BLException
	 */
	public IGDBM12DTO getCounterValue(IGDBM12DTO dto)throws BLException;
	/**
	 * ����: ��ȡ ���ղ��Ź������-���ӱ�����
	 * @param  IGDBM12DTO dto
	 * @return  ���ղ��Ź��� ����ֵ
	 * @throws BLException
	 */
	public IGDBM12DTO getRiskCheck(IGDBM12DTO dto)throws BLException;
	/**
	 * ����: ��ȡ ����ȷ��չ����������-���
	 * @param  IGDBM12DTO dto
	 * @return  ���ղ��Ź��� ����ֵ
	 * @throws BLException
	 */
	public IGDBM12DTO getRiskProblem(IGDBM12DTO dto)throws BLException;
	/**
	 * ����: ��ȡ ����ȷ������⼰����ռ��-���⼰����
	 * @param  IGDBM12DTO dto
	 * @return  ���ղ��Ź��� ����ֵ
	 * @throws BLException
	 */
	public IGDBM12DTO getRiskRepository(IGDBM12DTO dto)throws BLException;
	/**
	 * ����: ��ȡ �������������������-����ͼ-���⼰�������
	 * @param  IGDBM12DTO dto
	 * @return  ���ղ��Ź��� ����ֵ
	 * @throws BLException
	 */
	public IGDBM12DTO getRiskRectification(IGDBM12DTO dto)throws BLException;
	/**
	 * ����: ��ȡ �������������������-����ͼ-��鹤��
	 * @param  IGDBM12DTO dto
	 * @return  ���ղ��Ź��� ����ֵ
	 * @throws BLException
	 */
	public IGDBM12DTO getRiskAssess(IGDBM12DTO dto)throws BLException;
	/**
	 * ����: ��ȡ �������������������-����ͼ-��鹤��
	 * @param  IGDBM12DTO dto
	 * @return  ���ղ��Ź��� ����ֵ
	 * @throws BLException
	 */
	public IGDBM12DTO searchIssueCorrectiveByField(IGDBM12DTO dto)throws BLException;
	/**
	 * ����: ��ȡ �������������������-����ͼ-��鹤��
	 * @param  IGDBM12DTO dto
	 * @return  ���ղ��Ź��� ����ֵ
	 * @throws BLException
	 */
	public IGDBM12DTO searchCounterInfo(IGDBM12DTO dto)throws BLException;
	/**
	 * �ʲ�שȡҳ�����(���յ�,�����)
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDBM12DTO searchRiskRepositoryAction(IGDBM12DTO dto) throws BLException;
	
	//�Ƽ����� end����������
}
