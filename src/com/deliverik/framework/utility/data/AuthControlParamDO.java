package com.deliverik.framework.utility.data;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

/**
 * ��������XML ����p�����[�^�f�[�^�I�u�W�F�N�g<br>
 *
 * ��ʍ��ڐ���@�\�𗘗p����ۂɕK�v�ȍ��ڐ���XML�̒�`���e��<br>
 * ���I�u�W�F�N�g�Ƀ}�b�s���O����܂��B<br>
 * ���I�u�W�F�N�g�� �����A�X�܏�ԁA�X�܎�ނ̐������<br>
 * ����ID�A�l(��`�l)��ۗL���Ă��܂��B <br>
 * ���I�u�W�F�N�g�͂P����̒�`�i�ŏ��P�ʁj���ɐ�������܂��B<br>
 *
 * @author eicosha
 */
public class AuthControlParamDO {

	/** id */
	private String id;

	/** value */
	private String value;

	public AuthControlParamDO() {}

	/**
	 * toString���\�b�h<BR>
	 * ���̃C���X�^���X�̑S�Ă̍��ڂ̒l�������o���܂��B
	 */
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	/**
	 * id���擾���܂��B
	 * @return id
	 */
	public String getId() {
	    return id;
	}

	/**
	 * id��ݒ肵�܂��B
	 * @param id id
	 */
	public void setId(String id) {
	    this.id = id;
	}

	/**
	 * value���擾���܂��B
	 * @return value
	 */
	public String getValue() {
	    return value;
	}

	/**
	 * value��ݒ肵�܂��B
	 * @param value value
	 */
	public void setValue(String value) {
	    this.value = value;
	}

}
