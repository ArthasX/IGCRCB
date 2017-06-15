package com.deliverik.infogovernor.sym.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sym.dto.IGSYM15DTO;

/**
 * �������ݹ���ҵ���߼��ӿ�
 *
 * 
 */
public interface IGSYM15BL extends BaseBL {


	/**
	 * ���ݷ�����Ϣ���������ʾ
	 *
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
	public IGSYM15DTO initIGSYM1501Action(IGSYM15DTO dto) throws BLException;
	
//	/**
//	 * ���ݷ���ɾ������
//	 *
//	 * @param dto IGSYM15DTO
//	 * @return IGSYM15DTO
//	 */
//	public IGSYM15DTO deleteCodeCategoryAction(IGSYM15DTO dto) throws BLException;
//	
	/**
	 * ���ݷ���ǼǴ���
	 *
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
	public IGSYM15DTO insertCodeCategoryDefAction(IGSYM15DTO dto) throws BLException;
	
	/**
	 * ���ݷ���༭���������ʾ
	 *
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
//	public IGSYM15DTO initIGSYM1102Action(IGSYM15DTO dto) throws BLException;
	
	/**
	 * ���ݷ���������
	 *
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
	public IGSYM15DTO updateCodeCategoryDefAction(IGSYM15DTO dto) throws BLException;
	
	/**
	 * ������Ϣ��ϸ���������ʾ
	 *
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
	public IGSYM15DTO initIGSYM1502Action(IGSYM15DTO dto) throws BLException;
	
	/**
	 * ������Ϣ��ϸ���淵����ʾ
	 *
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
	public IGSYM15DTO initIGSYM1502BackAction(IGSYM15DTO dto) throws BLException;
	
	/**
	 * ������Ϣɾ������
	 *
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
	public IGSYM15DTO deleteCodeDetailDefAction(IGSYM15DTO dto) throws BLException;
	
	/**
	 * ������Ϣɾ������
	 *
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
	public IGSYM15DTO realdeleteCodeDetailDefAction(IGSYM15DTO dto) throws BLException;
	
	
	/**
	 * ������Ϣ�༭���������ʾ
	 *
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
	public IGSYM15DTO initIGSYM1503Action(IGSYM15DTO dto) throws BLException;
	
	/**
	 * ������Ϣ�ǼǴ���
	 *
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
	public IGSYM15DTO insertCodeDetailDefAction(IGSYM15DTO dto) throws BLException;
	
	/**
	 * ������Ϣ���´���
	 *
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
	public IGSYM15DTO updateCodeDetailDefAction(IGSYM15DTO dto) throws BLException;
	
	/**
	 * ���ݷ�����������
	 *
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
	public IGSYM15DTO saveIGSYM11501Action(IGSYM15DTO dto) throws BLException;
	
	/**
	 * ���ݷ���ɾ������
	 *
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
	public IGSYM15DTO deleteIGSYM1501Action(IGSYM15DTO dto) throws BLException;
	/**
	 * ���ݷ�����Ϣ���������ʾ
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM15DTO initIGSYM1506Action(IGSYM15DTO dto) throws BLException;
	
}
