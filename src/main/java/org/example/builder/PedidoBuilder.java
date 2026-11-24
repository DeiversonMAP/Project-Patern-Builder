package org.example.builder;

public class PedidoBuilder {

    private static final String MATERIAL_PADRAO = "PLA";
    private static final String COR_PADRAO = "Branco";
    private static final int PRAZO_PADRAO_DIAS = 7;

    private String cliente;
    private String modelo;
    private String material = MATERIAL_PADRAO;
    private String cor = COR_PADRAO;
    private int alturaMm;
    private Acabamento acabamento = Acabamento.NENHUM;
    private int prazoDias = PRAZO_PADRAO_DIAS;

    public PedidoBuilder cliente(String cliente) {
        this.cliente = cliente;
        return this;
    }

    public PedidoBuilder modelo(String modelo) {
        this.modelo = modelo;
        return this;
    }

    public PedidoBuilder material(String material) {
        this.material = material;
        return this;
    }

    public PedidoBuilder cor(String cor) {
        this.cor = cor;
        return this;
    }

    public PedidoBuilder alturaMm(int alturaMm) {
        if (alturaMm <= 0) {
            throw new IllegalArgumentException("Altura deve ser positiva");
        }
        this.alturaMm = alturaMm;
        return this;
    }

    public PedidoBuilder acabamento(Acabamento acabamento) {
        this.acabamento = acabamento;
        return this;
    }

    public PedidoBuilder prazoDias(int prazoDias) {
        if (prazoDias <= 0) {
            throw new IllegalArgumentException("Prazo deve ser positivo");
        }
        this.prazoDias = prazoDias;
        return this;
    }

    public PedidoImpressao build() {
        if (cliente == null || cliente.isBlank()) {
            throw new IllegalStateException("Cliente obrigatorio");
        }
        if (modelo == null || modelo.isBlank()) {
            throw new IllegalStateException("Modelo obrigatorio");
        }
        if (alturaMm == 0) {
            throw new IllegalStateException("Altura obrigatoria");
        }
        return new PedidoImpressao(this);
    }

    String getCliente() {
        return cliente;
    }

    String getModelo() {
        return modelo;
    }

    String getMaterial() {
        return material;
    }

    String getCor() {
        return cor;
    }

    int getAlturaMm() {
        return alturaMm;
    }

    Acabamento getAcabamento() {
        return acabamento;
    }

    int getPrazoDias() {
        return prazoDias;
    }
}
