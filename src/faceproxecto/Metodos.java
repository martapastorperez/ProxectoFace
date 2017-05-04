package faceproxecto;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Group;
import facebook4j.Post;
import facebook4j.PostUpdate;
import facebook4j.ResponseList;
import facebook4j.conf.ConfigurationBuilder;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Metodos {

    String mensaje;
    static String foto;
    static Facebook facebook;

    public static void autorizar() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthAppId("1885158391756593")
                .setOAuthAppSecret("f043621a6e53ff21d0d6d4c0e6b4bd2a")
                .setOAuthAccessToken("EAAayiqRJNzEBAIUVYUOl4PEy8fecYBnRPdSINfpt8Nypyd4xx9Dcya8aBNqG034wCnCUmkwwXtcQlj4TkZACxj7dQBFDUyqs3EZAqDC7yNFlaO1wGOIkrbkS14juOXPFkq3FmXFL4BCVZCgU54bVJZAxDoe9dXIZD")
                .setOAuthPermissions("email,publish_stream,publish_actions,user_likes,manage_pages,read_stream");
        FacebookFactory ff = new FacebookFactory(cb.build());
        facebook = ff.getInstance();

    }

    /**
     * Para publicar un mensaje
     *
     * @throws facebook4j.FacebookException
     */
    public static void publicarMensaje() throws FacebookException {
        facebook.postStatusMessage(JOptionPane.showInputDialog("Inserta tu mensaje:"));

    }

    /**
     * para publicar una imagen con un enlace
     */
    public static void publicarImagen() {
        PostUpdate post = null;
        try {
            post = new PostUpdate(new URL("http://facebook4j.org"))
                    .picture(new URL("http://facebook4j.org/images/hero.png"))
                    .name("Facebook4J - A Java library for the Facebook Graph API")
                    .caption("facebook4j.org")
                    .description("Facebook4J is a Java library for the Facebook Graph API.");
        } catch (MalformedURLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            facebook.postFeed(post);
        } catch (FacebookException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  
    /**
     * comentar en fotos
     */
    public static void comentarFoto( ) {

        try {

            facebook.commentPhoto(" ", JOptionPane.showInputDialog("¿Que quieres comentar en la foto? "));

        } catch (FacebookException ex) {

            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    
    /**
     * metodo para buscar
     */
    public static void buscar() {

        try {
            ResponseList<Post> results = facebook.searchPosts(JOptionPane.showInputDialog("Palabra por la que quieres buscar: "));
            for (int i = 0; i < results.size(); i++) {
                System.out.println(results.get(i));
            }
        } catch (FacebookException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
}
