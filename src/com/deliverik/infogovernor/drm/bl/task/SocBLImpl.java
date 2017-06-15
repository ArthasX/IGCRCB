/**
 * 
 */
package com.deliverik.infogovernor.drm.bl.task;

import com.deliverik.infogovernor.drm.model.dao.SocDAO;

/**
 * @author Administrator
 *
 */
public class SocBLImpl implements SocBL {
	private SocDAO socDAO;
	
	/**  
	 * 获取socDAO  
	 * @return socDAO 
	 */
	public SocDAO getSocDAO() {
		return socDAO;
	}

	/**  
	 * 设置socDAO  
	 * @param socDAO
	 */
	
	public void setSocDAO(SocDAO socDAO) {
		this.socDAO = socDAO;
	}

	/**
	 * 通过prid查询场景的定义ID
	 */
	public String searchFlowPidid(Integer prid) {
		String pidid = socDAO.searchFlowPidid(prid);
		return pidid;
	}

}
