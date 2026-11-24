package org.example.builder;

public class PedidoImpressao {

    private final String cliente;
    private final String modelo;
    private final String material;
    private final String cor;
    private final int alturaMm;
    private final Acabamento acabamento;
    private final int prazoDias;

    PedidoImpressao(PedidoBuilder builder) {
        this.cliente = builder.getCliente();
        this.modelo = builder.getModelo();
        this.material = builder.getMaterial();
        this.cor = builder.getCor();
        this.alturaMm = builder.getAlturaMm();
        this.acabamento = builder.getAcabamento();
        this.prazoDias = builder.getPrazoDias();
    }

    public String getCliente() {
        return cliente;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMaterial() {
        return material;
    }

    public String getCor() {
        return cor;
    }

    public int getAlturaMm() {
        return alturaMm;
    }

    public Acabamento getAcabamento() {
        return acabamento;
    }

    public int getPrazoDias() {
        return prazoDias;
    }

    public String resumo() {
        return modelo + " | " + material + " | " + cor + " | " + alturaMm + " mm | "
                + acabamento + " | " + prazoDias + " dias | cliente " + cliente;
    }
}
