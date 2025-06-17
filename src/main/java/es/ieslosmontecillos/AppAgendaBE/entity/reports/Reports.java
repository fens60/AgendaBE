package es.ieslosmontecillos.AppAgendaBE.entity.reports;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.core.env.Environment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;
import java.util.Objects;

public enum Reports
{
    USUARIO_REPORT;

    public static final String REPORT_FOLDER = "/reports/";
    public static JasperReport[] reports;

    public static void loadReports()
    {
        reports = new JasperReport[Reports.values().length];
        for (Reports report : Reports.values())
        {
            reports[report.ordinal()] = report.loadReport();
        }
    }

    private JasperReport loadReport()
    {
        try
        {
            return (JasperReport) JRLoader.loadObject(Objects.requireNonNull(this.getClass().getResourceAsStream(getReportPath())));
        }
        catch (Exception e)
        {
            System.err.println("Error loading report: " + this.getReportName());
            System.err.println(e.getMessage());
            return null;
        }
    }

    public JasperPrint fillReport(Map<String, Object> parameters, Environment environment)
    {
        try
        {
            String url = environment.getProperty("spring.datasource.url");
            String user = environment.getProperty("spring.datasource.username");
            String password = environment.getProperty("spring.datasource.password");

            if (url == null || user == null || password == null) throw new Exception("No se pudo conseguir los datos de conexion a la BD");


            return JasperFillManager.fillReport(reports[ordinal()], parameters, DriverManager.getConnection(url, user, password));
        }
        catch (Exception e)
        {
            System.err.println("Error filling report: " + this.getReportName());
            System.err.println(e.getMessage());
        }
        return null;
    }

    public JasperPrint fillReport(Map<String, Object> parameters, Connection connection)
    {
        try
        {
            return JasperFillManager.fillReport(reports[ordinal()], parameters, connection);
        }
        catch (Exception e)
        {
            System.err.println("Error filling report: " + this.getReportName());
            System.err.println(e.getMessage());
        }
        return null;
    }

    private String getReportPath()
    {
        return REPORT_FOLDER + this.getReportName() + ".jasper";
    }

    public String getReportName()
    {
        return switch (this)
        {
            case USUARIO_REPORT -> "Usuario";
        };
    }

    public static Reports getReportByName(String reportName)
    {
        return switch (reportName)
        {
            case "Usuario" -> USUARIO_REPORT;
            default -> throw new IllegalStateException("Error no tiene este informe: " + reportName);
        };
    }
}
