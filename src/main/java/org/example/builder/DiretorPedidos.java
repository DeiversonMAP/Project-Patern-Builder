package org.example.builder;

public class DiretorPedidos {

    private static final int ALTURA_CHAVEIRO_MM = 40;
    private static final int PRAZO_CHAVEIRO_DIAS = 3;
    private static final int ALTURA_BUSTO_MM = 150;
    private static final int PRAZO_BUSTO_DIAS = 10;

    public PedidoImpressao chaveiroPadrao(String cliente) {
        return new PedidoBuilder()
                .cliente(cliente)
                .modelo("Chaveiro")
                .alturaMm(ALTURA_CHAVEIRO_MM)
                .prazoDias(PRAZO_CHAVEIRO_DIAS)
                .build();
    }

    public PedidoImpressao bustoPremium(String cliente, String santo) {
        return new PedidoBuilder()
                .cliente(cliente)
                .modelo("Busto de " + santo)
                .material("PETG")
                .alturaMm(ALTURA_BUSTO_MM)
                .acabamento(Acabamento.PINTADO)
                .prazoDias(PRAZO_BUSTO_DIAS)
                .build();
    }
}
