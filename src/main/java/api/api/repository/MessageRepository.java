package api.api.repository;

import api.api.domain.Message;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;
import java.util.UUID;

public interface MessageRepository extends CassandraRepository<Message, UUID>, CustomizedSave<Message> {

    @AllowFiltering
    List<Message> findMessagesByEmail(String email);

    @AllowFiltering
    List<Message> findMessagesByMagicNumber(int magicNumber);
}
