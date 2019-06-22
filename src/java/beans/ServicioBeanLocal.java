/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entidades.Categoria;
import entidades.Producto;
import entidades.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Informatica
 */
@Local
public interface ServicioBeanLocal {

    Usuario iniciarSesion(String rut, String clave);

    void guardar(Object object);
    
     //Categorías
    List<Categoria> getCategorias();
    
    //Productos
    List<Producto> getProductos();
    void sincronizar(Object o);
    Categoria buscarCategoria(int id); //Para reconocer la categoría que viene del combo box
    
    
    //Buscar usuario
    Usuario buscarUsuario(String rut);
}
