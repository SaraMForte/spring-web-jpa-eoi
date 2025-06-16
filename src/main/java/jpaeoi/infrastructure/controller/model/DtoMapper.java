package jpaeoi.infrastructure.controller.model;

public interface DtoMapper<T, R> {

    T toDomain(R dto);

    R fromDomain(T domain);

    T emptyDomain();

    R emptyDto();
}
