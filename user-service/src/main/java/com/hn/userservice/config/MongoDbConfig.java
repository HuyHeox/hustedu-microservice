package com.hn.userservice.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Collections;
@Configuration
public class MongoDbConfig {
    @Value("${mongodb.database}") private String databaseName;
    @Value("${mongodb.host}") private String host;

    @Bean
    @Profile("dev")
    public MongoDatabase mongodbConfigDev() {
        System.out.println("databaseName : " + databaseName);
        CodecRegistry pojoCodecRegistry = CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                pojoCodecRegistry);
        ConnectionString connectionString = new ConnectionString(String.format("mongodb://%s:27017/?authSource=admin",  host));
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .codecRegistry(codecRegistry)
                .applyToClusterSettings(builder ->
                        builder.hosts(Collections.singletonList(new ServerAddress(host))))
                .build();
        MongoClient mongoClient = MongoClients.create(settings);
        return mongoClient.getDatabase(databaseName);
    }

    @Bean
    @Profile("prod")
    public MongoDatabase mongodbConfigProd() {
        CodecRegistry pojoCodecRegistry = CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                pojoCodecRegistry);
        ConnectionString connectionString = new ConnectionString(String.format("mongodb://%s:27017/?authSource=admin",  host));
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .codecRegistry(codecRegistry)
                .applyToClusterSettings(builder ->
                        builder.hosts(Collections.singletonList(new ServerAddress(host))))
                .build();
        MongoClient mongoClient = MongoClients.create(settings);
        return mongoClient.getDatabase(databaseName);
    }
}

