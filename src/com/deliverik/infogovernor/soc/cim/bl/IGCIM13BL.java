package com.deliverik.infogovernor.soc.cim.bl;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.CicollecttaskInfo;
import com.deliverik.framework.soc.asset.model.Timer01Info;
import com.deliverik.framework.soc.asset.model.Timer02Info;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM13DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0806Form;

public interface IGCIM13BL extends BaseBL{
	
	/**
	 * CI采集定时任务查询处理
	 * @param dto
	 * @return
	 */
	public IGCIM13DTO getCICollectTimerTaskList(IGCIM13DTO dto);
	
	/**
	 * 数据同步逻辑
	 * @return
	 * @throws Exception
	 */
	public String init()throws Exception;
	
	/**
	 * 通过server类型获取该类型下的server的resouceid集合
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public List<Integer> findResourceidByType(int type) throws Exception;
	
	public List<CicollecttaskInfo> findAllByCollectType(String collectType) throws Exception;
	
	/**
	 * 获取xml配置文件的server类型名集合
	 * @return
	 */
	public List<String> getRealtimeTypeNames();
	
	public IGCIM13DTO getHistoryTaskListByType(IGCIM13DTO dto);
	
	public String editCollect(IGCIM0806Form igcim0806Form);
	
	public Timer01Info getTimer01ByUuid(String uuid)throws Exception;
	
	public void updateTimer01(Timer01Info timer01)throws Exception;
	
	public void addTimer02(Timer02Info instance)throws Exception;
}
