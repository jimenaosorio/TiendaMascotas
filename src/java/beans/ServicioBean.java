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
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Informatica
 */
@Stateless
public class ServicioBean implements ServicioBeanLocal {

    @PersistenceContext(unitName = "TiendaMascotasPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Usuario iniciarSesion(String rut, String clave) {
        try{
            return (Usuario) em.createNamedQuery("Usuario.iniciarSesion", Usuario.class).setParameter("rutUser",rut).setParameter("clave", clave).getSingleResult(); //Los dos parámetros de entrada
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public void guardar(Object object) {
        em.persist(object);
    }
    
    
    @Override
    public List<Categoria> getCategorias() {
        return em.createNamedQuery("Categoria.findAll").getResultList();
    }

    @Override
    public List<Producto> getProductos() {
        return em.createNamedQuery("Producto.findAll").getResultList();
    }

    @Override
    public void sincronizar(Object o) {
        em.merge(o); //Guarda el producto en la lista de su categoría
        em.flush();
    }

    @Override
    public Categoria buscarCategoria(int id) {
        return em.find(Categoria.class,id);
    }

     @Override
    public Usuario buscarUsuario(String rut) {
        return em.find(Usuario.class,rut);
    }
}
