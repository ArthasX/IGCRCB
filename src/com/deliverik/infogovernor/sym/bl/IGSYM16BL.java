package com.deliverik.infogovernor.sym.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sym.dto.IGSYM16DTO;

/**
 * �������ݹ���ҵ���߼��ӿ�
 *
 * 
 */
public interface IGSYM16BL extends BaseBL {

	/**
	 * <p>
	 * ��ѯ������Ϣ��
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	public IGSYM16DTO searchCodeTreeAction(IGSYM16DTO dto) throws BLException;

	/**
	 * <p>
	 * ��ѯentity��
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	public IGSYM16DTO searchEntityTreeAction(IGSYM16DTO dto) throws BLException;
	
	/**
	 * <p>
	 * ��ѯ1����㲻��ѡ��������Ϣ��
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public IGSYM16DTO searchSpecialCodeTreeAction(IGSYM16DTO dto) throws BLException;
	
	/**
	 * <p>
	 * ��ѯ1����㲻��ѡ������״̬Ϊ���õ�������Ϣ��
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public IGSYM16DTO searchSpecialCodeTreeByCdStatusAction(IGSYM16DTO dto) throws BLException;
	
	/**
	 * <p>
	 * ��ѯEntitiy����ָ��1����㣩
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public IGSYM16DTO searchEntityTreeByLevelAction(IGSYM16DTO dto) throws BLException;
}
