/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mir00r.bean;

import java.io.*;
import java.util.*;
import javax.faces.bean.*;
import javax.faces.context.*;
import javax.faces.event.*;

/**
 *
 * @author Abdur Razzak <abdur.razzaq06@gmail.com>
 */
@ManagedBean
@SessionScoped
public class LocaleBean implements Serializable {

    private final Locale ENGLISH = Locale.ENGLISH;
    private final Locale SPANISH = new Locale("es");
    private final Locale FRENCH = Locale.FRENCH;
    private final Locale BANGLA = new Locale("bn");
    private Locale locale = ENGLISH;

    public Locale getLocale() {
        return (locale);
    }

    public void setBangla(ActionEvent event) {
        locale = BANGLA;
        updateViewLocale();
    }

    public void setEnglish(ActionEvent event) {
        locale = ENGLISH;
        updateViewLocale();
    }

    public void setSpanish(ActionEvent event) {
        locale = SPANISH;
        updateViewLocale();
    }

    public void setFrench(ActionEvent event) {
        locale = FRENCH;
        updateViewLocale();
    }

    private void updateViewLocale() {
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }
}
