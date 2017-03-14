/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.bl;

import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.sym.dto.IGSYM03DTO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_��ɫ����_BL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public interface IGSYM03BL extends BaseBL {
	
	/**
	 * <p>
	 * Description: ��ɫ��ѯ
	 * </p>
	 * 
	 * @param dto IGSYM03DTO
	 * @return IGSYM03DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM03DTO searchRoleAction(IGSYM03DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ��ɫɾ��
	 * </p>
	 * 
	 * @param dto IGSYM03DTO
	 * @return IGSYM03DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM03DTO deleteRoleAction(IGSYM03DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ��ɫ����
	 * </p>
	 * 
	 * @param dto IGSYM03DTO
	 * @return IGSYM03DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM03DTO insertRoleAction(IGSYM03DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ��ɫ�����ʼ��
	 * </p>
	 * 
	 * @param dto IGSYM03DTO
	 * @return IGSYM03DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM03DTO initIGSYM0302Action(IGSYM03DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ��ɫ���
	 * </p>
	 * 
	 * @param dto IGSYM03DTO
	 * @return IGSYM03DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM03DTO updateRoleAction(IGSYM03DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ȡ�ý�ɫ��������(�ʲ�����ʹ��)
	 * </p>
	 * 
	 * @param dto IGSYM03DTO
	 * @return IGSYM03DTO
	 * @throws BLException
	 * @author duchong@deliverik.com
	 * @update
	 */
	
	public IGSYM03DTO getRoleDomainTree(IGSYM03DTO sym03dto,String roletype,User user) throws BLException;
	public IGSYM03DTO getRoleDomainTree(IGSYM03DTO sym03dto) throws BLException;
	/**
	 * ���ݴ���ĸ��û��Ľ�ɫ���Ϻͽ�ɫ����ȡ�����и����͵Ľ�ɫ���ʲ������������Ĳ���
	 * @param ��ɫ����(ҳ�洫��)
	 * @param ���û��Ľ�ɫ����(session��ȡ��)
	 * @return 
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	public IGSYM03DTO getAssetDomainTree(IGSYM03DTO sym03dto,String roletype,User user) throws BLException;
	
	/**
	 * <p>
	 * Description: ��ɫ��ѯ��IGSYM0306��������ʹ�ã�
	 * </p>
	 * 
	 * @param dto IGSYM03DTO
	 * @return IGSYM03DTO
	 * @throws BLException
	 */
	
	public IGSYM03DTO searchRoleActionFor0306(IGSYM03DTO dto) throws BLException;
	
	/**
	 * ���ݴ���Ľ�ɫID����ѯ��
	 * @param ��ɫID
	 * @return 
	 * @throws BLException
	 * @author
	 */
	public Map<String, TreeNode> getRoleDomainsTree(String roleId) throws BLException;
}
