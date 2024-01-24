package io.github.wickeddroid.plugin.mongo;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import team.unnamed.inject.Provider;

public class MongoClientProvider implements Provider<MongoClient> {

  private static final ConnectionString CONNECTION_STRING = new ConnectionString(
          System.getProperty("mongo.uri")
  );

  private static final MongoClientSettings MONGO_CLIENT_SETTINGS = MongoClientSettings
          .builder()
          .applyConnectionString(CONNECTION_STRING)
          .build();

  @Override
  public MongoClient get() {
    return MongoClients.create(MONGO_CLIENT_SETTINGS);
  }
}
