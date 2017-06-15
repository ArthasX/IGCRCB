/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.crc.vo;

import java.io.Serializable;
import java.text.NumberFormat;

import com.deliverik.framework.base.BaseVO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description:�¼�ƽ�����ʱ��VO 
 * </p>
 * 
 * @version 1.0
 */

public class IGCRC2402VO extends BaseVO implements Serializable{

	public IGCRC2402VO() {
		super();
	}
	
	public IGCRC2402VO(IGCRC2402VO timeSum, String userId, String name) {
		super();
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(1);
		this.userId = userId;
		this.name = name;
		//����ƽ��ʱ�����±��浽������
		if(timeSum.getGrade1Count() > 0){
			this.grade1Str = nf.format(timeSum.getGrade1()/new Double(timeSum.getGrade1Count()));
		}else{
			this.grade1Str = "0";
		}
		if(timeSum.getGrade2Count() > 0){
			this.grade2Str = nf.format(timeSum.getGrade2()/new Double(timeSum.getGrade2Count()));
		}else{
			this.grade2Str = "0";
		}
		if(timeSum.getGrade3Count() > 0){
			this.grade3Str = nf.format(timeSum.getGrade3()/new Double(timeSum.getGrade3Count()));
		}else{
			this.grade3Str = "0";
		}
		if(timeSum.getGrade4Count() > 0){
			this.grade4Str = nf.format(timeSum.getGrade4()/new Double(timeSum.getGrade4Count()));
		}else{
			this.grade4Str = "0"; 
		}
		if(timeSum.getGrade5Count() > 0){
			this.grade5Str = nf.format(timeSum.getGrade5()/new Double(timeSum.getGrade5Count()));
		}else{
			this.grade5Str = "0";
		}
		if(timeSum.getGrade6Count() > 0){
			this.grade6Str = nf.format(timeSum.getGrade6()/new Double(timeSum.getGrade6Count()));
		}else{
			this.grade6Str = "0";
		}
		if(timeSum.getGrade7Count() > 0){
			this.grade7Str = nf.format(timeSum.getGrade7()/new Double(timeSum.getGrade7Count()));
		}else{
			this.grade7Str = "0";
		}
		if(timeSum.getGrade8Count() > 0){
			this.grade8Str = nf.format(timeSum.getGrade8()/new Double(timeSum.getGrade8Count()));
		}else{
			this.grade8Str = "0";
		}
		this.pridNUM = timeSum.getPridNUM();
		this.prid_In = timeSum.getPrid_In();
	}
	/**   */	
	
	private static final long serialVersionUID = 1L;
	
	/** ��������*/
	protected Integer pridNUM;
	/** ������������*/
	protected String prid_In;
	/** id */
	protected String userId;
	/** ���� */
	protected String name;
	/** �¼�����1 */
	protected String grade1Str;
	/** �¼�����2 */
	protected String grade2Str;
	/** �¼�����3 */
	protected String grade3Str;
	/** �¼�����4 */
	protected String grade4Str;
	/** �¼�����5 */
	protected String grade5Str;
	/** �¼�����6 */
	protected String grade6Str;
	/** �¼�����7 */
	protected String grade7Str;
	/** �¼�����8*/
	protected String grade8Str;
	
	
	/** �¼�����1 */
	protected long grade1;
	/** �¼�����2 */
	protected long grade2;
	/** �¼�����3 */
	protected long grade3;
	/** �¼�����4 */
	protected long grade4;
	/** �¼�����5 */
	protected long grade5;
	/** �¼�����6 */
	protected long grade6;
	/** �¼�����7 */
	protected long grade7;
	/** �¼�����8*/
	protected long grade8;
	
	/** �¼�����1 ����*/
	protected int grade1Count;
	/** �¼�����2 ����*/
	protected int grade2Count;
	/** �¼�����3 ����*/
	protected int grade3Count;
	/** �¼�����4 ����*/
	protected int grade4Count;
	/** �¼�����5 ����*/
	protected int grade5Count;
	/** �¼�����6 ����*/
	protected int grade6Count;
	/** �¼�����7 ����*/
	protected int grade7Count;
	/** �¼�����8 ����*/
	protected int grade8Count;
	/**
	 * ����ȡ��
	 * @return name  ����
	 */
	public String getName() {
		return name;
	}
	/**
	 * �����趨
	 * @param name  ����
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * �¼�����1ȡ��
	 * @return grade1  �¼�����1
	 */
	public long getGrade1() {
		return grade1;
	}
	/**
	 * �¼�����1�趨
	 * @param grade1  �¼�����1
	 */
	public void setGrade1(long grade1) {
		this.grade1 = grade1;
	}
	/**
	 * �¼�����2ȡ��
	 * @return grade2  �¼�����2
	 */
	public long getGrade2() {
		return grade2;
	}
	/**
	 * �¼�����2�趨
	 * @param grade2  �¼�����2
	 */
	public void setGrade2(long grade2) {
		this.grade2 = grade2;
	}
	/**
	 * �¼�����3ȡ��
	 * @return grade3  �¼�����3
	 */
	public long getGrade3() {
		return grade3;
	}
	/**
	 * �¼�����3�趨
	 * @param grade3  �¼�����3
	 */
	public void setGrade3(long grade3) {
		this.grade3 = grade3;
	}
	/**
	 * �¼�����4ȡ��
	 * @return grade4  �¼�����4
	 */
	public long getGrade4() {
		return grade4;
	}
	/**
	 * �¼�����4�趨
	 * @param grade4  �¼�����4
	 */
	public void setGrade4(long grade4) {
		this.grade4 = grade4;
	}
	/**
	 * �¼�����5ȡ��
	 * @return grade5  �¼�����5
	 */
	public long getGrade5() {
		return grade5;
	}
	/**
	 * �¼�����5�趨
	 * @param grade5  �¼�����5
	 */
	public void setGrade5(long grade5) {
		this.grade5 = grade5;
	}
	/**
	 * �¼�����6ȡ��
	 * @return grade6  �¼�����6
	 */
	public long getGrade6() {
		return grade6;
	}
	/**
	 * �¼�����6�趨
	 * @param grade6  �¼�����6
	 */
	public void setGrade6(long grade6) {
		this.grade6 = grade6;
	}
	/**
	 * �¼�����7ȡ��
	 * @return grade7  �¼�����7
	 */
	public long getGrade7() {
		return grade7;
	}
	/**
	 * �¼�����7�趨
	 * @param grade7  �¼�����7
	 */
	public void setGrade7(long grade7) {
		this.grade7 = grade7;
	}
	/**
	 * �¼�����8ȡ��
	 * @return grade8  �¼�����8
	 */
	public long getGrade8() {
		return grade8;
	}
	/**
	 * �¼�����8�趨
	 * @param grade8  �¼�����8
	 */
	public void setGrade8(long grade8) {
		this.grade8 = grade8;
	}
	/**
	 * �¼�����1����ȡ��
	 * @return grade1Count  �¼�����1����
	 */
	public int getGrade1Count() {
		return grade1Count;
	}
	/**
	 * �¼�����1�����趨
	 * @param grade1Count  �¼�����1����
	 */
	public void setGrade1Count(int grade1Count) {
		this.grade1Count = grade1Count;
	}
	/**
	 * �¼�����2����ȡ��
	 * @return grade2Count  �¼�����2����
	 */
	public int getGrade2Count() {
		return grade2Count;
	}
	/**
	 * �¼�����2�����趨
	 * @param grade2Count  �¼�����2����
	 */
	public void setGrade2Count(int grade2Count) {
		this.grade2Count = grade2Count;
	}
	/**
	 * �¼�����3����ȡ��
	 * @return grade3Count  �¼�����3����
	 */
	public int getGrade3Count() {
		return grade3Count;
	}
	/**
	 * �¼�����3�����趨
	 * @param grade3Count  �¼�����3����
	 */
	public void setGrade3Count(int grade3Count) {
		this.grade3Count = grade3Count;
	}
	/**
	 * �¼�����4����ȡ��
	 * @return grade4Count  �¼�����4����
	 */
	public int getGrade4Count() {
		return grade4Count;
	}
	/**
	 * �¼�����4�����趨
	 * @param grade4Count  �¼�����4����
	 */
	public void setGrade4Count(int grade4Count) {
		this.grade4Count = grade4Count;
	}
	/**
	 * �¼�����5����ȡ��
	 * @return grade5Count  �¼�����5����
	 */
	public int getGrade5Count() {
		return grade5Count;
	}
	/**
	 * �¼�����5�����趨
	 * @param grade5Count  �¼�����5����
	 */
	public void setGrade5Count(int grade5Count) {
		this.grade5Count = grade5Count;
	}
	/**
	 * �¼�����6����ȡ��
	 * @return grade6Count  �¼�����6����
	 */
	public int getGrade6Count() {
		return grade6Count;
	}
	/**
	 * �¼�����6�����趨
	 * @param grade6Count  �¼�����6����
	 */
	public void setGrade6Count(int grade6Count) {
		this.grade6Count = grade6Count;
	}
	/**
	 * �¼�����7����ȡ��
	 * @return grade7Count  �¼�����7����
	 */
	public int getGrade7Count() {
		return grade7Count;
	}
	/**
	 * �¼�����7�����趨
	 * @param grade7Count  �¼�����7����
	 */
	public void setGrade7Count(int grade7Count) {
		this.grade7Count = grade7Count;
	}
	/**
	 * �¼�����8����ȡ��
	 * @return grade8Count  �¼�����8����
	 */
	public int getGrade8Count() {
		return grade8Count;
	}
	/**
	 * �¼�����8�����趨
	 * @param grade8Count  �¼�����8����
	 */
	public void setGrade8Count(int grade8Count) {
		this.grade8Count = grade8Count;
	}

	/**
	 * idȡ��
	 * @return userId  id
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * id�趨
	 * @param userId  id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * �¼�����1ȡ��
	 * @return grade1Str  �¼�����1
	 */
	public String getGrade1Str() {
		return grade1Str;
	}

	/**
	 * �¼�����1�趨
	 * @param grade1Str  �¼�����1
	 */
	public void setGrade1Str(String grade1Str) {
		this.grade1Str = grade1Str;
	}

	/**
	 * �¼�����2ȡ��
	 * @return grade2Str  �¼�����2
	 */
	public String getGrade2Str() {
		return grade2Str;
	}

	/**
	 * �¼�����2�趨
	 * @param grade2Str  �¼�����2
	 */
	public void setGrade2Str(String grade2Str) {
		this.grade2Str = grade2Str;
	}

	/**
	 * �¼�����3ȡ��
	 * @return grade3Str  �¼�����3
	 */
	public String getGrade3Str() {
		return grade3Str;
	}

	/**
	 * �¼�����3�趨
	 * @param grade3Str  �¼�����3
	 */
	public void setGrade3Str(String grade3Str) {
		this.grade3Str = grade3Str;
	}

	/**
	 * �¼�����4ȡ��
	 * @return grade4Str  �¼�����4
	 */
	public String getGrade4Str() {
		return grade4Str;
	}

	/**
	 * �¼�����4�趨
	 * @param grade4Str  �¼�����4
	 */
	public void setGrade4Str(String grade4Str) {
		this.grade4Str = grade4Str;
	}

	/**
	 * �¼�����5ȡ��
	 * @return grade5Str  �¼�����5
	 */
	public String getGrade5Str() {
		return grade5Str;
	}

	/**
	 * �¼�����5�趨
	 * @param grade5Str  �¼�����5
	 */
	public void setGrade5Str(String grade5Str) {
		this.grade5Str = grade5Str;
	}

	/**
	 * �¼�����Iȡ��
	 * @return grade6Str  �¼�����6
	 */
	public String getGrade6Str() {
		return grade6Str;
	}

	/**
	 * �¼�����6�趨
	 * @param grade6Str  �¼�����6
	 */
	public void setGrade6Str(String grade6Str) {
		this.grade6Str = grade6Str;
	}

	/**
	 * �¼�����7ȡ��
	 * @return grade7Str  �¼�����7
	 */
	public String getGrade7Str() {
		return grade7Str;
	}

	/**
	 * �¼�����7�趨
	 * @param grade7Str  �¼�����7
	 */
	public void setGrade7Str(String grade7Str) {
		this.grade7Str = grade7Str;
	}

	/**
	 * �¼�����8ȡ��
	 * @return grade8Str  �¼�����8
	 */
	public String getGrade8Str() {
		return grade8Str;
	}

	/**
	 * �¼�����8�趨
	 * @param grade8Str  �¼�����8
	 */
	public void setGrade8Str(String grade8Str) {
		this.grade8Str = grade8Str;
	}

	/**
	 * �����������ϻ�ȡ
	 * @return the prid_In
	 */
	public String getPrid_In() {
		return prid_In;
	}

	/**
	 * �������������趨
	 * @param prid_In
	 */
	public void setPrid_In(String prid_In) {
		this.prid_In = prid_In;
	}

	/**
	 * ����������ȡ
	 * @return the pridNUM
	 */
	public Integer getPridNUM() {
		return pridNUM;
	}

	/**
	 * ���������趨
	 * @param pridNUM
	 */
	public void setPridNUM(Integer pridNUM) {
		this.pridNUM = pridNUM;
	}
}
