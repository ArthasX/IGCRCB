/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.bl;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.infogovernor.sym.dto.IGSYM05DTO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_֪ͨ����_BL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public interface IGSYM05BL extends BaseBL {
	
	
	/**
	 * <p>
	 * Description: ȡ����Ҫ������ʾ��֪ͨ��Ϣ
	 * </p>
	 * 
	 * @param dto IGSYM05DTO
	 * @return IGSYM05DTO
	 * @throws BLException
	 * @author duchong@deliverik.com
	 * @update
	 */
	public IGSYM05DTO getNoticeInfo(IGSYM05DTO dto) throws BLException ;
	/**
	 * <p>
	 * Description: ֪ͨ��ѯ
	 * </p>
	 * 
	 * @param dto IGSYM05DTO
	 * @return IGSYM05DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM05DTO searchNoticeAction(IGSYM05DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ֪ͨɾ��
	 * </p>
	 * 
	 * @param dto IGSYM05DTO
	 * @return IGSYM05DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM05DTO deleteNoticeAction(IGSYM05DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ֪ͨ����
	 * </p>
	 * 
	 * @param dto IGSYM05DTO
	 * @return IGSYM05DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM05DTO insertNoticeAction(IGSYM05DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ֪ͨ�����ʼ��
	 * </p>
	 * 
	 * @param dto IGSYM05DTO
	 * @return IGSYM05DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM05DTO initIGSYM0502Action(IGSYM05DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ֪ͨ���
	 * </p>
	 * 
	 * @param dto IGSYM05DTO
	 * @return IGSYM05DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM05DTO updateNoticeAction(IGSYM05DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: ֪ͨ������ѯ
	 * </p>
	 * 
	 * @param dto IGSYM05DTO
	 * @return IGSYM05DTO
	 * @throws BLException
	 * @author tangxiaona@deliverik.com
	 * @update
	 */
	
	public IGSYM05DTO searchNoticeDetail(IGSYM05DTO dto) throws BLException;
	public IGSYM05DTO searchDateWorkAction(String userid) throws BLException;
	public IGSYM05DTO searchDateWorkAction(String userid, List<UserRoleInfo> list) throws BLException;
	public IGSYM05DTO searchDateWorkAction(String userid, List<UserRoleInfo> list, String temp) throws BLException;
	
	public IGSYM05DTO searchDateWorkAction(String date, String userid) throws BLException;
	public IGSYM05DTO searchDateWorkAction(String date, String userid, List<UserRoleInfo> list) throws BLException;
	public IGSYM05DTO searchDateWorkAction(String date, String userid, List<UserRoleInfo> list, String temp) throws BLException;
}
