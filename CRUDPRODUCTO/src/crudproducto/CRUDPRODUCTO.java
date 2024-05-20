
package crudproducto;

import Controlador.CtrlProducto;
import Modelo.ConsultaProducto;
import Modelo.Producto;
import Vista.frmProducto;

public class CRUDPRODUCTO {


    public static void main(String[] args) {
        
        Producto mod = new Producto();
        ConsultaProducto modC = new ConsultaProducto();
        frmProducto frm = new frmProducto();
        CtrlProducto ctrl = new CtrlProducto(mod, modC,frm);
        ctrl.iniciar();
        frm.setVisible(true);
    }
    
}
