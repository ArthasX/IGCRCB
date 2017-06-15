package com.deliverik.infogovernor.scheduling.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.entity.Timer01TB;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.infogovernor.scheduling.dto.IGSCH02DTO;
import com.deliverik.infogovernor.scheduling.dto.IGSCH03DTO;
import com.deliverik.infogovernor.scheduling.model.QuartzJobs;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM13BL;

public interface IGSCH02BL extends BaseBL {
	
	public void saveQuartzJobs(IGSCH02DTO dto) throws BLException;
	
	public void saveQuartzWorkAction(IGSCH02DTO dto) throws BLException;
	
	public void init(IGSCH02DTO dto) throws BLException;
	
	public String getPeriodInfo(String periodType, String CustomDate, 
			String exeHour, String exeMinute,String startDate);
	
	public IGSCH02DTO getProcessDefinitions(IGSCH02DTO dto) throws BLException;
	
	public IGSCH02DTO getProcessInfoDefs(IGSCH02DTO dto) throws BLException;
	
	public void createPersonJobs(QuartzJobs quartzJobs) throws BLException;
	
	/**
	 * 根据传入参数决定调用哪个BL完成服务策略的自动发起工作任务
	 * @param dto02
	 * @param dto03
	 * @throws BLException
	 */
	public  void initByWorkType(IGSCH02DTO dto02,IGSCH03DTO dto03) throws BLException;
	
	public Timer01TB getTimer01(String uuid) throws Exception;
	
	public IGCIM13BL getIgcim13BL();
	
	public CodeListUtils getCodeListUtils()throws Exception;
	
	public void updateTimer01(Timer01TB timer01TB) throws Exception;
	
}
