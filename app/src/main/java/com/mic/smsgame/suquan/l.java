package com.mic.smsgame.suquan;

import j2me.aj;
import j2me.ay;
import j2me.az;
import j2me.cx;
import j2me.cz;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class l extends aj {
  private Image c = az.b("/bksplashscreen");
  
  private int d;
  
  public l() {
    cz.d().a(30);
  }
  
  public void a(Graphics paramGraphics) {
    paramGraphics.drawImage(this.c, cx.l, cx.m, 20);
  }
  
  public void a() {
    this.d++;
    if (this.d == 30) {
      (j2me.cz.a()).f = j2me.cz.a().d(ay.a(j2me.cz.a().j()));
      cz.d().a(new ac(), true);
    } 
  }
}


/* Location:              C:\Users\bot-nosense\Downloads\Loan-12-Su-Quan.jar!\com\mic\smsgame\suquan\l.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */