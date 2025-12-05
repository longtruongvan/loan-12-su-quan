package com.mg.smsgame.main;

import j2me.al;
import j2me.an;
import j2me.bg;
import j2me.ci;
import j2me.cn;
import j2me.cx;
import j2me.cz;
import j2me.d;
import java.io.IOException;
import javax.microedition.io.PushRegistry;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.midlet.MIDlet;
import javax.wireless.messaging.MessageConnection;
import javay.microedition.in.Connector;

public abstract class MGMIDlet extends MIDlet {
  public Display a;

  public static boolean b = false;

  private boolean f = false;

  protected long c = 0L;

  public boolean d;

  protected static MGMIDlet e;

  public MGMIDlet(boolean paramBoolean, String paramString1, String paramString2, String paramString3,
      String paramString4) {
    cx.F = paramBoolean;
    if (cx.F) {
      an.h = 0;
      an.g = 0;
      an.f = 0;
      an.e = 0;
      an.i = 0;
      an.j = 0;
    }
    if (paramString1 != null)
      an.a = paramString1;
    if (paramString2 != null)
      an.b = paramString2;
    if (paramString3 != null)
      an.d = paramString3;
    if (paramString4 != null)
      an.c = paramString4;
    an.k = String.valueOf(an.a) + an.b;
    a();
    this.f = false;
    String str = getAppProperty("Distributor-Name");
    if (str == null || str.length() == 0)
      str = "asao";
    an.l = str;
    try {
      g();
      h();
    } catch (Throwable throwable) {
    }
    i();
    this.a = Display.getDisplay(this);
    e = this;
    this.a.setCurrent((Displayable) new cn());
  }

  public void a(String paramString) {
    f().platformRequest(paramString);
    f().notifyDestroyed();
  }

  private void g() {
    String str = System.getProperty("microedition.platform");
    cx.V = false;
    if (str != null) {
      int i = str.toLowerCase().trim().indexOf("nokia");
      if (i >= 0) {
        cx.V = true;
        if (System.getProperty("com.nokia.mid.imei") != null || System.getProperty("com.nokia.mid.imsi") != null
            || System.getProperty("com.nokia.mid.networkid") != null
            || System.getProperty("com.nokia.mid.networksignal") != null
            || System.getProperty("com.nokia.mid.networkavailability") != null
            || System.getProperty("com.nokia.mid.batterylevel") != null
            || System.getProperty("com.nokia.mid.countrycode") != null)
          cx.V = false;
      }
    }
    j2me.d.a("NokiaLessThanSerials60=" + cx.V);
  }

  private void h() {
    cx.D = false;
    String str = System.getProperty("com.sonyericsson.java.platform");
    str = str.substring(3);
    int i = str.indexOf(".");
    if (i > 0)
      str = str.substring(0, i);
    int j = Integer.parseInt(str);
    if (j < 8)
      cx.D = true;
  }

  public void destroyApp(boolean paramBoolean) {
    ci.a().b();
    notifyDestroyed();
  }

  public void pauseApp() {
    d();
  }

  public void startApp() {
    c();
  }

  private void i() {
    String[] arrayOfString = PushRegistry.listConnections(false);
    if (arrayOfString == null || arrayOfString.length == 0)
      try {
        String str1 = "sms://:" + an.d;
        String str2 = getClass().getName();
        PushRegistry.registerConnection(str1, str2, "*");
      } catch (Exception exception) {
      }
  }

  private void j() {
    if (b)
      return;
    String[] arrayOfString = PushRegistry.listConnections(true);
    if (arrayOfString != null && arrayOfString.length > 0) {
      MessageConnection messageConnection = (MessageConnection) Connector.open("sms://:" + an.d);
      j2me.an.a(messageConnection);
      b = true;
    } else {
      MessageConnection messageConnection = (MessageConnection) Connector.open("sms://:" + an.d);
      j2me.an.a(messageConnection);
      b = false;
    }
  }

  public final void c() {
    bg.i();
    this.a.setCurrent((Displayable) cz.d());
    a(b);
    if (!cx.F && al.a())
      al.e();
    if (!al.a(true))
      al.e();
    cz.d().b();
  }

  public void d() {
    notifyDestroyed();
  }

  public void e() {
    this.a.setCurrent((Displayable) j2me.d.a());
  }

  public static MGMIDlet f() {
    return e;
  }

  protected abstract void a();

  protected abstract void a(boolean paramBoolean);

  protected abstract void b();

  protected abstract void a(long paramLong);
}

/*
 * Location:
 * C:\Users\bot-nosense\Downloads\Loan-12-Su-Quan.jar!\com\mg\smsgame\main\
 * MGMIDlet.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version: 1.1.3
 */