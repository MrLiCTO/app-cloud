package com.lingxin.cloud.ui.app.log;

import com.mongodb.*;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

/**
 * mrli
 * 2016/09/25
 */
public class MongoAppender extends AppenderSkeleton {
    private MongoClient mongoClient;
    private DB db;
    private DBCollection dbCollection;
    private String connectionUrl;
    private String databaseName;
    private String collectionName;

    @Override
    protected void append(LoggingEvent loggingEvent) {
        try {
            if (db == null) {
                MongoClientURI connectionString = new MongoClientURI(connectionUrl);
                mongoClient = new MongoClient(connectionString);
                db = mongoClient.getDB(databaseName);
                dbCollection = db.getCollection(collectionName);
            }
            dbCollection.insert((BasicDBObject) loggingEvent.getMessage());
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    @Override
    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }

    @Override
    public boolean requiresLayout() {
        return false;
    }

    public MongoClient getMongoClient() {
        return mongoClient;
    }

    public void setMongoClient(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    public DB getDb() {
        return db;
    }

    public void setDb(DB db) {
        this.db = db;
    }

    public DBCollection getDbCollection() {
        return dbCollection;
    }

    public void setDbCollection(DBCollection dbCollection) {
        this.dbCollection = dbCollection;
    }

    public String getConnectionUrl() {
        return connectionUrl;
    }

    public void setConnectionUrl(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }
}