package com.deliverik.framework.exception;

/**
 * MAX�����I�[�o�[��O�N���X<br>
 *
 *
 * @author eicosha
 */
public class MaxDataCountException extends Exception {

	private static final long serialVersionUID = 1L;

	/** �������ʌ��� */
	protected int resultCount;

	/** MAX���� */
	protected int maxCount;

	/**
	 * �R���X�g���N�^
	 *
	 * @param resultCount �������ʌ���
	 * @param maxCount MAX����
	 */
	public MaxDataCountException(int resultCount, int maxCount) {
		super();
		this.resultCount = resultCount;
		this.maxCount = maxCount;
	}

	public int getMaxCount() {
		return maxCount;
	}

	public int getResultCount() {
		return resultCount;
	}

}
