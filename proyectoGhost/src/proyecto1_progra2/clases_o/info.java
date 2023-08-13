/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_progra2.clases_o;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author pcast
 */
public class info {
    private String username;
    private String password;
    private Date creacion;
    
    public info(String username, String password,Date creacion) {//int puntos iniciales
        this.username = username;
        this.password = password;
        this.creacion = creacion;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String newPassword) {
        password = newPassword;
    }
    public Date getFechaCreada() {
        return creacion;
    }
    
}
