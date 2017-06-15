/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.security.UserPermission;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.prm.dto.IGPRM00DTO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̹���_���̷���_ѡ����������ҵ��ӿ�
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public interface IGPRM00BL extends BaseBL {

	/**
	 * ��ѯ��������
	 * @param dto IGPRM00DTO
	 * @return IGPRM00DTO
	 * @throws BLException
	 */
	
	public IGPRM00DTO searchProcessDefinitionAction(IGPRM00DTO dto) throws BLException;
	
	/**
	 * ��ѯ��������
	 * @param dto IGPRM00DTO
	 * @return IGPRM00DTO
	 * @throws BLException
	 */
	public IGPRM00DTO searchProcessDefinition(User user,UserPermission up,IGPRM00DTO dto) throws BLException;
	
	/**
	 * ��ѯ��������
	 * @param dto IGPRM00DTO
	 * @return IGPRM00DTO
	 * @throws BLException
	 */
	
	public IGPRM00DTO searchWorkDefinitionAction(IGPRM00DTO dto) throws BLException;
	
	/**
	 * ��ѯ��������
	 * @param dto IGPRM00DTO
	 * @return IGPRM00DTO
	 * @throws BLException
	 */
	
	public IGPRM00DTO searchWorkDefinitionTreeAction(IGPRM00DTO dto) throws BLException;
	
	/**
	 * <p>
	 * ��ѯ�ɿ�ݷ�����������
	 * </p>
	 * 
	 * @param dto IGPRM00DTO
	 * @return IGPRM00DTO
	 * @throws BLException
	 */
	
	public IGPRM00DTO searchQuickProcessDefinitionAction(IGPRM00DTO dto) throws BLException, SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException;
	
	/**
     * <p>
     * ��ѯ���̶�������ط���ť����Ŀɷ�����������
     * </p>
     * 
     * @param dto IGPRM00DTO
     * @return IGPRM00DTO
     * @throws BLException
     * @throws NoSuchFieldException 
     * @throws SecurityException 
     * @throws IllegalAccessException 
     * @throws IllegalArgumentException 
     */
    
    public IGPRM00DTO searchRelevantProcessAction(IGPRM00DTO dto) throws BLException	;
}
