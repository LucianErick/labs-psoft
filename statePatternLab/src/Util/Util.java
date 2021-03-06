package src.Util;

import src.Classes.Vacinacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Util {

    public static final String JA_HABILITADO_PRIMEIRA_DOSE = "Usuário já habilitado para primeira dose.";
    public static final String JA_HABILITADO_SEGUNDA_DOSE = "Usuário já habilitado para segunda dose.";
    public static final String JA_TOMOU_PRIMEIRA_DOSE = "Usuário já tomou a primeira dose.";
    public static final String JA_TOMOU_SEGUNDA_DOSE = "Usuário já tomou a segunda dose.";
    public static final String NAO_HABILITADO_SEGUNDA_DOSE = "Usuário inabilitado para segunda dose.";
    public static final String HABILITADO_SEGUNDA_DOSE = "Usuário habilitado para segunda dose.";
    public static final String ERRO_USUARIO_NAO_ENCONTRADO = "Usuário não encontrado.";

    public static List<String> mapStringParaLista(String stringQualquer) {
        List<String> listaString = new ArrayList<String>();
        for (String string : stringQualquer.replaceAll(" ", "").split(",")) {
            listaString.add(string);
        }
        return listaString;
    }

    public static int calcularIdade(Date data) {
        Calendar cData = Calendar.getInstance();
        Calendar cHoje = Calendar.getInstance();
        cData.setTime(data);
        cData.set(Calendar.YEAR, cHoje.get(Calendar.YEAR));
        int idade = cData.after(cHoje) ? -1 : 0;
        cData.setTime(data);
        idade += cHoje.get(Calendar.YEAR) - cData.get(Calendar.YEAR);
        return idade;
    }

    public static Date mapStringParaDate(String data) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = sdf.parse(data);
        return date;
    }

    public static long calcularQuantidadeDeDiasEntreDatas(String dataInicio, String dataFim) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        long dias = 0;
        try {
            Date data1 = sdf.parse(dataInicio);
            Date data2 = sdf.parse(dataFim);

            long diferenca = data2.getTime() - data1.getTime();
            dias = TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
            return dias;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dias;
    }

    public static boolean anularEntradaVazia(String entrada) {
        return entrada.replaceAll(" ", "").equals("");
    }
}
