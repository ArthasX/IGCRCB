package com.deliverik.infogovernor.sym.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sym.dto.IGSYM11DTO;

/**
 * �������ݹ���ҵ���߼��ӿ�
 *
 * 
 */
public interface IGSYM11BL extends BaseBL {


	/**
	 * ���ݷ�����Ϣ���������ʾ
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO initIGSYM1101Action(IGSYM11DTO dto) throws BLException;

	/**
	 * ���ݷ���ǼǴ���
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO insertCodeCategoryAction(IGSYM11DTO dto) throws BLException;
	
	/**
	 * ���ݷ���༭���������ʾ
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO initIGSYM1102Action(IGSYM11DTO dto) throws BLException;
	
	/**
	 * ���ݷ���������
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO updateCodeCategoryAction(IGSYM11DTO dto) throws BLException;
	
	/**
	 * ������Ϣ��ϸ���������ʾ
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO initIGSYM1106Action(IGSYM11DTO dto) throws BLException;
	
	/**
	 * ������Ϣ��ϸ���淵����ʾ
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO initIGSYM1106BackAction(IGSYM11DTO dto) throws BLException;
	
	/**
	 * ������Ϣɾ������
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO deleteCodeDetailAction(IGSYM11DTO dto) throws BLException;
	
	/**
	 * ������Ϣ�༭���������ʾ
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO initIGSYM1104Action(IGSYM11DTO dto) throws BLException;
	
	/**
	 * ������Ϣ�ǼǴ���
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO insertCodeDetailAction(IGSYM11DTO dto) throws BLException;
	
	/**
	 * ������Ϣ���´���
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO updateCodeDetailAction(IGSYM11DTO dto) throws BLException;
	/**
	 * �������ȼ���������
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO findByPriorityCond(IGSYM11DTO dto) throws BLException;
	
	/**
	 * ���ݷ�����������
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO saveIGSYM1107Action(IGSYM11DTO dto) throws BLException;
	
	/**
	 * ���ݷ���ɾ������
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO deleteIGSYM1101Action(IGSYM11DTO dto) throws BLException;
	
	/**
	 * ȡ������Ӱ��ȼ���������Ϣ
	 *
	 * @param IGSYM11DTO
	 * @param 
	 */
	public IGSYM11DTO getPrimpactAndPrurgency(IGSYM11DTO dto) throws BLException;
	
	/**
	 * �������ȼ���������
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public void savePriority(IGSYM11DTO dto) throws BLException;
}
