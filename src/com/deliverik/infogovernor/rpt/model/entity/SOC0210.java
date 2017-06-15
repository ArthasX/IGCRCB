/**
 * ��������������������޹�˾��Ȩ���У���������Ȩ��
 */
package com.deliverik.infogovernor.rpt.model.entity;

/**
 * ����: word����
 * ��������: ����ȡĳ��word�ĵ�ͼƬ�Ķ���
 * ������¼: ����ȫ 2012/06/13
 * �޸ļ�¼: ¬��Ԫ 2012/08/09 ��DocTemObj������ΪSOC0210
 */
public class SOC0210 {
	/**�ĵ��б�ʶ*/
	private String flag;
	/**�ĵ�����·��*/
	private String docPath;
	/**ȡ��ͼƬ��*/
	private Integer shapeIndex;
	/**ͼƬʶ���ַ���*/
	private String imgStr;
	/**�ļ�����*/
	private String docName;
	/**����λ�����*/
	private Integer locationNum;
	
	public SOC0210() {
	}

	public SOC0210(String flag, String docPath, Integer shapeIndex,
			String imgStr, String docName) {
		super();
		this.flag = flag;
		this.docPath = docPath;
		this.shapeIndex = shapeIndex;
		this.imgStr = imgStr;
		this.docName = docName;
	}



	/**
	 * �ĵ��б�ʶȡ��
	 *
	 * @return flag �ĵ��б�ʶ
	 */
	public String getFlag() {
		return flag;
	}



	/**
	 * �ĵ��б�ʶ�趨
	 *
	 * @param flag �ĵ��б�ʶ
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}



	/**
	 * �ĵ�����·��ȡ��
	 *
	 * @return docPath �ĵ�����·��
	 */
	public String getDocPath() {
		return docPath;
	}



	/**
	 * �ĵ�����·���趨
	 *
	 * @param docPath �ĵ�����·��
	 */
	public void setDocPath(String docPath) {
		this.docPath = docPath;
	}



	/**
	 * ȡ��ͼƬ��ȡ��
	 *
	 * @return shapeIndex ȡ��ͼƬ��
	 */
	public Integer getShapeIndex() {
		return shapeIndex;
	}



	/**
	 * ȡ��ͼƬ���趨
	 *
	 * @param shapeIndex ȡ��ͼƬ��
	 */
	public void setShapeIndex(Integer shapeIndex) {
		this.shapeIndex = shapeIndex;
	}



	/**
	 * ͼƬʶ���ַ���ȡ��
	 *
	 * @return imgStr ͼƬʶ���ַ���
	 */
	public String getImgStr() {
		return imgStr;
	}



	/**
	 * ͼƬʶ���ַ����趨
	 *
	 * @param imgStr ͼƬʶ���ַ���
	 */
	public void setImgStr(String imgStr) {
		this.imgStr = imgStr;
	}



	/**
	 * �ļ�����ȡ��
	 *
	 * @return docName �ļ�����
	 */
	public String getDocName() {
		return docName;
	}



	/**
	 * �ļ������趨
	 *
	 * @param docName �ļ�����
	 */
	public void setDocName(String docName) {
		this.docName = docName;
	}

	/**
	 * ����λ�����ȡ��
	 *
	 * @return locationNum ����λ�����
	 */
	public Integer getLocationNum() {
		return locationNum;
	}

	/**
	 * ����λ������趨
	 *
	 * @param locationNum ����λ�����
	 */
	public void setLocationNum(Integer locationNum) {
		this.locationNum = locationNum;
	}


	
}
