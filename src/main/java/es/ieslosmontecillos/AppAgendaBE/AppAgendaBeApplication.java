package es.ieslosmontecillos.AppAgendaBE;

import es.ieslosmontecillos.AppAgendaBE.entity.reports.Reports;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppAgendaBeApplication {

    public static void main(String[] args) {
        Reports.loadReports();
        SpringApplication.run(AppAgendaBeApplication.class, args);
    }

}

