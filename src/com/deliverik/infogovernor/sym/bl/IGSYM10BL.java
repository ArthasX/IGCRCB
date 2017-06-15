package com.deliverik.infogovernor.sym.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sym.dto.IGSYM10DTO;

/**
 * �������ݹ���ҵ���߼��ӿ�
 *
 * 
 */
public interface IGSYM10BL extends BaseBL {


	/**
	 * ���ݷ�����Ϣ���������ʾ
	 *
	 * @param dto IGSYM10DTO
	 * @return IGSYM10DTO
	 */
	public IGSYM10DTO initIGSYM1001Action(IGSYM10DTO dto) throws BLException;
	
	/**
	 * ���ݷ���ɾ������
	 *
	 * @param dto IGSYM10DTO
	 * @return IGSYM10DTO
	 */
	public IGSYM10DTO deleteCodeCategoryAction(IGSYM10DTO dto) throws BLException;
	
	/**
	 * ������Ϣ��ϸ���������ʾ
	 *
	 * @param dto IGSYM10DTO
	 * @return IGSYM10DTO
	 */
	public IGSYM10DTO initIGSYM1006Action(IGSYM10DTO dto) throws BLException;
	
	/**
	 * ������Ϣɾ������
	 *
	 * @param dto IGSYM10DTO
	 * @return IGSYM10DTO
	 */
	public IGSYM10DTO deleteCodeDetailAction(IGSYM10DTO dto) throws BLException;
	
	/**
	 * ������Ϣ�༭���������ʾ
	 *
	 * @param dto IGSYM10DTO
	 * @return IGSYM10DTO
	 */
	public IGSYM10DTO initIGSYM1004Action(IGSYM10DTO dto) throws BLException;
	
	/**
	 * ������Ϣ�ǼǴ���
	 *
	 * @param dto IGSYM10DTO
	 * @return IGSYM10DTO
	 */
	public IGSYM10DTO insertCodeDetailAction(IGSYM10DTO dto) throws BLException;
	
	/**
	 * ������Ϣ���´���
	 *
	 * @param dto IGSYM10DTO
	 * @return IGSYM10DTO
	 */
	public IGSYM10DTO updateCodeDetailAction(IGSYM10DTO dto) throws BLException;
	
}
