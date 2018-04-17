package br.com.bossini.threadsjsonads3anmca;

/**
 * Created by rodrigo on 09/04/18.
 */

public class Previsao {


    public Previsao (){

    }

    public Previsao (double min, double max, String descricao){
        setMin(min);
        setMax(max);
        setDescricao(descricao);
    }

    private long id;
    private double min, max;
    private String descricao;

    public Previsao(long id, double min, double max, String descricao) {
        this (min, max, descricao);
        setId(id);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
