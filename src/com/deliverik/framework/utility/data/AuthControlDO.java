package com.deliverik.framework.utility.data;
import java.util.ArrayList;
import java.util.List;

/**
 * ���ڐ���@�\XML�f�[�^�I�u�W�F�N�g<br>
 *
 * ��ʍ��ڐ���@�\�𗘗p����ۂɕK�v�ȍ��ڐ���XML�̒�`���e��<br>
 * ���I�u�W�F�N�g�Ƀ}�b�s���O����܂��B<br>
 * ���I�u�W�F�N�g�� �����A�X�܏�ԁA�X�܎�ނ̐�������܂݂܂��B<br>
 * ���I�u�W�F�N�g�� ��ʓ��̉�ʃu���b�N�I�u�W�F�N�g���X�g��ۗL���Ă��܂��B<br>
 * ��ʂ��\������I�u�W�F�N�g�̍\���͈ȉ��̒ʂ�ł��B<br>
 * [���]1-n[���ڃu���b�N]1-n[����]<br><br>
 * ���I�u�W�F�N�g�͂P��ʒP�ʂɐ�������܂��B<br>
 *
 * @author eicosha
 */
public class AuthControlDO {

	/** ��ʍ���ID */
	private String gui_id;

	/** ���䌠�� */
	private List<AuthControlParamDO> rolls;

	/** �X�܏�� */
	private List<AuthControlParamDO> status;

	/** �X�܂̎�� */
	private List<AuthControlParamDO> type;

	/** ��ʃu���b�N */
	private List<AuthControlGuiBlockDO> gui_blocks;

	/**
	 * ���ڐ���@�\XML�f�[�^�I�u�W�F�N�g�R���X�g���N�^<br>
	 */
	public AuthControlDO() {
		gui_blocks = new ArrayList<AuthControlGuiBlockDO>();
		rolls = new ArrayList<AuthControlParamDO>();
		status = new ArrayList<AuthControlParamDO>();
		type = new ArrayList<AuthControlParamDO>();
	}


	/**
	 * ��ʃu���b�N��ǉ����܂��B<br>
	 *
	 * @param gui_block ��ʃu���b�N�I�u�W�F�N�g
	 */
	public void addGui_block(AuthControlGuiBlockDO gui_block) {
		this.gui_blocks.add(gui_block);
	}

	/**
	 * ������ǉ����܂��B<br>
	 *
	 * @param kengen �����I�u�W�F�N�g
	 */
	public void addKengen(AuthControlParamDO kengen) {
		this.rolls.add(kengen);
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
		for( int i=0; i<gui_blocks.size(); i++ ){
			buf.append( gui_blocks.get(i) ).append( newline );
		}
		return buf.toString();
	}

	/**
	 * ��ʃu���b�N���擾���܂��B
	 * @return ��ʃu���b�N
	 */
	public List<AuthControlGuiBlockDO> getGui_blocks() {
		 return gui_blocks;
	}

	/**
	 * ��ʍ���ID���擾���܂��B
	 * @return ��ʍ���ID
	 */
	public String getGui_id() {
		return gui_id;
	}

	/**
	 * ��ʍ���ID��ݒ肵�܂��B
	 * @param gui_id ��ʍ���ID
	 */
	public void setGui_id(String gui_id) {
		this.gui_id = gui_id;
	}

	/**
	 * ���䌠�����擾���܂��B
	 * @return ���䌠��
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
