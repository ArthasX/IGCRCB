 /*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.room.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

/**
 * @Description: java���ýű�������
 * 
 * @Author	yangyining;wangfeng;
 * @History 2013-05-29     �½� 
 * @Version V1.0
 */
public class ExecScriptUtil {

    /** �ɹ� */
	public static final int RETURNVALUE_SUCCESS = 0;

    /** ʧ�� */
	public static final int RETURNVALUE_FILE = 1;

    /** ���з� */
    private final String LINE_SEPARATOR = System.getProperty("line.separator");
    
    /** ִ�к���־�ļ���Ŀ¼ */
    private String execLogPath = "";
    
    /**
     * ִ����������Ľű�
     * 
     * @param command	��Ҫִ�е�����
     * @return
     * @throws Exception
     */
    public int exec(String command) throws Exception {
        
        int successFlag = RETURNVALUE_SUCCESS;

        StringBuffer stringBuffer = new StringBuffer();
        
        // �����ַ���
        BufferedReader bufferedReader = null;
        try {
            
            appendMessage(stringBuffer, "׼��ִ��Shell����", command);

            // ������Ϣ
            Process process = null;
            // ����
            String[] envp = {"/bin/sh", "-c", "export PATH=$PATH:/usr/local/swftools/bin/"};
            
            if ("\\".equals(File.separator)) {
            	envp = new String[]{"cmd", "/c"};
    		}
            
            // ִ��Shell����
            process = Runtime.getRuntime().exec(command, envp);
            
            // �жϽ����Ƿ����
            if (process != null) {
                
                appendMessage(stringBuffer, "���̺ţ�" + process.toString());
                
                // bufferedReader���ڶ�ȡShell���������
                bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()), 1024);
                
                // �ȴ��ӽ���ִ�н���
                process.waitFor();
                
                appendMessage(stringBuffer, "Shell����ִ�����\r\nִ�н��Ϊ��");
                
                String line = null;
                // ��ȡShell��������ݣ�����ӵ�stringBuffer��
                while (bufferedReader != null && (line = bufferedReader.readLine()) != null) {
                    
                    appendMessage(stringBuffer, line);
                    
                    // �ж��ڽű�ִ�еĹ������Ƿ�����쳣
                    if ("error".equals(line)) {
                        appendMessage(stringBuffer, "Shell�ű�ִ�й��̳����쳣");
                        successFlag = RETURNVALUE_FILE;
                        break;
                    }
                }
            } else {
                appendMessage(stringBuffer, "û��pid");
                successFlag = RETURNVALUE_FILE;
            }
        } catch (Exception ioe) {
            appendMessage(stringBuffer, "ִ��Shell����ʱ�����쳣��", ioe.getMessage());
            successFlag = RETURNVALUE_FILE;
        } finally {
            if (stringBuffer != null && StringUtils.isNotEmpty(execLogPath)) {
                
                OutputStreamWriter outputStreamWriter = null;
                try {
                    // �رջ�����
                    if (null != bufferedReader) {
                        bufferedReader.close();
                    }
                    // ��Shell��ִ�����׷�ӵ���־�ļ���
                    OutputStream outputStream = new FileOutputStream(execLogPath + File.separator + "exec.log", true);
                    outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
                    outputStreamWriter.write(stringBuffer.toString());

                } catch (Exception e) {
                    throw new Exception("�����־�ļ��쳣", e);
                } finally {
                    if (null != outputStreamWriter) {
                        outputStreamWriter.close();
                    }
                }
            }
        }
        return successFlag;
    }
    
    /**
     * ƴд��Ϣ
     * 
     * @param stringBuffer	ƴдĿ��
     * @param comment		ƴд����
     */
    private void appendMessage(StringBuffer stringBuffer, String... comment) {
    	
    	if (!"".equals(execLogPath)) {
    		
			stringBuffer.append(getDateTime()).append("  ");
			
			for (int i = 0; i < comment.length; i++) {
				
				if (comment[i] != null) {
					stringBuffer.append(comment[i]).append(LINE_SEPARATOR);
				}
			}
    	}
	}
    
    /**
     * ȡ��ʱ��
     * 
     * @return datetime
     */
    private String getDateTime(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date());
    }

	/**
	 * ִ�к���־�ļ���Ŀ¼ȡ��
	 *
	 * @return execLogPath ִ�к���־�ļ���Ŀ¼
	 */
	public String getExecLogPath() {
		return execLogPath;
	}

	/**
	 * ִ�к���־�ļ���Ŀ¼�趨
	 *
	 * @param execLogPath ִ�к���־�ļ���Ŀ¼
	 */
	public void setExecLogPath(String execLogPath) {
		this.execLogPath = execLogPath;
	}
}
