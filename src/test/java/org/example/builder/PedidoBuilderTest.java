package org.example.builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoBuilderTest {

    private PedidoBuilder basico() {
        return new PedidoBuilder().cliente("Maria").modelo("Chaveiro").alturaMm(40);
    }

    @Test
    void deveUsarValoresPadraoQuandoNaoInformados() {
        PedidoImpressao pedido = basico().build();

        assertEquals("PLA", pedido.getMaterial());
        assertEquals("Branco", pedido.getCor());
        assertEquals(Acabamento.NENHUM, pedido.getAcabamento());
        assertEquals(7, pedido.getPrazoDias());
    }

    @Test
    void deveSobrescreverValoresPadrao() {
        PedidoImpressao pedido = basico().material("PETG").cor("Azul").prazoDias(2).build();

        assertEquals("PETG", pedido.getMaterial());
        assertEquals("Azul", pedido.getCor());
        assertEquals(2, pedido.getPrazoDias());
    }

    @Test
    void deveExigirCliente() {
        IllegalStateException excecao = assertThrows(
                IllegalStateException.class,
                () -> new PedidoBuilder().modelo("Chaveiro").alturaMm(40).build()
        );
        assertEquals("Cliente obrigatorio", excecao.getMessage());
    }

    @Test
    void deveExigirClienteNaoVazio() {
        assertThrows(IllegalStateException.class, () -> basico().cliente("   ").build());
    }

    @Test
    void deveExigirModelo() {
        IllegalStateException excecao = assertThrows(
                IllegalStateException.class,
                () -> new PedidoBuilder().cliente("Maria").alturaMm(40).build()
        );
        assertEquals("Modelo obrigatorio", excecao.getMessage());
    }

    @Test
    void deveExigirAltura() {
        IllegalStateException excecao = assertThrows(
                IllegalStateException.class,
                () -> new PedidoBuilder().cliente("Maria").modelo("Chaveiro").build()
        );
        assertEquals("Altura obrigatoria", excecao.getMessage());
    }

    @Test
    void deveRecusarAlturaNegativaOuZero() {
        assertThrows(IllegalArgumentException.class, () -> new PedidoBuilder().alturaMm(0));
        assertThrows(IllegalArgumentException.class, () -> new PedidoBuilder().alturaMm(-10));
    }

    @Test
    void deveRecusarPrazoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new PedidoBuilder().prazoDias(0));
    }

    @Test
    void mesmoBuilderPodeGerarPedidosIndependentes() {
        PedidoBuilder builder = basico();
        PedidoImpressao primeiro = builder.build();
        PedidoImpressao segundo = builder.cor("Verde").build();

        assertNotSame(primeiro, segundo);
        assertEquals("Branco", primeiro.getCor());
        assertEquals("Verde", segundo.getCor());
    }
}
