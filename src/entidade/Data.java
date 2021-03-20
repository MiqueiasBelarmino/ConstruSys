/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.util.GregorianCalendar;

/**
 *
 * @author aluno
 */
public class Data {

    public Data() {
    }

    private Object data;

    public Object pegaDataAtual() {
        GregorianCalendar calendar = new GregorianCalendar();
        int dia = calendar.get(GregorianCalendar.DAY_OF_MONTH);
        int mes = calendar.get(GregorianCalendar.MONTH);
        int ano = calendar.get(GregorianCalendar.YEAR);
        String mese =null;
        switch(mes){
            case 1:{
                mese = "Janeiro";
            }
            case 2:{
                mese = "Fevereiro";
            }
            case 3:{
                mese = "Março";
            }
            case 4:{
                mese = "Abril";
            }
            case 5:{
                mese = "Maio";
            }
            case 6:{
                mese = "Junho";
            }
            case 7:{
                mese = "Julho";
            }
            case 8:{
                mese = "Agosto";
            }
            case 9:{
                mese = "Setembro";
            }
            case 10:{
                mese = "Outubro";
            }
            case 11:{
                mese = "Novembro";
            }
            case 12:{
                mese = "Dezembro";
            }
        }

        data = dia + " de " + mese + " de " + ano;
        return this.data;
    }
    
}
