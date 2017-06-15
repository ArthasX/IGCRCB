/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sym.dto.IGSYM02DTO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_�û�����_BL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public interface IGSYM02BL extends BaseBL {
	
	/**
	 * <p>
	 * Description: �û���ѯ
	 * </p>
	 * 
	 * @param dto IGSYM02DTO
	 * @return IGSYM02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM02DTO searchUserAction(IGSYM02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: �û�ɾ��/����
	 * </p>
	 * 
	 * @param dto IGSYM02DTO
	 * @return IGSYM02DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	
	public IGSYM02DTO changeUserFlagAction(IGSYM02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: �û�����
	 * </p>
	 * 
	 * @param dto IGSYM02DTO
	 * @return IGSYM02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM02DTO insertUserAction(IGSYM02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: �û������ʼ��
	 * </p>
	 * 
	 * @param dto IGSYM02DTO
	 * @return IGSYM02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM02DTO initIGSYM0202Action(IGSYM02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: �û����
	 * </p>
	 * 
	 * @param dto IGSYM02DTO
	 * @return IGSYM02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM02DTO updateUserAction(IGSYM02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: �û����
	 * </p>
	 * 
	 * @param dto IGSYM02DTO
	 * @return IGSYM02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM02DTO updateUserManagerAction(IGSYM02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ������ѯ
	 * </p>
	 * 
	 * @return IGSYM02DTO
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM02DTO searchOrganizationAll(IGSYM02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: �û�������ѯ
	 * </p>
	 * 
	 * @return IGSYM02DTO
	 * @author songhaiyang@deliverik.com
	 * @update
	 */
	public int searchUserCount(IGSYM02DTO dto) throws BLException;
	
	/** <p>
	 * Description: �û���ѯ
	 * </p>
	 * 
	 * @param dto IGSYM02DTO
	 * @return IGSYM02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM02DTO searchUserActionForIGASM0101() throws BLException;
	
	/**
	 * <p>
	 * Description: �û���ҳ�б�ȡ��
	 * </p>
	 * 
	 * @param dto IGSYM02DTO
	 * @return IGSYM02DTO
	 * @throws BLException
	 * @update
	 */
	public IGSYM02DTO searchComboBoxAction(IGSYM02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: �û���ѯ
	 * �޷�ҳ
	 * </p>
	 * 
	 * @param dto IGSYM02DTO
	 * @return IGSYM02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	public IGSYM02DTO searchUserActionNoPage(IGSYM02DTO dto) throws BLException ;
}
