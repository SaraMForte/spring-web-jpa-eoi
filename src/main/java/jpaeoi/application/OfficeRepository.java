package jpaeoi.application;

import jpaeoi.domain.Office;

import java.util.List;

public interface OfficeRepository {
    List<Office> findBasicAddress();
}
