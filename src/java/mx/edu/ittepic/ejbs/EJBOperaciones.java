/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.ittepic.ejbs;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import mx.edu.ittepic.entidades.Usuario;
import mx.edu.ittepic.entidades.Administrador;
import mx.edu.ittepic.entidades.Objeto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;

/**
 *
 * @author DanielaMarcela
 */
@Stateless
public class EJBOperaciones {
    @PersistenceContext
    EntityManager em;
    
     public String nuevoUsuario(String nombreusuario,String apellidousuario,String passwordusuario,String regionusuario,String contactousuario, int usuarioid)
    {
        Usuario r=new Usuario();
        r.setNombreusuario(nombreusuario);
        r.setApellidousuario(apellidousuario);
        r.setPasswordusuario(passwordusuario);
        r.setRegionusuario(regionusuario);
        r.setContactousuario(contactousuario);
        r.setIdusuario(usuarioid);
        String msj;
        
        try
        {
            em.persist(r);
            msj="{\"code\":200, \"msj\":\"La operacion se realizo correctamente\"}";
        }catch(Exception e)
        {
            msj="{\"code\":400, \"msj\":\"Error en los parametros\"}";
        }
        return msj;
    }
     
     public String consultaUsuario()
    {
        try
        {
            Query q;
            List<Usuario> listaUsuario;
            q=em.createNamedQuery("Usuario.findAll");
            listaUsuario= q.getResultList();
            
            //convertir la lista a objetos json
            GsonBuilder builder= new GsonBuilder();
            Gson gson= builder.create();
            return gson.toJson(listaUsuario);
          
        }catch(Exception e)
        {
            return "{msg:'Error'}";
        }
    }
      public String actualizaUsuario(int usuarioid,String nombreusuario,String apellidousuario,String passwordusuario,String regionusuario,String contactousuario){
	GsonBuilder builder=new GsonBuilder();
	Gson gson=builder.create();
	String msj;
	Usuario usuario=new Usuario();
	try{
            usuario=em.find(Usuario.class,usuarioid);//Busca por rolid
            usuario.setNombreusuario(nombreusuario);
            usuario.setApellidousuario(apellidousuario);
            usuario.setPasswordusuario(passwordusuario);
            usuario.setRegionusuario(regionusuario);
            usuario.setContactousuario(contactousuario);
            em.merge(usuario);
            msj="Codigo:200-La operacion se realizo correctamente";
	}catch(NumberFormatException e){
	msj="{\"codigo\":400\"msj:\"Error en los tipos de parametros\"}";
	}//fin del try
    return msj;
}//Fin actualizaUsuario
      
      public String eliminaUsuario(int idusuario)
    {
        Usuario usuario=new Usuario();
        String msj;
        try{
            usuario=(Usuario) em.createNamedQuery("Usuario.findByIdusuario").setParameter("idusuario", idusuario).getSingleResult();
            em.remove(em.merge(usuario));
             msj="Codigo:200-La operacion se realizo correctamente}";
        }catch(NumberFormatException e)
        {
            msj="{\"codigo\":400\"msj:\"Error en los tipos de parametros\"}";
        }
        return msj;
    }
      
      
      //=========ADINISTRADOR===============================================
 public String nuevoAdmin(String nombreadmin,String apellidoadmin,String passwordadmin, int adminid)
    {
        Administrador r=new Administrador();
        r.setNombreadministrador(nombreadmin);
        r.setApellidoadministrador(apellidoadmin);
        r.setPasswordadministrador(passwordadmin);
        r.setIdadministrador(adminid);
        String msj;
        
        try
        {
            em.persist(r);
            msj="{\"code\":200, \"msj\":\"La operacion se realizo correctamente\"}";
        }catch(Exception e)
        {
            msj="{\"code\":400, \"msj\":\"Error en los parametros\"}";
        }
        return msj;
    }
     
     public String consultaAdmin()
    {
        try
        {
            Query q;
            List<Administrador> listaAdministrador;
            q=em.createNamedQuery("Administrador.findAll");
            listaAdministrador= q.getResultList();
            
            //convertir la lista a objetos json
            GsonBuilder builder= new GsonBuilder();
            Gson gson= builder.create();
            return gson.toJson(listaAdministrador);
          
        }catch(Exception e)
        {
            return "{msg:'Error'}";
        }
    }
      public String actualizaAdmin(int adminid,String nombreadmin,String apellidoadmin, String passwordadmin){
	GsonBuilder builder=new GsonBuilder();
	Gson gson=builder.create();
	String msj;
	Administrador admin=new Administrador();
	try{
            admin=em.find(Administrador.class,adminid);//Busca por rolid
            admin.setNombreadministrador(nombreadmin);
            admin.setApellidoadministrador(apellidoadmin);
            admin.setPasswordadministrador(passwordadmin);
            
            em.merge(admin);
            msj="Codigo:200-La operacion se realizo correctamente";
	}catch(NumberFormatException e){
	msj="{\"codigo\":400\"msj:\"Error en los tipos de parametros\"}";
	}//fin del try
    return msj;
}//Fin actualizaUsuario
      
      public String eliminaAdmin(int idadmin)
    {
        Administrador admin=new Administrador();
        String msj;
        try{
            admin=(Administrador) em.createNamedQuery("Administrador.findByIdadministrador").setParameter("idadmin", idadmin).getSingleResult();
            em.remove(em.merge(admin));
             msj="Codigo:200-La operacion se realizo correctamente}";
        }catch(NumberFormatException e)
        {
            msj="{\"codigo\":400\"msj:\"Error en los tipos de parametros\"}";
        }
        return msj;
    }
      
   //==================================OBJETO===========================
      

      public String nuevoObjeto(String nombreobj,String imagenobj,String descripcionobj, int objid, int usuarioid)
    {
        Objeto r=new Objeto();
        r.setNombreobjeto(nombreobj);
        r.setImagenobjeto(imagenobj);
        r.setDescripcionobjeto(descripcionobj);
        r.setIdobjeto(objid);
        r.setIdusuario(usuarioid);
        String msj;
        
        try
        {
            em.persist(r);
            msj="{\"code\":200, \"msj\":\"La operacion se realizo correctamente\"}";
        }catch(Exception e)
        {
            msj="{\"code\":400, \"msj\":\"Error en los parametros\"}";
        }
        return msj;
    }
     
     public String consultaObjeto()
    {
        try
        {
            Query q;
            List<Objeto> listaObjeto;
            q=em.createNamedQuery("Objeto.findAll");
            listaObjeto= q.getResultList();
            
            //convertir la lista a objetos json
            GsonBuilder builder= new GsonBuilder();
            Gson gson= builder.create();
            return gson.toJson(listaObjeto);
          
        }catch(Exception e)
        {
            return "{msg:'Error'}";
        }
    }
      public String actualizaObjeto(int objid,String nombreobj,String imagenobj,String descripcionobj){
	GsonBuilder builder=new GsonBuilder();
	Gson gson=builder.create();
	String msj;
	Objeto obj=new Objeto();
	try{
            obj=em.find(Objeto.class,objid);//Busca por rolid
            obj.setNombreobjeto(nombreobj);
            obj.setImagenobjeto(imagenobj);
            obj.setDescripcionobjeto(descripcionobj);
            
            em.merge(obj);
            msj="Codigo:200-La operacion se realizo correctamente";
	}catch(NumberFormatException e){
	msj="{\"codigo\":400\"msj:\"Error en los tipos de parametros\"}";
	}//fin del try
    return msj;
}//Fin actualizaUsuario
      
      public String eliminaObjeto(int idobj)
    {
        Objeto obj=new Objeto();
        String msj;
        try{
            obj=(Objeto) em.createNamedQuery("Objeto.findByIdobjeto").setParameter("idobj", idobj).getSingleResult();
            em.remove(em.merge(obj));
             msj="Codigo:200-La operacion se realizo correctamente}";
        }catch(NumberFormatException e)
        {
            msj="{\"codigo\":400\"msj:\"Error en los tipos de parametros\"}";
        }
        return msj;
    }
      
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
