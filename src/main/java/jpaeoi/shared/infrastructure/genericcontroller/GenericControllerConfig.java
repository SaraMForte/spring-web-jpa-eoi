package jpaeoi.gandening.infrastructure.controller;

import jpaeoi.gandening.infrastructure.controller.model.DtoMapper;
import jpaeoi.shared.generictable.GenericTable;

import java.util.List;
import java.util.Optional;

public interface GenericControllerConfig<T, R> {

    List<T> findDomainAll();

    Optional<T> findDomainById(String id);

    void saveDomain(T domain);

    void updateDomain(T domain);

    void deleteDomainById(String id);

    DtoMapper<T, R> mapper();

    GenericTable getTable(List<R> entities);
}
