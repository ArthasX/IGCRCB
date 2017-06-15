package com.deliverik.infogovernor.soc.cim.bl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hyperic.hq.hqapi1.HQApi;
import org.hyperic.hq.hqapi1.types.Resource;
import org.hyperic.hq.hqapi1.types.ResourceResponse;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.soc.asset.bl.task.CicollecttaskBL;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.infogovernor.util.HQUtil;

public class IGCIM15BLImpl extends BaseBLImpl implements IGCIM15BL {

	HQApi hqapi;
	protected CicollecttaskBL cicollecttaskBL;
	private static Log log = LogFactory.getLog(IGCIM15BLImpl.class);

	/**
	 * init
	 * 
	 */
	public void init() throws Exception {
		CodeListUtils codeListUtils = this.getCodeListUtils();
		hqapi = HQUtil.getHQApi(codeListUtils);
	}

	/**
	 * get CodeList Utils
	 * 
	 * @return
	 * @throws Exception
	 */
	private CodeListUtils getCodeListUtils() throws Exception {
		CodeListUtils codeListUtils = (CodeListUtils) WebApplicationSupport
				.getBean("codeListUtils");
		return codeListUtils;
	}

	/**
	 * execute
	 */
	public void execute() throws Exception {
		synchronized(this){
			List<String> plateformNameList = cicollecttaskBL.getHQPlateformNameList();
			List<ResourceResponse> plateformList = HQUtil.getHQPlateforms(
					plateformNameList, hqapi);
			
			if (plateformList == null || plateformList.size() == 0) {
				return;
			}
			for (ResourceResponse plateform : plateformList) {
				List<Resource> serverList = HQUtil
						.getHQServerListByPlateform(plateform);
				for (Resource server : serverList) {
					HQUtil.openMetric(server, hqapi);
				}
			}
		}
	}

	public void setCicollecttaskBL(CicollecttaskBL cicollecttaskBL) {
		this.cicollecttaskBL = cicollecttaskBL;
	}

}
