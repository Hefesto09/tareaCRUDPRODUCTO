
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Modelo.ConsultaProducto;
import Modelo.Producto;
import Vista.frmProducto;


public class CtrlProducto implements ActionListener{
    
    private Producto mod;
    private ConsultaProducto modC;
    private frmProducto frm;
    
    public CtrlProducto(Producto mod, ConsultaProducto modC, frmProducto frm){
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        this.frm.btnGuardar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);        
    }
    
    public void iniciar(){
        frm.setTitle("PRODUCTO");
        frm.setLocationRelativeTo(null);
        frm.txtId.setVisible(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        int longitud=frm.txtPrecio.getText().length() * frm.txtNombre.getText().length()*
                frm.txtCodigo.getText().length()*frm.txtCantidad.getText().length();
        //Si pulso el botón Guardar
        if (e.getSource()==frm.btnGuardar) {
            if (longitud==0){
                JOptionPane.showMessageDialog(null, "Ingrese todos los campos");
                frm.txtCodigo.requestFocus();
            }else{
                mod.setCodigo(frm.txtCodigo.getText());
                mod.setNombre(frm.txtNombre.getText());
                mod.setPrecio(Double.parseDouble(frm.txtPrecio.getText()));
                mod.setCantidad(Integer.parseInt(frm.txtCantidad.getText()));
                if (modC.registrar(mod)) {
                    JOptionPane.showMessageDialog(null, "Registro Guardado");
                    limpiar();
                }else{
                    JOptionPane.showMessageDialog(null, "Error al Guardar");
                    limpiar();
                }
            }            
        }
        
        //Si pulso el botón Modificar
        if (e.getSource()==frm.btnModificar) {
            if (longitud==0){
                JOptionPane.showMessageDialog(null, "Ingrese todos los campos");
                frm.txtCodigo.requestFocus();
            }else{
                mod.setId(Integer.parseInt(frm.txtId.getText()));
                mod.setCodigo(frm.txtCodigo.getText());
                mod.setNombre(frm.txtNombre.getText());
                mod.setPrecio(Double.parseDouble(frm.txtPrecio.getText()));
                mod.setCantidad(Integer.parseInt(frm.txtCantidad.getText()));
                if (modC.modificar(mod)) {
                    JOptionPane.showMessageDialog(null, "Registro Modificado");
                    limpiar();
                }else{
                    JOptionPane.showMessageDialog(null, "Error al Modificar");
                    limpiar();
                }
            }
        }
        
        //Si pulso el botón Eliminar
        if (e.getSource()==frm.btnEliminar) {
            if (longitud==0){
                JOptionPane.showMessageDialog(null, "Ingrese el Codigo y Buscar");
                frm.txtCodigo.requestFocus();
            }else{
                mod.setId(Integer.parseInt(frm.txtId.getText()));            
                if (modC.eliminar(mod)) {
                    JOptionPane.showMessageDialog(null, "Registro Eliminado");
                    limpiar();
                }else{
                    JOptionPane.showMessageDialog(null, "Error al Eliminar");
                    limpiar();
                }
            }            
        }
        
        //Si pulso el botón Buscar
        if (e.getSource()==frm.btnBuscar) {
            mod.setCodigo(frm.txtCodigo.getText());            
            if (modC.buscar(mod)) {
                frm.txtId.setText(String.valueOf(mod.getId()));
                frm.txtCodigo.setText(mod.getCodigo());
                frm.txtNombre.setText(mod.getNombre());
                frm.txtPrecio.setText(String.valueOf(mod.getPrecio()));
                frm.txtCantidad.setText(String.valueOf(mod.getCantidad()));
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro registro");
                limpiar();
            }
        }
        
         //Si pulso el botón Limpiar
        if (e.getSource()==frm.btnLimpiar) {
            limpiar();
        }
    }
    
    public void limpiar(){
        frm.txtId.setText(null);
        frm.txtCodigo.setText(null);
        frm.txtNombre.setText(null);
        frm.txtPrecio.setText(null);
        frm.txtCantidad.setText(null);
        frm.txtCodigo.requestFocus();
    }
    
}
