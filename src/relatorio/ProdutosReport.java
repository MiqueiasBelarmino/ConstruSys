/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorio;


import java.util.List;
import entidade.Produto;
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
public class ProdutosReport {

    public ProdutosReport(List<Produto> list) {
        build(list);
    }

    private void build(List<Produto> list) {
        try {

            StyleBuilder style = style().setTextAlignment(HorizontalTextAlignment.CENTER, VerticalTextAlignment.TOP)
                    .setRightBorder(stl.pen2Point());

            report()//create new report design

                    .columns(
                            col.column("Código", "codigo", type.stringType()).setTitleStyle(style).setStyle(style),
                            col.column("Descrição", "descricao", type.stringType()).setTitleStyle(style).setStyle(style),
                            col.column("Unidade", "unidade", type.stringType()).setTitleStyle(style).setStyle(style),
                            col.column("Preço Unitario", "precoUnitario", type.stringType()).setTitleStyle(style).setStyle(style),
                            col.column("Quantidade", "quantidade", type.stringType()).setTitleStyle(style).setStyle(style),
                            col.column("Fornecedor", "provider", type.stringType()).setTitleStyle(style).setStyle(style))
                    .title(cmp.text("Produtos\n"))//shows report title
                    .pageFooter(cmp.pageXofY())//shows number of page at page footer
                    .setDataSource(createDataSource(list))//set datasource
                    .show(false);//create and show report
        } catch (DRException e) {
            e.printStackTrace();

        }

    }

    private JRDataSource createDataSource(List<Produto> list) {

        DRDataSource dataSource = new DRDataSource("codigo", "descricao", "unidade","precoUnitario","quantidade","provider");

        for (Produto produto : list) {
                       dataSource.add(String.valueOf(produto.getCodigo()),String.valueOf(produto.getDescricao())
                       ,String.valueOf(produto.getUnidade()),String.valueOf(produto.getPrecoUnitario())
                       ,String.valueOf(produto.getQuantidade()),String.valueOf(produto.getProvider()));
        }
        return dataSource;

    }

}
