/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.push.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import nl.justobjects.pushlet.util.Log;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.LogFactory;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.infogovernor.drm.push.MessagePushBL;

public class MINAServer {
    private final org.apache.commons.logging.Log log = LogFactory.getLog(MINAServer.class);  //��־�ļ�
	protected boolean serverStatus = false; //������״̬ false = δ����; true = ������;��sprint�й�
	protected IoAcceptor ioAcceptor = null; //Socket����
	public static String port;
	protected MessagePushBL messagePushBL; //������
	protected CodeListUtils codeListUtils;
	

    public void setCodeListUtils(CodeListUtils codeListUtils) {
        this.codeListUtils = codeListUtils;
    }

    public boolean isServerStatus() {
        return serverStatus;
    }

    public void setServerStatus(boolean serverStatus) {
        this.serverStatus = serverStatus;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
    	MINAServer.port = port;
    }


    public IoAcceptor getIoAcceptor() {
        return ioAcceptor;
    }

    public void setIoAcceptor(IoAcceptor ioAcceptor) {
        this.ioAcceptor = ioAcceptor;
    }

    



    public void setMessagePushBL(MessagePushBL messagePushBL) {
		this.messagePushBL = messagePushBL;
	}

	/***
     * ��ʼ��������spring�Զ�����
	 * ����SOCKET ����
	 * @return 0 = �����ɹ�,1 = ����ʧ��
	 */
	public void createSession(){
	    log.info("=========mina������ʼ===========");
	    String portcc = codeListUtils.getCodeValue("174",null, null, "1");
	    
	    if(StringUtils.isNotBlank(portcc)){
	        port=portcc;
	    }
		ioAcceptor = new NioSocketAcceptor();
		ioAcceptor.getFilterChain().addLast("logger", new LoggingFilter() );
		TextLineCodecFactory lineCodec = new TextLineCodecFactory(Charset.forName("UTF-8"),LineDelimiter.NUL,LineDelimiter.NUL);
		lineCodec.setDecoderMaxLineLength(1024*1024);
		lineCodec.setEncoderMaxLineLength(1024*1024);
		ioAcceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(lineCodec));
		ioAcceptor.setHandler(messagePushBL); //�������������
		ioAcceptor.getSessionConfig().setReadBufferSize(4096);
		try {
			ioAcceptor.bind(new InetSocketAddress(Integer.valueOf(port)));  //�󶨶˿�
			serverStatus = true;
		} catch (IOException e) {
			serverStatus = false;
			Log.error("����SOCKETʧ��, �˿ں�="+port,e);
		}
		log.info("=========mina������� �Ƿ�ɹ���"+serverStatus+"===========");
	}
	
	
	/***
	 * ���ٷ���
	 */
	public void destroy() {
		serverStatus = false;
		//��������
		if(ioAcceptor!=null){
			ioAcceptor.unbind();
			ioAcceptor.dispose();
		}
	}
}
