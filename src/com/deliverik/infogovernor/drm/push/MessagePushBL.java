package com.deliverik.infogovernor.drm.push;

import org.apache.mina.core.service.IoHandler;

import com.deliverik.framework.base.BLException;
/**
 * 
 * @ClassName: FlexMessagePushBL 
 * @Description: TODO ͨ��Mina��Flex ������Ϣ
 * @author wangyaowen@Deliverik.com 
 * @date 2015-3-5 ����2:38:51 
 *
 */
public interface MessagePushBL extends IoHandler {
    /**
     * 
     * @Title: pushMessage 
     * @Description: ͨ��Mina��Flex ������Ϣ
     * @param prid Ӧ��ָ��deshboard id
     * @param message ��Ϣ��һ��Ϊ json
     * @return
     * @throws BLException    
     * boolean    
     * @throws
     */
	public boolean pushMessage(String prid,String message)throws BLException;
}