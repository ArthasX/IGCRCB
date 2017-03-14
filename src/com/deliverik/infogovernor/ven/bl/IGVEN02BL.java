/**   
* @Title: IGVen01BL.java 
* @Package com.deliverik.infogovernor.ven.bl 
* @Description: TODO
* @author wangyaowen@Deliverik.com 
* @date 2014-12-1 ����10:55:23 
* @version V1.0   
*/
package com.deliverik.infogovernor.ven.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.risk.dto.IGRIS02DTO;
import com.deliverik.infogovernor.ven.dto.IGVEN02DTO;

//ξ BL
public interface IGVEN02BL extends BaseBL {
	
	/**	
	 * ���ܣ����ռ���ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 * �޸ļ�¼��null
	 */	
	public IGVEN02DTO searchRiskMonitoringAction(IGVEN02DTO dto) throws BLException;
	
	/**	
	 * ���ܣ����ռ�⹤����ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 * �޸ļ�¼��null 	
	 */	
	public IGVEN02DTO initIGVEN0202Action(IGVEN02DTO dto) throws BLException;
	
	/**	
	 * ���ܣ����ռ��������
	 * @param dto
	 * @return
	 * @throws BLException
	 * �޸ļ�¼��null 	
	 */	
	public IGVEN02DTO insertMonitoringWorkAction(IGVEN02DTO dto) throws BLException;
}
