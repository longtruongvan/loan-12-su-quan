package j2me;

import com.mg.smsgame.main.MGMIDlet;
import com.mg.smsgame.main.a;
import java.io.UnsupportedEncodingException;

class bc {
  String a;

  String b;

  a c;

  bc(String paramString1, String paramString2, a parama) {
    this.b = paramString1;
    this.c = parama;
    a(paramString2);
  }

  private void a(String paramString) {
    paramString = paramString.trim();
    if (paramString.length() == 1) {
      int i = Integer.parseInt(paramString.trim());
      String str = "8731";
      str = String.valueOf(8) + paramString + '\037';
      byte[] arrayOfByte1 = j2me.b.a(str);
      byte[] arrayOfByte2 = new byte[arrayOfByte1.length];
      System.arraycopy(cx.a[i], 0, arrayOfByte2, 0, 4);
      System.arraycopy(cx.b[i], 0, arrayOfByte2, 8, 4);
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 4, 4);
      System.arraycopy(arrayOfByte1, 4, arrayOfByte2, 12, arrayOfByte1.length - 4);
      this.a = str;
    }
  }
}