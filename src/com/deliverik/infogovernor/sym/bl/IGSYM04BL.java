/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sym.dto.IGSYM04DTO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_��Ȩ����_��ɫ��ȨBL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public interface IGSYM04BL extends BaseBL {
	
	/**
	 * <p>
	 * Description: �û���ѯ
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM04DTO searchUserAction(IGSYM04DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ��ɫ��ѯ
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM04DTO searchRoleAction(IGSYM04DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: �û���ɫ��ѯ
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM04DTO searchUserRoleAction(IGSYM04DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: �û���ɫ��ѯ
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM04DTO searchUserRoleForManagerAction(IGSYM04DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ɾ���û���ɫ
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM04DTO revokeUserRoleAction(IGSYM04DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ����û���ɫ
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM04DTO grantUserRoleAction(IGSYM04DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ��ɫ�˵���ѯ
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM04DTO searchRoleActionAction(IGSYM04DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ɾ����ɫ�˵�
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM04DTO revokeRoleActionAction(IGSYM04DTO dto) throws BLException; 
	
	/**
	 * <p>
	 * Description: ��ӽ�ɫ�˵�
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM04DTO grantRoleActionAction(IGSYM04DTO dto) throws BLException; 
	
	/**
	 * <p>
	 * Description: �˵���Ȩ
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM04DTO roleActionAction(IGSYM04DTO dto) throws BLException; 
	
	/**
	 * <p>
	 * Description: ������ѯ
	 * </p>
	 * 
	 * @return List<Organization>
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM04DTO searchOrganizationAll(IGSYM04DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ���ݽ�ɫ��ѯ�û�
	 * </p>
	 * 
	 * @return IGSYM04DTO
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM04DTO searchRoleUser(IGSYM04DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ���ݽ�ɫ��ѯ�û�����ҳ
	 * </p>
	 * 
	 * @return IGSYM04DTO
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM04DTO searchRoleUserALL(IGSYM04DTO dto) throws BLException;
	
	/**
	 * ��ȡ��ɫ������
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */
	public IGSYM04DTO searchRoleManagerAction(IGSYM04DTO dto) throws BLException;
	
	/**
	 * ���ý�ɫ������
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */
	public IGSYM04DTO saveRoleManagerAction(IGSYM04DTO dto) throws BLException;
	

	/**
	 * ����ֵ����
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author wangxiaoqiang@deliverik.com
	 */
	public IGSYM04DTO saveDutyflagAction(IGSYM04DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: ���ݽ�ɫ���Ͳ�ѯ�û�
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */
	
	public IGSYM04DTO searchUserByRoleType(IGSYM04DTO dto) throws BLException;

/**
	 * ������Ϣ��ѯ����
	 *
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 */
	public IGSYM04DTO searchReportFileDefinitionAction(IGSYM04DTO dto) throws BLException;
	
	/**
	 * ������Ϣ�����ʼ��
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 */
	
	public IGSYM04DTO initReportFileDefinitionAction(IGSYM04DTO dto) throws BLException;
	
	/**
	 * ������Ȩ��Ϣ��ѯ����
	 *
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 */
	public IGSYM04DTO searchRoleReportAction(IGSYM04DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ��ӱ����ɫ
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author 
	 * @update
	 */
	
	public IGSYM04DTO grantRoleReportAction(IGSYM04DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ɾ�������ɫ
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author 
	 * @update
	 */
	
	public void revokeRoleReportAction(IGSYM04DTO dto) throws BLException;
	
	/**
	 * ����汾��Ϣ��ѯ����
	 *
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 */
	public IGSYM04DTO searchReportFileVersionAction(IGSYM04DTO dto) throws BLException;
	
	/**
	 * ������Ȩ��Ϣ��ʼ��
	 * 
	 * @param dto IGSYM14DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 */
	
	public IGSYM04DTO roleReportFileDefinitionAction(IGSYM04DTO dto) throws BLException;
	
	/**
	 * ��Ȩ�û�RRID��ѯ
	 * 
	 * @param dto IGSYM14DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 */
	
	public IGSYM04DTO searchRoleReportRfdidByRoleid(IGSYM04DTO dto) throws BLException;
	
	/**
	 * ���б����ѯ
	 * 
	 * @param dto IGSYM14DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 */
	
	public IGSYM04DTO searchReportFileDefinition(IGSYM04DTO dto) throws BLException;
	
	/**
	 * ͨ����ɫID��ѯ��ɫ��
	 * 
	 * @param dto IGSYM14DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 */
	
	public IGSYM04DTO searchRolenameByRoleId(IGSYM04DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ����ɫIDɾ������
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author 
	 * @update
	 */
	
	public void revokeRoleReportActionByRoleid(IGSYM04DTO dto) throws BLException;

	/**
	 * <p>
	 * Description: ����ɫID��ӱ���
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author 
	 * @update
	 */
	
	public IGSYM04DTO grantRoleReportActionByRoleid(IGSYM04DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ���ݽ�ɫ��ѯ�û�
	 * </p>
	 * 
	 * @return IGSYM04DTO
	 * @author   
	 * @update
	 */
	
	public IGSYM04DTO searchRoleUserByOrg(IGSYM04DTO dto) throws BLException;

	/**
	 * <p>
	 * Description: ��ѯ����������Ϣ
	 * </p>
	 * 
	 * @return IGSYM04DTO
	 * @author   
	 * @update
	 */
	public IGSYM04DTO getProcessInfoAll(IGSYM04DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ���ݽ�ɫ���Ͳ�ѯ�û�����Ҫ��ҳ
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author   
	 */
	
	public IGSYM04DTO searchUserByRoleTypeNoPage(IGSYM04DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ���ݽ�ɫ���Ͳ�ѯ�����ڸý�ɫ���û�
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author   
	 */
	
	public IGSYM04DTO searchUserNoByRoleType(IGSYM04DTO dto) throws BLException;
	

	/**
	 * <p>
	 * Description: ɾ����ɫ�û�
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	public IGSYM04DTO deleteRoleUser(IGSYM04DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ��ӽ�ɫ�û�
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	public IGSYM04DTO saveRoleUser(IGSYM04DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ͨ����ɫid��ѯ��ɫ
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author renxiaodi
	 * @update
	 */
	public IGSYM04DTO searchRoleByRoleId(IGSYM04DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ���ݽ�ɫ���Ͳ�ѯ�����ڸý�ɫ��ͬ���û�
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author   
	 */
	public IGSYM04DTO searchUserNoByRoleTypeSyn(IGSYM04DTO dto) throws BLException;
	
	/** ��Դ����Ȩ Start 2012/11/19 */
	/**
	 * ��ѯͬ���Ľ�ɫ�б�
	 * @return
	 * @throws BLException
	 */
	public IGSYM04DTO searchSYNRoleAction(IGSYM04DTO dto) throws BLException;
	/** ��Դ����Ȩ End */
}
