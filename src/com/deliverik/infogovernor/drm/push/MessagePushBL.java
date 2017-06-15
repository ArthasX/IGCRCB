package com.deliverik.infogovernor.drm.push;

import org.apache.mina.core.service.IoHandler;

import com.deliverik.framework.base.BLException;
/**
 * 
 * @ClassName: FlexMessagePushBL 
 * @Description: TODO 通过Mina向Flex 推送信息
 * @author wangyaowen@Deliverik.com 
 * @date 2015-3-5 下午2:38:51 
 *
 */
public interface MessagePushBL extends IoHandler {
    /**
     * 
     * @Title: pushMessage 
     * @Description: 通过Mina向Flex 推送信息
     * @param prid 应急指挥deshboard id
     * @param message 信息，一般为 json
     * @return
     * @throws BLException    
     * boolean    
     * @throws
     */
	public boolean pushMessage(String prid,String message)throws BLException;
}