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
	 * ��ȡsocDAO  
	 * @return socDAO 
	 */
	public SocDAO getSocDAO() {
		return socDAO;
	}

	/**  
	 * ����socDAO  
	 * @param socDAO
	 */
	
	public void setSocDAO(SocDAO socDAO) {
		this.socDAO = socDAO;
	}

	/**
	 * ͨ��prid��ѯ�����Ķ���ID
	 */
	public String searchFlowPidid(Integer prid) {
		String pidid = socDAO.searchFlowPidid(prid);
		return pidid;
	}

}
