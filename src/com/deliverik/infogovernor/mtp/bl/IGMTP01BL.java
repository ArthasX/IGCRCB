package com.deliverik.infogovernor.mtp.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.mtp.dto.IGMTP01DTO;
import com.deliverik.infogovernor.mtp.dto.IGMTP03DTO;
import com.deliverik.infogovernor.mtp.dto.IGMTP04DTO;

public interface IGMTP01BL extends BaseBL {

	/**
	 * ȡ������ģ�嶨����Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMTP01DTO getProcessDefinitions(IGMTP01DTO dto) throws BLException;

	
	/**
	 * ������ά�ƻ��Ǽ���Ϣ����ִ�����ڱ��ʽ˵��
	 * @param periodType ��������
	 * @param exeHour Сʱ
	 * @param exeMinute ����
	 * @param startDate ��ʼ����
	 * @return
	 */
	public String getPeriodInfo(String periodType, String exeHour, String exeMinute,String startDate);
	
	/**
	 * ���ݵǼǵ���ά�ƻ���Ϣ����ִ�����ڱ��ʽ
	 * @param periodType ��������
	 * @param exeHour Сʱ
	 * @param exeMinute ����
	 * @param qjcrttime ��ʼ����
	 * @return
	 */
	public String creatCronExp(String periodType,String exeHour, String exeMinute, String qjcrttime);
	
	/**
	 * ��ʼ����ά�ƻ���ϸ����ҳ�棨IGMTP0104��
	 * @param dto 
	 * @param cronExpression quartz���ʽ
	 * @return
	 * @throws Exception
	 */
	public IGMTP01DTO initIGMTP0104(IGMTP01DTO dto,String cronExpression) throws Exception;
	
	/**
	 * ��ʼ����ά�ƻ���ϸ�����޸�ҳ�棨IGMTP0106��
	 * @param dto 
	 * @param cronExpression quartz���ʽ
	 * @return
	 * @throws Exception
	 */
	public IGMTP01DTO initIGMTP0107(IGMTP01DTO dto,String cronExpression) throws Exception;

	/**
	 * �Ǽǹ����ƻ�������ʼ��
	 * @param dto 
	 * @return
	 * @throws Exception
	 */
	public IGMTP03DTO initIGMTP0104Action(IGMTP03DTO dto) throws BLException;

	/**
	 * �޸Ĺ����ƻ�������ʼ��
	 * @param dto 
	 * @return
	 * @throws Exception
	 */
	public IGMTP03DTO initIGMTP0107Action(IGMTP03DTO dto) throws BLException;	
	
	/**
	 * �޸Ĺ����ƻ�������ʼ��(IGMTP0107Action)
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMTP03DTO initIGMTP0107(IGMTP03DTO dto) throws BLException;
	
	
	/**
	 * ȡ����ά�ƻ�����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMTP04DTO getQuartzJobs(IGMTP04DTO dto) throws BLException;


	/**
	 * �ճ���ά�ƻ��޸Ĵ���
	 * @param dto
	 * @throws BLException
	 */
	public IGMTP01DTO updateQuartzJobs(IGMTP01DTO dto) throws BLException;
	
	/**
	 * �޸Ĺ����ƻ�������ʼ��(IGMTP0104Action)
	 */
	public IGMTP03DTO initIGMTP0104(IGMTP03DTO dto) throws BLException ;
}
