package com.deliverik.infogovernor.soc.cim.bl;

import java.util.List;

import org.hyperic.hq.hqapi1.types.ResourceResponse;

import main.java.com.dlk.hq.Plateform;

import com.deliverik.framework.base.BaseBL;

public interface IGCIM15BL extends BaseBL{
	
	/**
	 * ����ͬ���߼�
	 * @return
	 * @throws Exception
	 */
	public void init()throws Exception;
	
	/**
	 * �ɼ�
	 * @throws Exception
	 */
	public void execute()throws Exception;
	
	
}
