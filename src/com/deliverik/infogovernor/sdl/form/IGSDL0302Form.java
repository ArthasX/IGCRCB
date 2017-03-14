/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.sdl.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.sdl.model.SdlDefineInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_����ˮƽ����_��׼����Form
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSDL0302Form extends BaseForm implements SdlDefineInfo{
	
	/**����*/
	protected Integer sdiid;

	/**���*/
	protected String sdiyear;

	/**����ʲ�ID*/
	protected Integer sdieiid;

	/**�ʲ����� */
	protected String sdieiname;

	/**���ж�ʱ�� */
	protected Integer sdibreakm;

	/**���ж�ʱ��*/
	protected Integer sdibreaky;

	/** ������ʱ��ٷֱ�*/
	protected Double sdicontinuousm;

	/**������ʱ��ٷֱ�*/
	protected Double sdicontinuousy;

	/**��Ӱ��ʱ��*/
	protected Integer sdiimpactm;

	/**��Ӱ��ʱ��*/
	protected Integer sdiimpacty;

	/** ���ȶ�ʱ��ٷֱ�*/
	protected Double sdisteadym;

	/**���ȶ�ʱ��ٷֱ�*/
	protected Double sdisteadyy;

	/**�°�ȫ�¼�����*/
	protected Integer sdisafecasem;

	/**�갲ȫ�¼�����*/
	protected Integer sdisafecasey;

	/**�°�ȫ�¼�����*/
	protected Integer sdisafemarkm;

	/**�갲ȫ�¼�����*/
	protected Integer sdisafemarky;

	/** �·��ռ������*/
	protected Integer sdiriskmarkm;

	/**����ռ������*/
	protected Integer sdiriskmarky;

	/**�������¼����� */
	protected Integer sdicapacitycasem;

	/**�������¼�����*/
	protected Integer sdicapacitycasey;

	/**�������¼�����*/
	protected Integer sdicapacitymarkm;

	/** �������¼�����*/
	protected Integer sdicapacitymarky;
	
	/** �༭ģʽ*/
	protected String mode = "0";

	/**
	 * ��ȡ����
	 * @return ����
	 */
	public Integer getSdiid() {
		if(sdiid != null && sdiid != 0){
			return sdiid;
		}else{
			return null;
		}
	}

	/**
	 * ��������
	 * @param sdiid ����
	 */
	public void setSdiid(Integer sdiid) {
		this.sdiid = sdiid;
	}
	
	/**
	 * ��ȡ���
	 * @return ���
	 */
	public String getSdiyear() {
		return sdiyear;
	}

	/**
	 * �������
	 * @param sdiyear ���
	 */
	public void setSdiyear(String sdiyear) {
		this.sdiyear = sdiyear;
	}

	/**
	 * ��ȡ����ʲ�ID
	 * @return ����ʲ�ID
	 */
	public Integer getSdieiid() {
		if(sdieiid != null && sdieiid != 0){
			return sdieiid;
		}else{
			return null;
		}
	}

	/**
	 * ��������ʲ�ID
	 * @param sdieiid ����ʲ�ID
	 */
	public void setSdieiid(Integer sdieiid) {
		this.sdieiid = sdieiid;
	}

	/**
	 * ��ȡ����ʲ�����
	 * @return ����ʲ�����
	 */
	public String getSdieiname() {
		return sdieiname;
	}

	/**
	 * ��������ʲ�����
	 * @param sdieiname ����ʲ�����
	 */
	public void setSdieiname(String sdieiname) {
		this.sdieiname = sdieiname;
	}

	/**
	 * ��ȡ���ж�ʱ��
	 * @return ���ж�ʱ��
	 */
	public Integer getSdibreakm() {
		if(sdibreakm != null && sdibreakm != 0){
			return sdibreakm;
		}else{
			return null;
		}
	}

	/**
	 * �������ж�ʱ��
	 * @param sdibreakm ���ж�ʱ��
	 */
	public void setSdibreakm(Integer sdibreakm) {
		this.sdibreakm = sdibreakm;
	}

	/**
	 * ��ȡ���ж�ʱ��
	 * @return ���ж�ʱ��
	 */
	public Integer getSdibreaky() {
		if(sdibreaky != null && sdibreaky != 0){
			return sdibreaky;
		}else{
			return null;
		}
	}

	/**
	 * �������ж�ʱ��
	 * @param sdibreaky ���ж�ʱ��
	 */
	public void setSdibreaky(Integer sdibreaky) {
		this.sdibreaky = sdibreaky;
	}

	/**
	 * ��ȡ������ʱ��ٷֱ�
	 * @return ������ʱ��ٷֱ�
	 */
	public Double getSdicontinuousm() {
		if(sdicontinuousm != null && sdicontinuousm != 0){
			return sdicontinuousm;
		}else{
			return null;
		}
	}

	/**
	 * ����������ʱ��ٷֱ�
	 * @param sdicontinuousm ������ʱ��ٷֱ�
	 */
	public void setSdicontinuousm(Double sdicontinuousm) {
		this.sdicontinuousm = sdicontinuousm;
	}

	/**
	 * ��ȡ������ʱ��ٷֱ�
	 * @return ������ʱ��ٷֱ�
	 */
	public Double getSdicontinuousy() {
		if(sdicontinuousy != null && sdicontinuousy != 0){
			return sdicontinuousy;
		}else{
			return null;
		}
	}

	/**
	 * ����������ʱ��ٷֱ�
	 * @param sdicontinuousy ������ʱ��ٷֱ�
	 */
	public void setSdicontinuousy(Double sdicontinuousy) {
		this.sdicontinuousy = sdicontinuousy;
	}

	/**
	 * ��ȡ��Ӱ��ʱ��
	 * @return ��Ӱ��ʱ��
	 */
	public Integer getSdiimpactm() {
		if(sdiimpactm != null && sdiimpactm != 0){
			return sdiimpactm;
		}else{
			return null;
		}
	}

	/**
	 * ������Ӱ��ʱ��
	 * @param sdiimpactm ��Ӱ��ʱ��
	 */
	public void setSdiimpactm(Integer sdiimpactm) {
		this.sdiimpactm = sdiimpactm;
	}

	/**
	 * ��ȡ��Ӱ��ʱ��
	 * @return ��Ӱ��ʱ��
	 */
	public Integer getSdiimpacty() {
		if(sdiimpacty != null && sdiimpacty != 0){
			return sdiimpacty;
		}else{
			return null;
		}
	}

	/**
	 * ������Ӱ��ʱ��
	 * @param sdiimpacty ��Ӱ��ʱ��
	 */
	public void setSdiimpacty(Integer sdiimpacty) {
		this.sdiimpacty = sdiimpacty;
	}

	/**
	 * ��ȡ���ȶ�ʱ��ٷֱ�
	 * @return ���ȶ�ʱ��ٷֱ�
	 */
	public Double getSdisteadym() {
		if(sdisteadym != null && sdisteadym != 0){
			return sdisteadym;
		}else{
			return null;
		}
	}

	/**
	 * �������ȶ�ʱ��ٷֱ�
	 * @param sdisteadym ���ȶ�ʱ��ٷֱ�
	 */
	public void setSdisteadym(Double sdisteadym) {
		this.sdisteadym = sdisteadym;
	}

	/**
	 * ��ȡ���ȶ�ʱ��ٷֱ�
	 * @return ���ȶ�ʱ��ٷֱ�
	 */
	public Double getSdisteadyy() {
		if(sdisteadyy != null && sdisteadyy != 0){
			return sdisteadyy;
		}else{
			return null;
		}
	}

	/**
	 * �������ȶ�ʱ��ٷֱ�
	 * @param sdisteadyy ���ȶ�ʱ��ٷֱ�
	 */
	public void setSdisteadyy(Double sdisteadyy) {
		this.sdisteadyy = sdisteadyy;
	}

	/**
	 * ��ȡ�°�ȫ�¼�����
	 * @return �°�ȫ�¼�����
	 */
	public Integer getSdisafecasem() {
		if(sdisafecasem != null && sdisafecasem != 0){
			return sdisafecasem;
		}else{
			return null;
		}
	}

	/**
	 * �����°�ȫ�¼�����
	 * @param sdisafecasem �°�ȫ�¼�����
	 */
	public void setSdisafecasem(Integer sdisafecasem) {
		this.sdisafecasem = sdisafecasem;
	}

	/**
	 * ��ȡ�갲ȫ�¼�����
	 * @return �갲ȫ�¼�����
	 */
	public Integer getSdisafecasey() {
		if(sdisafecasey != null && sdisafecasey != 0){
			return sdisafecasey;
		}else{
			return null;
		}
	}

	/**
	 * �����갲ȫ�¼�����
	 * @param sdisafecasey �갲ȫ�¼�����
	 */
	public void setSdisafecasey(Integer sdisafecasey) {
		this.sdisafecasey = sdisafecasey;
	}

	/**
	 * ��ȡ�°�ȫ�¼�����
	 * @return �°�ȫ�¼�����
	 */
	public Integer getSdisafemarkm() {
		if(sdisafemarkm != null && sdisafemarkm != 0){
			return sdisafemarkm;
		}else{
			return null;
		}
	}

	/**
	 * �����°�ȫ�¼�����
	 * @param sdisafemarkm �°�ȫ�¼�����
	 */
	public void setSdisafemarkm(Integer sdisafemarkm) {
		this.sdisafemarkm = sdisafemarkm;
	}

	/**
	 * ��ȡ�갲ȫ�¼�����
	 * @return �갲ȫ�¼�����
	 */
	public Integer getSdisafemarky() {
		if(sdisafemarky != null && sdisafemarky != 0){
			return sdisafemarky;
		}else{
			return null;
		}
	}

	/**
	 * �����갲ȫ�¼�����
	 * @param sdisafemarky �갲ȫ�¼�����
	 */
	public void setSdisafemarky(Integer sdisafemarky) {
		this.sdisafemarky = sdisafemarky;
	}

	/**
	 * ��ȡ�·��ռ������
	 * @return �·��ռ������
	 */
	public Integer getSdiriskmarkm() {
		if(sdiriskmarkm != null && sdiriskmarkm != 0){
			return sdiriskmarkm;
		}else{
			return null;
		}
	}

	/**
	 * �����·��ռ������
	 * @param sdiriskmarkm �·��ռ������
	 */
	public void setSdiriskmarkm(Integer sdiriskmarkm) {
		this.sdiriskmarkm = sdiriskmarkm;
	}

	/**
	 * ��ȡ����ռ������
	 * @return ����ռ������
	 */
	public Integer getSdiriskmarky() {
		if(sdiriskmarky != null && sdiriskmarky != 0){
			return sdiriskmarky;
		}else{
			return null;
		}
	}

	/**
	 * ��������ռ������
	 * @param sdiriskmarky ����ռ������
	 */
	public void setSdiriskmarky(Integer sdiriskmarky) {
		this.sdiriskmarky = sdiriskmarky;
	}

	/**
	 * ��ȡ�������¼�����
	 * @return �������¼�����
	 */
	public Integer getSdicapacitycasem() {
		if(sdicapacitycasem != null && sdicapacitycasem != 0){
			return sdicapacitycasem;
		}else{
			return null;
		}
	}

	/**
	 * �����������¼�����
	 * @param sdicapacitycasem �������¼�����
	 */
	public void setSdicapacitycasem(Integer sdicapacitycasem) {
		this.sdicapacitycasem = sdicapacitycasem;
	}

	/**
	 * ��ȡ�������¼�����
	 * @return �������¼�����
	 */
	public Integer getSdicapacitycasey() {
		if(sdicapacitycasey != null && sdicapacitycasey != 0){
			return sdicapacitycasey;
		}else{
			return null;
		}
	}

	/**
	 * �����������¼�����
	 * @param sdicapacitycasey �������¼�����
	 */
	public void setSdicapacitycasey(Integer sdicapacitycasey) {
		this.sdicapacitycasey = sdicapacitycasey;
	}

	/**
	 * ��ȡ�������¼�����
	 * @return �������¼�����
	 */
	public Integer getSdicapacitymarkm() {
		if(sdicapacitymarkm != null && sdicapacitymarkm != 0){
			return sdicapacitymarkm;
		}else{
			return null;
		}
	}

	/**
	 * �����������¼�����
	 * @param sdicapacitymarkm �������¼�����
	 */
	public void setSdicapacitymarkm(Integer sdicapacitymarkm) {
		this.sdicapacitymarkm = sdicapacitymarkm;
	}

	/**
	 * ��ȡ�������¼�����
	 * @return �������¼�����
	 */
	public Integer getSdicapacitymarky() {
		if(sdicapacitymarky != null && sdicapacitymarky != 0){
			return sdicapacitymarky;
		}else{
			return null;
		}
	}

	/**
	 * �����������¼�����
	 * @param sdicapacitymarky �������¼�����
	 */
	public void setSdicapacitymarky(Integer sdicapacitymarky) {
		this.sdicapacitymarky = sdicapacitymarky;
	}

	/**
	 * ��ȡ�༭ģʽ
	 * @return �༭ģʽ
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * ���ñ༭ģʽ
	 * @param mode �༭ģʽ
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	protected String fingerPrint;

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
	
}
