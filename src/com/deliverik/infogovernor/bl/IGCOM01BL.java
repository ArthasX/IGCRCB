package com.deliverik.infogovernor.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dto.IGCOM01DTO;


/**
 * ��¼����ҵ���߼��ӿ�
 *
 *
 */
public interface IGCOM01BL extends BaseBL {


	/**
	 * 
	 *
	 * @param dto IGBAS01DTO
	 * @return IGBAS01DTO
	 */
	public IGCOM01DTO loginAction(IGCOM01DTO dto) throws BLException;
	
	public IGCOM01DTO loginActionByLDAP(IGCOM01DTO dto) throws BLException;
	
	public IGCOM01DTO loginActionByAD(IGCOM01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * ��ȡ�û�������Ľ�ɫList
	 * </p>
	 * 
	 * @param userId �û�ID
	 * @return �û�������Ľ�ɫList
	 * @author liupeng@deliverik.com
	 */

	public IGCOM01DTO getUserRoles(IGCOM01DTO dto);
	
	/**
	 * <p>
	 * ��ȡ��ҳ�����еĹ���
	 * </p>
	 * 
	 * @param userId �û�ID
	 * @return �����еĹ���
	 * @author   
	 */
	public IGCOM01DTO getProcessInHand(IGCOM01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * ��ȡ��ҳ�����е�֪ʶ
	 * </p>
	 * 
	 * @author   
	 */
	public IGCOM01DTO getKnowledge(IGCOM01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ��ȡ��ҳ�м�鹤�����
	 * </p>
	 */
	public IGCOM01DTO getRiskCheckResultGoup(IGCOM01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * ��ȡ��ҳ֪ͨ
	 * </p>
	 * 
	 * @author   
	 */
	public IGCOM01DTO getNotice(IGCOM01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * ��ҳ�ճ��ƻ�����
	 * </p>
	 * 
	 * @author   
	 */
	public IGCOM01DTO getDaysPlans(IGCOM01DTO dto) throws BLException;
	
	/**
	 * ��ҳ��ת����
	 * @param dto IGCOM01DTO
	 * @return IGCOM01DTO
	 * @throws BLException
	 */
	public IGCOM01DTO initIGCOM0105Action(IGCOM01DTO dto) throws BLException;
	
	/**
	 * �澯�б�
	 * @param dto IGCOM01DTO
	 * @return IGCOM01DTO
	 * @throws Exception
	 */
	public IGCOM01DTO searchHQAlertListDetailVWAction(IGCOM01DTO dto) throws Exception;
	
	/**
	 * ҵ��ϵͳ�������б�
	 * @param dto IGCOM01DTO
	 * @return IGCOM01DTO
	 * @throws Exception
	 */
	public IGCOM01DTO searchBussinessAvailvalVWAction(IGCOM01DTO dto) throws Exception;
	
	/**
	 * Oracle�澯�б�
	 * @param dto IGCOM01DTO
	 * @return IGCOM01DTO
	 * @throws Exception
	 */
	public IGCOM01DTO searchOracleAlertAction(IGCOM01DTO dto) throws Exception;
	
	/**
	 * �澯�б�
	 * @param dto IGCOM01DTO
	 * @return IGCOM01DTO
	 * @throws Exception
	 */
	public IGCOM01DTO searchHQAlertListDetailVWActionByIP(IGCOM01DTO dto) throws Exception;
}
