package com.notificator.notificator.model;

import java.io.Serializable;
import java.util.Date;

public class Notificacao implements Serializable {


    private String nomeNotificacao;
    private String mensagemNoticacao;
    private Date data;
    private String localEvento;
    private String listaContatos;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Notificacao that = (Notificacao) o;

        if (nomeNotificacao != null ? !nomeNotificacao.equals(that.nomeNotificacao) : that.nomeNotificacao != null)
            return false;
        if (mensagemNoticacao != null ? !mensagemNoticacao.equals(that.mensagemNoticacao) : that.mensagemNoticacao != null)
            return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (localEvento != null ? !localEvento.equals(that.localEvento) : that.localEvento != null)
            return false;
        return listaContatos != null ? listaContatos.equals(that.listaContatos) : that.listaContatos == null;
    }

    @Override
    public int hashCode() {
        int result = nomeNotificacao != null ? nomeNotificacao.hashCode() : 0;
        result = 31 * result + (mensagemNoticacao != null ? mensagemNoticacao.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (localEvento != null ? localEvento.hashCode() : 0);
        result = 31 * result + (listaContatos != null ? listaContatos.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Notificacao{" +
                "nomeNotificacao='" + nomeNotificacao + '\'' +
                ", mensagemNoticacao='" + mensagemNoticacao + '\'' +
                ", data=" + data +
                ", localEvento='" + localEvento + '\'' +
                ", listaContatos='" + listaContatos + '\'' +
                '}';
    }
}

