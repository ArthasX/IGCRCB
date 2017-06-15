/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sym.dto.IGSYM20DTO;
import com.deliverik.infogovernor.sym.model.MSGFILTERInfo;


public interface IGSYM20BL extends BaseBL {

	public IGSYM20DTO searchIPInfoAction(IGSYM20DTO dto) throws BLException;
	public boolean checkSearchCount(IGSYM20DTO dto);
	public void deleteTB(MSGFILTERInfo msgfilterinfo) throws BLException;
	public void deleteByPK(IGSYM20DTO dto) throws BLException;
	public IGSYM20DTO insertInfo(IGSYM20DTO dto) throws BLException;
	public IGSYM20DTO updateInfo(IGSYM20DTO dto) throws BLException;
	public IGSYM20DTO changeTempstate(IGSYM20DTO dto) throws BLException;
	
}
