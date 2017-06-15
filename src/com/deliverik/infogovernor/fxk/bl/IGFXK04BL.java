/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.fxk.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.fxk.dto.IGFXK04DTO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��������BL�ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IGFXK04BL extends BaseBL{

	/**
	 * ģ������ѯ
	 * @param dto
	 * @return
	 */
	public IGFXK04DTO searchAsmModelTree(IGFXK04DTO dto) throws BLException;

	/**
	 * ���յ��ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGFXK04DTO searchAsm013Action(IGFXK04DTO dto) throws BLException;

	/**
	 * ������ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGFXK04DTO searchAsm014Action(IGFXK04DTO dto) throws BLException;

	/**
	 * ��ѯ��ط����嵥
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGFXK04DTO getRelationProcess(IGFXK04DTO dto) throws BLException;
	
	/**
	 * ģ������ѯZTree
	 * @param dto
	 * @return
	 */
	public String searchAsmModelZTree(IGFXK04DTO dto) throws BLException;
	
}
