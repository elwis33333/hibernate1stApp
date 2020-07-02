package sda11.hibernate;

import javax.persistence.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Date;


@Entity(name = "types")
public class ORMTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int anInt;
    private short aShort;
    private double aDouble;
    private String string;
    @Transient //mówi że hasło może krążyć w świecie obiektów ale nie może być utrwalone - jest w javie ale nie w bazie
    private String password;
    private String passHash;
    private float aFloat;
    private int[] array;
    @Temporal(TemporalType.DATE)
    private Date date;
    @Temporal(TemporalType.TIME)
    private Date time;
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    //private PoryRoku poryRoku;  //tak zapisuje w formie intów
    @Enumerated(EnumType.STRING) //tak będzie zapisywał w formie stringów
    @Column(length = 10)  //ustawienie domyślnej długości ciągów znaków w bazie danych
    private PoryRoku poryRoku;
    public void setPoryRoku(PoryRoku poryRoku) {
        this.poryRoku = poryRoku;
    }

    public PoryRoku getPoryRoku() {
        return poryRoku;
    }

    public void setPassword(String password) {
        this.password = password;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(password.getBytes());
            setPassHash(Arrays.toString(digest));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public void setPassHash(String passHash) {
        this.passHash = passHash;
    }

    public String getPassword() {
        return password;
    }

    public String getPassHash() {
        return passHash;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Date getTime() {
        return time;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }



    public void setaFloat(float aFloat) {
        this.aFloat = aFloat;
    }

    public float getaFloat() {
        return aFloat;
    }

    public ORMTypes() { } //POJO = plain old java object

    public Long getId() {
        return id;
    }

    public int getAnInt() {
        return anInt;
    }

    public short getaShort() {
        return aShort;
    }

    public double getaDouble() {
        return aDouble;
    }

    public String getString() {
        return string;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }

    public void setaShort(short aShort) {
        this.aShort = aShort;
    }

    public void setaDouble(double aDouble) {
        this.aDouble = aDouble;
    }

    public void setString(String string) {
        this.string = string;
    }

}
