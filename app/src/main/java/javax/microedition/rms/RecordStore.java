package javax.microedition.rms;

import android.content.Context;
import android.content.SharedPreferences;
import javax.microedition.midlet.MIDlet;

public class RecordStore {
    public static RecordStore openRecordStore(String name, boolean createIfNecessary) throws RecordStoreException {
        return new RecordStore(name);
    }

    public static void deleteRecordStore(String recordStoreName) throws RecordStoreException {
        // Stub
    }

    private String name;

    private RecordStore(String name) {
        this.name = name;
    }

    public void closeRecordStore() throws RecordStoreException {
    }

    public int getNumRecords() throws RecordStoreException {
        return 0; // Stub
    }

    public byte[] getRecord(int recordId) throws RecordStoreException {
        return null;// Stub
    }

    public int addRecord(byte[] data, int offset, int numBytes) throws RecordStoreException {
        return 1; // Stub
    }

    public void setRecord(int recordId, byte[] data, int offset, int numBytes) throws RecordStoreException {
    }

    public void deleteRecord(int recordId) throws RecordStoreException {
    }

    public RecordEnumeration enumerateRecords(Object filter, Object comparator, boolean keepUpdated) {
        return new RecordEnumeration();
    }

    public int getNextRecordID() {
        return 1;
    }

    public int getSize() {
        return 0;
    }

    public int getSizeAvailable() {
        return 100000;
    }
}
