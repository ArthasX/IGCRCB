/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.bl;

import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.infogovernor.sym.dto.IGSYM01DTO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_��������_BL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public interface IGSYM01BL extends BaseBL {
	
	/**
	 * <p>
	 * Description: ������ѯ
	 * </p>
	 * 
	 * @param dto IGSYM01DTO
	 * @return IGSYM01DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM01DTO searchOrganizationAction(IGSYM01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ����ɾ��
	 * </p>
	 * 
	 * @param dto IGSYM01DTO
	 * @return IGSYM01DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM01DTO deleteOrganizationAction(IGSYM01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ��������
	 * </p>
	 * 
	 * @param dto IGSYM01DTO
	 * @return IGSYM01DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM01DTO insertOrganizationAction(IGSYM01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ���������ʼ��
	 * </p>
	 * 
	 * @param dto IGSYM01DTO
	 * @return IGSYM01DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM01DTO initIGSYM0102Action(IGSYM01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: �������
	 * </p>
	 * 
	 * @param dto IGSYM01DTO
	 * @return IGSYM01DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM01DTO updateOrganizationAction(IGSYM01DTO dto) throws BLException;
	
	/**
	 * ���ݴ���Ļ���ID����ѯ��
	 * @param ����ID
	 * @return 
	 * @throws BLException
	 * @author
	 */
	public Map<String, TreeNode> getOrgsyscodingTree(String orgid) throws BLException;
	
	/**
	 * ��ѯ���л���
	 * @return List<Organization>
	 */
	
	public IGSYM01DTO searchOrganizationAll(IGSYM01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * ��ѯ���ڵ��ϼ�������һ��������
	 * </p>
	 * 
	 * @param dto IGSYM01DTO
	 * @return IGSYM01DTO
	 * @throws BLException
	 */
	
	public IGSYM01DTO searchOrgTreeAction(IGSYM01DTO dto,String type) throws BLException;
	
	public void changePTStatus(IGSYM01DTO dto) throws BLException ;
	
	/**
	 * <p>
	 * ��ѯ���ڵ��ϼ�������һ��������
	 * </p>
	 * 
	 * @param dto IGSYM01DTO
	 * @return IGSYM01DTO
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public IGSYM01DTO searchItemTreeAction(IGSYM01DTO dto,String type) throws BLException;
	
	/**
	 * <p>
	 * Description: ������ѯ(IGASM1303Action����)
	 * </p>
	 */
	
	public IGSYM01DTO searchOrganizationForIGASM1303Action(IGSYM01DTO dto) throws BLException; 
	
	/**
	 * <p>
	 * ȡ�øý��Ļ���ȫ��
	 * </p>
	 * @param  syscoding
	 * @throws BLException
	 */

	public String getCompleteOrgName(String syscoding);
	
	/**
	 * <p>
	 * Description: ������ѯ(IGASM01BL����)
	 * </p>
	 */
	
	public IGSYM01DTO searchOrganizationForIGASM0101() throws BLException;
	
	public IGSYM01DTO searchITEMS0174Tree(IGSYM01DTO dto) throws BLException;
}
