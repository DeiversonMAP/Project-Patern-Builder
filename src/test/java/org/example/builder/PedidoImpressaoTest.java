package org.example.builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoImpressaoTest {

    @Test
    void deveGuardarTodosOsCamposDoBuilder() {
        PedidoImpressao pedido = new PedidoBuilder()
                .cliente("Maria")
                .modelo("Busto")
                .material("PETG")
                .cor("Preto")
                .alturaMm(120)
                .acabamento(Acabamento.LIXADO)
                .prazoDias(5)
                .build();

        assertEquals("Maria", pedido.getCliente());
        assertEquals("Busto", pedido.getModelo());
        assertEquals("PETG", pedido.getMaterial());
        assertEquals("Preto", pedido.getCor());
        assertEquals(120, pedido.getAlturaMm());
        assertEquals(Acabamento.LIXADO, pedido.getAcabamento());
        assertEquals(5, pedido.getPrazoDias());
    }

    @Test
    void deveGerarResumoDoPedido() {
        PedidoImpressao pedido = new PedidoBuilder()
                .cliente("Maria")
                .modelo("Busto")
                .alturaMm(120)
                .build();

        assertEquals("Busto | PLA | Branco | 120 mm | NENHUM | 7 dias | cliente Maria", pedido.resumo());
    }
}
