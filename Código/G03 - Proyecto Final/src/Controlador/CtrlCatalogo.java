package Controlador;

import Modelo.Archivo;
import Modelo.ArregloCuentas;
import Modelo.ArregloPeliculas;
import Modelo.ArregloVideos;
import Modelo.ArregloVisualizaciones;
import Modelo.Cuenta;
import Modelo.Multimedia;
import Modelo.Pelicula;
import Modelo.Reproductor;
import Modelo.Video;
import Modelo.Visualizacion;
import Vista.FrmCatalogo;
import Vista.FrmInicio;
import Vista.FrmReproductor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class CtrlCatalogo {

    private ArregloCuentas modelo;
    private FrmCatalogo vista;
    private ArregloPeliculas peliculas;
    private ArregloVideos videos;

    private int btnSeleccionado;
    //0 inicio 1 peliculas 2 series

    int indexPrincipal;
    int indexSecDer;
    int indexSecIzq;
    int indexTerDer;
    int indexTerIzq;

    int indexRecoPrincipal;
    int indexRecoSecDer;
    int indexRecoSecIzq;
    int indexRecoTerDer;
    int indexRecoTerIzq;
    int idPerfil;

    public CtrlCatalogo(ArregloCuentas modelo, FrmCatalogo vista) {
        this.modelo = modelo;
        this.vista = vista;
        peliculas = Multimedia.catalogoPeliculas;
        this.videos = Multimedia.catalogoVideos;
        indexPrincipal = 2;
        indexSecDer = indexPrincipal + 1;
        indexSecIzq = indexPrincipal - 1;
        indexTerDer = indexSecDer + 1;
        indexTerIzq = indexSecIzq - 1;
        indexRecoPrincipal = 2;
        indexRecoSecDer = indexRecoPrincipal + 1;
        indexRecoSecIzq = indexRecoPrincipal - 1;
        indexRecoTerDer = indexRecoSecDer + 1;
        indexRecoTerIzq = indexRecoSecIzq - 1;

        ActionListener actualizar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                if (btnSeleccionado == 0) {
                    mostrarVideos();
                } else if (btnSeleccionado == 1) {
                    mostrarPeliculas();
                } else if (btnSeleccionado == 2) {
                    mostrarSeries();
                } else {
                    JOptionPane.showMessageDialog(vista, "Inserte un mensaje de error aqui");
                }

            }
        };
        ActionListener moverDer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                int parametro = 0;

                if (btnSeleccionado == 0) {
                    parametro = videos.dimension();
                } else if (btnSeleccionado == 1) {
                    parametro = peliculas.dimension();
                } else {
                    JOptionPane.showMessageDialog(vista, "Inserte un mensaje de error aqui");
                }

                indexPrincipal = indexPrincipal + 1;
                indexSecDer = indexSecDer + 1;
                indexSecIzq = indexSecIzq + 1;
                indexTerDer = indexTerDer + 1;
                indexTerIzq = indexTerIzq + 1;

                if (indexPrincipal > parametro - 1) {
                    indexPrincipal = 0;
                }
                if (indexSecDer > parametro - 1) {
                    indexSecDer = 0;
                }
                if (indexSecIzq > parametro - 1) {
                    indexSecIzq = 0;
                }
                if (indexTerDer > parametro - 1) {
                    indexTerDer = 0;
                }
                if (indexTerIzq > parametro - 1) {
                    indexTerIzq = 0;
                }

                actualizar.actionPerformed(ae);

            }
        };
        ActionListener moverIzq = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int parametro = 0;

                if (btnSeleccionado == 0) {
                    parametro = videos.dimension();
                } else if (btnSeleccionado == 1) {
                    parametro = peliculas.dimension();
                } else {
                    JOptionPane.showMessageDialog(vista, "Inserte un mensaje de error aqui");
                }

                indexPrincipal = indexPrincipal - 1;
                indexSecDer = indexSecDer - 1;
                indexSecIzq = indexSecIzq - 1;
                indexTerDer = indexTerDer - 1;
                indexTerIzq = indexTerIzq - 1;

                if (indexPrincipal < 0) {
                    indexPrincipal = parametro - 1;
                }
                if (indexSecDer < 0) {
                    indexSecDer = parametro - 1;
                }
                if (indexSecIzq < 0) {
                    indexSecIzq = parametro - 1;
                }
                if (indexTerDer < 0) {
                    indexTerDer = parametro - 1;
                }
                if (indexTerIzq < 0) {
                    indexTerIzq = parametro - 1;
                }
                actualizar.actionPerformed(e);

            }
        };
        this.vista.btnDerecha.addActionListener(moverDer);
        this.vista.btnIzquierda.addActionListener(moverIzq);

        try {
            //AGREGANDO VISUALIZACION
            ArregloVisualizaciones v = modelo.cuentaActiva2().getVisualizaciones();
            if (v == null) {
                modelo.cuentaActiva2().setVisualizaciones(new ArregloVisualizaciones());
            }
        } catch (Exception e) {

        }
        //PERSONALIZANDO EL CIERRE DEL PROGRAMA//
        vista.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        vista.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                JFrame frame = (JFrame) e.getSource();
                try {
                    //GUARDANDO LOS CAMBIOS EN EL ARCHIVO//
                    Archivo archivo = new Archivo();
                    archivo.serializar(Archivo.archivoArregloCuentas, modelo);
                    // // // // // // // // // // // // // //
                    vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                } catch (Exception ex) {
                    //Logger.getLogger(CtrlAdministrarCuenta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        ////////////////
        vista.btnInformación.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                Video videoSeleccionado = null;

                if (btnSeleccionado == 0) {
                    videoSeleccionado = videos.getVideo(indexPrincipal);
                } else if (btnSeleccionado == 1) {
                    videoSeleccionado = peliculas.getPelicula(indexPrincipal);
                }

                //SINOPSIS
                JOptionPane.showMessageDialog(vista,
                        "Titulo: " + Multimedia.catalogoPeliculas.getPelicula(indexPrincipal).getTitulo() + "\n"
                        + "Sinopsis: " + Multimedia.catalogoPeliculas.getPelicula(indexPrincipal).getSinopsis() + "\n"
                        + "Duración: " + Multimedia.catalogoPeliculas.getPelicula(indexPrincipal).getDuracion() + " minutos" + "\n"
                        + "Año: " + Multimedia.catalogoPeliculas.getPelicula(indexPrincipal).getAnio() + "\n"
                        + "Director: " + Multimedia.catalogoPeliculas.getPelicula(indexPrincipal).getDirector() + "\n"
                        + "Genero: " + Multimedia.catalogoPeliculas.getPelicula(indexPrincipal).getGenero() + "\n");
            }
        });
        this.vista.btnPrincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int indiceEnArregloVideos = 0;
                try {
                    Video v = null;
                    if (btnSeleccionado == 0) {
                        v = Multimedia.catalogoVideos.getVideo(indexPrincipal);
                        indiceEnArregloVideos = indexPrincipal;
                    } else if (btnSeleccionado == 1) {
                        v = Multimedia.catalogoPeliculas.getPelicula(indexPrincipal);
                    } else if (btnSeleccionado == 2) {
                        indiceEnArregloVideos = indexPrincipal;
                    }

                    Reproductor rep = new Reproductor();
                    FrmReproductor fRep = new FrmReproductor();
                    CtrlReproductor cRep;

                    Pelicula p = new Pelicula();
                    p = Multimedia.catalogoPeliculas.getPelicula(indexPrincipal);
                    p.setReproduciendo(true);
                    if(!modelo.cuentaActiva2().getVisualizaciones().buscarPorTitulo(p.getTitulo())){
                        System.out.println("dentro del if xd");
                        modelo.cuentaActiva2().getVisualizaciones().agregarVisulizacion(new Visualizacion(p,1));
                    }else {
                        modelo.cuentaActiva2().getVisualizaciones().buscarVisualizacion(p.getTitulo()).aumentarVisualizacion();
                        Multimedia.catalogoVideos.ver(indiceEnArregloVideos);
                    }
                    
                    Archivo archivo = new Archivo();
                    vista.dispose();
                    archivo.serializar(Archivo.archivoArregloCuentas, modelo);

                    //MOSTRANDO PELICULA
                    cRep = new CtrlReproductor(rep, fRep, v, modelo);
                    
                    cRep.init();
                    vista.dispose();
                } catch (Exception ex) {
                    Logger.getLogger(CtrlCatalogo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        this.vista.btnTerIzq.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int indiceEnArregloVideos = 0;
                try {
                    Video v = null;
                    if (btnSeleccionado == 0) {
                        v = Multimedia.catalogoVideos.getVideo(indexTerIzq);
                        indiceEnArregloVideos = indexTerIzq;
                    } else if (btnSeleccionado == 1) {
                        v = Multimedia.catalogoPeliculas.getPelicula(indexTerIzq);
                    } else if (btnSeleccionado == 2) {
                        indiceEnArregloVideos = indexTerIzq;
                    }

                    Reproductor rep = new Reproductor();
                    FrmReproductor fRep = new FrmReproductor();
                    CtrlReproductor cRep;

                    Archivo archivo = new Archivo();
                    archivo.serializar(Archivo.archivoArregloCuentas, modelo);
                    //MOSTRANDO PELICULA
                    //cRep = new CtrlReproductor(rep, fRep, v, modelo, modelo.cuentaActiva(auxCorreo));
                    //Multimedia.catalogoVideos.ver(indiceEnArregloVideos);
                    //cRep.init();
                    //vista.dispose();

                } catch (Exception ex) {
                    Logger.getLogger(CtrlCatalogo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        this.vista.btnSecIzq.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int indiceEnArregloVideos = 0;
                try {
                    Video v = null;
                    if (btnSeleccionado == 0) {
                        v = Multimedia.catalogoVideos.getVideo(indexSecIzq);
                        indiceEnArregloVideos = indexSecIzq;
                    } else if (btnSeleccionado == 1) {
                        v = Multimedia.catalogoPeliculas.getPelicula(indexSecIzq);
                    } else if (btnSeleccionado == 2) {
                        indiceEnArregloVideos = indexSecIzq;
                    }

                    Reproductor rep = new Reproductor();
                    FrmReproductor fRep = new FrmReproductor();
                    CtrlReproductor cRep;
                    Archivo archivo = new Archivo();
                    archivo.serializar(Archivo.archivoArregloCuentas, modelo);

                    //MOSTRANDO PELICULA
                    //cRep = new CtrlReproductor(rep, fRep, v, modelo, modelo.cuentaActiva(auxCorreo));
                    //Multimedia.catalogoVideos.ver(indiceEnArregloVideos);
                    //cRep.init();
                    //vista.dispose();
                } catch (Exception ex) {
                    Logger.getLogger(CtrlCatalogo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        this.vista.btnSecDer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int indiceEnArregloVideos = 0;
                try {
                    Video v = null;
                    if (btnSeleccionado == 0) {
                        v = Multimedia.catalogoVideos.getVideo(indexSecDer);
                        indiceEnArregloVideos = indexSecDer;
                    } else if (btnSeleccionado == 1) {
                        v = Multimedia.catalogoPeliculas.getPelicula(indexSecDer);
                    } else if (btnSeleccionado == 2) {
                        indiceEnArregloVideos = indexSecDer;
                    }

                    Reproductor rep = new Reproductor();
                    FrmReproductor fRep = new FrmReproductor();
                    CtrlReproductor cRep;

                    Archivo archivo = new Archivo();
                    archivo.serializar(Archivo.archivoArregloCuentas, modelo);
                    Multimedia.catalogoVideos.ver(indiceEnArregloVideos);

                    //MOSTRANDO PELICULA
                    //cRep = new CtrlReproductor(rep, fRep, v, modelo, modelo.cuentaActiva(auxCorreo));
                    //cRep.init();
                    //vista.dispose();
                } catch (Exception ex) {
                    Logger.getLogger(CtrlCatalogo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        this.vista.btnTerDer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int indiceEnArregloVideos = 0;
                try {
                    Video v = null;
                    if (btnSeleccionado == 0) {
                        v = Multimedia.catalogoVideos.getVideo(indexTerDer);
                        indiceEnArregloVideos = indexTerDer;
                    } else if (btnSeleccionado == 1) {
                        v = Multimedia.catalogoPeliculas.getPelicula(indexTerDer);
                    } else if (btnSeleccionado == 2) {
                        indiceEnArregloVideos = indexTerDer;
                    }

                    Reproductor rep = new Reproductor();
                    FrmReproductor fRep = new FrmReproductor();
                    CtrlReproductor cRep;
                    Archivo archivo = new Archivo();
                    archivo.serializar(Archivo.archivoArregloCuentas, modelo);
                    Multimedia.catalogoVideos.ver(indiceEnArregloVideos);
                    /*MOSTRANDO PELICULA
                        cRep = new CtrlReproductor(rep, fRep, v, modelo, modelo.cuentaActiva(auxCorreo));
                        cRep.init();
                        vista.dispose();*/
                } catch (Exception ex) {
                    Logger.getLogger(CtrlCatalogo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        this.vista.btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    vista.dispose();
                    Cuenta a = modelo.cuentaActiva2();
                    String Correo = a.getUsuario().getCorreo();
                    //System.out.println(Correo);
                    modelo.cambiarEstadoSesion(Correo);
                    //GUARDANDO LOS CAMBIOS EN EL ARCHIVO//
                    Archivo archivo = new Archivo();
                    archivo.serializar(Archivo.archivoArregloCuentas, modelo);
                    FrmInicio fInicio = new FrmInicio();
                    CtrlInicio ctrlInicio = new CtrlInicio(modelo, fInicio);
                    ctrlInicio.init();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(vista, "Excepcion: " + e.getMessage());
                }
            }
        });
        this.vista.btnRecomendar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    Pelicula p = Multimedia.catalogoPeliculas.recomendarPelicula(modelo.cuentaActiva2().getVisualizaciones());
                    if (p.getTitulo().equalsIgnoreCase("Nuevo video")) {
                        JOptionPane.showMessageDialog(vista, "AUN NO SE REGISTRAN VISUALIZACIONES");
                    } else {
                        JOptionPane.showMessageDialog(vista, "Se le recomienda la siguiente pelicula: " + p.getTitulo());
                    }
                } catch (Exception ex) {
                    System.out.println("EXCEPCION: " + ex.getMessage());
                }
            }
        });
        this.vista.btnTop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                try {
                    modelo.cuentaActiva2().getVisualizaciones().ordenaVectorVisualizaciones();
                    modelo.cuentaActiva2().getVisualizaciones().mostrarContenido();
                    modelo.cuentaActiva2().getVisualizaciones().mostrarTop();
                    JOptionPane.showMessageDialog(vista, modelo.cuentaActiva2().getVisualizaciones().mostrarTop());
                } catch (Exception ex) {
                    System.out.println("EXCEPCION: " + ex.getMessage());
                }
            }
        }
        );
    }

    public void init() {
        //ACTUALIZANDO DATOS//
        Archivo archivo = new Archivo();
        archivo.serializar(Archivo.archivoArregloCuentas, modelo);
        try {
            System.out.println("El correo de mi cuenta es : " + modelo.cuentaActiva2().getUsuario().getCorreo());
        } catch (Exception ex) {
            System.out.println("Inserte mensaje de error aqui");
        }
        ///////////////////
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);

        if (btnSeleccionado == 0) {
            mostrarVideos();
        } else if (btnSeleccionado == 1) {
            mostrarPeliculas();
        } else if (btnSeleccionado == 2) {
            mostrarSeries();
        } else {
            JOptionPane.showMessageDialog(vista, "Inserte un mensaje de error aqui");
        }
    }

    public void initBack() throws Exception {
        //GUARDANDO LOS CAMBIOS EN EL ARCHIVO//
        Archivo archivo = new Archivo();
        archivo.serializar(Archivo.archivoArregloCuentas, modelo);
        init();
    }

    private void mostrarPeliculas() {
        Pelicula peliculaMostradaIzq1 = peliculas.getPelicula(indexTerIzq);
        Pelicula peliculaMostradaIzq = peliculas.getPelicula(indexSecIzq);
        Pelicula peliculaMostrada = peliculas.getPelicula(indexPrincipal);
        Pelicula peliculaMostradaDer = peliculas.getPelicula(indexSecDer);
        Pelicula peliculaMostradaDer1 = peliculas.getPelicula(indexTerDer);

        vista.btnTerIzq.setText(String.valueOf(indexSecIzq));
        vista.btnPrincipal.setText(String.valueOf(indexPrincipal));
        vista.btnTerDer.setText(String.valueOf(indexSecDer));

        vista.btnTerIzq.setIcon(new ImageIcon(peliculaMostradaIzq1.getDirImg()));
        vista.btnSecIzq.setIcon(new ImageIcon(peliculaMostradaIzq.getDirImg()));
        vista.btnPrincipal.setIcon(new ImageIcon(peliculaMostrada.getDirImg()));
        vista.btnSecDer.setIcon(new ImageIcon(peliculaMostradaDer.getDirImg()));
        vista.btnTerDer.setIcon(new ImageIcon(peliculaMostradaDer1.getDirImg()));

        String lblTexto
                = "<html><h1>"
                + peliculaMostrada.getTitulo()
                + "</h1></html>";

        vista.lblPelicula.setHorizontalAlignment(SwingConstants.CENTER);
        vista.lblPelicula.setText(lblTexto);
    }

    private void mostrarSeries() {

        vista.btnTerIzq.setText(String.valueOf(indexSecIzq));
        vista.btnPrincipal.setText(String.valueOf(indexPrincipal));
        vista.btnTerDer.setText(String.valueOf(indexSecDer));

        vista.lblPelicula.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void mostrarVideos() {
        Video videoMostradaAdIzq = videos.getVideo(indexTerIzq);
        Video videoMostradaIzq = videos.getVideo(indexSecIzq);
        Video videoMostrada = videos.getVideo(indexPrincipal);
        Video videoMostradaDer = videos.getVideo(indexSecDer);
        Video videoMostradaAdDer = videos.getVideo(indexTerDer);

        vista.btnTerIzq.setText(String.valueOf(indexTerIzq));
        vista.btnSecIzq.setText(String.valueOf(indexSecIzq));
        vista.btnPrincipal.setText(String.valueOf(indexPrincipal));
        vista.btnSecDer.setText(String.valueOf(indexSecDer));
        vista.btnTerDer.setText(String.valueOf(indexTerDer));

        vista.btnTerIzq.setIcon(new ImageIcon(videoMostradaAdIzq.getDirImg()));
        vista.btnSecIzq.setIcon(new ImageIcon(videoMostradaIzq.getDirImg()));
        vista.btnPrincipal.setIcon(new ImageIcon(videoMostrada.getDirImg()));
        vista.btnSecDer.setIcon(new ImageIcon(videoMostradaDer.getDirImg()));
        vista.btnTerDer.setIcon(new ImageIcon(videoMostradaAdDer.getDirImg()));

        String lblTexto
                = "<html><h1>"
                + videoMostrada.getTitulo()
                + "</h1></html>";

        vista.lblPelicula.setHorizontalAlignment(SwingConstants.CENTER);
        vista.lblPelicula.setText(lblTexto);
    }

    public void setIdP(int i) {

        this.idPerfil = i;
    }

    public int getIdP() {
        return this.idPerfil;
    }
}
