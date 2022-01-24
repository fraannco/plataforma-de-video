package Controlador;

import Modelo.Archivo;
import Modelo.ArregloCuentas;
import Modelo.Tarjeta;
import Vista.FrmInicio;
import Vista.FrmTarjeta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CtrlTarjeta {

    private ArregloCuentas modelo;
    private FrmTarjeta vista;
    private String auxCorreo;

    public CtrlTarjeta(ArregloCuentas modelo, FrmTarjeta vista) {
        this.modelo = modelo;
        this.vista = vista;
        
        this.vista.btnGuardarTarjeta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                try {
                    String nombre = vista.txtNombre.getText();
                    String apellido = vista.txtApellido.getText();
                    String nroTarjeta = vista.txtNroTarjeta.getText().replaceAll("-", "");
                    String fechaVencimiento = vista.txtFechaVencimiento.getText();
                    Integer cvv = Integer.parseInt(vista.txtCVV.getText().trim());

                    Tarjeta tarjetaAux = new Tarjeta(nombre, apellido, nroTarjeta, fechaVencimiento, cvv);

                    if (tarjetaAux.validar()) {
                        modelo.cuentaActiva().setTarjeta(tarjetaAux);
                        modelo.cambiarEstadoSesion(modelo.cuentaActiva().getUsuario().getCorreo());

                        
                        //Archivos.Creador.serializar(Archivos.Archivos.archivoArregloCuentas, ArregloCuentas);

                        Archivo archivo = new Archivo();
                        archivo.serializar(Archivo.archivoArregloCuentas, modelo);

                        JOptionPane.showMessageDialog(vista, "¡Bienvenido a nuestro servicio!");
                        vista.dispose();
                        FrmInicio frmInicio = new FrmInicio();
                        CtrlInicio ctrlInicio = new CtrlInicio(modelo, frmInicio);
                        ctrlInicio.init();
                    } else {
                        JOptionPane.showMessageDialog(vista, "Debe ingresar una tarjeta válida.");
                        vista.txtNroTarjeta.setText("");
                        vista.txtCVV.setText("");

                    }
                } catch (Exception e) {
                    System.out.println("EXCEPCION: " + e.getMessage());
                }

            }
        });
    }

    public void init() {
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
    }

}
