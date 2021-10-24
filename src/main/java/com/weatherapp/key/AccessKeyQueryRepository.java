package com.weatherapp.key;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AccessKeyQueryRepository extends MongoRepository<AccessKey, String > {

    public Optional<AccessKey> findAccessKeyById(String id);
}
