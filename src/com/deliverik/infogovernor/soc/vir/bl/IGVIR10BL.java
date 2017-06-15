package com.deliverik.infogovernor.soc.vir.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR10DTO;

/**
 * ��ҳҵ���߼��ӿ�
 *
 * 
 */
public interface IGVIR10BL extends BaseBL {
	
	/**
	 *  ��ȡ������Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR10DTO getProcessList(IGVIR10DTO dto) throws BLException;
	
	
	/**
	 * ��ȡ��Դ��Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR10DTO getResouceInfo(IGVIR10DTO dto)throws BLException;
	
	
	/**
	 * ��ȡ�����Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR10DTO getFigureInfo(IGVIR10DTO dto)throws BLException;
	
	
	/**
	 * ��ʼ���û�Action��Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR10DTO initVir10UserAction(IGVIR10DTO dto)throws BLException;
	

	/**
	 * ��ʼ������ԱAction��Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR10DTO initVir10ManageAction(IGVIR10DTO dto)throws BLException;
	
	
	/**
	 * ��ȡ��������Դʹ�����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR10DTO getResourceInfoByOrg(IGVIR10DTO dto)throws BLException;
	
	
	/**
	 * ��ȡ��Դ�ſ�
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR10DTO getResourceSurvey(IGVIR10DTO dto)throws BLException;
	
	/**
	 * ��ȡ�������������Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR10DTO getPendingProcessList(IGVIR10DTO dto)throws BLException;

	/**
	 * ��ʼ������Ա��ҳ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR10DTO initManageHomePageAction(IGVIR10DTO dto) throws BLException;
	
	/**
	 * ��ȡģ����Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR10DTO getTemplateList(IGVIR10DTO dto)throws BLException;


	/**
	 * ��ʼ���û���ҳ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR10DTO initUserHomePageAction(IGVIR10DTO dto) throws BLException;

	/**
	 * �ı����״̬����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR10DTO changeVMAction(IGVIR10DTO dto) throws BLException;

	/**
	 * ��ʼ����Դ������ҳ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR10DTO initResourceManageHomePageAction(IGVIR10DTO dto) throws BLException;
}
