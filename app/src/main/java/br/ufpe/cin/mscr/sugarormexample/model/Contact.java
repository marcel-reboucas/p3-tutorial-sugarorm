package br.ufpe.cin.mscr.sugarormexample.model;

import com.orm.SugarRecord;

/**
 * Created by Marcel on 11/07/2015.
 */
public class Contact extends SugarRecord{

    private String name;
    private String phone;

    public Contact(){}

    public Contact(final String name, final String phone){
        this.setName(name);
        this.setPhone(phone);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String toString(){
        return this.name;
    }
}
