
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class EmployeeDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "employee.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_EMPLOYEE = "employee";

    // Employee table columns
    private static final String COLUMN_EID = "eid";
    private static final String COLUMN_ENAME = "ename";
    private static final String COLUMN_ADEPT = "adept";
    private static final String COLUMN_ESALARY = "esalary";

    public EmployeeDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create employee table
        String createTable = "CREATE TABLE " + TABLE_EMPLOYEE + " ("
                + COLUMN_EID + " INTEGER PRIMARY KEY, "
                + COLUMN_ENAME + " TEXT, "
                + COLUMN_ADEPT + " TEXT, "
                + COLUMN_ESALARY + " REAL)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EMPLOYEE);
        onCreate(db);
    }

    // Method to insert employee record
    public void insertEmployee(int eid, String ename, String adept, float esalary) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_EID, eid);
        values.put(COLUMN_ENAME, ename);
        values.put(COLUMN_ADEPT, adept);
        values.put(COLUMN_ESALARY, esalary);

        db.insert(TABLE_EMPLOYEE, null, values);
        db.close(); // Close database connection
    }
}
