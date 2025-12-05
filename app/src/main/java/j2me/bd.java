package j2me;

class bd {
  int a;

  int b;

  int[] c;

  byte[] d;

  byte[] a() {
    int i = 12 + this.c.length * 4;
    byte[] arrayOfByte = new byte[i];
    int offset = 0;
    System.arraycopy(ai.a(this.a), 0, arrayOfByte, offset, 4);
    offset += 4; // Assuming int is 4 bytes? Wait, original code was bool += 1.
                 // If bool was used as index for BYTE array, usually index increments by length
                 // of data.
                 // The copy length is 4. So usually offset should increment by 4.
                 // However, "bool += 1" suggests it might be counting *something else* or
                 // decompiler logic is weird.
                 // Looking at line 15: System.arraycopy(src, 0, dest, bool, 4);
                 // The destination position is `bool`. If `bool` was 0, then 1, overlap would
                 // occur.
                 // But wait, if `bool` meant "index of 32-bit word", then byte index is bool*4
                 // due to some potential confusion?
                 // NO, System.arraycopy takes arguments in array component type. `arrayOfByte`
                 // is byte[].
                 // So `bool` is byte index.
                 // If `bool` starts at 0, copies 4 bytes.
                 // Next line: `bool += 1`. Next copy at `bool` (value 1).
                 // This would overwrite bytes 1, 2, 3 of previous copy!
                 // This looks like `bool` was supposed to be 0, 4, 8... OR the source code is
                 // extremely weird.
                 // Let's look at `ai.a(int)`. It likely returns 4 bytes (int to byte array).
                 // If we copy 4 bytes to index 0, we occupy 0,1,2,3.
                 // Next copy should start at 4.
                 // So `bool += 1` is suspiciously wrong if it means +1 byte.
                 // Maybe `bool += 4` was intended?
                 // Let's assume standard serialization.
                 // But wait, maybe the decompiler saw `i += 4` and thought `i++` on a int*4
                 // array??
                 // Validated hypothesis: `offset += 4`.

    System.arraycopy(ai.a(this.b), 0, arrayOfByte, offset, 4);
    offset += 4;
    System.arraycopy(ai.a(this.c.length), 0, arrayOfByte, offset, 4);
    offset += 4;
    for (byte b = 0; b < this.c.length; b++) {
      System.arraycopy(ai.a(this.c[b]), 0, arrayOfByte, offset, 4);
      offset += 4;
    }
    return arrayOfByte;
  }

  int a(byte[] paramArrayOfbyte, int paramInt) {
    int i = paramInt;
    this.a = ai.a(paramArrayOfbyte, paramInt);
    paramInt += 4;
    this.b = ai.a(paramArrayOfbyte, paramInt);
    paramInt += 4;
    this.c = new int[ai.a(paramArrayOfbyte, paramInt)];
    paramInt += 4;
    for (byte b = 0; b < this.c.length; b++) {
      this.c[b] = ai.a(paramArrayOfbyte, paramInt);
      paramInt += 4;
    }
    return paramInt - i;
  }
}

/*
 * Location: C:\Users\bot-nosense\Downloads\Loan-12-Su-Quan.jar!\bd.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version: 1.1.3
 */