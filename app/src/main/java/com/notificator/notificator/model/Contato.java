package com.notificator.notificator.model;

import java.io.Serializable;
import java.util.Date;

public class Contato implements Serializable{

    private String nome;
    private String celular;
    private String foto;
    private String email;
    private Date aniversario;
    private String endereco;
    private String categoria;
    private String mensagemAniversario;
    private Boolean notificarAniversario;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getAniversario() {
        return aniversario;
    }

    public void setAniversario(Date aniversario) {
        this.aniversario = aniversario;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMensagemAniversario() {
        return mensagemAniversario;
    }

    public void setMensagemAniversario(String mensagemAniversario) {
        this.mensagemAniversario = mensagemAniversario;
    }

    public Boolean getNotificarAniversario() {
        return notificarAniversario;
    }

    public void setNotificarAniversario(Boolean notificarAniversario) {
        this.notificarAniversario = notificarAniversario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contato contato = (Contato) o;

        if (nome != null ? !nome.equals(contato.nome) : contato.nome != null) return false;
        if (celular != null ? !celular.equals(contato.celular) : contato.celular != null)
            return false;
        if (foto != null ? !foto.equals(contato.foto) : contato.foto != null) return false;
        if (email != null ? !email.equals(contato.email) : contato.email != null) return false;
        if (aniversario != null ? !aniversario.equals(contato.aniversario) : contato.aniversario != null)
            return false;
        if (endereco != null ? !endereco.equals(contato.endereco) : contato.endereco != null)
            return false;
        if (categoria != null ? !categoria.equals(contato.categoria) : contato.categoria != null)
            return false;
        if (mensagemAniversario != null ? !mensagemAniversario.equals(contato.mensagemAniversario) : contato.mensagemAniversario != null)
            return false;
        return notificarAniversario != null ? notificarAniversario.equals(contato.notificarAniversario) : contato.notificarAniversario == null;
    }

    @Override
    public int hashCode() {
        int result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + (celular != null ? celular.hashCode() : 0);
        result = 31 * result + (foto != null ? foto.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (aniversario != null ? aniversario.hashCode() : 0);
        result = 31 * result + (endereco != null ? endereco.hashCode() : 0);
        result = 31 * result + (categoria != null ? categoria.hashCode() : 0);
        result = 31 * result + (mensagemAniversario != null ? mensagemAniversario.hashCode() : 0);
        result = 31 * result + (notificarAniversario != null ? notificarAniversario.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "nome='" + nome + '\'' +
                ", celular='" + celular + '\'' +
                ", foto='" + foto + '\'' +
                ", email='" + email + '\'' +
                ", aniversario=" + aniversario +
                ", endereco='" + endereco + '\'' +
                ", categoria='" + categoria + '\'' +
                ", mensagemAniversario='" + mensagemAniversario + '\'' +
                ", notificarAniversario=" + notificarAniversario +
                '}';
    }
}
