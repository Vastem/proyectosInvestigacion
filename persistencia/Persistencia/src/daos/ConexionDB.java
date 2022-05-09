/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import interfaces.IConexionDB;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

public class ConexionDB implements IConexionDB{
    
    private static final String HOST = "localhost";
    private static final int PUERTO = 27017;
    private static final String BASE_DATOS = "proyectos_Investigacion";
    
    @Override
    public MongoDatabase crearConexion() {
       try{
            //CONFIGURACIÃ“N PARA QUE MONGODRIVE REALICE EL MAPEO DE POJOS AUMATICAMENTE
z            CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
            
            CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
            
            ConnectionString cadenaConexion = new ConnectionString("mongodb://"+HOST+"/"+PUERTO);
            
            MongoClientSettings clientsSettings = MongoClientSettings.builder()
                .applyConnectionString(cadenaConexion)
                .codecRegistry(codecRegistry)
                .build();
            
            MongoClient clienteMongo = MongoClients.create(clientsSettings);
            
            MongoDatabase baseDatos = clienteMongo.getDatabase(BASE_DATOS);
            
            return baseDatos;           
        }catch(Exception ex){
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
}