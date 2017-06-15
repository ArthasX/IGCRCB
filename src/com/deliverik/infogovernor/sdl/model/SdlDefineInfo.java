/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sdl.model;

import com.deliverik.framework.base.BaseModel;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_����ˮƽ����_����ˮƽ��׼��ϢMODEL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public interface SdlDefineInfo  extends BaseModel {
	
	/**
	 * ��ȡ����
	 * @return ����
	 */
	public abstract Integer getSdiid();

	/**
	 * ��ȡ���
	 * @return ���
	 */
	public abstract String getSdiyear();

	/**
	 * ��ȡ����ʲ�ID
	 * @return ����ʲ�ID
	 */
	public abstract Integer getSdieiid();

	/**
	 * ��ȡ�ʲ�����
	 * @return �ʲ�����
	 */
	public abstract String getSdieiname();

	/**
	 * ��ȡ���ж�ʱ��
	 * @return ���ж�ʱ��
	 */
	public abstract Integer getSdibreakm();

	/**
	 * ��ȡ���ж�ʱ��
	 * @return ���ж�ʱ��
	 */
	public abstract Integer getSdibreaky();

	/**
	 * ��ȡ������ʱ��ٷֱ�
	 * @return ������ʱ��ٷֱ�
	 */
	public abstract Double getSdicontinuousm();

	/**
	 * ��ȡ������ʱ��ٷֱ�
	 * @return ������ʱ��ٷֱ�
	 */
	public abstract Double getSdicontinuousy();

	/**
	 * ��ȡ��Ӱ��ʱ��
	 * @return ��Ӱ��ʱ��
	 */
	public abstract Integer getSdiimpactm();

	/**
	 * ��ȡ��Ӱ��ʱ��
	 * @return ��Ӱ��ʱ��
	 */
	public abstract Integer getSdiimpacty();

	/**
	 * ��ȡ���ȶ�ʱ��ٷֱ�
	 * @return ���ȶ�ʱ��ٷֱ�
	 */
	public abstract Double getSdisteadym();

	/**
	 * ��ȡ���ȶ�ʱ��ٷֱ�
	 * @return ���ȶ�ʱ��ٷֱ�
	 */
	public abstract Double getSdisteadyy();

	/**
	 * ��ȡ�°�ȫ�¼�����
	 * @return �°�ȫ�¼�����
	 */
	public abstract Integer getSdisafecasem();

	/**
	 * ��ȡ�갲ȫ�¼�����
	 * @return �갲ȫ�¼�����
	 */
	public abstract Integer getSdisafecasey();

	/**
	 * ��ȡ�°�ȫ�¼�����
	 * @return �°�ȫ�¼�����
	 */
	public abstract Integer getSdisafemarkm();

	/**
	 * ��ȡ�갲ȫ�¼�����
	 * @return �갲ȫ�¼�����
	 */
	public abstract Integer getSdisafemarky();

	/**
	 * ��ȡ�·��ռ������
	 * @return �·��ռ������
	 */
	public abstract Integer getSdiriskmarkm();

	/**
	 * ��ȡ����ռ������
	 * @return ����ռ������
	 */
	public abstract Integer getSdiriskmarky();

	/**
	 * ��ȡ�������¼�����
	 * @return �������¼�����
	 */
	public abstract Integer getSdicapacitycasem();

	/**
	 * ��ȡ�������¼�����
	 * @return �������¼�����
	 */
	public abstract Integer getSdicapacitycasey();

	/**
	 * ��ȡ�������¼�����
	 * @return �������¼�����
	 */
	public abstract Integer getSdicapacitymarkm();

	/**
	 * ��ȡ�������¼�����
	 * @return �������¼�����
	 */
	public abstract Integer getSdicapacitymarky();
}