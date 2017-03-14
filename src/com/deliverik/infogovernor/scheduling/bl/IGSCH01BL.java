package com.deliverik.infogovernor.scheduling.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.scheduling.dto.IGSCH01DTO;
import com.deliverik.infogovernor.sdl.dto.IGSDL01DTO;

public interface IGSCH01BL extends BaseBL  {
	/**
	 * <p>
	 * Description: ��ʱ�����ѯ
	 * </p>
	 * 
	 * @param dto IGSCH01DTO
	 * @return IGSCH01DTO
	 * @throws BLException
	 * @author maozhipeng@deliverik.com
	 * @update
	 */
	public IGSCH01DTO searchQuartzJobs(IGSCH01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ��ʱ������ID��ѯ
	 * </p>
	 * 
	 * @param integer IGSCH01DTO
	 * @return IGSCH01DTO
	 * @throws BLException
	 * @author maozhipeng@deliverik.com
	 * @update
	 */
	public IGSCH01DTO searchQuartzJobsByPK(IGSCH01DTO dto) throws BLException;
	/**dto
	 * <p>
	 * Description: ��ʱ����ɾ��
	 * </p>
	 * 
	 * @param dto IGSCH01DTO
	 * @return IGSCH01DTO
	 * @throws BLException
	 * @author maozhipeng@deliverik.com
	 * @update
	 */
	
	public IGSCH01DTO deleteQuartzJobs(IGSCH01DTO dto) throws BLException;

	/**
	 * <p>
	 * Description: ��ʱ��������ʼ��
	 * </p>
	 * 
	 * @param dto IGSCH01DTO
	 * @return IGSCH01DTO
	 * @throws BLException
	 * @author maozhipeng@deliverik.com
	 * @update
	 */
	
	public IGSCH01DTO initIGSCH0101(IGSCH01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ��ʱ������
	 * </p>
	 * 
	 * @param dto IGSCH01DTO
	 * @return IGSCH01DTO
	 * @throws BLException
	 * @author maozhipeng@deliverik.com
	 * @update
	 */
	
	public void updateQuartzJobs(IGSCH01DTO dto) throws BLException;
	
	public IGSCH01DTO getQuartzJobs(IGSCH01DTO dto) throws BLException;
	
	public IGSDL01DTO findQuartzJobsForSDL(IGSDL01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: �������ڲ�ѯ�������
	 * </p>
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSDL01DTO searchQuartzJobsByDate(IGSDL01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ��ʱ������ID��ѯQuartzJobDetails
	 * </p>
	 * 
	 * @param integer IGSCH01DTO
	 * @return IGSCH01DTO
	 * @throws BLException
	 * @update
	 */
	public IGSCH01DTO searchQuartzJobDetailsByQjid(IGSCH01DTO dto) throws BLException;
	

	/**
	 * <p>
	 * Description: �������ڼ���¼�û���ѯ�������
	 * </p>
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSDL01DTO searchQuartzJobsByUserDate(IGSDL01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: �������ڼ���¼�û���ѯ��ά�ƻ���IGSDL0110.JSP��ѯҳʹ�ã�
	 * </p>
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSDL01DTO searchQuartzJobsForIGSDL0110(IGSDL01DTO dto) throws BLException;
}
