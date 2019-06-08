package api.api.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.InsertOptions;

public class CustomizedSaveImpl<T> implements CustomizedSave {

    @Autowired
    private CassandraOperations cassandraOperations;

    @Override
    public Object save(Object entity, int ttl) {
        InsertOptions insertOptions = InsertOptions.builder().ttl(ttl).build();
        cassandraOperations.insert(entity, insertOptions);
        return entity;
    }
}
