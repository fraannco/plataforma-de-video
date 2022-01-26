package Controlador;

import Modelo.Archivo;
import Modelo.ArregloCuentas;
import Modelo.Cuenta;
import Vista.FrmAdministrarCuenta;
import Vista.FrmCatalogo;
import Vista.FrmPlanes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.JOptionPane;

public class CtrlAdministrarCuenta {

    ArregloCuentas modelo;
    FrmAdministrarCuenta vista;

    public CtrlAdministrarCuenta(ArregloCuentas modelo, FrmAdministrarCuenta vista) {
        this.modelo = modelo;
        this.vista = vista;

        this.vista.btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                mostrarDatos();
            }
        });

        this.vista.btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Archivo archivo = new Archivo();
                vista.dispose();

                archivo.serializar(Archivo.archivoArregloCuentas, modelo);

                FrmCatalogo frmCatalogo = new FrmCatalogo();
                CtrlCatalogo ctrlCatalogo = new CtrlCatalogo(modelo, frmCatalogo);

                ctrlCatalogo.init();
            }
        });

        this.vista.btnCambiarCorreo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {

                    String password = JOptionPane.showInputDialog("Ingrese su contraseña actual");
                    if (password.length() != 0 && password.equals(modelo.cuentaActiva().getUsuario().getContraseña())) {
                        String correo = JOptionPane.showInputDialog("Ingrese su nuevo correo");
                        if (correo.length() != 0 && correo.contains("@") && correo.contains(".com")) {
                            modelo.cuentaActiva().getUsuario().setCorreo(correo);
                            JOptionPane.showMessageDialog(null, "Se cambio el correo exitosamente");
                        } else {
                            JOptionPane.showMessageDialog(null, "El correo ingresado no es valido");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "La contraseña no coincide con tu cuenta o el campo esta vacio");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Hubo un error, prueba de nuevo");
                    System.out.println(e.getMessage());
                }
            }
        });

        this.vista.btnCambiarPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {

                    String password = JOptionPane.showInputDialog("Ingrese su contraseña actual");
                    if (password.length() != 0 && password.equals(modelo.cuentaActiva().getUsuario().getContraseña())) {
                        String newPassword = JOptionPane.showInputDialog("Ingrese la nueva contraseña");
                        modelo.cuentaActiva().getUsuario().setContraseña(newPassword);
                        JOptionPane.showMessageDialog(null, "Se cambio el correo exitosamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "Algun campo ingresado no es el correo o esta vacío");
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Hubo un error, prueba de nuevo");
                    System.out.println(e.getMessage());
                }
            }
        });

        this.vista.btnCambiarTelefono.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {

                    String password = JOptionPane.showInputDialog("Ingrese su contraseña actual");
                    if (password.length() != 0 && password.equals(modelo.cuentaActiva().getUsuario().getContraseña())) {
                        String nuevoTelefono = JOptionPane.showInputDialog("Ingrese el nuevo telefono");
                        modelo.cuentaActiva().getUsuario().setTelefono(nuevoTelefono);
                        JOptionPane.showMessageDialog(null, "Se cambio el correo exitosamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "La contraseña no coincide con tu cuenta o el campo esta vacio");
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "La contraseña no coincide con tu cuenta o el campo esta vacio");
                    System.out.println(e.getMessage());
                }
            }
        });

        this.vista.btnCambiarPlan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                vista.dispose();
                FrmPlanes frmPlanes = new FrmPlanes();
                CtrlCambiarPlan ctrlPlanes = new CtrlCambiarPlan(modelo, frmPlanes);
                ctrlPlanes.init();
            }
        });
    }

    public void init() {
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
        mostrarDatos();
    }

    private void mostrarDatos() {
        try {
            String password = "";
            Cuenta datosCuenta = modelo.cuentaActiva();
            this.vista.txtCorreo.setText(datosCuenta.getUsuario().getCorreo());
            for (int i = 0; i < datosCuenta.getUsuario().getContraseña().length(); i++) {
                password = password + "*";
            }
            this.vista.txtContraseña.setText(password);
            this.vista.txtPlan.setText(datosCuenta.getSuscripcion().getMembresia().name());
            this.vista.txtTelefono.setText(datosCuenta.getUsuario().getTelefono());
        } catch (Exception e) {
            System.out.println("Excepcion: " + e.getMessage());
        }
    }
}
