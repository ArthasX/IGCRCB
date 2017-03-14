package com.deliverik.infogovernor.scheduling.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.scheduling.dto.IGSCH03DTO;
import com.deliverik.infogovernor.scheduling.model.QuartzJobs;
/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务策略_企业定时任务BL
 * </p>
 * 
 * @author maozhipeng@deliverik.com
 * @version 1.0
 */
public interface IGSCH03BL extends BaseBL {
	
	public IGSCH03DTO saveQuartzJobs(IGSCH03DTO dto) throws BLException;
	
	public IGSCH03DTO findRole(IGSCH03DTO dto) throws BLException;
	
	public IGSCH03DTO saveQuartzWorkAction(IGSCH03DTO dto) throws BLException;
	
	public void init(IGSCH03DTO dto) throws BLException;
	
	public IGSCH03DTO getProcessDefinitions(IGSCH03DTO dto) throws BLException;
	
	public IGSCH03DTO getProcessInfoDefs(IGSCH03DTO dto) throws BLException;
	
	public void createEnterpriseTimerJob(QuartzJobs quartzJobs) throws BLException;
}
