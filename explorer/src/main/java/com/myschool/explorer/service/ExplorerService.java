package com.myschool.explorer.service;

import com.myschool.commons.dto.InstituteResponse;
import com.myschool.commons.dto.LocationCords;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExplorerService {
    private final RestTemplate restTemplate;

    public List<InstituteResponse> getAllInstitute(LocationCords cords) {
        return this.getInstituteByCategory(cords, null);
    }

    public List<InstituteResponse> getInstituteByCategory(LocationCords cords, String categoryId) {
        // internal api call TODO
        return Collections.emptyList();
    }
}
