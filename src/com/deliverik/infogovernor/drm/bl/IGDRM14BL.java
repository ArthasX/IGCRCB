/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.drm.bl;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.infogovernor.drm.dto.IGDRM14DTO;

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

public interface IGDRM14BL extends BaseBL {
	
	
	/**
	 * <p>
	 * Description: ȡ����Ҫ������ʾ��֪ͨ��Ϣ
	 * </p>
	 * 
	 * @param dto IGDRM14DTO
	 * @return IGDRM14DTO
	 * @throws BLException
	 * @author duchong@deliverik.com
	 * @update
	 */
	public IGDRM14DTO getNoticeInfo(IGDRM14DTO dto) throws BLException ;
	/**
	 * <p>
	 * Description: ֪ͨ��ѯ
	 * </p>
	 * 
	 * @param dto IGDRM14DTO
	 * @return IGDRM14DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGDRM14DTO searchNoticeAction(IGDRM14DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ֪ͨ��ѯ
	 * </p>
	 * 
	 * @param dto IGDRM14DTO
	 * @return IGDRM14DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGDRM14DTO searchPageNoticeAction(IGDRM14DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ֪ͨɾ��
	 * </p>
	 * 
	 * @param dto IGDRM14DTO
	 * @return IGDRM14DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGDRM14DTO deleteNoticeAction(IGDRM14DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ֪ͨ����
	 * </p>
	 * 
	 * @param dto IGDRM14DTO
	 * @return IGDRM14DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGDRM14DTO insertNoticeAction(IGDRM14DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ֪ͨ�����ʼ��
	 * </p>
	 * 
	 * @param dto IGDRM14DTO
	 * @return IGDRM14DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGDRM14DTO initIGDRM1402Action(IGDRM14DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ֪ͨ���
	 * </p>
	 * 
	 * @param dto IGDRM14DTO
	 * @return IGDRM14DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGDRM14DTO updateNoticeAction(IGDRM14DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: ֪ͨ������ѯ
	 * </p>
	 * 
	 * @param dto IGDRM14DTO
	 * @return IGDRM14DTO
	 * @throws BLException
	 * @author tangxiaona@deliverik.com
	 * @update
	 */
	
	public IGDRM14DTO searchNoticeDetail(IGDRM14DTO dto) throws BLException;
	public IGDRM14DTO searchDateWorkAction(String userid) throws BLException;
	public IGDRM14DTO searchDateWorkAction(String userid, List<UserRoleInfo> list) throws BLException;
	public IGDRM14DTO searchDateWorkAction(String userid, List<UserRoleInfo> list, String temp) throws BLException;
	
	public IGDRM14DTO searchDateWorkAction(String date, String userid) throws BLException;
	public IGDRM14DTO searchDateWorkAction(String date, String userid, List<UserRoleInfo> list) throws BLException;
	public IGDRM14DTO searchDateWorkAction(String date, String userid, List<UserRoleInfo> list, String temp) throws BLException;
}
