�P�D�L�[�쐬�菇
C:\workspace\MasaClock\key>"C:\Program Files\Java\jdk1.6.0_23\bin\keytool" -genkey -keystore masaclock.keystore -alias masaclock -validity 10000

 �L�[�X�g�A�̃p�X���[�h����͂��Ă�������:masaclock
�V�K�p�X���[�h���ē��͂��Ă�������:masaclock
��������͂��Ă��������B
  [Unknown]:  Tatsumasa Kuwabara
�g�D�P�ʖ�����͂��Ă��������B
  [Unknown]:
�g�D������͂��Ă��������B
  [Unknown]:  Masa Project
�s�s���܂��͒n�於����͂��Ă��������B
  [Unknown]:  Gifu
�B���܂��͒n��������͂��Ă��������B
  [Unknown]:  Gifu
���̒P�ʂɊY������ 2 �����̍��ԍ�����͂��Ă��������B
  [Unknown]:  jp
CN=Tatsumasa Kuwabara, OU=Unknown, O=Masa Project, L=Gifu, ST=Gifu, C=jp �ł��
�����ł���?
  [no]:  yes

<masaclock> �̌��p�X���[�h����͂��Ă��������B
        (�L�[�X�g�A�̃p�X���[�h�Ɠ����ꍇ�� RETURN �������Ă�������):

�Q�D�����菇
C:\workspace\MasaClock\key>cd ..

C:\workspace\MasaClock>"C:\Program Files\Java\jdk1.6.0_23\bin\jarsigner.exe" -verbose -keystore key\masaclock.keystore bin\MasaClock.apk masaclock
�L�[�X�g�A�̃p�X���[�h����͂��Ă�������:
   �ǉ���: META-INF/MASACLOC.SF
   �ǉ���: META-INF/MASACLOC.DSA
  ������: res/drawable/digital_clock.png
  ������: res/drawable/icon.png
  ������: res/layout/main.xml
  ������: res/raw/s1.ogg
  ������: res/raw/s2.ogg
  ������: AndroidManifest.xml
  ������: resources.arsc
  ������: classes.dex
