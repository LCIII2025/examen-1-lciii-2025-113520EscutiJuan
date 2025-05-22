package org.example.parking;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.*;

public class EstacionamientoTest {

    @Test
    public void testRetirarVehiculo() throws Exception {
        //TODO test
  Estacionamiento estacionamiento = new Estacionamiento();
  Cliente cliente = new Cliente("12345678", "Juan");
  Vehiculo vehiculo = new Vehiculo("ABC123", "Ferrari", Vehiculo.Tipo.AUTO);

  estacionamiento.ingresarVehiculo(cliente.getDni(), cliente.getNombre(), vehiculo);
 Ticket ticket = estacionamiento.retirarVehiculo(vehiculo.getPatente());


 assertNotNull(ticket);
 assertEquals(vehiculo.getPatente(), ticket.getVehiculo().getPatente());
 assertNotNull(ticket.getHoraSalida());
    }

    @Test
    public void testCalcularPrecio() throws Exception {
        // TODO test
    Estacionamiento estacionamiento = new Estacionamiento();
    Cliente cliente = new Cliente("12345678", "Juan");
    Vehiculo vehiculo = new Vehiculo("ABC123", "Ferrari", Vehiculo.Tipo.AUTO);

    estacionamiento.ingresarVehiculo(cliente.getDni(), cliente.getNombre(), vehiculo);
    Ticket ticket = estacionamiento.retirarVehiculo(vehiculo.getPatente());
 long minutos = ticket.calcularMinutos();
 double precioCalculado = ticket.calcularPrecio();

 long horasEsperadas = (minutos + 59) / 60;
 double precioEsperado = horasEsperadas * 100;

assertTrue(precioCalculado >= 100);
assertTrue(precioCalculado <= horasEsperadas * 100);
    }

}