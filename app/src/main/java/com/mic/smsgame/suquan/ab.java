package com.mic.smsgame.suquan;

import j2me.ai;
import j2me.aj;
import j2me.ar;
import j2me.bs;
import j2me.bu;
import j2me.c;
import com.mg.smsgame.main.b;
import j2me.cq;
import j2me.cz;
import j2me.d;
import j2me.dd;
import j2me.i;
import javax.microedition.lcdui.Graphics;

public class ab extends aj implements e {
  cq c;

  i d;

  bu e;

  public ab() {
    long l = System.currentTimeMillis();
    try {
      bs.b();
      try {
        byte[] arrayOfByte = (byte[]) null;
        int j = 0;
        if (f.e()) {
          System.out.println("khasc nullllllllllllll");
          arrayOfByte = f.d();
          com.mic.smsgame.suquan.f.f();
          dd.c = ai.a(arrayOfByte, j);
          j += 1;
          dd.e = new c();
          j += dd.e.b(arrayOfByte, j);
          dd.f = new c();
          j += dd.f.b(arrayOfByte, j);
        }
        this.c = new cq(dd.d(dd.c), dd.e, dd.f);
        this.d = new i(this.c);
        this.e = new bu(this.c, this.d);
        this.e.a(arrayOfByte, j);
      } catch (Exception exception) {
        exception.printStackTrace();
        exception.printStackTrace();
        j2me.d.a(exception);
        com.mic.smsgame.suquan.f.f();
        j2me.cz.a().a(5, 7, false);
        return;
      }
      a((b) j2me.cz.a());
      a((j2me.bk) null);
      dd.h();
      try {
        j2me.bs.a().c();
        j2me.bs.a().b(dd.e.f);
        j2me.bs.a().b(dd.f.f);
      } catch (Exception exception) {
        j2me.bs.a().j();
        exception.printStackTrace();
        j2me.d.a(exception);
      }
    } catch (Exception exception) {
      exception.printStackTrace();
      exception.printStackTrace();
      j2me.d.a(exception);
      j2me.cz.a().a(5, 7, false);
    }
    j2me.d.a("DONE LOADPLAY" + (System.currentTimeMillis() - l));
    this.q = 5;
  }

  public void r() {
    bs.k();
  }

  public void a(int paramInt) {
    this.e.b(paramInt);
  }

  public void a(int paramInt1, int paramInt2) {
    this.e.a(paramInt1, paramInt2);
  }

  public void a() {
    this.e.c();
    this.d.d();
  }

  public void a(Graphics paramGraphics) {
    this.d.a(paramGraphics);
  }

  public void e() {
    this.e.t();
  }

  public void t() {
    this.d.a(false);
  }

  public void s() {
    this.d.a(true);
  }
}

/*
 * Location:
 * C:\Users\bot-nosense\Downloads\Loan-12-Su-Quan.jar!\com\mic\smsgame\suquan\ab
 * .class
 * Java compiler version: 1 (45.3)
 * JD-Core Version: 1.1.3
 */