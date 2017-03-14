package com.deliverik.infogovernor.soc.cim.bl;

import java.util.List;

import org.hyperic.hq.hqapi1.types.ResourceResponse;

import main.java.com.dlk.hq.Plateform;

import com.deliverik.framework.base.BaseBL;

public interface IGCIM15BL extends BaseBL{
	
	/**
	 * 数据同步逻辑
	 * @return
	 * @throws Exception
	 */
	public void init()throws Exception;
	
	/**
	 * 采集
	 * @throws Exception
	 */
	public void execute()throws Exception;
	
	
}
