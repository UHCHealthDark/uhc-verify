package io.github.wickeddroid.plugin.mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import team.unnamed.inject.Inject;
import team.unnamed.inject.Provider;

public class MongoDatabaseProvider implements Provider<MongoDatabase> {

  @Inject
  private MongoClient mongoClient;

  @Override
  public MongoDatabase get() {
    return this.mongoClient.getDatabase(System.getProperty("mongo.database"));
  }
}
