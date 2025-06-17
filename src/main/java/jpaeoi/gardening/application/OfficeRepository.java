package jpaeoi.gardening.application;

import jpaeoi.gardening.domain.Office;

import java.util.List;

public interface OfficeRepository {
    List<Office> findBasicAddress();
}
