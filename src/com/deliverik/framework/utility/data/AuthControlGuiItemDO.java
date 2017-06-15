package com.deliverik.framework.utility.data;

import java.util.ArrayList;
import java.util.List;

/**
 * ��������XML ��ʍ��ڃf�[�^�I�u�W�F�N�g<br>
 *
 * ��ʍ��ڐ���@�\�𗘗p����ۂɕK�v�ȍ��ڐ���XML�̒�`���e��<br>
 * ���I�u�W�F�N�g�Ƀ}�b�s���O����܂��B<br>
 * ���I�u�W�F�N�g�� �����A�X�܏�ԁA�X�܎�ނ̐�������܂݂܂��B<br>
 * ��ʂ��\������I�u�W�F�N�g�̍\���͈ȉ��̒ʂ�ł��B<br>
 * [���]1-n[���ڃu���b�N]1-n[����]<br><br>
 * ���I�u�W�F�N�g�͂P���ږ��ɐ�������܂��B<br>
 *
 * @author eicosha
 */
public class AuthControlGuiItemDO {

	/** ��ʍ���ID */
	private String id;

	/** ���䌠�� */
	private List<AuthControlParamDO> rolls;

	/** �X�܏�� */
	private List<AuthControlParamDO> status;

	/** �X�܂̎�� */
	private List<AuthControlParamDO> type;

	/**
	 * ��������XML ��ʍ��ڃf�[�^�I�u�W�F�N�g�R���X�g���N�^<br>
	 */
	public AuthControlGuiItemDO() {
		rolls = new ArrayList<AuthControlParamDO>();
		status = new ArrayList<AuthControlParamDO>();
		type = new ArrayList<AuthControlParamDO>();
	}

	/**
	 * ���[����ǉ����܂��B<br>
	 *
	 * @param roll ���[���I�u�W�F�N�g
	 */
	public void addRoll(AuthControlParamDO roll) {
		this.rolls.add(roll);
	}

	/**
	 * �X�܏�Ԃ�ǉ����܂��B<br>
	 *
	 * @param status �X�܏�ԃI�u�W�F�N�g
	 */
	public void addStatus(AuthControlParamDO status) {
		this.status.add(status);
	}

	/**
	 * �X�܎�ނ�ǉ����܂��B<br>
	 *
	 * @param type �X�܎�ރI�u�W�F�N�g
	 */
	public void addType(AuthControlParamDO type) {
		this.type.add(type);
	}

	/**
	 * �I�u�W�F�N�g�̓��e�������ǉ����܂��B<br>
	 *
	 * @return �I�u�W�F�N�g�̓��e������
	 */
	public String toString() {
		String newline = System.getProperty( "line.separator" );
		StringBuffer buf = new StringBuffer();

		buf.append( "--- Excases ---" ).append(newline);
		for(int i=0; i<rolls.size(); i++){
			buf.append( rolls.get(i) ).append(newline);
		}
		for( int i=0; i<status.size(); i++ ){
			buf.append( status.get(i) ).append(newline);
		}
		for( int i=0; i<type.size(); i++ ){
			buf.append( type.get(i) ).append(newline);
		}
		return buf.toString();
	}

	/**
	 * ��ʍ���ID���擾���܂��B
	 * @return ��ʍ���ID
	 */
	public String getId() {
	    return id;
	}

	/**
	 * ��ʍ���ID��ݒ肵�܂��B
	 * @param id ��ʍ���ID
	 */
	public void setId(String id) {
	    this.id = id;
	}

	/**
	 * ���䃍�[�����擾���܂��B
	 * @return ���䃍�[��
	 */
	public List<AuthControlParamDO> getRolls() {
		 return rolls;
	}

	/**
	 * �X�܏�Ԃ��擾���܂��B
	 * @return �X�܏��
	 */
	public List<AuthControlParamDO> getStatus() {
		 return status;
	}

	/**
	 * �X�܂̎�ނ��擾���܂��B
	 * @return �X�܂̎��
	 */
	public List<AuthControlParamDO> getType() {
		 return type;
	}
}
