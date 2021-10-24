package com.weatherapp.key;

import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccessKeyRepository extends MongoRepository<AccessKey, String> {

    AccessKey save(AccessKey accessKey);
}
