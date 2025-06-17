package jpaeoi.gandening.application;

import jpaeoi.gandening.domain.Office;

import java.util.List;

public interface OfficeRepository {
    List<Office> findBasicAddress();
}
