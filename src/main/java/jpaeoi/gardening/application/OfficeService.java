package jpaeoi.gardening.application;

import jpaeoi.gardening.domain.Office;

import java.util.List;

public class OfficeService {

    private OfficeRepository officeRepository;

    public OfficeService(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    public List<Office> findBasicAddress() {
        return officeRepository.findBasicAddress();
    }
}
