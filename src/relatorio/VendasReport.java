/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorio;

import entidade.Venda;
import java.text.SimpleDateFormat;
import java.util.List;
import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import static net.sf.dynamicreports.report.builder.style.Styles.style;

import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;

import net.sf.dynamicreports.report.constant.VerticalTextAlignment;

import net.sf.dynamicreports.report.datasource.DRDataSource;

import net.sf.dynamicreports.report.exception.DRException;

import net.sf.jasperreports.engine.JRDataSource;

/**
 *
 * @author andreani
 */
public class VendasReport {

    public VendasReport(List<Venda> list) {
        build(list);
    }

    private void build(List<Venda> list) {
        try {

            StyleBuilder style = style().setTextAlignment(HorizontalTextAlignment.CENTER, VerticalTextAlignment.TOP)
                    .setRightBorder(stl.pen2Point());

            report()//create new report design

                    .columns(
                            col.column("Código", "codigo", type.stringType()).setTitleStyle(style).setStyle(style),
                             col.column("Data", "data", type.dateType()).setTitleStyle(style).setStyle(style),
                            col.column("Pagamento", "pagamento", type.stringType()).setTitleStyle(style).setStyle(style),
                            col.column("Parcelas", "parcelas", type.stringType()).setTitleStyle(style).setStyle(style),
                            col.column("Status", "status", type.stringType()).setTitleStyle(style).setStyle(style))
                    .title(cmp.text("Venda\n"))//shows report title
                    .pageFooter(cmp.pageXofY())//shows number of page at page footer
                    .setDataSource(createDataSource(list))//set datasource
                    .show(false);//create and show report
        } catch (DRException e) {
            e.printStackTrace();

        }

    }

    private JRDataSource createDataSource(List<Venda> list) {

        DRDataSource dataSource = new DRDataSource("codigo","data","pagamento","parcelas","status");

        for (Venda venda : list) {
            dataSource.add(String.valueOf(venda.getCod_venda()),venda.getData(),String.valueOf(venda.getFormaPagto())
            ,String.valueOf(venda.getParcelas()),venda.getStatus());
        }
        return dataSource;

    }

}
