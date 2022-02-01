
package App;

import Controlador.CtrlInicio;
import Modelo.Archivo;
import Modelo.Multimedia;
import Modelo.ArregloCuentas;
import Modelo.Membresia;
import Modelo.Suscripcion;
import Modelo.Tarjeta;
import Modelo.Usuario;
import Vista.FrmInicio;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        //INSTANCIAMOS UNA VARIABLE DEL TIPO ARREGLO CUENTAS
        ArregloCuentas Cuentas = new ArregloCuentas();
        
        //Creamos una cuenta para poder testear el programa.
        Cuentas.agregarCuenta(Cuentas.crearCuenta(new Usuario("franco@gmail.com", "franco@gmail.com", "994421210"),
                new Tarjeta("Fran", "Co", "4895045575702316", "25/12", 123),
                new Suscripcion(Membresia.PREMIUM)));
        Cuentas.agregarCuenta(Cuentas.crearCuenta(new Usuario("christian@gmail.com", "christian@gmail.com", "994421210"),
                new Tarjeta("Fran", "Co", "4895045575702316", "25/12", 123),
                new Suscripcion(Membresia.PREMIUM)));
        Cuentas.agregarCuenta(Cuentas.crearCuenta(new Usuario("samuel@gmail.com", "samuel@gmail.com", "994421210"),
                new Tarjeta("Fran", "Co", "4895045575702316", "25/12", 123),
                new Suscripcion(Membresia.PREMIUM)));
        Cuentas.agregarCuenta(Cuentas.crearCuenta(new Usuario("diego@gmail.com", "diego@gmail.com", "994421210"),
                new Tarjeta("Fran", "Co", "4895045575702316", "25/12", 123),
                new Suscripcion(Membresia.PREMIUM)));
        Cuentas.agregarCuenta(Cuentas.crearCuenta(new Usuario("nick@gmail.com", "nick@gmail.com", "994421210"),
                new Tarjeta("Fran", "Co", "4895045575702316", "25/12", 123),
                new Suscripcion(Membresia.PREMIUM)));
        
        //Agregamos el catalogo de peliculas que manejara el programa
        Multimedia.crearCatalogo();
        
        //INSTANCIAMOS UNA VARAIBLE DEL TIPO FILE
        File file = new File(Archivo.archivoArregloCuentas);

        //INSTANCIAMOS LA VARIABLE ARCHIVO PARA PODER HACER USO
        //DE SERIALIZAR Y DESERIALIZAR
        Archivo archivo = new Archivo();

        //EN CASO QUE EL ARCHIVO CUENTAS NO EXISTA CREAR UNO POR DEFAULT//    
        if (!file.exists()) {
            archivo.serializar(Archivo.archivoArregloCuentas, Cuentas);
        }

        //SERIALZIANDO
        Cuentas = (ArregloCuentas) archivo.deserializar(Archivo.archivoArregloCuentas);
        
        
        FrmInicio frmInicio = new FrmInicio();
        CtrlInicio ctrlInicio = new CtrlInicio(Cuentas, frmInicio);
        ctrlInicio.init();
    }
}
