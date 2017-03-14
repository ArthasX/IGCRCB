/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.mtp.bl;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_��������
 * </p>
 * 
 * @version 1.0
 */

public class IGMTP01BLType {
	/*------------------����״̬------------------*/

	/** �ȴ����� */
	public static final String PROCESS_STATUS_WAITING_ASSIGNEE = "P";
	/** �ȴ���� */
	public static final String PROCESS_STATUS_WAITING_VERIFY = "V";
	/** �ȴ����� */
	public static final String PROCESS_STATUS_WAITING_IMPLEMENT = "E";
	

	/*------------------���̲�����״̬------------------*/
	
	/** ��� */
	public static final String PARTICIPANT_STATUS_VERIFY = "V";
	/** ����*/
	public static final String PARTICIPANT_STATUS_DISPATCHER = "P";
	/** ���� */
	public static final String PARTICIPANT_STATUS_INITIAL = "I";
	/** ���� */
	public static final String PARTICIPANT_STATUS_IMPLEMENT = "E";
	
	/*------------------�����û���������------------------*/
	
	public static final String PARTICIPANT_TYPE = "P";
	
	
	/** ��������(ָ�ɹ���)*/
	public static final String PROCESS_ENTERPRISE_TYPE = "WA";
	
	public static final String PROCESS_ENTERPRISE_NAME = "ָ�ɹ���";
	
	/** ��������(���˹���)*/
	public static final String PROCESS_PERSON_TYPE = "WB";
	
	public static final String PROCESS_PERSON_NAME = "���˹���";
	
	/** ��������(�Զ��幤��)*/
	public static final String PROCESS_USERDEFINED_TYPE = "WD";
	
	public static final String PROCESS_USERDEFINED_NAME = "�Զ��幤��";
	
	/*------------------�ճ���ά�ƻ�ִ��״̬------------------*/
	/** �ƻ���ִ��*/
	public static final String JOB_TYPE_EXECUTION = "1";
	
	/** �ƻ�δִ��*/
	public static final String JOB_TYPE_UNEXECUTION = "0";

	
	/**
	 * make a key for Trigger
 	 *
	 * @param  String
	 * @return String 
	 */
	private static SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    private static NumberFormat nf = NumberFormat.getInstance(Locale.CHINA);
    static{
        //������С����λ
        nf.setMinimumIntegerDigits(4);
        nf.setGroupingUsed(false);
    }
    private static long postfix = 0;//�������4λ
	public static synchronized String getTriggerKey(){
		String id="";
		Date date=new Date();
		id=df.format(date);
		 
		if(postfix==9999l){
		    postfix = 0;
		}else{
		    postfix++;
		}
		
		return id+nf.format(postfix);//������strΪ21λ
		
	}
	
	public static void main(String[] args){
		//System.out.println(getTriggerKey());
		
		//String time = IGStringUtils.getCurrentDateTime();//��ǰʱ��
		System.out.println("2010/10/24".compareTo("2010/10/23"));
	}
	
}
