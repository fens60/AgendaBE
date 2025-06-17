package es.ieslosmontecillos.AppAgendaBE.controller;

import es.ieslosmontecillos.AppAgendaBE.entity.reports.Reports;
import net.sf.jasperreports.engine.JasperExportManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class ReportController
{
    @Autowired
    private Environment environment;

    @GetMapping(value="/reports/byId/{id}")
    public ResponseEntity<Object> getByID(@PathVariable int id)
    {
        Reports report = Reports.values()[id];
        return getFilledReportResponse(report);
    }

    @GetMapping(value="/reports/byName/{name}")
    public ResponseEntity<Object> getByName(@PathVariable String name)
    {
        Reports report = Reports.getReportByName(name);
        return getFilledReportResponse(report);
    }

    private ResponseEntity<Object> getFilledReportResponse(Reports report) {
        try
        {
            return new ResponseEntity<>(JasperExportManager.exportReportToXml(report.fillReport(null, environment)), HttpStatus.OK);
        }
        catch (Exception e)
        {
            Map<String, Object> map = new HashMap<>();
            map.put("error", HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
