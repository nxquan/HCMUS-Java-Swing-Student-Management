package com.mycompany.studentmanagement;

import java.io.Serializable;

public class Student implements Serializable {

    private String _id;
    private String _name;
    private String _urlAvatar;
    private float[] _scores;
    private String _address;
    private String _notes;

    public Student() {
        this._id = "";
        this._name = "";
        this._urlAvatar = "";
        this._address = "";
        this._notes = "";
        this._scores = new float[6];
    }

    public Student(String _id, String _name, String _urlAvatar, float[] _scores, String _address, String _notes) {
        this._id = _id;
        this._name = _name;
        this._urlAvatar = _urlAvatar;
        this._scores = _scores;
        this._address = _address;
        this._notes = _notes;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public String getUrlAvatar() {
        return _urlAvatar;
    }

    public void setUrlAvatar(String _urlAvatar) {
        this._urlAvatar = _urlAvatar;
    }

    public float[] getScores() {
        return _scores;
    }

    public void setScore(float s, int pos) {
        this._scores[pos] = s;
    }

    public float getScore(int pos) {
        return this._scores[pos];
    }

    public void setScores(float[] _scores) {
        this._scores = _scores;
    }

    public String getAddress() {
        return _address;
    }

    public void setAddress(String _address) {
        this._address = _address;
    }

    public String getNotes() {
        return _notes;
    }

    public void setNotes(String _notes) {
        this._notes = _notes;
    }

    public void reset() {
        this._id = "";
        this._name = "";
        this._urlAvatar = "";
        this._address = "";
        this._notes = "";
        this._scores = new float[6];
    }

    public String[] convertArrayString() {
        
        
        String[] temp = {
            this._id,
            this._name,
            this._urlAvatar,
            Float.toString(this._scores[0]),
            Float.toString(this._scores[1]),
            Float.toString(this._scores[2]),
            Float.toString(this._scores[3]),
            Float.toString(this._scores[4]),
            Float.toString(this._scores[5]),
            this._address,
            this._notes
        };
        return temp;
    }

    public static Student parser(String[] rawData) {
        float temp[] = {
            Float.parseFloat(rawData[3]),
            Float.parseFloat(rawData[4]),
            Float.parseFloat(rawData[5]),
            Float.parseFloat(rawData[6]),
            Float.parseFloat(rawData[7]),
            Float.parseFloat(rawData[8])};
        Student s = new Student(rawData[0], rawData[1], rawData[2], temp, rawData[9], rawData[10]);

        return s;
    }
}
