package com.mic.smsgame.suquan;

import j2me.af;
import j2me.ag;
import j2me.aj;
import j2me.bb;
import j2me.bi;
import j2me.bv;
import j2me.by;
import j2me.cf;
import j2me.cx;
import j2me.cy;
import j2me.dc;
import j2me.j;
import j2me.v;
import j2me.z;

public class y extends bv {
  public y() {
    super(true);
  }

  public dc k() {
    if (cx.T)
      return null;
    int i = 2;
    if (this.b != null)
      i = this.b.k();
    if (aa.c)
      i = 7;
    if (i < 0)
      return null;
    if (i == 0)
      i = 2;
    return new m(i);
  }

  public void l() {
    this.g = new bb[4];
    this.g[0] = (bb) new j();
    this.g[1] = (bb) new af();
    this.g[2] = (bb) new bi();
    this.g[3] = (bb) new cy();
  }

  public void m() {
    this.k = (by) new z();
    this.j = (by) new ag();
  }

  protected aj d(int paramInt1, int paramInt2) {
    ab ab;
    cx.T = false;
    switch (paramInt2) {
      case 1:
        return (aj) new v(6);
      case 6:
        return new l();
      case 2:
        return new ac();
      case 3:
        return (aj) new m(paramInt1);
      case 5:
        ab = new ab();
        cx.T = true;
        return ab;
      case 7:
        if (paramInt1 == 2)
          aa.d = true;
        return new aa();
      case 4:
        return new q(paramInt1);
      case 8:
        return new com.mic.smsgame.suquan.z();
    }
    return null;
  }

  public void b(int paramInt1, int paramInt2) {
  }

  public void h() {
    super.h();
    if (!cx.T && !cx.H)
      cf.a().e();
  }

  public void g() {
    super.g();
    if (!cx.T && !cx.H)
      cf.a().b();
  }
}

/*
 * Location:
 * C:\Users\bot-nosense\Downloads\Loan-12-Su-Quan.jar!\com\mic\smsgame\suquan\y.
 * class
 * Java compiler version: 1 (45.3)
 * JD-Core Version: 1.1.3
 */