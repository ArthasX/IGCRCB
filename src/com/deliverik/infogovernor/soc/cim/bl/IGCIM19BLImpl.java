package com.deliverik.infogovernor.soc.cim.bl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.util.FilesUtil;

public class IGCIM19BLImpl  extends BaseBLImpl implements IGCIM19BL{
	
	static Log log = LogFactory.getLog(IGCIM19BLImpl.class);
	
	public String execut() throws Exception {
		
		String message = "";
		
		try{
			String batPath = ResourceUtility.getString("CI_RELATION_BAT_PATH");
			
			if(batPath==null || !batPath.contains(".bat")){
				message = "IGCIM0809.E001";
				return message;
			}
			if(FilesUtil.isOlder(batPath, System.currentTimeMillis())){
				Runtime.getRuntime().exec("cmd /c start " + batPath);
				message = "IGCIM0809.E002";
			}else{
				message = "IGCIM0809.E003";
			}
		}catch(Exception e){
			log.error(e);
			message = "IGCIM0809.E004";
		}

		return message;
	}
}
