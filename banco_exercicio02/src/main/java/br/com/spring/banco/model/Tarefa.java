package br.com.spring.banco.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tarefa implements Serializable {
    private static final long serialVersionUID = 1L;
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tarefa")
    private Long idTarefa;
    private String titulo;
    private String descricao;
    
    @Column(name = "data_criacao")
    private Date dataCriacao;
    
    @Column(name = "data_vencimento")
    private Date dataVencimento;
    private Prioridade prioridade;
    private Estado estado;

    public Tarefa() {
    }

    public Tarefa(Long idTarefa, String titulo, String descricao, Date dataCriacao, Date dataVencimento, Prioridade prioridade, Estado estado) {
        this.idTarefa = idTarefa;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.dataVencimento = dataVencimento;
        this.prioridade = prioridade;
        this.estado = estado;
    }

    // Getters and Setters
    public Long getIdTarefa() {
        return idTarefa;
    }

    public void setIdTarefa(Long idTarefa) {
        this.idTarefa = idTarefa;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    // Equals and HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tarefa tarefa = (Tarefa) o;
        return Objects.equals(idTarefa, tarefa.idTarefa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTarefa);
    }

    // ToString
    @Override
    public String toString() {
        return "Tarefa{" +
                "idTarefa=" + idTarefa +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", dataVencimento=" + dataVencimento +
                ", prioridade=" + prioridade +
                ", estado=" + estado +
                '}';
    }

    public enum Prioridade {
        ALTA, MEDIA, BAIXA
    }

    public enum Estado {
        A_FAZER, EM_ANDAMENTO, CONCLUIDA
    }
}
