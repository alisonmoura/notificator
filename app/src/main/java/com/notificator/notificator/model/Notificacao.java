package com.notificator.notificator.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by luizc on 02/12/2017.
 */

public class Notificacao implements Serializable {

    private String nomedaNotificacao;
    private String mensagemNoticacao;
    private Date data;
    private String localEvento;
    private String listaContatos;
    private String nomeNotificacao;

    public String getNomedaNotificacao() {
        return nomedaNotificacao;
    }

    public void setNomedaNotificacao(String nomedaNotificacao) {
        this.nomedaNotificacao = nomedaNotificacao;
    }

    public String getMensagemNoticacao() {
        return mensagemNoticacao;
    }

    public void setMensagemNoticacao(String mensagemNoticacao) {
        this.mensagemNoticacao = mensagemNoticacao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getLocalEvento() {
        return localEvento;
    }

    public void setLocalEvento(String localEvento) {
        this.localEvento = localEvento;
    }

    public String getListaContatos() {
        return listaContatos;
    }

    public void setListaContatos(String listaContatos) {
        this.listaContatos = listaContatos;
    }

    public String getNomeNotificacao() {
        return nomeNotificacao;
    }

    public void setNomeNotificacao(String nomeNotificacao) {
        this.nomeNotificacao = nomeNotificacao;
    }

    @Override
    public String toString() {
        return "Notificacao{" +
                "nomedaNotificacao='" + nomedaNotificacao + '\'' +
                ", mensagemNoticacao='" + mensagemNoticacao + '\'' +
                ", data=" + data +
                ", localEvento='" + localEvento + '\'' +
                ", listaContatos='" + listaContatos + '\'' +
                ", nomeNotificacao='" + nomeNotificacao + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Notificacao that = (Notificacao) o;

        if (nomedaNotificacao != null ? !nomedaNotificacao.equals(that.nomedaNotificacao) : that.nomedaNotificacao != null)
            return false;
        if (mensagemNoticacao != null ? !mensagemNoticacao.equals(that.mensagemNoticacao) : that.mensagemNoticacao != null)
            return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (localEvento != null ? !localEvento.equals(that.localEvento) : that.localEvento != null)
            return false;
        if (listaContatos != null ? !listaContatos.equals(that.listaContatos) : that.listaContatos != null)
            return false;
        return nomeNotificacao != null ? nomeNotificacao.equals(that.nomeNotificacao) : that.nomeNotificacao == null;

    }

    @Override
    public int hashCode() {
        int result = nomedaNotificacao != null ? nomedaNotificacao.hashCode() : 0;
        result = 31 * result + (mensagemNoticacao != null ? mensagemNoticacao.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (localEvento != null ? localEvento.hashCode() : 0);
        result = 31 * result + (listaContatos != null ? listaContatos.hashCode() : 0);
        result = 31 * result + (nomeNotificacao != null ? nomeNotificacao.hashCode() : 0);
        return result;
    }
}

