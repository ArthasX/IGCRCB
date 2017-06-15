/**   
* @Title: IGVen01BL.java 
* @Package com.deliverik.infogovernor.ven.bl 
* @Description: TODO
* @author wangyaowen@Deliverik.com 
* @date 2014-12-1 上午10:55:23 
* @version V1.0   
*/
package com.deliverik.infogovernor.ven.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.risk.dto.IGRIS02DTO;
import com.deliverik.infogovernor.ven.dto.IGVEN02DTO;

//尉 BL
public interface IGVEN02BL extends BaseBL {
	
	/**	
	 * 功能：风险监测查询
	 * @param dto
	 * @return
	 * @throws BLException
	 * 修改记录：null
	 */	
	public IGVEN02DTO searchRiskMonitoringAction(IGVEN02DTO dto) throws BLException;
	
	/**	
	 * 功能：风险监测工作查询
	 * @param dto
	 * @return
	 * @throws BLException
	 * 修改记录：null 	
	 */	
	public IGVEN02DTO initIGVEN0202Action(IGVEN02DTO dto) throws BLException;
	
	/**	
	 * 功能：风险检查结果保存
	 * @param dto
	 * @return
	 * @throws BLException
	 * 修改记录：null 	
	 */	
	public IGVEN02DTO insertMonitoringWorkAction(IGVEN02DTO dto) throws BLException;
}
