package reporte;

import entity.Turnoa;
import entity.Turnod;   
import entityDAO.TurnoaDAO;
import entityDAO.TurnodDAO;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.swing.JRViewer;


/**
 *
 * @author Bel Walter
 */
public class ReporteTurno {

    private String nombre = new File ("").getAbsolutePath ()+"/src";
    private String directorio = new File ("").getAbsolutePath ()+"/src/image";
	
    private int dni;
    private boolean opc1;
    private boolean opc2;
    private boolean opc3;
    private int tipo;
    private Date fecha1;
    private Date fecha2;

    public ReporteTurno(int tipo, boolean opc1, boolean opc2, boolean opc3,int dni, Date fecha1, Date fecha2) {
    	this.dni = dni;
        this.opc1 = opc1;
        this.opc2 = opc2;
        this.opc3 = opc3;
        this.tipo = tipo;
        this.fecha1 = fecha1;
        this.fecha2 = fecha2;
    }
    
    public void generarReporte(){
        try {
            List<Turnod> docentes = null;
            List<Turnoa> admins = null;
            Map<String, Object> parameters = new HashMap<String, Object>();
            int numero = 0;
            double canth = 0;
            Calendar cal1 = Calendar.getInstance();
	    Calendar cal2 = Calendar.getInstance();
	    parameters.put("directorio", directorio);
            /*if (tipo==1){
                //reporte unico 
            }
            else{
                if(opc1){
                    //reporte adm separado por cargo
                }else{
                    //reporte adm junto
                    */
                    admins = new TurnoaDAO().FiltroAdmin(dni, fecha1, fecha2);
                    canth=0;
                    if((admins!=null)&&(admins.size()>0)){
                        if(admins.get(0).getTipo()=='E'){numero=1;}
                        else{numero=2;}
                        while(numero<=admins.size()-1){
                            cal1.setTime(admins.get(numero-1).getHora());
                            cal2.setTime(admins.get(numero).getHora());
                            long milis1 = cal1.getTimeInMillis();
                            long milis2 = cal2.getTimeInMillis();
                            long diff = milis2 - milis1;
                            //long diffHours = diff / (60 * 60 * 1000);
                            if(diff>=0){canth = canth + diff;}
                                numero=numero+2;}
                        canth = canth  / (60 * 60 * 1000);
                        System.out.println(new DecimalFormat(".##").format(canth));
                        parameters.put("canth", canth);
                        JasperReport report = (JasperReport)JRLoader.loadObject(new File(nombre + "/reporte/reportAdm.jasper"));
                        JRDataSource beanCollectionDataSource = null;
                        
                        beanCollectionDataSource = new JRBeanCollectionDataSource(admins, true);
                        JasperPrint print = JasperFillManager.fillReport(report, parameters, beanCollectionDataSource);
                        
                        
                        JDialog viewer = new JDialog(new JFrame(),"Vista previa del reporte", true);
                        viewer.setSize(900,700);
                        viewer.setLocationRelativeTo(null);
                        JRViewer jrv = new JRViewer(print);
                        viewer.getContentPane().add(jrv);
                        viewer.setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null, "No hay datos de registros administrativos para realizar informes");}
                /*}
                if(opc2 || opc3){
                    if(opc2){
                        //reporte doc separado por carrera
                    }else{
                        //reporte doc separado por catedra
                    }
                }
                else{
                    //reporte doc junto
                    */
                    docentes = new TurnodDAO().FiltroDoc(dni, fecha1, fecha2);
                    canth=0;
                    if((docentes!=null)&&(docentes.size()>0)){
                        if(docentes.get(0).getTipo()=='E'){numero=1;}
                        else{numero=2;}
                        while(numero<=docentes.size()-1){
                            cal1.setTime(docentes.get(numero-1).getHora());
                            cal2.setTime(docentes.get(numero).getHora());
                            long milis1 = cal1.getTimeInMillis();
                            long milis2 = cal2.getTimeInMillis();
                            long diff = milis2 - milis1;
                            //long diffHours = diff / (60 * 60 * 1000);
                            if(diff>=0){canth = canth + diff;}
                                numero=numero+2;}
                        canth = canth  / (60 * 60 * 1000);
                        System.out.println(new DecimalFormat(".##").format(canth));
                        parameters.put("canth", canth);
                        JasperReport report = (JasperReport)JRLoader.loadObject(new File(nombre + "/reporte/reportDoc.jasper"));
                        JRDataSource beanCollectionDataSource = null;
                
                        beanCollectionDataSource = new JRBeanCollectionDataSource(docentes, true);
                        JasperPrint print = JasperFillManager.fillReport(report, parameters, beanCollectionDataSource);
                
                        JDialog viewer = new JDialog(new JFrame(),"Vista previa del reporte", true);
                        viewer.setSize(900,700);
                        viewer.setLocationRelativeTo(null);
                        JRViewer jrv = new JRViewer(print);
                        viewer.getContentPane().add(jrv);
                        viewer.setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null, "No hay datos de registros docentes para realizar informes");}
                /*}
            }*/
		/*	
	    if(parameters != null && ((docentes != null)||(admins != null))){
                JasperReport report = (JasperReport)JRLoader.loadObject(new File(nombre));
                JRDataSource beanCollectionDataSource = null;
                
                if (tipo==1){beanCollectionDataSource = new JRBeanCollectionDataSource(docentes, true);}
                else{beanCollectionDataSource = new JRBeanCollectionDataSource(admins, true);}
                    
                JasperPrint print = JasperFillManager.fillReport(report, parameters, beanCollectionDataSource);
                
                JDialog viewer = new JDialog(new JFrame(),"Vista previa del reporte", true);
                viewer.setSize(900,700);
                viewer.setLocationRelativeTo(null);
                JRViewer jrv = new JRViewer(print);
                viewer.getContentPane().add(jrv);
                viewer.setVisible(true);
                
            }*/}
        catch (Exception e) {
            e.printStackTrace();
        }}
}
