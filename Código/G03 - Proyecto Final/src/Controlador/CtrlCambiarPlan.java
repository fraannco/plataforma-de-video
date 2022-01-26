package Controlador;

import Modelo.ArregloCuentas;
import Modelo.Membresia;
import Modelo.Suscripcion;
import Vista.FrmAdministrarCuenta;
import Vista.FrmPlanes;
import Vista.FrmTarjeta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlCambiarPlan {

    private ArregloCuentas modelo;
    private FrmPlanes vista;

    public CtrlCambiarPlan(ArregloCuentas modelo, FrmPlanes vista) {
        this.modelo = modelo;
        this.vista = vista;

        this.vista.btnBasico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    modelo.cuentaActiva().setSuscripcion(new Suscripcion(Membresia.BASIC));
                    vista.dispose();
                    FrmAdministrarCuenta frmAdminCuenta = new FrmAdministrarCuenta();
                    CtrlAdministrarCuenta ctrlAdminCuenta = new CtrlAdministrarCuenta(modelo, frmAdminCuenta);
                    ctrlAdminCuenta.init();
                } catch (Exception e) {
                    System.out.println("EXCEPCION: " + e.getMessage());
                }
            }
        });

        this.vista.btnStandard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                try {
                    modelo.cuentaActiva().setSuscripcion(new Suscripcion(Membresia.STANDARD));
                    vista.dispose();
                    FrmAdministrarCuenta frmAdminCuenta = new FrmAdministrarCuenta();
                    CtrlAdministrarCuenta ctrlAdminCuenta = new CtrlAdministrarCuenta(modelo, frmAdminCuenta);
                    ctrlAdminCuenta.init();
                } catch (Exception e) {
                    System.out.println("EXCEPCION: " + e.getMessage());
                }
            }
        });

        this.vista.btnPremium.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                try {
                    modelo.cuentaActiva().setSuscripcion(new Suscripcion(Membresia.PREMIUM));
                    vista.dispose();
                    FrmAdministrarCuenta frmAdminCuenta = new FrmAdministrarCuenta();
                    CtrlAdministrarCuenta ctrlAdminCuenta = new CtrlAdministrarCuenta(modelo, frmAdminCuenta);
                    ctrlAdminCuenta.init();
                } catch (Exception e) {
                    System.out.println("EXCEPCION: " + e.getMessage());
                }

            }
        });

        this.vista.btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                try {
                    vista.dispose();
                    FrmAdministrarCuenta frmAdminCuenta = new FrmAdministrarCuenta();
                    CtrlAdministrarCuenta ctrlAdminCuenta = new CtrlAdministrarCuenta(modelo, frmAdminCuenta);
                    ctrlAdminCuenta.init();
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
