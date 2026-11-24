package org.example.builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiretorPedidosTest {

    private final DiretorPedidos diretor = new DiretorPedidos();

    @Test
    void deveMontarChaveiroPadrao() {
        PedidoImpressao pedido = diretor.chaveiroPadrao("Joao");

        assertEquals("Chaveiro | PLA | Branco | 40 mm | NENHUM | 3 dias | cliente Joao", pedido.resumo());
    }

    @Test
    void deveMontarBustoPremium() {
        PedidoImpressao pedido = diretor.bustoPremium("Maria", "Sao Jose");

        assertEquals("Busto de Sao Jose", pedido.getModelo());
        assertEquals("PETG", pedido.getMaterial());
        assertEquals(150, pedido.getAlturaMm());
        assertEquals(Acabamento.PINTADO, pedido.getAcabamento());
        assertEquals(10, pedido.getPrazoDias());
    }

    @Test
    void deveExigirClienteMesmoNasReceitas() {
        assertThrows(IllegalStateException.class, () -> diretor.chaveiroPadrao(null));
    }
}
