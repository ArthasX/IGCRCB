package com.deliverik.infogovernor.soc.iop.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.iop.dto.IGIOP01DTO;

/**
 * IP�εǼ�ҵ���߼��ӿ�
 *
 * 
 */
public interface IGIOP01BL extends BaseBL {

	/**
	 * �Ǽ�IP��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGIOP01DTO regIP(IGIOP01DTO dto)throws BLException;
	
	
	/**
	 * ����������Ϣ
	 * @param dto
	 * @return
	 */
	public IGIOP01DTO searchIPS(IGIOP01DTO dto)throws BLException;
	
	/**
	 * ���������ڵ�����IP
	 * @param dto
	 * @return
	 * @throws BLException 
	 */
	public IGIOP01DTO recoveryAllIP(IGIOP01DTO dto) throws BLException;
	
	/**
	 * �鿴����IP
	 * @param dto
	 * @return
	 */
	public IGIOP01DTO showIP(IGIOP01DTO dto)throws BLException;
	
	/**
	 * ����IP
	 * @param dto
	 * @return
	 */
	public IGIOP01DTO saveIP(IGIOP01DTO dto)throws BLException;
	
	/**
	 * ɾ��������ɾ�������ڵ�IP
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGIOP01DTO delSubNet(IGIOP01DTO dto)throws BLException;
	
	/**
	 * ����IP�ʲ���eiid ��ѯ
	 * @param dto
	 * @return
	 */
	public IGIOP01DTO searchIPByEiids(IGIOP01DTO dto);
	
	/**
	 * IP����
	 * @param dto
	 * @return
	 */
	public IGIOP01DTO allotIP(IGIOP01DTO dto)throws BLException;
	
	/**
	 * �Ǽ�����
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGIOP01DTO regSubNet(IGIOP01DTO dto) throws BLException;
	
	/**
	 * ��������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGIOP01DTO updateSubNet(IGIOP01DTO dto) throws BLException;
	
}
