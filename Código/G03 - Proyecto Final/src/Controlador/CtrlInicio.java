package Controlador;

import Modelo.Archivo;
import Modelo.ArregloCuentas;
import Vista.FrmCatalogo;
import Vista.FrmInicio;
import Vista.FrmRegistro;
//import Vista.FrmPaquetes;
//import Vista.FrmPerfiles;
//import Vista.FrmRegistro;
//import Vista.FrmSolicitudReestablecerContrasena;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CtrlInicio {

    private ArregloCuentas modelo;
    private FrmInicio vista;

    public CtrlInicio(ArregloCuentas modelo, FrmInicio vista) {
        this.modelo = modelo;
        this.vista = vista;

        this.vista.btnIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //ACTUALIZANDO DATOS//
                Archivo archivo = new Archivo();
                ArregloCuentas modelo;
                modelo = (ArregloCuentas) archivo.deserializar(Archivo.archivoArregloCuentas);
                ///////////////////
                Boolean error = false;
                //CAPTAMOS EL CORREO Y LA CONTRASEÑA
                String correo = vista.txtUsuario.getText();
                String contraseña = vista.txtContraseña.getText().trim();
                //System.out.println("Se ingreso: "+correo+", "+contraseña);
                if (correo.isEmpty() || contraseña.isEmpty()) {
                    JOptionPane.showMessageDialog(vista, "Ingresa un usuario y/o contraseña válido(s)", "Iniciar sesión", 0);
                    vista.txtContraseña.requestFocus();
                    return;
                }

                try {
                    if (!modelo.validarInicioSesion(correo, contraseña) || !modelo.verificarEstadoSesion(correo) || !modelo.buscarCuentaPorCorreo(correo).getSuscripcion().getEstadoMembresia()) {
                        System.out.println("CORREO: " + correo);
                        JOptionPane.showMessageDialog(vista, "La cuenta ingresada no cuenta con suscripcion activa o no esta registrada");
                    } else {
                        System.out.println("asdf: "+modelo.buscarCuentaPorCorreo(correo).getSesion());
                        modelo.cambiarEstadoSesion(correo);
                        System.out.println("Cuenta activa: "+modelo.cuentaActiva().getUsuario().getCorreo());
                        
                        JOptionPane.showMessageDialog(vista, "¡Bienvenido!");
                        vista.dispose();

                        archivo.serializar(Archivo.archivoArregloCuentas, modelo);

                        FrmCatalogo frmCatalogo = new FrmCatalogo();
                        CtrlCatalogo ctrlCatalogo = new CtrlCatalogo(modelo, frmCatalogo);

                        ctrlCatalogo.init();
                    }
                } catch (Exception e) {
                    System.out.println("a EXCEPCION: " + e.getMessage());
                    JOptionPane.showMessageDialog(vista, e.getMessage());
                }
            }
        });

        this.vista.btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                vista.dispose();

                FrmRegistro fRegistro = new FrmRegistro();
                CtrlRegistro ctrlRegistro = new CtrlRegistro(modelo, fRegistro);
                ctrlRegistro.init();
            }
        });

        this.vista.btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
    }

    public String getCorreo() {
        String correo = vista.txtUsuario.getText();
        return correo;
    }

    public void init() {
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
    }
}
