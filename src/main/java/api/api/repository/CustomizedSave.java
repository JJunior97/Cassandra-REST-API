package api.api.repository;

public interface CustomizedSave<T> {
    <S extends T> S save(S entity, int ttl);
}
