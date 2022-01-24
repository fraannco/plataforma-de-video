package Modelo;

import java.io.Serializable;

/**
 *
 * @author ErnestoSilva
 */
public class ArregloCuentas implements Serializable {

    private Cuenta cuentas[];

    public ArregloCuentas() {
        cuentas = new Cuenta[0];
    }

    //===================
    //      METODOS
    //===================
    public void agregarCuenta(Cuenta cuenta) {
        try {
            int i;
            //Se captura la dimension del vector
            i = cuentas.length;
            Cuenta a;
            aumentarDimension();
            a = cuenta;
            cuentas[i] = a;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Indice fuera de limites: " + e);
        }
        
    }
    
    //GETTERS AND SETTERS

    public Cuenta[] getCuentas() {
        return cuentas;
    }

    public void setCuentas(Cuenta[] cuentas) {
        this.cuentas = cuentas;
    }
    
    
    
    //METODOS

    private void aumentarDimension() {
        //int n=x.length;
        int n = cuentas.length;
        n = n + 1;
        Cuenta y[] = new Cuenta[n];
        for (int i = 0; i < cuentas.length; i = i + 1) {
            y[i] = cuentas[i];
        }
        this.cuentas = y;
    }

    private void disminuirDimension() {
        int n = cuentas.length;
        n = n - 1;
        Cuenta aux[] = new Cuenta[n];

        for (int i = 0; i < n; i++) {
            aux[i] = cuentas[i];
        }
        cuentas = aux;
    }

    public void cambiarEstadoSesion(String Correo) {
        int n;
        n = cuentas.length;
        for (Cuenta c : cuentas) {
            if (c.getUsuario().getCorreo().equals(Correo)) {
                c.setSesion(!c.getSesion());
                break;
            }
        }
    }

    public boolean validarPorCorreo1(String Correo) {
        int n;
        n = cuentas.length;
        Boolean a = false;
        for (Cuenta c : cuentas) {
            if (c.getUsuario().getCorreo().equals(Correo)) {
                a = true;
                break;
            }
        }
        return a;
    }

    public Cuenta buscarCuentaPorCorreo(String Correo) throws Exception {
        int n;
        n = cuentas.length;
        Cuenta a = new Cuenta();
        Boolean b = false;
        for (Cuenta c : cuentas) {
            if (c.getUsuario().getCorreo().equals(Correo)) {
                b = true;
                a = c;
                break;
            }
        }
        if (b == false) {
            throw new Exception("EXCECIPN EN buscarCuentaPorCorreo NO SE ENCONTRÓ AL USUARIO");
        }
        return a;
    }

    public boolean validarPorCorreo(String Correo) throws Exception {
        Boolean a = false;
        for (Cuenta c : cuentas) {
            System.out.println(c.getUsuario().getCorreo());
            if (c.getUsuario().getCorreo().equals(Correo)) {
                a = true;
                //System.out.println(c.getUsuario().getCorreo());
                break;
            }
        }
        if (a == false) {
            throw new Exception("EXCECIPN EN validarPorCorreo() EL USUARIO NO HA INICIADO SESION");
        }
        return a;
    }
    
    //Semana 07 - Divide y venceras - MergeSort
    
    public void mergesort(Cuenta[] A, int izq, int der) {
        if (izq < der) {
            int m = (izq + der) / 2;
            mergesort(A, izq, m);
            mergesort(A, m + 1, der);
            merge(A, izq, m, der);
        }
    }

    public void merge(Cuenta[] A, int izq, int m, int der) {
        int i, j, k;
        Cuenta[] B = new Cuenta[A.length]; //array auxiliar
        for (i = izq; i <= der; i++) //copia ambas mitades en el array auxiliar                                       
        {
            B[i] = A[i];
        }

        i = izq;
        j = m + 1;
        k = izq;

        while (i <= m && j <= der) //copia el siguiente elemento más grande                                      
        {
            if (B[i].getUsuario().getCorreo().charAt(0) <= B[j].getUsuario().getCorreo().charAt(0)) {
                A[k++] = B[i++];
            } else {
                A[k++] = B[j++];
            }
        }

        while (i <= m) //copia los elementos que quedan de la
        {
            A[k++] = B[i++]; //primera mitad (si los hay)
        }
    }

    //Búsqueda Secuencial en un arreglo ordenado - Semana 05
    public Boolean validarInicioSesion(String Correo, String Contraseña) throws Exception {

        Boolean cuentaValida = false;
        mergesort(cuentas, 0, cuentas.length-1);
        
        int i=0;
        
        while((i <= cuentas.length-1) && (cuentaValida == false) && (Correo.charAt(0) >= cuentas[i].getUsuario().getCorreo().charAt(0))){
            if(cuentas[i].getUsuario().getCorreo().equalsIgnoreCase(Correo)&& cuentas[i].getUsuario().getContraseña().equals(Contraseña)){
                cuentaValida = true;
            }
            i++;
        }
        System.out.println("Cuenta valida: "+cuentaValida);
        return cuentaValida;
    }
    
    //Busqueda Binaria Iterativa - Semana 05:
    public boolean verificarEstadoSesion(String Correo) throws Exception {
        System.out.println("Dentro de verificarEstadoSesion");
        boolean r = Boolean.FALSE;
        int ini = 0, medio;
        int fin = cuentas.length - 1;
        while (ini <= fin) {
            medio = (ini + fin) / 2;
            if (cuentas[medio].getUsuario().getCorreo().equals(Correo)) {
                r = true;
                System.out.println(Correo);
                break;
            } else if (cuentas[medio].getUsuario().getCorreo().compareTo(Correo)>0) {
                fin = medio - 1;
            } else {
                ini = medio + 1;
            }
        }
        System.out.println(r);
        return r;
    }
    
    public Cuenta cuentaActiva() throws Exception{

        Cuenta cuentaAux = new Cuenta();
        Boolean s = true;
        for (Cuenta c : cuentas) {
            if (c.getSesion()) {
                cuentaAux = c;
                s = false;
                break;
            }
        }

        if (s == true) {
            throw new Exception("EXCEPCION EN cuentaActiva2 UN USUARIO ACTIVO");
        }
        return cuentaAux;
    }
    
    public void inactivarSesión(Cuenta cuenta) {
        cuenta.setSesion(!cuenta.getSesion());
    }

    public int posicionPorCorreo(String Correo) {
        int posicionBuscada = -1;
        int n;
        n = cuentas.length;
        for (int i = 0; i < n; i++) {
            if (cuentas[i].getUsuario().getCorreo().equals(Correo)) {
                posicionBuscada = i;
                break;
            }
        }
        return posicionBuscada;
    }

    public void eliminarPorCorreo(String Correo) {
        int nElemento = posicionPorCorreo(Correo);
        if (nElemento < cuentas.length) {
            while (nElemento < (cuentas.length - 1)) {
                cuentas[nElemento] = cuentas[nElemento + 1];
                nElemento++;
            }
            disminuirDimension();
        } else {
            System.out.println("POSICION MAYOR AL TAMAÑO DEL VECTOR...!!");
        }
    }

    public boolean editarCorreo(String correo, String nuevoCorreo) throws Exception {
        int n = cuentas.length;
        Boolean error = true;
        for (int i = 0; i <= n; i++) {
            if (cuentas[i].getUsuario().getCorreo().equals(correo)) {
                if (!validarPorCorreo1(nuevoCorreo)) {
                    error = false;
                    cuentas[i].getUsuario().setCorreo(nuevoCorreo);
                }
                break;
            }
        }
        if (error == true) {
            throw new Exception("EL NUEVO YA SE ENCUENTRA REGISTRADO");
        }
        return error;
    }

    public void mostrarCuentas() {

        for (int i = 0; i < cuentas.length; i = i + 1) {
            System.out.println("\n\n=====================================================");
            System.out.println("    CANTIDAD DE USUARIOS: " + cuentas.length + " - USUARIO Nro. " + (i + 1));
            System.out.println("=====================================================");
            System.out.println("CORREO: " + cuentas[i].getUsuario().getCorreo() + "\n"
                    + "CONTRASEÑA: " + cuentas[i].getUsuario().getContraseña() + "\n"
                    + "TELEFONO: " + cuentas[i].getUsuario().getTelefono());
            System.out.println("=====================================================");
            System.out.println("DATOS DE LA SUSCRIPCIÓN");
            System.out.println("FECHA DE REGISTRO " + cuentas[i].getSuscripcion().getFechaRegistro() + "\n"
                    + "ESTADO DE LA MEMBRESÍA: " + cuentas[i].getSuscripcion().getEstadoMembresia() + "\n"
                    + "MEMBRESÍA: " + cuentas[i].getSuscripcion().getMembresia());
            System.out.println("=====================================================");
            System.out.println("DATOS DE LA TARJETA");
            System.out.println("NOMBRE: " + cuentas[i].getTarjeta().getNombre() + "\n"
                    + "APELLIDO: " + cuentas[i].getTarjeta().getApellido() + "\n"
                    + "NUMERO DE TARJETA: " + cuentas[i].getTarjeta().getNroTarjeta() + "\n"
                    + "FECHA DE VENCIMIENTO: " + cuentas[i].getTarjeta().getFechaVencimiento().toString() + "\n"
                    + "CVV: " + cuentas[i].getTarjeta().getCvv() + "\n"
                    + "SALDO: " + cuentas[i].getTarjeta().getSaldo());
            System.out.println("=====================================================");
        }
    }

    public void mostrarCuentasActivas() {
        System.out.println("----CUENTAS ACTIVAS-------");
        for (Cuenta c : cuentas) {
            if (c.getUsuario().getDispositivosConectados() > 0) {
                System.out.println(c.getUsuario().getCorreo() + "\n");
            }

        }
        System.out.println("-----------------");
    }

    public Cuenta crearCuenta(Usuario user, Tarjeta tarjeta, Suscripcion suscripcion) {
        Cuenta cuentaNueva = new Cuenta();
        cuentaNueva.setUsuario(user);
        cuentaNueva.setTarjeta(tarjeta);
        cuentaNueva.setSuscripcion(suscripcion);
        return cuentaNueva;
    }
}
