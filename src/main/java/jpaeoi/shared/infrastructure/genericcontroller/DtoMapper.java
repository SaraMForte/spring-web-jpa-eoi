package jpaeoi.shared.infrastructure.genericcontroller;

public interface DtoMapper<T, R> {

    T toDomain(R dto);

    R fromDomain(T domain);

    T emptyDomain();

    R emptyDto();
}
