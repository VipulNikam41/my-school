package com.myschool.manageops.service;

import com.myschool.commons.dto.InstituteResponse;
import com.myschool.commons.dto.LocationCords;
import com.myschool.manageops.domain.entities.Institute;
import com.myschool.manageops.domain.mapper.InstituteMapper;
import com.myschool.manageops.domain.repository.InstituteRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.myschool.constants.Defaults.SEARCH_RADIUS;

@Service
@RequiredArgsConstructor
@Slf4j
public class LandingPageService {
    private final InstituteRepo instituteRepo;
    private final InstituteMapper instituteMapper;

    public List<InstituteResponse> getAllInstitute(LocationCords cords) {
        return this.getInstituteByCategory(cords, null);
    }

    public List<InstituteResponse> getInstituteByCategory(LocationCords cords, String categoryId) {
        List<Institute> instituteList;
        if ( categoryId == null ) {
            instituteList = this.getInstitutesByLocation(cords);
        } else {
            instituteList = this.getInstitutesByLocationAndCatogory(cords, categoryId);
        }

        return instituteList.stream()
                .map(instituteMapper::entityToDto)
                .toList();
    }

    private List<Institute> findByLocation(LocationCords cords) {
        int radius = cords.getRadius() == null ?
                            SEARCH_RADIUS :
                            Integer.parseInt(cords.getRadius());

        return instituteRepo.findByLocation(
                minRange(cords.getXCordinate(), radius),
                maxRange(cords.getXCordinate(), radius),
                minRange(cords.getYCordinate(), radius),
                maxRange(cords.getYCordinate(), radius)
        );
    }

    private String minRange(String cord, int radius) {
        if(radius < 0) {
            return null;
        }
        return cord;
    }

    private String maxRange(String cord, int radius) {
        if(radius == 0) {
            return null;
        }
        return cord;
    }

    private List<Institute> getInstitutesByLocationAndCatogory(LocationCords cords, String categoryId) {
        if (cords == null) {
            return instituteRepo.findAll();
        } else {
            return this.findByLocation(cords);
        }
    }

    private List<Institute> getInstitutesByLocation(LocationCords cords) {
        if (cords == null) {
            return instituteRepo.findAll();
        } else {
            return this.findByLocation(cords);
        }
    }
}
