package com.deliverik.infogovernor.fxk.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.fxk.dto.IGFXK03DTO;
/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��������BL�ӿ�
 * </p>
 * 
 * @author fenghuan@deliverik.com
 * @version 1.0
 */
public interface IGFXK03BL extends BaseBL {
	/**
	 * ���ռƻ���ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGFXK03DTO searchRiskproAction(IGFXK03DTO dto) throws BLException;
	public IGFXK03DTO searchLableValueAction(IGFXK03DTO dto) throws BLException ;
	/**
	 * �ƻ������޸�֮ǰ��ѯ
	 */
	public IGFXK03DTO searchFXK0302FormAction(IGFXK03DTO dto) throws BLException;
	/**
	 * �ƻ������޸�
	 */
	public IGFXK03DTO editFXK0302FormAction(IGFXK03DTO dto) throws BLException; 
	/**
	 * 
	* @Title: searchUserLabelValueBean 
	* @Description: TODO ��ѯ�����������б�
	* @param dto
	* @return
	* @throws BLException    
	* IGFXK03DTO    
	* @throws
	 */
	public IGFXK03DTO searchUserLabelValueBean(IGFXK03DTO dto) throws BLException;
}
