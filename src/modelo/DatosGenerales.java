/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Natsu98fx
 */
public class DatosGenerales {
    
    private int codigo_sede;
    private String ruc;
    private String nombre;
    private String telefono;
    private String direccion;
    private String mensaje;

    public DatosGenerales() {
    }

    public DatosGenerales(int codigo_sede, String ruc, String nombre, String telefono, String direccion, String mensaje) {
        this.codigo_sede = codigo_sede;
        this.ruc = ruc;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.mensaje = mensaje;
    }

    public int getCodigo_sede() {
        return codigo_sede;
    }

    public void setCodigo_sede(int codigo_sede) {
        this.codigo_sede = codigo_sede;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
    
    
}
