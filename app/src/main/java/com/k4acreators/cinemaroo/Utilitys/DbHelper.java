package com.k4acreators.cinemaroo.Utilitys;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.k4acreators.cinemaroo.Models.Movie;
import com.k4acreators.cinemaroo.Models.Theatre;
import com.k4acreators.cinemaroo.Models.User;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by PC on 1/23/2018.
 */

public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "SinemaRooDb";
    // User table name
    private static final String TABLE_USER = "user";
    private static final String TABLE_THEATER = "theater";
    // User Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PHONE_NUMBER = "phone_number";
    private static final String KEY_NICNUMBER = "nic_number";
    private static final String KEY_BIRTH_DATE = "birth_date";
    private static final String KEY_PASSWORD = "password ";
    private static final String KEY_TOKEN = "token";
    private static final String KEY_THEA_NAME = "theaname";
    private static final String KEY_THEA_LAT = "thealat";
    private static final String KEY_THEA_LONG = "thealong";
    private static final String KEY_THEA_DISCRIPTION = "theadiscription";

    private static final String KEY_MOVIE_NAME="moviename";
    private static final String KEY_MOVIE_STR_DATE="moviestrdate";
    private static final String KEY_MOVIE_END_DATE="movieenddate";
    private static final String KEY_MOVIE_DISCRIPTION="moviediscription";
    private static final String KEY_MOVIE_LINK="movielink";

    private static final String[] COLUMNS = {KEY_ID,KEY_USERNAME,KEY_PHONE_NUMBER,KEY_NICNUMBER,KEY_BIRTH_DATE,KEY_PASSWORD,KEY_TOKEN};
    private static final String[] COLUMNSTHEA = {KEY_ID,KEY_THEA_NAME,KEY_THEA_LAT,KEY_THEA_LONG,KEY_THEA_DISCRIPTION};

    public DbHelper(Context context) {
        super(context, "SinemaRooDb",null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE = "CREATE TABLE user( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "username TEXT, "+
                "phone_number TEXT, "+
                "nic_number  TEXT, "+
                "birth_date TEXT, " +
                "password TEXT, " +
                "token TEXT )";

        String CREATE_THEATER_TABLE = "CREATE TABLE theater( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "theaname TEXT, "+
                "thealat TEXT, "+
                "thealong  TEXT, "+
                "theadiscription TEXT )";
        // create user table
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_THEATER_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS user");
        db.execSQL("DROP TABLE IF EXISTS theater");
        this.onCreate(db);
    }

    public boolean addUser(User user){
        //for logging
        Log.d("addUser", user.toString());

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(KEY_USERNAME, user.getUsername());
        values.put(KEY_PHONE_NUMBER, user.getPhone_number());
        values.put(KEY_NICNUMBER, user.getNic_number());
        values.put(KEY_BIRTH_DATE, user.getBirth_date());
        values.put(KEY_PASSWORD, user.getPassword());
        values.put(KEY_TOKEN,user.getToken());

        // 3. insert
        db.insert(TABLE_USER, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values

        // 4. close
        db.close();
        return true;
    }
    public User getBook(int id){

        // 1. get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();

        // 2. build query
        Cursor cursor =
                db.query(TABLE_USER, // a. table
                        COLUMNS, // b. column names
                        " id = ?", // c. selections
                        new String[] { String.valueOf(id) }, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit

        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();

        // 4. build book object
        User book = new User();
        book.setId(Integer.parseInt(cursor.getString(0)));
        book.setUsername(cursor.getString(1));
        book.setPhone_number(cursor.getString(2));
        book.setPhone_number(cursor.getString(2));
        book.setPhone_number(cursor.getString(2));

        //log
        Log.d("getBook("+id+")", book.toString());

        // 5. return book
        return book;
    }

    public List<User> getAllUsers() {
        List<User> users = new LinkedList<User>();

        // 1. build the query
        String query = "SELECT  * FROM " + TABLE_USER;

        // 2. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // 3. go over each row, build book and add it to list
        User user = null;
        if (cursor.moveToFirst()) {
            do {
                user = new User();
                user.setId(Integer.parseInt(cursor.getString(0)));
                user.setUsername(cursor.getString(1));
                user.setPhone_number(cursor.getString(2));
                user.setNic_number(cursor.getString(3));
                user.setBirth_date(cursor.getString(4));
                user.setPassword(cursor.getString(5));
                user.setToken(cursor.getString(6));

                // Add book to books
                users.add(user);
            } while (cursor.moveToNext());
        }

        Log.d("getAllusers()", users.toString());

        // return books
        return users;
    }


    ////////////////////////////////////////////////

    //Theater
    public boolean AddTheat(Theatre theatre)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_THEA_NAME, theatre.getThName());
        values.put(KEY_THEA_LAT, theatre.getThLat());
        values.put(KEY_THEA_LONG, theatre.getThLong());
        values.put(KEY_THEA_DISCRIPTION, theatre.getThDiscrption());
        // insert row in table
        long insert = db.insert(TABLE_THEATER, null, values);
        db.close();
        return true;
    }

    public List<Theatre> getAllTheater()
    {
        List<Theatre> theaters = new LinkedList<Theatre>();

        // 1. build the query
        String query = "SELECT  * FROM " + TABLE_USER;

        // 2. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // 3. go over each row, build book and add it to list
        Theatre theater = null;
        if (cursor.moveToFirst()) {
            do {
                theater = new Theatre();
                theater.setId(Integer.parseInt(cursor.getString(0)));
                theater.setThName(cursor.getString(1));
                theater.setThLat(cursor.getString(2));
                theater.setThLong(cursor.getString(3));
                theater.setThDiscrption(cursor.getString(4));

                // Add book to books
                theaters.add(theater);
            } while (cursor.moveToNext());
        }

        Log.d("getAlltheater()", theaters.toString());

        // return books
        return theaters;
    }

    ////////////////////////////////////////////////
    public boolean AddMovie(Movie movie)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_MOVIE_NAME, movie.getMovName());
        values.put(KEY_MOVIE_STR_DATE, movie.getMovStartDate());
        values.put(KEY_MOVIE_END_DATE, movie.getMovEndDate());
        values.put(KEY_MOVIE_DISCRIPTION, movie.getMovDiscrption());
        values.put(KEY_MOVIE_LINK, movie.getLink());
        // insert row in table
        long insert = db.insert(TABLE_THEATER, null, values);
        db.close();
        return true;
    }

    public List<Movie> getAllMovie()
    {
        List<Movie> movies = new LinkedList<Movie>();

        // 1. build the query
        String query = "SELECT  * FROM " + TABLE_USER;

        // 2. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // 3. go over each row, build book and add it to list
        Movie movie = null;
        if (cursor.moveToFirst()) {
            do {
                movie = new Movie();
                movie.setId(Integer.parseInt(cursor.getString(0)));
                movie.setMovName(cursor.getString(1));
                movie.setMovStartDate(cursor.getString(2));
                movie.setMovEndDate(cursor.getString(3));
                movie.setMovDiscrption(cursor.getString(4));
                movie.setLink(cursor.getString(5));

                // Add book to books
                movies.add(movie);
            } while (cursor.moveToNext());
        }

        Log.d("getAlltheater()", movies.toString());

        // return books
        return movies;
    }

}
