package com.example.demo.Services;

import com.example.demo.Dao.BasestationDao;
import com.example.demo.Dao.MobilestationDao;
import com.example.demo.Dto.BaseStaionResult;
import com.example.demo.Dto.NotFoundMS;
import com.example.demo.Dto.Report;
import com.example.demo.Entity.BasestationEntity;
import com.example.demo.Entity.MobilestationEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class MobileStationSearchService {

    private final BasestationDao basestationDao;
    private final MobilestationDao mobilestationEntityDao;
    private BaseStaionResult baseStaionResult;
    private Report report;

    public MobileStationSearchService(BasestationDao basestationDao,
                                      MobilestationDao mobilestationEntityDao) {

        this.mobilestationEntityDao = mobilestationEntityDao;
        this.basestationDao = basestationDao;
    }

    public ResponseEntity<?> searchLocation(Integer uuid) {

        Date date = new Date();

        List<BasestationEntity> getBSList = basestationDao.getAllBy();
        List<BaseStaionResult> resultSet = new ArrayList<>();
        MobilestationEntity getMSData = mobilestationEntityDao.getFirstById(uuid);

        getBSList.parallelStream().forEach(getSingleBSdata -> {

                List<Report> reports = new ArrayList<>();

                baseStaionResult = new BaseStaionResult();
                baseStaionResult.setBase_station_id(getSingleBSdata.getId());

                if(getMSData != null) {
                    report = new Report();
                    report.setMobile_station_id(getMSData.getId());
                    report.setTimestamp(date.getTime());
                    report.setDistance(getDistance(getSingleBSdata.getX(), getMSData.getLastX(),
                            getSingleBSdata.getY(), getMSData.getLastY()));
                    reports.add(report);
                }
            baseStaionResult.setReports(reports);
            resultSet.add(baseStaionResult);
        });

        if(!resultSet.get(0).getReports().isEmpty()) {
            return new ResponseEntity<>(resultSet, HttpStatus.OK);
        }

        else {
            NotFoundMS notFound = new NotFoundMS();

            notFound.setError_code(404);
            notFound.setError_description("Not Found in Range");
            notFound.setError_radius(0.00f);
            resultSet.clear();

            return new ResponseEntity<>(notFound, HttpStatus.OK);
        }
    }

    private float getDistance(double latitudeBS, double latitudeMS, double longitudeBS, double longitudeMS) {

        if ((latitudeBS == latitudeMS) && (longitudeBS == longitudeMS)) {
            return 0;
        }
        else {
            double theta = longitudeBS - longitudeMS;

            double distance = Math.sin(Math.toRadians(latitudeBS)) * Math.sin(Math.toRadians(latitudeMS)) +
                    Math.cos(Math.toRadians(latitudeBS)) * Math.cos(Math.toRadians(latitudeMS)) * Math.cos(Math.toRadians(theta));

            distance = Math.acos(distance);
            distance = Math.toDegrees(distance);
            distance = distance * 60 * 1.1515;
            distance = (distance * 1.609344) * 1000;

            return ((float)distance);
        }
    }
}
