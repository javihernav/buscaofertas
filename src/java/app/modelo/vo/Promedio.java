/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.modelo.vo;

/**
 *
 * @author JAVIER
 */
public class Promedio {
    double puntosPrecio;
    double puntosCalidad;

    public Promedio() {
    }

    public Promedio(double puntosPrecio, double puntosCalidad) {
        this.puntosPrecio = puntosPrecio;
        this.puntosCalidad = puntosCalidad;
    }

    public double getPuntosPrecio() {
        return puntosPrecio;
    }

    public void setPuntosPrecio(double puntosPrecio) {
        this.puntosPrecio = puntosPrecio;
    }

    public double getPuntosCalidad() {
        return puntosCalidad;
    }

    public void setPuntosCalidad(double puntosCalidad) {
        this.puntosCalidad = puntosCalidad;
    }

    @Override
    public String toString() {
        return "Promedio [" + "puntosCalidad " + puntosCalidad + " " + "puntosPrecio " + puntosPrecio + "]";
    }
}
